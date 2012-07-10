package org.sdu.android.util.graphicsUtil;

/**
 * ������
 * 
 * @author yyt
 * 
 */
public class Rect extends Shapes {

	/** �� */
	float height = 0;
	/** �� */
	float wigth = 0;

	/**
	 * ��ʼ��
	 */
	public Rect(){}
	/**
	 * 
	 * @param x
	 *            ������
	 * @param y
	 *            ������
	 * @param h
	 *            ����
	 * @param w
	 *            ���
	 */
	public Rect(float x, float y, float h, float w) {
		super.x = x;
		super.y = y;
		this.height = h;
		this.wigth = w;
	}


	/**
	 *���þ��εĳ��Ϳ� 
	 * @param h
	 *            ��
	 * @param w
	 *            ��
	 */
	public void setRectangle(float h, float w) {
		this.height = h;
		this.wigth = w;
	}

	/**
	 * �õ����
	 * @return area
	 */
	public float getArea() {
		area = x * y;
		return area;
	}

	/**
	 * �õ��߶�
	 * @return height
	 */
	public float getHeight(){
		return this.height;
	}
	/**
	 * �õ����
	 * @return wigth
	 */
	public float getWigth(){
		return this.wigth;
	}
	/**
	 * �������������ص����
	 * 
	 * @param rec1
	 *            ��һ������
	 * @param rec2
	 *            �ڶ�������
	 * @return ca �ص����
	 */
	public float rCoveredArea(Rect rec1, Rect rec2) {
		float ca = 0;
		/** �ж��Ƿ�����ײ���ص���,���ص�������м��� */
		if (rec1.x < rec2.x + rec2.wigth && rec2.x < rec1.x + rec1.wigth
				&& rec1.y < rec1.y + rec1.height
				&& rec2.y < rec1.y + rec1.height) {
			/** �ж�������Դ�С��λ�ã� */
			float minX = 0;
			float maxX = 0;
			float minY = 0;
			float maxY = 0;
			float w = 0;
			float h = 0;
			if (rec1.x < rec2.x) {
				minX = rec1.x;
				maxX = rec2.x;
				w = rec1.wigth;
			} else {
				minX = rec2.x;
				maxX = rec1.x;
				w = rec2.wigth;
			}
			if (rec1.y < rec2.y) {
				minY = rec1.y;
				maxY = rec2.y;
				h = rec1.height;
			} else {
				minY = rec2.y;
				maxY = rec1.y;
				h = rec2.height;
			}
			ca = (minX + w - maxX) * (minY + h - maxY);
		}
		return ca;
	}

	/**
	 * �ж��Ƿ���ײ�����Σ�
	 * 
	 * @param rec
	 *            ����
	 * @return isCol
	 */
	public boolean isCollide(Rect rec) {

		area = rCoveredArea(rec, this);
		isC(rec.area, this.area);
		return isCol;
	}
	/**
	 * ����һ�����Ƿ��ھ����ڲ�
	 * @param p ��
	 * @return isIn booleanֵ
	 */
	@Override
	public boolean isPointIn(Point p) {
		boolean isIn=false;
		if(p.x>=this.x&&p.y>=this.y&&p.x<=this.x+this.wigth&&p.y<=this.y+this.height){
			isIn=true;
		}
		else{
			isIn=false;
		}
		return isIn;
	}
	/**
	 * ��String���ͷ��ؾ�����Ϣ
	 * @return string
	 */
	@Override
	public String toString() {
		return "Rect [height=" + height + ", wigth=" + wigth + ", x=" + x
				+ ", y=" + y + "]";
	}
	
	
}
