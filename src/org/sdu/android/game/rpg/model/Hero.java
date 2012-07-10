package org.sdu.android.game.rpg.model;

import java.util.Vector;

import org.sdu.android.game.rpg.model.Skill.sort;


/**
 * Ӣ�ۻ���
 * 
 * @author yyt&&ls
 * 
 */
public class Hero extends People {

	/** Ӣ�۵ȼ� */
	private int degree;
	/** Ӣ����ߵȼ� */
	private int maxDegree;
	/** Ӣ�۳�ʼ�ȼ� */
	private int minDegree;
	/** Ӣ�۳�ʼ����ֵ */
	private int initialExp;
	/** Ӣ��������һ�����辭��ֵ */
	private int upDegreeExp;
	/** Ӣ�۵�ǰ����ֵ */
	private int currentExp;
	/** Ӣ�۵ȼ�֮�侭��ֵ�ı��� */
	private float multiple;
	/** Ӣ�۵���Ʒ�� */
	private Vector<Item> items = new Vector<Item>();
	/** Ӣ�۵�װ���� */
	private Vector<Equipment> equipments = new Vector<Equipment>();
	/** Ӣ�۵Ľ�� */
	private int gold;
	/** Ӣ�۳�����Ʒ��װ���۸���ʧ�ٷֱȣ�1-100�� */
	private int losePercent;

	/**
	 * Ĭ�ϵĹ��췽��
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
	 * ָ����ν�Ĺ��췽��
	 * 
	 * @param name
	 *            Ӣ�۳�ν
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
	 * �Զ��幹�췽��
	 * 
	 * @param name
	 *            Ӣ�۳�ν
	 * @param blood_volumn
	 *            Ӣ��Ѫ��
	 * @param magic_volumn
	 *            Ӣ��ħ��ֵ
	 * @param str
	 *            Ӣ������
	 * @param atk
	 *            Ӣ�۹�����
	 * @param def
	 *            Ӣ�۷�����
	 * @param dex
	 *            Ӣ�����ݶ�
	 * @param skill
	 *            Ӣ�ۼ�����
	 * @param defPercent
	 *            �����ܹ���ʱ���������������İٷֱȣ�ȡֵ��0-100��
	 * @param icon_id
	 *            Ӣ��ͼ����
	 * @param anim_id
	 *            Ӣ�۶������
	 * @param minDegree
	 *            Ӣ�۳�ʼ�ȼ�
	 * @param maxDegree
	 *            Ӣ����ߵȼ�
	 * @param upDegreeExp
	 *            Ӣ��������һ�����辭��ֵ
	 * @param initialExp
	 *            Ӣ�۳�ʼ����ֵ
	 * @param multiple
	 *            Ӣ�۵ȼ�֮�侭��ֵ�ı���
	 * @param items
	 *            Ӣ�۵���Ʒ��
	 * @param equipment
	 *            Ӣ�۵�װ����
	 * @param gold
	 *            Ӣ�۵Ľ��
	 * @param losePercent
	 *            Ӣ�۳�����Ʒ��װ���۸���ʧ�ٷֱȣ�1-100��
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
	 * ��ȡӢ��������һ�����辭��ֵ
	 * 
	 * @return
	 */
	public int getUpDegreeExp() {
		return upDegreeExp;
	}

	/**
	 * ����Ӣ��������һ������
	 * 
	 * @param upDegreeExp
	 */
	public void setUpDegreeExp(int upDegreeExp) {
		this.upDegreeExp = upDegreeExp;
	}

	/**
	 * ��ȡӢ�۵�ǰ����ֵ
	 * 
	 * @return
	 */
	public int getCurrentExp() {
		return currentExp;
	}

	/**
	 * ����Ӣ�۵�ǰ����ֵ
	 * 
	 * @param currentExp
	 */
	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	/**
	 * ��ȡӢ����ߵȼ�
	 * 
	 * @return
	 */
	public int getMaxDegree() {
		return maxDegree;
	}

	/**
	 * ����Ӣ����ߵȼ�
	 * 
	 * @param maxDegree
	 */
	public void setMaxDegree(int maxDegree) {
		this.maxDegree = maxDegree;
	}

	/**
	 * ��ȡӢ�۳�ʼ�ȼ�
	 * 
	 * @return
	 */
	public int getMinDegree() {
		return minDegree;
	}

	/**
	 * ����Ӣ�۳�ʼ�ȼ�
	 * 
	 * @param minDegree
	 */
	public void setMinDegree(int minDegree) {
		this.minDegree = minDegree;
	}

	/**
	 * ��ȡӢ�۵ȼ�֮�侭��ֵ�ı���
	 * 
	 * @return
	 */
	public float getMultiple() {
		return multiple;
	}

	/**
	 * ����Ӣ�۵ȼ�֮�侭��ֵ�ı���
	 * 
	 * @param multiple
	 */
	public void setMultiple(float multiple) {
		this.multiple = multiple;
	}

	/**
	 * ��ȡӢ�۵�ǰ�ȼ�
	 * 
	 * @return degree int
	 */
	public int getDegree() {
		return degree;
	}

	/**
	 * ����Ӣ�۵�ǰ�ȼ�
	 * 
	 * @param degree
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}

	/**
	 * ����Ӣ�۵���Ʒ��
	 * 
	 * @return Vector<Item>
	 */
	public Vector<Item> getItems() {
		return items;
	}

	/**
	 * ����Ӣ�۵���Ʒ��
	 * 
	 * @param items
	 */
	public void setItems(Vector<Item> items) {
		this.items = items;
	}

	/**
	 * ����Ӣ�۵�װ����
	 * 
	 * @return Vector<Equipment>
	 */
	public Vector<Equipment> getEquipments() {
		return equipments;
	}

