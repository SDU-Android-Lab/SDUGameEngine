package org.sdu.android.game.rpg.model;

/**
 * ���ܻ���
 * 
 * @author yyt&&ls
 * 
 */
public class Skill {
	/** �������� */
	private String name;
	/** ���ܱ�� */
	private int id;
	/** ���ܼ�� */
	private String intro;
	/** ���ܶ�Ӣ�۵ȼ�������Ҫ�� */
	private int minDegree;
	/** �Լ����ͷ�����������ģ�Ѫ�� */
	private int alter_blood_personal;
	/** �Լ����ͷ�����������ģ�ħ��ֵ */
	private int alter_magic_personal;
	/** �Լ����ͷ�����������ģ����� */
	private int alter_str_personal;
	/** �Լ����ͷ�����������ģ����ݶ� */
	private int alter_dex_personal;
	/** �Լ����ͷ�Ŀ������Ӱ�죺Ѫ�� */
	private int alter_blood_aim;
	/** �Լ����ͷ�Ŀ������Ӱ�죺ħ��ֵ */
	private int alter_magic_aim;
	/** �Լ����ͷ�Ŀ������Ӱ�죺���� */
	private int alter_str_aim;
	/** �Լ����ͷ�Ŀ������Ӱ�죺���ݶ� */
	private int alter_dex_aim;
	/** ���ܹ�����Χ */
	private sort weapon_range;
	/** ����ͼ���� */
	private int icon_id;
	/** ���ܶ������ */
	private int anim_id;

	public enum sort {
		WHOLE_PEOPLE, SINGLE_PEOPLE, PERSONAL_PEOPLE;
	}
	
