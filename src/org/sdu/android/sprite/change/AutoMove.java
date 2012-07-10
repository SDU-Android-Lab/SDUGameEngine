package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * 定义自动移动的移动事件
 * 
 * 
 */
public abstract class AutoMove extends Move {
	/**
	 * 构造方法
	 */
	public AutoMove() {
		super(0, 0, Move.NONE);
	}

	/**
	 * 构造方法
	 * 
	 * @param x
	 *            x方向上的操作值
	 * @param y
	 *            y方向上的操作值
	 */
	public AutoMove(int x, int y) {
		super(x, y, Move.NONE);
	}

	/**
	 * 执行自动移动方法
	 * 
	 * @param sprite
	 *            要操作的精灵
	 */
	public abstract void begin(AbstractSprite sprite);

	/**
	 * @param sprite
	 *            要操作的精灵
	 */
	public void startMove(AbstractSprite sprite) {
	}

	/**
	 * @param sprite
	 *            要操作的精灵
	 */
	public void startMoveTo(AbstractSprite sprite) {
	}

	/**
	 * 自动移动
	 * 
	 * @param sprite
	 *            要操作的精灵
	 */
	public abstract void auto(AbstractSprite sprite);
}
