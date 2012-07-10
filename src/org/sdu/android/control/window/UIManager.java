package org.sdu.android.control.window;

import java.util.Vector;

import android.view.MotionEvent;

/**
 * �ؼ�������
 * @author shadow
 *
 */
public class UIManager {
	/**�ؼ�����*/
	public Vector<WindowObject> uiList=new Vector<WindowObject>();
	/**
	 * ����һ���ؼ�
	 * @param w Ҫ���ӵĿؼ�
	 */
	public void addWindowObject(WindowObject w){
		uiList.add(w);
	}
	/**
	 * ����һ��ָ��λ�õĿؼ�
	 * @param index �ؼ����ڲ��
	 * @param w Ҫ��ӵĿؼ�
	 */
	public void addWindowObject(int index,WindowObject w){
		uiList.add(index,w);
	}
	/**
	 * �Ƴ�ĳ�����ʵ��
	 * @param w ���Ƴ������ʵ��
	 * @return ����ɹ��Ƴ� true������false
	 */
	public boolean removeWindowObject(WindowObject w){
		return uiList.remove(w);
	}
	/**
	 * ��ȡ�ؼ�����
	 * @return ��ǰ�ؼ�����
	 */
	public Vector<WindowObject> getUiList() {
		return uiList;
	}
	/**
	 * ���Ͱ�ѹ�����¼�
	 * @param event �����¼�
	 * @return �¼��Ƿ񱻴���
	 */
	public boolean dealTouchDownAction(MotionEvent event){
		final float x=event.getX();
		final float y=event.getY();
		WindowObject tem;
		for(int i=0;i<uiList.size();i++){
			tem=uiList.get(i);
			if(tem.isIn(x, y)&&tem.isFocusable()){
			 tem.onPress(event);
			 return true;
			}
		}
		return false;
	}
	/**
	 * ���Ͱ�ѹ�����¼�
	 * @param event ��ѹ�����¼�
	 * @return �¼��Ƿ񱻴���
	 */
	public boolean dealTouchUpAction(MotionEvent event){
		final float x=event.getX();
		final float y=event.getY();
		WindowObject tem;
		for(int i=0;i<uiList.size();i++){
			tem=uiList.get(i);
			if(tem.isIn(x, y)&&tem.isFocusable()){
			 tem.onRelease(event);
			 return true;
			}else{
				tem.setCurrentState(0);
			}
		}
		return false;
	}
	/**
	 * ������ק�¼�
	 * @param event ��ק�¼�
	 * @return �¼��Ƿ񱻴���
	 */
	public boolean dealTouchDragAction(MotionEvent event){
		final float x=event.getX();
		final float y=event.getY();
		WindowObject tem;
		for(int i=0;i<uiList.size();i++){
			tem=uiList.get(i);
			if(tem.isIn(x, y)&&tem.isFocusable()){
			 tem.onDrag(event);
			 return true;
			}
		}
		return false;
	}
	
	
}
