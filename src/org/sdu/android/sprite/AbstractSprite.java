package org.sdu.android.sprite;

import org.sdu.android.util.graphicsUtil.Point;
import org.sdu.android.util.graphicsUtil.SImage;
import org.sdu.android.util.graphicsUtil.Shapes;

import android.content.res.Resources;

/**
 * 
 * ������Ļ��࣬���徫�������������
 * 
 * */

public abstract class AbstractSprite implements Drawable, Changeable {
	/** ��Դ */
	protected Resources resource;
	/** ��Ե�ͼx���� */
	protected int x;
	/** ��Ե�ͼy���� */
	protected int y;
	/** ��� */
	protected int width;
	/** �߶� */
	protected int height;
	/** ������ */
	protected String name;
	/** ��Դͼ���ʶ */
	protected int resId;
	/** ������ʾ�ĵ�ǰͼ�� */
	protected SImage image = null;
	/** ��Χ�� */
	protected Shapes rect;
	/** id */
	protected int id;

	/**
	 * ���췽��
	 * 
	 * @param id
	 *            Ψһ�ı�ʾ
	 */
	public AbstractSprite(int id) {
		this.id = id;
	}

	/**
	 * ����resId
	 * 
	 * @param resId
	 *            ��Դͼ���resId
	 */
	public void setResId(int resId) {
		this.resId = resId;
	}

	/**
	 * 
	 * �õ�ResId
	 * 
	 * @return ResId ��Դͼ���ResId
	 * */
	public int getResId() {
		return resId;
	}

	/**
	 * ���õ�ͼx����
	 * 
	 * @param x
	 *            x����
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * ��ȡ��ͼX����
	 * 
	 * @return x x����
	 */
	public int getX() {
		return x;
	}

	/**
	 * ���õ�ͼy����
	 * 
	 * @param y
	 *            y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * ��ȡ��ͼy����
	 * 
	 * @return y y����
	 */
	public int getY() {
		return y;
	}

	/**
	 * ���ÿ��
	 * 
	 * @param width
	 *            ���
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * ��ÿ��
	 * 
	 * @return width ���
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * ���ø߶�
	 * 
	 * @param height
	 *            �߶�
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * ��ȡ�߶�
	 * 
	 * @return height �߶�
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * �趨��ǰͼ��
	 * 
	 * @param image
	 *            Ҫ�趨��ͼ��
	 * */
	public void setImage(SImage image) {
		this.image = image;
	}

	/**
	 * ��ȡ��ǰͼ��
	 * 
	 * @return image ��ǰͼ��
	 * */
	public SImage getImage() {
		return image;
	}

	/**
	 * ���ð�Χ��
	 * 
	 * @param box
	 *            ��״����
	 */
	public void setBox(Shapes box) {
		this.rect = box;
	}

	/**
	 * �õ���Χ��
	 * 
	 * @return ��Χ��
	 */
	public Shapes getRect() {
		return rect;
	}

	/**
	 * ��������
	 * 
	 * @param name
	 *            ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * ��ȡ����
	 * 
	 * @return ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���Ƿ��ڰ�Χ����
	 * 
	 * @param p
	 *            ��
	 * @return true / false
	 */
	public boolean isPointIn(Point p) {
		return rect.isPointIn(p);
	}
}
