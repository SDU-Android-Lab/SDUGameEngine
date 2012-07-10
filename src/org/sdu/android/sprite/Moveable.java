package org.sdu.android.sprite;

import org.sdu.android.sprite.change.Move;

/**
 * 
 * ���徫���Ƿ���ƶ�
 * */
public interface Moveable {
	/**
	 * ���ָ���ƶ��¼�
	 * 
	 * @param move
	 *            ָ�����ƶ��¼�
	 * 
	 * */
	void addMoves(Move move);

	/**
	 * 
	 * �Ƴ�ָ���ƶ��¼�
	 * 
	 * @param move
	 *            ָ�����ƶ��¼�
	 * */
	void removeMoves(Move move);

	/**
	 * 
	 * ��Ӧ�ƶ��¼�
	 * 
	 * */
	void move();
}
