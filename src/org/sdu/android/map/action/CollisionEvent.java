package org.sdu.android.map.action;

import org.sdu.android.map.painter.scene.SceneInterface;
import org.sdu.android.sprite.AbstractSprite;

/**碰撞事件
 * 
 * @author Joycery & Sww
 *
 */
public class CollisionEvent extends SEvent{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**碰撞的精灵组*/
	CollisionGroup group;
	
	/**对应的场景*/
	private SceneInterface scene;
	
	/**
	 * 
	 * @param scene 场景
	 * @param group 精灵组
	 */
	public CollisionEvent(SceneInterface scene,CollisionGroup group) {
		// TODO Auto-generated constructor stub
		super(scene);
		this.group=group;
	}

	/**
	 * 
	 * @return 第一个碰撞物
	 */
	public AbstractSprite getSp1() {
		return group.getSp1();
	}

	/**
	 * 
	 * @return 第二个碰撞物
	 */
	public AbstractSprite getSp2() {
		return group.getSp2();
	}

	/**
	 * 获取精灵组
	 * @return group
	 */
	public CollisionGroup getGroup() {
		return group;
	}

	/**
	 * 
	 * @return 场景
	 */
	public SceneInterface getScene() {
		return scene;
	}

}
