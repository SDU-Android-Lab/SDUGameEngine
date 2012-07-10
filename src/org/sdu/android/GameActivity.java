package org.sdu.android;

import org.sdu.android.control.ControlListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * 游戏的主Activity
 * 
 * @author shadow
 * 
 */
public class GameActivity extends Activity {
	/** 显示的view */
	private GameView view;
	/**事件监听器*/
	private ControlListener controlListener;
	/**顶层布局管理器*/
	private FrameLayout frameLayout;

	/**
	 * @param bundle 传入bundle
	 */
	@Override
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		//无title     
	    requestWindowFeature(Window.FEATURE_NO_TITLE);     
	     //全屏     
	    getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,       
	                   WindowManager.LayoutParams. FLAG_FULLSCREEN);    
		frameLayout=new FrameLayout(this);
		initialize();
		
	}
	/**
	 * 得到内部view
	 * 
	 * @return 内部view
	 */
	public GameView getView() {
		return view;
	}

	/**
	 * 设置内部view
	 * 
	 * @param view
	 *            要设置的view
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
	 * 构造方法
	 */
	public GameActivity() {

	}
	//TODO 多种初始化方式
	/**
	 * 系统默认的初始化方法
	 * 构建默认触屏监听器、控件管理器、设置帧速率为30
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

	/** 摧毁方法  */
	protected void onDestroy() {
		try {
			if (this.view != null) {
				this.view.setRunning(false);
			}
		} finally {
			super.onDestroy();
		}
	}

	// TODO 完善暂停,目前只是停止了View的刷新
	/**
	 * 暂停
	 */
	@Override
	protected void onPause() {
		super.onPause();
		SystemData.getCurrentView().setRunning(false);
	}

	// TODO 完善重回
	/**
	 * 重回场景
	 */
	@Override
	protected void onResume() {
		super.onResume();
	}

	// TODO 完善停止
	/**
	 * 停止
	 */
	@Override
	protected void onStop() {
		super.onStop();
	}

	// TODO 完善重开始
	/**
	 * 重开始
	 */
	protected void onRestart() {
		super.onRestart();
	}

	// TODO 完善开始
	/*
	 * 1、Activity 从创建到进入运行态所触发的事件 onCreate()-->onStart-->onResume()
	 * 2、从运行态到停止态所触发的事件 onPause()--->onStop()
	 * 3、从停止态到运行态所触发事件onRestart()-->onStart()--->onResume() 
	 * 4、从运行态到暂停态所触发事件 onPause()
	 * 5、从暂停态到运行态所触发事件 onResume()
	 */
	/**
	 * 开始
	 */
	protected void onStart() {
		super.onStart();
	}
	/**
	 * 设置事件监听器
	 * @param controlListener 事件监听器
	 */
	public void setControlListener(ControlListener controlListener) {
		this.controlListener = controlListener;
		SystemData.setControlListener(controlListener);
	}
	/**
	 * 得到当前事件监听器
	 * @return 当前时间监听器
	 */
	public ControlListener getControlListener() {
		return controlListener;
	}
	/**
	 * 触屏监听
	 * @param event 触屏事件
	 * @return 触屏事件boolean
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event){
		return controlListener.onTouchEvent(event);
	}
	
}
