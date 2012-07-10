package org.sdu.android;

import java.util.Date;

import org.sdu.android.map.painter.scene.SceneInterface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.InflateException;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * 游戏通用显示View，自带刷新线程
 * @author shadow
 *
 */
public class GameView extends SurfaceView implements Callback, Runnable {
	/**Surface控制器*/
	private SurfaceHolder sfh;
	/**刷新线程*/
	private Thread updateThread;
	/**缓存画布*/
	private Canvas canvas;
	/**画笔*/
	private Paint paint;
	/**屏幕宽*/
	public static int ScreenW;
	/**屏幕长*/
	public static int ScreenH;
	/**是否运行*/
	private boolean running=true;
	/**清屏颜色*/
	private int baseColor=Color.WHITE;
	/**
	 * GameView 构造方法
	 * @param context 上层容器
	 */
	public GameView(Context context) {
		super(context);
		updateThread = new Thread(this);
		sfh = this.getHolder();
		sfh.addCallback(this);
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setColor(Color.RED);
		this.setKeepScreenOn(true);

	}
	/**
	 * 创建Surface
	 * @param holder SurfaceHolder
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		ScreenW = getWidth();
		ScreenH = getHeight();
		updateThread.start();
	}
	/**
	 * 初始化Surface
	 */
	public void load(){
		setFocusable(true);
		setFocusableInTouchMode(true);
	}
	/**
	 * 绘制方法
	 */
	private void draw() {
		try {
			canvas = sfh.lockCanvas(); 
			canvas.drawColor(baseColor);
			gameUpdate();   
		} catch (InflateException ex) {
			ex.printStackTrace();
		}
		finally { 
			if (canvas != null){
				sfh.unlockCanvasAndPost(canvas);} 
		}
	}
	
	/**
	 * 数据刷新，包括组建刷新和场景刷新两部分
	 */
	public void gameUpdate(){
		if(SystemData.getCurrentScene()!=null){
			SystemData.getCurrentScene().onDraw(canvas,null);
		}
		if(SystemData.getCurrentComponentLevel()!=null){
			SystemData.getCurrentComponentLevel().onDraw(canvas,null);
		}
		
	}
	/**
	 * 刷新主线程
	 */
	public void run() {
	
		while (running) {
			final long STARTT=new Date().getTime();
			draw();
			try {
			final long ENDT=new Date().getTime();
			final long t=Math.max(0, SystemData.getSleepTime()-(ENDT-STARTT));
			Thread.sleep(t);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *
	 * @param holder  发生改变的holder 
	 * @param format  新的PixelFormat 
	 * @param width   新的宽度
	 * @param height  新的高度 
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}
	/**
	 * @param holder 被摧毁Surface的Holder
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	/**
	 * 设置当前Scene
	 * @param currentScene 当前Scene
	 */
	public void setCurrentScene(SceneInterface currentScene) {
		SystemData.setCurrentScene(currentScene);
	}
	/**
	 * 获取当前Scene
	 * @return Scene对象
	 */
	public SceneInterface getCurrentScene() {
		return SystemData.getCurrentScene();
	}
	/**
	 * 设置当前fps
	 * @param fps 整数的fps
	 */
	public void setFps(int fps) {
		SystemData.setCurrentFPS(fps);
	}
	/**
	 * 获取当前fps
	 * @return 整数表示的当前fps
	 */
	public int getFps() {
		return SystemData.getCurrentFPS();
	}
	/**
	 * 设置是否运行
	 * @param running 设定状态
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	/**
	 * 当前运行状态
	 * @return 当前运行状态
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * @param baseColor the baseColor to set
	 */
	public void setBaseColor(int baseColor) {
		this.baseColor = baseColor;
	}
	/**
	 * @return the baseColor
	 */
	public int getBaseColor() {
		return baseColor;
	}


}
