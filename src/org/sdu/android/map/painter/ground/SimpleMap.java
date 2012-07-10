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
 * 简单地图类,只有一个数组
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
	 * 是否可以走数组
	 */
	int[][] array;

	/** 瓦片宽度 */
	int tileWidth;

	/** 瓦片高度 */
	int tileHeight;

	/** 静态上层 */
	StaticLevel upLevel;

	/** 静态下层 */
	StaticLevel downLevel;

	/** 偏移量x */
	int offsetX;
	/** 偏移量y */
	int offsetY;

	/**
	 * 地图事件坐标集合
	 */
	private final Set<Point> mapEventPointSet=new HashSet<Point>();
	
	/**
	 * 增加地图事件坐标
	 * @param mapEventPoint 事件坐标
	 */
	public void add(Point mapEventPoint){
		mapEventPointSet.add(mapEventPoint);
	}
	
	/**
	 * 构造简单地图
	 * 
	 * @param array
	 *            是否可以走数组
	 * @param tileWidth
	 *            瓦片宽度
	 * @param tileHeight
	 *            瓦片高度
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
	 * 绘制
	 ************************/

	/**
	 * 画动态下层
	 * 
	 * @param canvas
	 *            画布,paint 画笔
	 */
	public void drawDown(Canvas canvas, Paint paint) {
		if (downLevel != null) {
			downLevel.setOffsetXY(offsetX, offsetY);
			downLevel.onDraw(canvas, paint);
		}
	}

	/**
	 * 画动态上层
	 * 
	 * @param canvas
	 *            画布,paint 画笔
	 */
	public void drawUp(Canvas canvas, Paint paint) {
		if (upLevel != null) {
			upLevel.setOffsetXY(offsetX, offsetY);
			upLevel.onDraw(canvas, paint);
		}
	}

	/**
	 * 加载资源
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
	 * 释放资源
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
	 * 得到瓦片宽度
	 * 
	 * @return 瓦片宽度
	 */
	public int getTileWidth() {
		return tileWidth;
	}

	/***********************
	 * get 与 set 方法
	 **********************/

	/**
	 * 设置瓦片宽度
	 * 
	 * @param tileWidth
	 *            瓦片宽度
	 */
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	/**
	 * 得到瓦片高度
	 * 
	 * @return 瓦片高度
	 */
	public int getTileHeight() {
		return tileHeight;
	}

	/**
	 * 设置瓦片高度
	 * 
	 * @param tileHeight
	 *            瓦片高度
	 */
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	/**
	 * 得到静态上层
	 * 
	 * @return 静态上层
	 */

	public StaticLevel getUpLevel() {
		return upLevel;
	}

	/**
	 * 设置静态上层
	 * 
	 * @param upLevel
	 *            静态上层
	 */
	public void setUpLevel(StaticLevel upLevel) {
		this.upLevel = upLevel;
	}

	/**
	 * 得到静态下层
	 * 
	 * @return 静态下层
	 */
	public StaticLevel getDownLevel() {
		return downLevel;
	}

	/**
	 * 设置静态下层
	 * 
	 * @param downLevel
	 *            静态下层
	 */
	public void setDownLevel(StaticLevel downLevel) {
		this.downLevel = downLevel;
	}

	/**
	 * 返回是否可以走数组
	 * 
	 * @return array
	 */
	public int[][] getArray() {
		return array;
	}

	/**
	 * 设置数组
	 * 
	 * @param array
	 *            数组
	 */
	public void setArray(int[][] array) {
		this.array = array;

	}

	/**
	 * 设置某处是否能走
	 * 
	 * @param x
	 *            数组一维下标
	 * @param y
	 *            数组二维下标
	 * @param moveable
	 *            是否能走
	 */
	public void setArray(int x, int y, boolean moveable) {
		if (moveable) {
			array[x][y] = ALLOWED;
		} else {
			array[x][y] = NO;
		}
	}

	/**************************
	 * 对map中碰撞的检测方法
	 *************************/

	/**
	 * 数组中某点是否可走
	 * 
	 * @param x
	 *            数组一维下标
	 * @param y
	 *            数组二维下标
	 * @return 是否可走
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
	 * 判断某点是否能走
	 * 
	 * @param x
	 *            某点的横坐标
	 * @param y
	 *            某点的纵坐标
	 * @return 是否能走
	 */
	public boolean allowed(int x, int y) {
		final int dx = x / tileWidth;
		final int dy = y / tileHeight;
		return getArrayAllowed(dx, dy);
	}

	/**
	 * 判断某个精灵（以块的标准）是否与静态资源碰撞
	 * 
	 * @param rect
	 *            精灵对应矩形块
	 * @return 是否碰撞
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
	 * 将地图的一个“点”转换成数组的一个数字的索引
	 * 
	 * @param map
	 *            地图上的一个点
	 * @return 数组中的一个点
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
