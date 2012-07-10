package org.sdu.test.gameText;

import org.sdu.android.SystemData;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.util.sensorUtil.Sensor;

import android.os.Bundle;

/**
 * ��Ϸʾ��
 * 
 * @author shadow
 * 
 */
public class GameTest extends Sensor {
	/**fps*/
	final int fps=20;
	/**�����*/
	ComponentLevel first;
	
	/**
	 * ��ڷ���
	 * @param bundle bundle
	 */
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		getSystemService(AUDIO_SERVICE);
		SystemData.setCurrentFPS(fps);
		load();
		SystemData.setCurrentComponentLevel(first);
		this.close();
	}
	
	public void load(){
		first=new LogLevel();
	}
}
