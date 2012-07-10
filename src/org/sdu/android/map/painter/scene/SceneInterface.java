package org.sdu.android.map.painter.scene;

import java.io.Serializable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 通用场景要实现的接口
 * 
 * @author Joycery & Sww
 * 
 */
public interface SceneInterface extends Serializable {

	/**
	 * 初始化
	 */
	void initialize();

	/**
	 * 绘制
	 * 
	 * @param c
	 *            canvas
	 */
	void onDraw(Canvas c,Paint paint);

	/**
	 * 载入
	 * 
	 * @param context
	 *            context
	 */
	void load(Resources resource);

	/**
	 * 释放
	 */
	void unLoad();
}
