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
	 * ���췽��
	 * 
	 * @param id
	 *            id
	 */
	public AniSprite(int id) {
		super(id, true);
	}

	/**
	 * ��Ӳ����¼��Ĳ�����ͬʱ��Ӳ���,�����¼�Ĭ��ΪNormalPlay
	 * 
	 * @param frameOrder
	 *            ���ŵ�֡��˳��
	 * @param speed
	 *            �����ٶ�
	 */
	public void startPlay(int[] framesOrder, float speed) {
		NormalPlay p = new NormalPlay(framesOrder);
		this.addPlays(p);
		p.setSpeed(speed);
		p.onStart();
	}

	/**
	 * ����ƶ��¼���Ĭ���ƶ�Ϊ�Զ�ѭ���ƶ�
	 * 
	 * @param locations
	 *            �ƶ���λ�ü���
	 */
	public void startMove(Point[] locations) {
		this.addMoves(new AutoLoopMove(locations));
	}

	/**
	 * ��ӱ仯�¼���Ĭ�ϱ仯Ϊ͸���ȱ仯
	 * 
	 * @param alpha
	 *            ͸����
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
