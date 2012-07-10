package org.sdu.android.game.rpg.model;

import java.util.Vector;

import org.sdu.android.game.rpg.model.Skill.sort;


/**
 * 英雄基类
 * 
 * @author yyt&&ls
 * 
 */
public class Hero extends People {

	/** 英雄等级 */
	private int degree;
	/** 英雄最高等级 */
	private int maxDegree;
	/** 英雄初始等级 */
	private int minDegree;
	/** 英雄初始经验值 */
	private int initialExp;
	/** 英雄升到下一级所需经验值 */
	private int upDegreeExp;
	/** 英雄当前经验值 */
	private int currentExp;
	/** 英雄等级之间经验值的比例 */
	private float multiple;
	/** 英雄的物品组 */
	private Vector<Item> items = new Vector<Item>();
	/** 英雄的装备组 */
	private Vector<Equipment> equipments = new Vector<Equipment>();
	/** 英雄的金币 */
	private int gold;
	/** 英雄出售物品或装备价格损失百分比（1-100） */
	private int losePercent;

	/**
	 * 默认的构造方法
	 */
	public Hero() {
		super();
		this.upDegreeExp = 0;
		this.initialExp = 0;
		this.currentExp = this.initialExp;
		this.degree = this.minDegree;
		this.maxDegree = 0;
		this.minDegree = 0;
		this.multiple = 1f;
		items = null;
		equipments = null;
		this.gold = 100;
		this.losePercent = 0;
		this.isLive = true;
		this.icon_id = 0;
		this.anim_id = 0;
	}

	/**
	 * 指定称谓的构造方法
	 * 
	 * @param name
	 *            英雄称谓
	 */
	public Hero(String name) {
		super(name);
		this.upDegreeExp = 0;
		this.initialExp = 0;
		this.currentExp = this.initialExp;
		this.degree = this.minDegree;
		this.maxDegree = 0;
		this.minDegree = 0;
		this.multiple = 1f;
		items = null;
		equipments = null;
		this.gold = 100;
		this.losePercent = 0;
		this.isLive = true;
		this.icon_id = 0;
		this.anim_id = 0;
	}

	/**
	 * 自定义构造方法
	 * 
	 * @param name
	 *            英雄称谓
	 * @param blood_volumn
	 *            英雄血量
	 * @param magic_volumn
	 *            英雄魔法值
	 * @param str
	 *            英雄体力
	 * @param atk
	 *            英雄攻击力
	 * @param def
	 *            英雄防御力
	 * @param dex
	 *            英雄敏捷度
	 * @param skill
	 *            英雄技能组
	 * @param defPercent
	 *            人物受攻击时，防御抵消攻击的百分比（取值：0-100）
	 * @param icon_id
	 *            英雄图标编号
	 * @param anim_id
	 *            英雄动画编号
	 * @param minDegree
	 *            英雄初始等级
	 * @param maxDegree
	 *            英雄最高等级
	 * @param upDegreeExp
	 *            英雄升到下一级所需经验值
	 * @param initialExp
	 *            英雄初始经验值
	 * @param multiple
	 *            英雄等级之间经验值的比例
	 * @param items
	 *            英雄的物品组
	 * @param equipment
	 *            英雄的装备组
	 * @param gold
	 *            英雄的金币
	 * @param losePercent
	 *            英雄出售物品或装备价格损失百分比（1-100）
	 */
	public Hero(String name, int blood_volumn, int magic_volumn, int str,
			int atk, int def, int dex, Vector<Skill> skill, int defPercent,int icon_id,int anim_id,
			int minDegree, int maxDegree, int upDegreeExp, int initialExp,
			float multiple, Vector<Item> items, Vector<Equipment> equipments,
			int gold, int losePercent) {
		this.name = name;
		this.blood_volumn = blood_volumn;
		this.magic_volum = magic_volumn;
		this.str = str;
		this.atk = atk;
		this.def = def;
		this.dex = dex;
		this.skill = skill;
		this.defPercent = defPercent;
		this.icon_id=icon_id;
		this.anim_id=anim_id;
		this.degree = minDegree;
		this.upDegreeExp = upDegreeExp;
		this.initialExp = initialExp;
		this.currentExp = this.initialExp;
		this.multiple = multiple;
		this.maxDegree = maxDegree;
		this.minDegree = minDegree;
		this.items = items;
		this.equipments = equipments;
		this.gold = gold;
		this.losePercent = losePercent;
		this.isLive = true;
	}

