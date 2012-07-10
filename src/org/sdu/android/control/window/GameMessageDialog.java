package org.sdu.android.control.window;

import org.sdu.android.SystemData;
import org.sdu.android.util.graphicsUtil.Rect;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.MotionEvent;

/***
 * 游戏交谈控件
 * 
 * @author shadow
 * 
 */
public class GameMessageDialog extends UIAdapter {

	/**
	 * 串行标识
	 */
	private static final long serialVersionUID = 5433786074606263309L;
	/** 对话框x坐标 */
	private int x;
	/** 对话框y坐标 */
	private int y;
	/** 对话框宽度 */
	private int weight;
	/** 对话框高度 */
	private int height;
	/** 默认底色 */
	public static final int DEFAULT_COLOR_1 = 0x70000000;
	/** 默认底色 */
	public static final int DEFAULT_COLOR_2 = 0x70ff0000;
	/** outR */
	final int outR = 12;
	/** inset */
	final int insetR = 7;
	/** cx */
	final static int CX = 150;
	/** cy */
	final static int CY = 25;
	/** Shader */
	private Shader shader = null;
	/** Default shader */
	final static Shader DEFAULT_SHADER = new SweepGradient(CX, CY, new int[] {
			DEFAULT_COLOR_1, DEFAULT_COLOR_2 }, null);
	/** 矩形边框 */
	ShapeDrawable mDrawable;
	/** 默认透明度 */
	static final int DEFAULT_ALPHA = 255;
	/** 透明度 */
	int alpha = DEFAULT_ALPHA;
	/** 默认字体大小 */
	static final int DEFAULT_TEXT_SIZE = 20;
	/** 字体大小 */
	int textSize = DEFAULT_TEXT_SIZE;
	/** 画笔 */
	Paint p;
	/** text */
	private String text = "";
	/** text1 */
	private String[] tempText;
	/** 计数器 */
	private int timer = 0;
	/** 行间隔 */
	private int space;
	/** 文本框最大容量 */
	private int maxSize;
	/** 文本框单行容量 */
	private int lineSize;
	/** 文本框最大 */
	static final int LINENUM = 3;
	/** 默认文本速度 */
	static final int DEFAULT_SPEED = 10;
	/** 文本速度 */
	int speed = DEFAULT_SPEED;
	/** 显示完成 */
	boolean finish = false;
	/** 标注对话框消失 */
	private boolean dispose = false;

	/**
	 * 构造交谈控件，使用屏幕宽度置于屏幕中央,使用默认着色方式（两颜色中心辐射）
	 * 
	 * @param id
	 *            id号
	 */
	public GameMessageDialog(int id) {
		this(id, null);
	}

	/**
	 * 构造交谈控件，使用屏幕宽度置于屏幕中央,使用自定义着色方式
	 * 
	 * @param id
	 *            id号
	 * @param shader
	 *            颜色着色方式
	 */
	public GameMessageDialog(int id, Shader shader) {
		super(id);
		this.x = 0;
		this.y = SystemData.getActivityHeight() / 2;
		this.weight = SystemData.getActivityWidth();
		this.height = SystemData.getActivityHeight() / 2 / 2;
		this.shader = shader;
		p = new Paint();
		p.setAntiAlias(true);
		p.setTextSize(DEFAULT_TEXT_SIZE);
		p.setColor(Color.BLACK);
		space = this.y / 2 / 2 / 2;
		setText(this.text);
	}

	/**
	 * 绘制方法,绘制文字和图框
	 * 
	 * @param c
	 *            画布
	 */
	@Override
	public void draw(Canvas c) {
		update();
		if (isVisible) {
			timer++;
			getShape().draw(c);
			drawText(c);
			if (dispose) {
				dispose(c);
			}
		}
	}

	/**
	 * 绘制文字
	 * 
	 * @param c
	 *            画布
	 */
	private void drawText(Canvas c) {
		p.setAlpha(alpha);
		String temp = text;
		if (timer / speed < tempText[0].length()) {
			temp = tempText[0].substring(0, timer / speed);
			c.drawText(temp, x + weight / 2 / 2 / 2/ 2, y + space, p);
		} else if (timer / speed < tempText[0].length() + tempText[1].length()) {
			temp = tempText[1].substring(0,timer / speed - tempText[0].length());
			c.drawText(tempText[0], x + weight / 2 / 2 / 2/ 2, y + space, p);
			c.drawText(temp, x + weight / 2 / 2 / 2/ 2, y + 2 * space, p);
		} else if (timer / speed < tempText[0].length() + tempText[1].length()+ tempText[2].length()) {
			temp = tempText[2].substring(0, timer / speed - tempText[0].length()- tempText[1].length());
			c.drawText(tempText[0], x + weight / 2 / 2 / 2/ 2, y + space, p);
			c.drawText(tempText[1], x + weight / 2 / 2 / 2/ 2, y + 2 * space, p);
			c.drawText(temp, x + weight / 2 / 2 / 2/ 2, y + space + space + space,
					p);
		} else {
			if (tempText[0] != null) {
				c.drawText(tempText[0], x + weight / 2 / 2 / 2/2, y + space, p);
			}
			if (tempText[1] != null) {
				c.drawText(tempText[1], x + weight / 2 / 2 / 2/2, y + 2 * space,
						p);
			}
			if (tempText[2] != null) {
				c.drawText(tempText[2], x + weight / 2 / 2 / 2/2, y + space+ space + space, p);
			}
			if (!text.equals("")) {
				c.drawText("▼", x + weight / 2, y + space * 2 * 2, p);
			}
			finish = true;
			speed = DEFAULT_SPEED;
		}
	}

