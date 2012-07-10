package org.sdu.android.sprite;

import org.sdu.android.sprite.change.Change;

import android.graphics.Paint;

/**
 * 定义精灵是否可以发生颜色、透明度等变化
 * */
public interface Changeable {
	/**
	 * 添加指定变化事件
	 * 
	 * @param change
	 *            指定的变化
	 * */
	void addChanges(Change change);

	/**
	 * 移除指定的变化事件
	 * 
	 * @param change
	 *            指定的变化
	 * */
	void removeChanges(Change change);

	/**
	 * 移除全部的变化事件
	 * */
	void removeAllChanges();

	/**
	 * 响应变化事件
	 * 
	 * @param paint
	 *            进行处理的paint
	 * */
	void change(Paint paint);
}
