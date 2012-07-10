package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * �����Զ��ƶ����ƶ��¼�
 * 
 * 
 */
public abstract class AutoMove extends Move {
	/**
	 * ���췽��
	 */
	public AutoMove() {
		super(0, 0, Move.NONE);
	}

	/**
	 * ���췽��
	 * 
	 * @param x
	 *            x�����ϵĲ���ֵ
	 * @param y
	 *            y�����ϵĲ���ֵ
	 */
	public AutoMove(int x, int y) {
		super(x, y, Move.NONE);
	}

	/**
	 * ִ���Զ��ƶ�����
	 * 
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public abstract void begin(AbstractSprite sprite);

	/**
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public void startMove(AbstractSprite sprite) {
	}

	/**
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public void startMoveTo(AbstractSprite sprite) {
	}

	/**
	 * �Զ��ƶ�
	 * 
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public abstract void auto(AbstractSprite sprite);
}
