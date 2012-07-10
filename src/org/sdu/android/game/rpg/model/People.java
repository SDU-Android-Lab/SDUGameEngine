package org.sdu.android.game.rpg.model;

import java.util.Vector;

import org.sdu.android.game.rpg.model.Skill.sort;


/**
 * 人物抽象类
 * 
 * @author yyt&&ls
 * 
 */
public abstract class People {
	/** 人物的称谓 */
	protected String name;
	/** 人物的状态 */
	protected boolean isLive;
	/** 人物的血量 */
	protected int blood_volumn;
	/** 人物的魔法值 */
	protected int magic_volum;
	/** 人物的体力值 */
	protected int str;
	/** 人物的攻击力 */
	protected int atk;
	/** 人物的防御力 */
	protected int def;
	/** 人物的敏捷度 */
	protected int dex;
	/** 人物的技能组 */
	protected Vector<Skill> skill = new Vector<Skill>();
	/** 人物受攻击时，防御抵消攻击的百分比（取值：0-100） */
	protected int defPercent;
	/** 人物图标编号 */
	protected int icon_id;
	/** 人物动画编号 */
	protected int anim_id;

	/**
	 * 默认的构造方法
	 */
	public People() {
		this.name = "people";
		this.blood_volumn = 100;
		this.magic_volum = 100;
		this.str = 100;
		this.atk = 100;
		this.def = 100;
		this.dex = 100;
		this.skill = null;
		this.isLive = true;
		this.defPercent = 0;
		this.icon_id = 0;
		this.anim_id = 0;
	}

	/**
	 * 指定称谓的构造方法
	 * 
	 * @param name
	 *            String
	 */
	public People(String name) {
		this.name = name;

		this.blood_volumn = 100;
		this.magic_volum = 100;
		this.str = 100;
		this.atk = 100;
		this.def = 100;
		this.dex = 100;
		this.skill = null;
		this.isLive = true;
		this.defPercent = 0;
		this.icon_id = 0;
		this.anim_id = 0;
	}

	/**
	 * 获取人物称谓
	 * 
	 * @return name String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置人物的称谓
	 * 
	 * @param name
	 *            String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 判断任务是否死亡
	 * 
	 * @return isLive boolean
	 */
	public boolean isLive() {
		return isLive;
	}

	/**
	 * 设置人物的状态：死亡或者生存
	 * 
	 * @param isLive
	 *            状态
	 */
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	/**
	 * 获取人物的血量
	 * 
	 * @return blood_volumn int
	 */
	public int getBlood_volumn() {
		return blood_volumn;
	}

	/**
	 * 设置人物的血量
	 * 
	 * @param blood_volumn
	 *            int
	 */
	public void setBlood_volumn(int blood_volumn) {
		this.blood_volumn = blood_volumn;
	}

	/**
	 * 获取人物的魔法值
	 * 
	 * @return magic_volum int
	 */
	public int getMagic_volum() {
		return magic_volum;
	}

	/**
	 * 设置人物的血量
	 * 
	 * @param magic_volum
	 *            int
	 */
	public void setMagic_volum(int magic_volum) {
		this.magic_volum = magic_volum;
	}

	/**
	 * 获取人物的体力
	 * 
	 * @return str int
	 */
	public int getStr() {
		return str;
	}

	/**
	 * 设置人物的体力
	 * 
	 * @param str
	 *            int
	 */
	public void setStr(int str) {
		this.str = str;
	}

	/**
	 * 获取人物的攻击力
	 * 
	 * @return
	 */
	public int getAtk() {
		return atk;
	}

	/**
	 * 设置人物的攻击力
	 * 
	 * @param atk
	 *            int
	 */
	public void setAtk(int atk) {
		this.atk = atk;
	}

	/**
	 * 获取人物的防御力
	 * 
	 * @return def int
	 */
	public int getDef() {
		return def;
	}

	/**
	 * 设置人物的防御力
	 * 
	 * @param def
	 *            int
	 */
	public void setDef(int def) {
		this.def = def;
	}

	/**
	 * 获取人物的敏捷度
	 * 
	 * @return dex int
	 */
	public int getDex() {
		return dex;
	}

	/**
	 * 设置人物的敏捷度
	 * 
	 * @param dex
	 *            int
	 */
	public void setDex(int dex) {
		this.dex = dex;
	}

	/**
	 * 获取人物的技能组
	 * 
	 * @return
	 */
	public Vector<Skill> getSkill() {
		return skill;
	}

	/**
	 * 设置人物的技能组
	 * 
	 * @param skill
	 */
	public void setSkill(Vector<Skill> skill) {
		this.skill = skill;
	}

	/**
	 * 获取人物受攻击时，防御抵消攻击的百分比（取值：0-100）
	 * 
	 * @return
	 */
	public int getDefPercent() {
		return defPercent;
	}

	/**
	 * 设置人物受攻击时，防御抵消攻击的百分比（取值：0-100）
	 * 
	 * @param defPercent
	 */
	public void setDefPercent(int defPercent) {
		this.defPercent = defPercent;
	}

	/**
	 * 获取人物图标编号
	 * 
	 * @return 图标编号 int
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * 设置人物图标编号
	 * 
	 * @param iconId
	 *            图标编号
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * 获取人物动画编号
	 * 
	 * @return int 动画编号
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * 设置人物动画编号
	 * 
	 * @param animId
	 *            动画编号
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}

	/**
	 * 增加人物技能
	 * 
	 * @param newSkill
	 * @return
	 */
	public boolean addSkill(Skill newSkill) {
		if (this.skill.add(newSkill))
			return true;
		else
			return false;
	}

	/**
	 * 删除人物技能
	 * 
	 * @param oldSkill
	 * @return
	 */
	public boolean reduceSkill(Skill oldSkill) {
		if (this.skill.remove(oldSkill))
			return true;
		else
			return false;
	}

	/**
	 * 删除人物技能组指定位置的技能
	 * 
	 * @param location
	 * @return 删除的技能对象
	 */
	public Skill reduceSkill(int location) {
		return this.skill.remove(location);
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
		if (this.skill.get(num).getWeapon_range() == sort.PERSONAL_PEOPLE
				&& enemy != this) {
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

		// 添加被释放技能的敌人属性变化（包括敌人的状态：是否死亡）
		// 添加释放技能的人物属性的变化
		// 如果敌人死亡则获得该敌人掉落的物品、装备、经验、金币
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
		if (this.skill.get(num).getWeapon_range() != sort.WHOLE_PEOPLE) {
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
		// 添加被释放技能的敌团属性变化（包括敌团中敌人的状态：是否死亡）
		// 添加释放技能的人物属性的变化
		// 如果敌人死亡则获得该敌人掉落的物品、装备、经验、金币
	}

}
