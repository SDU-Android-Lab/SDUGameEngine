package org.sdu.android.game.rpg.model;

/**
 * ��Ʒ����
 * 
 * @author yyt&&ls
 * 
 */
public class Item {

	/** ��Ʒ���� */
	private String name;
	/** ��Ʒ��� */
	private int id;
	/** ��Ʒ�۸� */
	private int price;
	/** ��Ʒ��� */
	private String intro;
	/** ��Ʒ��Ѫ����Ӱ�� */
	private int alter_blood;
	/** ��Ʒ��ħ��ֵ��Ӱ�� */
	private int alter_magic;
	/** ��Ʒ��������Ӱ�� */
	private int alter_str;
	/** ��Ʒ�Թ�������Ӱ�� */
	private int alter_atk;
	/** ��Ʒ�Է�������Ӱ�� */
	private int alter_def;
	/** ��Ʒ�����ݶȵ�Ӱ�� */
	private int alter_dex;
	/** ��Ʒͼ���� */
	private int icon_id;
	/** ��Ʒ������� */
	private int anim_id;

	/**
	 * Ĭ�ϵĹ��췽��
	 */
	public Item() {
		this.name = "item";
		this.id = 0;
		this.price = 0;
		this.intro = "item";

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
	 *            ��Ʒ����
	 * @param id
	 *            ��Ʒ���
	 * @param price
	 *            ��Ʒ�۸�
	 * @param intro
	 *            ��Ʒ���
	 * @param alter_blood
	 *            ��Ʒ��Ѫ����Ӱ��
	 * @param alter_magic
	 *            ��Ʒ��ħ��ֵ��Ӱ��
	 * @param alter_str
	 *            ��Ʒ��������Ӱ��
	 * @param alter_atk
	 *            ��Ʒ�Թ�������Ӱ��
	 * @param alter_def
	 *            ��Ʒ�Է�������Ӱ��
	 * @param alter_dex
	 *            ��Ʒ�����ݶȵ�Ӱ��
	 * @param icon_id
	 *            ��Ʒͼ����
	 * @param anim_id
	 *            ��Ʒ�������
	 */
	public Item(String name, int id, int price, String intro, int alter_blood,
			int alter_magic, int alter_str, int alter_atk, int alter_def,
			int alter_dex, int icon_id, int anim_id) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.intro = intro;

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
	 *            ��Ʒ����
	 * @param id
	 *            ��Ʒ���
	 */
	public Item(String name, int id) {
		this();
		this.name = name;
		this.id = id;
	}

	/**
	 * ��ȡ��Ʒ����
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * ������Ʒ����
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��Ʒ���
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * ������Ʒ���
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ��Ʒ�۸�
	 * 
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * ��ȡ��Ʒ�۸�
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * ��ȡ��Ʒ���
	 * @return
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * ������Ʒ���
	 * @param intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * ��ȡ��Ʒ��Ѫ����Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_blood() {
		return alter_blood;
	}

	/**
	 * ������Ʒ��Ѫ����Ӱ��
	 * 
	 * @param alterBlood
	 */
	public void setAlter_blood(int alterBlood) {
		alter_blood = alterBlood;
	}

	/**
	 * ��ȡ��Ʒ��ħ��ֵ��Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_magic() {
		return alter_magic;
	}

	/**
	 * ������Ʒ��ħ��ֵ��Ӱ��
	 * 
	 * @param alterMagic
	 */
	public void setAlter_magic(int alterMagic) {
		alter_magic = alterMagic;
	}

	/**
	 * ��ȡ��Ʒ��������Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_str() {
		return alter_str;
	}

	/**
	 * ������Ʒ��������Ӱ��
	 * 
	 * @param alterStr
	 */
	public void setAlter_str(int alterStr) {
		alter_str = alterStr;
	}

	/**
	 * ��ȡ��Ʒ�Թ�������Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_atk() {
		return alter_atk;
	}

	/**
	 * ������Ʒ�Թ�������Ӱ��
	 * 
	 * @param alterAtk
	 */
	public void setAlter_atk(int alterAtk) {
		alter_atk = alterAtk;
	}

	/**
	 * ��ȡ��Ʒ�Է�������Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_def() {
		return alter_def;
	}

	/**
	 * ������Ʒ�Է�������Ӱ��
	 * 
	 * @param alterDef
	 */
	public void setAlter_def(int alterDef) {
		alter_def = alterDef;
	}

	/**
	 * ������Ʒ�����ݶȵ�Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_dex() {
		return alter_dex;
	}

	/**
	 * ������Ʒ�����ݶȵ�Ӱ��
	 * 
	 * @param alterDex
	 */
	public void setAlter_dex(int alterDex) {
		alter_dex = alterDex;
	}

	/**
	 * ��ȡ��Ʒͼ����
	 * 
	 * @return
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * ������Ʒ���
	 * 
	 * @param iconId
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * ��ȡ��Ʒ�������
	 * 
	 * @return
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * ������Ʒ�������
	 * 
	 * @param animId
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}

}
