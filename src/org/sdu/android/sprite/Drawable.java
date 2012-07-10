package org.sdu.android.sprite;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ������Ҫʵ�ֵĽӿڣ������˾���������ķ���
 * 
 * 
 * */
public interface Drawable {
	/**
	 * װ����Դ
	 * 
	 * @param resources
	 *            ��Ҫ���ص���Դ
	 */
	void load(Resources resources);

	/**
	 * ����ͼ��
	 * 
	 * @param canvas
	 *            ��Ҫ���ƵĻ���
	 * @param paint
	 *            �����õĻ���
	 * */
	void onDraw(Canvas canvas, Paint paint);

	/**
	 * �ͷ���Դ
	 * */
	void unload();
}
