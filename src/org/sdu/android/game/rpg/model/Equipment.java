package org.sdu.android.game.rpg.model;

/**
 * 装备基类
 * 
 * @author yyt&&ls
 * 
 */
public class Equipment {

	/**
	 * 装备分类：武器，衣服，鞋子，头盔，装饰品
	 * 
	 * @author yyt&&ls
	 * 
	 */
	public enum sort {
		weapon, clothes, shose, helmet, adornment;
	}

	/** 装备名称 */
	private String name;
	/** 装备编号 */
	private int id;
	/** 装备类型 */
	private sort mySort;
	/** 装备简介 */
	private String intro;
	/** 装备价格 */
	private int price;
	/** 装备对血量的影响 */
	private int alter_blood;
	/** 装备对魔法值的影响 */
	private int alter_magic;
	/** 装备对体力的影响 */
	private int alter_str;
	/** 装备对攻击力的影响 */
	private int alter_atk;
	/** 装备对防御力的影响 */
	private int alter_def;
	/** 装备对敏捷度的影响 */
	private int alter_dex;
	/** 装备图标编号 */
	private int icon_id;
	/** 装备动画编号 */
	private int anim_id;

	/**
	 * 默认的构造方法
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
	 * 自定义构造方法1
	 * 
	 * @param name
	 *            装备名称
	 * @param id
	 *            装备编号
	 * @param price
	 *            装备价格
	 * @param intro
	 *            装备简介
	 * @param mySort
	 *            装备类型
	 * @param alter_blood
	 *            装备对血量的影响
	 * @param alter_magic
	 *            装备对魔法值的影响
	 * @param alter_str
	 *            装备对体力的影响
	 * @param alter_atk
	 *            装备对攻击力的影响
	 * @param alter_def
	 *            装备对防御力的影响
	 * @param alter_dex
	 *            装备对敏捷度的影响
	 * @param icon_id
	 *            装备图标编号
	 * @param anim_id
	 *            装备动画编号
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
	 * 自定义构造方法2
	 * 
	 * @param name
	 *            装备名称
	 * @param id
	 *            装备编号
	 * @param mySort
	 *            装备类型
	 */
	public Equipment(String name, int id, sort mySort) {
		this();
		this.name = name;
		this.id = id;
		this.mySort = mySort;
	}

	/**
	 * 获取装备名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置装备名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取装备编号
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置装备编号
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取装备价格
	 * 
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 获取装备价格
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 获取装备简介
	 * 
	 * @return
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * 设置装备简介
	 * 
	 * @param intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * 获取装备的类型
	 * @return
	 */
	public sort getMySort() {
		return mySort;
	}

	/**
	 * 设置装备的类型
	 * @param mySort
	 */
	public void setMySort(sort mySort) {
		this.mySort = mySort;
	}

	/**
	 * 获取装备对血量的影响
	 * 
	 * @return
	 */
	public int getAlter_blood() {
		return alter_blood;
	}

	/**
	 * 设置装备对血量的影响
	 * 
	 * @param alterBlood
	 */
	public void setAlter_blood(int alterBlood) {
		alter_blood = alterBlood;
	}

	/**
	 * 获取装备对魔法值的影响
	 * 
	 * @return
	 */
	public int getAlter_magic() {
		return alter_magic;
	}

	/**
	 * 设置装备对魔法值的影响
	 * 
	 * @param alterMagic
	 */
	public void setAlter_magic(int alterMagic) {
		alter_magic = alterMagic;
	}

	/**
	 * 获取装备对体力的影响
	 * 
	 * @return
	 */
	public int getAlter_str() {
		return alter_str;
	}

	/**
	 * 设置装备对体力的影响
	 * 
	 * @param alterStr
	 */
	public void setAlter_str(int alterStr) {
		alter_str = alterStr;
	}

	/**
	 * 获取装备对攻击力的影响
	 * 
	 * @return
	 */
	public int getAlter_atk() {
		return alter_atk;
	}

	/**
	 * 设置装备对攻击力的影响
	 * 
	 * @param alterAtk
	 */
	public void setAlter_atk(int alterAtk) {
		alter_atk = alterAtk;
	}

	/**
	 * 获取装备对防御力的影响
	 * 
	 * @return
	 */
	public int getAlter_def() {
		return alter_def;
	}

	/**
	 * 设置装备对防御力的影响
	 * 
	 * @param alterDef
	 */
	public void setAlter_def(int alterDef) {
		alter_def = alterDef;
	}

	/**
	 * 货物装备对敏捷度的影响
	 * 
	 * @return
	 */
	public int getAlter_dex() {
		return alter_dex;
	}

	/**
	 * 设置装备对敏捷度的影响
	 * 
	 * @param alterDex
	 */
	public void setAlter_dex(int alterDex) {
		alter_dex = alterDex;
	}

	/**
	 * 获取装备图标编号
	 * 
	 * @return
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * 设置装备编号
	 * 
	 * @param iconId
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * 获取装备动画编号
	 * 
	 * @return
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * 设置装备动画编号
	 * 
	 * @param animId
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}

}
