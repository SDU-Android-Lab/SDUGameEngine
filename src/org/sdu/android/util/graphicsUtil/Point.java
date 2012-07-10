package org.sdu.android.util.graphicsUtil;

/**
 * 点类
 * 
 * @author yyt
 * 
 */
public class Point extends Shapes {

	/**
	 * 
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 */
	public Point(float x, float y) {
		super.x = x;
		super.y = y;
	}

	/**
	 * 计算两点之间距离的平方（为了省去开平方的花销）
	 * 
	 * @param p1
	 *            第一个点
	 * @param p2
	 *            第二个点
	 * @return dis2 距离的平方
	 */
	public static float pDistance2(Point p1, Point p2) {
		float dis2 = 0;
		dis2 = (float)(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.x), 2));
		return dis2;
	}

	/**
	 * 计算两点之间的角度
	 * 
	 * @param p1
	 *            第一个点
	 * @param p2
	 *            第二个点
	 * @return angle 角度
	 */
	public static float getAngle(Point p1, Point p2) {
		float angle;
		angle = (float)(Math.atan(Math.abs(p1.y - p2.y) / Math.abs(p1.x - p2.x)));
		return angle;
	}
	/**
	 * 计算一个点是否在图形内部
	 * @param p 点
	 * @return isIn boolean值
	 */
	@Override
	public boolean isPointIn(Point p) {
		
		return false;
	}
}
