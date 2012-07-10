package org.sdu.test;

import java.util.ArrayList;
import java.util.List;

import org.sdu.test.gameText.GameTest;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/**
 * 演示程序
 * @author sduAndroidTeam
 * 
 * @author Joycery & Sww
 * 					Map Scene etc
 * @author Misshooooo
 * 					Drawable Sprite etc
 * @author yes_coffee
 * 					Util SImage Database MultiPointsTools etc
 * @author yyt
 * 					Util Shaps Media etc
 * @author shadow
 * 					Activity UI etc
 */
public class DemoList extends ListActivity {
	/**要显示的项目s*/
	private  List<String> items=new ArrayList<String>();
	
	/**在此处加入希望展示的项目*/
	public void load(){
		items.add("摇杆、按钮、对话框、LOGO闪屏示例");
		items.add("地图示例");
		items.add("精灵示例");
		items.add("音乐、媒体示例");
		items.add("数据库示例");
		items.add("重力感应示例");
		items.add("战斗场景");
		items.add("综合演示1");
		items.add("更多示例请继续添加");
	}
	/**
	 * 创建及初始化方法，可以无视之
	 * @param bundle bundle
	 */
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setTheme(android.R.style.Theme_Black);
		load();
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);
		this.setListAdapter(adapter);
	}
	
	/**
	 * 监听,在这里设定跳转到指定的演示Activity
	 * @param l 囧囧囧囧
	 * @param v 囧
	 * @param position 在List中的编号
	 * @param id 囧囧有神~
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//为了逃避魔法数检查的偷懒 = =
		final String num=""+position;
		if(num.equals("0")){
			jumpTo(UIActivity.class);
		}
		else if (num.equals("1")){
			jumpTo(MapActivity.class);
		}
		else if(num.equals("2")){
			//jumpTo(SpriteActivity.class);
		}
		else if (num.equals("3")){
			jumpTo(SoundTest.class);
		
		}else if(num.equals("4")){
			jumpTo(DBTest.class);
		}
		else if(num.equals("5")){
			jumpTo(SensorTest.class);
		}
		else if(num.equals("6")){
			jumpTo(BattleActivity.class);
		}
		else if(num.equals("7")){
			jumpTo(GameTest.class);
		}
		
		//接着else if (num.equals("号"))

		else{
		Toast.makeText(getApplicationContext(),"开发ing 请期待", Toast.LENGTH_SHORT).show();
		}
	}
	
	/**
	 * 工具方法，跳转到指定Activity
	 * @param cls 目标Class
	 */
	private void jumpTo(Class<?> cls){
		final Intent intent=new Intent();
		intent.setClass(DemoList.this,cls);
		startActivity(intent);
	}

}
