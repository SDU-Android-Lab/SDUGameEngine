package org.sdu.android.control;

import org.sdu.android.control.window.GameChoice;

import android.view.MotionEvent;

/**
 * ��Ϸ�¼�������
 * @author shadow
 * 
 */
public interface GameChoiceListener {
	
	/**
	 * �¼���Ӧ����
	 * @param event ��Ļ�¼�
	 */
	 void actionPerformed(GameChoice gChoice,int selected,MotionEvent event);
}
