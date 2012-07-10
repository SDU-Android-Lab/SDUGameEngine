package org.sdu.android.control;

import org.sdu.android.control.window.GameChoice;

import android.view.MotionEvent;

/**
 * 游戏事件监听器
 * @author shadow
 * 
 */
public interface GameChoiceListener {
	
	/**
	 * 事件响应方法
	 * @param event 屏幕事件
	 */
	 void actionPerformed(GameChoice gChoice,int selected,MotionEvent event);
}
