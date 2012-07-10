package org.sdu.android.map.painter.scene;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.sdu.android.SystemData;
import org.sdu.android.map.action.CollisionEvent;
import org.sdu.android.map.action.CollisionEventListener;
import org.sdu.android.map.action.CollisionGroup;
import org.sdu.android.map.action.MapEvent;
import org.sdu.android.map.action.MapEventListener;
import org.sdu.android.map.action.StaCollidable;
import org.sdu.android.map.painter.ground.SimpleMap;
import org.sdu.android.map.painter.level.DynamicLevel;
import org.sdu.android.map.painter.resource.Moveable;
import org.sdu.android.map.search.AutoSearchable;
import org.sdu.android.map.search.Route;
import org.sdu.android.sprite.AbstractSprite;
import org.sdu.android.sprite.Hero;
import org.sdu.android.sprite.change.Move;
import org.sdu.android.sprite.change.StraightMove;
import org.sdu.android.util.graphicsUtil.Rect;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;

/**
 * �����ࡣʵ�ֶ���Դ�Ĺ���Ͷ��¼��Ĵ���
 * 
 * @author Joycery & Sww
 * 
 */
public abstract class Scene implements SceneInterface{
	/*** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** ��ͼ */
	SimpleMap map;
	/** ��̬��Դ�� */
	DynamicLevel dynLevel;

	/** ����ײ��ļ��� */
	Set<CollisionGroup> collisionSet;

	/** ��ײ������ */
	private CollisionEventListener cevl;
	
	/**��ͼ�¼�������*/
	private MapEventListener mel;

	/** �Ե�ͼ���Ͻǵ�Ϊ����ԭ�㣬��Ļ���Ͻǵĵ���������ϵ�ϵ����� */
	int offsetX;
	/***/
	int offsetY;

	/** �������� */
	Hero hero;

	/** �������ߵ��߳� */
	Step step;
	/** Ĭ��Paint*/
	static final Paint DEFAULT_PAINT=new Paint();
	
	public Scene() {
		this.collisionSet = new HashSet<CollisionGroup>();
	}

	/**
	 * ���õ�ͼ�¼�������
	 * @param mel ��ͼ�¼�������
	 */
	
	public void setMel(MapEventListener mel) {
		this.mel = mel;
	}

	/**
	 * ��ʼ������ ��Ҫ��� ����map ���ö�̬�� ������ײ��϶� ʵ����sceneInterface
	 */
	public abstract void initialize();

	/**
	 * ���õ�ͼ
	 * 
	 * @param map
	 *            ��ͼ
	 */
	public void setMap(SimpleMap map) {
		this.map = map;
	}

	/**
	 * ��ȡ��̬��
	 * 
	 * @return dynlevel
	 */
	public DynamicLevel getDynLevel() {
		return dynLevel;
	}

	/**
	 * ��ȡ����
	 * 
	 * @return ����
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * ��������
	 * 
	 * @param hero
	 *            ����
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * ���ö�̬��
	 * 
	 * @param dynLevel
	 *            ��̬
	 */
	public void setDynLevel(DynamicLevel dynLevel) {
		this.dynLevel = dynLevel;
	}

	/**
	 * ��ȡ���x����
	 * 
	 * @return offsetX
	 */
	public int getOffsetX() {
		return offsetX;
	}

	/**
	 * �������x����
	 * 
	 * @param offsetX
	 *            ���
	 */
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	/**
	 * ��ȡ���y����
	 * 
	 * @return offsetY
	 */
	public int getOffsetY() {
		return offsetY;
	}

	/**
	 * �������y����
	 * 
	 * @param offsetY
	 *            ���
	 */
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	/**
	 * ������������
	 * 
	 * @param x
	 *            xֵ
	 * @param y
	 *            yֵ
	 */
	public void setOffset(int x, int y) {
		this.offsetX = x;
		this.offsetY = y;
	}

	/**
	 * ���ƣ�ʵ����sceneInterface
	 * 
	 * @param canvas
	 *            ����
	 */
	public void onDraw(Canvas canvas,Paint paint) {
		if(paint==null){
			paint=DEFAULT_PAINT;
		}
		final Iterator<AbstractSprite> it = dynLevel.getSpriteList().iterator();
		while (it.hasNext()) {
			final AbstractSprite obj = it.next();
			if (obj instanceof Moveable) {
				((Moveable) obj).autoMove();
			}
			if (obj instanceof StaCollidable) {
				((StaCollidable) obj).handleStaCollision();
			}
		}
		checkCollision();
		if (mel!=null){
			MapEvent met=map.checkEvent((Rect)hero.getRect());
			if (met!=null){
				mel.mapEventOccured(met);
			}
		}if (hero!=null){

		offsetX = hero.getX() - SystemData.getActivityWidth() / 2;
		offsetY = hero.getY() - SystemData.getActivityHeight() / 2;
		}

		if (offsetX < 0)
			offsetX = 0;
		if (offsetY < 0)
			offsetY = 0;

		if (offsetX + SystemData.getActivityWidth() > map.getWidth()) {
			offsetX = map.getWidth() - SystemData.getActivityWidth();
		}
		if (offsetY + SystemData.getActivityHeight() > map.getHeight()) {
			offsetY = map.getHeight() - SystemData.getActivityHeight();
		}

		Matrix m = new Matrix();
		m.setTranslate(-offsetX, -offsetY);
		canvas.setMatrix(m);

		// map.setOffsetXY(offsetX, offsetY);
		// dynLevel.setOffsetXY(offsetX, offsetY);

		if(map!=null)
		{
			map.drawDown(canvas,paint);
		}
		if(dynLevel!=null)
		{
			dynLevel.onDraw(canvas,paint);
		}
		if(map!=null)
		{
			map.drawUp(canvas,paint);
		}
		

		canvas.setMatrix(new Matrix());
	}

