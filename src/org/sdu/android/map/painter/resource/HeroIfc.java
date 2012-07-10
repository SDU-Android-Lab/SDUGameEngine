package org.sdu.android.map.painter.resource;

import org.sdu.android.map.painter.ground.Map;

import android.view.KeyEvent;

/**
 * 
 * @author Joycery & Sww
 *
 */
public interface HeroIfc {

	/**�������ϣ�*/
	int NORTH=100;
	
	/**�Ϸ����£�*/
	int SOUTH=200;
	
	/**��������*/
	int WEST=300;
	
	/**�������ң�*/
	int EAST=400;
	
	/**
	 * ���������¼�
	 * @param keyCode ����ֵ
	 * @param event �¼�
	 */
	void onKeyDown(int keyCode, KeyEvent event) ;
	
	/**
	 * ���ǵ��ƶ�
	 * @param direction ���ǵ��ƶ�����
	 */
	void move(int direction);
	
	/**
	 * ����ÿһ���ĳ���
	 * @param dtc ����
	 */
	void setDistance(int dtc);
	
	/**
	 * ��ȡÿһ���ĳ���
	 * @return ����
	 */
	int getDistance();
	
	/**
	 * ���õ�ͼ
	 * @param map ��ͼ
	 */
	void setMap(Map map);
}
