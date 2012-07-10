package org.sdu.test;

import org.sdu.android.GameActivity;
import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.control.GameRockerListener;
import org.sdu.android.control.window.GameButton;
import org.sdu.android.control.window.GameRocker;
import org.sdu.android.control.window.UIAdapter;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.util.graphicsUtil.SImage;
import org.sdu.android.util.mediaUtil.Sound;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.MotionEvent;
/**
 * 音频Sound类的测试
 * @author yyt
 *
 */
public class SoundTest extends GameActivity{

	/** 新建一个默认位置的摇杆*/
	final GameRocker control=new GameRocker(1);
	/**	新建组件层*/
	ComponentLevel clevel=new ComponentLevel();
	/**新建Sound对象*/
	Sound s=new Sound();
	/** 声明一个AudioManager对象并获取系统服务 */
	AudioManager am;
	
	//TextView med=new TextView(this);
	//TextView pool=new TextView(this);
	/** 声音流ID */
	int streamID[]=new int[3];
	/** 声音ID */
	int soundID[]=new int[3];
	/** 音量 */
	float volume;
	/**记录加载音乐个数*/
	static int count=0;
	/**记录加载音乐的位置*/
	static int id=0;
	/**按钮id*/
	final int bid[]={1,2,3,4,5,6,7,8,9,10,11};
	/**	按钮位置	 */
	public final int x1 =10;
	/**	按钮位置	 */
	public final int y1=10;
	/**	按钮位置	 */
	public final int y2=60;
	
	/** 暂停按钮的背景图片*/
	SImage[] pause = { SImage.createImage("/res/pause.png"),
			SImage.createImage("/res/pause1.png"),
			SImage.createImage("/res/icon3.png") };
	/** 停止按钮的背景图片*/
	SImage[] stop = { SImage.createImage("/res/stop.png"),
			SImage.createImage("/res/stop1.png"),
			SImage.createImage("/res/icon.png") };
	/** 播放按钮的背景图片*/
	SImage[] start = { SImage.createImage("/res/start.png"),
			SImage.createImage("/res/start1.png"),
			SImage.createImage("/res/icon2.png") };
	/** 加载按钮的背景图片*/
	SImage[] load = { SImage.createImage("/res/load.png"),
			SImage.createImage("/res/load1.png"),
			SImage.createImage("/res/icon2.png") };
	/** 卸载按钮的背景图片*/
	SImage[] unload = { SImage.createImage("/res/unload.png"),
			SImage.createImage("/res/unload1.png"),
			SImage.createImage("/res/icon2.png") };
	/**
	 * Mediaplayer的按钮
	 */
	/** 暂停按钮*/
	GameButton pauseb = new GameButton(bid[1], pause, x1+y2, y1);
	/** 停止按钮*/
	GameButton stopb = new GameButton(bid[2], stop, x1+y2+y2, y1);
	/** 播放按钮*/
	GameButton startb = new GameButton(bid[0], start, x1, y1);
	/**
	 * SoundPool的按钮
	 */
	/** 新建一个指定位置的按钮*/
	//GameButton startb1 = new GameButton(1, start, x1+40, y2);
	/** 播放按钮*/
	GameButton playb1 = new GameButton(bid[9], start, x1+y2+y2, y2);
	
	/** 加载按钮*/
	GameButton init1 = new GameButton(bid[3], load, x1, y2);
	/** 加载按钮*/
	GameButton init2 = new GameButton(bid[4], load, x1, y2+y2);
	/** 加载按钮*/
	GameButton init3 = new GameButton(bid[5], load, x1, y2+y2+y2);
	
	/** 卸载按钮*/
	GameButton unload1 = new GameButton(bid[6], unload, x1+y2, y2);
	/** 卸载按钮*/
	GameButton unload2 = new GameButton(bid[7], unload, x1+y2, y2+y2);
	/** 卸载按钮*/
	GameButton unload3 = new GameButton(bid[8], unload, x1+y2, y2+y2+y2);
	/** 释放资源按钮*/
	GameButton release = new GameButton(bid[10], unload, x1+y2+y2, y2+y2);
	/**
	 * 入口方法
	 * @param bundle bundle
	 */
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		/**获取当前系统服务的AudioMananger对象*/
		am=(AudioManager)getSystemService(AUDIO_SERVICE);
		
		//med.setText("MediaPlayer");
		//med.layout(10, 10, 80, 30);
		//pool.setText("SoundPool");
		//pool.layout(10, 40, 80, 60);

