package org.sdu.android.map.search;

import android.graphics.Point;

/**
 * 可寻径接口
 * @author Joycery & Sww
 * 
 */
public interface AutoSearchable {
	/**
	 * 得到从开始地到终点的路径
	 * @param start 开始地点
	 * @param des	结束地点
	 * @return 路径，如果路径不存在则返回null
	 */
	Route findRoute(Point start, Point des);
}
