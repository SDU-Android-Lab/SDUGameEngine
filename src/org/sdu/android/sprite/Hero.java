package org.sdu.android.sprite;

import org.sdu.android.map.painter.ground.Map;
import org.sdu.android.map.painter.resource.HeroIfc;
import org.sdu.android.util.graphicsUtil.Rect;

import android.util.Log;
import android.view.KeyEvent;

/**
 * 实现了响应键盘接口的精灵
 * @author Joycery & Sww
 *
 */
public class Hero extends DynamicSprite implements HeroIfc{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3682645158011733891L;
	
	/**
	 *设置地图
	 */
	Map map;
	
	/**15*/
	final static int tile=2;
	/**每一步的长度*/
	int distance;
	
	/***
	 * 构造方法
	 * @param id 主角在各资源中的编号
	 */
	public Hero(int id)
	{
		super(id,true);
		//默认每一步为15，可以在setDistance（）中修改
		distance=tile;
	}
	
	/**
	 * 获取地图
	 * @return map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * 设置地图
	 * @param map map
	 */
	public void setMap(Map map) {
		this.map = map;
	}



	/**
	 * 按键监听事件
	 * @param keyCode 按键值
	 * @param event 事件
	 */
	public void onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_UP: {
			//需要检测主角将要走到的地方是否会碰撞
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
	 * 主角移动方法，实现自HeroIfc
	 * @param direction 应传入interface中的东南西北四个中的一个方向
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
	 * 设置每一步的长度，实现自HeroIfc
	 * @param dtc 每一步的长度
	 */
	public void setDistance(int dtc) {
		// TODO Auto-generated method stub
		this.distance=dtc;
	}

	/**
	 * 获取每一步的长度，实现自HeroIfc
	 * @return dtc 每一步的长度
	 */
	public int getDistance() {
		// TODO Auto-generated method stub
		return distance;
	}
}
