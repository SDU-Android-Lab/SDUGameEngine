package org.sdu.android.sprite.change;

import android.graphics.Paint;

/**
 * 
 * ����͸���ȷ����仯���¼�
 * 
 * 
 * */
public class AlphaChange extends Change {
	/** ȫ͸�� */
	public static final int EMPTYALPHA = 0;
	/** ��͸�� */
	public static final int FULLALPHA = 255;
	/** ͸���� */
	int alpha;

	/**
	 * ���췽��
	 * 
	 * @param alpha
	 *            Ҫ�趨��͸����
	 * 
	 * */
	public AlphaChange(int alpha) {
		this.alpha = alpha;
	}

	/**
	 * ���б仯������paint����͸���ȴ���
	 * 
	 * @param paint
	 *            Ҫ�����paint
	 * */
	public void startChange(Paint paint) {
		paint.setAlpha(alpha);
		paint.setAntiAlias(true);

	}

}
