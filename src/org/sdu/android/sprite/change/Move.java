package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * 定义有关移动的基础事件
 * 
 * */
public abstract class Move {
	/** 定义移动的类型 ,指代精灵的移动类型为移动一步 */
	public final static int MOVE = 0;
	/** 定义移动的类型 ,指代精灵的移动类型为移动到某一位置 */
	public final static int MOVE_TO = 1;
	/** 定义移动的类型，指代精灵的移动类型为不动 */
	public final static int NONE = -1;
	/** 在x轴上的操作值 */
	int x;
	/** 在y轴上的操作值 */
	int y;
	/** 移动的类型 */
	int type;
	/** 事件的状态 */
	boolean alive;

	/**
	 * 构造方法
	 * 
	 * @param x
	 *            在x轴上的操作值
	 * @param y
	 *            在y轴上的操作值
	 * @param type
	 *            移动的类型,具体是MOVE或MOVE_TO
	 * */
	public Move(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	/**
	 * 对MOVE作响应
	 * 
	 * @param sprite
	 *            要移动的精灵
	 * */
	public abstract void startMove(AbstractSprite sprite);

	/**
	 * 对MOVE_TO作响应
	 * 
	 * @param sprite
	 *            要移动的精灵
	 * */
	public abstract void startMoveTo(AbstractSprite sprite);

	/**
	 * 作出具体的移动
	 * 
	 * @param sprite
	 *            要处理的精灵
	 * */
	public abstract void begin(AbstractSprite sprite);

	/**
	 * 事件是否还存在
	 * 
	 * @return true 如果事件还存在
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * 事件的状态设定
	 * 
	 * @param alive
	 *            事件状态
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
