package org.sdu.android.map.search;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Point;

/**
 * 路线类
 * @author Joycery & Sww
 *
 */
public class Route {

	/**路径*/
	List<Point> route;
	
	/**
	 * 创建一个空的路径
	 */
	public Route(){
		route=new ArrayList<Point>();
	}
	/**
	 * 创建路径
	 * @param route route
	 */
	public Route(List<Point> route) {
		this.route = route;
	}

	/**
	 *添加路径上的点
	 *@param point 点
	 */
	public void addPoint(Point point)
	{
		route.add(point);
	}
	
	/**
	 * 返回路径
	 * @return route 路径
	 */
	public List<Point> getRoute()
	{
		return route;
	}
}
