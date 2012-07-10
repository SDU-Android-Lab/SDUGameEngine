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
 * �����ƶ��ľ��飬����ʵ����ɫ��͸���ȵı仯�Լ�����Ч��.
 * 
 * 
 * 
 */

public class StaticSprite extends AbstractSprite implements Playable {
	/** Ĭ��͸���� */
	private static final int DEFAULT_ALPHA = 255;
	/** �����֡ͼ�� */
	protected SImage[] frames = null;
	/** �������ɫ��͸���ȱ仯�¼� */
	protected LinkedList<Change> changes = null;
	/** ����Ĳ����¼� */
	protected LinkedList<Play> plays = null;
	/** ��ǰ�Ĳ����¼� */
	protected Play nowPlay = null;
	/** ���ƾ����Ƿ����� */
	protected boolean start = false;
	/** ��ʶ�����Ƿ�ɲ��� */
	protected boolean canPlay;
	/** ��ǰ͸���� */
	protected int currentAlpha = DEFAULT_ALPHA;
	/** �Ƿ���ݰ�Χ������ */
	protected boolean scale = false;

	/**
	 * ���췽��
	 * 
	 * @param x
	 *            ����ڵ�ͼx����
	 * @param y
	 *            ����ڵ�ͼy����
	 * @param id
	 *            id
	 * @param resId
	 *            ͼ����Դ�ı�ʶ
	 * @param canPlay
	 *            �����Ƿ�ɲ���
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
	 * ���췽��
	 * 
	 * @param x
	 *            ����ڵ�ͼx����
	 * @param y
	 *            ����ڵ�ͼy���� 
	 * @param id
	 *            id
	 * @param canPlay
	 *            �����Ƿ�ɲ���
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
	 * װ����Դ�ķ��������ڼ���ͼ����ʵ����StaticSprite����á�
	 * 
	 * @param resources
	 *            ��Դ������ͼ��ʱ����õ���Դ
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
	 * װ����Դ
	 * 
	 * @param si
	 *            ͼƬ��Դ
	 */
	public void load(SImage si) {
		image = si;
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	/**
	 * ��ȷ������ɲ��ź���ʽ���ã������и�ͼƬ�������Ϊ��֡ͼ�� �ָ���֡�������ң����ϵ����������С�
	 * 
	 * @param row
	 *            �ָ������
	 * @param rank
	 *            �ָ������
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
	 * ��ʼ��������������Ļ��
	 * */
	public void start() {
		start = true;
	}

	/**
	 * 
	 * ���Ʒ���
	 * 
	 * @param canvas
	 *            ��Ҫ���ƵĻ���
	 * @param paint
	 *            �����õĻ���
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
	 * ��ӱ仯�����֮�󲻱���ʽ�ĵ���change��������Ϊchange�����ѱ�draw�������á�
	 * 
	 * @param change
	 *            ָ���ı仯
	 * */
	public void addChanges(Change change) {
		changes.add(change);
	}

	/**
	 * �����仯,�Ե�ǰ��ʾ��ͼ����б仯
	 * 
	 * @param paint
	 *            ��Ҫ�ı��paint
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
	 * �Ƴ�ָ���ı仯
	 * 
	 * @param change
	 *            ָ���ı仯
	 * */
	public void removeChanges(Change change) {
		changes.remove(change);
	}

	/**
	 * �Ƴ�ȫ���仯
	 * */
	public void removeAllChanges() {
		changes.clear();
	}

	/**
	 * ��Ӳ����¼�
	 * 
	 * @param play
	 *            ָ���Ĳ����¼�
	 * */
	public void addPlays(Play play) {
		play.setFrames(frames);
		plays.add(play);
	}

	/**
	 * 
	 * ���Ʋ��ţ��������¼������˳�����β��š�
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
	 * �Ƴ�ָ���Ĳ����¼�
	 * 
	 * @param play
	 *            ָ���Ĳ����¼�
	 * */
	public void removePlays(Play play) {
		plays.remove(play);
	}

	/**
	 * ֹͣ����
	 * 
	 * 
	 * */
	public void stop() {
		this.start = false;
	}

	/**
	 * �ͷ�������Դ
	 * */
	public void unload() {
		stop();
		image.dispose();
		for (SImage s : frames) {
			s.dispose();
		}
	}

	/**
	 * �õ���ǰ͸����
	 * 
	 * @return ��ǰ͸����
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
