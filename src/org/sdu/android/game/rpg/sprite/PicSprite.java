/**
 * 
 */
package org.sdu.android.game.rpg.sprite;

/**
 * @author shadow
 *
 */
public class PicSprite extends RpgSprite{

	/**
	 * @param resId
	 * @param playable
	 */
	public PicSprite(int resId) {
		super(resId,false);
	}

	/**
	 * 
	 * @see org.sdu.android.game.rpg.sprite.RpgSprite#load()
	 */
	
	@Override
	public void load() {
		super.load();
		PicManager.add(this);
	}

	

}
