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
 * ��ʾ����
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
	/**Ҫ��ʾ����Ŀs*/
	private  List<String> items=new ArrayList<String>();
	
	/**�ڴ˴�����ϣ��չʾ����Ŀ*/
	public void load(){
		items.add("ҡ�ˡ���ť���Ի���LOGO����ʾ��");
		items.add("��ͼʾ��");
		items.add("����ʾ��");
		items.add("���֡�ý��ʾ��");
		items.add("���ݿ�ʾ��");
		items.add("������Ӧʾ��");
		items.add("ս������");
		items.add("�ۺ���ʾ1");
		items.add("����ʾ����������");
	}
	/**
	 * ��������ʼ����������������֮
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
	 * ����,�������趨��ת��ָ������ʾActivity
	 * @param l �����
	 * @param v ��
	 * @param position ��List�еı��
	 * @param id �������~
	 */
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//Ϊ���ӱ�ħ��������͵�� = =
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
		
		//����else if (num.equals("��"))

		else{
		Toast.makeText(getApplicationContext(),"����ing ���ڴ�", Toast.LENGTH_SHORT).show();
		}
	}
	
	/**
	 * ���߷�������ת��ָ��Activity
	 * @param cls Ŀ��Class
	 */
	private void jumpTo(Class<?> cls){
		final Intent intent=new Intent();
		intent.setClass(DemoList.this,cls);
		startActivity(intent);
	}

}
