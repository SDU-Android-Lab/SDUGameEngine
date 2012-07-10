package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

import android.graphics.Point;

/**
 * 定义了自动移动的循环移动
 * 
 * @author lhy
 * 
 */
public class AutoLoopMove extends AutoMove {
	/**
	 * 位置
	 */
	Point[] locations;
	/**
	 * 循环的标示，用以计数循环
	 */
	int loop;

	/**
	 * 构造方法
	 * 
	 * @param locations
	 *            位置数组
	 */
	public AutoLoopMove(Point[] locations) {
		super();
		this.setAlive(true);
		loop = locations.length;
	}

	/**
	 * 执行自动移动方法,按locations循环移动
	 * 
	 * @param sprite
	 *            要操作的精灵
	 */
	public void begin(AbstractSprite sprite) {
		auto(sprite);
	}

	/**
	 * 自动移动,根据locations循环设定精灵的位置
	 * 
	 * @param sprite
	 *            要操作的精灵
	 */
	public void auto(AbstractSprite sprite) {
		if (loop <= 0) {
			loop = locations.length;
		}
		sprite.setX(locations[locations.length - loop].x);
		sprite.setY(locations[locations.length - loop].y);
		loop--;
	}
}
