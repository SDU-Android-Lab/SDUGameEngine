/**
 * 
 */
package org.sdu.android.game.rpg.sprite;

import org.sdu.android.sprite.DynamicSprite;
import org.sdu.android.util.graphicsUtil.SImage;

/**
 * @author shadow
 * 
 */
public abstract class RpgSprite extends DynamicSprite {
	protected String imagePth;

	/**
	 * @param x
	 * @param y
	 * @param id
	 * @param canPlay
	 */
	public RpgSprite(int x, int y, int id, boolean canPlay) {
		super(x, y, id, canPlay);
	}

	public RpgSprite(int id, boolean playable) {
		this(0, 0, id, playable);
	}

	public void load() {
		this.image = SImage.createImage(imagePth);
	}

	/**
	 * 
	 * @see org.sdu.android.game.rpg.sprite.RpgSprite#unLoad()
	 */

	public void unLoad() {
		this.image.getBitmap().recycle();
		this.image = null;
	}

	/**
	 * @param imagePth
	 *            the imagePth to set
	 */
	public void setImagePth(String imagePth) {
		this.imagePth = imagePth;
	}

	/**
	 * @return the imagePth
	 */
	public String getImagePth() {
		return imagePth;
	}
}
