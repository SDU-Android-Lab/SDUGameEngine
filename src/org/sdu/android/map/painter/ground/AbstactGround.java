package org.sdu.android.map.painter.ground;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * 地图基类
 * @author Joycery & Sww
 *
 */
public abstract class AbstactGround implements Map {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 宽度
	 */
	private int width;
	/**
	 * 高度
	 */
	private int height;
	/**
	 * 设置宽度和高度
	 * @param width 宽度
	 * @param height 高度
	 */
	public void setWidthHeight(int width, int height){
		this.width=width;
		this.height=height;
	}
	
	/**
	 * 获取宽度
	 * @return width 宽度
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * 获取高度
	 * @return height 高度
	 */
	public int getHeight(){
		return height;
	}
	/**
	 * 设置宽度
	 * @param width 宽度
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * 设置高度
	 * @param height 高度
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * 判断某点是否能走
	 * @param x 某点的横坐标
	 * @param y 某点的纵坐标
	 * @return 是否能走
	 */
	public abstract boolean allowed(int x, int y);
	
	/**
	 * 绘制动态下层
	 * @param canvas 画布,paint 画笔
	 */
	public abstract void drawDown(Canvas canvas,Paint paint);
	
	/**
	 * 绘制动态上层
	 * @param canvas 画布,paint 画笔
	 */
	public abstract void drawUp(Canvas canvas,Paint paint);
	
	/**
	 * 加载资源
	 * @param resource 资源
	 */
	public abstract void load(Resources resource);
	
	/**
	 * 释放资源
	 */
	public abstract void unload();
}
