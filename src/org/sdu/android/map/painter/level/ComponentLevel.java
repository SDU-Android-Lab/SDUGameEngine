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
 * �����
 * 
 * @author shadow
 * 
 */
public class ComponentLevel extends Level {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/** ������ͼ���б� */
	private List<UIAdapter> uiList;
	public boolean isReady;
	public UIManager uiManager;

	/**
	 * �����齨��,���Զ���ʼ��
	 */
	public ComponentLevel() {
		super();
		uiList = new Vector<UIAdapter>();
		uiManager = new UIManager();
	}

	/**
	 * ����ؼ�
	 * 
	 * @param u
	 *            �ؼ�
	 */
	public void add(UIAdapter u) {
		synchronized (this.uiList) {
			uiList.add(u);
			uiManager.addWindowObject(u);
		}
	}

	/**
	 * ��ָ��λ�ü���ؼ�
	 * 
	 * @param u
	 *            �ؼ�
	 * @param position
	 *            λ��
	 */
	public void add(UIAdapter u, int position) {
		synchronized (this.uiList) {
			uiList.add(position, u);
			uiManager.addWindowObject(position,u);
		}
	}

	/**
	 * ���ƿؼ�
	 * 
	 * @param canvas
	 *            ����
	 * @param paint
	 *            ����
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
	 * �Ƴ����
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
