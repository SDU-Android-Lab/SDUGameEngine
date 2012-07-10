/**
 * 
 */
package org.sdu.android.map.action;

import org.sdu.android.map.painter.ground.Map;

import android.graphics.Point;


/**
 * 地图事件
 * @author Joycery & Sww
 *
 */
public class MapEvent extends SEvent {


	private static final long serialVersionUID = 1L;

	
	private Map map;
	private Point point;
	
	/**
	 * 构造地图事件
	 * @param source 地图
	 * @param point 坐标
	 */
	public MapEvent(Map source,Point point) {
		super(source);
	}

	/**
	 * 得到地图
	 * @return 地图
	 */
	public Map getMap(){
		return map;
	}
	/**
	 * 得到事件位置
	 * @return  事件位置
	 */
	public Point getPoint() {
		return point;
	}
}
