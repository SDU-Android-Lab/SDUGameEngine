package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * 
 * 精灵的直线移动事件
 * 
 * */
public class StraightMove extends Move {
	/**
	 * 构造方法
	 * @param x
	 *            在x轴上的操作值
	 * @param y
	 *            在y轴上的操作值
	 * @param type
	 *            移动的类型,具体是MOVE或MOVE_TO
	 * */
	public StraightMove(int x, int y, int type) {
		super(x, y, type);
		this.setAlive(true);
	}

	/**
	 * 对MOVE作响应,具体为精灵x方向增加x，y方向增加y。
	 * 
	 * @param sprite
	 *            要移动的精灵
	 * */
	public void startMove(AbstractSprite sprite) {
		sprite.setX(x + sprite.getX());
		sprite.setY(y + sprite.getY());
	}

	/**
	 * 对MOVE_TO作响应,具体为精灵x方向变为x，y方向变为y。
	 * 
	 * @param sprite
	 *            要移动的精灵
	 * */
	public void startMoveTo(AbstractSprite sprite) {
		sprite.setX(x);
		sprite.setY(y);
	}

	/**
	 * 若type为MOVE，则调用startMove，为MOVE_TO调用startMoveTo
	 * 
	 * @param sprite
	 *            要处理的精灵
	 * */
	public void begin(AbstractSprite sprite) {
		if (type == MOVE) {
			startMove(sprite);
		}
		if (type == MOVE_TO) {
			startMoveTo(sprite);
		}
		this.setAlive(false);
	}

}
