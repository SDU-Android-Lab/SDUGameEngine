package org.sdu.android.sprite;

import org.sdu.android.util.graphicsUtil.Point;
import org.sdu.android.util.graphicsUtil.SImage;
import org.sdu.android.util.graphicsUtil.Shapes;

import android.content.res.Resources;

/**
 * 
 * 精灵类的基类，定义精灵最基础的属性
 * 
 * */

public abstract class AbstractSprite implements Drawable, Changeable {
	/** 资源 */
	protected Resources resource;
	/** 相对地图x坐标 */
	protected int x;
	/** 相对地图y坐标 */
	protected int y;
	/** 宽度 */
	protected int width;
	/** 高度 */
	protected int height;
	/** 精灵名 */
	protected String name;
	/** 资源图像标识 */
	protected int resId;
	/** 精灵显示的当前图像 */
	protected SImage image = null;
	/** 包围盒 */
	protected Shapes rect;
	/** id */
	protected int id;

	/**
	 * 构造方法
	 * 
	 * @param id
	 *            唯一的标示
	 */
	public AbstractSprite(int id) {
		this.id = id;
	}

	/**
	 * 设置resId
	 * 
	 * @param resId
	 *            资源图像的resId
	 */
	public void setResId(int resId) {
		this.resId = resId;
	}

	/**
	 * 
	 * 得到ResId
	 * 
	 * @return ResId 资源图像的ResId
	 * */
	public int getResId() {
		return resId;
	}

	/**
	 * 设置地图x坐标
	 * 
	 * @param x
	 *            x坐标
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 获取地图X坐标
	 * 
	 * @return x x坐标
	 */
	public int getX() {
		return x;
	}

	/**
	 * 设置地图y坐标
	 * 
	 * @param y
	 *            y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 获取地图y坐标
	 * 
	 * @return y y坐标
	 */
	public int getY() {
		return y;
	}

	/**
	 * 设置宽度
	 * 
	 * @param width
	 *            宽度
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * 获得宽度
	 * 
	 * @return width 宽度
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 设置高度
	 * 
	 * @param height
	 *            高度
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * 获取高度
	 * 
	 * @return height 高度
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * 设定当前图像
	 * 
	 * @param image
	 *            要设定的图像
	 * */
	public void setImage(SImage image) {
		this.image = image;
	}

	/**
	 * 获取当前图像
	 * 
	 * @return image 当前图像
	 * */
	public SImage getImage() {
		return image;
	}

	/**
	 * 设置包围盒
	 * 
	 * @param box
	 *            形状对象
	 */
	public void setBox(Shapes box) {
		this.rect = box;
	}

	/**
	 * 得到包围盒
	 * 
	 * @return 包围盒
	 */
	public Shapes getRect() {
		return rect;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * 获取名称
	 * 
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 点是否在包围盒内
	 * 
	 * @param p
	 *            点
	 * @return true / false
	 */
	public boolean isPointIn(Point p) {
		return rect.isPointIn(p);
	}
}
