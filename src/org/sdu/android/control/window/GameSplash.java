
package org.sdu.android.control.window;

import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.sprite.change.AlphaChange;
import org.sdu.android.util.graphicsUtil.SImage;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * 游戏开始、GameOver、退出游戏时候的闪屏
 * @author shadow
 *
 */
public class GameSplash extends UIAdapter{
	
	/**计时器*/
	private int timer; 
	/**效果1 渐渐消失*/
	public static final int SPLASH_DISPOSE=0;
	/**效果2 渐渐出现*/
	public static final int SPLASH_APPEAR=1;
	/**效果3 闪烁*/
	public static final int SPLASH_FLASH=2;
	/**默认速度*/
	public static final int DEFAULT_SPEED=10;
	/**默认透明度改变值*/
	public static final int CHANGE_VALUE=10;
	/**最大透明度*/
	public static final int MAX_ALP=255;
	/**当前效果*/
	private int currentSplash=SPLASH_APPEAR;
	/**当前速度*/
	private int currentSpeed=DEFAULT_SPEED;
	/**图像数组*/
	SImage[] si;
	/**是否运行*/
	private boolean running=true;
	/**是否消失*/
	private boolean disposing=false;
	/** 事件监听器 */
	private GameActionListener actionListener;
	/**构建一个带编号的闪屏
	 * @param id 编号
	 */
	public GameSplash(int id) {
		super(id);
	}
	/**
	 * 构建一个带编号和指定图片数组的闪屏
	 * @param id 编号
	 * @param si 图片数组
	 */
	public GameSplash(int id,SImage[] si){
		super(id);
		this.width = SystemData.getActivityWidth();
		this.height = SystemData.getActivityHeight();
		this.si=si;
		this.setImage(si[0]);
		final AlphaChange c=new AlphaChange(0);
		this.addChanges(c);	
	}
	/**
	 * 设置是否可见，闪屏可见时将被默认加载在最顶层
	 * @param isVisible true/false
	 * @see org.sdu.android.control.window.WindowObject#setVisible(boolean)
	 */
	
	@Override
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		if (this.isVisible) {
			this.scale=true;
			SystemData.getCurrentComponentLevel().add(this,0);
			this.start();
		} else {
			SystemData.getCurrentComponentLevel().remove(this);
			System.gc();
			if (actionListener != null) {
				actionListener.actionPerformed(this,null);
			} 
		}	
	}	

	/**
	 * 绘制方法
	 * @param c 画布
	 * @see org.sdu.android.sprite.Sprite#draw(android.graphics.Canvas)
	 */
	@Override
	public void draw(Canvas c){
		super.draw(c);
		timer++;
		if(running){
		splash();
		}if(disposing){
			if(timer%currentSpeed==0){
				final int alp=this.getAlpha()-CHANGE_VALUE>0?this.getAlpha()-CHANGE_VALUE:0;
				final AlphaChange c2=new AlphaChange(alp);
				this.addChanges(c2);
			}
			if(this.changes.isEmpty()){
				this.setVisible(false);
			}
		}
	}
	/**
	 * 闪屏实现
	 */
	private void splash(){
		if(currentSplash==SPLASH_DISPOSE){
			if(timer%currentSpeed==0){
				final int alp=this.getAlpha()-CHANGE_VALUE>0?this.getAlpha()-CHANGE_VALUE:0;
				final AlphaChange c=new AlphaChange(alp);
				this.addChanges(c);
			}
		}else if(currentSplash==SPLASH_APPEAR){
			if(timer%currentSpeed==0){
			final int alp=this.getAlpha()+CHANGE_VALUE<MAX_ALP?this.getAlpha()+CHANGE_VALUE:MAX_ALP;
			final AlphaChange c=new AlphaChange(alp);
			this.addChanges(c);
			}
			}
		else if(currentSplash==SPLASH_FLASH){
			//TODO 待实现
		}
	
	}
	/**
	 * @param currentSplash the current_splash to set
	 */
	public void setCurrentSplash(int currentSplash) {
		this.currentSplash = currentSplash;
		if(currentSplash==SPLASH_APPEAR){
			final AlphaChange c=new AlphaChange(0);
			this.addChanges(c);		}
	}
	/**
	 * @return the current_splash
	 */
	public int getCurrentSplash() {
		return currentSplash;
	}
	/**
	 * @param currentSpeed the currentSpeed to set
	 */
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	/**
	 * @return the currentSpeed
	 */
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	/**
	 * 是否在响应区,覆盖所有控件
	 * 
	 * @param x
	 *            x
	 * @param y
	 *            y
	 * @return true/false
	 * @see org.sdu.android.control.window.UIAdapter#isIn(float, float)
	 */
	@Override
	public boolean isIn(float x, float y) {
		return true;
	}
	
	/**
	 * 按下闪屏
	 * @param event 屏幕事件
	 * @see org.sdu.android.control.window.UIAdapter#onPress(android.view.MotionEvent)
	 */
	@Override
	public void onPress(MotionEvent event) {
		this.disposing=true;
	}
	/**
	 * @param actionListener the actionListener to set
	 */
	public void setActionListener(GameActionListener actionListener) {
		this.actionListener = actionListener;
	}
	/**
	 * @return the actionListener
	 */
	public GameActionListener getActionListener() {
		return actionListener;
	}
}
