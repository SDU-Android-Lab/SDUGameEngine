package org.sdu.android.sprite.change;

import android.graphics.Paint;

/**
 * 
 * 控制颜色发生变化的事件
 * 
 * 
 * */
public class ColorChange extends Change {
	/**
	 * 对应红色通道
	 * 
	 * */
	int r;
	/**
	 * 
	 * 对应绿色通道
	 * */
	int g;
	/**
	 * 
	 * 对应蓝色通道
	 * */
	int b;

	/**
	 * 构造方法
	 * 
	 * @param r
	 *            红色通道
	 * @param g
	 *            绿色通道
	 * @param b
	 *            蓝色通道
	 * */
	public ColorChange(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	/**
	 * 进行变化处理，对paint进行颜色处理
	 * 
	 * @param paint
	 *            要处理的paint
	 * */
	public void startChange(Paint paint) {
		paint.setARGB(paint.getAlpha(), r, g, b);
	}

}
