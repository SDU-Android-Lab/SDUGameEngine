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
 * ��̬����
 * 
 * @author Joycery & Sww
 * 
 */
public class StaticLevel extends OffsetLevel {
/**
 * bitmap��ʼ��������
 */
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ҫ�ڻ����ϻ��������ͼ
	 */
	private Bitmap bitmap;
	/**
	 * ��ͼ���
	 */
	private int width;
	/**
	 * ��ͼ�߶�
	 */
	private int height;
	/**
	 * paint
	 */
	private Paint paint;
	/**
	 * ��ͼ
	 * @param canvas
	 *            canvas
	 */
	@Override
	public void onDraw(Canvas canvas,Paint paint) {
		canvas.drawBitmap(bitmap, offsetX,offsetY,paint);
	}

	/**
	 * ������ͼ�Ŀ�Ⱥ͸߶�
	 * 
	 * @param width
	 *            ��ͼ���
	 * @param height
	 *            ��ͼ�߶�
	 */
	public void setWidthHeight(int width, int height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * ������Դ
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
	 * �ͷ���Դ
	 */
	@Override
	public void unload() {
		super.unload();
		bitmap.recycle();
	}
	/**
	 * ����paint
	 * @param paint paint
	 */
	public void setPaint(Paint paint) {
		this.paint = paint;
	}

}
