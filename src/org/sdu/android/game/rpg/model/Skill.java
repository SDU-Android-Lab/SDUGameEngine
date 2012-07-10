package org.sdu.android.game.rpg.model;

/**
 * 技能基类
 * 
 * @author yyt&&ls
 * 
 */
public class Skill {
	/** 技能名称 */
	private String name;
	/** 技能编号 */
	private int id;
	/** 技能简介 */
	private String intro;
	/** 技能对英雄等级的下限要求 */
	private int minDegree;
	/** 对技能释放者自身的消耗：血量 */
	private int alter_blood_personal;
	/** 对技能释放者自身的消耗：魔法值 */
	private int alter_magic_personal;
	/** 对技能释放者自身的消耗：体力 */
	private int alter_str_personal;
	/** 对技能释放者自身的消耗：敏捷度 */
	private int alter_dex_personal;
	/** 对技能释放目标对象的影响：血量 */
	private int alter_blood_aim;
	/** 对技能释放目标对象的影响：魔法值 */
	private int alter_magic_aim;
	/** 对技能释放目标对象的影响：体力 */
	private int alter_str_aim;
	/** 对技能释放目标对象的影响：敏捷度 */
	private int alter_dex_aim;
	/** 技能攻击范围 */
	private sort weapon_range;
	/** 技能图标编号 */
	private int icon_id;
	/** 技能动画编号 */
	private int anim_id;

	public enum sort {
		WHOLE_PEOPLE, SINGLE_PEOPLE, PERSONAL_PEOPLE;
	}
	
	/**
	 * 默认的构造方法
	 */
	public Skill() {
		this.name = "skill";
		this.id = 0;
		this.intro = "skill";
		this.minDegree = 0;
		this.weapon_range = sort.SINGLE_PEOPLE;
		this.alter_blood_aim = 10;
		this.alter_blood_personal = 0;
		this.alter_dex_aim = 0;
		this.alter_dex_personal = 0;
		this.alter_magic_aim = 0;
		this.alter_magic_personal = 10;
		this.alter_str_aim = 0;
		this.alter_str_personal = 0;
		this.icon_id = 0;
		this.anim_id = 0;
	}

	/**
	 * 自定义构造方法1
	 * 
	 * @param name
	 *            技能名称
	 * @param id
	 *            技能编号
	 * @param intro
	 *            技能简介
	 * @param minDegree
	 *            技能对英雄等级的下限要求
	 * @param weapon_range
	 *            技能攻击范围
	 * @param alter_blood_personal
	 *            技能对释放者自身血量的消耗
	 * @param alter_magic_personal
	 *            技能对释放者自身魔法值的消耗
	 * @param alter_str_personal
	 *            技能对释放者自身体力的消耗
	 * @param alter_dex_personal
	 *            技能对释放者自身敏捷度的消耗
	 * @param alter_blood_aim
	 *            技能对释放对象血量的影响
	 * @param alter_magic_aim
	 *            技能对释放对象魔法值的影响
	 * @param alter_str_aim
	 *            技能对释放对象体力的影响
	 * @param alter_dex_aim
	 *            技能对释放对象敏捷度的影响
	 */
	public Skill(String name, int id, String intro, int minDegree,
			sort weapon_range, int alter_blood_personal,
			int alter_magic_personal, int alter_str_personal,
			int alter_dex_personal, int alter_blood_aim, int alter_magic_aim,
			int alter_str_aim, int alter_dex_aim, int icon_id, int anim_id) {
		this.name = name;
		this.id = id;
		this.intro = intro;
		this.minDegree = minDegree;
		this.weapon_range = weapon_range;

		this.alter_blood_aim = alter_blood_aim;
		this.alter_blood_personal = alter_blood_personal;
		this.alter_dex_aim = alter_dex_aim;
		this.alter_dex_personal = alter_dex_personal;
		this.alter_magic_aim = alter_magic_aim;
		this.alter_magic_personal = alter_magic_personal;
		this.alter_str_aim = alter_str_aim;
		this.alter_str_personal = alter_str_personal;

		this.icon_id = icon_id;
		this.anim_id = anim_id;
	}

	/**
	 * 自定义构造方法2
	 * 
	 * @param name
	 *            技能 名称
	 * @param id
	 *            技能id
	 */
	public Skill(String name, int id) {
		this();
		this.name = name;
		this.id = id;
	}

