package org.sdu.test;

import java.util.Vector;

import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.control.window.GameSplash;
import org.sdu.android.control.window.UIAdapter;
import org.sdu.android.map.painter.ground.SimpleMap;
import org.sdu.android.map.painter.level.DynamicLevel;
import org.sdu.android.map.painter.level.StaticLevel;
import org.sdu.android.map.painter.scene.Scene;
import org.sdu.android.sprite.DynamicSprite;
import org.sdu.android.sprite.change.AlphaChange;
import org.sdu.android.util.graphicsUtil.SImage;

import android.graphics.Color;
import android.view.MotionEvent;


public class BattleScene extends Scene {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DynamicSprite bg;
	DynamicLevel dl;
	
	public void initialize(int h,int w,SImage background) {
		
		SimpleMap map=new SimpleMap(new int[][]{{1}}, w, h);
		StaticLevel sl=new StaticLevel();
		sl.initialize();
		sl.setWidthHeight(w, h);
		bg=new DynamicSprite(0,0,10, false);
		bg.load(background);
		bg.setHeight(SystemData.getActivityHeight());
		bg.setWidth(SystemData.getActivityWidth());
		bg.setScale(true);
		
		sl.add(bg);
		map.setDownLevel(sl);
		this.setMap(map);

		dl=new DynamicLevel();
		dl.initialize();
		this.setDynLevel(dl);

		
	}
	
	/**
	 * 添加精灵
	 * @param ds
	 * @param si
	 */
	public void addSprite(DynamicSprite ds,SImage si,int h,int w){
		ds.load(si);
//		ds.setHeight(h);
//		ds.setWidth(w);
//		ds.setScale(true);
		dl.add(ds);
	
	}
	/**
	 * 删除精灵
	 * @param ds
	 */
	public void removeSprite(DynamicSprite ds){
			dl.remove(ds);
		
	}

	
	/**
	 * 普通攻击动画
	 * @param ds
	 */
	public void battle(DynamicSprite ds){
		AlphaChange ac=new AlphaChange(20);
		ds.addChanges(ac);
		ds.start();
		
		AlphaChange ac1=new AlphaChange(255);
		ds.addChanges(ac1);
		ds.start();
	}
	/**
	 * 使用技能的动画
	 * @param ds
	 */
	public void skill(DynamicSprite ds){
		int i=0;
		while(i<2){
			AlphaChange ac=new AlphaChange(20);
			ds.addChanges(ac);
			ds.start();
			
			AlphaChange ac1=new AlphaChange(255);
			ds.addChanges(ac1);
			ds.start();
			i++;
		}
	}
	/**
	 * 使用物品的动画
	 * @param ds
	 */
	public void useItem(DynamicSprite ds){
		AlphaChange ac=new AlphaChange(20);
		ds.addChanges(ac);
		ds.start();
		
		AlphaChange ac1=new AlphaChange(255);
		ds.addChanges(ac1);
		ds.start();
	}
	/**
	 * 逃跑的动画
	 * @param ds
	 */
	public boolean run(DynamicSprite ds){
		if(Math.random()*100>60){
			dl.remove(ds);
			SystemData.showToast("逃跑成功！！");
			return true;
		}else{
			SystemData.showToast("逃跑失败。。");
			return false;
		}
		
	}
	/**
	 * 选中要攻打的敌人后的动画,选中ds1
	 * @param ds1
	 */
	public DynamicSprite choose(DynamicSprite ds1){

		AlphaChange ac1=new AlphaChange(200);
		ds1.addChanges(ac1);
		ds1.start();
		return ds1;
	}
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
	

}
