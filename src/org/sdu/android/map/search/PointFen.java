package org.sdu.android.map.search;

import android.graphics.Point;

/**
 * 寻径过程中用到的节点类
 * 
 * @author Joycery & Sww
 * 
 */
public class PointFen implements Comparable<PointFen> {
	/** 从开始到当前点已经有过的路的长度加上从当前点到终点的长度的预测值 */
	int f;

	/** 从开始到当前点已经有过的路的长度 */
	int g;

	/** 从当前点到终点的长度的预测值 */
	int h;

	/** 当前点 */
	Point p;

	/** 上一个节点 */
	PointFen pf;

	/**
	 * 构造第一个节点
	 * 
	 * @param point
	 *            开始节点
	 */
	public PointFen(Point point) {
		pf = null;
		p = point;
	}

	/**
	 * 构造下一个节点
	 * 
	 * @param p
	 *            下一个节点的坐标值
	 * @param g
	 *            下一个节点的 g 值
	 * @param h
	 *            下一个节点的 h 值
	 * @param pf
	 *            当前节点
	 */
	public PointFen(Point p, int g, int h, PointFen pf) {
		this.p = p;
		this.g = g;
		this.h = h;
		this.pf = pf;
		f = g + h;
	}

	/**
	 * 比较经过那个结点是最短路径的可能性大
	 * @param h 另外一个节点
	 * @return 小于零说明路径较短
	 */
	public int compareTo(PointFen  h) {
		if (f != h.f) {
			return f - h.f;
		}
		if (p.x > h.p.x) {
			return p.x - h.p.x;
		}
		return p.y - h.p.y;
	}
}
