package org.sdu.android.util.graphicsUtil;

/**
 * Բ��,x,yΪԲ���ھ������Ͻ�����
 * 
 * @author yyt
 * 
 */
public class Circle extends Shapes {

	/** �뾶 */
	float r = 0;

	/**
	 * ���췽��3��
	 */
	public Circle() {

	}

	/**
	 * 
	 * @param x
	 *            ������
	 * @param y
	 *            ������
	 * @param r
	 *            �뾶
	 */
	public Circle(float x, float y, float r) {
		super.x = x;
		super.y = y;
		this.r = r;
	}

	/**
	 * 
	 * @param r
	 *            �뾶
	 */
	public Circle(float r) {
		this.r = r;
	}

	/**
	 * �õ����
	 * @return area
	 */
	public float getArea() {
		area = (float)(Math.PI * Math.pow(r, 2));
		return area;
	}
	/**
	 * �õ��뾶
	 * @return r
	 */
	public float getR(){
		return r;
	}

	/**
	 * ��������Բ�ε��ص������������ײ����ж��ص������ռ������ ��˿��Լ�Ϊ���������ھ��ε��ص����
	 * 
	 * @param cir Բ��
	 * @return ca �ص����
	 */
	private float cCoveredArea(Circle cir) {
		float ca = 0;
		/** ��������Ӧת��Ϊ���β��� */
		final Rect rec1 = new Rect();
		final Rect rec2 = new Rect();
		rec1.x = cir.x;
		rec1.y = cir.y;
		rec2.x = this.x;
		rec2.y = this.y;
		rec1.wigth = 2 * cir.r;
		rec1.height = 2 * cir.r;
		rec2.wigth = 2 * this.r;
		rec2.height = 2 * this.r;
		ca = rec1.rCoveredArea(rec1, rec2);
		return ca;
	}

	/**
	 * �ж��Ƿ���ײ��Բ��
	 * 
	 * @param cir
	 *            Բ
	 * @return isCol
	 */
	public boolean isCollide(Circle cir) {

		area = cCoveredArea(cir);
		isC(cir.area,this.area);
		return isCol;
	}

	/**
	 * ����һ�����Ƿ���Բ���ڲ�
	 * @param p ��
	 * @return isIn booleanֵ
	 */
	@Override
	public boolean isPointIn(Point p) {
		boolean isIn=false;
		float dis=0;		
		final Point p0;
		p0=getLocation();
		dis=(float)Point.pDistance2(p, p0);
		if(dis<=this.r*r){
			isIn=true;
		}
		else{
			isIn=false;
		}
		return isIn;
	}
}
