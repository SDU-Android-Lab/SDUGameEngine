package org.sdu.android.control.window;

import java.util.Vector;

import android.view.MotionEvent;

/**
 * 控件管理类
 * @author shadow
 *
 */
public class UIManager {
	/**控件链表*/
	public Vector<WindowObject> uiList=new Vector<WindowObject>();
	/**
	 * 增加一个控件
	 * @param w 要增加的控件
	 */
	public void addWindowObject(WindowObject w){
		uiList.add(w);
	}
	/**
	 * 增加一个指定位置的控件
	 * @param index 控件所在层号
	 * @param w 要添加的控件
	 */
	public void addWindowObject(int index,WindowObject w){
		uiList.add(index,w);
	}
	/**
	 * 移除某个组件实例
	 * @param w 需移除的组件实例
	 * @return 组件成功移除 true，否则false
	 */
	public boolean removeWindowObject(WindowObject w){
		return uiList.remove(w);
	}
	/**
	 * 获取控件链表
	 * @return 当前控件链表
	 */
	public Vector<WindowObject> getUiList() {
		return uiList;
	}
	/**
	 * 派送按压触屏事件
	 * @param event 触屏事件
	 * @return 事件是否被处理
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
	 * 派送按压弹起事件
	 * @param event 按压弹起事件
	 * @return 事件是否被处理
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
	 * 派送拖拽事件
	 * @param event 拖拽事件
	 * @return 事件是否被处理
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
