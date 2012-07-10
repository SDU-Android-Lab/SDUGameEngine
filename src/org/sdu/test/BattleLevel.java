package org.sdu.test;

import java.util.Vector;

import org.sdu.android.GameView;
import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.control.GameChoiceListener;
import org.sdu.android.control.window.GameChoice;
import org.sdu.android.control.window.GameTextButton;
import org.sdu.android.control.window.UIAdapter;
import org.sdu.android.control.window.UIFont;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.sprite.DynamicSprite;
import org.sdu.android.util.graphicsUtil.SImage;
import org.sdu.android.util.mediaUtil.Sound;

import android.view.MotionEvent;

public class BattleLevel extends ComponentLevel implements GameActionListener,GameChoiceListener{

	Sound s=new Sound();
	
	/** 菜单 */
	Vector<GameChoice> gc;
	/**属性按钮列表*/
	Vector<GameTextButton> gtb=new Vector<GameTextButton>();

	GameView view;

	int height = 0;
	int width = 0;
	int x0 = 0;
	int x1 =SystemData.getActivityWidth();
	int y0 = 0;
	int y1 = 0;

	BattleScene bs;
	
	DynamicSprite choiceEnemy,choiceHero;
	/**精灵列表*/
	Vector<DynamicSprite> dsList;
	/**是否逃跑成功*/
	boolean run1=false,run2=false;
	
	public BattleLevel(Vector<DynamicSprite> dsList,BattleScene bs,Vector<GameChoice> gc){
		super();
		SystemData.setCurrentComponentLevel(this);
		
		s.initSoundP(4);
		s.loadSoundP(SystemData.getCurrentActivity(),R.drawable.mus, 0,1);
		s.loadSoundP(SystemData.getCurrentActivity(),R.drawable.ao, 1,1);
		s.loadSoundP(SystemData.getCurrentActivity(),R.drawable.bibi, 2,1);
		s.loadSoundP(SystemData.getCurrentActivity(),R.drawable.ring, 3,1);
		//将精灵列表传入
		this.dsList=dsList;
		this.bs=bs;
		choiceEnemy=dsList.lastElement();
		choiceHero=dsList.firstElement();
		this.gc=gc;
	}
	/**
	 * 添加英雄
	 * 
	 * @param id
	 * @param n
	 * @param gtb
	 * @param text
	 * @param font
	 */
	public void addHero(int[] id, int n, GameTextButton[] gtb, String[] text,
			UIFont font) {
		gtb[n - 1] = new GameTextButton(id[n - 1], font, text[n - 1]);
		gtb[n - 1].load();
		height = gtb[n - 1].getHeight();
		gtb[n - 1].setX(x0);
		gtb[n - 1].setY(SystemData.getActivityHeight()
				- height);
		y0 = gtb[n - 1].getY();
		gtb[n - 1].setVisible(true);
		int yy = 1;
		for (int i = n - 2; i >= 0; i--) {
			gtb[i] = new GameTextButton(id[i], font, text[i], x0, y0 - height
					* yy);
			yy++;
			gtb[i].setVisible(true);
		}
		gtb[0].load();
		x0 += gtb[0].getWidth();
		y1 = gtb[0].getY();
		gtb[0].setActionListener(this);
		this.gtb.add(gtb[0]);
		
	}

	/**
	 * 添加敌人
	 * 
	 * @param id
	 * @param gtb
	 * @param text
	 * @param font
	 */
	public void addEnemy(int[] id, GameTextButton[] gtb, String[] text,
			UIFont font) {
		gtb[0] = new GameTextButton(id[0], font, text[0]);
		gtb[0].load();
		height = gtb[0].getHeight();
		width = gtb[0].getWidth();
		gtb[0].setX(x1 - width);
		gtb[0].setY(y1);

		gtb[0].setVisible(true);
		gtb[1] = new GameTextButton(id[1], font, text[1], x1 - width, y1
				+ height);
		gtb[1].setVisible(true);

		x1 -= width;
		gtb[0].setActionListener(this);
		this.gtb.add(gtb[0]);
	}
 
	@Override
	public void actionPerformed(UIAdapter ui, MotionEvent event) {
		//点下按钮并且该英雄没逃跑成功
		if (ui.equals(gtb.get(0))&&!run1) {
			gc.get(0).setVisible(true);
			gc.get(0).setActionListener(this);
			bs.removeSprite(dsList.get(0));
			bs.removeSprite(dsList.get(1));
			bs.addSprite(dsList.get(0),SImage.createImage("/res/hero1.png"),SystemData.getActivityHeight()/3,120);
			choiceHero=dsList.get(0);
		} else if (ui.equals(gtb.get(1))&&!run2) {
			gc.get(0).setVisible(true);
			gc.get(0).setActionListener(this);
			bs.removeSprite(dsList.get(0));
			bs.removeSprite(dsList.get(1));
			bs.addSprite(dsList.get(1),SImage.createImage("/res/hero2.png"),SystemData.getActivityHeight()/3,120);
			choiceHero=dsList.get(1);
		}
		else if (ui.equals(gtb.get(2))) {
			bs.removeSprite(dsList.get(2));
			bs.removeSprite(dsList.get(3));
			bs.addSprite(dsList.get(2),SImage.createImage("/res/enemy1.png"),SystemData.getActivityHeight()/3,200);
			choiceEnemy=bs.choose(dsList.get(2));
		} else if (ui.equals(gtb.get(3))) {
			bs.removeSprite(dsList.get(2));
			bs.removeSprite(dsList.get(3));
			bs.addSprite(dsList.get(3),SImage.createImage("/res/enemy2.png"),SystemData.getActivityHeight()/3,200);
			choiceEnemy=bs.choose(dsList.get(3));
		}
	}

	@Override
	public void actionPerformed(GameChoice gChoice, int selected,
			MotionEvent event) {
		if (selected == 0) {
			String str = gChoice.getSelectedText();
			SystemData.showToast(str);
			bs.battle(choiceEnemy);
			s.playSound(1, 1, 0, 1,100);
		} else if (selected == 1) {
			if(choiceHero.equals(dsList.get(0))){
				//显示二级菜单

			}else if(choiceHero.equals(dsList.get(1))){
				//显示二级菜单
			}
			
			String str = gChoice.getSelectedText();
			SystemData.showToast(str);
			bs.skill(choiceEnemy);
			s.playSound(2, 1, 0, 1,100);
		} else if (selected == 2) {
			if(choiceHero.equals(dsList.get(0))){
				//显示二级菜单
			}else if(choiceHero.equals(dsList.get(1))){
				//显示二级菜单
			}
			String str = gChoice.getSelectedText();
			SystemData.showToast(str);
			bs.useItem(choiceHero);
			s.playSound(3, 1, 0, 1,100);
		} else if (selected == 3) {
			s.playSound(0, 1, 0, 1,100);
			String str = gChoice.getSelectedText();
			SystemData.showToast(str);
			boolean run=bs.run(choiceHero);
			if(choiceHero.equals(dsList.get(0))){
				run1=run;
			}else if(choiceHero.equals(dsList.get(1))){
				run2=run;
			}
		}

		gc.get(0).setVisible(false);
		gc.get(1).setVisible(false);
	}

}
