package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * 自动直线移动
 * 
 * 
 */
public class AutoStrMove extends AutoMove {
	/** 要操作的精灵 */
	AbstractSprite sprite;
	/** 事件开始时的x坐标 */
	int oldx;
	/** 事件开始时的y坐标 */
	int oldy;

	/**
	 * 构造方法
	 * 
	 *@param x
	 *            x方向上的操作值,x方向上的移动速度
	 *@param y
	 *            y方向上的操作值,y方向上的移动速度
	 */
	public AutoStrMove(int x, int y) {
		super(x, y);
		this.setAlive(true);

	}

	/**
	 * 自动移动,每次沿x方向移动xSpeed,沿y移动ySpeed
	 * 
	 * @param sprite
	 *            要操作的精灵
	 */
	public void auto(AbstractSprite sprite) {
		if (this.sprite == null) {
			this.sprite = sprite;
			this.oldx = sprite.getX();
			this.oldy = sprite.getY();
		}
		sprite.setX(x + sprite.getX());
		sprite.setY(y + sprite.getY());
		final int m = sprite.getX() - oldx;
		final int n = sprite.getY() - oldy;
		final int h = m * m + n * n;
		final int loop = 10000;
		if (h > loop) {
			sprite.setX(oldx);
			sprite.setY(oldy);
		}

	}

	/**
	 * 执行自动移动方法,直线移动且移动到一定位置就返回原位置
	 * 
	 * @param sprite
	 *            要操作的精灵
	 */
	public void begin(AbstractSprite sprite) {
		auto(sprite);
	}
}
