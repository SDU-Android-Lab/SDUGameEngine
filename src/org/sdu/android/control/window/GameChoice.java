/**
 * 
 */
package org.sdu.android.control.window;

import java.util.ArrayList;

import org.sdu.android.control.GameChoiceListener;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.view.MotionEvent;

/**
 * 选项框
 * @author shadow
 * 
 */
public class GameChoice extends UIAdapter {

	private UIFont font;
	private String[] choice;
	private int selectedIndex = 0;
	private int choice_weight;
	private int choice_height;
	private int choice_space;
	private Paint paint;
	private GameChoiceListener actionListener;

	public ArrayList<Rect> rectList;
	
	
	/**
	 * @param id
	 */
	public GameChoice(int id) {
		super(id);
	}

	public GameChoice(int id, UIFont font, String[] choice, int x, int y) {
		this(id);
		this.font = font;
		this.choice = choice;
		this.x = x;
		this.y = y;
	}

	@Override
	public synchronized void draw(Canvas canvas) {
		update();
		if (isVisible) {
			super.draw(canvas, paint);
		}
	}

	@Override
	public void update() {
		if (image == null) {
			load();
			return;
		}
		final Canvas canvas = new Canvas(image.getBitmap());
		for (int i = 0; i < choice.length; i++) {
			String str = choice[i];
			if (rectList.size() < choice.length) {
				Rect r=new Rect(font.getSize()/4, (i + 1) * choice_space - choice_height,
						 choice_weight+font.getSize()/4,(i + 2) * choice_space - choice_height);
				canvas.drawRect(r, paint);
				rectList.add(r);
			}
			canvas.drawText(str, font.getSize()/4, (i + 1) * choice_space, paint);
		}
	}

	public void load() {
		rectList = new ArrayList<Rect>();
		for (int i = 0; i < choice.length; i++) {
			choice_weight = Math
					.max(choice_weight, font.stringWidth(choice[i]));
		}
		this.choice_height = font.getHeight();
		this.choice_space = choice_height + font.getSize() / 2;
		this.height = choice_space * (choice.length)+ font.getSize();
		this.width =choice_weight + font.getSize()/2;
		paint=new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setStyle(Style.STROKE);
		paint.setTextSize(font.getTypefacePaint().getTextSize());
		paint.setColor(Color.RED);
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
	public void setActionListener(GameChoiceListener actionListener) {
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
		for (int i = 0; i < rectList.size(); i++) {
			if (isPointIn(rectList.get(i),prex,prey)) {
				this.selectedIndex=i;
				if(this.actionListener!=null){
					this.actionListener.actionPerformed(this,selectedIndex, event);
				}
				break;
			}
		}
		this.selectedIndex = -1;
	}


	/**
	 * @return the choice
	 */
	public String[] getChoice() {
		return choice;
	}

	/**
	 * @param choice the choice to set
	 */
	public void setChoice(String[] choice) {
		this.choice = choice;
	}
	public Shader getShader(){
	return new SweepGradient(0, 0, new int[] {
			Color.BLACK,Color.WHITE}, null);
	}
	public String getSelectedText(){
		return choice[selectedIndex];
	}
}
