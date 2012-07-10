package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;

import android.graphics.Point;

/**
 * �������Զ��ƶ���ѭ���ƶ�
 * 
 * @author lhy
 * 
 */
public class AutoLoopMove extends AutoMove {
	/**
	 * λ��
	 */
	Point[] locations;
	/**
	 * ѭ���ı�ʾ�����Լ���ѭ��
	 */
	int loop;

	/**
	 * ���췽��
	 * 
	 * @param locations
	 *            λ������
	 */
	public AutoLoopMove(Point[] locations) {
		super();
		this.setAlive(true);
		loop = locations.length;
	}

	/**
	 * ִ���Զ��ƶ�����,��locationsѭ���ƶ�
	 * 
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public void begin(AbstractSprite sprite) {
		auto(sprite);
	}

	/**
	 * �Զ��ƶ�,����locationsѭ���趨�����λ��
	 * 
	 * @param sprite
	 *            Ҫ�����ľ���
	 */
	public void auto(AbstractSprite sprite) {
		if (loop <= 0) {
			loop = locations.length;
		}
		sprite.setX(locations[locations.length - loop].x);
		sprite.setY(locations[locations.length - loop].y);
		loop--;
	}
}
