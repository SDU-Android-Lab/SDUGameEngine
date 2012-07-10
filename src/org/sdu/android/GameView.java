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
 * ��Ϸͨ����ʾView���Դ�ˢ���߳�
 * @author shadow
 *
 */
public class GameView extends SurfaceView implements Callback, Runnable {
	/**Surface������*/
	private SurfaceHolder sfh;
	/**ˢ���߳�*/
	private Thread updateThread;
	/**���滭��*/
	private Canvas canvas;
	/**����*/
	private Paint paint;
	/**��Ļ��*/
	public static int ScreenW;
	/**��Ļ��*/
	public static int ScreenH;
	/**�Ƿ�����*/
	private boolean running=true;
	/**������ɫ*/
	private int baseColor=Color.WHITE;
	/**
	 * GameView ���췽��
	 * @param context �ϲ�����
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
	 * ����Surface
	 * @param holder SurfaceHolder
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		ScreenW = getWidth();
		ScreenH = getHeight();
		updateThread.start();
	}
	/**
	 * ��ʼ��Surface
	 */
	public void load(){
		setFocusable(true);
		setFocusableInTouchMode(true);
	}
	/**
	 * ���Ʒ���
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
	 * ����ˢ�£������齨ˢ�ºͳ���ˢ��������
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
	 * ˢ�����߳�
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
	 * @param holder  �����ı��holder 
	 * @param format  �µ�PixelFormat 
	 * @param width   �µĿ��
	 * @param height  �µĸ߶� 
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}
	/**
	 * @param holder ���ݻ�Surface��Holder
	 */
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	/**
	 * ���õ�ǰScene
	 * @param currentScene ��ǰScene
	 */
	public void setCurrentScene(SceneInterface currentScene) {
		SystemData.setCurrentScene(currentScene);
	}
	/**
	 * ��ȡ��ǰScene
	 * @return Scene����
	 */
	public SceneInterface getCurrentScene() {
		return SystemData.getCurrentScene();
	}
	/**
	 * ���õ�ǰfps
	 * @param fps ������fps
	 */
	public void setFps(int fps) {
		SystemData.setCurrentFPS(fps);
	}
	/**
	 * ��ȡ��ǰfps
	 * @return ������ʾ�ĵ�ǰfps
	 */
	public int getFps() {
		return SystemData.getCurrentFPS();
	}
	/**
	 * �����Ƿ�����
	 * @param running �趨״̬
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	/**
	 * ��ǰ����״̬
	 * @return ��ǰ����״̬
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
