package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * �����й��ƶ��Ļ����¼�
 * 
 * */
public abstract class Move {
	/** �����ƶ������� ,ָ��������ƶ�����Ϊ�ƶ�һ�� */
	public final static int MOVE = 0;
	/** �����ƶ������� ,ָ��������ƶ�����Ϊ�ƶ���ĳһλ�� */
	public final static int MOVE_TO = 1;
	/** �����ƶ������ͣ�ָ��������ƶ�����Ϊ���� */
	public final static int NONE = -1;
	/** ��x���ϵĲ���ֵ */
	int x;
	/** ��y���ϵĲ���ֵ */
	int y;
	/** �ƶ������� */
	int type;
	/** �¼���״̬ */
	boolean alive;

	/**
	 * ���췽��
	 * 
	 * @param x
	 *            ��x���ϵĲ���ֵ
	 * @param y
	 *            ��y���ϵĲ���ֵ
	 * @param type
	 *            �ƶ�������,������MOVE��MOVE_TO
	 * */
	public Move(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	/**
	 * ��MOVE����Ӧ
	 * 
	 * @param sprite
	 *            Ҫ�ƶ��ľ���
	 * */
	public abstract void startMove(AbstractSprite sprite);

	/**
	 * ��MOVE_TO����Ӧ
	 * 
	 * @param sprite
	 *            Ҫ�ƶ��ľ���
	 * */
	public abstract void startMoveTo(AbstractSprite sprite);

	/**
	 * ����������ƶ�
	 * 
	 * @param sprite
	 *            Ҫ����ľ���
	 * */
	public abstract void begin(AbstractSprite sprite);

	/**
	 * �¼��Ƿ񻹴���
	 * 
	 * @return true ����¼�������
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * �¼���״̬�趨
	 * 
	 * @param alive
	 *            �¼�״̬
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
