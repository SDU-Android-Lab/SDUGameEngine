package org.sdu.android.sprite.change;

/**
 * 
 * 一般播放速度的播放事件
 * 
 * */
public class NormalPlay extends Play {
	/**
	 *  构造方法 默认播放速度是1.0f 动画播放顺序按照framesOrder
	 * @param framesOrder  播放的帧的顺序
	 */
	public NormalPlay(int[] framesOrder) {
		super(framesOrder);
		this.frameIndex = 0;
		this.speed = 1.0f;
	}

	/**
	 * 构造方法 默认播放速度是1.0f 动画播放顺序是按照全部帧的顺序播放
	 */
	public NormalPlay() {
		super(null);
		this.frameIndex = 0;
		this.speed = 1.0f;
	}

	/**
	 * 启动播放事件
	 * 
	 * 
	 * */
	public void onStart() {
		play = true;
	}

	/**
	 * 停止播放事件
	 * 
	 * */
	public void onStop() {
		play = false;
	}

}
