/**
 * 
 */
package org.sdu.android.game.rpg.sprite;

import org.sdu.android.sprite.change.AlphaChange;
import org.sdu.android.sprite.change.AutoLoopMove;
import org.sdu.android.sprite.change.NormalPlay;

import android.graphics.Point;

/**
 * 
 * 
 * @author shadow
 * 
 */
public class AniSprite extends RpgSprite {

	/**
	 * 构造方法
	 * 
	 * @param id
	 *            id
	 */
	public AniSprite(int id) {
		super(id, true);
	}

	/**
	 * 添加播放事件的参数，同时添加播放,播放事件默认为NormalPlay
	 * 
	 * @param frameOrder
	 *            播放的帧的顺序
	 * @param speed
	 *            播放速度
	 */
	public void startPlay(int[] framesOrder, float speed) {
		NormalPlay p = new NormalPlay(framesOrder);
		this.addPlays(p);
		p.setSpeed(speed);
		p.onStart();
	}

	/**
	 * 添加移动事件，默认移动为自动循环移动
	 * 
	 * @param locations
	 *            移动的位置集合
	 */
	public void startMove(Point[] locations) {
		this.addMoves(new AutoLoopMove(locations));
	}

	/**
	 * 添加变化事件，默认变化为透明度变化
	 * 
	 * @param alpha
	 *            透明度
	 */

	public void startChange(int alpha) {
		this.addChanges(new AlphaChange(alpha));
	}

	/**
	 * 
	 * @see org.sdu.android.game.rpg.sprite.RpgSprite#load()
	 */

	public void load() {
		super.load();
		AniManager.add(this);
	}
}