	/**
	 * 获取英雄升到下一级所需经验值
	 * 
	 * @return
	 */
	public int getUpDegreeExp() {
		return upDegreeExp;
	}

	/**
	 * 设置英雄升到下一级所需
	 * 
	 * @param upDegreeExp
	 */
	public void setUpDegreeExp(int upDegreeExp) {
		this.upDegreeExp = upDegreeExp;
	}

	/**
	 * 获取英雄当前经验值
	 * 
	 * @return
	 */
	public int getCurrentExp() {
		return currentExp;
	}

	/**
	 * 设置英雄当前经验值
	 * 
	 * @param currentExp
	 */
	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	/**
	 * 获取英雄最高等级
	 * 
	 * @return
	 */
	public int getMaxDegree() {
		return maxDegree;
	}

	/**
	 * 设置英雄最高等级
	 * 
	 * @param maxDegree
	 */
	public void setMaxDegree(int maxDegree) {
		this.maxDegree = maxDegree;
	}

	/**
	 * 获取英雄初始等级
	 * 
	 * @return
	 */
	public int getMinDegree() {
		return minDegree;
	}

	/**
	 * 设置英雄初始等级
	 * 
	 * @param minDegree
	 */
	public void setMinDegree(int minDegree) {
		this.minDegree = minDegree;
	}

	/**
	 * 获取英雄等级之间经验值的比例
	 * 
	 * @return
	 */
	public float getMultiple() {
		return multiple;
	}

	/**
	 * 设置英雄等级之间经验值的比例
	 * 
	 * @param multiple
	 */
	public void setMultiple(float multiple) {
		this.multiple = multiple;
	}

	/**
	 * 获取英雄当前等级
	 * 
	 * @return degree int
	 */
	public int getDegree() {
		return degree;
	}

	/**
	 * 设置英雄当前等级
	 * 
	 * @param degree
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}

	/**
	 * 返回英雄的物品组
	 * 
	 * @return Vector<Item>
	 */
	public Vector<Item> getItems() {
		return items;
	}

	/**
	 * 设置英雄的物品组
	 * 
	 * @param items
	 */
	public void setItems(Vector<Item> items) {
		this.items = items;
	}

	/**
	 * 返回英雄的装备组
	 * 
	 * @return Vector<Equipment>
	 */
	public Vector<Equipment> getEquipments() {
		return equipments;
	}

	/**
	 * 设置英雄的装备组
	 * 
	 * @param equipments
	 *            Vector<Equipment>
	 */
	public void setEquipments(Vector<Equipment> equipments) {
		this.equipments = equipments;
	}

	/**
	 * 获取英雄初始经验值
	 * 
	 * @return 初始经验值
	 */
	public int getInitialExp() {
		return initialExp;
	}

	/**
	 * 设置英雄初始经验值
	 * 
	 * @param initialExp
	 *            初始经验值
	 */
	public void setInitialExp(int initialExp) {
		this.initialExp = initialExp;
	}

	/**
	 * 获取英雄当前金币
	 * 
	 * @return 金币 int
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * 设置英雄当前金币
	 * 
	 * @param gold
	 *            金币
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * 获取英雄出售物品或装备价格损失百分比（1-100）
	 * 
	 * @return 英雄出售物品或装备价格损失百分比（1-100）
	 */
	public int getLosePercent() {
		return losePercent;
	}

	/**
	 * 设置英雄出售物品或装备价格损失百分比（1-100）
	 * 
	 * @param losePercent
	 *            英雄出售物品或装备价格损失百分比（1-100）
	 */
	public void setLosePercent(int losePercent) {
		this.losePercent = losePercent;
	}

	/**
	 * 英雄升级
	 */
	public void upDegree() {
		if (this.degree < this.maxDegree) {
			this.degree++;
			this.upDegreeExp = (int) (this.upDegreeExp * this.multiple);
		}
	}

	/**
	 * 英雄降级
	 */
	public void downDegree() {
		if (this.degree > minDegree) {
			this.degree--;
			this.upDegreeExp = (int) (this.upDegreeExp / this.multiple);
		}
	}

