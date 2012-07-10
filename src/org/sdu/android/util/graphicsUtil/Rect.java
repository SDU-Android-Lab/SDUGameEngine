package org.sdu.android.util.graphicsUtil;

/**
 * 矩形类
 * 
 * @author yyt
 * 
 */
public class Rect extends Shapes {

	/** 长 */
	float height = 0;
	/** 宽 */
	float wigth = 0;

	/**
	 * 初始化
	 */
	public Rect(){}
	/**
	 * 
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 * @param h
	 *            长度
	 * @param w
	 *            宽度
	 */
	public Rect(float x, float y, float h, float w) {
		super.x = x;
		super.y = y;
		this.height = h;
		this.wigth = w;
	}


	/**
	 *设置矩形的长和宽 
	 * @param h
	 *            长
	 * @param w
	 *            宽
	 */
	public void setRectangle(float h, float w) {
		this.height = h;
		this.wigth = w;
	}

	/**
	 * 得到面积
	 * @return area
	 */
	public float getArea() {
		area = x * y;
		return area;
	}

	/**
	 * 得到高度
	 * @return height
	 */
	public float getHeight(){
		return this.height;
	}
	/**
	 * 得到宽度
	 * @return wigth
	 */
	public float getWigth(){
		return this.wigth;
	}
	/**
	 * 计算两个矩形重叠面积
	 * 
	 * @param rec1
	 *            第一个矩形
	 * @param rec2
	 *            第二个矩形
	 * @return ca 重叠面积
	 */
	public float rCoveredArea(Rect rec1, Rect rec2) {
		float ca = 0;
		/** 判断是否发生碰撞（重叠）,若重叠，则进行计算 */
		if (rec1.x < rec2.x + rec2.wigth && rec2.x < rec1.x + rec1.wigth
				&& rec1.y < rec1.y + rec1.height
				&& rec2.y < rec1.y + rec1.height) {
			/** 判断坐标相对大小（位置） */
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
	 * 判断是否碰撞（矩形）
	 * 
	 * @param rec
	 *            矩形
	 * @return isCol
	 */
	public boolean isCollide(Rect rec) {

		area = rCoveredArea(rec, this);
		isC(rec.area, this.area);
		return isCol;
	}
	/**
	 * 计算一个点是否在矩形内部
	 * @param p 点
	 * @return isIn boolean值
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
	 * 以String类型返回矩形信息
	 * @return string
	 */
	@Override
	public String toString() {
		return "Rect [height=" + height + ", wigth=" + wigth + ", x=" + x
				+ ", y=" + y + "]";
	}
	
	
}
