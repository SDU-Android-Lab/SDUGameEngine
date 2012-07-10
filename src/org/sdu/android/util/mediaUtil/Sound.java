package org.sdu.android.util.mediaUtil;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.util.Log;

/**
 * �������Ʒ����� ��Ҫ�ڵ��ø÷��������д���AudioManager���󣬲�ʹ��
 * (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);��ȡϵͳ����
 * �ٽ�����Ϊ�������룬��������ؿ��Ʒ���
 * 
 * @author yyt
 * 
 */
public class Sound {

	/** ͬʱ���ŵ������������,Ĭ��Ϊ1 */
	int maxStream = 1;
	/** ������ת����������ǰ��Ч����ʹ��0��ΪĬ��ֵ */
	int srcQuality = 0;
	/** ����һ��AudioManager���� */
	// AudioManager am=
	// (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
	/** ����һ��MediaPlayer���� */
	private MediaPlayer mp;
	/** ����һ��SoundPool���� */
	SoundPool soundPool;
	/** ����HASH�� */
	private HashMap<Integer, Integer> soundPoolMap;
	/** ����ID */
	 int soundID;
	/** ������ID */
	int streamID=0;
	/** �ж������Ƿ�ֹͣ */
	boolean stop = true;
	/** �Ƿ��� */
	boolean silence = false;

	// ===============================================================
	// ��������
	/**
	 * ��������
	 * 
	 * @param am
	 *            AudioManager����
	 */
	public void lVolume(AudioManager am) {
		/** ������������ */
		am.adjustVolume(AudioManager.ADJUST_LOWER, 0);
	}

	/**
	 * ��������
	 * 
	 * @param am
	 *            AudioManager����
	 */
	public void rVolume(AudioManager am) {
		/** ������������ */
		am.adjustVolume(AudioManager.ADJUST_RAISE, 0);
	}

	/**
	 * ����
	 * 
	 * @param am
	 *            AudioManager����
	 */
	public void silent(AudioManager am) {
		if (!silence) {
			am.setStreamMute(AudioManager.STREAM_MUSIC, true);
			silence = true;
		}

	}

	/**
	 * �Ӿ����лָ�
	 * 
	 * @param am
	 *            AudioManager����
	 */
	public void normal(AudioManager am) {
		if (silence) {
			am.setStreamMute(AudioManager.STREAM_MUSIC, false);
			silence = false;
		}

	}

	// ===============================================================
	// �������ֲ���mediaplayer��ֱ�ӵ���playBSound�Զ����غͲ��ţ�
	// ���ݲ�ͬ�Ĳ�����ȷ����ͬ �ļ��ط�ʽ

	/**
	 * ��ʼ��MediaPlayer
	 */
	private void initMediaP() {
		if (stop) {
			mp = new MediaPlayer();
		}

	}

	/**
	 * �ڲ����ã�������Դ�󲥷�
	 */
	private void start() {
		if (stop) {
			try {
				mp.prepare();
			} catch (IOException e) {
				e.printStackTrace();
			}
			stop = false;
		}
		mp.start();

	}

	/**
	 * ͨ����Դid�Զ�������Դ�����ű�������,�����Ƿ�ѭ������
	 * 
	 * @param context
	 *            Context
	 * @param resid
	 *            ��Դid��
	 * @param isloop
	 *            �����Ƿ�ѭ�����ŵ�booleanֵ
	 */
	public void playBSound(Context context, int resid, boolean isloop) {
		if (stop) {
			mp = MediaPlayer.create(context, resid);
			stop = false;
		}
		mp.start();

		/** ѭ�����ţ� */
		mp.setLooping(isloop);
	}

