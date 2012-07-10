/**
 * 
 */
package org.sdu.android.game.rpg.sprite;

import org.sdu.android.map.painter.ground.Map;
import org.sdu.android.map.painter.resource.HeroIfc;
import org.sdu.android.util.graphicsUtil.SImage;

import android.view.KeyEvent;

/**
 * @author shadow
 * 
 */
public class HeroSprite extends RpgSprite implements HeroIfc{
	private int row;
	private int rank;
	int lastDir;
	int FrameIndex;

	/**
	 * ¥¥Ω®”¢–€¿‡
	 * 
	 * @param resId
	 */
	public HeroSprite(int resId) {
		super(resId, true);
	}

	public HeroSprite(int resId, String pth) {
		this(resId, pth, 4, 4);
	}

	public HeroSprite(int resId, String pth, int row, int rank) {
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
		HeroManager.add(this);
	}

	public synchronized void Go(int direction) {
		if (direction == lastDir) {
			FrameIndex++;
			if (FrameIndex % row == 1) {
				FrameIndex -= rank;
			}
			move(direction);
		}else {
			FrameIndex=direction*rank;
			lastDir=direction;
		}
	}
	
	public synchronized void move(int direction){
		
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

	/**
	 * @param keyCode
	 * @param event
	 * @see org.sdu.android.map.painter.resource.HeroIfc#onKeyDown(int, android.view.KeyEvent)
	 */
	
	@Override
	public void onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param dtc
	 * @see org.sdu.android.map.painter.resource.HeroIfc#setDistance(int)
	 */
	
	@Override
	public void setDistance(int dtc) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return
	 * @see org.sdu.android.map.painter.resource.HeroIfc#getDistance()
	 */
	
	@Override
	public int getDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param map
	 * @see org.sdu.android.map.painter.resource.HeroIfc#setMap(org.sdu.android.map.painter.ground.Map)
	 */
	
	@Override
	public void setMap(Map map) {
		// TODO Auto-generated method stub
		
	}

}
