/**
 * 
 */
package org.sdu.android.game.rpg.sprite;

import java.util.HashMap;

import org.sdu.android.sprite.StaticSprite;

/**
 * @author shadow
 *
 */
public class SpriteManager {

	public static HashMap<Integer,StaticSprite> sprites=new HashMap<Integer,StaticSprite>();
	/**
	 * 增加精灵
	 * @param s
	 */
	public static void add(StaticSprite s){
		sprites.put(s.getResId(), s);
	}
	/**
	 * 根据id得到精灵
	 * @param id
	 * @return
	 */
	public static StaticSprite getSprite(int id){
		return sprites.get(id);
	}
	/**
	 * 根据id移除精灵
	 * @param id
	 * @return
	 */
	public static StaticSprite removeSprite(int id){
		return sprites.remove(id);
	}
	/**
	 * 重置精灵管理器
	 */
	public static void clear(){
		sprites.clear();
		System.gc();
	}
}
