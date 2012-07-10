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
 * 按钮和UI的示例程序
 * 
 * @author shadow
 * 
 */
public class UIActivity extends GameActivity {
	/** 按钮的背景图片*/
	SImage[] skin = { SImage.createImage("/res/2.png"),
			SImage.createImage("/res/22.png"),
			SImage.createImage("/res/icon3.png") };
	/**	按钮位置	 */
	public final int x2 =180;
	/**	按钮位置	 */
	public final int y2=360;
	/** 帧速率*/
	public final int fps=80;
	/** 新建一个指定位置的按钮*/
	public GameButton gb;
	/** 新建一个默认位置的摇杆*/
	GameRocker gr;
	/**对话框*/
	GameMessageDialog gmd;
	/**闪屏*/
	GameSplash gs;
	/**	新建组件层*/
	ComponentLevel clevel=new ComponentLevel();
	/**
	 * 入口方法
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
	/**初始化*/
	public void load(){
		gb = new GameButton(1, skin, x2, y2);
		gr=new GameRocker(2);
		gmd=new GameMessageDialog(0);
		gs=new GameSplash(0,
				new SImage[]{SImage.createImage("/res/splash2.png")});
		gb.setActionListener(new MyListener());
		gr.setActionListener(new RockerListener());
		gmd.setText("我爱北京天安门天安门上太阳升，伟大领袖毛主席指引我们向前进"
				+"abcdefjhijklmnopqrstuvwxyz"
				+"!@#$%^&&*()_+{}|:");
	}
	/**
	 * 内部类1，按钮的监听器
	 * @author shadow
	 *
	 */
	class MyListener implements GameActionListener{
		/**
		 * 按钮监听方法
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
	 * 内部类2，摇杆的监听器
	 * @author shadow
	 *
	 */
	class RockerListener implements GameRockerListener{
		/**
		 * for log
		 */
		String log="---->";
		/**
		 * ╮(╯_╰)╭~
		 * @param event e
		 */
		@Override
		public void actionUp(MotionEvent event) {
			Log.e(log,"up~");
			gb.setY(gb.getY()-2);
		}
		/**
		 * ╮(╯_╰)╭~
		 * @param event e
		 */
		@Override
		public void actionDown(MotionEvent event) {
			Log.e(log,"down~");
			gb.setY(gb.getY()+2);
		}
		/**
		 * ╮(╯_╰)╭~
		 * @param event e
		 */
		@Override
		public void actionLeft(MotionEvent event) {
			Log.e(log,"left~");
			gb.setX(gb.getX()-2);
		}
		/**
		 * ╮(╯_╰)╭~
		 * @param event e
		 */
		@Override
		public void actionRight(MotionEvent event) {
			Log.e(log,"right~");
			gb.setX(gb.getX()+2);			
		}
		
	}
}
