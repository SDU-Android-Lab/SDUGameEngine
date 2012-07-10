package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

/**
 * �Զ�ֱ���ƶ�
 * 
 * 
 */
public class AutoStrMove extends AutoMove {
	/** Ҫ�����ľ��� */
	AbstractSprite sprite;
	/** �¼���ʼʱ��x���� */
	int oldx;
	/** �¼���ʼʱ��y���� */
	int oldy;

	/**
	 * ���췽��
	 * 
	 *@param x
	 *            x�����ϵĲ���ֵ,x�����ϵ��ƶ��ٶ�
	 *@param y
	 *            y�����ϵĲ���ֵ,y�����ϵ��ƶ��ٶ�
	 */
	public AutoStrMove(int x, int y) {
		super(x, y);
		this.setAlive(true);

	}

	/**
	 * �Զ��ƶ�,ÿ����x�����ƶ�xSpeed,��y�ƶ�ySpeed
	 * 
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public void auto(AbstractSprite sprite) {
		if (this.sprite == null) {
			this.sprite = sprite;
			this.oldx = sprite.getX();
			this.oldy = sprite.getY();
		}
		sprite.setX(x + sprite.getX());
		sprite.setY(y + sprite.getY());
		final int m = sprite.getX() - oldx;
		final int n = sprite.getY() - oldy;
		final int h = m * m + n * n;
		final int loop = 10000;
		if (h > loop) {
			sprite.setX(oldx);
			sprite.setY(oldy);
		}

	}

	/**
	 * ִ���Զ��ƶ�����,ֱ���ƶ����ƶ���һ��λ�þͷ���ԭλ��
	 * 
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public void begin(AbstractSprite sprite) {
		auto(sprite);
	}
}