	/**
	 * @return the alpha
	 */
	public int getAlpha() {
		return alpha;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 得到对话框矩形边框
	 * 
	 * @return 矩形边框
	 */
	private ShapeDrawable getShape() {
		if (mDrawable == null) {
			final float[] outerR = new float[] { outR, outR, outR, outR, 0, 0,
					0, 0 };
			final RectF inset = new RectF(insetR, insetR, insetR, insetR);
			mDrawable = new ShapeDrawable(new RoundRectShape(outerR, inset,
					null));
			mDrawable.getPaint().setShader(makeSweep());
			final PathEffect pe = new DiscretePathEffect(10, 4);
			final PathEffect pe2 = new CornerPathEffect(4);
			mDrawable.getPaint().setPathEffect(new ComposePathEffect(pe2, pe));
			mDrawable.setBounds(x, y, x + this.weight, y + this.height);
		}
		mDrawable.setAlpha(alpha);
		return mDrawable;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * 着色方案
	 * 
	 * @return 着色色彩
	 */
	private Shader makeSweep() {
		if (this.shader != null) {
			return shader;
		}
		return DEFAULT_SHADER;
	}

	/**
	 * @param alpha
	 *            the alpha to set
	 */
	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the textSize
	 */
	public int getTextSize() {
		return textSize;
	}

	/**
	 * @param textSize
	 *            the textSize to set
	 */
	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}

	/**
	 * 设置显示文本
	 * 
	 * @param t
	 *            the text to set
	 */
	public void setText(String t) {		
		tempText = new String[LINENUM];		
		this.text = t;
		if(text.equals("")){
		text=" ";	
		}
		String temp = text;
		final float[] wArr = new float[text.length()];
		p.getTextWidths(temp, wArr);
		float w = 0;
		for (int i = 0; i < wArr.length; i++) {
			w += wArr[i];
		}
		lineSize = (int) (weight * (2 + 1) / 2 / 2 / (w / temp.length()))-2-2;
		maxSize = lineSize * LINENUM;
		if (text.length() > maxSize) {
			temp = text.substring(0, maxSize);
			text = text.substring(maxSize);
		} else {
			text = "";
		}
		for (int i = 0; i < maxSize / lineSize; i++) {
			if (temp.length() > lineSize) {
				tempText[i] = temp.substring(0, lineSize);
				temp = temp.substring(lineSize);
			} else {
				if (temp == null || temp.equals("")) {
					tempText[i] = "";
				} else {
					tempText[i] = temp;
					temp = "";
				}
			}
		}
	}

	/**
	 * 对话框消失
	 */
	public void dispose() {
		this.dispose = true;
	}

	/**
	 * 对话框消失
	 * 
	 * @param c
	 *            画布
	 */
	private void dispose(Canvas c) {
		if (timer % speed == 0) {
			this.alpha -= speed * 2 * 2 - speed;
		}
		if (this.alpha <= 0) {
			this.setVisible(false);
		}
	}

	/**
	 * 点击对话框
	 * 
	 * @param event
	 *            触屏事件
	 * @see org.sdu.android.control.window.UIAdapter#onPress(android.view.MotionEvent)
	 */
	@Override
	public void onPress(MotionEvent event) {
		if (finish) {
			if (text == null || text.equals("")) {
				dispose();
			} else {
				this.setText(text);
				timer = 0;
				finish = false;
			}
		}
		// else {
		// speed = 1;
		// }
	}

	/**
	 * 包围盒
	 * 
	 * @return 包围盒
	 * @see org.sdu.android.sprite.AbstractSprite#getRect()
	 */
	@Override
	public Rect getRect() {
		return new Rect(x, y, height, width);
	}

	/**
	 * 是否在响应区
	 * 
	 * @param x
	 *            x
	 * @param y
	 *            y
	 * @return true/false
	 * @see org.sdu.android.control.window.UIAdapter#isIn(float, float)
	 */
	@Override
	public boolean isIn(float x, float y) {
		return true;
	}
}
