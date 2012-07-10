package org.sdu.test;

import org.sdu.android.GameActivity;
import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.control.GameRockerListener;
import org.sdu.android.control.window.GameButton;
import org.sdu.android.control.window.GameMessageDialog;
import org.sdu.android.control.window.GameRocker;
import org.sdu.android.control.window.GameSplash;
import org.sdu.android.control.window.UIAdapter;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.util.graphicsUtil.SImage;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

/**
 * ��ť��UI��ʾ������
 * 
 * @author shadow
 * 
 */
public class UIActivity extends GameActivity {
	/** ��ť�ı���ͼƬ*/
	SImage[] skin = { SImage.createImage("/res/2.png"),
			SImage.createImage("/res/22.png"),
			SImage.createImage("/res/icon3.png") };
	/**	��ťλ��	 */
	public final int x2 =180;
	/**	��ťλ��	 */
	public final int y2=360;
	/** ֡����*/
	public final int fps=80;
	/** �½�һ��ָ��λ�õİ�ť*/
	public GameButton gb;
	/** �½�һ��Ĭ��λ�õ�ҡ��*/
	GameRocker gr;
	/**�Ի���*/
	GameMessageDialog gmd;
	/**����*/
	GameSplash gs;
	/**	�½������*/
	ComponentLevel clevel=new ComponentLevel();
	/**
	 * ��ڷ���
	 * @param bundle bundle
	 */
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		load();
		SystemData.setCurrentFPS(fps);
		SystemData.setCurrentComponentLevel(clevel);
		gmd.setVisible(true);
		gr.setVisible(true);
		gb.setVisible(true);
		gs.setVisible(true);
	}
	/**��ʼ��*/
	public void load(){
		gb = new GameButton(1, skin, x2, y2);
		gr=new GameRocker(2);
		gmd=new GameMessageDialog(0);
		gs=new GameSplash(0,
				new SImage[]{SImage.createImage("/res/splash2.png")});
		gb.setActionListener(new MyListener());
		gr.setActionListener(new RockerListener());
		gmd.setText("�Ұ������찲���찲����̫������ΰ������ë��ϯָ��������ǰ��"
				+"abcdefjhijklmnopqrstuvwxyz"
				+"!@#$%^&&*()_+{}|:");
	}
	/**
	 * �ڲ���1����ť�ļ�����
	 * @author shadow
	 *
	 */
	class MyListener implements GameActionListener{
		/**
		 * ��ť��������
		 * @param event event
		 */
		@Override
		public void actionPerformed(UIAdapter ui,MotionEvent event) {
			final int c=gr.getColorBack();
			gr.setColorBack(gr.getColorUp());
			gr.setColorUp(c);
			}
		
	}
	/**
	 * �ڲ���2��ҡ�˵ļ�����
	 * @author shadow
	 *
	 */
	class RockerListener implements GameRockerListener{
		/**
		 * for log
		 */
		String log="---->";
		/**
		 * �r(�s_�t)�q~
		 * @param event e
		 */
		@Override
		public void actionUp(MotionEvent event) {
			Log.e(log,"up~");
			gb.setY(gb.getY()-2);
		}
		/**
		 * �r(�s_�t)�q~
		 * @param event e
		 */
		@Override
		public void actionDown(MotionEvent event) {
			Log.e(log,"down~");
			gb.setY(gb.getY()+2);
		}
		/**
		 * �r(�s_�t)�q~
		 * @param event e
		 */
		@Override
		public void actionLeft(MotionEvent event) {
			Log.e(log,"left~");
			gb.setX(gb.getX()-2);
		}
		/**
		 * �r(�s_�t)�q~
		 * @param event e
		 */
		@Override
		public void actionRight(MotionEvent event) {
			Log.e(log,"right~");
			gb.setX(gb.getX()+2);			
		}
		
	}
}
