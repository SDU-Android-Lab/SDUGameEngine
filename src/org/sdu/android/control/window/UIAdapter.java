package org.sdu.android.control.window;

import org.sdu.android.SystemData;
import org.sdu.android.sprite.StaticSprite;
import org.sdu.android.util.graphicsUtil.Point;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * UI������,�̳�DrawableObject��ʵ��WindowObject
 * 
 * @author shadow
 * 
 */
public class UIAdapter extends StaticSprite implements WindowObject {

	/**
	 * ���а汾��
	 */
	private static final long serialVersionUID = 4742586904638847771L;
	/**
	 * �Ƿ�ɻ�ȡ����
	 */
	private boolean canFocus = true;
	/**
	 * �Ƿ����ק
	 */
	private boolean canDrag = false;
	/**
	 * �Ƿ�ɼ�
	 */
	protected boolean isVisible = true;

	/**
	 * Ĭ�ϻ���
	 */
	private final Paint defaultPaint = new Paint();
	/**
	 * ����
	 */
	private Paint p;

	/**
	 * ���������������ÿؼ�id����Ϊ���ɲ���
	 * 
	 * @param id
	 *            id��
	 */
	public UIAdapter(int id) {
		super(id, false);
	}

	/**
	 * �õ��ؼ�ID��
	 * 
	 * @return id��
	 */
	public int getId() {
		return this.getResId();
	}

	/**
	 * ����������������id�������Ƿ�ɲ���
	 * 
	 * @param id
	 *            id��
	 * @param playable
	 *            �Ƿ�ɲ���
	 */
	public UIAdapter(int id, boolean playable) {
		super(id, playable);
	}

	/**
	 * @param event
	 *            �¼� ������Ӧ
	 */
	public void onPress(MotionEvent event) {

	}

	/**
	 * @param event
	 *            �¼� ������Ӧ
	 */
	@Override
	public void onRelease(MotionEvent event) {

	}

	/**
	 * @param event
	 *            �¼� ��ק��Ӧ
	 */
	@Override
	public void onDrag(MotionEvent event) {

	}

	/**
	 * �Ƿ�ɻ�ȡ����
	 * 
	 * @return true/false
	 */
	@Override
	public boolean isFocusable() {
		return canFocus;
	}

	/**
	 * �����Ƿ�ɻ�ȡ����
	 * 
	 * @param canFocus
	 *            true/false
	 */
	@Override
	public void setFocusable(boolean canFocus) {
		this.canFocus = canFocus;
	}

	/**
	 * �����Ƿ����ק
	 * 
	 * @param canDrag
	 *            �Ƿ����ק
	 */
	@Override
	public void setDragable(boolean canDrag) {
		this.canDrag = canDrag;
	}

	/**
	 * �����Ƿ�ɼ�
	 * 
	 * @param isVisible
	 *            true/false
	 * @see org.sdu.android.control.window.WindowObject#setVisible(boolean)
	 */

	@Override
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
		if (this.isVisible) {
			SystemData.getCurrentComponentLevel().add(this);
		} else {
			SystemData.getCurrentComponentLevel().remove(this);
			System.gc();
		}
	}

	/**
	 * �Ƿ����ק
	 * 
	 * @return the canDrag true/false
	 */
	public boolean isDragable() {
		return canDrag;
	}

	/**
	 * ���·���
	 * 
	 * @see org.sdu.android.control.window.WindowObject#update()
	 */

	@Override
	public void update() {

	}

	/**
	 * x,yλ�õ��¼��Ƿ��ڿؼ��ڲ���Ĭ�ϲ��þ��ΰ�Χ��
	 * 
	 * @param x
	 *            �¼�������
	 * @param y
	 *            �¼�������
	 * @return �Ƿ��ڿؼ��ڲ�
	 * @see org.sdu.android.control.window.WindowObject#isIn(float, float)
	 */
	@Override
	public boolean isIn(float x, float y) {
		if (this.getRect() != null) {
			return this.getRect().isPointIn(new Point(x, y));
		} else {
			return false;
		}
	}

	/**
	 * ����¼�
	 * 
	 * @param event
	 *            ����λ��
	 * @return �¼�����Ӧ true , ���� false
	 * @see org.sdu.android.control.window.WindowObject#actionPerformed(android.view.MotionEvent)
	 */

	@Override
	public boolean actionPerformed(MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * ���õ�ǰ״̬
	 * 
	 * @param s
	 *            ״̬��
	 * @see org.sdu.android.control.window.WindowObject#setCurrentState(int)
	 */

	@Override
	public void setCurrentState(int s) {
		// TODO Auto-generated method stub

	}

	/**
	 * ��ȡ��ǰ״̬
	 * 
	 * @return ״̬�� int
	 * @see org.sdu.android.control.window.WindowObject#getCurrentState()
	 */

	@Override
	public int getCurrentState() {
		return 0;
	}

	/**
	 * ��ͼ
	 * 
	 * @param c
	 *            ����
	 * @see org.sdu.android.control.window.WindowObject#draw(android.graphics.Canvas)
	 */
	@Override
	public void draw(Canvas c) {
		if (p != null) {
			onDraw(c, p);
		} else {
			onDraw(c, defaultPaint);
		}
	}

	public void draw(Canvas c, Paint p) {
		onDraw(c, p);

	}
	
	public boolean isPointIn(Rect r, float x, float y) {
		if(x>=this.x+r.left&&x<=this.x+r.right&&y>=this.y+r.top&&y<=this.y+r.bottom){
			return true;
		}
		return false;
	}
}
