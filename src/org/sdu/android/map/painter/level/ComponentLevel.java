package org.sdu.android.map.painter.level;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.sdu.android.control.window.UIAdapter;
import org.sdu.android.control.window.UIManager;
import org.sdu.android.util.otherUtil.CopiedIterator;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 组件层
 * 
 * @author shadow
 * 
 */
public class ComponentLevel extends Level {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** 待绘制图像列表 */
	private List<UIAdapter> uiList;
	public boolean isReady;
	public UIManager uiManager;

	/**
	 * 创建组建层,并自动初始化
	 */
	public ComponentLevel() {
		super();
		uiList = new Vector<UIAdapter>();
		uiManager = new UIManager();
	}

	/**
	 * 加入控件
	 * 
	 * @param u
	 *            控件
	 */
	public void add(UIAdapter u) {
		synchronized (this.uiList) {
			uiList.add(u);
			uiManager.addWindowObject(u);
		}
	}

	/**
	 * 在指定位置加入控件
	 * 
	 * @param u
	 *            控件
	 * @param position
	 *            位置
	 */
	public void add(UIAdapter u, int position) {
		synchronized (this.uiList) {
			uiList.add(position, u);
			uiManager.addWindowObject(position,u);
		}
	}

	/**
	 * 绘制控件
	 * 
	 * @param canvas
	 *            画布
	 * @param paint
	 *            画笔
	 */
	@SuppressWarnings("unchecked")
	public synchronized void onDraw(Canvas canvas, Paint paint) {
		Iterator<UIAdapter> iterator = null;
		  synchronized(uiList) {
		  iterator = new CopiedIterator(uiList.iterator());
		  }
		  while(iterator.hasNext( )) {
			  iterator.next().draw(canvas);
		  }
	}

	/**
	 * 移除组件
	 * 
	 */
	public void remove(UIAdapter d) {
		synchronized (this.uiList) {
			uiList.remove(d);
			uiManager.removeWindowObject(d);
		}
	}

	public void removeAll() {
		synchronized (this.uiList) {
			uiList.clear();
			uiManager.uiList.clear();
		}
	}
}
