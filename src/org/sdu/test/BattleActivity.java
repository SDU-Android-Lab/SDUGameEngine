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
	/** 帧速率 */
	public final int fps = 80;
	/** 闪屏 */
	GameSplash gs;
	/** 新建组件层 */
	ComponentLevel clevel = new ComponentLevel();

	/** 精灵信息列表按钮 */
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
	/** 菜单 */
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
	/** 菜单 */
	Vector<GameChoice> gc=new Vector<GameChoice>();
	
	/**精灵列表*/
	Vector<DynamicSprite> dsList=new Vector<DynamicSprite>();
	/**
	 * 入口方法
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
	 * 加载精灵
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
	/** 加载英雄、敌人属性列表 */
	public void addHeroList() {
		
		UIFont font = UIFont.getFont("Monospaced", 0, 13);
		int id[] = { 001, 002, 003, 004 };
		int id1[] = { 011, 012 };
		String text1[] = { "===英雄A===", "血量：", "体力：", "神:" };
		String text2[] = { "===英雄B===", "血量：", "体力：", "神:" };
		String text4[] = { "===敌人A===", "血量：" };
		String text5[] = { "===敌人B===", "血量：" };
		gc1=new GameChoice(1,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"普通攻击","特殊技能","使用物品","走为上计"},0,50);
		//二级菜单
		gc2=new GameChoice(2,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"A技能1","A技能2"},0,50);
		gc3=new GameChoice(3,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"B技能1","B技能2"},0,50);
		gc4=new GameChoice(4,UIFont.getFont("Monospaced", 0, 22),new
				 String[]{"物品1","物品2"},0,50);
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