		control.setActionListener(new RockerListener());
		pauseb.setActionListener(new PauseListener());
		startb.setActionListener(new StartListener());
		stopb.setActionListener(new StopListener());
		//startb1.setActionListener(new LoadListener());
		playb1.setActionListener(new Play1Listener());
		init1.setActionListener(new InitListener(1));
		init2.setActionListener(new InitListener(2));
		init3.setActionListener(new InitListener(3));
		unload1.setActionListener(new UnloadListener(1));
		unload2.setActionListener(new UnloadListener(2));
		unload3.setActionListener(new UnloadListener(3));
		release.setActionListener(new ReleaseListener());
		SystemData.setCurrentComponentLevel(clevel);
		clevel.add(control);
		clevel.add(pauseb);
		clevel.add(stopb);
		clevel.add(startb);
		//clevel.add(startb1);
		clevel.add(playb1);
		clevel.add(init1);
		clevel.add(init2);
		clevel.add(init3);
		clevel.add(unload1);
		clevel.add(unload2);
		clevel.add(unload3);
		clevel.add(release);
		
		control.setVisible(true);
		startb.setVisible(true);
		pauseb.setVisible(true);
		stopb.setVisible(true);
		playb1.setVisible(true);
		init1.setVisible(true);
		init2.setVisible(true);
		init3.setVisible(true);
		unload1.setVisible(true);
		unload2.setVisible(true);
		unload3.setVisible(true);
		release.setVisible(true);
		//startb1.setVisible(true);
	}
	
	/**
	 * 内部类，按钮的监听器
	 * @author shadow
	 *
	 */
	class PauseListener implements GameActionListener{
		/**
		 * 按钮监听方法
		 * @param e event
		 */
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			s.pauseBSound();
			
			}
		
	}
	/**
	 * 内部类，按钮的监听器
	 * @author shadow
	 *
	 */
	class StopListener implements GameActionListener{
		/**
		 * 按钮监听方法
		 * @param e event
		 */
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			s.stopBSound();
			
			}
		
	}
	/**
	 * 内部类，按钮的监听器
	 * @author shadow
	 *
	 */
	class StartListener implements GameActionListener{
		/**
		 * 按钮监听方法
		 * @param e event
		 */
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			//s.playBSound(SoundTest.this,R.drawable.sadangel, true);
			
			}
		
	}
	/**
	 * 内部类，按钮的监听器
	 * @author shadow
	 *
	 */
	class InitListener implements GameActionListener{
		/**
		 * 按钮监听方法
		 * @param e event
		 */
		int num;
		public InitListener(int num){
			this.num=num;
		}
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			
			if(count==0){
				s.initSoundP(3);
			}
			
			if(num==1){
				soundID[0]=s.loadSoundP(SoundTest.this,R.drawable.ao, id,1);
				id++;
				count++;
			}
			if(num==2){
				soundID[1]=s.loadSoundP(SoundTest.this,R.drawable.bibi, id,1);
				id++;
				count++;
			}
			if(num==3){
				soundID[2]=s.loadSoundP(SoundTest.this,R.drawable.mus, id,1);
				id++;
				count++;
			}
			
			
			}
		
	}
	/**
	 * 内部类，按钮的监听器
	 * @author shadow
	 *
	 */
	class UnloadListener implements GameActionListener{
		/**
		 * 按钮监听方法
		 * @param e event
		 */
		int num;
		public UnloadListener(int num){
			this.num=num;
		}
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			if(num==1){
				s.unload(soundID[0]);
				count--;
				id--;
			}
			if(num==2){
				s.unload(soundID[1]);
				count--;
				id--;
			}
			if(num==3){
				s.unload(soundID[2]);
				count--;
				id--;
			}
			
			}
		
	}
	/**
	 * 内部类，按钮的监听器
	 * @author shadow
	 *
	 */
	class Play1Listener implements GameActionListener{
		/**
		 * 按钮监听方法
		 * @param e event
		 */
		
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			/**获取当前系统服务的AudioMananger对象*/
			am=(AudioManager)getSystemService(AUDIO_SERVICE);
			/** 获得当前音量 */
			volume = am.getStreamVolume(AudioManager.STREAM_MUSIC);

				for(int i=0;i<count;i++){
					streamID[i]=s.playSound(i, 1, 0, 1,volume);
				}
			
			}
		
	}
	/**
	 * 内部类，按钮的监听器
	 * @author shadow
	 *
	 */
	class ReleaseListener implements GameActionListener{
		/**
		 * 按钮监听方法
		 * @param e event
		 */
		
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			s.release();
			count=0;
			id=0;
			}
	}
	/**
	 * 内部类，摇杆的监听器
	 * @author yyt
	 *
	 */
	class RockerListener implements GameRockerListener{
		
		/**
		 * @param event e
		 */
		@Override
		public void actionUp(MotionEvent event) {
			s.rVolume(am);
		}
		/**
		 * @param event e
		 */
		@Override
		public void actionDown(MotionEvent event) {
			s.lVolume(am);
		}
		/**
		 * @param event e
		 */
		@Override
		public void actionLeft(MotionEvent event) {
			s.silent(am);
		}
		/**
		 * @param event e
		 */
		@Override
		public void actionRight(MotionEvent event) {
			s.normal(am);
		}
		
	}

}
