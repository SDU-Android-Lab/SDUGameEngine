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
 * 声音控制方法： 需要在调用该方法的类中创建AudioManager对象，并使用
 * (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);获取系统服务
 * 再将其作为参数传入，来调用相关控制方法
 * 
 * @author yyt
 * 
 */
public class Sound {

	/** 同时播放的流的最大数量,默认为1 */
	int maxStream = 1;
	/** 采样率转化质量，当前无效果，使用0作为默认值 */
	int srcQuality = 0;
	/** 声明一个AudioManager对象 */
	// AudioManager am=
	// (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
	/** 声明一个MediaPlayer对象 */
	private MediaPlayer mp;
	/** 声明一个SoundPool对象 */
	SoundPool soundPool;
	/** 定义HASH表 */
	private HashMap<Integer, Integer> soundPoolMap;
	/** 声音ID */
	 int soundID;
	/** 声音流ID */
	int streamID=0;
	/** 判断音乐是否停止 */
	boolean stop = true;
	/** 是否静音 */
	boolean silence = false;

	// ===============================================================
	// 声音控制
	/**
	 * 调低声音
	 * 
	 * @param am
	 *            AudioManager对象
	 */
	public void lVolume(AudioManager am) {
		/** 减少声音音量 */
		am.adjustVolume(AudioManager.ADJUST_LOWER, 0);
	}

	/**
	 * 调高声音
	 * 
	 * @param am
	 *            AudioManager对象
	 */
	public void rVolume(AudioManager am) {
		/** 调大声音音量 */
		am.adjustVolume(AudioManager.ADJUST_RAISE, 0);
	}

	/**
	 * 静音
	 * 
	 * @param am
	 *            AudioManager对象
	 */
	public void silent(AudioManager am) {
		if (!silence) {
			am.setStreamMute(AudioManager.STREAM_MUSIC, true);
			silence = true;
		}

	}

	/**
	 * 从静音中恢复
	 * 
	 * @param am
	 *            AudioManager对象
	 */
	public void normal(AudioManager am) {
		if (silence) {
			am.setStreamMute(AudioManager.STREAM_MUSIC, false);
			silence = false;
		}

	}

	// ===============================================================
	// 背景音乐播放mediaplayer，直接调用playBSound自动加载和播放，
	// 根据不同的参数来确定不同 的加载方式

	/**
	 * 初始化MediaPlayer
	 */
	private void initMediaP() {
		if (stop) {
			mp = new MediaPlayer();
		}

	}

	/**
	 * 内部调用，加载资源后播放
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
	 * 通过资源id自动加载资源，播放背景音乐,设置是否循环播放
	 * 
	 * @param context
	 *            Context
	 * @param resid
	 *            资源id号
	 * @param isloop
	 *            设置是否循环播放的boolean值
	 */
	public void playBSound(Context context, int resid, boolean isloop) {
		if (stop) {
			mp = MediaPlayer.create(context, resid);
			stop = false;
		}
		mp.start();

		/** 循环播放？ */
		mp.setLooping(isloop);
	}

	/**
	 * 通过uri自动加载资源，播放背景音乐,设置是否循环播放
	 * 
	 * @param context
	 *            Context
	 * @param uri
	 *            Uri
	 * @param isloop
	 *            设置是否循环播放的boolean值
	 */
	public void playBSound(Context context, Uri uri, boolean isloop) {
		/** 以同步方式设置播放器进入prepare状态 */
		initMediaP();
		try {
			mp.setDataSource(context, uri);
		} catch (IOException e) {
			e.printStackTrace();
		}
		start();
		/** 循环播放？ */
		mp.setLooping(isloop);
	}

