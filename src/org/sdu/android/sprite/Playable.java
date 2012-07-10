package org.sdu.android.sprite;

import org.sdu.android.sprite.change.Play;


/**
 * 
 * 定义精灵是否可播放
 * 
 */
public interface Playable {
	/**
	 * 
	 * 添加指定播放事件
	 * 
	 * @param play
	 * 
	 *            指定的播放事件
	 * */
	void addPlays(Play play);

	/**
	 * 移除指定播放事件
	 * 
	 * @param play
	 * 
	 *            指定的播放事件
	 * */
	void removePlays(Play play);

	/**
	 * 响应播放事件
	 * 
	 * */
	void play();
}
