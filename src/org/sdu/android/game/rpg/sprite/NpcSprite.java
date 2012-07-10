/**
 * 
 */
package org.sdu.android.game.rpg.sprite;

import org.sdu.android.util.graphicsUtil.SImage;

/**
 * @author shadow
 * 
 */
public class NpcSprite extends RpgSprite {
	private int row;
	private int rank;
	int lastDir;
	int FrameIndex;

	/**
	 * ¥¥Ω®”¢–€¿‡
	 * 
	 * @param resId
	 */
	public NpcSprite(int resId) {
		super(resId, true);
	}

	public NpcSprite(int resId, String pth) {
		this(resId, pth, 4, 4);
	}

	public NpcSprite(int resId, String pth, int row, int rank) {
		this(resId);
		setImagePth(pth);
		this.setRank(rank);
		this.setRow(row);
	}

	@Override
	public void load() {
		this.image = SImage.createImage(imagePth);
		this.splitImage(this.getRow(), this.getRank());
		this.setImage(frames[0]);
		NpcManager.add(this);
	}

	

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param rank
	 *            the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

}
