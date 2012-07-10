package org.sdu.android.sprite.change;

/**
 * 
 * һ�㲥���ٶȵĲ����¼�
 * 
 * */
public class NormalPlay extends Play {
	/**
	 *  ���췽�� Ĭ�ϲ����ٶ���1.0f ��������˳����framesOrder
	 * @param framesOrder  ���ŵ�֡��˳��
	 */
	public NormalPlay(int[] framesOrder) {
		super(framesOrder);
		this.frameIndex = 0;
		this.speed = 1.0f;
	}

	/**
	 * ���췽�� Ĭ�ϲ����ٶ���1.0f ��������˳���ǰ���ȫ��֡��˳�򲥷�
	 */
	public NormalPlay() {
		super(null);
		this.frameIndex = 0;
		this.speed = 1.0f;
	}

	/**
	 * ���������¼�
	 * 
	 * 
	 * */
	public void onStart() {
		play = true;
	}

	/**
	 * ֹͣ�����¼�
	 * 
	 * */
	public void onStop() {
		play = false;
	}

}
