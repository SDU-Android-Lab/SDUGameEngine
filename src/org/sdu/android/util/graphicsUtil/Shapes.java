package org.sdu.android.util.graphicsUtil;

/**
 * 基本图形父类
 * 
 * @author yyt
 * 
 */
public abstract class Shapes {
	/** 横坐标 */
	float x = 0;
	/** 纵坐标 */
	float y = 0;
	/** 面积 */
	float area = 0;
	/** 点结构 */
	Point location;

	/** 是否碰撞boolean值 */
	boolean isCol = false;

	/** 两个图形中比较小的面积 */
	float minArea = 0;
	/** 判断碰撞条件：面积所占比例 */
	private static final float PERC = 0.2f;

	/**
	 * 
	 * @param x
	 *            横坐标
	 * @param y
	 *            纵坐标
	 */
	public void setLocation(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param area
	 *            面积
	 */
	void setArea(float area) {
		this.area = area;
	}

	/**
	 * 
	 * @return x 横坐标
	 */
	public float getX() {
		return x;
	}

	/**
	 * 
	 * @return y 纵坐标
	 */
	public float getY() {
		return y;
	}

	/**
	 * 得到图形位置
	 * 
	 * @return location
	 */
	public Point getLocation() {
		location = new Point(x, y);
		return location;
	}

	/**
	 * 得到图形面积
	 * 
	 * @return area
	 */
	float getArea() {
		return area;
	}

	/**
	 * 计算两个图形中比较小的面积
	 * 
	 * @param s1
	 *            第一个
	 * @param s2
	 *            第二个
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
	 * 计算一个点是否在图形内部
	 * @param p 点
	 * @return isIn boolean值
	 */
	public abstract boolean isPointIn(Point p);
	/**
	 * 判断是否碰撞（矩形）
	 * 
	 * @param rec
	 *            矩形
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
