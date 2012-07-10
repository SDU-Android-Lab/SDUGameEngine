package org.sdu.android.sprite;

import org.sdu.android.sprite.change.Change;
import org.sdu.android.util.graphicsUtil.SImage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * ���ڼ��е�ͼ��ĳһ�����ͼ��ľ���
 * 
 * @author lhy
 * 
 */
public class Tile extends AbstractSprite {
	/** ��Ҫ���ƵĻ��� */
	Canvas canvas;
	/** ���� */
	Paint p;

	/**
	 * ���췽��
	 * 
	 * @param id
	 *            id
	 * @param width
	 *            ��
	 * @param height
	 *            ��
	 */
	public Tile(int id, int width, int height) {
		super(id);
		this.width = width;
		this.height = height;
	}

	/**
	 * ������Դ���˴�Ϊ�շ���
	 * 
	 * @param resources
	 *            ϵͳ��Դ
	 */
	public void load(Resources resources) {

	}

	/**
	 * ���ƾ���
	 * 
	 * @param canvas
	 *            ����
	 * 
	 * @param paint
	 *            ����
	 */
	public void onDraw(Canvas canvas, Paint paint) {
		if (this.getImage() != null) {
			canvas.drawBitmap(image.getBitmap(), x, y, paint);
		}
	}

	/**
	 * ���ͼͼ��װ��ͼ��
	 * 
	 * @param rect
	 *            ͼ�����
	 * @param si
	 *            ͼ����Դͼ
	 */
	public void loadTile(Rect rect, SImage si) {
		if (image == null) {
			p = new Paint();
			Bitmap bitmap = Bitmap
					.createBitmap(width, height, Config.ARGB_8888);
			image = new SImage(bitmap);
			canvas = new Canvas(image.getBitmap());
		}
		final Bitmap temp = Bitmap.createBitmap(si.getBitmap(), rect.left,
				rect.top, rect.width(), rect.height());
		canvas.drawBitmap(temp, x, y, p);
	}

	public void destroy() {
		this.image.getBitmap().recycle();
		this.canvas = null;
		this.p = null;
	}

	/**
	 * �ͷ���Դ
	 */
	public void unload() {
		this.getImage().dispose();
		this.image = null;
	}

	/**
	 * ��ӱ仯���˴�Ϊ�շ���
	 * 
	 * @param change
	 *            �仯
	 */
	public void addChanges(Change change) {
	}

	/**
	 * �Ƴ��仯���˴�Ϊ�շ���
	 * 
	 * @param change
	 *            �仯
	 */
	public void removeChanges(Change change) {
	}

	/**
	 * �Ƴ�ȫ���仯���˴�Ϊ�շ���
	 */
	public void removeAllChanges() {
	}

	/**
	 * ��Ӧ�仯���˴�Ϊ�շ���
	 * 
	 * @param paint
	 *            Ҫ�����仯��paint
	 */
	public void change(Paint paint) {
	}

}
