package org.sdu.android.map.painter.level;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.sdu.android.sprite.AbstractSprite;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

/**
 * ��̬�㣬��ӿ����ƶ�����Դ
 * 
 * @author Joycery & Sww
 * 
 */
public class DynamicLevel extends OffsetLevel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��ʱlist���������м���뾫��
	 */
	private List<AbstractSprite> tAddlist=new LinkedList();
	
	/**
	 * ��ʱlist���������м�ɾ������
	 */
	private List<AbstractSprite> tRemovelist=new LinkedList();

	/**
	 * ɾ������
	 * 
	 * @param sprite
	 *            sprite
	 */
	public void remove(AbstractSprite sprite) {
		Log.i("dynamiclevel","remove function is invoked");
		if(spriteList.contains(sprite))
		{
			tRemovelist.add(sprite);
			Log.i("dynamiclevel","spritelist contains this sprite");
		}
		else
		{
			Log.i("dynamiclevel","spritelist doesn't contain this sprite");
		}
	
	}

	/**
	 * ���ƶ�̬��
	 * 
	 * @param canvas
	 *            canvas
	 */
	@Override
	public void onDraw(Canvas canvas,Paint paint) {
		final Iterator<AbstractSprite> it = spriteList.iterator();
		while (it.hasNext()) {
			final AbstractSprite sprite = it.next();
		//	sprite.setOffsetXY(offsetX, offsetY);
//			sprite.setX(offsetX);
//			sprite.setY(offsetY);
			sprite.onDraw(canvas,paint);
		}
		
		if(!tAddlist.isEmpty())
		{
			final Iterator<AbstractSprite> ii = tAddlist.iterator();
			while (ii.hasNext()) {
				final AbstractSprite sprite = ii.next();
			//	sprite.setOffsetXY(offsetX, offsetY);
				spriteList.add(sprite);
			}
			tAddlist.clear();
			onDraw(canvas,paint);
		}
		
		if(!tRemovelist.isEmpty())
		{
			if(tRemovelist.isEmpty())
			{
				Log.i("dynamiclevel","removelist is empty");
			}
			else
			{
				Log.i("dynamiclevel","removelist is not empty");
			}
			final Iterator<AbstractSprite> i2 = tRemovelist.iterator();
			while (i2.hasNext()) {
				final AbstractSprite sprite = i2.next();
			//	sprite.setOffsetXY(offsetX, offsetY);
				spriteList.remove(sprite);
				Log.i("DynamicLevel","remove one");
			}
			tRemovelist.clear();
			onDraw(canvas,paint);
		}

	}
	
	public void add(AbstractSprite sprite) {
		tAddlist.add(sprite);
	}
}
