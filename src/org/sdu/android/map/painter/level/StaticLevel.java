package org.sdu.android.map.painter.level;

import java.util.Iterator;

import org.sdu.android.sprite.AbstractSprite;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 静态层类
 * 
 * @author Joycery & Sww
 * 
 */
public class StaticLevel extends OffsetLevel {
/**
 * bitmap初始化？？？
 */
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 要在画布上画的总体的图
	 */
	private Bitmap bitmap;
	/**
	 * 总图宽度
	 */
	private int width;
	/**
	 * 总图高度
	 */
	private int height;
	/**
	 * paint
	 */
	private Paint paint;
	/**
	 * 绘图
	 * @param canvas
	 *            canvas
	 */
	@Override
	public void onDraw(Canvas canvas,Paint paint) {
		canvas.drawBitmap(bitmap, offsetX,offsetY,paint);
	}

	/**
	 * 设置总图的宽度和高度
	 * 
	 * @param width
	 *            总图宽度
	 * @param height
	 *            总图高度
	 */
	public void setWidthHeight(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * 加载资源
	 * 
	 * @param context
	 *            context
	 */
	@Override
	public void load(Resources resource) {
		super.load(resource);
		paint=new Paint(Paint.ANTI_ALIAS_FLAG);
		bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		final Iterator<AbstractSprite> it = spriteList.iterator();
		final Canvas canvas = new Canvas(bitmap);
		while (it.hasNext()) {
			final AbstractSprite sprite = it.next();
			sprite.setX(0);
			sprite.setY(0);
			if(this.paint!=null)
			    sprite.onDraw(canvas,paint);
			else
				sprite.onDraw(canvas, new Paint());
		}
	}

	/**
	 * 释放资源
	 */
	@Override
	public void unload() {
		super.unload();
		bitmap.recycle();
	}
	/**
	 * 设置paint
	 * @param paint paint
	 */
	public void setPaint(Paint paint) {
		this.paint = paint;
	}

}
