package org.sdu.android.map.action;

import org.sdu.android.map.painter.scene.SceneInterface;
import org.sdu.android.sprite.AbstractSprite;

/**��ײ�¼�
 * 
 * @author Joycery & Sww
 *
 */
public class CollisionEvent extends SEvent{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**��ײ�ľ�����*/
	CollisionGroup group;
	
	/**��Ӧ�ĳ���*/
	private SceneInterface scene;
	
	/**
	 * 
	 * @param scene ����
	 * @param group ������
	 */
	public CollisionEvent(SceneInterface scene,CollisionGroup group) {
		// TODO Auto-generated constructor stub
		super(scene);
		this.group=group;
	}

	/**
	 * 
	 * @return ��һ����ײ��
	 */
	public AbstractSprite getSp1() {
		return group.getSp1();
	}

	/**
	 * 
	 * @return �ڶ�����ײ��
	 */
	public AbstractSprite getSp2() {
		return group.getSp2();
	}

	/**
	 * ��ȡ������
	 * @return group
	 */
	public CollisionGroup getGroup() {
		return group;
	}

	/**
	 * 
	 * @return ����
	 */
	public SceneInterface getScene() {
		return scene;
	}

}
