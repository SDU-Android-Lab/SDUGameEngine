package org.sdu.android.map.action;
/**
 * ��ײ�¼�������
 * @author Joycery & Sww
 *
 */
public interface CollisionEventListener extends SEventListener{

	/**
     * ��Ӧ��ײ�¼��ĺ���
     * @param event event
     */
	void collisionOccured(CollisionEvent event);
}
