package org.sdu.android.map.painter.ground;

import java.util.HashSet;
import java.util.Set;

import org.sdu.android.map.action.MapEvent;
import org.sdu.android.map.painter.level.StaticLevel;
import org.sdu.android.util.graphicsUtil.Rect;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * �򵥵�ͼ��,ֻ��һ������
 * 
 * @author Joycery & Sww
 * 
 */
public class SimpleMap extends AbstactGround {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * �Ƿ����������
	 */
	int[][] array;

	/** ��Ƭ��� */
	int tileWidth;

	/** ��Ƭ�߶� */
	int tileHeight;

	/** ��̬�ϲ� */
	StaticLevel upLevel;

	/** ��̬�²� */
	StaticLevel downLevel;

	/** ƫ����x */
	int offsetX;
	/** ƫ����y */
	int offsetY;

	/**
	 * ��ͼ�¼����꼯��
	 */
	private final Set<Point> mapEventPointSet=new HashSet<Point>();
	
	/**
	 * ���ӵ�ͼ�¼�����
	 * @param mapEventPoint �¼�����
	 */
	public void add(Point mapEventPoint){
		mapEventPointSet.add(mapEventPoint);
	}
	
	/**
	 * ����򵥵�ͼ
	 * 
	 * @param array
	 *            �Ƿ����������
	 * @param tileWidth
	 *            ��Ƭ���
	 * @param tileHeight
	 *            ��Ƭ�߶�
	 */
	public SimpleMap(int[][] array, int tileWidth, int tileHeight) {
		this.array = array;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		final int w = array[0].length;
		final int h = array.length;
		setWidth(tileWidth * w);
		setHeight(tileHeight * h);
	}

	/*************************
	 * ����
	 ************************/

	/**
	 * ����̬�²�
	 * 
	 * @param canvas
	 *            ����,paint ����
	 */
	public void drawDown(Canvas canvas, Paint paint) {
		if (downLevel != null) {
			downLevel.setOffsetXY(offsetX, offsetY);
			downLevel.onDraw(canvas, paint);
		}
	}

	/**
	 * ����̬�ϲ�
	 * 
	 * @param canvas
	 *            ����,paint ����
	 */
	public void drawUp(Canvas canvas, Paint paint) {
		if (upLevel != null) {
			upLevel.setOffsetXY(offsetX, offsetY);
			upLevel.onDraw(canvas, paint);
		}
	}

	/**
	 * ������Դ
	 * 
	 * @param context
	 *            context
	 */
	public void load(Resources resource) {
		if (upLevel != null) {
			upLevel.load(resource);
		}
		if (downLevel != null) {
			downLevel.load(resource);
		}
	}

	/**
	 * �ͷ���Դ
	 */
	public void unload() {
		if (upLevel != null) {
			upLevel.unload();
		}
		if (downLevel != null) {
			downLevel.unload();
		}
	}

	/***
	 * �õ���Ƭ���
	 * 
	 * @return ��Ƭ���
	 */
	public int getTileWidth() {
		return tileWidth;
	}

	/***********************
	 * get �� set ����
	 **********************/

	/**
	 * ������Ƭ���
	 * 
	 * @param tileWidth
	 *            ��Ƭ���
	 */
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	/**
	 * �õ���Ƭ�߶�
	 * 
	 * @return ��Ƭ�߶�
	 */
	public int getTileHeight() {
		return tileHeight;
	}

	/**
	 * ������Ƭ�߶�
	 * 
	 * @param tileHeight
	 *            ��Ƭ�߶�
	 */
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	/**
	 * �õ���̬�ϲ�
	 * 
	 * @return ��̬�ϲ�
	 */

	public StaticLevel getUpLevel() {
		return upLevel;
	}

	/**
	 * ���þ�̬�ϲ�
	 * 
	 * @param upLevel
	 *            ��̬�ϲ�
	 */
	public void setUpLevel(StaticLevel upLevel) {
		this.upLevel = upLevel;
	}

