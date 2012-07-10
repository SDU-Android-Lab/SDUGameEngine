package org.sdu.android.sprite;

import java.util.LinkedList;

import org.sdu.android.sprite.change.Move;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 可移动的精灵，可以实现颜色、透明度的变化以及播放效果和移动.
 * 
 * 
 * 
 */
public class DynamicSprite extends StaticSprite implements Moveable {
	/** 精灵的移动事件 */
	LinkedList<Move> moves;

	/**
	 * 构造方法
	 * 
	 * @param x
	 *            相对于地图x坐标
	 * @param y
	 *            相对于地图y坐标
	 * @param id
	 *            id
	 * @param resId
	 *            图像资源的标识
	 * @param canPlay
	 *            精灵是否可播放
	 * 
	 */
	public DynamicSprite(int x, int y, int id, int resId, boolean canPlay) {
		super(x, y, id, resId, canPlay);
		moves = new LinkedList<Move>();
	}

	/**
	 * 构造方法
	 * 
	 * @param x
	 *            相对于地图x坐标
	 * @param y
	 *            相对于地图y坐标
	 * @param id
	 *            id
	 * @param canPlay
	 *            精灵是否可播放
	 * */

	public DynamicSprite(int x, int y, int id, boolean canPlay) {
		super(x, y, id, canPlay);
		moves = new LinkedList<Move>();
	}

	/**
	 * @param id
	 * @param b
	 */
	public DynamicSprite(int id, boolean b) {
		this(0, 0, id, b);
	}

	/**
	 * 重载onDraw方法
	 * 
	 * @param canvas
	 *            将要绘制的画布
	 * @param paint
	 *            绘制用的画笔
	 */
	public void onDraw(Canvas canvas, Paint paint) {
		super.onDraw(canvas, paint);
		move();
	}

	/**
	 * 添加移动事件
	 * 
	 * @param move
	 *            指定的移动事件
	 * */
	public void addMoves(Move move) {
		moves.add(move);
	}

	/**
	 * 响应移动事件
	 * */
	public void move() {
		if (!start) {
			return;
		}
		if (!moves.isEmpty()) {
			final Move m = moves.get(0);
			m.begin(this);
			if (!m.isAlive()) {
				moves.remove(0);
			}
		}
	}

	/**
	 * 移除指定的移动事件
	 * 
	 * @param move
	 *            要移除的移动事件
	 * 
	 * */
	public void removeMoves(Move move) {
		moves.remove(move);
	}

}