	/**
	 * 获取技能名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置技能名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取技能编号
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置技能编号
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取技能简介
	 * 
	 * @return
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * 设置技能简介
	 * 
	 * @param intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * 获取技能对英雄等级要求
	 * 
	 * @return
	 */
	public int getMinDegree() {
		return minDegree;
	}

	/**
	 * 设置技能对英雄等级要求
	 * 
	 * @param degree
	 */
	public void setMinDegree(int degree) {
		this.minDegree = degree;
	}

	/**
	 * 获取技能对释放者自身的血量消耗
	 * 
	 * @return
	 */
	public int getAlter_blood_personal() {
		return alter_blood_personal;
	}

	/**
	 * 设置技能对释放者自身血量的消耗
	 * 
	 * @param alterBloodPersonal
	 */
	public void setAlter_blood_personal(int alterBloodPersonal) {
		alter_blood_personal = alterBloodPersonal;
	}

	/**
	 * 获取技能对释放者自身魔法值的消耗
	 * 
	 * @return
	 */
	public int getAlter_magic_personal() {
		return alter_magic_personal;
	}

	/**
	 * 设置技能对释放者自身魔法值的消耗
	 * 
	 * @param alterMagicPersonal
	 */
	public void setAlter_magic_personal(int alterMagicPersonal) {
		alter_magic_personal = alterMagicPersonal;
	}

	/**
	 * 获取技能对释放者自身体力的消耗
	 * 
	 * @return
	 */
	public int getAlter_str_personal() {
		return alter_str_personal;
	}

	/**
	 * 设置技能对释放者自身体力的消耗
	 * 
	 * @param alterStrPersonal
	 */
	public void setAlter_str_personal(int alterStrPersonal) {
		alter_str_personal = alterStrPersonal;
	}

	/**
	 * 获取技能对释放者自身敏捷度的消耗
	 * 
	 * @return
	 */
	public int getAlter_dex_personal() {
		return alter_dex_personal;
	}

	/**
	 * 设置技能对释放者自身敏捷度的消耗
	 * 
	 * @param alterDexPersonal
	 */
	public void setAlter_dex_personal(int alterDexPersonal) {
		alter_dex_personal = alterDexPersonal;
	}

	/**
	 * 获取技能对目标血量的影响
	 * 
	 * @return
	 */
	public int getAlter_blood_aim() {
		return alter_blood_aim;
	}

	/**
	 * 设置技能对目标血量的影响
	 * 
	 * @param alterBloodAim
	 */
	public void setAlter_blood_aim(int alterBloodAim) {
		alter_blood_aim = alterBloodAim;
	}

	/**
	 * 获取技能对目标魔法值的影响
	 * 
	 * @return
	 */
	public int getAlter_magic_aim() {
		return alter_magic_aim;
	}

	/**
	 * 这是技能对目标魔法值的影响
	 * 
	 * @param alterMagicAim
	 */
	public void setAlter_magic_aim(int alterMagicAim) {
		alter_magic_aim = alterMagicAim;
	}

	/**
	 * 获取技能对目标体力的影响
	 * 
	 * @return
	 */
	public int getAlter_str_aim() {
		return alter_str_aim;
	}

	/**
	 * 设置技能对目标体力的影响
	 * 
	 * @param alterStrAim
	 */
	public void setAlter_str_aim(int alterStrAim) {
		alter_str_aim = alterStrAim;
	}

	/**
	 * 获取技能对目标敏捷度的影响
	 * 
	 * @return
	 */
	public int getAlter_dex_aim() {
		return alter_dex_aim;
	}

	/**
	 * 设置技能对目标敏捷度的影响
	 * 
	 * @param alterDexAim
	 */
	public void setAlter_dex_aim(int alterDexAim) {
		alter_dex_aim = alterDexAim;
	}

	/**
	 * 获取技能的攻击范围
	 * 
	 * @return
	 */
	public sort getWeapon_range() {
		return weapon_range;
	}

	/**
	 * 设置技能的攻击范围
	 * 
	 * @param weaponRange
	 */
	public void setWeapon_range(sort weaponRange) {
		weapon_range = weaponRange;
	}

	/**
	 * 获取技能图标编号
	 * 
	 * @return
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * 设置技能编号
	 * 
	 * @param iconId
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * 获取技能动画编号
	 * 
	 * @return
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * 设置技能动画编号
	 * 
	 * @param animId
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}
}
