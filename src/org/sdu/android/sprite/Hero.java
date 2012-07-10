package org.sdu.android.sprite;

import org.sdu.android.map.painter.ground.Map;
import org.sdu.android.map.painter.resource.HeroIfc;
import org.sdu.android.util.graphicsUtil.Rect;

import android.util.Log;
import android.view.KeyEvent;

/**
 * ʵ������Ӧ���̽ӿڵľ���
 * @author Joycery & Sww
 *
 */
public class Hero extends DynamicSprite implements HeroIfc{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3682645158011733891L;
	
	/**
	 *���õ�ͼ
	 */
	Map map;
	
	/**15*/
	final static int tile=2;
	/**ÿһ���ĳ���*/
	int distance;
	
	/***
	 * ���췽��
	 * @param id �����ڸ���Դ�еı��
	 */
	public Hero(int id)
	{
		super(id,true);
		//Ĭ��ÿһ��Ϊ15��������setDistance�������޸�
		distance=tile;
	}
	
	/**
	 * ��ȡ��ͼ
	 * @return map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * ���õ�ͼ
	 * @param map map
	 */
	public void setMap(Map map) {
		this.map = map;
	}



	/**
	 * ���������¼�
	 * @param keyCode ����ֵ
	 * @param event �¼�
	 */
	public void onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_UP: {
			//��Ҫ������ǽ�Ҫ�ߵ��ĵط��Ƿ����ײ
			if(!map.isCollision(new Rect(this.x,this.y-distance,this.height,this.width)))
			{
				final int sx=(int)(this.x/32+0.5);
				final int sy=(int)((this.y-distance)/32+0.5);
				final int ex=(int)((this.x+this.width)/32);
				final int ey=(int)((this.y+this.height)/32);
				Log.i("rect",sy+","+sx+"  "+ey+","+ex);
				move(NORTH);
			}
			break;
		}
		case KeyEvent.KEYCODE_DPAD_DOWN: {
			if(!map.isCollision(new Rect(this.x,this.y+distance,this.height,this.width)))
			{
				final int sx=(int)(this.x/32+0.5);
				final int sy=(int)((this.y-distance)/32+0.5);
				final int ex=(int)((this.x+this.width)/32);
				final int ey=(int)((this.y+this.height)/32);
				Log.i("rect",sy+","+sx+"  "+ey+","+ex);
				move(SOUTH);
			}
			break;
		}
		case KeyEvent.KEYCODE_DPAD_LEFT: {
			if(!map.isCollision(new Rect(this.x-distance,this.y,this.height,this.width)))
			{
				final int sx=(int)(this.x/32+0.5);
				final int sy=(int)((this.y-distance)/32+0.5);
				final int ex=(int)((this.x+this.width)/32);
				final int ey=(int)((this.y+this.height)/32);
				Log.i("rect",sy+","+sx+"  "+ey+","+ex);
				move(WEST);
			}
			break;
		}
		case KeyEvent.KEYCODE_DPAD_RIGHT: {
			if(!map.isCollision(new Rect(this.x+distance,this.y,this.height,this.width)))
			{
				final int sx=(int)(this.x/32+0.5);
				final int sy=(int)((this.y-distance)/32+0.5);
				final int ex=(int)((this.x+this.width)/32);
				final int ey=(int)((this.y+this.height)/32);
				Log.i("rect",sy+","+sx+"  "+ey+","+ex);
				move(EAST);
			}
			break;
		}
		}
		map.checkEvent(new Rect(this.x+distance,this.y,this.height,this.width));
	}

	/**
	 * �����ƶ�������ʵ����HeroIfc
	 * @param direction Ӧ����interface�еĶ��������ĸ��е�һ������
	 */
	public void move(int direction) {
		// TODO Auto-generated method stub
		switch (direction) {
		case NORTH: {
			setY(getY() - distance);
			break;
		}
		case SOUTH: {
			setY(getY() + distance);
			break;
		}
		case WEST: {
			setX(getX() - distance);
			break;
		}
		case EAST: {
			setX(getX() + distance);
			break;
		}
		}
	}

	/**
	 * ����ÿһ���ĳ��ȣ�ʵ����HeroIfc
	 * @param dtc ÿһ���ĳ���
	 */
	public void setDistance(int dtc) {
		// TODO Auto-generated method stub
		this.distance=dtc;
	}

	/**
	 * ��ȡÿһ���ĳ��ȣ�ʵ����HeroIfc
	 * @return dtc ÿһ���ĳ���
	 */
	public int getDistance() {
		// TODO Auto-generated method stub
		return distance;
	}
}
