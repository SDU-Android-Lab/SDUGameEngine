package org.sdu.android.util.graphicsUtil;

/**
 * ����
 * 
 * @author yyt
 * 
 */
public class Point extends Shapes {

	/**
	 * 
	 * @param x
	 *            ������
	 * @param y
	 *            ������
	 */
	public Point(float x, float y) {
		super.x = x;
		super.y = y;
	}

	/**
	 * ��������֮������ƽ����Ϊ��ʡȥ��ƽ���Ļ�����
	 * 
	 * @param p1
	 *            ��һ����
	 * @param p2
	 *            �ڶ�����
	 * @return dis2 �����ƽ��
	 */
	public static float pDistance2(Point p1, Point p2) {
		float dis2 = 0;
		dis2 = (float)(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.x), 2));
		return dis2;
	}

	/**
	 * ��������֮��ĽǶ�
	 * 
	 * @param p1
	 *            ��һ����
	 * @param p2
	 *            �ڶ�����
	 * @return angle �Ƕ�
	 */
	public static float getAngle(Point p1, Point p2) {
		float angle;
		angle = (float)(Math.atan(Math.abs(p1.y - p2.y) / Math.abs(p1.x - p2.x)));
		return angle;
	}
	/**
	 * ����һ�����Ƿ���ͼ���ڲ�
	 * @param p ��
	 * @return isIn booleanֵ
	 */
	@Override
	public boolean isPointIn(Point p) {
		
		return false;
	}
}
