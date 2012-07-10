package org.sdu.android.map.action;
/**
 * 碰撞事件监听器
 * @author Joycery & Sww
 *
 */
public interface CollisionEventListener extends SEventListener{

	/**
     * 响应碰撞事件的函数
     * @param event event
     */
	void collisionOccured(CollisionEvent event);
}
