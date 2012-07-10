package org.sdu.android.map.search;

import android.graphics.Point;

/**
 * Ѱ���������õ��Ľڵ���
 * 
 * @author Joycery & Sww
 * 
 */
public class PointFen implements Comparable<PointFen> {
	/** �ӿ�ʼ����ǰ���Ѿ��й���·�ĳ��ȼ��ϴӵ�ǰ�㵽�յ�ĳ��ȵ�Ԥ��ֵ */
	int f;

	/** �ӿ�ʼ����ǰ���Ѿ��й���·�ĳ��� */
	int g;

	/** �ӵ�ǰ�㵽�յ�ĳ��ȵ�Ԥ��ֵ */
	int h;

	/** ��ǰ�� */
	Point p;

	/** ��һ���ڵ� */
	PointFen pf;

	/**
	 * �����һ���ڵ�
	 * 
	 * @param point
	 *            ��ʼ�ڵ�
	 */
	public PointFen(Point point) {
		pf = null;
		p = point;
	}

	/**
	 * ������һ���ڵ�
	 * 
	 * @param p
	 *            ��һ���ڵ������ֵ
	 * @param g
	 *            ��һ���ڵ�� g ֵ
	 * @param h
	 *            ��һ���ڵ�� h ֵ
	 * @param pf
	 *            ��ǰ�ڵ�
	 */
	public PointFen(Point p, int g, int h, PointFen pf) {
		this.p = p;
		this.g = g;
		this.h = h;
		this.pf = pf;
		f = g + h;
	}

	/**
	 * �ȽϾ����Ǹ���������·���Ŀ����Դ�
	 * @param h ����һ���ڵ�
	 * @return С����˵��·���϶�
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
