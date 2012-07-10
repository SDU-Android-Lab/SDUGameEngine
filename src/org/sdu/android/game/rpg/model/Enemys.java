package org.sdu.android.game.rpg.model;

import java.util.Vector;

/**
 * ���Ż���
 * 
 * @author yyt&&ls
 * 
 */
public class Enemys {

	/** �������� */
	private String name;
	/** ���ű�� */
	private int id;
	/** ���ų�Ա�� */
	private Vector<Enemy> enemys = new Vector<Enemy>();

	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public Enemys() {
		this.name = "enemys";
		this.id = 0;
		this.enemys = null;
	}

	/**
	 * �Զ��幹�췽��
	 * 
	 * @param name
	 *            ��������
	 * @param id
	 *            ���ű��
	 * @param enemys
	 *            ���ų�Ա��
	 */
	public Enemys(String name, int id, Vector<Enemy> enemys) {
		this.name = name;
		this.id = id;
		this.enemys = enemys;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���õ�������
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ���ű��
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * ���õ��ű��
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ���ŵ�ǰ��Ա����
	 * 
	 * @return
	 */
	public int getCount() {
		return this.enemys.size();
	}

	/**
	 * ��ȡ���ų�Ա��
	 * 
	 * @return
	 */
	public Vector<Enemy> getEnemys() {
		return enemys;
	}

	/**
	 * ���õ��ų�Ա��
	 * 
	 * @param enemys
	 */
	public void setEnemys(Vector<Enemy> enemys) {
		this.enemys = enemys;
	}

	/**
	 * ������ӳ�Ա
	 * 
	 * @param enemy
	 */
	public void addEnemy(Enemy enemy) {
		this.enemys.add(enemy);
	}

	/**
	 * ����ɾ��ָ����Ա
	 * 
	 * @param enemy
	 *            ���ų�Ա
	 * @return ��Ա�Ƿ�ӵ���ɾ���ɹ�
	 */
	public boolean deleteEnemy(Enemy enemy) {
		if (this.enemys.remove(enemy))
			return true;
		else
			return false;
	}

	/**
	 * ɾ������ָ��λ�õĳ�Ա
	 * 
	 * @param location
	 *            ��Ա�ڵ��ų�Ա���λ��
	 * @return ��ɾ�����˳�Ա�Ķ���
	 */
	public Enemy deleteEnemy(int location) {
		return this.enemys.remove(location);
	}
}
