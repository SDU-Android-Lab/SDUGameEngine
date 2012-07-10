package org.sdu.android.sprite.change;

import android.graphics.Paint;

/**
 * 
 * ������ɫ�����仯���¼�
 * 
 * 
 * */
public class ColorChange extends Change {
	/**
	 * ��Ӧ��ɫͨ��
	 * 
	 * */
	int r;
	/**
	 * 
	 * ��Ӧ��ɫͨ��
	 * */
	int g;
	/**
	 * 
	 * ��Ӧ��ɫͨ��
	 * */
	int b;

	/**
	 * ���췽��
	 * 
	 * @param r
	 *            ��ɫͨ��
	 * @param g
	 *            ��ɫͨ��
	 * @param b
	 *            ��ɫͨ��
	 * */
	public ColorChange(int r, int g, int b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}

	/**
	 * ���б仯������paint������ɫ����
	 * 
	 * @param paint
	 *            Ҫ�����paint
	 * */
	public void startChange(Paint paint) {
		paint.setARGB(paint.getAlpha(), r, g, b);
	}

}
