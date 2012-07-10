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
	 * ���Ӿ���
	 * @param s
	 */
	public static void add(StaticSprite s){
		sprites.put(s.getResId(), s);
	}
	/**
	 * ����id�õ�����
	 * @param id
	 * @return
	 */
	public static StaticSprite getSprite(int id){
		return sprites.get(id);
	}
	/**
	 * ����id�Ƴ�����
	 * @param id
	 * @return
	 */
	public static StaticSprite removeSprite(int id){
		return sprites.remove(id);
	}
	/**
	 * ���þ��������
	 */
	public static void clear(){
		sprites.clear();
		System.gc();
	}
}
