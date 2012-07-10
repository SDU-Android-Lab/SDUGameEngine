package org.sdu.android.map.painter.scene;

import java.io.Serializable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ͨ�ó���Ҫʵ�ֵĽӿ�
 * 
 * @author Joycery & Sww
 * 
 */
public interface SceneInterface extends Serializable {

	/**
	 * ��ʼ��
	 */
	void initialize();

	/**
	 * ����
	 * 
	 * @param c
	 *            canvas
	 */
	void onDraw(Canvas c,Paint paint);

	/**
	 * ����
	 * 
	 * @param context
	 *            context
	 */
	void load(Resources resource);

	/**
	 * �ͷ�
	 */
	void unLoad();
}
