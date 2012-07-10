package org.sdu.android.map.painter.ground;

import org.sdu.android.map.search.AutoSearchable;
import org.sdu.android.map.search.Route;
import org.sdu.android.map.search.Search;

import android.graphics.Point;

/**
 * 地图类，继承了简单地图，并实现了自动寻径的接口模块
 * 
 * @author Joycery & Sww
 *
 */
public abstract class SearchableMap extends SimpleMap implements AutoSearchable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**寻径对象*/
	private Search search;

	/**
	 * 
	 * @param array  地图对应的数组
	 *        0代表可以通过，1代表不可以通过
	 *        
	 *  瓦片的宽高参数
	 * @param tileWidth  .
	 * @param tileHeight .
	 */
	public SearchableMap(int[][] array, int tileWidth, int tileHeight){
		super(array, tileWidth, tileHeight);
		search=new Search(this);
	}
	
	/***************************
	 *对自动寻径的功能实现
	 **************************/
	
	/**
	 * @param start  路径的起始点
	 * @param des    路径的终点
	 * 
	 * @return route 返回一条路径
	 */
	public Route findRoute(Point start, Point des) {
		search.search(start, des);
		return search.getRoute();
	}
}
