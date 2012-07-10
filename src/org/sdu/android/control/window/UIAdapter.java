package org.sdu.android.control.window;

import org.sdu.android.SystemData;
import org.sdu.android.sprite.StaticSprite;
import org.sdu.android.util.graphicsUtil.Point;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * UI适配器,继承DrawableObject，实现WindowObject
 * 
 * @author shadow
 * 
 */
public class UIAdapter extends StaticSprite implements WindowObject {

	/**
	 * 串行版本号
	 */
	private static final long serialVersionUID = 4742586904638847771L;
	/**
	 * 是否可获取焦点
	 */
	private boolean canFocus = true;
	/**
	 * 是否可拖拽
	 */
	private boolean canDrag = false;
	/**
	 * 是否可见
	 */
	protected boolean isVisible = true;

	/**
	 * 默认画笔
	 */
	private final Paint defaultPaint = new Paint();
	/**
	 * 画笔
	 */
	private Paint p;

	/**
	 * 构造适配器，设置控件id，设为不可播放
	 * 
	 * @param id
	 *            id号
	 */
	public UIAdapter(int id) {
		super(id, false);
	}

	/**
	 * 得到控件ID号
	 * 
	 * @return id号
	 */
	public int getId() {
		return this.getResId();
	}

	/**
	 * 构造适配器，设置id，设置是否可播放
	 * 
	 * @param id
	 *            id号
	 * @param playable
	 *            是否可播放
	 */
	public UIAdapter(int id, boolean playable) {
		super(id, playable);
	}

	/**
	 * @param event
	 *            事件 按下响应
	 */
	public void onPress(MotionEvent event) {

	}

	/**
	 * @param event
	 *            事件 弹起响应
	 */
	@Override
	public void onRelease(MotionEvent event) {

	}

	/**
	 * @param event
	 *            事件 拖拽响应
	 */
	@Override
	public void onDrag(MotionEvent event) {

	}

	/**
	 * 是否可获取焦点
	 * 
	 * @return true/false
	 */
	@Override
	public boolean isFocusable() {
		return canFocus;
	}

	/**
	 * 设置是否可获取焦点
	 * 
	 * @param canFocus
	 *            true/false
	 */
	@Override
	public void setFocusable(boolean canFocus) {
		this.canFocus = canFocus;
	}

	/**
	 * 设置是否可拖拽
	 * 
	 * @param canDrag
	 *            是否可拖拽
	 */
	@Override
	public void setDragable(boolean canDrag) {
		this.canDrag = canDrag;
	}

	/**
	 * 设置是否可见
	 * 
	 * @param isVisible
	 *            true/false
	 * @see org.sdu.android.control.window.WindowObject#setVisible(boolean)
	 */

	@Override
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		if (this.isVisible) {
			SystemData.getCurrentComponentLevel().add(this);
		} else {
			SystemData.getCurrentComponentLevel().remove(this);
			System.gc();
		}
	}

	/**
	 * 是否可拖拽
	 * 
	 * @return the canDrag true/false
	 */
	public boolean isDragable() {
		return canDrag;
	}

	/**
	 * 更新方法
	 * 
	 * @see org.sdu.android.control.window.WindowObject#update()
	 */

	@Override
	public void update() {

	}

	/**
	 * x,y位置的事件是否在控件内部，默认采用矩形包围盒
	 * 
	 * @param x
	 *            事件横坐标
	 * @param y
	 *            事件纵坐标
	 * @return 是否在控件内部
	 * @see org.sdu.android.control.window.WindowObject#isIn(float, float)
	 */
	@Override
	public boolean isIn(float x, float y) {
		if (this.getRect() != null) {
			return this.getRect().isPointIn(new Point(x, y));
		} else {
			return false;
		}
	}

	/**
	 * 点击事件
	 * 
	 * @param event
	 *            按键位置
	 * @return 事件被响应 true , 否则 false
	 * @see org.sdu.android.control.window.WindowObject#actionPerformed(android.view.MotionEvent)
	 */

	@Override
	public boolean actionPerformed(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 设置当前状态
	 * 
	 * @param s
	 *            状态号
	 * @see org.sdu.android.control.window.WindowObject#setCurrentState(int)
	 */

	@Override
	public void setCurrentState(int s) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取当前状态
	 * 
	 * @return 状态号 int
	 * @see org.sdu.android.control.window.WindowObject#getCurrentState()
	 */

	@Override
	public int getCurrentState() {
		return 0;
	}

	/**
	 * 绘图
	 * 
	 * @param c
	 *            画布
	 * @see org.sdu.android.control.window.WindowObject#draw(android.graphics.Canvas)
	 */
	@Override
	public void draw(Canvas c) {
		if (p != null) {
			onDraw(c, p);
		} else {
			onDraw(c, defaultPaint);
		}
	}

	public void draw(Canvas c, Paint p) {
		onDraw(c, p);

	}
	
	public boolean isPointIn(Rect r, float x, float y) {
		if(x>=this.x+r.left&&x<=this.x+r.right&&y>=this.y+r.top&&y<=this.y+r.bottom){
			return true;
		}
		return false;
	}
}
