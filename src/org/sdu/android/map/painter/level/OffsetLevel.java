package org.sdu.android.map.painter.level;


/**
 * 有偏移量的Level类（抽象类）
 * 
 * @author Joycery & Sww
 * 
 */
public abstract class OffsetLevel extends Level {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 屏幕左上角在层上的横坐标
	 */
	protected int offsetX;

	/**
	 * 屏幕左上角在层上的纵坐标
	 */
	protected int offsetY;

	/**
	 * 设置 屏幕左上角在层上的横坐标和纵坐标
	 * @param x
	 *            屏幕左上角在层上的横坐标
	 * @param y
	 *            屏幕左上角在层上的纵坐标
	 */
	public void setOffsetXY(int x, int y) {
		offsetX = x;
		offsetY = y;
	}
}
