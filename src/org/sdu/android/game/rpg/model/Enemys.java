package org.sdu.android.game.rpg.model;

import java.util.Vector;

/**
 * 敌团基类
 * 
 * @author yyt&&ls
 * 
 */
public class Enemys {

	/** 敌团名称 */
	private String name;
	/** 敌团编号 */
	private int id;
	/** 敌团成员组 */
	private Vector<Enemy> enemys = new Vector<Enemy>();

	/**
	 * 默认的构造方法
	 */
	public Enemys() {
		this.name = "enemys";
		this.id = 0;
		this.enemys = null;
	}

	/**
	 * 自定义构造方法
	 * 
	 * @param name
	 *            敌团名称
	 * @param id
	 *            敌团编号
	 * @param enemys
	 *            敌团成员组
	 */
	public Enemys(String name, int id, Vector<Enemy> enemys) {
		this.name = name;
		this.id = id;
		this.enemys = enemys;
	}

	/**
	 * 获取敌团名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置敌团名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取敌团编号
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置敌团编号
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取敌团当前成员数量
	 * 
	 * @return
	 */
	public int getCount() {
		return this.enemys.size();
	}

	/**
	 * 获取敌团成员组
	 * 
	 * @return
	 */
	public Vector<Enemy> getEnemys() {
		return enemys;
	}

	/**
	 * 设置敌团成员组
	 * 
	 * @param enemys
	 */
	public void setEnemys(Vector<Enemy> enemys) {
		this.enemys = enemys;
	}

	/**
	 * 敌团添加成员
	 * 
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy) {
		this.enemys.add(enemy);
	}

	/**
	 * 敌团删除指定成员
	 * 
	 * @param enemy
	 *            敌团成员
	 * @return 成员是否从敌团删除成功
	 */
	public boolean deleteEnemy(Enemy enemy) {
		if (this.enemys.remove(enemy))
			return true;
		else
			return false;
	}

	/**
	 * 删除敌团指定位置的成员
	 * 
	 * @param location
	 *            成员在敌团成员组的位置
	 * @return 被删除敌人成员的对象
	 */
	public Enemy deleteEnemy(int location) {
		return this.enemys.remove(location);
	}
}
