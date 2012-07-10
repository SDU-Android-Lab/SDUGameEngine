package org.sdu.test;
import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.control.window.GameButton;
import org.sdu.android.control.window.UIAdapter;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.util.graphicsUtil.SImage;
import org.sdu.android.util.sensorUtil.Sensor;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

/**
 * 重力感应测试类
 * @author yyt
 * 
 */
public class SensorTest extends Sensor {
	
	/**	新建组件层*/
	ComponentLevel clevel=new ComponentLevel();
	/** 暂停按钮的背景图片*/
	SImage[] pause = { SImage.createImage("/res/pause.png"),
			SImage.createImage("/res/pause1.png"),
			SImage.createImage("/res/icon3.png") };
	/**	按钮位置	 */
	public int x2 =0;
	/**	按钮位置	 */
	public int y2=0;
	/** 暂停按钮*/
	GameButton pauseb = new GameButton(1, pause, x2, y2);
	/**用于获得屏幕分辨率*/
	DisplayMetrics dm;
	
	/**按钮按下次数*/
	int count=0;
	/**
	 * 入口方法
	 * @param savedInstanceState Bundle对象
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	    //设置屏幕恒为纵向
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

	    //获得屏幕分辨率
	    dm=new DisplayMetrics();  
	    getWindowManager().getDefaultDisplay().getMetrics(dm);  

		SystemData.setCurrentComponentLevel(clevel);
		pauseb.setActionListener(new PauseListener());
		clevel.add(pauseb);
		pauseb.setVisible(true);

	}
	/**
	 * 设置相应操作
	 * @param x x坐标
	 * @param y y坐标
	 * @param z z坐标
	 */
	public void act(float x,float y,float z){

		final int n=10;
		final int m=40;
			x2=x2-(int)x*n;
			y2=y2+(int)y*n;
			if(x2<=0){
				x2=0;
			}
			if(y2<=0){
				y2=0;
			}
			if(x2>=dm.widthPixels-m){
				x2=dm.widthPixels-m;
			}
			if(y2>=dm.heightPixels-m){
				y2=dm.heightPixels-m;
			}
			pauseb.setX(x2);
			pauseb.setY(y2);
		
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

			count++;
			if(count%2!=0){
				close();
			}else{
				start();
			}
			
			}
		
	}
}