	/**
	 * ���أ�ʵ����sceneInterface
	 * 
	 * @param context
	 *            context
	 */
	public void load(Resources resource) {
		if(map!=null)
		{
			map.load(resource);
		}
		if(dynLevel!=null)
		{
			dynLevel.load(resource);
		}
		
	}

	/**
	 * �ͷţ�ʵ����sceneInterface
	 */
	public void unLoad() {
		if(map!=null)
		{
			map.unload();
		}
		if(dynLevel!=null)
		{
			dynLevel.unload();
		}
	}

	/***********************************
	 * ��ײ����봦�����ش���
	 *********************************/

	/**
	 * ���Ҫ���ľ�����
	 * 
	 * @param group
	 *            ������
	 */
	public void addCollisionGroup(CollisionGroup group) {
		collisionSet.add(group);
	}

	/**
	 * �Ƴ�Ҫ���ľ�����
	 * 
	 * @param group
	 *            ������
	 */
	public void removeCollisionGroup(CollisionGroup group) {
		collisionSet.remove(group);
	}

	/**
	 * �����ײ�¼�������
	 * 
	 * @param evtLs
	 *            ��ײ�¼�������
	 */
	public void addCollisionEventListener(CollisionEventListener evtLs) {
		cevl = evtLs;
	}

	/**
	 * ɾ����ײ�¼�������
	 */
	public void removeCollisionEventListener() {
		cevl = null;
	}

	/**
	 * ������ײ�¼�
	 * 
	 * @param event
	 *            ��ײ�¼�
	 */
	public void handleCollisionEvent(CollisionEvent event) {
		if (cevl != null) {
			cevl.collisionOccured(event);
		}
	}

	/**
	 * �ж����������Ƿ�����ײ������
	 * 
	 * @param group
	 *            ������
	 * @return re �Ƿ�����ײ
	 */
	public boolean collision(CollisionGroup group) {
		final boolean re = group.getSp1().getRect()
				.isCollide(group.getSp2().getRect());
		// Log.i("rrrrrrrrr",""+group.getSp1().getRect()+group.getSp2().getRect());
		if (re) {
			final CollisionEvent event = new CollisionEvent(this, group);
			handleCollisionEvent(event);
		}
		return re;
	}

	/**
	 * ��Ҫ���ľ����鼯�Ͻ��м��
	 */
	public void checkCollision() {
		final Iterator<CollisionGroup> it = collisionSet.iterator();
		while (it.hasNext()) {
			collision(it.next());
		}
	}

	/***************************************
	 * ���ڴ����¼��Զ����ߵ���ش���
	 ***************************************/

	/**
	 * �����¼�����
	 * 
	 * @param event
	 *            �����¼�
	 */
	public void onTouchEvent(MotionEvent event) {
		Log.i("touch", "touch!!!!!!!!!!");
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (map instanceof AutoSearchable) {
				final int x = (int) event.getX();
				final int y = (int) event.getY();

				final Point des = map.mapToArray(new Point(x, y));
				final Point start = map.mapToArray(new Point(hero.getX(), hero
						.getY()));
				final Route route = ((AutoSearchable) map)
						.findRoute(start, des);
				if (route != null) {
					createStep(route);
				}
			}
		}
	}

	/**
	 * ����·������
	 * 
	 * @param route
	 *            ·��
	 */
	public void createStep(Route route) {
		interuptStep();
		step = new Step(route);
		step.start();
	}

	/**
	 * �����ж�
	 */
	public void interuptStep() {
		if (step != null) {
			step.interrupt();
		}
	}

	/**
	 * ����·������
	 * 
	 * @author Joycery & Sww
	 * 
	 */
	private class Step extends Thread {
		/** ·�� */
		Route route;

		/**
		 * ����
		 * 
		 * @param route
		 *            ·��
		 */
		public Step(Route route) {
			this.route = route;
		}

		/**
		 * ��·
		 */
		public void run() {
			List<Point> list=route.getRoute();
			while (!list.isEmpty()) {
				final Point point = list.remove(list.size()-1);
				hero.addMoves(new StraightMove(point.x, point.y, Move.MOVE_TO));
				try {
					Thread.sleep(SystemData.ONESECOND);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
