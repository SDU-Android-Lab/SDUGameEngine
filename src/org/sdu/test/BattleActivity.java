package org.sdu.test;

import java.util.Vector;

import org.sdu.android.GameActivity;
import org.sdu.android.GameView;
import org.sdu.android.SystemData;
import org.sdu.android.control.window.GameChoice;
import org.sdu.android.control.window.GameSplash;
import org.sdu.android.control.window.GameTextButton;
import org.sdu.android.control.window.UIFont;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.sprite.DynamicSprite;
import org.sdu.android.util.graphicsUtil.SImage;

import android.os.Bundle;
import android.util.Log;

public class BattleActivity extends GameActivity{
	/** ֡���� */
	public final int fps = 80;
	/** ���� */
	GameSplash gs;
	/** �½������ */
	ComponentLevel clevel = new ComponentLevel();

	/** ������Ϣ�б�ť */
	public GameTextButton hero_gtb1_1, hero_gtb1_2, hero_gtb1_3, hero_gtb1_4;
	public GameTextButton hero_gtb2_1, hero_gtb2_2, hero_gtb2_3, hero_gtb2_4;
	public GameTextButton hero_gtb3_1, hero_gtb3_2, hero_gtb3_3, hero_gtb3_4;
	public GameTextButton enemy_gtb1_1, enemy_gtb1_2, enemy_gtb1_3,
			enemy_gtb1_4;
	public GameTextButton enemy_gtb2_1, enemy_gtb2_2, enemy_gtb2_3,
			enemy_gtb2_4;
	public GameTextButton enemy_gtb3_1, enemy_gtb3_2, enemy_gtb3_3,
			enemy_gtb3_4;

	GameTextButton gtb1[] = { hero_gtb1_1, hero_gtb1_2, hero_gtb1_3,
			hero_gtb1_4 };
	GameTextButton gtb2[] = { hero_gtb2_1, hero_gtb2_2, hero_gtb2_3,
			hero_gtb2_4 };
	GameTextButton gtb3[] = { hero_gtb3_1, hero_gtb3_2, hero_gtb3_3,
			hero_gtb3_4 };
	GameTextButton gtb4[] = { enemy_gtb1_1, enemy_gtb1_2};
	GameTextButton gtb5[] = { enemy_gtb2_1, enemy_gtb2_2};
	GameTextButton gtb6[] = { enemy_gtb3_1, enemy_gtb3_2 };
	/** �˵� */
	GameChoice gc1;
	GameChoice gc2;
	GameChoice gc3;
	GameChoice gc4;
	GameChoice gc5;

	GameView view;

	int height = 0;
	int width = 0;
	int x0 = 0;
	int x1 = 0;
	int y0 = 0;
	int y1 = 0;

	BattleScene bs;
	BattleLevel bl;

	DynamicSprite ds1;
	DynamicSprite ds2;
	
	DynamicSprite ds4;
	DynamicSprite ds5;
	/** �˵� */
	Vector<GameChoice> gc=new Vector<GameChoice>();
	
	/**�����б�*/
	Vector<DynamicSprite> dsList=new Vector<DynamicSprite>();
	/**
	 * ��ڷ���
	 * 
	 * @param bundle
	 *            bundle
	 */
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		SystemData.setCurrentFPS(fps);
		x1 = SystemData.getActivityWidth();
		addSpr();
		addHeroList();
		
	}

	/**
	 * ���ؾ���
	 */
	public void addSpr(){
		bs=new BattleScene();
		bs.initialize(SystemData.getActivityHeight(),
				SystemData.getActivityWidth(),SImage.createImage("/res/bg1.jpg"));
		bs.load(getResources());
		SystemData.setCurrentScene(bs);	
		ds1=new DynamicSprite(10,10,1, true);
		ds2=new DynamicSprite(10,10,2, true);
		ds4=new DynamicSprite(x1-150,10,3, true);
		ds5=new DynamicSprite(x1-150,10,4, true);

		ds1.load(SImage.createImage("/res/hero1.png"));
		ds2.load(SImage.createImage("/res/hero2.png"));
		ds4.load(SImage.createImage("/res/enemy1.png"));
		ds5.load(SImage.createImage("/res/enemy2.png"));
		dsList.add(ds1);
		dsList.add(ds2);
		dsList.add(ds5);
		dsList.add(ds4);
		bs.addSprite(ds1, SImage.createImage("/res/hero1.png"),SystemData.getActivityHeight()/3,120);
		bs.addSprite(ds4, SImage.createImage("/res/enemy1.png"),SystemData.getActivityHeight()/3,200);
		
	}
	/** ����Ӣ�ۡ����������б� */
	public void addHeroList() {
		
		UIFont font = UIFont.getFont("Monospaced", 0, 13);
		int id[] = { 001, 002, 003, 004 };
		int id1[] = { 011, 012 };
		String text1[] = { "===Ӣ��A===", "Ѫ����", "������", "��:" };
		String text2[] = { "===Ӣ��B===", "Ѫ����", "������", "��:" };
		String text4[] = { "===����A===", "Ѫ����" };
		String text5[] = { "===����B===", "Ѫ����" };
		gc1=new GameChoice(1,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"��ͨ����","���⼼��","ʹ����Ʒ","��Ϊ�ϼ�"},0,50);
		//�����˵�
		gc2=new GameChoice(2,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"A����1","A����2"},0,50);
		gc3=new GameChoice(3,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"B����1","B����2"},0,50);
		gc4=new GameChoice(4,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"��Ʒ1","��Ʒ2"},0,50);
		gc.add(gc1);
		gc.add(gc2);
		gc.add(gc3);
		gc.add(gc4);

		bl=new BattleLevel(dsList, bs,gc);
		
		bl.addHero(id, 4, gtb1, text1, font);
		bl.addHero(id, 4, gtb2, text2, font);
		bl.addEnemy(id1, gtb4, text4, font);
		bl.addEnemy(id1, gtb5, text5, font);
	
	}

	
}
