package org.sdu.android.map.painter.ground;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * ��ͼ����
 * @author Joycery & Sww
 *
 */
public abstract class AbstactGround implements Map {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���
	 */
	private int width;
	/**
	 * �߶�
	 */
	private int height;
	/**
	 * ���ÿ�Ⱥ͸߶�
	 * @param width ���
	 * @param height �߶�
	 */
	public void setWidthHeight(int width, int height){
		this.width=width;
		this.height=height;
	}
	
	/**
	 * ��ȡ���
	 * @return width ���
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * ��ȡ�߶�
	 * @return height �߶�
	 */
	public int getHeight(){
		return height;
	}
	/**
	 * ���ÿ��
	 * @param width ���
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * ���ø߶�
	 * @param height �߶�
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * �ж�ĳ���Ƿ�����
	 * @param x ĳ��ĺ�����
	 * @param y ĳ���������
	 * @return �Ƿ�����
	 */
	public abstract boolean allowed(int x, int y);
	
	/**
	 * ���ƶ�̬�²�
	 * @param canvas ����,paint ����
	 */
	public abstract void drawDown(Canvas canvas,Paint paint);
	
	/**
	 * ���ƶ�̬�ϲ�
	 * @param canvas ����,paint ����
	 */
	public abstract void drawUp(Canvas canvas,Paint paint);
	
	/**
	 * ������Դ
	 * @param resource ��Դ
	 */
	public abstract void load(Resources resource);
	
	/**
	 * �ͷ���Դ
	 */
	public abstract void unload();
}
