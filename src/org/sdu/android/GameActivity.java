package org.sdu.android;

import org.sdu.android.control.ControlListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * ��Ϸ����Activity
 * 
 * @author shadow
 * 
 */
public class GameActivity extends Activity {
	/** ��ʾ��view */
	private GameView view;
	/**�¼�������*/
	private ControlListener controlListener;
	/**���㲼�ֹ�����*/
	private FrameLayout frameLayout;

	/**
	 * @param bundle ����bundle
	 */
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		//��title     
	    requestWindowFeature(Window.FEATURE_NO_TITLE);     
	     //ȫ��     
	    getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,       
	                   WindowManager.LayoutParams. FLAG_FULLSCREEN);    
		frameLayout=new FrameLayout(this);
		initialize();
		
	}
	/**
	 * �õ��ڲ�view
	 * 
	 * @return �ڲ�view
	 */
	public GameView getView() {
		return view;
	}

	/**
	 * �����ڲ�view
	 * 
	 * @param view
	 *            Ҫ���õ�view
	 */
	public void setView(final GameView view) {
		runOnUiThread(new Runnable(){
			@Override
			public void run() {
				GameActivity.this.view = view;
				frameLayout.removeAllViews();
				frameLayout.addView(view);
				SystemData.setCurrentView(view);
			}
			
		});
		
	}

	/**
	 * ���췽��
	 */
	public GameActivity() {

	}
	//TODO ���ֳ�ʼ����ʽ
	/**
	 * ϵͳĬ�ϵĳ�ʼ������
	 * ����Ĭ�ϴ������������ؼ�������������֡����Ϊ30
	 */
	public void initialize() {
		controlListener=new ControlListener();
		view =new GameView(this);
		frameLayout.addView(view);
		this.setContentView(frameLayout);
		SystemData.setControlListener(controlListener);
		SystemData.setCurrentFPS(SystemData.DEFALUTFPS);
		SystemData.setCurrentView(view);
		SystemData.setCurrentActivity(this);
	}

	/** �ݻٷ���  */
	protected void onDestroy() {
		try {
			if (this.view != null) {
				this.view.setRunning(false);
			}
		} finally {
			super.onDestroy();
		}
	}

	// TODO ������ͣ,Ŀǰֻ��ֹͣ��View��ˢ��
	/**
	 * ��ͣ
	 */
	@Override
	protected void onPause() {
		super.onPause();
		SystemData.getCurrentView().setRunning(false);
	}

	// TODO �����ػ�
	/**
	 * �ػس���
	 */
	@Override
	protected void onResume() {
		super.onResume();
	}

	// TODO ����ֹͣ
	/**
	 * ֹͣ
	 */
	@Override
	protected void onStop() {
		super.onStop();
	}

	// TODO �����ؿ�ʼ
	/**
	 * �ؿ�ʼ
	 */
	protected void onRestart() {
		super.onRestart();
	}

	// TODO ���ƿ�ʼ
	/*
	 * 1��Activity �Ӵ�������������̬���������¼� onCreate()-->onStart-->onResume()
	 * 2��������̬��ֹ̬ͣ���������¼� onPause()--->onStop()
	 * 3����ֹ̬ͣ������̬�������¼�onRestart()-->onStart()--->onResume() 
	 * 4��������̬����̬ͣ�������¼� onPause()
	 * 5������̬ͣ������̬�������¼� onResume()
	 */
	/**
	 * ��ʼ
	 */
	protected void onStart() {
		super.onStart();
	}
	/**
	 * �����¼�������
	 * @param controlListener �¼�������
	 */
	public void setControlListener(ControlListener controlListener) {
		this.controlListener = controlListener;
		SystemData.setControlListener(controlListener);
	}
	/**
	 * �õ���ǰ�¼�������
	 * @return ��ǰʱ�������
	 */
	public ControlListener getControlListener() {
		return controlListener;
	}
	/**
	 * ��������
	 * @param event �����¼�
	 * @return �����¼�boolean
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event){
		return controlListener.onTouchEvent(event);
	}
	
}
