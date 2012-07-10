package org.sdu.android.control.window;

import org.sdu.android.control.GameActionListener;
import org.sdu.android.util.graphicsUtil.Rect;
import org.sdu.android.util.graphicsUtil.SImage;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * 游戏按钮类
 * 
 * @author shadow
 * 
 */
public class GameButton extends UIAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6135078682737161738L;
	/** 是否可获得焦点 */
	private boolean isFocusable = true;
	/** 是否可被拖拽 */
	private boolean isDragable = false;
	/** 当前状态代号 */
	private int currentState;
	/** 事件监听器 */
	private GameActionListener actionListener;
	/** 常态代号，0 */
	public final static int NORMAL = 0;
	/** 被按下 代号，1 */
	public final static int PRESSED = 1;
	/** 失去焦点代号，2 */
	public final static int LOSEFOCUS = 2;
	/**图片数组*/
	public SImage[] bitsp;
	/**
	 * GameButton按钮构造方法
	 * 
	 * @param id
	 *            按钮标识
	 * @param bitsp
	 *            图片序列 常态、按下、失去焦点三种状态
	 * @param x
	 *            按钮x坐标
	 * @param y
	 *            按钮y坐标
	 */
	public GameButton(int id, SImage[] bitsp, int x, int y) {
		super(id);
		this.bitsp=bitsp;
		this.setX(x);
		this.setY(y);
		final Rect r=new Rect();
		r.setLocation(x, y);
		r.setRectangle(bitsp[0].getHeight(), bitsp[0].getWidth());
		this.setBox(r);
	}
	/**
	 * 自动切分图片的按钮
	 * @param id 按钮编号
	 * @param image 图片
	 * @param x x坐标
	 * @param y y坐标
	 */
	public GameButton(int id,SImage image,int x,int y){
		super(id);
		this.setImage(image);
		this.splitImage(1, 2+1);
		this.setX(x);
		this.setY(y);
		bitsp=frames;
		final Rect r=new Rect();
		r.setLocation(x, y);
		r.setRectangle(bitsp[0].getHeight(), bitsp[0].getWidth());
		this.setBox(r);
	}

	/**
	 * 被按下
	 * 
	 * @param event
	 *            触屏事件
	 */
	public void onPress(MotionEvent event) {
		setCurrentState(PRESSED);
	};

	/**
	 * 被释放
	 * 
	 * @param event
	 *            触屏事件
	 */
	public void onRelease(MotionEvent event) {
		if (actionListener != null) {
			actionListener.actionPerformed(this,event);
		} else {
			actionPerformed(event);
		}
		setCurrentState(NORMAL);
	}

	/**
	 * 被拖拽
	 * 
	 * @param event
	 *            触屏事件
	 */
	public void onDrag(MotionEvent event) {
		if (!isDragable) {
			return;
		}
		setCurrentState(PRESSED);
	}

	/**
	 * 是否可获取焦点
	 * 
	 * @return 是否可以获取焦点 是 true，否 false
	 */
	public boolean isFocusable() {
		return isFocusable;
	}

	/**
	 * 是否可获取焦点
	 * 
	 * @return the isDragable
	 */
	public boolean isDragable() {
		return isDragable;
	}

	/**
	 * 设置组件是否可以获取焦点
	 * 
	 * @param canFocus
	 *            是 true，否 false
	 */
	public void setFocusable(boolean canFocus) {
	}

	/**
	 * 是否可拖动
	 * 
	 * @param canDrag
	 *            可拖动 true，不可拖动false
	 */
	public void setDragable(boolean canDrag) {
		isDragable = canDrag;
	}


	/**
	 * 绘制按钮
	 * 
	 * @param canvas
	 *            在canvas上绘制按钮
	 */
	public void draw(Canvas canvas) {
		update();
		if (isVisible) {
			super.draw(canvas);
		}
	}

	/**
	 * 更新按钮信息
	 */
	@Override
	public void update() {
		goToIndex(getCurrentState());

	}

	/**
	 * @param index 图片编号
	 */
	private void goToIndex(int index) {
		super.load(bitsp[index]);
	}

	/**
	 * 设置当前状态号
	 * 
	 * @param currentState
	 *            当前状态号 0正常 1按下 2失去焦点
	 */
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	/**
	 * 得到当前状态号
	 * 
	 * @return 当前状态号 0正常 1按下 2失去焦点
	 */
	public int getCurrentState() {
		return currentState;
	}

	/**
	 * 判断某点是否在按钮内部
	 * 
	 * @param x
	 *            点x坐标
	 * @param y
	 *            点y坐标
	 * @return 是true 否 false
	 */
	@Override
	public boolean isIn(float x, float y) {
		if(x>this.x&&x<this.x+this.bitsp[0].getWidth()){
			if(y>this.y&&y<this.y+this.bitsp[0].getHeight()){
				return true;
			}
		}
		return false;
	}

	/**
	 * 按钮相应事件处理 请重载实现
	 * @param event 屏幕事件
	 * @return 事件是否被捕获
	 */
	@Override
	public boolean actionPerformed(MotionEvent event) {
		return true;
	}

	/**
	 * 设置GameActionListener
	 * 
	 * @param actionListener
	 *            需设置的GameActionListener
	 */
	public void setActionListener(GameActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/**
	 * 获取GameActionListener
	 * 
	 * @return 当前的GameActionListener
	 */
	public GameActionListener getActionListener() {
		return actionListener;
	}
}