	/**
	 * Ĭ�ϵĹ��췽��
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
	 * �Զ��幹�췽��1
	 * 
	 * @param name
	 *            ��������
	 * @param id
	 *            ���ܱ��
	 * @param intro
	 *            ���ܼ��
	 * @param minDegree
	 *            ���ܶ�Ӣ�۵ȼ�������Ҫ��
	 * @param weapon_range
	 *            ���ܹ�����Χ
	 * @param alter_blood_personal
	 *            ���ܶ��ͷ�������Ѫ��������
	 * @param alter_magic_personal
	 *            ���ܶ��ͷ�������ħ��ֵ������
	 * @param alter_str_personal
	 *            ���ܶ��ͷ�����������������
	 * @param alter_dex_personal
	 *            ���ܶ��ͷ����������ݶȵ�����
	 * @param alter_blood_aim
	 *            ���ܶ��ͷŶ���Ѫ����Ӱ��
	 * @param alter_magic_aim
	 *            ���ܶ��ͷŶ���ħ��ֵ��Ӱ��
	 * @param alter_str_aim
	 *            ���ܶ��ͷŶ���������Ӱ��
	 * @param alter_dex_aim
	 *            ���ܶ��ͷŶ������ݶȵ�Ӱ��
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
	 * �Զ��幹�췽��2
	 * 
	 * @param name
	 *            ���� ����
	 * @param id
	 *            ����id
	 */
	public Skill(String name, int id) {
		this();
		this.name = name;
		this.id = id;
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
	 * ���ü�������
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ���ܱ��
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * ���ü��ܱ��
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ���ܼ��
	 * 
	 * @return
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * ���ü��ܼ��
	 * 
	 * @param intro
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * ��ȡ���ܶ�Ӣ�۵ȼ�Ҫ��
	 * 
	 * @return
	 */
	public int getMinDegree() {
		return minDegree;
	}

	/**
	 * ���ü��ܶ�Ӣ�۵ȼ�Ҫ��
	 * 
	 * @param degree
	 */
	public void setMinDegree(int degree) {
		this.minDegree = degree;
	}

	/**
	 * ��ȡ���ܶ��ͷ��������Ѫ������
	 * 
	 * @return
	 */
	public int getAlter_blood_personal() {
		return alter_blood_personal;
	}

	/**
	 * ���ü��ܶ��ͷ�������Ѫ��������
	 * 
	 * @param alterBloodPersonal
	 */
	public void setAlter_blood_personal(int alterBloodPersonal) {
		alter_blood_personal = alterBloodPersonal;
	}

	/**
	 * ��ȡ���ܶ��ͷ�������ħ��ֵ������
	 * 
	 * @return
	 */
	public int getAlter_magic_personal() {
		return alter_magic_personal;
	}

	/**
	 * ���ü��ܶ��ͷ�������ħ��ֵ������
	 * 
	 * @param alterMagicPersonal
	 */
	public void setAlter_magic_personal(int alterMagicPersonal) {
		alter_magic_personal = alterMagicPersonal;
	}

	/**
	 * ��ȡ���ܶ��ͷ�����������������
	 * 
	 * @return
	 */
	public int getAlter_str_personal() {
		return alter_str_personal;
	}

	/**
	 * ���ü��ܶ��ͷ�����������������
	 * 
	 * @param alterStrPersonal
	 */
	public void setAlter_str_personal(int alterStrPersonal) {
		alter_str_personal = alterStrPersonal;
	}

	/**
	 * ��ȡ���ܶ��ͷ����������ݶȵ�����
	 * 
	 * @return
	 */
	public int getAlter_dex_personal() {
		return alter_dex_personal;
	}

	/**
	 * ���ü��ܶ��ͷ����������ݶȵ�����
	 * 
	 * @param alterDexPersonal
	 */
	public void setAlter_dex_personal(int alterDexPersonal) {
		alter_dex_personal = alterDexPersonal;
	}

	/**
	 * ��ȡ���ܶ�Ŀ��Ѫ����Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_blood_aim() {
		return alter_blood_aim;
	}

	/**
	 * ���ü��ܶ�Ŀ��Ѫ����Ӱ��
	 * 
	 * @param alterBloodAim
	 */
	public void setAlter_blood_aim(int alterBloodAim) {
		alter_blood_aim = alterBloodAim;
	}

	/**
	 * ��ȡ���ܶ�Ŀ��ħ��ֵ��Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_magic_aim() {
		return alter_magic_aim;
	}

	/**
	 * ���Ǽ��ܶ�Ŀ��ħ��ֵ��Ӱ��
	 * 
	 * @param alterMagicAim
	 */
	public void setAlter_magic_aim(int alterMagicAim) {
		alter_magic_aim = alterMagicAim;
	}

	/**
	 * ��ȡ���ܶ�Ŀ��������Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_str_aim() {
		return alter_str_aim;
	}

	/**
	 * ���ü��ܶ�Ŀ��������Ӱ��
	 * 
	 * @param alterStrAim
	 */
	public void setAlter_str_aim(int alterStrAim) {
		alter_str_aim = alterStrAim;
	}

	/**
	 * ��ȡ���ܶ�Ŀ�����ݶȵ�Ӱ��
	 * 
	 * @return
	 */
	public int getAlter_dex_aim() {
		return alter_dex_aim;
	}

	/**
	 * ���ü��ܶ�Ŀ�����ݶȵ�Ӱ��
	 * 
	 * @param alterDexAim
	 */
	public void setAlter_dex_aim(int alterDexAim) {
		alter_dex_aim = alterDexAim;
	}

	/**
	 * ��ȡ���ܵĹ�����Χ
	 * 
	 * @return
	 */
	public sort getWeapon_range() {
		return weapon_range;
	}

	/**
	 * ���ü��ܵĹ�����Χ
	 * 
	 * @param weaponRange
	 */
	public void setWeapon_range(sort weaponRange) {
		weapon_range = weaponRange;
	}

	/**
	 * ��ȡ����ͼ����
	 * 
	 * @return
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * ���ü��ܱ��
	 * 
	 * @param iconId
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * ��ȡ���ܶ������
	 * 
	 * @return
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * ���ü��ܶ������
	 * 
	 * @param animId
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}
}
