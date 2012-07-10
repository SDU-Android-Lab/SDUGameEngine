package org.sdu.android.map.painter.ground;

import org.sdu.android.map.search.AutoSearchable;
import org.sdu.android.map.search.Route;
import org.sdu.android.map.search.Search;

import android.graphics.Point;

/**
 * ��ͼ�࣬�̳��˼򵥵�ͼ����ʵ�����Զ�Ѱ���Ľӿ�ģ��
 * 
 * @author Joycery & Sww
 *
 */
public abstract class SearchableMap extends SimpleMap implements AutoSearchable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**Ѱ������*/
	private Search search;

	/**
	 * 
	 * @param array  ��ͼ��Ӧ������
	 *        0�������ͨ����1��������ͨ��
	 *        
	 *  ��Ƭ�Ŀ�߲���
	 * @param tileWidth  .
	 * @param tileHeight .
	 */
	public SearchableMap(int[][] array, int tileWidth, int tileHeight){
		super(array, tileWidth, tileHeight);
		search=new Search(this);
	}
	
	/***************************
	 *���Զ�Ѱ���Ĺ���ʵ��
	 **************************/
	
	/**
	 * @param start  ·������ʼ��
	 * @param des    ·�����յ�
	 * 
	 * @return route ����һ��·��
	 */
	public Route findRoute(Point start, Point des) {
		search.search(start, des);
		return search.getRoute();
	}
}
