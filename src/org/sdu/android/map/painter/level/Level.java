package org.sdu.android.map.painter.level;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.sdu.android.sprite.AbstractSprite;
import org.sdu.android.sprite.Drawable;

import android.content.res.Resources;

/**
 * 在Scene中所有层的基类（抽象类）
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
	 * 存储精灵的List;
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
	 * 初始化
	 */
	public void initialize() {
		spriteList = new LinkedList<AbstractSprite>();
	}

	/**
	 * 加载资源
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
	 * 释放资源
	 */
	public void unload() {
		final Iterator<AbstractSprite> it = spriteList.iterator();
		while (it.hasNext()) {
			it.next().unload();
		}
	}

	/**
	 * 添加精灵
	 * 
	 * @param sprite
	 *            sprite
	 */
	public void add(AbstractSprite sprite) {
		spriteList.add(sprite);
	}
}
