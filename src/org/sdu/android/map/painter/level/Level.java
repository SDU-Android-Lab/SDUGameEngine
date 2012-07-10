package org.sdu.android.map.painter.level;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.sdu.android.sprite.AbstractSprite;
import org.sdu.android.sprite.Drawable;

import android.content.res.Resources;

/**
 * ��Scene�����в�Ļ��ࣨ�����ࣩ
 * 
 * @author Joycery & Sww
 * 
 */

public abstract class Level implements Drawable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * �洢�����List;
	 */
	protected List<AbstractSprite> spriteList;

	/**
	 * 
	 */
	private Resources resource;
	/**
	 * 
	 * @return list
	 */
	public List<AbstractSprite> getSpriteList() {
		return spriteList;
	}

	/**
	 * ��ʼ��
	 */
	public void initialize() {
		spriteList = new LinkedList<AbstractSprite>();
	}

	/**
	 * ������Դ
	 * 
	 * @param context
	 *            context
	 */
	public void load(Resources resource) {
//		final Iterator<AbstractSprite> it = spriteList.iterator();
//		while (it.hasNext()) {
//			final AbstractSprite r = it.next();
//			
//			r.load(resource);
//		}
	}

	/**
	 * �ͷ���Դ
	 */
	public void unload() {
		final Iterator<AbstractSprite> it = spriteList.iterator();
		while (it.hasNext()) {
			it.next().unload();
		}
	}

	/**
	 * ��Ӿ���
	 * 
	 * @param sprite
	 *            sprite
	 */
	public void add(AbstractSprite sprite) {
		spriteList.add(sprite);
	}
}
