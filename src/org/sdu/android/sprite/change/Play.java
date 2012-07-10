package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;
import org.sdu.android.util.graphicsUtil.SImage;

/**
 * �����йز��ŵĻ����¼�
 * */
public abstract class Play {
	/** �������� */
	protected boolean play = false;
	/** �����ٶ� */
	protected float speed;
	/** ��ǰ����֡ */
	protected float frameIndex;
	/** ȫ����֡ */
	protected SImage[] frames;
	/** ���ŵ�֡��˳�� */
	protected int[] framesOrder;

	/**
	 * ���췽��
	 * 
	 * @param framesOrder
	 *            ���ŵ�֡��˳��
	 */
	public Play(int[] framesOrder) {
		this.play = false;
		this.frameIndex = 0;
		this.framesOrder = framesOrder;
	}

	/**
	 * 
	 * �趨�����¼���ȫ��֡,�ر�ģ����û���趨framesOrder��δ��ʼ��framesOrder,
	 * �ͻ�Ĭ�Ͻ�framesOrder�趨Ϊ��frames���β���
	 * 
	 * @param frames
	 *            ָ����֡
	 * */
	public void setFrames(SImage[] frames) {
		this.frames = frames;
		if (framesOrder == null || framesOrder.length == 0) {
			framesOrder = new int[frames.length];
			for (int i = 0; i < frames.length; i++) {
				framesOrder[i] = i;
			}
		}
	}

	/**
	 * �趨����˳��
	 * 
	 * @param framesOrder
	 *            Ҫ�趨��˳��
	 */
	public void setOrder(int[] framesOrder) {
		this.framesOrder = framesOrder;
	}

	/**
	 * �趨��ǰ����֡
	 * 
	 * @param frameIndex
	 *            ��ǰ����֡
	 */
	public void setPresent(float frameIndex) {
		this.frameIndex = frameIndex;
	}

	/**
	 * ��ȡ��ǰ����֡
	 * 
	 * @return ��ǰ����֡
	 * */
	public SImage getPresent() {
		return frames[framesOrder[(int) frameIndex]];
	}

	/**
	 * �ڵ�ǰ������׷��֡
	 * 
	 * @param bitsp
	 *            ��ӵ������ͼ�� ����
	 * @param pos
	 *            ��׷�ӵ�λ��
	 */
	public void addFrames(int[] bitsp, int pos) {
		final int[] temp = new int[framesOrder.length + bitsp.length];
		for (int i = 0; i < pos; i++) {
			temp[i] = framesOrder[i];
		}
		for (int i = pos; i < temp.length; i++) {
			if ((i - pos) < bitsp.length) {
				temp[i] = bitsp[i - pos];
			} else {
				temp[i] = framesOrder[i - pos];
			}
		}
	}

	/**
	 * 
	 * ���������¼�
	 * 
	 * */
	public abstract void onStart();

	/**
	 * ֹͣ�����¼�
	 * 
	 * */
	public abstract void onStop();

	/**
	 * �������ţ��������¼���ʼ��������в��Ŵ���
	 * 
	 * @param sprite
	 *            ��Ҫ�����޸ĵ�sprite
	 * 
	 * */
	public void onContinue(AbstractSprite sprite) {
		if (!play) {
			return;
		}
		sprite.setImage(getPresent());
		this.nextFrame();
	}

	/**
	 * ������һ֡
	 */
	public void nextFrame() {
		frameIndex += speed;
		if (frameIndex >= framesOrder.length) {
			frameIndex %= framesOrder.length;
		} else if (frameIndex < 0) {
			frameIndex += framesOrder.length;
		}
	}

	/**
	 * �趨��ǰ�Ƿ񲥷�
	 * 
	 * @param play
	 *            �Ƿ񲥷�
	 * 
	 * */
	public void setPlay(boolean play) {
		this.play = play;
	}

	/**
	 * ��ȡ����״̬
	 * 
	 * @return ��������� ������false
	 * 
	 * 
	 * */
	public boolean isPlay() {
		return play;
	}

	/**
	 * ���ò����ٶ�
	 * 
	 * @param speed
	 *            ÿ��ˢ��ǰ��֡��
	 */
	public void setSpeed(float speed) {
		this.speed = speed - (int) speed / frames.length * frames.length;
	}

	/**
	 * ��ò����ٶ�
	 * 
	 * @return �ٶ�
	 */
	public float getSpeed() {
		return speed;
	}
}
