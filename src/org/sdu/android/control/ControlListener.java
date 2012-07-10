package org.sdu.android.control;

import org.sdu.android.SystemData;

//import android.util.Log;
import android.view.MotionEvent;

/**
 * ����������
 * @author shadow
 *
 */
public class ControlListener {
	/**�¼���*/
	byte[] lock = new byte[0];
	/**
	 * �������¼�
	 * @param event �����¼�
	 * @return ��Ϊtrueֵ
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
	 * �Դ������µ���Ӧ
	 * @param event �����¼�
	 */
	public void touchDown(MotionEvent event){
		//Log.e("touchDonw",""+event.getX()+" "+event.getY());
		if(SystemData.getUiManager().dealTouchDownAction(event)){
			return;
		}
		//TODO ������Scene�²�
	}
	/**
	 * �Դ����������Ӧ
	 * @param event �����¼�
	 */
	public void touchUp(MotionEvent event){
		//Log.e("touchUp",""+event.getX()+", "+event.getY());
		if(SystemData.getUiManager().dealTouchUpAction(event)){
			return;
		}
		//TODO ������Scene�²�
	}
	/**
	 * ���ڴ������ƶ�����Ӧ
	 * @param event �����¼�
	 */
	public void touchMove(MotionEvent event){
		//Log.e("touchMove",""+event.getX()+","+event.getY());
		if(SystemData.getUiManager().dealTouchDragAction(event)){
			return;
		}
		//TODO ������Scene�²�
	}
}
