package org.sdu.android.util.graphicsUtil;

/**
 * ����ͼ�θ���
 * 
 * @author yyt
 * 
 */
public abstract class Shapes {
	/** ������ */
	float x = 0;
	/** ������ */
	float y = 0;
	/** ��� */
	float area = 0;
	/** ��ṹ */
	Point location;

	/** �Ƿ���ײbooleanֵ */
	boolean isCol = false;

	/** ����ͼ���бȽ�С����� */
	float minArea = 0;
	/** �ж���ײ�����������ռ���� */
	private static final float PERC = 0.2f;

	/**
	 * 
	 * @param x
	 *            ������
	 * @param y
	 *            ������
	 */
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param area
	 *            ���
	 */
	void setArea(float area) {
		this.area = area;
	}

	/**
	 * 
	 * @return x ������
	 */
	public float getX() {
		return x;
	}

	/**
	 * 
	 * @return y ������
	 */
	public float getY() {
		return y;
	}

	/**
	 * �õ�ͼ��λ��
	 * 
	 * @return location
	 */
	public Point getLocation() {
		location = new Point(x, y);
		return location;
	}

	/**
	 * �õ�ͼ�����
	 * 
	 * @return area
	 */
	float getArea() {
		return area;
	}

	/**
	 * ��������ͼ���бȽ�С�����
	 * 
	 * @param s1
	 *            ��һ��
	 * @param s2
	 *            �ڶ���
	 */
	protected void isC(float s1, float s2) {
		if (s1 < s2) {
			minArea = s1;
		} else {
			minArea = s2;
		}
		if (area / minArea >= PERC) {
			isCol = true;
		}
	}
	/**
	 * ����һ�����Ƿ���ͼ���ڲ�
	 * @param p ��
	 * @return isIn booleanֵ
	 */
	public abstract boolean isPointIn(Point p);
	/**
	 * �ж��Ƿ���ײ�����Σ�
	 * 
	 * @param rec
	 *            ����
	 * @return isCol
	 */
	public boolean isCollide(Shapes s) {

		if(s instanceof Rect){
			isCollide(s);
		}
		else if(s instanceof Circle){
			isCollide(s);
		}
		return isCol;
	}

}
