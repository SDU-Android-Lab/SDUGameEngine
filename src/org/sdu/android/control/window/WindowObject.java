package org.sdu.android.control.window;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * window组件接口
 * @author shadow
 *
 */
public interface WindowObject {
    /**
     * 被按压
     * @param event 屏幕事件
     */
	void onPress(MotionEvent event);
	/**
	 * 被释放
	 * @param event 屏幕事件
	 */
	void onRelease(MotionEvent event);
	/**
	 * 被拖拽
	 * @param event 屏幕事件
	 */
	void onDrag(MotionEvent event);
	/**
	 * 是否可获取焦点
	 * @return 是否可以获取焦点 是 true，否 false
	 */
	boolean isFocusable();
	/**
	 * 设置组件是否可以获取焦点
	 * @param canFocus 是 true，否 false
	 */
	void setFocusable(boolean canFocus);
	/**
	 * 是否可拖动
	 * @param canDrag 可拖动 true，不可拖动false
	 */
	void setDragable(boolean canDrag);
	/**
	 * 组件是否可见
	 * @param isVisible 可见 true，不可见 false
	 */
	void setVisible(boolean isVisible);
	/**
	 * 绘制组件
	 * @param c 组件在此canvas上绘制
	 */
	void draw(Canvas c);
	/**
	 * 更新组件信息
	 */
	void update();
	/**
	 * 判断点p是否在按钮的包围盒内
	 * @param x 点x坐标
	 * @param y 点y坐标
	 * @return 在 true,不在 false
	 */
	boolean isIn(float x,float y);
	/**
	 * 响应事件
	 * @param event 响应事件
	 * @return 响应事件是否被捕获
	 */
	boolean actionPerformed(MotionEvent event);
	/**
	 * 设置状态
	 * @param s 状态数 0为常态
	 */
	void setCurrentState(int s);
	/**
	 * 得到状态
	 * @return 状态数 0为常态
	 */
	int getCurrentState();
}
