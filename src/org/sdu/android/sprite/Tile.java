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
 * 用于剪切地图上某一区域的图像的精灵
 * 
 * @author lhy
 * 
 */
public class Tile extends AbstractSprite {
	/** 需要绘制的画布 */
	Canvas canvas;
	/** 画笔 */
	Paint p;

	/**
	 * 构造方法
	 * 
	 * @param id
	 *            id
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 */
	public Tile(int id, int width, int height) {
		super(id);
		this.width = width;
		this.height = height;
	}

	/**
	 * 加载资源，此处为空方法
	 * 
	 * @param resources
	 *            系统资源
	 */
	public void load(Resources resources) {

	}

	/**
	 * 绘制精灵
	 * 
	 * @param canvas
	 *            画布
	 * 
	 * @param paint
	 *            画笔
	 */
	public void onDraw(Canvas canvas, Paint paint) {
		if (this.getImage() != null) {
			canvas.drawBitmap(image.getBitmap(), x, y, paint);
		}
	}

	/**
	 * 向地图图块装载图像
	 * 
	 * @param rect
	 *            图像矩形
	 * @param si
	 *            图像资源图
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
	 * 释放资源
	 */
	public void unload() {
		this.getImage().dispose();
		this.image = null;
	}

	/**
	 * 添加变化，此处为空方法
	 * 
	 * @param change
	 *            变化
	 */
	public void addChanges(Change change) {
	}

	/**
	 * 移除变化，此处为空方法
	 * 
	 * @param change
	 *            变化
	 */
	public void removeChanges(Change change) {
	}

	/**
	 * 移除全部变化，此处为空方法
	 */
	public void removeAllChanges() {
	}

	/**
	 * 响应变化，此处为空方法
	 * 
	 * @param paint
	 *            要发生变化的paint
	 */
	public void change(Paint paint) {
	}

}
