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
 * ��ƵSound��Ĳ���
 * @author yyt
 *
 */
public class SoundTest extends GameActivity{

	/** �½�һ��Ĭ��λ�õ�ҡ��*/
	final GameRocker control=new GameRocker(1);
	/**	�½������*/
	ComponentLevel clevel=new ComponentLevel();
	/**�½�Sound����*/
	Sound s=new Sound();
	/** ����һ��AudioManager���󲢻�ȡϵͳ���� */
	AudioManager am;
	
	//TextView med=new TextView(this);
	//TextView pool=new TextView(this);
	/** ������ID */
	int streamID[]=new int[3];
	/** ����ID */
	int soundID[]=new int[3];
	/** ���� */
	float volume;
	/**��¼�������ָ���*/
	static int count=0;
	/**��¼�������ֵ�λ��*/
	static int id=0;
	/**��ťid*/
	final int bid[]={1,2,3,4,5,6,7,8,9,10,11};
	/**	��ťλ��	 */
	public final int x1 =10;
	/**	��ťλ��	 */
	public final int y1=10;
	/**	��ťλ��	 */
	public final int y2=60;
	
	/** ��ͣ��ť�ı���ͼƬ*/
	SImage[] pause = { SImage.createImage("/res/pause.png"),
			SImage.createImage("/res/pause1.png"),
			SImage.createImage("/res/icon3.png") };
	/** ֹͣ��ť�ı���ͼƬ*/
	SImage[] stop = { SImage.createImage("/res/stop.png"),
			SImage.createImage("/res/stop1.png"),
			SImage.createImage("/res/icon.png") };
	/** ���Ű�ť�ı���ͼƬ*/
	SImage[] start = { SImage.createImage("/res/start.png"),
			SImage.createImage("/res/start1.png"),
			SImage.createImage("/res/icon2.png") };
	/** ���ذ�ť�ı���ͼƬ*/
	SImage[] load = { SImage.createImage("/res/load.png"),
			SImage.createImage("/res/load1.png"),
			SImage.createImage("/res/icon2.png") };
	/** ж�ذ�ť�ı���ͼƬ*/
	SImage[] unload = { SImage.createImage("/res/unload.png"),
			SImage.createImage("/res/unload1.png"),
			SImage.createImage("/res/icon2.png") };
	/**
	 * Mediaplayer�İ�ť
	 */
	/** ��ͣ��ť*/
	GameButton pauseb = new GameButton(bid[1], pause, x1+y2, y1);
	/** ֹͣ��ť*/
	GameButton stopb = new GameButton(bid[2], stop, x1+y2+y2, y1);
	/** ���Ű�ť*/
	GameButton startb = new GameButton(bid[0], start, x1, y1);
	/**
	 * SoundPool�İ�ť
	 */
	/** �½�һ��ָ��λ�õİ�ť*/
	//GameButton startb1 = new GameButton(1, start, x1+40, y2);
	/** ���Ű�ť*/
	GameButton playb1 = new GameButton(bid[9], start, x1+y2+y2, y2);
	
	/** ���ذ�ť*/
	GameButton init1 = new GameButton(bid[3], load, x1, y2);
	/** ���ذ�ť*/
	GameButton init2 = new GameButton(bid[4], load, x1, y2+y2);
	/** ���ذ�ť*/
	GameButton init3 = new GameButton(bid[5], load, x1, y2+y2+y2);
	
	/** ж�ذ�ť*/
	GameButton unload1 = new GameButton(bid[6], unload, x1+y2, y2);
	/** ж�ذ�ť*/
	GameButton unload2 = new GameButton(bid[7], unload, x1+y2, y2+y2);
	/** ж�ذ�ť*/
	GameButton unload3 = new GameButton(bid[8], unload, x1+y2, y2+y2+y2);
	/** �ͷ���Դ��ť*/
	GameButton release = new GameButton(bid[10], unload, x1+y2+y2, y2+y2);
	/**
	 * ��ڷ���
	 * @param bundle bundle
	 */
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		/**��ȡ��ǰϵͳ�����AudioMananger����*/
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
	 * �ڲ��࣬��ť�ļ�����
	 * @author shadow
	 *
	 */
	class PauseListener implements GameActionListener{
		/**
		 * ��ť��������
		 * @param e event
		 */
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			s.pauseBSound();
			
			}
		
	}
	/**
	 * �ڲ��࣬��ť�ļ�����
	 * @author shadow
	 *
	 */
	class StopListener implements GameActionListener{
		/**
		 * ��ť��������
		 * @param e event
		 */
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			s.stopBSound();
			
			}
		
	}
	/**
	 * �ڲ��࣬��ť�ļ�����
	 * @author shadow
	 *
	 */
	class StartListener implements GameActionListener{
		/**
		 * ��ť��������
		 * @param e event
		 */
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			//s.playBSound(SoundTest.this,R.drawable.sadangel, true);
			
			}
		
	}
	/**
	 * �ڲ��࣬��ť�ļ�����
	 * @author shadow
	 *
	 */
	class InitListener implements GameActionListener{
		/**
		 * ��ť��������
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
	 * �ڲ��࣬��ť�ļ�����
	 * @author shadow
	 *
	 */
	class UnloadListener implements GameActionListener{
		/**
		 * ��ť��������
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
	 * �ڲ��࣬��ť�ļ�����
	 * @author shadow
	 *
	 */
	class Play1Listener implements GameActionListener{
		/**
		 * ��ť��������
		 * @param e event
		 */
		
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent e) {
			/**��ȡ��ǰϵͳ�����AudioMananger����*/
			am=(AudioManager)getSystemService(AUDIO_SERVICE);
			/** ��õ�ǰ���� */
			volume = am.getStreamVolume(AudioManager.STREAM_MUSIC);

				for(int i=0;i<count;i++){
					streamID[i]=s.playSound(i, 1, 0, 1,volume);
				}
			
			}
		
	}
	/**
	 * �ڲ��࣬��ť�ļ�����
	 * @author shadow
	 *
	 */
	class ReleaseListener implements GameActionListener{
		/**
		 * ��ť��������
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
	 * �ڲ��࣬ҡ�˵ļ�����
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
