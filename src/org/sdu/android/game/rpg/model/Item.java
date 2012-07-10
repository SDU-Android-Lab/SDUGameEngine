package org.sdu.android.game.rpg.model;

/**
 * 物品基类
 * 
 * @author yyt&&ls
 * 
 */
public class Item {

	/** 物品名称 */
	private String name;
	/** 物品编号 */
	private int id;
	/** 物品价格 */
	private int price;
	/** 物品简介 */
	private String intro;
	/** 物品对血量的影响 */
	private int alter_blood;
	/** 物品对魔法值的影响 */
	private int alter_magic;
	/** 物品对体力的影响 */
	private int alter_str;
	/** 物品对攻击力的影响 */
	private int alter_atk;
	/** 物品对防御力的影响 */
	private int alter_def;
	/** 物品对敏捷度的影响 */
	private int alter_dex;
	/** 物品图标编号 */
	private int icon_id;
	/** 物品动画编号 */
	private int anim_id;

	/**
	 * 默认的构造方法
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
	 * 自定义构造方法1
	 * 
	 * @param name
	 *            物品名称
	 * @param id
	 *            物品编号
	 * @param price
	 *            物品价格
	 * @param intro
	 *            物品简介
	 * @param alter_blood
	 *            物品对血量的影响
	 * @param alter_magic
	 *            物品对魔法值的影响
	 * @param alter_str
	 *            物品对体力的影响
	 * @param alter_atk
	 *            物品对攻击力的影响
	 * @param alter_def
	 *            物品对防御力的影响
	 * @param alter_dex
	 *            物品对敏捷度的影响
	 * @param icon_id
	 *            物品图标编号
	 * @param anim_id
	 *            物品动画编号
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
	 * 自定义构造方法2
	 * 
	 * @param name
	 *            物品名称
	 * @param id
	 *            物品编号
	 */
	public Item(String name, int id) {
		this();
		this.name = name;
		this.id = id;
	}

	/**
	 * 获取物品名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置物品名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取物品编号
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置物品编号
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取物品价格
	 * 
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 获取物品价格
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 获取物品简介
	 * @return
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * 设置物品简介
	 * @param intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * 获取物品对血量的影响
	 * 
	 * @return
	 */
	public int getAlter_blood() {
		return alter_blood;
	}

	/**
	 * 设置物品对血量的影响
	 * 
	 * @param alterBlood
	 */
	public void setAlter_blood(int alterBlood) {
		alter_blood = alterBlood;
	}

	/**
	 * 获取物品对魔法值的影响
	 * 
	 * @return
	 */
	public int getAlter_magic() {
		return alter_magic;
	}

	/**
	 * 设置物品对魔法值的影响
	 * 
	 * @param alterMagic
	 */
	public void setAlter_magic(int alterMagic) {
		alter_magic = alterMagic;
	}

	/**
	 * 获取物品对体力的影响
	 * 
	 * @return
	 */
	public int getAlter_str() {
		return alter_str;
	}

	/**
	 * 设置物品对体力的影响
	 * 
	 * @param alterStr
	 */
	public void setAlter_str(int alterStr) {
		alter_str = alterStr;
	}

	/**
	 * 获取物品对攻击力的影响
	 * 
	 * @return
	 */
	public int getAlter_atk() {
		return alter_atk;
	}

	/**
	 * 设置物品对攻击力的影响
	 * 
	 * @param alterAtk
	 */
	public void setAlter_atk(int alterAtk) {
		alter_atk = alterAtk;
	}

	/**
	 * 获取物品对防御力的影响
	 * 
	 * @return
	 */
	public int getAlter_def() {
		return alter_def;
	}

	/**
	 * 设置物品对防御力的影响
	 * 
	 * @param alterDef
	 */
	public void setAlter_def(int alterDef) {
		alter_def = alterDef;
	}

	/**
	 * 货物物品对敏捷度的影响
	 * 
	 * @return
	 */
	public int getAlter_dex() {
		return alter_dex;
	}

	/**
	 * 设置物品对敏捷度的影响
	 * 
	 * @param alterDex
	 */
	public void setAlter_dex(int alterDex) {
		alter_dex = alterDex;
	}

	/**
	 * 获取物品图标编号
	 * 
	 * @return
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * 设置物品编号
	 * 
	 * @param iconId
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * 获取物品动画编号
	 * 
	 * @return
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * 设置物品动画编号
	 * 
	 * @param animId
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}

}