	/**
	 * 技能自定义升级
	 */
	public void upDegree(int addDegree) {
		int temp = this.degree + addDegree;
		if (temp > maxDegree) {
			this.degree = maxDegree;
			this.upDegreeExp = 0;
		} else {
			this.degree += addDegree;
			this.upDegreeExp = (int) (this.upDegreeExp * Math.pow(
					(double) this.multiple, (double) addDegree));
		}
	}

	/**
	 * 技能自定义降级
	 */
	public void downDegree(int reduceDegree) {
		int temp = this.degree - reduceDegree;
		if (temp < minDegree) {
			this.degree = minDegree;
			this.upDegreeExp = this.initialExp;
		} else {
			this.degree -= reduceDegree;
			this.upDegreeExp = (int) (this.upDegreeExp / Math.pow(
					(double) this.multiple, (double) reduceDegree));
		}
	}

	/**
	 * 判断英雄是否升级(英雄每次获得经验时，用于判断)
	 * 
	 * @return
	 */
	public boolean isUpDegree() {
		if (this.currentExp >= this.upDegreeExp) {
			return true;
		} else
			return false;
	}

	/**
	 *英雄使用物品(使用完后物品消失，即从物品组里移除)
	 * 
	 * @param item
	 *            物品
	 * @return boolean 该物品是否存在与原物品组里
	 */
	public boolean useItem(Item item) {
		if (this.items.remove(item)) {
			this.blood_volumn += item.getAlter_blood();
			this.magic_volum += item.getAlter_magic();
			this.str += item.getAlter_str();
			this.atk += item.getAlter_atk();
			this.def += item.getAlter_def();
			this.dex += item.getAlter_dex();
			return true;
		} else
			return false;
	}

	/**
	 * 英雄穿上装备
	 * 
	 * @param equipment
	 *            Equipment
	 */
	public void put_on_equipment(Equipment equipment) {
		this.blood_volumn += equipment.getAlter_blood();
		this.magic_volum += equipment.getAlter_magic();
		this.str += equipment.getAlter_str();
		this.atk += equipment.getAlter_atk();
		this.def += equipment.getAlter_def();
		this.dex += equipment.getAlter_dex();
	}

	/**
	 * 英雄换下装备
	 * 
	 * @param equipment
	 *            装备
	 */
	public void get_off_equipment(Equipment equipment) {
		this.blood_volumn -= equipment.getAlter_blood();
		this.magic_volum -= equipment.getAlter_magic();
		this.str -= equipment.getAlter_str();
		this.atk -= equipment.getAlter_atk();
		this.def -= equipment.getAlter_def();
		this.dex -= equipment.getAlter_dex();
	}

	/**
	 * 英雄获得物品（非购买）
	 * 
	 * @param item
	 *            物品
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}

	/**
	 * 英雄丢掉物品（非卖出）
	 * 
	 * @param item
	 *            物品
	 * @return boolean 英雄原物品组里是否有该物品
	 */
	public boolean dropItem(Item item) {
		if (this.items.remove(item))
			return true;
		else
			return false;
	}

	/**
	 * 英雄获得装备（非购买）
	 * 
	 * @param equipment
	 *            装备
	 */
	public void addEquipment(Equipment equipment) {
		this.equipments.add(equipment);
	}

	/**
	 * 英雄丢掉装备（非卖出）
	 * 
	 * @param equipment
	 *            装备
	 * @return boolean 英雄原装备组里是否有该装备
	 */
	public boolean dropEquipment(Equipment equipment) {
		if (this.equipments.remove(equipment))
			return true;
		else
			return false;
	}

	/**
	 * 英雄购买物品
	 * 
	 * @param item
	 *            物品
	 * @return 是否买得起
	 */
	public boolean buyItem(Item item) {
		if (this.gold >= item.getPrice()) {
			this.items.add(item);
			this.gold -= item.getPrice();
			return true;
		} else
			return false;
	}

	/**
	 * 英雄出售物品
	 * 
	 * @param item
	 *            物品
	 * @return boolean 该物品是否存在与原物品组中
	 */
	public boolean sellItem(Item item) {
		if (this.losePercent < 0)
			this.losePercent = 0;
		else if (this.losePercent > 100)
			this.losePercent = 100;
		if (this.items.remove(item)) {
			this.gold += item.getPrice() * (100 - this.losePercent) / 100;
			return true;
		} else
			return false;
	}

