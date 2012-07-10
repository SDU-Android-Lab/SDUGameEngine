
package org.sdu.test.gameText;

import org.sdu.android.SystemData;
import org.sdu.android.control.GameActionListener;
import org.sdu.android.control.GameChoiceListener;
import org.sdu.android.control.window.GameButton;
import org.sdu.android.control.window.GameChoice;
import org.sdu.android.control.window.GameSplash;
import org.sdu.android.control.window.GameTextButton;
import org.sdu.android.control.window.UIAdapter;
import org.sdu.android.control.window.UIFont;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.util.graphicsUtil.SImage;
import org.sdu.android.util.mediaUtil.Sound;
import org.sdu.android.util.sensorUtil.Sensor;
import org.sdu.test.R;

import android.graphics.Color;
import android.view.MotionEvent;

/**
 * @author shadow
 *
 */
public class LogLevel extends ComponentLevel implements GameActionListener,GameChoiceListener{
	Sound s=new Sound();

	GameSplash gs;
	GameButton start;	
	GameButton load;
	GameButton exit;
	GameChoice gc;
	GameTextButton gtb;
	public LogLevel(){
		super();
		SystemData.setCurrentComponentLevel(this);
		loadStartSplash();
		s.initSoundP(2);
		s.loadSoundP(SystemData.getCurrentActivity(),R.drawable.mus, 0,1);
		s.loadSoundP(SystemData.getCurrentActivity(),R.drawable.ao, 1,1);
	}
	
	public void loadStartSplash(){
		gs=new GameSplash(0,new SImage[]{SImage.createImage("/res/splashstart.jpg")});
		gs.setActionListener(new GameActionListener(){
			@Override
			public void actionPerformed(UIAdapter ui,MotionEvent event) {
				SystemData.getCurrentView().setBaseColor(Color.BLACK);
				loadButton();
			}});
		gs.setVisible(true);
		gs.play();
	}
	
	public void loadEndSplash(){
		gs=new GameSplash(0,new SImage[]{SImage.createImage("/res/endsplash.jpg")});
		gs.setActionListener(new GameActionListener(){
			@Override
			public void actionPerformed(UIAdapter ui,MotionEvent event) {
				System.exit(0);
			}});
		gs.setVisible(true);
		gs.play();
	}
	public void loadButton(){
		((Sensor)SystemData.getCurrentActivity()).start();
		start=new GameButton(33,SImage.createImage("/res/title_start.png"),170,50);
		start.setVisible(true);
		start.setActionListener(this);
		load=new GameButton(33,SImage.createImage("/res/title_load.png"),170,130);
		load.setVisible(true);
		load.setActionListener(this);
		exit=new GameButton(33,SImage.createImage("/res/title_end.png"),170,210);
		gc=new GameChoice(3,UIFont.getFont("Monospaced", 0, 24),new String[]{"普通攻击","特殊技能","使用物品","走为上计"},20,10);
		gtb=new GameTextButton(4,UIFont.getFont("Monospaced", 0, 24),"我是文字按钮",190,10);
		exit.setVisible(true);
		exit.setActionListener(this);
	}
	
	@Override
	public void actionPerformed(UIAdapter ui, MotionEvent event) {
		if(ui.equals(start)){
			s.playSound(0, 1, 0, 1,100);
			gc.setVisible(true);
			gc.setActionListener(this);
		}else if(ui.equals(load)){
			s.playSound(0, 1, 0, 1,100);
			gtb.setVisible(true);
			gtb.setActionListener(this);
		}else if(ui.equals(exit)){
			this.removeAll();
			s.playSound(1, 1, 0, 1,100);
			loadEndSplash();
		}else if(ui.equals(gtb)){
			SystemData.showToast(gtb.getText());
		}
	}

	/**
	 * @param ui
	 * @param selected
	 * @param event
	 * @see org.sdu.android.control.GameChoiceListener#actionPerformed(org.sdu.android.control.window.GameChoice, int, android.view.MotionEvent)
	 */
	
	@Override
	public void actionPerformed(GameChoice gChoice, int selected, MotionEvent event) {
			String str=gChoice.getSelectedText();
			SystemData.showToast(str);
	}

	

}