	/**
	 * �õ���̬�²�
	 * 
	 * @return ��̬�²�
	 */
	public StaticLevel getDownLevel() {
		return downLevel;
	}

	/**
	 * ���þ�̬�²�
	 * 
	 * @param downLevel
	 *            ��̬�²�
	 */
	public void setDownLevel(StaticLevel downLevel) {
		this.downLevel = downLevel;
	}

	/**
	 * �����Ƿ����������
	 * 
	 * @return array
	 */
	public int[][] getArray() {
		return array;
	}

	/**
	 * ��������
	 * 
	 * @param array
	 *            ����
	 */
	public void setArray(int[][] array) {
		this.array = array;

	}

	/**
	 * ����ĳ���Ƿ�����
	 * 
	 * @param x
	 *            ����һά�±�
	 * @param y
	 *            �����ά�±�
	 * @param moveable
	 *            �Ƿ�����
	 */
	public void setArray(int x, int y, boolean moveable) {
		if (moveable) {
			array[x][y] = ALLOWED;
		} else {
			array[x][y] = NO;
		}
	}

	/**************************
	 * ��map����ײ�ļ�ⷽ��
	 *************************/

	/**
	 * ������ĳ���Ƿ����
	 * 
	 * @param x
	 *            ����һά�±�
	 * @param y
	 *            �����ά�±�
	 * @return �Ƿ����
	 */
	public boolean getArrayAllowed(int x, int y) {
		if (x >= 0 && y >= 0) {
			if (x < array[0].length && y < array.length
					&& array[y][x] == ALLOWED) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �ж�ĳ���Ƿ�����
	 * 
	 * @param x
	 *            ĳ��ĺ�����
	 * @param y
	 *            ĳ���������
	 * @return �Ƿ�����
	 */
	public boolean allowed(int x, int y) {
		final int dx = x / tileWidth;
		final int dy = y / tileHeight;
		return getArrayAllowed(dx, dy);
	}

	/**
	 * �ж�ĳ�����飨�Կ�ı�׼���Ƿ��뾲̬��Դ��ײ
	 * 
	 * @param rect
	 *            �����Ӧ���ο�
	 * @return �Ƿ���ײ
	 */
	public boolean isCollision(Rect rect) {
		final int sx = (int) (rect.getX() / tileWidth);
		final int sy = (int) (rect.getY() / tileHeight);
		final int ex = (int) ((rect.getX() + rect.getWigth()) / tileWidth);
		final int ey = (int) ((rect.getY() + rect.getHeight()) / tileHeight);
		for (int i = sx; i <= ex; i++) {
			for (int j = sy; j <= ey; j++) {
				if (!getArrayAllowed(i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkOneEvent(Rect rect, int x, int y) {
		final int sx = (int) (rect.getX() / tileWidth);
		final int sy = (int) (rect.getY() / tileHeight);
		final int ex = (int) ((rect.getX() + rect.getWigth()) / tileWidth);
		final int ey = (int) ((rect.getY() + rect.getHeight()) / tileHeight);
		if (sx <= x && ex >= x && sy <= y && ey >= y) {
			return true;
		}
		return false;
	}

	/**
	 * ����ͼ��һ�����㡱ת���������һ�����ֵ�����
	 * 
	 * @param map
	 *            ��ͼ�ϵ�һ����
	 * @return �����е�һ����
	 */
	public Point mapToArray(Point map) {
		return new Point(map.x / tileWidth, map.y / tileHeight);
	}

	@Override
	public void setOffsetXY(int x, int y) {
		this.offsetX = x;
		this.offsetY = y;
	}

	/* (non-Javadoc)
	 * @see org.sdu.android.map.painter.ground.Map#checkEvent(org.sdu.android.util.graphicsUtil.Rect)
	 */
	@Override
	public MapEvent checkEvent(Rect rect) {
		for (Point p:mapEventPointSet){
			if (checkOneEvent(rect, p.x, p.y))
				return new MapEvent(this, p);
		}
		return null;
	}
}