	/**
	 * ����Ӣ�۵�װ����
	 * 
	 * @param equipments
	 *            Vector<Equipment>
	 */
	public void setEquipments(Vector<Equipment> equipments) {
		this.equipments = equipments;
	}

	/**
	 * ��ȡӢ�۳�ʼ����ֵ
	 * 
	 * @return ��ʼ����ֵ
	 */
	public int getInitialExp() {
		return initialExp;
	}

	/**
	 * ����Ӣ�۳�ʼ����ֵ
	 * 
	 * @param initialExp
	 *            ��ʼ����ֵ
	 */
	public void setInitialExp(int initialExp) {
		this.initialExp = initialExp;
	}

	/**
	 * ��ȡӢ�۵�ǰ���
	 * 
	 * @return ��� int
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * ����Ӣ�۵�ǰ���
	 * 
	 * @param gold
	 *            ���
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * ��ȡӢ�۳�����Ʒ��װ���۸���ʧ�ٷֱȣ�1-100��
	 * 
	 * @return Ӣ�۳�����Ʒ��װ���۸���ʧ�ٷֱȣ�1-100��
	 */
	public int getLosePercent() {
		return losePercent;
	}

	/**
	 * ����Ӣ�۳�����Ʒ��װ���۸���ʧ�ٷֱȣ�1-100��
	 * 
	 * @param losePercent
	 *            Ӣ�۳�����Ʒ��װ���۸���ʧ�ٷֱȣ�1-100��
	 */
	public void setLosePercent(int losePercent) {
		this.losePercent = losePercent;
	}

	/**
	 * Ӣ������
	 */
	public void upDegree() {
		if (this.degree < this.maxDegree) {
			this.degree++;
			this.upDegreeExp = (int) (this.upDegreeExp * this.multiple);
		}
	}

	/**
	 * Ӣ�۽���
	 */
	public void downDegree() {
		if (this.degree > minDegree) {
			this.degree--;
			this.upDegreeExp = (int) (this.upDegreeExp / this.multiple);
		}
	}

	/**
	 * �����Զ�������
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
	 * �����Զ��彵��
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
	 * �ж�Ӣ���Ƿ�����(Ӣ��ÿ�λ�þ���ʱ�������ж�)
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
	 *Ӣ��ʹ����Ʒ(ʹ�������Ʒ��ʧ��������Ʒ�����Ƴ�)
	 * 
	 * @param item
	 *            ��Ʒ
	 * @return boolean ����Ʒ�Ƿ������ԭ��Ʒ����
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
	 * Ӣ�۴���װ��
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
	 * Ӣ�ۻ���װ��
	 * 
	 * @param equipment
	 *            װ��
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
	 * Ӣ�ۻ����Ʒ���ǹ���
	 * 
	 * @param item
	 *            ��Ʒ
	 */
	public void addItem(Item item) {
		this.items.add(item);
	}

	/**
	 * Ӣ�۶�����Ʒ����������
	 * 
	 * @param item
	 *            ��Ʒ
	 * @return boolean Ӣ��ԭ��Ʒ�����Ƿ��и���Ʒ
	 */
	public boolean dropItem(Item item) {
		if (this.items.remove(item))
			return true;
		else
			return false;
	}

	/**
	 * Ӣ�ۻ��װ�����ǹ���
	 * 
	 * @param equipment
	 *            װ��
	 */
	public void addEquipment(Equipment equipment) {
		this.equipments.add(equipment);
	}

	/**
	 * Ӣ�۶���װ������������
	 * 
	 * @param equipment
	 *            װ��
	 * @return boolean Ӣ��ԭװ�������Ƿ��и�װ��
	 */
	public boolean dropEquipment(Equipment equipment) {
		if (this.equipments.remove(equipment))
			return true;
		else
			return false;
	}

	/**
	 * Ӣ�۹�����Ʒ
	 * 
	 * @param item
	 *            ��Ʒ
	 * @return �Ƿ������
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
	 * Ӣ�۳�����Ʒ
	 * 
	 * @param item
	 *            ��Ʒ
	 * @return boolean ����Ʒ�Ƿ������ԭ��Ʒ����
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
	 * Ӣ�۹���װ��
	 * 
	 * @param equipment
	 *            װ��
	 * @return �Ƿ������
	 */
	public boolean buyItem(Equipment equipment) {
		if (this.gold >= equipment.getPrice()) {
			this.gold -= equipment.getPrice();
			return true;
		} else
			return false;
	}

	/**
	 * Ӣ�۳���װ��
	 * 
	 * @param equipment
	 *            װ��
	 */
	public void sellItem(Equipment equipment) {
		if (this.losePercent < 0)
			this.losePercent = 0;
		else if (this.losePercent > 100)
			this.losePercent = 100;

		this.gold += equipment.getPrice() * (100 - this.losePercent) / 100;
	}

	/**
	 * Ӣ����ͨ������������(����˷�����Ӱ��)
	 * 
	 * @param enemy
	 *            ���������˶���
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
	 * Ӣ�۹������ţ�����ȫ�壬����˷�����Ӱ��)
	 * 
	 * @param enemys
	 *            ���������Ŷ���
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
	 * �Ե����ͷż���
	 * 
	 * @param enemy
	 * @param num
	 *            �ͷŵļ��ܶ�Ӧ�������λ��
	 * @return boolean �����Ƿ����ͷ�
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
	 * �Ե����ͷż���
	 * 
	 * @param enemys
	 * @param num
	 *            �ͷŵļ��ܶ�Ӧ�������λ��
	 * @return boolean �����Ƿ��ܹ����ͷ�
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
