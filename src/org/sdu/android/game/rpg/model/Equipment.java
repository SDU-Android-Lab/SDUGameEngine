package org.sdu.android.game.rpg.model;

/**
 * װ������
 * 
 * @author yyt&&ls
 * 
 */
public class Equipment {

	/**
	 * װ�����ࣺ�������·���Ь�ӣ�ͷ����װ��Ʒ
	 * 
	 * @author yyt&&ls
	 * 
	 */
	public enum sort {
		weapon, clothes, shose, helmet, adornment;
	}

	/** װ������ */
	private String name;
	/** װ����� */
	private int id;
	/** װ������ */
	private sort mySort;
	/** װ����� */
	private String intro;
	/** װ���۸� */
	private int price;
	/** װ����Ѫ����Ӱ�� */
	private int alter_blood;
	/** װ����ħ��ֵ��Ӱ�� */
	private int alter_magic;
	/** װ����������Ӱ�� */
	private int alter_str;
	/** װ���Թ�������Ӱ�� */
	private int alter_atk;
	/** װ���Է�������Ӱ�� */
	private int alter_def;
	/** װ�������ݶȵ�Ӱ�� */
	private int alter_dex;
	/** װ��ͼ���� */
	private int icon_id;
	/** װ��������� */
	private int anim_id;

	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public Equipment() {
		this.name = "item";
		this.id = 0;
		this.price = 0;
		this.intro = "equipment";
		this.mySort = sort.weapon;

		this.alter_blood = 0;
		this.alter_atk = 0;
		this.alter_def = 0;
		this.alter_magic = 0;
		this.alter_dex = 0;
		this.alter_str = 0;

		this.icon_id = 0;
		this.anim_id = 0;
	}

	/**
	 * �Զ��幹�췽��1
	 * 
	 * @param name
	 *            װ������
	 * @param id
	 *            װ�����
	 * @param price
	 *            װ���۸�
	 * @param intro
	 *            װ�����
	 * @param mySort
	 *            װ������
	 * @param alter_blood
	 *            װ����Ѫ����Ӱ��
	 * @param alter_magic
	 *            װ����ħ��ֵ��Ӱ��
	 * @param alter_str
	 *            װ����������Ӱ��
	 * @param alter_atk
	 *            װ���Թ�������Ӱ��
	 * @param alter_def
	 *            װ���Է�������Ӱ��
	 * @param alter_dex
	 *            װ�������ݶȵ�Ӱ��
	 * @param icon_id
	 *            װ��ͼ����
	 * @param anim_id
	 *            װ���������
	 */
	public Equipment(String name, int id, int price, String intro, sort mySort,
			int alter_blood, int alter_magic, int alter_str, int alter_atk,
			int alter_def, int alter_dex, int icon_id, int anim_id) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.intro = intro;
		this.mySort = mySort;

		this.alter_blood = alter_blood;
		this.alter_atk = alter_atk;
		this.alter_def = alter_def;
		this.alter_magic = alter_magic;
		this.alter_dex = alter_dex;
		this.alter_str = alter_str;

		this.icon_id = icon_id;
		this.anim_id = anim_id;
	}

	/**
	 * �Զ��幹�췽��2
	 * 
	 * @param name
	 *            װ������
	 * @param id
	 *            װ�����
	 * @param mySort
	 *            װ������
	 */
	public Equipment(String name, int id, sort mySort) {
		this();
		this.name = name;
		this.id = id;
		this.mySort = mySort;
	}

	/**
	 * ��ȡװ������
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����װ������
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡװ�����
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * ����װ�����
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡװ���۸�
	 * 
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * ��ȡװ���۸�
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * ��ȡװ�����
	 * 
	 * @return
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * ����װ�����
	 * 
	 * @param intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * ��ȡװ��������
	 * @return
	 */
	public sort getMySort() {
		return mySort;
	}

	/**
	 * ����װ��������
	 * @param mySort
	 */
	public void setMySort(sort mySort) {
		this.mySort = mySort;
	}

	/**
	 * ��ȡװ����Ѫ����Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_blood() {
		return alter_blood;
	}

	/**
	 * ����װ����Ѫ����Ӱ��
	 * 
	 * @param alterBlood
	 */
	public void setAlter_blood(int alterBlood) {
		alter_blood = alterBlood;
	}

	/**
	 * ��ȡװ����ħ��ֵ��Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_magic() {
		return alter_magic;
	}

	/**
	 * ����װ����ħ��ֵ��Ӱ��
	 * 
	 * @param alterMagic
	 */
	public void setAlter_magic(int alterMagic) {
		alter_magic = alterMagic;
	}

	/**
	 * ��ȡװ����������Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_str() {
		return alter_str;
	}

	/**
	 * ����װ����������Ӱ��
	 * 
	 * @param alterStr
	 */
	public void setAlter_str(int alterStr) {
		alter_str = alterStr;
	}

	/**
	 * ��ȡװ���Թ�������Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_atk() {
		return alter_atk;
	}

	/**
	 * ����װ���Թ�������Ӱ��
	 * 
	 * @param alterAtk
	 */
	public void setAlter_atk(int alterAtk) {
		alter_atk = alterAtk;
	}

	/**
	 * ��ȡװ���Է�������Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_def() {
		return alter_def;
	}

	/**
	 * ����װ���Է�������Ӱ��
	 * 
	 * @param alterDef
	 */
	public void setAlter_def(int alterDef) {
		alter_def = alterDef;
	}

	/**
	 * ����װ�������ݶȵ�Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_dex() {
		return alter_dex;
	}

	/**
	 * ����װ�������ݶȵ�Ӱ��
	 * 
	 * @param alterDex
	 */
	public void setAlter_dex(int alterDex) {
		alter_dex = alterDex;
	}

	/**
	 * ��ȡװ��ͼ����
	 * 
	 * @return
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * ����װ�����
	 * 
	 * @param iconId
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * ��ȡװ���������
	 * 
	 * @return
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * ����װ���������
	 * 
	 * @param animId
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}

}
