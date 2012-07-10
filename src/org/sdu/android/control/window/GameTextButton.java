/**
 * 
 */
package org.sdu.android.control.window;

import org.sdu.android.control.GameActionListener;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * 选项框
 * 
 * @author shadow
 * 
 */
public class GameTextButton extends UIAdapter {

	private UIFont font;
	private String text;
	private int choice_weight;
	private int choice_height;
	private int choice_space;
	private Paint paint;
	private GameActionListener actionListener;
	/** 默认底色 1 */
	public static final int DEFAULT_COLOR_1 = 0x70000000;
	/** 默认底色 2 */
	public static final int DEFAULT_COLOR_2 = 0x70ff0000;
	public Rect rect;

	/**
	 * @param id
	 */
	public GameTextButton(int id) {
		super(id);
		this.font = UIFont.getFont("Monospaced", 0,24);
		this.text = "";
		this.x = 0;
		this.y = 0;
	}

	public GameTextButton(int id, UIFont font, String text) {
		this(id);
		this.font = font;
		this.text = text;
		this.x = 0;
		this.y = 0;
	}
	public GameTextButton(int id, UIFont font, String text, int x, int y) {
		this(id);
		this.font = font;
		this.text = text;
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Canvas canvas) {
		update();
		if (isVisible) {
			super.draw(canvas, paint);
		}
	}

	@Override
	public void update() {
		if (image == null) {
			load();
		}
		final Canvas canvas = new Canvas(image.getBitmap());
		String str = text;
		if (rect == null) {
			rect = new Rect(font.getSize()/4, choice_space - choice_height,
					 choice_weight+font.getSize()/4,2 * choice_space - choice_height);
			canvas.drawRect(rect, paint);
		}
		canvas.drawText(str, font.getSize() / 4, choice_space, paint);
	}

	public void load() {
		choice_weight = Math.max(choice_weight, font.stringWidth(text));
		this.choice_height = font.getHeight();
		this.choice_space = choice_height + font.getSize() / 2;
		this.height = choice_space + font.getSize();
		this.width =choice_weight + font.getSize()/2;
		paint=new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setStyle(Style.STROKE);
		paint.setTextSize(font.getTypefacePaint().getTextSize());
		paint.setColor(Color.WHITE);
		image=UIBitmapFactory.creatImage(width, height, null);
	}

	@Override
	public boolean isIn(float x, float y) {
		if (x > this.x && x < this.x + this.getWidth()) {
			if (y > this.y && y < this.y + this.getHeight()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param actionListener
	 *            the actionListener to set
	 */
	public void setActionListener(GameActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/**
	 * 被按下
	 * 
	 * @param event
	 *            触屏事件
	 */
	public void onPress(MotionEvent event) {

	}

	/**
	 * 被释放
	 * 
	 * @param event
	 *            触屏事件
	 */
	public void onRelease(MotionEvent event) {
		float prex = event.getX();
		float prey = event.getY();
		if (isPointIn(rect, prex, prey)) {
			if (this.actionListener != null) {
				this.actionListener.actionPerformed(this, event);
			}
		}
	}


	/**
	 * @return the choice
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param choice
	 *            the choice to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
