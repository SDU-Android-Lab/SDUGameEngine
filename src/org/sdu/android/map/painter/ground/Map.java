package org.sdu.android.map.painter.ground;

import java.io.Serializable;

import org.sdu.android.map.action.MapEvent;
import org.sdu.android.util.graphicsUtil.Rect;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ��ͼ�ӿ�
 * @author Joycery & Sww
 * 
 */
public interface Map extends Serializable{
	/**
	 * ������
	 */
	int ALLOWED=0;
	/**
	 * ��������
	 */
	int NO=1;
	/**
	 * ���ÿ�Ⱥ͸߶�
	 * @param width ���
	 * @param height �߶�
	 */
	void setWidthHeight(int width, int height);
	
	/**
	 * �õ����
	 * @return ���
	 */
	int getWidth();
	
	/**
	 * �õ��߶�
	 * @return �߶�
	 */
	int getHeight();
	
	/**
	 * �ж�ĳ���Ƿ�����
	 * @param x ĳ��ĺ�����
	 * @param y ĳ���������
	 * @return �Ƿ�����
	 */
	boolean allowed(int x, int y);
	/**
	 * ���ƶ�̬�²�
	 * @param canvas ����,paint ����
	 */
	void drawDown(Canvas canvas,Paint paint);
	
	/**
	 * ���ƶ�̬�ϲ�
	 * @param canvas ������paint ����
	 */
	void drawUp(Canvas canvas,Paint paint);
	
	/**
	 * ������Դ
	 * @param Resources resource
	 */
	void load(Resources resource);
	
	/**
	 * �ͷ���Դ
	 */
	void unload();
	
    /**
     * ����Ƿ���ײ
     * @param rect ����
     * @return �Ƿ���ײ
     */
	boolean isCollision(Rect rect);
	
	/**
	 * ����ƫ����
	 * @param x ������
	 * @param y ������
	 */
	void setOffsetXY(int x,int y);
	
	/**
	 * �õ�ĳ���������ĵ�ͼ�¼�
	 * @param rect ����
	 * @return ������¼����ظ��¼������û�з���null
	 */
	MapEvent checkEvent(Rect rect);
}
