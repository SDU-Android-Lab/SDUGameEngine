package org.sdu.android.control;

import org.sdu.android.SystemData;

//import android.util.Log;
import android.view.MotionEvent;

/**
 * 操作监听类
 * @author shadow
 *
 */
public class ControlListener {
	/**事件锁*/
	byte[] lock = new byte[0];
	/**
	 * 处理触屏事件
	 * @param event 触屏事件
	 * @return 恒为true值
	 */
	public boolean onTouchEvent(MotionEvent event){
		 if (event.getAction() == MotionEvent.ACTION_DOWN) {
			 touchDown(event);
	        } else if (event.getAction() == MotionEvent.ACTION_UP) {  
	         touchUp(event);
	        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {  
	         touchMove(event);
	        }  
	        synchronized (lock) {  
	            try {  
	                lock.wait(SystemData.getSleepTime());  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	        }  
		return true;
	}
	/**
	 * 对触屏按下的响应
	 * @param event 触屏事件
	 */
	public void touchDown(MotionEvent event){
		//Log.e("touchDonw",""+event.getX()+" "+event.getY());
		if(SystemData.getUiManager().dealTouchDownAction(event)){
			return;
		}
		//TODO 派送至Scene下层
	}
	/**
	 * 对触屏弹起的响应
	 * @param event 触屏事件
	 */
	public void touchUp(MotionEvent event){
		//Log.e("touchUp",""+event.getX()+", "+event.getY());
		if(SystemData.getUiManager().dealTouchUpAction(event)){
			return;
		}
		//TODO 派送至Scene下层
	}
	/**
	 * 对在触屏上移动的响应
	 * @param event 触屏事件
	 */
	public void touchMove(MotionEvent event){
		//Log.e("touchMove",""+event.getX()+","+event.getY());
		if(SystemData.getUiManager().dealTouchDragAction(event)){
			return;
		}
		//TODO 派送至Scene下层
	}
}
