package org.sdu.android.control;

import android.view.MotionEvent;

/**
 * ��Ϸҡ�˼�����
 * @author shadow
 * 
 */
public interface GameRockerListener {
	/**
	 * ҡ�����ϵ���Ӧ
	 * @param event ��Ļ�¼�
	 */
	 void actionUp(MotionEvent event);
	 /**
	  * ҡ�����µ���Ӧ
	  * @param event ��Ļ�¼�
	  */
	 void actionDown(MotionEvent event);
	 /**
      * ҡ���������Ӧ
      * @param event ��Ļ�¼�
      */
	 void actionLeft(MotionEvent event);
	 /**
	  * ҡ�����ҵ���Ӧ
	  * @param event ��Ļ�¼�
	  */
	 void actionRight(MotionEvent event);
}