	/**
	 * 英雄购买装备
	 * 
	 * @param equipment
	 *            装备
	 * @return 是否买得起
	 */
	public boolean buyItem(Equipment equipment) {
		if (this.gold >= equipment.getPrice()) {
			this.gold -= equipment.getPrice();
			return true;
		} else
			return false;
	}

	/**
	 * 英雄出售装备
	 * 
	 * @param equipment
	 *            装备
	 */
	public void sellItem(Equipment equipment) {
		if (this.losePercent < 0)
			this.losePercent = 0;
		else if (this.losePercent > 100)
			this.losePercent = 100;

		this.gold += equipment.getPrice() * (100 - this.losePercent) / 100;
	}

	/**
	 * 英雄普通攻击单个敌人(添加了防御力影响)
	 * 
	 * @param enemy
	 *            被攻击敌人对象
	 */
	public void attack(Enemy enemy) {
		enemy.blood_volumn -= this.atk * (100 - enemy.defPercent) / 100;
		if (enemy.blood_volumn < 0) {
			enemy.setLive(false);
			enemy.setBlood_volumn(0);
			this.items.add(enemy.getItem());
			this.equipments.add(enemy.getEquipment());
			this.gold+=enemy.getGold();
			this.currentExp+=enemy.getExp();
		}
	}

	/**
	 * 英雄攻击敌团（攻击全体，添加了防御力影响)
	 * 
	 * @param enemys
	 *            被攻击敌团对象
	 */
	public void attack(Enemys enemys) {
		for (int i = 0; i < enemys.getCount(); i++) {
			enemys.getEnemys().get(i).blood_volumn -= this.atk
					* (100 - enemys.getEnemys().get(i).defPercent) / 100;
			if (enemys.getEnemys().get(i).blood_volumn < 0) {
				enemys.getEnemys().get(i).setLive(false);
				this.currentExp += enemys.getEnemys().get(i).getExp();
				this.gold = enemys.getEnemys().get(i).getGold();
				enemys.getEnemys().get(i).setBlood_volumn(0);
				this.items.add(enemys.getEnemys().get(i).getItem());
				this.equipments.add(enemys.getEnemys().get(i).getEquipment());
			}
		}
	}
	
	/**
	 * 对英雄释放技能
	 * 
	 * @param hero
	 *            英雄对象
	 * @param num
	 *            释放的技能对应技能组的位置
	 * @return boolean 
	 *            技能能否被释放
	 */
	public boolean openSkill(Hero hero, int num) {
		if(this.degree<this.skill.get(num).getMinDegree()){
			return false;
		}
		if (this.skill.get(num).getWeapon_range() == sort.PERSONAL_PEOPLE
				&& hero != this) {
			return false;
		}
		if (this.blood_volumn - this.skill.get(num).getAlter_blood_personal() < 0) {
			return false;
		}
		if (this.magic_volum - this.skill.get(num).getAlter_magic_personal() < 0) {
			return false;
		}
		if (this.str - this.skill.get(num).getAlter_str_personal() < 0) {
			return false;
		}
		if (this.dex - this.skill.get(num).getAlter_dex_personal() < 0) {
			return false;
		}
		this.blood_volumn -= this.skill.get(num).getAlter_blood_personal();
		this.magic_volum -= this.skill.get(num).getAlter_magic_personal();
		this.str -= this.skill.get(num).getAlter_str_personal();
		this.dex -= this.skill.get(num).getAlter_dex_personal();

		hero.blood_volumn -= this.skill.get(num).getAlter_blood_aim();
		hero.magic_volum -= this.skill.get(num).getAlter_magic_aim();
		hero.str -= this.skill.get(num).getAlter_str_aim();
		hero.dex -= this.skill.get(num).getAlter_dex_aim();

		if (hero.blood_volumn - this.skill.get(num).getAlter_blood_aim() < 0) {
			hero.setLive(false);
			hero.setBlood_volumn(0);
		}
		if (hero.magic_volum - this.skill.get(num).getAlter_magic_aim() < 0) {
			hero.magic_volum = 0;
		}
		if (hero.str - this.skill.get(num).getAlter_str_aim() < 0) {
			hero.str = 0;
		}
		if (hero.dex - this.skill.get(num).getAlter_dex_aim() < 0) {
			hero.dex = 0;
		}
		return true;
	}
	
