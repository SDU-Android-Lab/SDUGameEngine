package org.sdu.android.control;

import org.sdu.android.control.window.UIAdapter;

import android.view.MotionEvent;

/**
 * ��Ϸ�¼�������
 * @author shadow
 * 
 */
public interface GameActionListener {
	
	/**
	 * �¼���Ӧ����
	 * @param event ��Ļ�¼�
	 */
	 void actionPerformed(UIAdapter ui,MotionEvent event);
}
