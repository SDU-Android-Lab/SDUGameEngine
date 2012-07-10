/**
 * 
 */
package org.sdu.android.map.action;

import org.sdu.android.map.painter.ground.Map;

import android.graphics.Point;


/**
 * ��ͼ�¼�
 * @author Joycery & Sww
 *
 */
public class MapEvent extends SEvent {


	private static final long serialVersionUID = 1L;

	
	private Map map;
	private Point point;
	
	/**
	 * �����ͼ�¼�
	 * @param source ��ͼ
	 * @param point ����
	 */
	public MapEvent(Map source,Point point) {
		super(source);
	}

	/**
	 * �õ���ͼ
	 * @return ��ͼ
	 */
	public Map getMap(){
		return map;
	}
	/**
	 * �õ��¼�λ��
	 * @return  �¼�λ��
	 */
	public Point getPoint() {
		return point;
	}
}
