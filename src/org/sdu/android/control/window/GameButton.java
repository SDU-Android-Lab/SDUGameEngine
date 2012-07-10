package org.sdu.android.control.window;

import org.sdu.android.control.GameActionListener;
import org.sdu.android.util.graphicsUtil.Rect;
import org.sdu.android.util.graphicsUtil.SImage;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * ��Ϸ��ť��
 * 
 * @author shadow
 * 
 */
public class GameButton extends UIAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6135078682737161738L;
	/** �Ƿ�ɻ�ý��� */
	private boolean isFocusable = true;
	/** �Ƿ�ɱ���ק */
	private boolean isDragable = false;
	/** ��ǰ״̬���� */
	private int currentState;
	/** �¼������� */
	private GameActionListener actionListener;
	/** ��̬���ţ�0 */
	public final static int NORMAL = 0;
	/** ������ ���ţ�1 */
	public final static int PRESSED = 1;
	/** ʧȥ������ţ�2 */
	public final static int LOSEFOCUS = 2;
	/**ͼƬ����*/
	public SImage[] bitsp;
	/**
	 * GameButton��ť���췽��
	 * 
	 * @param id
	 *            ��ť��ʶ
	 * @param bitsp
	 *            ͼƬ���� ��̬�����¡�ʧȥ��������״̬
	 * @param x
	 *            ��ťx����
	 * @param y
	 *            ��ťy����
	 */
	public GameButton(int id, SImage[] bitsp, int x, int y) {
		super(id);
		this.bitsp=bitsp;
		this.setX(x);
		this.setY(y);
		final Rect r=new Rect();
		r.setLocation(x, y);
		r.setRectangle(bitsp[0].getHeight(), bitsp[0].getWidth());
		this.setBox(r);
	}
	/**
	 * �Զ��з�ͼƬ�İ�ť
	 * @param id ��ť���
	 * @param image ͼƬ
	 * @param x x����
	 * @param y y����
	 */
	public GameButton(int id,SImage image,int x,int y){
		super(id);
		this.setImage(image);
		this.splitImage(1, 2+1);
		this.setX(x);
		this.setY(y);
		bitsp=frames;
		final Rect r=new Rect();
		r.setLocation(x, y);
		r.setRectangle(bitsp[0].getHeight(), bitsp[0].getWidth());
		this.setBox(r);
	}

	/**
	 * ������
	 * 
	 * @param event
	 *            �����¼�
	 */
	public void onPress(MotionEvent event) {
		setCurrentState(PRESSED);
	};

	/**
	 * ���ͷ�
	 * 
	 * @param event
	 *            �����¼�
	 */
	public void onRelease(MotionEvent event) {
		if (actionListener != null) {
			actionListener.actionPerformed(this,event);
		} else {
			actionPerformed(event);
		}
		setCurrentState(NORMAL);
	}

	/**
	 * ����ק
	 * 
	 * @param event
	 *            �����¼�
	 */
	public void onDrag(MotionEvent event) {
		if (!isDragable) {
			return;
		}
		setCurrentState(PRESSED);
	}

	/**
	 * �Ƿ�ɻ�ȡ����
	 * 
	 * @return �Ƿ���Ի�ȡ���� �� true���� false
	 */
	public boolean isFocusable() {
		return isFocusable;
	}

	/**
	 * �Ƿ�ɻ�ȡ����
	 * 
	 * @return the isDragable
	 */
	public boolean isDragable() {
		return isDragable;
	}

	/**
	 * ��������Ƿ���Ի�ȡ����
	 * 
	 * @param canFocus
	 *            �� true���� false
	 */
	public void setFocusable(boolean canFocus) {
	}

	/**
	 * �Ƿ���϶�
	 * 
	 * @param canDrag
	 *            ���϶� true�������϶�false
	 */
	public void setDragable(boolean canDrag) {
		isDragable = canDrag;
	}


	/**
	 * ���ư�ť
	 * 
	 * @param canvas
	 *            ��canvas�ϻ��ư�ť
	 */
	public void draw(Canvas canvas) {
		update();
		if (isVisible) {
			super.draw(canvas);
		}
	}

	/**
	 * ���°�ť��Ϣ
	 */
	@Override
	public void update() {
		goToIndex(getCurrentState());

	}

	/**
	 * @param index ͼƬ���
	 */
	private void goToIndex(int index) {
		super.load(bitsp[index]);
	}

	/**
	 * ���õ�ǰ״̬��
	 * 
	 * @param currentState
	 *            ��ǰ״̬�� 0���� 1���� 2ʧȥ����
	 */
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	/**
	 * �õ���ǰ״̬��
	 * 
	 * @return ��ǰ״̬�� 0���� 1���� 2ʧȥ����
	 */
	public int getCurrentState() {
		return currentState;
	}

	/**
	 * �ж�ĳ���Ƿ��ڰ�ť�ڲ�
	 * 
	 * @param x
	 *            ��x����
	 * @param y
	 *            ��y����
	 * @return ��true �� false
	 */
	@Override
	public boolean isIn(float x, float y) {
		if(x>this.x&&x<this.x+this.bitsp[0].getWidth()){
			if(y>this.y&&y<this.y+this.bitsp[0].getHeight()){
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ť��Ӧ�¼����� ������ʵ��
	 * @param event ��Ļ�¼�
	 * @return �¼��Ƿ񱻲���
	 */
	@Override
	public boolean actionPerformed(MotionEvent event) {
		return true;
	}

	/**
	 * ����GameActionListener
	 * 
	 * @param actionListener
	 *            �����õ�GameActionListener
	 */
	public void setActionListener(GameActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/**
	 * ��ȡGameActionListener
	 * 
	 * @return ��ǰ��GameActionListener
	 */
	public GameActionListener getActionListener() {
		return actionListener;
	}
}
