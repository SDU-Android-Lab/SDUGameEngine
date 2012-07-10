package org.sdu.android.sprite;

import org.sdu.android.sprite.change.Move;

/**
 * 
 * 定义精灵是否可移动
 * */
public interface Moveable {
	/**
	 * 添加指定移动事件
	 * 
	 * @param move
	 *            指定的移动事件
	 * 
	 * */
	void addMoves(Move move);

	/**
	 * 
	 * 移除指定移动事件
	 * 
	 * @param move
	 *            指定的移动事件
	 * */
	void removeMoves(Move move);

	/**
	 * 
	 * 响应移动事件
	 * 
	 * */
	void move();
}
