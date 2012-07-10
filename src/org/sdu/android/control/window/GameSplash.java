
package org.sdu.android.control.window;

import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.sprite.change.AlphaChange;
import org.sdu.android.util.graphicsUtil.SImage;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * ��Ϸ��ʼ��GameOver���˳���Ϸʱ�������
 * @author shadow
 *
 */
public class GameSplash extends UIAdapter{
	
	/**��ʱ��*/
	private int timer; 
	/**Ч��1 ������ʧ*/
	public static final int SPLASH_DISPOSE=0;
	/**Ч��2 ��������*/
	public static final int SPLASH_APPEAR=1;
	/**Ч��3 ��˸*/
	public static final int SPLASH_FLASH=2;
	/**Ĭ���ٶ�*/
	public static final int DEFAULT_SPEED=10;
	/**Ĭ��͸���ȸı�ֵ*/
	public static final int CHANGE_VALUE=10;
	/**���͸����*/
	public static final int MAX_ALP=255;
	/**��ǰЧ��*/
	private int currentSplash=SPLASH_APPEAR;
	/**��ǰ�ٶ�*/
	private int currentSpeed=DEFAULT_SPEED;
	/**ͼ������*/
	SImage[] si;
	/**�Ƿ�����*/
	private boolean running=true;
	/**�Ƿ���ʧ*/
	private boolean disposing=false;
	/** �¼������� */
	private GameActionListener actionListener;
	/**����һ������ŵ�����
	 * @param id ���
	 */
	public GameSplash(int id) {
		super(id);
	}
	/**
	 * ����һ������ź�ָ��ͼƬ���������
	 * @param id ���
	 * @param si ͼƬ����
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
	 * �����Ƿ�ɼ��������ɼ�ʱ����Ĭ�ϼ��������
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
	 * ���Ʒ���
	 * @param c ����
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
	 * ����ʵ��
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
			//TODO ��ʵ��
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
	 * �Ƿ�����Ӧ��,�������пؼ�
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
	 * ��������
	 * @param event ��Ļ�¼�
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
