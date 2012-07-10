package org.sdu.android.sprite.change;

import org.sdu.android.sprite.AbstractSprite;
import org.sdu.android.util.graphicsUtil.SImage;

/**
 * 定义有关播放的基础事件
 * */
public abstract class Play {
	/** 动画开关 */
	protected boolean play = false;
	/** 播放速度 */
	protected float speed;
	/** 当前播放帧 */
	protected float frameIndex;
	/** 全部的帧 */
	protected SImage[] frames;
	/** 播放的帧的顺序 */
	protected int[] framesOrder;

	/**
	 * 构造方法
	 * 
	 * @param framesOrder
	 *            播放的帧的顺序
	 */
	public Play(int[] framesOrder) {
		this.play = false;
		this.frameIndex = 0;
		this.framesOrder = framesOrder;
	}

	/**
	 * 
	 * 设定播放事件的全部帧,特别的，如果没有设定framesOrder或未初始化framesOrder,
	 * 就会默认将framesOrder设定为将frames依次播放
	 * 
	 * @param frames
	 *            指定的帧
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
	 * 设定播放顺序
	 * 
	 * @param framesOrder
	 *            要设定的顺序
	 */
	public void setOrder(int[] framesOrder) {
		this.framesOrder = framesOrder;
	}

	/**
	 * 设定当前播放帧
	 * 
	 * @param frameIndex
	 *            当前播放帧
	 */
	public void setPresent(float frameIndex) {
		this.frameIndex = frameIndex;
	}

	/**
	 * 获取当前播放帧
	 * 
	 * @return 当前播放帧
	 * */
	public SImage getPresent() {
		return frames[framesOrder[(int) frameIndex]];
	}

	/**
	 * 在当前精灵中追加帧
	 * 
	 * @param bitsp
	 *            添加到精灵的图像 序列
	 * @param pos
	 *            待追加的位置
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
	 * 启动播放事件
	 * 
	 * */
	public abstract void onStart();

	/**
	 * 停止播放事件
	 * 
	 * */
	public abstract void onStop();

	/**
	 * 持续播放，当播放事件开始后持续进行播放处理
	 * 
	 * @param sprite
	 *            需要进行修改的sprite
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
	 * 播放下一帧
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
	 * 设定当前是否播放
	 * 
	 * @param play
	 *            是否播放
	 * 
	 * */
	public void setPlay(boolean play) {
		this.play = play;
	}

	/**
	 * 获取播放状态
	 * 
	 * @return 如果不播放 ，返回false
	 * 
	 * 
	 * */
	public boolean isPlay() {
		return play;
	}

	/**
	 * 设置播放速度
	 * 
	 * @param speed
	 *            每次刷新前进帧数
	 */
	public void setSpeed(float speed) {
		this.speed = speed - (int) speed / frames.length * frames.length;
	}

	/**
	 * 获得播放速度
	 * 
	 * @return 速度
	 */
	public float getSpeed() {
		return speed;
	}
}
