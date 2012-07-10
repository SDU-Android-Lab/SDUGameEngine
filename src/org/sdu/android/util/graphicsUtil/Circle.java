package org.sdu.android.util.graphicsUtil;

/**
 * 圆类,x,y为圆所在矩形左上角坐标
 * 
 * @author yyt
 * 
 */
public class Circle extends Shapes {

	/** 半径 */
	float r = 0;

	/**
	 * 构造方法3个
	 */
	public Circle() {

	}

	/**
	 * 
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 * @param r
	 *            半径
	 */
	public Circle(float x, float y, float r) {
		super.x = x;
		super.y = y;
		this.r = r;
	}

	/**
	 * 
	 * @param r
	 *            半径
	 */
	public Circle(float r) {
		this.r = r;
	}

	/**
	 * 得到面积
	 * @return area
	 */
	public float getArea() {
		area = (float)(Math.PI * Math.pow(r, 2));
		return area;
	}
	/**
	 * 得到半径
	 * @return r
	 */
	public float getR(){
		return r;
	}

	/**
	 * 计算两个圆形的重叠面积，用于碰撞检测判断重叠面积所占比例， 因此可以简化为计算其所在矩形的重叠面积
	 * 
	 * @param cir 圆形
	 * @return ca 重叠面积
	 */
	private float cCoveredArea(Circle cir) {
		float ca = 0;
		/** 将参数对应转化为矩形参数 */
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
	 * 判断是否碰撞（圆）
	 * 
	 * @param cir
	 *            圆
	 * @return isCol
	 */
	public boolean isCollide(Circle cir) {

		area = cCoveredArea(cir);
		isC(cir.area,this.area);
		return isCol;
	}

	/**
	 * 计算一个点是否在圆形内部
	 * @param p 点
	 * @return isIn boolean值
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
