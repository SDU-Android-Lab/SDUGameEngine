/**
 * 
 */
package org.sdu.android.map.action;

/**
 * 地图事件监听器
 * @author  Joycery & Sww
 *
 */
public interface MapEventListener extends SEventListener{
	
	/**
	 * 处理地图事件
	 * @param event 地图事件
	 */
	void mapEventOccured(MapEvent event);
}
