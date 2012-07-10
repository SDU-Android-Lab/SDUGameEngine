package org.sdu.android.game.rpg.model;

import java.util.Vector;

/**
 * ���˻���
 * 
 * @author yyt&&ls
 * 
 */
public class Enemy extends People {
	/** �������� */
	private float wit;
	/** ɱ���õ��˻�õľ��� */
	private int exp;
	/** ɱ���õ��˻�õ���Ʒ */
	private Item item; // �������ɱ��һ�����˿��Ի�ö����Ʒ�������������ΪVector<Item> items
	/** ɱ���õ��˻�õ�װ�� */
	private Equipment equipment; // ͬ���������ɱ��һ�����˿��Ի�ö��װ���������������ΪVector<Equipment>
									// equipments
	/** ɱ���õ��˻�õĽ�� */
	private int gold;

	/**
	 * Ĭ�Ϲ��췽��
	 */
	public Enemy() {
		super();
		this.wit = 0;
		this.exp = 0;
		this.item = null;
		this.equipment = null;
		gold=0;
	}

	/**
	 * ָ����ν�Ĺ��췽��
	 * 
	 * @param name
	 *            ��������
	 */
	public Enemy(String name) {
		super(name);
		this.wit = 0;
		this.exp = 0;
		this.item = null;
		this.equipment = null;
		this.gold=0;
	}

	/**
	 * �Զ��幹�췽��
	 * 
	 * @param name
	 *            ��ν
	 * @param blood_volumn
	 *            Ѫ��
	 * @param magic_volumn
	 *            ħ��ֵ
	 * @param str
	 *            ����
	 * @param atk
	 *            ������
	 * @param def
	 *            ������
	 * @param dex
	 *            ���ݶ�
	 * @param skill
	 *            ��������
	 * @param defPercent
	 *            �����ܹ���ʱ���������������İٷֱȣ�ȡֵ��0-100��
	 * @param wit
	 *            ����
	 * @param exp
	 *            ɱ���õ��˻�õľ���
	 * @param item
	 *            ɱ���õ��˻�õ���Ʒ
	 * @param equipment
	 *            ɱ���õ��˻�õ�װ��
	 *            @param gold ɱ���õ��˻�õĽ��
	 * 
	 */
	public Enemy(String name, int blood_volumn, int magic_volumn, int str,
			int atk, int def, int dex, Vector<Skill> skill, int defPercent,
			float wit, int exp, Item item, Equipment equipment,int gold) {
		this.name = name;
		this.blood_volumn = blood_volumn;
		this.magic_volum = magic_volumn;
		this.str = str;
		this.atk = atk;
		this.def = def;
		this.dex = dex;
		this.wit = wit;
		this.skill = skill;
		this.defPercent = defPercent;
		this.exp = exp;
		this.item = item;
		this.equipment = equipment;
		this.gold = gold;
	}

	/**
	 * ��ȡ���˵�����ֵ
	 * 
	 * @return
	 */
	public float getWit() {
		return wit;
	}

	/**
	 * ���õ��˵�����ֵ
	 * 
	 * @param wit
	 */
	public void setWit(float wit) {
		this.wit = wit;
	}

	/**
	 * ��ȡɱ���õ��˻�õľ���
	 * 
	 * @return
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * ����ɱ���õ��˻�õľ���
	 * 
	 * @param exp
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * ��ȡɱ���õ��˻�õ���Ʒ
	 * 
	 * @return
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * ����ɱ���õ��˻�õ���Ʒ
	 * 
	 * @param item
	 *            Item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * ��ȡɱ���õ��˻�õ�װ��
	 * 
	 * @return equipment Equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * ����ɱ���õ��˻�õ�װ��
	 * 
	 * @param equipment
	 *            Equipment
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * ��ȡɱ���õ��˻�õĽ��
	 * @return ɱ���õ��˻�õĽ��
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * ����ɱ���õ��˻�õĽ��
	 * @param gold ���
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * ������ͨ����Ӣ��
	 * 
	 * @param hero ������Ӣ�۶���
	 */
	public void attack(Hero hero) {
		hero.blood_volumn -= this.atk*(100-hero.def)/100;
		if(hero.blood_volumn<0)
			hero.setLive(false);
	}
}
