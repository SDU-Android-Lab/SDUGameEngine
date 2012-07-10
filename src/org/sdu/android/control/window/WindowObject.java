package org.sdu.android.control.window;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * window����ӿ�
 * @author shadow
 *
 */
public interface WindowObject {
    /**
     * ����ѹ
     * @param event ��Ļ�¼�
     */
	void onPress(MotionEvent event);
	/**
	 * ���ͷ�
	 * @param event ��Ļ�¼�
	 */
	void onRelease(MotionEvent event);
	/**
	 * ����ק
	 * @param event ��Ļ�¼�
	 */
	void onDrag(MotionEvent event);
	/**
	 * �Ƿ�ɻ�ȡ����
	 * @return �Ƿ���Ի�ȡ���� �� true���� false
	 */
	boolean isFocusable();
	/**
	 * ��������Ƿ���Ի�ȡ����
	 * @param canFocus �� true���� false
	 */
	void setFocusable(boolean canFocus);
	/**
	 * �Ƿ���϶�
	 * @param canDrag ���϶� true�������϶�false
	 */
	void setDragable(boolean canDrag);
	/**
	 * ����Ƿ�ɼ�
	 * @param isVisible �ɼ� true�����ɼ� false
	 */
	void setVisible(boolean isVisible);
	/**
	 * �������
	 * @param c ����ڴ�canvas�ϻ���
	 */
	void draw(Canvas c);
	/**
	 * ���������Ϣ
	 */
	void update();
	/**
	 * �жϵ�p�Ƿ��ڰ�ť�İ�Χ����
	 * @param x ��x����
	 * @param y ��y����
	 * @return �� true,���� false
	 */
	boolean isIn(float x,float y);
	/**
	 * ��Ӧ�¼�
	 * @param event ��Ӧ�¼�
	 * @return ��Ӧ�¼��Ƿ񱻲���
	 */
	boolean actionPerformed(MotionEvent event);
	/**
	 * ����״̬
	 * @param s ״̬�� 0Ϊ��̬
	 */
	void setCurrentState(int s);
	/**
	 * �õ�״̬
	 * @return ״̬�� 0Ϊ��̬
	 */
	int getCurrentState();
}