	/**
	 * 通过路径自动加载资源，播放背景音乐,设置是否循环播放
	 * 
	 * @param path
	 *            资源路径
	 * @param isloop
	 *            设置是否循环播放的boolean值
	 */
	public void playBSound(String path, boolean isloop) {
		initMediaP();
		try {
			mp.setDataSource(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		start();
		/** 循环播放？ */
		mp.setLooping(isloop);
	}

	/**
	 * 通过FileDescriptor自动加载资源，播放背景音乐,设置是否循环播放
	 * 
	 * @param fd
	 *            FileDescriptor对象
	 * @param isloop
	 *            设置是否循环播放的boolean值
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
	 * 暂停
	 */
	public void pauseBSound() {
		if (!stop) {
			mp.pause();
		}
	}

	/**
	 * 停止
	 */
	public void stopBSound() {
		if (!stop) {
			mp.stop();
			stop = true;
			/** 释放资源 */
			mp.release();
		}
	}

	// ===============================================================
	// 游戏音效播放soundpool
	/**
	 * 
	 * 调用loadSoundP加载音乐，不同的参数表示不同的加载方式，同时指明id号
	 * 之后调用playSound等方法播放，控制，通过id号控制不同的音乐 可以利用多个线程来实现音乐的同步播放
	 */

	/**
	 * 创建soundpool对象，自定义播放流数目
	 * 
	 * @param max
	 *            数目
	 */
	public void initSoundP(int max) {
		maxStream = max;
		soundPool = new SoundPool(maxStream, AudioManager.STREAM_MUSIC,
				srcQuality);
		/** 初始化HASH表 */
		soundPoolMap = new HashMap<Integer, Integer>();

	}

	/**
	 * 加载音频资源
	 * 
	 * @param priority
	 *            优先级
	 * @param context
	 *            Context对象
	 * @param resId
	 *            资源ID
	 * @param position
	 *            指定声音在soundPoolMap中的位置
	 *            @return soundID
	 */
	public int loadSoundP(Context context, int resId, int position,
			int priority) {
		soundID = soundPool.load(context, resId, priority);
		soundPoolMap.put(position, soundID);
		return soundID;
	}

	/**
	 * 加载音频资源
	 * 
	 * @param priority
	 *            优先级
	 * @param afd
	 *            AssetFileDescriptor对象
	 * @param position
	 *            指定声音在soundPoolMap中的位置
	 *            @return soundID
	 */
	public int loadSoundP(AssetFileDescriptor afd, int position, int priority
			) {
		/** prioriyt当前没有效果建议设置为1 */
		soundID = soundPool.load(afd, priority);
		soundPoolMap.put(position, soundID);
		return soundID;
	}

	/**
	 * 加载音频资源
	 * 
	 * @param priority
	 *            优先级
	 * @param path
	 *            音乐文件路径
	 * @param position
	 *            指定声音在soundPoolMap中的位置
	 *            @return soundID
	 */
	public int loadSoundP(String path, int position, int priority) {
		soundID = soundPool.load(path, priority);
		soundPoolMap.put(position,soundID);
		return soundID;
	}

	/**
	 * 加载音频资源
	 * 
	 * @param priority
	 *            优先级
	 * @param fd
	 *            FileDescriptor对象
	 * @param offset
	 *            ？？
	 * @param length
	 *            长度
	 * @param position
	 *           指定声音在soundPoolMap中的位置
	 * @return soundID
	 */
	public int loadSoundP(FileDescriptor fd, long offset, long length,
			int position, int priority) {
		soundID = soundPool.load(fd, offset, length, priority);
		soundPoolMap.put(position,soundID);
		return soundID;
	}

	/**
	 * 播放指定音频的音效，并返回一个streamID
	 * 
	 * @param soundID
	 *            声音ID在hash表中的位置
	 * @param priority
	 *            优先级
	 * @param loop
	 *            loop=0:播放一次;loop=-1:循环;loop=n:播放n-1次
	 * @param rate
	 *            播放频率
	 * @param volume
	 *            音量
	 * @return bool
	 */
	public int playSound(int soundID, int priority, int loop, float rate,
			float volume) {

		/** 使用手机当前音量播放 */
		if(soundID<soundPoolMap.size()){
			streamID = soundPool.play(soundPoolMap.get(soundID), volume, volume, 1,
					loop, rate);
		}
		
		return streamID;

	}

	/**
	 * 暂停
	 * 
	 * @param streamID
	 *            声音流ID
	 */
	public void pause(int streamID) {
		if (streamID != 0) {
			soundPool.pause(streamID);
		}
	}

	/**
	 * 恢复播放
	 * 
	 * @param streamID
	 *            声音流ID
	 */
	public void resume(int streamID) {
		if (streamID != 0) {
			soundPool.resume(streamID);
		}
	}

	/**
	 * 停止
	 * 
	 * @param streamID
	 *            声音流ID
	 */
	public void stop(int streamID) {
		if (streamID != 0) {
			soundPool.stop(streamID);
		}
	}

	/**
	 * 设置指定播放流的循环
	 * 
	 * @param streamID
	 *            声音流ID
	 * @param loop
	 *            loop=0:播放一次;loop=-1:循环;loop=n:播放n-1次
	 */
	public void setLoop(int streamID, int loop) {
		soundPool.setLoop(streamID, loop);
	}

	/**
	 * 设置指定播放流的音量
	 * 
	 * @param streamID
	 *            声音流ID
	 * @param leftVolume
	 *            左声道
	 * @param rightVolume
	 *            右声道
	 */
	public void setVolume(int streamID, float leftVolume, float rightVolume) {
		soundPool.setVolume(streamID, leftVolume, rightVolume);
	}

	/**
	 * 设置指定播放流的优先级
	 * 
	 * @param streamID
	 *            声音流ID
	 * @param priority
	 *            优先级
	 */
	public void setPriority(int streamID, int priority) {
		soundPool.setPriority(streamID, priority);
	}

	/**
	 * 设置指定播放流的速率，0.5-2.0
	 * 
	 * @param streamID
	 *            声音流ID
	 * @param rate
	 *            播放速率
	 */
	public void setRate(int streamID, float rate) {
		soundPool.setRate(streamID, rate);
	}

	/**
	 * 卸载一个指定的音频资源
	 * 
	 * @param soundID
	 *            声音ID
	 */
	public void unload(int soundID) {
		soundPool.unload(soundID);
	}

	/**
	 * 释放SoundPool中的所有音频资源
	 */
	public void release() {
		soundPool.release();
	}

  

}
