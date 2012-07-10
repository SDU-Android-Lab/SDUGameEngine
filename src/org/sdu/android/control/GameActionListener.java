package org.sdu.android.control;

import org.sdu.android.control.window.UIAdapter;

import android.view.MotionEvent;

/**
 * 游戏事件监听器
 * @author shadow
 * 
 */
public interface GameActionListener {
	
	/**
	 * 事件响应方法
	 * @param event 屏幕事件
	 */
	 void actionPerformed(UIAdapter ui,MotionEvent event);
}
