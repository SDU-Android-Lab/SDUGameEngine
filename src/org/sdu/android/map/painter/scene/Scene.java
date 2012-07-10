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
 * 场景类。实现对资源的管理和对事件的处理。
 * 
 * @author Joycery & Sww
 * 
 */
public abstract class Scene implements SceneInterface{
	/*** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 地图 */
	SimpleMap map;
	/** 动态资源层 */
	DynamicLevel dynLevel;

	/** 可碰撞组的集合 */
	Set<CollisionGroup> collisionSet;

	/** 碰撞监听器 */
	private CollisionEventListener cevl;
	
	/**地图事件监听器*/
	private MapEventListener mel;

	/** 以地图左上角点为坐标原点，屏幕左上角的点在其坐标系上的坐标 */
	int offsetX;
	/***/
	int offsetY;

	/** 场景主角 */
	Hero hero;

	/** 主角行走的线程 */
	Step step;
	/** 默认Paint*/
	static final Paint DEFAULT_PAINT=new Paint();
	
	public Scene() {
		this.collisionSet = new HashSet<CollisionGroup>();
	}

	/**
	 * 设置地图事件监听器
	 * @param mel 地图事件监听器
	 */
	
	public void setMel(MapEventListener mel) {
		this.mel = mel;
	}

	/**
	 * 初始化方法 需要完成 设置map 设置动态层 设置碰撞组合对 实现自sceneInterface
	 */
	public abstract void initialize();

	/**
	 * 设置地图
	 * 
	 * @param map
	 *            地图
	 */
	public void setMap(SimpleMap map) {
		this.map = map;
	}

	/**
	 * 获取动态层
	 * 
	 * @return dynlevel
	 */
	public DynamicLevel getDynLevel() {
		return dynLevel;
	}

	/**
	 * 获取主角
	 * 
	 * @return 主角
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * 设置主角
	 * 
	 * @param hero
	 *            主角
	 */
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * 设置动态层
	 * 
	 * @param dynLevel
	 *            动态
	 */
	public void setDynLevel(DynamicLevel dynLevel) {
		this.dynLevel = dynLevel;
	}

	/**
	 * 获取相对x坐标
	 * 
	 * @return offsetX
	 */
	public int getOffsetX() {
		return offsetX;
	}

	/**
	 * 设置相对x坐标
	 * 
	 * @param offsetX
	 *            相对
	 */
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	/**
	 * 获取相对y坐标
	 * 
	 * @return offsetY
	 */
	public int getOffsetY() {
		return offsetY;
	}

	/**
	 * 设置相对y坐标
	 * 
	 * @param offsetY
	 *            相对
	 */
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	/**
	 * 设置相对坐标点
	 * 
	 * @param x
	 *            x值
	 * @param y
	 *            y值
	 */
	public void setOffset(int x, int y) {
		this.offsetX = x;
		this.offsetY = y;
	}

	/**
	 * 绘制，实现自sceneInterface
	 * 
	 * @param canvas
	 *            画布
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
	 * 加载，实现自sceneInterface
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
	 * 释放，实现自sceneInterface
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
	 * 碰撞检测与处理的相关代码
	 *********************************/

	/**
	 * 添加要检测的精灵组
	 * 
	 * @param group
	 *            精灵组
	 */
	public void addCollisionGroup(CollisionGroup group) {
		collisionSet.add(group);
	}

	/**
	 * 移除要检测的精灵组
	 * 
	 * @param group
	 *            精灵组
	 */
	public void removeCollisionGroup(CollisionGroup group) {
		collisionSet.remove(group);
	}

	/**
	 * 添加碰撞事件监听器
	 * 
	 * @param evtLs
	 *            碰撞事件监听器
	 */
	public void addCollisionEventListener(CollisionEventListener evtLs) {
		cevl = evtLs;
	}

	/**
	 * 删除碰撞事件监听器
	 */
	public void removeCollisionEventListener() {
		cevl = null;
	}

	/**
	 * 处理碰撞事件
	 * 
	 * @param event
	 *            碰撞事件
	 */
	public void handleCollisionEvent(CollisionEvent event) {
		if (cevl != null) {
			cevl.collisionOccured(event);
		}
	}

	/**
	 * 判断两个精灵是否发生碰撞并处理
	 * 
	 * @param group
	 *            精灵组
	 * @return re 是否发生碰撞
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
	 * 对要检测的精灵组集合进行检测
	 */
	public void checkCollision() {
		final Iterator<CollisionGroup> it = collisionSet.iterator();
		while (it.hasNext()) {
			collision(it.next());
		}
	}

	/***************************************
	 * 对于触屏事件自动行走的相关代码
	 ***************************************/

	/**
	 * 触屏事件处理
	 * 
	 * @param event
	 *            触屏事件
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
	 * 根据路径行走
	 * 
	 * @param route
	 *            路径
	 */
	public void createStep(Route route) {
		interuptStep();
		step = new Step(route);
		step.start();
	}

	/**
	 * 行走中断
	 */
	public void interuptStep() {
		if (step != null) {
			step.interrupt();
		}
	}

	/**
	 * 根据路线行走
	 * 
	 * @author Joycery & Sww
	 * 
	 */
	private class Step extends Thread {
		/** 路径 */
		Route route;

		/**
		 * 构造
		 * 
		 * @param route
		 *            路径
		 */
		public Step(Route route) {
			this.route = route;
		}

		/**
		 * 走路
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
