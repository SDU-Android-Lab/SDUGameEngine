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
 * ������Ӧ������
 * @author yyt
 * 
 */
public class SensorTest extends Sensor {
	
	/**	�½������*/
	ComponentLevel clevel=new ComponentLevel();
	/** ��ͣ��ť�ı���ͼƬ*/
	SImage[] pause = { SImage.createImage("/res/pause.png"),
			SImage.createImage("/res/pause1.png"),
			SImage.createImage("/res/icon3.png") };
	/**	��ťλ��	 */
	public int x2 =0;
	/**	��ťλ��	 */
	public int y2=0;
	/** ��ͣ��ť*/
	GameButton pauseb = new GameButton(1, pause, x2, y2);
	/**���ڻ����Ļ�ֱ���*/
	DisplayMetrics dm;
	
	/**��ť���´���*/
	int count=0;
	/**
	 * ��ڷ���
	 * @param savedInstanceState Bundle����
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	    //������Ļ��Ϊ����
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

	    //�����Ļ�ֱ���
	    dm=new DisplayMetrics();  
	    getWindowManager().getDefaultDisplay().getMetrics(dm);  

		SystemData.setCurrentComponentLevel(clevel);
		pauseb.setActionListener(new PauseListener());
		clevel.add(pauseb);
		pauseb.setVisible(true);

	}
	/**
	 * ������Ӧ����
	 * @param x x����
	 * @param y y����
	 * @param z z����
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

			count++;
			if(count%2!=0){
				close();
			}else{
				start();
			}
			
			}
		
	}
}

