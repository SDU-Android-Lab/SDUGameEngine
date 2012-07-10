package org.sdu.android.map.painter.resource;

import org.sdu.android.map.painter.ground.Map;

import android.view.KeyEvent;

/**
 * 
 * @author Joycery & Sww
 *
 */
public interface HeroIfc {

	/**北方向（上）*/
	int NORTH=100;
	
	/**南方向（下）*/
	int SOUTH=200;
	
	/**西方向（左）*/
	int WEST=300;
	
	/**东方向（右）*/
	int EAST=400;
	
	/**
	 * 按键监听事件
	 * @param keyCode 按键值
	 * @param event 事件
	 */
	void onKeyDown(int keyCode, KeyEvent event) ;
	
	/**
	 * 主角的移动
	 * @param direction 主角的移动方向
	 */
	void move(int direction);
	
	/**
	 * 设置每一步的长度
	 * @param dtc 长度
	 */
	void setDistance(int dtc);
	
	/**
	 * 获取每一步的长度
	 * @return 长度
	 */
	int getDistance();
	
	/**
	 * 设置地图
	 * @param map 地图
	 */
	void setMap(Map map);
}
