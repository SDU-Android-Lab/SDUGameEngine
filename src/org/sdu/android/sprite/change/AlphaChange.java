package org.sdu.android.sprite.change;

import android.graphics.Paint;

/**
 * 
 * 控制透明度发生变化的事件
 * 
 * 
 * */
public class AlphaChange extends Change {
	/** 全透明 */
	public static final int EMPTYALPHA = 0;
	/** 不透明 */
	public static final int FULLALPHA = 255;
	/** 透明度 */
	int alpha;

	/**
	 * 构造方法
	 * 
	 * @param alpha
	 *            要设定的透明度
	 * 
	 * */
	public AlphaChange(int alpha) {
		this.alpha = alpha;
	}

	/**
	 * 进行变化处理，对paint进行透明度处理
	 * 
	 * @param paint
	 *            要处理的paint
	 * */
	public void startChange(Paint paint) {
		paint.setAlpha(alpha);
		paint.setAntiAlias(true);

	}

}
