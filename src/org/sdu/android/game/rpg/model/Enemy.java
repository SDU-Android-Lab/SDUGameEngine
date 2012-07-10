package org.sdu.android.game.rpg.model;

import java.util.Vector;

/**
 * 敌人基类
 * 
 * @author yyt&&ls
 * 
 */
public class Enemy extends People {
	/** 敌人智力 */
	private float wit;
	/** 杀死该敌人获得的经验 */
	private int exp;
	/** 杀死该敌人获得的物品 */
	private Item item; // 如果允许杀死一个敌人可以获得多个物品，这里可以声明为Vector<Item> items
	/** 杀死该敌人获得的装备 */
	private Equipment equipment; // 同理如果允许杀死一个敌人可以获得多个装备，这里可以声明为Vector<Equipment>
									// equipments
	/** 杀死该敌人获得的金币 */
	private int gold;

	/**
	 * 默认构造方法
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
	 * 指定称谓的构造方法
	 * 
	 * @param name
	 *            敌人名称
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
	 * 自定义构造方法
	 * 
	 * @param name
	 *            称谓
	 * @param blood_volumn
	 *            血量
	 * @param magic_volumn
	 *            魔法值
	 * @param str
	 *            体力
	 * @param atk
	 *            攻击力
	 * @param def
	 *            防御力
	 * @param dex
	 *            敏捷度
	 * @param skill
	 *            技能数组
	 * @param defPercent
	 *            人物受攻击时，防御抵消攻击的百分比（取值：0-100）
	 * @param wit
	 *            智力
	 * @param exp
	 *            杀死该敌人获得的经验
	 * @param item
	 *            杀死该敌人获得的物品
	 * @param equipment
	 *            杀死该敌人获得的装备
	 *            @param gold 杀死该敌人获得的金币
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
	 * 获取敌人的智力值
	 * 
	 * @return
	 */
	public float getWit() {
		return wit;
	}

	/**
	 * 设置敌人的智力值
	 * 
	 * @param wit
	 */
	public void setWit(float wit) {
		this.wit = wit;
	}

	/**
	 * 获取杀死该敌人获得的经验
	 * 
	 * @return
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * 设置杀死该敌人获得的经验
	 * 
	 * @param exp
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * 获取杀死该敌人获得的物品
	 * 
	 * @return
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * 设置杀死该敌人获得的物品
	 * 
	 * @param item
	 *            Item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 获取杀死该敌人获得的装备
	 * 
	 * @return equipment Equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * 设置杀死该敌人获得的装备
	 * 
	 * @param equipment
	 *            Equipment
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * 获取杀死该敌人获得的金币
	 * @return 杀死该敌人获得的金币
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * 设置杀死该敌人获得的金币
	 * @param gold 金币
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * 敌人普通攻击英雄
	 * 
	 * @param hero 被攻击英雄对象
	 */
	public void attack(Hero hero) {
		hero.blood_volumn -= this.atk*(100-hero.def)/100;
		if(hero.blood_volumn<0)
			hero.setLive(false);
	}
}
