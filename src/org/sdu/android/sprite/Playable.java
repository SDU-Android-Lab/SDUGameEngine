package org.sdu.android.sprite;

import org.sdu.android.sprite.change.Play;


/**
 * 
 * ���徫���Ƿ�ɲ���
 * 
 */
public interface Playable {
	/**
	 * 
	 * ���ָ�������¼�
	 * 
	 * @param play
	 * 
	 *            ָ���Ĳ����¼�
	 * */
	void addPlays(Play play);

	/**
	 * �Ƴ�ָ�������¼�
	 * 
	 * @param play
	 * 
	 *            ָ���Ĳ����¼�
	 * */
	void removePlays(Play play);

	/**
	 * ��Ӧ�����¼�
	 * 
	 * */
	void play();
}
