package org.sdu.android.map.search;

import android.graphics.Point;

/**
 * ��Ѱ���ӿ�
 * @author Joycery & Sww
 * 
 */
public interface AutoSearchable {
	/**
	 * �õ��ӿ�ʼ�ص��յ��·��
	 * @param start ��ʼ�ص�
	 * @param des	�����ص�
	 * @return ·�������·���������򷵻�null
	 */
	Route findRoute(Point start, Point des);
}
