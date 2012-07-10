package org.sdu.android.map.painter.ground;

import java.io.Serializable;

import org.sdu.android.map.action.MapEvent;
import org.sdu.android.util.graphicsUtil.Rect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 地图接口
 * @author Joycery & Sww
 * 
 */
public interface Map extends Serializable{
	/**
	 * 可以走
	 */
	int ALLOWED=0;
	/**
	 * 不可以走
	 */
	int NO=1;
	/**
	 * 设置宽度和高度
	 * @param width 宽度
	 * @param height 高度
	 */
	void setWidthHeight(int width, int height);
	
	/**
	 * 得到宽度
	 * @return 宽度
	 */
	int getWidth();
	
	/**
	 * 得到高度
	 * @return 高度
	 */
	int getHeight();
	
	/**
	 * 判断某点是否能走
	 * @param x 某点的横坐标
	 * @param y 某点的纵坐标
	 * @return 是否能走
	 */
	boolean allowed(int x, int y);
	/**
	 * 绘制动态下层
	 * @param canvas 画布,paint 画笔
	 */
	void drawDown(Canvas canvas,Paint paint);
	
	/**
	 * 绘制动态上层
	 * @param canvas 画布，paint 画笔
	 */
	void drawUp(Canvas canvas,Paint paint);
	
	/**
	 * 加载资源
	 * @param Resources resource
	 */
	void load(Resources resource);
	
	/**
	 * 释放资源
	 */
	void unload();
	
    /**
     * 检测是否碰撞
     * @param rect 矩形
     * @return 是否碰撞
     */
	boolean isCollision(Rect rect);
	
	/**
	 * 设置偏移量
	 * @param x 横坐标
	 * @param y 纵坐标
	 */
	void setOffsetXY(int x,int y);
	
	/**
	 * 得到某个区域发生的地图事件
	 * @param rect 矩形
	 * @return 如果有事件返回该事件，如果没有返回null
	 */
	MapEvent checkEvent(Rect rect);
}
