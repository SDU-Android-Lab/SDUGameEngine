package org.sdu.android.sprite.change;

import android.graphics.Paint;

/**
 * 
 * 定义有关颜色、透明度发生变化的事件
 * */
public abstract class Change {
	/**
	 * 进行变化处理，对paint进行处理
	 * 
	 * @param paint
	 *            要处理的paint
	 * */
	public abstract void startChange(Paint paint);
}
