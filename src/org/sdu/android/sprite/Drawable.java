package org.sdu.android.sprite;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 精灵需要实现的接口，定义了精灵最基础的方法
 * 
 * 
 * */
public interface Drawable {
	/**
	 * 装载资源
	 * 
	 * @param resources
	 *            需要加载的资源
	 */
	void load(Resources resources);

	/**
	 * 绘制图像
	 * 
	 * @param canvas
	 *            将要绘制的画布
	 * @param paint
	 *            绘制用的画笔
	 * */
	void onDraw(Canvas canvas, Paint paint);

	/**
	 * 释放资源
	 * */
	void unload();
}
