package org.sdu.android.control.window;

import org.sdu.android.SystemData;
import org.sdu.android.control.GameRockerListener;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * ��Ϸҡ����
 * 
 * @author shadow
 * 
 */
public class GameRocker extends UIAdapter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** ҡ�˸˵�X */
	private int rockerCircleX;
	/** ҡ�˸˵�Y */
	private int rockerCircleY;
	/** ҡ�˸˵װ뾶 */
	private int rockerCircleR;
	// ҡ�˵�X,Y�����Լ�ҡ�˵İ뾶
	/** ҡ��X */
	private float smallRockerCircleX;
	/** ҡ��Y */
	private float smallRockerCircleY;
	/** ҡ�˰뾶 */
	private float smallRockerCircleR;
	/** ��ǰҡ��x */
	private float currentRockerCircleX;
	/** ��ǰҡ��y */
	private float currentRockerCircleY;
	/** ҡ�˸˵�Ĭ��x */
	public static final int DEFAULTX = 70;
	/** ҡ�˸˵�Ĭ��y */
	public static final int DEFAULTY = 380;
	/** Ĭ�ϸ˵װ뾶 */
	public static final int DEFAULTR_L = 50;
	/** Ĭ��ҡ�˰뾶 */
	public static final int DEFAULTR_S = 20;
	/** Ĭ�ϵ�ɫ */
	public static final int DEFAULT_COLOR_BACK = 0x70000000;
	/** Ĭ�ϵ�ɫ */
	public static final int DEFAULT_COLOR_UP = 0x70ff0000;
	/** Ĭ�ϵ�ɫ */
	private int colorBack;
	/** Ĭ�ϵ�ɫ */
	private int colorUp;
	/** �Ƿ�ɻ�ý��� */
	private boolean isFocusable = true;
	/** �¼������� */
	private GameRockerListener actionListener;
	/**��ǰ״̬*/
	public int currentState;
	/**�߽糣��*/
	public static final int UPL=1;
	/**�߽糣��*/
	public static final int UPR=7;
	/**�߽糣��*/
	public static final int DOWNL=-7;
	/**�߽糣��*/
	public static final int DOWNR=-1;
	/**�߽糣��*/
	public static final int LEFTL=-3;
	/**�߽糣��*/
	public static final int LEFTR=3;
	/**�߽糣��*/
	public static final int RIGHTL=5;
	/**�߽糣��*/
	public static final int RIGHTR=-5;
	/**������Ļ�¼�*/
	MotionEvent lastEvent;
	/**
	 * ������Ϸҡ��,ʹ��Ĭ��λ�úʹ�С
	 * 
	 * @param id
	 *            ҡ��id
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
	 * ����λ��ȷ������Ϸҡ�ˣ�ҡ�˴�Сʹ��Ĭ��ֵ
	 * @param id ҡ��id
	 * @param x ҡ��x����
	 * @param y ҡ��y����
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
	 *            Բ���˶�����ת��
	 * @param centerX
	 *            ��ת��X
	 * @param centerY
	 *            ��ת��Y
	 * @param rad
	 *            ��ת�Ļ���
	 */
	public void getXY(float centerX, float centerY, float r, double rad) {
		smallRockerCircleX = (float) (r * Math.cos(rad)) + centerX;
		smallRockerCircleY = (float) (r * Math.sin(rad)) + centerY;
	}

	/**
	 * ��ѹҡ��
	 * 
	 * @param event
	 *            ��Ļ�¼�
	 */
	@Override
	public void onPress(MotionEvent event) {
		rockerDeal(event);
	}

	/**
	 * �ͷ�ҡ��
	 * 
	 * @param event
	 *            ��Ļ�¼�
	 */
	@Override
	public void onRelease(MotionEvent event) {
		currentRockerCircleX = this.rockerCircleX;
		currentRockerCircleY = this.rockerCircleY;
		lastEvent=null;
	}

	/**
	 * ��קҡ��
	 * 
	 * @param event
	 *            ��Ļ�¼�
	 */
	@Override
	public void onDrag(MotionEvent event) {
		rockerDeal(event);
		lastEvent=event;
	}

	/**
	 * �õ�����仡��
	 * 
	 * @param px1
	 *            ��1��x
	 * @param py1
	 *            ��1��y
	 * @param px2
	 *            ��2��x
	 * @param py2
	 *            ��2��y
	 * @return ����ֵ
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
	 * �ɷ��ȡ����
	 * 
	 * @return �ɷ��ȡ����
	 */
	@Override
	public boolean isFocusable() {
		return this.isFocusable;
	}

	/**
	 * �����Ƿ�ɻ�ȡ����
	 * 
	 * @param canFocus
	 *            �Ƿ�ɻ�ȡ����
	 */
	@Override
	public void setFocusable(boolean canFocus) {
		this.isFocusable = canFocus;
	}

	/**
	 * �����Ƿ�ɱ���ק
	 * 
	 * @param canDrag
	 *            �Ƿ���ק
	 */
	@Override
	public void setDragable(boolean canDrag) {

	}


	/**
	 * ���·���
	 */
	@Override
	public void update() {
		if(lastEvent!=null){
			rockerDeal(lastEvent);
		}
	}

	/**
	 * �¼��Ƿ����ڲ�
	 * 
	 * @param px1
	 *            �¼�x
	 * @param py1
	 *            �¼�y
	 * @return �Ƿ����ڲ�
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
	 * �����¼� ��дʵ��
	 * @param event ��Ļ�¼�
	 * @return �����Ƿ񱻲���
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
	 * ���Ʒ���
	 * 
	 * @param canvas
	 *            ����
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
	 * ����״̬
	 * @param s ״̬�� 0Ϊ��̬
	 */
	public void setCurrentState(int s){
		if(s==0){
			this.onRelease(null);
		}
	}
	/**
	 * �õ�״̬
	 * @return ״̬�� 0Ϊ��̬
	 */
	public int getCurrentState(){
		return currentState;
	}
	/**
	 * ҡ�˴�����
	 * @param event ��Ļ�¼�
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
	 * ����ҡ�˼�����
	 * 
	 * @param actionListener
	 *            �����õ�ҡ�˼�����
	 */
	public void setActionListener(GameRockerListener actionListener) {
		this.actionListener = actionListener;
	}
}
