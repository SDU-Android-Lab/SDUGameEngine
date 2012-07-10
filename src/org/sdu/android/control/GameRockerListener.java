package org.sdu.android.control;

import android.view.MotionEvent;

/**
 * 游戏摇杆监听器
 * @author shadow
 * 
 */
public interface GameRockerListener {
	/**
	 * 摇杆向上的响应
	 * @param event 屏幕事件
	 */
	 void actionUp(MotionEvent event);
	 /**
	  * 摇杆向下的响应
	  * @param event 屏幕事件
	  */
	 void actionDown(MotionEvent event);
	 /**
      * 摇杆向左的响应
      * @param event 屏幕事件
      */
	 void actionLeft(MotionEvent event);
	 /**
	  * 摇杆向右的响应
	  * @param event 屏幕事件
	  */
	 void actionRight(MotionEvent event);
}
