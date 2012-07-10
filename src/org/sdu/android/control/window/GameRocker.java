package org.sdu.android.control.window;

import org.sdu.android.SystemData;
import org.sdu.android.control.GameRockerListener;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * 游戏摇杆类
 * 
 * @author shadow
 * 
 */
public class GameRocker extends UIAdapter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 摇杆杆底X */
	private int rockerCircleX;
	/** 摇杆杆底Y */
	private int rockerCircleY;
	/** 摇杆杆底半径 */
	private int rockerCircleR;
	// 摇杆的X,Y坐标以及摇杆的半径
	/** 摇杆X */
	private float smallRockerCircleX;
	/** 摇杆Y */
	private float smallRockerCircleY;
	/** 摇杆半径 */
	private float smallRockerCircleR;
	/** 当前摇杆x */
	private float currentRockerCircleX;
	/** 当前摇杆y */
	private float currentRockerCircleY;
	/** 摇杆杆底默认x */
	public static final int DEFAULTX = 70;
	/** 摇杆杆底默认y */
	public static final int DEFAULTY = 380;
	/** 默认杆底半径 */
	public static final int DEFAULTR_L = 50;
	/** 默认摇杆半径 */
	public static final int DEFAULTR_S = 20;
	/** 默认底色 */
	public static final int DEFAULT_COLOR_BACK = 0x70000000;
	/** 默认底色 */
	public static final int DEFAULT_COLOR_UP = 0x70ff0000;
	/** 默认底色 */
	private int colorBack;
	/** 默认底色 */
	private int colorUp;
	/** 是否可获得焦点 */
	private boolean isFocusable = true;
	/** 事件监听器 */
	private GameRockerListener actionListener;
	/**当前状态*/
	public int currentState;
	/**边界常量*/
	public static final int UPL=1;
	/**边界常量*/
	public static final int UPR=7;
	/**边界常量*/
	public static final int DOWNL=-7;
	/**边界常量*/
	public static final int DOWNR=-1;
	/**边界常量*/
	public static final int LEFTL=-3;
	/**边界常量*/
	public static final int LEFTR=3;
	/**边界常量*/
	public static final int RIGHTL=5;
	/**边界常量*/
	public static final int RIGHTR=-5;
	/**最后的屏幕事件*/
	MotionEvent lastEvent;
	/**
	 * 构建游戏摇杆,使用默认位置和大小
	 * 
	 * @param id
	 *            摇杆id
	 */
	public GameRocker(int id) {
		super(id);
		this.smallRockerCircleR = DEFAULTR_S;
		this.smallRockerCircleX = DEFAULTX;
		this.smallRockerCircleY = SystemData.getActivityHeight()-DEFAULTR_L;
		this.rockerCircleR = DEFAULTR_L;
		this.rockerCircleX = DEFAULTX;
		this.rockerCircleY = SystemData.getActivityHeight()-DEFAULTR_L;
		currentRockerCircleX = this.rockerCircleX;
		currentRockerCircleY = this.rockerCircleY;
		colorUp=DEFAULT_COLOR_UP;
		colorBack=DEFAULT_COLOR_BACK;
	}
	/**
	 * 构建位置确定的游戏摇杆，摇杆大小使用默认值
	 * @param id 摇杆id
	 * @param x 摇杆x坐标
	 * @param y 摇杆y做完
	 */
	public GameRocker(int id,int x,int y){
		super(id);
		this.smallRockerCircleR = DEFAULTR_S;
		this.smallRockerCircleX = x;
		this.smallRockerCircleY = y;
		this.rockerCircleR = DEFAULTR_L;
		this.rockerCircleX = x;
		this.rockerCircleY = y;
		currentRockerCircleX = this.rockerCircleX;
		currentRockerCircleY = this.rockerCircleY;
		colorUp=DEFAULT_COLOR_UP;
		colorBack=DEFAULT_COLOR_BACK;
	}

	/**
	 * @return the rockerCircleX
	 */
	public int getRockerCircleX() {
		return rockerCircleX;
	}

	/**
	 * @param rockerCircleX
	 *            the rockerCircleX to set
	 */
	public void setRockerCircleX(int rockerCircleX) {
		this.rockerCircleX = rockerCircleX;
	}

	/**
	 * @return the rockerCircleY
	 */
	public int getRockerCircleY() {
		return rockerCircleY;
	}

	/**
	 * @param rockerCircleY
	 *            the rockerCircleY to set
	 */
	public void setRockerCircleY(int rockerCircleY) {
		this.rockerCircleY = rockerCircleY;
	}

	/**
	 * @return the rockerCircleR
	 */
	public int getRockerCircleR() {
		return rockerCircleR;
	}

	/**
	 * @param rockerCircleR
	 *            the rockerCircleR to set
	 */
	public void setRockerCircleR(int rockerCircleR) {
		this.rockerCircleR = rockerCircleR;
	}

	/**
	 * @return the smallRockerCircleX
	 */
	public float getSmallRockerCircleX() {
		return smallRockerCircleX;
	}

	/**
	 * @param smallRockerCircleX
	 *            the smallRockerCircleX to set
	 */
	public void setSmallRockerCircleX(float smallRockerCircleX) {
		this.smallRockerCircleX = smallRockerCircleX;
	}

	/**
	 * @return the smallRockerCircleY
	 */
	public float getSmallRockerCircleY() {
		return smallRockerCircleY;
	}

	/**
	 * @param smallRockerCircleY
	 *            the smallRockerCircleY to set
	 */
	public void setSmallRockerCircleY(float smallRockerCircleY) {
		this.smallRockerCircleY = smallRockerCircleY;
	}

	/**
	 * @return the smallRockerCircleR
	 */
	public float getSmallRockerCircleR() {
		return smallRockerCircleR;
	}

	/**
	 * @param smallRockerCircleR
	 *            the smallRockerCircleR to set
	 */
	public void setSmallRockerCircleR(float smallRockerCircleR) {
		this.smallRockerCircleR = smallRockerCircleR;
	}

	/**
	 * @return the defalutx
	 */
	public static int getDefalutx() {
		return DEFAULTX;
	}

	/**
	 * @return the defaluty
	 */
	public static int getDefaluty() {
		return DEFAULTY;
	}

	/**
	 * @return the defalutrL
	 */
	public static int getDefalutrL() {
		return DEFAULTR_L;
	}

	/**
	 * @return the defalutrS
	 */
	public static int getDefalutrS() {
		return DEFAULTR_S;
	}

	/**
	 * 
	 * @param r
	 *            圆周运动的旋转点
	 * @param centerX
	 *            旋转点X
	 * @param centerY
	 *            旋转点Y
	 * @param rad
	 *            旋转的弧度
	 */
	public void getXY(float centerX, float centerY, float r, double rad) {
		smallRockerCircleX = (float) (r * Math.cos(rad)) + centerX;
		smallRockerCircleY = (float) (r * Math.sin(rad)) + centerY;
	}

	/**
	 * 按压摇杆
	 * 
	 * @param event
	 *            屏幕事件
	 */
	@Override
	public void onPress(MotionEvent event) {
		rockerDeal(event);
	}

	/**
	 * 释放摇杆
	 * 
	 * @param event
	 *            屏幕事件
	 */
	@Override
	public void onRelease(MotionEvent event) {
		currentRockerCircleX = this.rockerCircleX;
		currentRockerCircleY = this.rockerCircleY;
		lastEvent=null;
	}

	/**
	 * 拖拽摇杆
	 * 
	 * @param event
	 *            屏幕事件
	 */
	@Override
	public void onDrag(MotionEvent event) {
		rockerDeal(event);
		lastEvent=event;
	}

	/**
	 * 得到两点间弧度
	 * 
	 * @param px1
	 *            点1的x
	 * @param py1
	 *            点1的y
	 * @param px2
	 *            点2的x
	 * @param py2
	 *            点2的y
	 * @return 弧度值
	 */
	public double getRad(float px1, float py1, float px2, float py2) {
		final float x = px2 - px1;
		final float y = py1 - py2;
		final float xie = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		final float cosAngle = x / xie;
		float rad = (float) Math.acos(cosAngle);
		if (py2 < py1) {
			rad = -rad;
		}
		return rad;
	}

	/**
	 * 可否获取焦点
	 * 
	 * @return 可否获取焦点
	 */
	@Override
	public boolean isFocusable() {
		return this.isFocusable;
	}

	/**
	 * 设置是否可获取焦点
	 * 
	 * @param canFocus
	 *            是否可获取焦点
	 */
	@Override
	public void setFocusable(boolean canFocus) {
		this.isFocusable = canFocus;
	}

	/**
	 * 设置是否可被拖拽
	 * 
	 * @param canDrag
	 *            是否被拖拽
	 */
	@Override
	public void setDragable(boolean canDrag) {

	}


	/**
	 * 更新方法
	 */
	@Override
	public void update() {
		if(lastEvent!=null){
			rockerDeal(lastEvent);
		}
	}

	/**
	 * 事件是否在内部
	 * 
	 * @param px1
	 *            事件x
	 * @param py1
	 *            事件y
	 * @return 是否在内部
	 */
	@Override
	public boolean isIn(float px1, float py1) {

		final float px2 = this.getRockerCircleX();
		final float py2 = this.getRockerCircleY();
		final float x = px2 - px1;
		final float y = py1 - py2;
		final float xie = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if (xie < this.getRockerCircleR() + this.getSmallRockerCircleR()) {
			return true;
		}
		return false;

	}

	/**
	 * 动作事件 重写实现
	 * @param event 屏幕事件
	 * @return 动作是否被捕获
	 */
	@Override
	public boolean actionPerformed(MotionEvent event) {
		boolean isDeal=false;
		if(actionListener==null){
			return isDeal;
		}
		final float ex=event.getX();
		final float ey=event.getY();
		final double r=this.getRad(ex, ey, this.getRockerCircleX(), this.getRockerCircleY());
		final double area=r/Math.PI*8;
		if(area>UPL&&area<UPR){
			actionListener.actionUp(event);
		}
		else if(area>DOWNL&&area<DOWNR){
			actionListener.actionDown(event);
		}
		if(area>LEFTL&&area<LEFTR){
			actionListener.actionLeft(event);
		}
		else if(area>RIGHTL||area<RIGHTR){
			actionListener.actionRight(event);
		}
		isDeal=true;
		return isDeal;
	}

	/**
	 * 绘制方法
	 * 
	 * @param canvas
	 *            画布
	 */
	@Override
	public void draw(Canvas canvas) {
		update();
		if (isVisible) {
			final Paint paint = new Paint();
			paint.setColor(colorBack);
			canvas.drawCircle(rockerCircleX, rockerCircleY, rockerCircleR,
					paint);
			paint.setColor(colorUp);
			canvas.drawCircle(currentRockerCircleX, currentRockerCircleY,
					smallRockerCircleR, paint);
		}
	}
	
	/**
	 * @return the colorBack
	 */
	public int getColorBack() {
		return colorBack;
	}
	/**
	 * @param colorBack the colorBack to set
	 */
	public void setColorBack(int colorBack) {
		this.colorBack = colorBack;
	}
	/**
	 * @return the colorUp
	 */
	public int getColorUp() {
		return colorUp;
	}
	/**
	 * @param colorUp the colorUp to set
	 */
	public void setColorUp(int colorUp) {
		this.colorUp = colorUp;
	}
	/**
	 * 设置状态
	 * @param s 状态数 0为常态
	 */
	public void setCurrentState(int s){
		if(s==0){
			this.onRelease(null);
		}
	}
	/**
	 * 得到状态
	 * @return 状态数 0为常态
	 */
	public int getCurrentState(){
		return currentState;
	}
	/**
	 * 摇杆处理方法
	 * @param event 屏幕事件
	 */
	private void rockerDeal(MotionEvent event){
		if (Math.sqrt(Math.pow((rockerCircleX - (int) event.getX()), 2)
				+ Math.pow((rockerCircleY - (int) event.getY()), 2)) >= rockerCircleR) {
			final double tempRad = getRad(rockerCircleX, rockerCircleY,
					event.getX(), event.getY());
			getXY(rockerCircleX, rockerCircleY, rockerCircleR, tempRad);
		} else {
			currentRockerCircleX = (int) event.getX();
			currentRockerCircleY = (int) event.getY();
		}
		if (actionListener != null) {
			this.actionPerformed(event);
		} 
	}
	/**
	 * 设置摇杆监听器
	 * 
	 * @param actionListener
	 *            需设置的摇杆监听器
	 */
	public void setActionListener(GameRockerListener actionListener) {
		this.actionListener = actionListener;
	}
}
