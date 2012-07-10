package org.sdu.android.sprite;

import java.util.LinkedList;

import org.sdu.android.sprite.change.Change;
import org.sdu.android.sprite.change.Play;
import org.sdu.android.util.graphicsUtil.SImage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;

/**
 * 不可移动的精灵，可以实现颜色、透明度的变化以及播放效果.
 * 
 * 
 * 
 */

public class StaticSprite extends AbstractSprite implements Playable {
	/** 默认透明度 */
	private static final int DEFAULT_ALPHA = 255;
	/** 精灵的帧图像 */
	protected SImage[] frames = null;
	/** 精灵的颜色和透明度变化事件 */
	protected LinkedList<Change> changes = null;
	/** 精灵的播放事件 */
	protected LinkedList<Play> plays = null;
	/** 当前的播放事件 */
	protected Play nowPlay = null;
	/** 控制精灵是否启动 */
	protected boolean start = false;
	/** 标识精灵是否可播放 */
	protected boolean canPlay;
	/** 当前透明度 */
	protected int currentAlpha = DEFAULT_ALPHA;
	/** 是否根据包围盒缩放 */
	protected boolean scale = false;

	/**
	 * 构造方法
	 * 
	 * @param x
	 *            相对于地图x坐标
	 * @param y
	 *            相对于地图y坐标
	 * @param id
	 *            id
	 * @param resId
	 *            图像资源的标识
	 * @param canPlay
	 *            精灵是否可播放
	 * */

	public StaticSprite(int x, int y, int id, int resId, boolean canPlay) {
		super(id);
		this.x = x;
		this.y = y;
		this.resId = resId;
		this.canPlay = canPlay;
		changes = new LinkedList<Change>();
		if (canPlay) {
			plays = new LinkedList<Play>();
		}

	}

	/**
	 * 构造方法
	 * 
	 * @param x
	 *            相对于地图x坐标
	 * @param y
	 *            相对于地图y坐标 
	 * @param id
	 *            id
	 * @param canPlay
	 *            精灵是否可播放
	 */
	public StaticSprite(int x, int y, int id, boolean canPlay) {
		super(id);
		this.x = x;
		this.y = y;
		this.canPlay = canPlay;
		changes = new LinkedList<Change>();
		if (canPlay) {
			plays = new LinkedList<Play>();
		}
	}

	/**
	 * @param id
	 * @param b
	 */
	public StaticSprite(int id, boolean b) {
		this(0,0,id,b);
	}

	/**
	 * 装载资源的方法，用于加载图像，在实例化StaticSprite后调用。
	 * 
	 * @param resources
	 *            资源，加载图像时需调用的资源
	 * 
	 * */
	public void load(Resources resources) {
		this.resource = resources;
		final TypedValue value = new TypedValue();
		resources.openRawResource(resId, value);
		final BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inTargetDensity = value.density;
		image = new SImage(BitmapFactory.decodeResource(resources, resId, opts));
		this.width = image.getWidth();
		this.height = image.getHeight();

	}

	/**
	 * 装载资源
	 * 
	 * @param si
	 *            图片资源
	 */
	public void load(SImage si) {
		image = si;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	/**
	 * 在确定精灵可播放后显式调用，用于切割图片，将其分为数帧图像。 分割后的帧按从左到右，自上到下依次排列。
	 * 
	 * @param row
	 *            分割的行数
	 * @param rank
	 *            分割的列数
	 * 
	 * */
	public void splitImage(int row, int rank) {
		frames = new SImage[row * rank];
		final int w = image.getWidth() / rank;
		final int h = image.getHeight() / row;
		int r = 0;
		int c = 0;
		for (int i = 0; i < row * rank; i++) {
			frames[i] = new SImage(Bitmap.createBitmap(image.getBitmap(), r, c,
					w, h));
			r += w;
			if (r >= image.getWidth()) {
				r = 0;
				c += h;
			}
		}
		this.width = w;
		this.height = h;

	}

	/**
	 * 开始精灵活动，启动精灵的活动。
	 * */
	public void start() {
		start = true;
	}

	/**
	 * 
	 * 绘制方法
	 * 
	 * @param canvas
	 *            将要绘制的画布
	 * @param paint
	 *            绘制用的画笔
	 * */
	public void onDraw(Canvas canvas, Paint paint) {
		if (canPlay) {
			play();
		}
		int alpha=paint.getAlpha();
		change(paint);
		if (scale) {
			canvas.drawBitmap(image.getBitmap(), null,
					new Rect(x, y, this.getWidth(), this.getHeight()), paint);
		} else {
			canvas.drawBitmap(image.getBitmap(), x, y, paint);
		}
		paint.setAlpha(alpha);
	}

	/**
	 * 
	 * 添加变化，添加之后不必显式的调用change方法，因为change方法已被draw方法调用。
	 * 
	 * @param change
	 *            指定的变化
	 * */
	public void addChanges(Change change) {
		changes.add(change);
	}

	/**
	 * 启动变化,对当前显示的图像进行变化
	 * 
	 * @param paint
	 *            需要改变的paint
	 * */
	public void change(Paint paint) {
		if (!start) {
			return;
		}
		if (!changes.isEmpty()) {
			final Change c = changes.get(0);
			c.startChange(paint);
			this.currentAlpha = paint.getAlpha();
			changes.remove(0);
		}
	}

	/**
	 * 移除指定的变化
	 * 
	 * @param change
	 *            指定的变化
	 * */
	public void removeChanges(Change change) {
		changes.remove(change);
	}

	/**
	 * 移除全部变化
	 * */
	public void removeAllChanges() {
		changes.clear();
	}

	/**
	 * 添加播放事件
	 * 
	 * @param play
	 *            指定的播放事件
	 * */
	public void addPlays(Play play) {
		play.setFrames(frames);
		plays.add(play);
	}

	/**
	 * 
	 * 控制播放，按播放事件的添加顺序依次播放。
	 * */
	public void play() {
		if (!start) {
			return;
		}
		if (nowPlay != null && nowPlay.isPlay()) {
			nowPlay.onContinue(this);
			setImage(nowPlay.getPresent());
			return;
		}
		if (plays == null || plays.isEmpty()) {
			return;
		}
		final Play p = plays.get(0);
		nowPlay = p;
		p.onStart();
		setImage(p.getPresent());
		plays.remove(0);
	}

	/**
	 * 移除指定的播放事件
	 * 
	 * @param play
	 *            指定的播放事件
	 * */
	public void removePlays(Play play) {
		plays.remove(play);
	}

	/**
	 * 停止精灵活动
	 * 
	 * 
	 * */
	public void stop() {
		this.start = false;
	}

	/**
	 * 释放现有资源
	 * */
	public void unload() {
		stop();
		image.dispose();
		for (SImage s : frames) {
			s.dispose();
		}
	}

	/**
	 * 得到当前透明度
	 * 
	 * @return 当前透明度
	 */
	public int getAlpha() {
		return currentAlpha;
	}

	public boolean isScale() {
		return scale;
	}

	public void setScale(boolean scale) {
		this.scale = scale;
	}
}
