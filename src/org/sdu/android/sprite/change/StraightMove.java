package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * 
 * �����ֱ���ƶ��¼�
 * 
 * */
public class StraightMove extends Move {
	/**
	 * ���췽��
	 * @param x
	 *            ��x���ϵĲ���ֵ
	 * @param y
	 *            ��y���ϵĲ���ֵ
	 * @param type
	 *            �ƶ�������,������MOVE��MOVE_TO
	 * */
	public StraightMove(int x, int y, int type) {
		super(x, y, type);
		this.setAlive(true);
	}

	/**
	 * ��MOVE����Ӧ,����Ϊ����x��������x��y��������y��
	 * 
	 * @param sprite
	 *            Ҫ�ƶ��ľ���
	 * */
	public void startMove(AbstractSprite sprite) {
		sprite.setX(x + sprite.getX());
		sprite.setY(y + sprite.getY());
	}

	/**
	 * ��MOVE_TO����Ӧ,����Ϊ����x�����Ϊx��y�����Ϊy��
	 * 
	 * @param sprite
	 *            Ҫ�ƶ��ľ���
	 * */
	public void startMoveTo(AbstractSprite sprite) {
		sprite.setX(x);
		sprite.setY(y);
	}

	/**
	 * ��typeΪMOVE�������startMove��ΪMOVE_TO����startMoveTo
	 * 
	 * @param sprite
	 *            Ҫ����ľ���
	 * */
	public void begin(AbstractSprite sprite) {
		if (type == MOVE) {
			startMove(sprite);
		}
		if (type == MOVE_TO) {
			startMoveTo(sprite);
		}
		this.setAlive(false);
	}

}