	/**
	 * 对敌人释放技能
	 * 
	 * @param enemy
	 * @param num
	 *            释放的技能对应技能组的位置
	 * @return boolean 技能是否能释放
	 */
	public boolean openSkill(Enemy enemy, int num) {
		if(this.degree<this.skill.get(num).getMinDegree()){
			return false;
		}
		if (this.blood_volumn - this.skill.get(num).getAlter_blood_personal() < 0) {
			return false;
		}
		if (this.magic_volum - this.skill.get(num).getAlter_magic_personal() < 0) {
			return false;
		}
		if (this.str - this.skill.get(num).getAlter_str_personal() < 0) {
			return false;
		}
		if (this.dex - this.skill.get(num).getAlter_dex_personal() < 0) {
			return false;
		}
		this.blood_volumn -= this.skill.get(num).getAlter_blood_personal();
		this.magic_volum -= this.skill.get(num).getAlter_magic_personal();
		this.str -= this.skill.get(num).getAlter_str_personal();
		this.dex -= this.skill.get(num).getAlter_dex_personal();

		enemy.blood_volumn -= this.skill.get(num).getAlter_blood_aim();
		enemy.magic_volum -= this.skill.get(num).getAlter_magic_aim();
		enemy.str -= this.skill.get(num).getAlter_str_aim();
		enemy.dex -= this.skill.get(num).getAlter_dex_aim();

		if (enemy.blood_volumn - this.skill.get(num).getAlter_blood_aim() < 0) {
			enemy.setLive(false);
			enemy.setBlood_volumn(0);
			this.items.add(enemy.getItem());
			this.equipments.add(enemy.getEquipment());
			this.gold+=enemy.getGold();
			this.currentExp+=enemy.getExp();
		}
		if (enemy.magic_volum - this.skill.get(num).getAlter_magic_aim() < 0) {
			enemy.magic_volum = 0;
		}
		if (enemy.str - this.skill.get(num).getAlter_str_aim() < 0) {
			enemy.str = 0;
		}
		if (enemy.dex - this.skill.get(num).getAlter_dex_aim() < 0) {
			enemy.dex = 0;
		}
		return true;
	}

	/**
	 * 对敌团释放技能
	 * 
	 * @param enemys
	 * @param num
	 *            释放的技能对应技能组的位置
	 * @return boolean 技能是否能够被释放
	 */
	public boolean openSkill(Enemys enemys, int num) {
		if(this.degree<this.skill.get(num).getMinDegree()){
			return false;
		}
		if (this.blood_volumn - this.skill.get(num).getAlter_blood_personal() < 0) {
			return false;
		}
		if (this.magic_volum - this.skill.get(num).getAlter_magic_personal() < 0) {
			return false;
		}
		if (this.str - this.skill.get(num).getAlter_str_personal() < 0) {
			return false;
		}
		if (this.dex - this.skill.get(num).getAlter_dex_personal() < 0) {
			return false;
		}
		this.blood_volumn -= this.skill.get(num).getAlter_blood_personal();
		this.magic_volum -= this.skill.get(num).getAlter_magic_personal();
		this.str -= this.skill.get(num).getAlter_str_personal();
		this.dex -= this.skill.get(num).getAlter_dex_personal();

		for (int i = 0; i < enemys.getCount(); i++) {
			Enemy enemy = enemys.getEnemys().get(i);

			enemy.blood_volumn -= this.skill.get(num).getAlter_blood_aim();
			enemy.magic_volum -= this.skill.get(num).getAlter_magic_aim();
			enemy.str -= this.skill.get(num).getAlter_str_aim();
			enemy.dex -= this.skill.get(num).getAlter_dex_aim();

			if (enemy.blood_volumn - this.skill.get(num).getAlter_blood_aim() < 0) {
				enemy.setLive(false);
				enemy.setBlood_volumn(0);
				this.items.add(enemy.getItem());
				this.equipments.add(enemy.getEquipment());
				this.gold+=enemy.getGold();
				this.currentExp+=enemy.getExp();
			}
			if (enemy.magic_volum - this.skill.get(num).getAlter_magic_aim() < 0) {
				enemy.magic_volum = 0;
			}
			if (enemy.str - this.skill.get(num).getAlter_str_aim() < 0) {
				enemy.str = 0;
			}
			if (enemy.dex - this.skill.get(num).getAlter_dex_aim() < 0) {
				enemy.dex = 0;
			}
		}
		return true;
	}
}
