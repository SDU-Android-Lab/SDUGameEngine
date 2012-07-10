package org.sdu.android.game.rpg.model;

import java.util.Vector;

import org.sdu.android.game.rpg.model.Skill.sort;


/**
 * ���������
 * 
 * @author yyt&&ls
 * 
 */
public abstract class People {
	/** ����ĳ�ν */
	protected String name;
	/** �����״̬ */
	protected boolean isLive;
	/** �����Ѫ�� */
	protected int blood_volumn;
	/** �����ħ��ֵ */
	protected int magic_volum;
	/** ���������ֵ */
	protected int str;
	/** ����Ĺ����� */
	protected int atk;
	/** ����ķ����� */
	protected int def;
	/** ��������ݶ� */
	protected int dex;
	/** ����ļ����� */
	protected Vector<Skill> skill = new Vector<Skill>();
	/** �����ܹ���ʱ���������������İٷֱȣ�ȡֵ��0-100�� */
	protected int defPercent;
	/** ����ͼ���� */
	protected int icon_id;
	/** ���ﶯ����� */
	protected int anim_id;

	/**
	 * Ĭ�ϵĹ��췽��
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
	 * ָ����ν�Ĺ��췽��
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
	 * ��ȡ�����ν
	 * 
	 * @return name String
	 */
	public String getName() {
		return name;
	}

	/**
	 * ��������ĳ�ν
	 * 
	 * @param name
	 *            String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �ж������Ƿ�����
	 * 
	 * @return isLive boolean
	 */
	public boolean isLive() {
		return isLive;
	}

	/**
	 * ���������״̬��������������
	 * 
	 * @param isLive
	 *            ״̬
	 */
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	/**
	 * ��ȡ�����Ѫ��
	 * 
	 * @return blood_volumn int
	 */
	public int getBlood_volumn() {
		return blood_volumn;
	}

	/**
	 * ���������Ѫ��
	 * 
	 * @param blood_volumn
	 *            int
	 */
	public void setBlood_volumn(int blood_volumn) {
		this.blood_volumn = blood_volumn;
	}

	/**
	 * ��ȡ�����ħ��ֵ
	 * 
	 * @return magic_volum int
	 */
	public int getMagic_volum() {
		return magic_volum;
	}

	/**
	 * ���������Ѫ��
	 * 
	 * @param magic_volum
	 *            int
	 */
	public void setMagic_volum(int magic_volum) {
		this.magic_volum = magic_volum;
	}

	/**
	 * ��ȡ���������
	 * 
	 * @return str int
	 */
	public int getStr() {
		return str;
	}

	/**
	 * �������������
	 * 
	 * @param str
	 *            int
	 */
	public void setStr(int str) {
		this.str = str;
	}

	/**
	 * ��ȡ����Ĺ�����
	 * 
	 * @return
	 */
	public int getAtk() {
		return atk;
	}

	/**
	 * ��������Ĺ�����
	 * 
	 * @param atk
	 *            int
	 */
	public void setAtk(int atk) {
		this.atk = atk;
	}

	/**
	 * ��ȡ����ķ�����
	 * 
	 * @return def int
	 */
	public int getDef() {
		return def;
	}

	/**
	 * ��������ķ�����
	 * 
	 * @param def
	 *            int
	 */
	public void setDef(int def) {
		this.def = def;
	}

	/**
	 * ��ȡ��������ݶ�
	 * 
	 * @return dex int
	 */
	public int getDex() {
		return dex;
	}

	/**
	 * ������������ݶ�
	 * 
	 * @param dex
	 *            int
	 */
	public void setDex(int dex) {
		this.dex = dex;
	}

	/**
	 * ��ȡ����ļ�����
	 * 
	 * @return
	 */
	public Vector<Skill> getSkill() {
		return skill;
	}

	/**
	 * ��������ļ�����
	 * 
	 * @param skill
	 */
	public void setSkill(Vector<Skill> skill) {
		this.skill = skill;
	}

	/**
	 * ��ȡ�����ܹ���ʱ���������������İٷֱȣ�ȡֵ��0-100��
	 * 
	 * @return
	 */
	public int getDefPercent() {
		return defPercent;
	}

	/**
	 * ���������ܹ���ʱ���������������İٷֱȣ�ȡֵ��0-100��
	 * 
	 * @param defPercent
	 */
	public void setDefPercent(int defPercent) {
		this.defPercent = defPercent;
	}

	/**
	 * ��ȡ����ͼ����
	 * 
	 * @return ͼ���� int
	 */
	public int getIcon_id() {
		return icon_id;
	}

	/**
	 * ��������ͼ����
	 * 
	 * @param iconId
	 *            ͼ����
	 */
	public void setIcon_id(int iconId) {
		icon_id = iconId;
	}

	/**
	 * ��ȡ���ﶯ�����
	 * 
	 * @return int �������
	 */
	public int getAnim_id() {
		return anim_id;
	}

	/**
	 * �������ﶯ�����
	 * 
	 * @param animId
	 *            �������
	 */
	public void setAnim_id(int animId) {
		anim_id = animId;
	}

	/**
	 * �������＼��
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
	 * ɾ�����＼��
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
	 * ɾ�����＼����ָ��λ�õļ���
	 * 
	 * @param location
	 * @return ɾ���ļ��ܶ���
	 */
	public Skill reduceSkill(int location) {
		return this.skill.remove(location);
	}

	/**
	 * ��Ӣ���ͷż���
	 * 
	 * @param hero
	 *            Ӣ�۶���
	 * @param num
	 *            �ͷŵļ��ܶ�Ӧ�������λ��
	 * @return boolean 
	 *            �����ܷ��ͷ�
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
	 * �Ե����ͷż���
	 * 
	 * @param enemy
	 * @param num
	 *            �ͷŵļ��ܶ�Ӧ�������λ��
	 * @return boolean �����Ƿ����ͷ�
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

		// ��ӱ��ͷż��ܵĵ������Ա仯���������˵�״̬���Ƿ�������
		// ����ͷż��ܵ��������Եı仯
		// ��������������øõ��˵������Ʒ��װ�������顢���
	}

	/**
	 * �Ե����ͷż���
	 * 
	 * @param enemys
	 * @param num
	 *            �ͷŵļ��ܶ�Ӧ�������λ��
	 * @return boolean �����Ƿ��ܹ����ͷ�
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
		// ��ӱ��ͷż��ܵĵ������Ա仯�����������е��˵�״̬���Ƿ�������
		// ����ͷż��ܵ��������Եı仯
		// ��������������øõ��˵������Ʒ��װ�������顢���
	}

}