	/**
	 * ͨ��uri�Զ�������Դ�����ű�������,�����Ƿ�ѭ������
	 * 
	 * @param context
	 *            Context
	 * @param uri
	 *            Uri
	 * @param isloop
	 *            �����Ƿ�ѭ�����ŵ�booleanֵ
	 */
	public void playBSound(Context context, Uri uri, boolean isloop) {
		/** ��ͬ����ʽ���ò���������prepare״̬ */
		initMediaP();
		try {
			mp.setDataSource(context, uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
		start();
		/** ѭ�����ţ� */
		mp.setLooping(isloop);
	}

	/**
	 * ͨ��·���Զ�������Դ�����ű�������,�����Ƿ�ѭ������
	 * 
	 * @param path
	 *            ��Դ·��
	 * @param isloop
	 *            �����Ƿ�ѭ�����ŵ�booleanֵ
	 */
	public void playBSound(String path, boolean isloop) {
		initMediaP();
		try {
			mp.setDataSource(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		start();
		/** ѭ�����ţ� */
		mp.setLooping(isloop);
	}

	/**
	 * ͨ��FileDescriptor�Զ�������Դ�����ű�������,�����Ƿ�ѭ������
	 * 
	 * @param fd
	 *            FileDescriptor����
	 * @param isloop
	 *            �����Ƿ�ѭ�����ŵ�booleanֵ
	 */
	public void playBSound(FileDescriptor fd, boolean isloop) {
		initMediaP();
		try {
			mp.setDataSource(fd);
		} catch (IOException ee) {
			ee.printStackTrace();
		}
		start();
		mp.setLooping(isloop);
	}

	/**
	 * ��ͣ
	 */
	public void pauseBSound() {
		if (!stop) {
			mp.pause();
		}
	}

	/**
	 * ֹͣ
	 */
	public void stopBSound() {
		if (!stop) {
			mp.stop();
			stop = true;
			/** �ͷ���Դ */
			mp.release();
		}
	}

	// ===============================================================
	// ��Ϸ��Ч����soundpool
	/**
	 * 
	 * ����loadSoundP�������֣���ͬ�Ĳ�����ʾ��ͬ�ļ��ط�ʽ��ͬʱָ��id��
	 * ֮�����playSound�ȷ������ţ����ƣ�ͨ��id�ſ��Ʋ�ͬ������ �������ö���߳���ʵ�����ֵ�ͬ������
	 */

	/**
	 * ����soundpool�����Զ��岥������Ŀ
	 * 
	 * @param max
	 *            ��Ŀ
	 */
	public void initSoundP(int max) {
		maxStream = max;
		soundPool = new SoundPool(maxStream, AudioManager.STREAM_MUSIC,
				srcQuality);
		/** ��ʼ��HASH�� */
		soundPoolMap = new HashMap<Integer, Integer>();

	}

	/**
	 * ������Ƶ��Դ
	 * 
	 * @param priority
	 *            ���ȼ�
	 * @param context
	 *            Context����
	 * @param resId
	 *            ��ԴID
	 * @param position
	 *            ָ��������soundPoolMap�е�λ��
	 *            @return soundID
	 */
	public int loadSoundP(Context context, int resId, int position,
			int priority) {
		soundID = soundPool.load(context, resId, priority);
		soundPoolMap.put(position, soundID);
		return soundID;
	}

	/**
	 * ������Ƶ��Դ
	 * 
	 * @param priority
	 *            ���ȼ�
	 * @param afd
	 *            AssetFileDescriptor����
	 * @param position
	 *            ָ��������soundPoolMap�е�λ��
	 *            @return soundID
	 */
	public int loadSoundP(AssetFileDescriptor afd, int position, int priority
			) {
		/** prioriyt��ǰû��Ч����������Ϊ1 */
		soundID = soundPool.load(afd, priority);
		soundPoolMap.put(position, soundID);
		return soundID;
	}

	/**
	 * ������Ƶ��Դ
	 * 
	 * @param priority
	 *            ���ȼ�
	 * @param path
	 *            �����ļ�·��
	 * @param position
	 *            ָ��������soundPoolMap�е�λ��
	 *            @return soundID
	 */
	public int loadSoundP(String path, int position, int priority) {
		soundID = soundPool.load(path, priority);
		soundPoolMap.put(position,soundID);
		return soundID;
	}

	/**
	 * ������Ƶ��Դ
	 * 
	 * @param priority
	 *            ���ȼ�
	 * @param fd
	 *            FileDescriptor����
	 * @param offset
	 *            ����
	 * @param length
	 *            ����
	 * @param position
	 *           ָ��������soundPoolMap�е�λ��
	 * @return soundID
	 */
	public int loadSoundP(FileDescriptor fd, long offset, long length,
			int position, int priority) {
		soundID = soundPool.load(fd, offset, length, priority);
		soundPoolMap.put(position,soundID);
		return soundID;
	}

	/**
	 * ����ָ����Ƶ����Ч��������һ��streamID
	 * 
	 * @param soundID
	 *            ����ID��hash���е�λ��
	 * @param priority
	 *            ���ȼ�
	 * @param loop
	 *            loop=0:����һ��;loop=-1:ѭ��;loop=n:����n-1��
	 * @param rate
	 *            ����Ƶ��
	 * @param volume
	 *            ����
	 * @return bool
	 */
	public int playSound(int soundID, int priority, int loop, float rate,
			float volume) {

		/** ʹ���ֻ���ǰ�������� */
		if(soundID<soundPoolMap.size()){
			streamID = soundPool.play(soundPoolMap.get(soundID), volume, volume, 1,
					loop, rate);
		}
		
		return streamID;

	}

	/**
	 * ��ͣ
	 * 
	 * @param streamID
	 *            ������ID
	 */
	public void pause(int streamID) {
		if (streamID != 0) {
			soundPool.pause(streamID);
		}
	}

	/**
	 * �ָ�����
	 * 
	 * @param streamID
	 *            ������ID
	 */
	public void resume(int streamID) {
		if (streamID != 0) {
			soundPool.resume(streamID);
		}
	}

	/**
	 * ֹͣ
	 * 
	 * @param streamID
	 *            ������ID
	 */
	public void stop(int streamID) {
		if (streamID != 0) {
			soundPool.stop(streamID);
		}
	}

	/**
	 * ����ָ����������ѭ��
	 * 
	 * @param streamID
	 *            ������ID
	 * @param loop
	 *            loop=0:����һ��;loop=-1:ѭ��;loop=n:����n-1��
	 */
	public void setLoop(int streamID, int loop) {
		soundPool.setLoop(streamID, loop);
	}

	/**
	 * ����ָ��������������
	 * 
	 * @param streamID
	 *            ������ID
	 * @param leftVolume
	 *            ������
	 * @param rightVolume
	 *            ������
	 */
	public void setVolume(int streamID, float leftVolume, float rightVolume) {
		soundPool.setVolume(streamID, leftVolume, rightVolume);
	}

	/**
	 * ����ָ�������������ȼ�
	 * 
	 * @param streamID
	 *            ������ID
	 * @param priority
	 *            ���ȼ�
	 */
	public void setPriority(int streamID, int priority) {
		soundPool.setPriority(streamID, priority);
	}

	/**
	 * ����ָ�������������ʣ�0.5-2.0
	 * 
	 * @param streamID
	 *            ������ID
	 * @param rate
	 *            ��������
	 */
	public void setRate(int streamID, float rate) {
		soundPool.setRate(streamID, rate);
	}

	/**
	 * ж��һ��ָ������Ƶ��Դ
	 * 
	 * @param soundID
	 *            ����ID
	 */
	public void unload(int soundID) {
		soundPool.unload(soundID);
	}

	/**
	 * �ͷ�SoundPool�е�������Ƶ��Դ
	 */
	public void release() {
		soundPool.release();
	}

  

}
