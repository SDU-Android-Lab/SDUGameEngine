package org.sdu.android.map.search;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;

/**
 * ·����
 * @author Joycery & Sww
 *
 */
public class Route {

	/**·��*/
	List<Point> route;
	
	/**
	 * ����һ���յ�·��
	 */
	public Route(){
		route=new ArrayList<Point>();
	}
	/**
	 * ����·��
	 * @param route route
	 */
	public Route(List<Point> route) {
		this.route = route;
	}

	/**
	 *���·���ϵĵ�
	 *@param point ��
	 */
	public void addPoint(Point point)
	{
		route.add(point);
	}
	
	/**
	 * ����·��
	 * @return route ·��
	 */
	public List<Point> getRoute()
	{
		return route;
	}
}
