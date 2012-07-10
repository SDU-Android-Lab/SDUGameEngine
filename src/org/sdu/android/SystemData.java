package org.sdu.android;

import org.sdu.android.control.ControlListener;
import org.sdu.android.control.window.UIManager;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.map.painter.scene.SceneInterface;

import android.widget.Toast;



/**
 * ����ʱ��������
 * @author shadow
 *
 */
public class SystemData {
	/**��ǰActivity*/
	public static GameActivity currentActivity;
	/**��ǰView*/
	public static GameView currentView;
	/**��ǰScene*/
	public static SceneInterface currentScene;
	/**��ǰFPS*/
	public static int currentFPS;
	/**�¼�������*/
	public static ControlListener controlListener;
	/**��ǰ�����*/
	public static ComponentLevel currentComponentLevel;
	/**һ��*/
	public final static int ONESECOND=1000;
	/**Ĭ��FPS 30*/
	public final static int DEFALUTFPS=30;
	/**
	 * ��ȡ��ǰUIManager
	 * @return the uiManager
	 */
	public static UIManager getUiManager() {
		return currentComponentLevel.uiManager;
	}

	
	/**
	 * �õ���ǰ�¼�������
	 * @return ��ǰ�¼�������
	 */
	public static ControlListener getControlListener() {
		return controlListener;
	}
	/**
	 * ע�ᵱǰ�¼�������
	 * @param controlListener �¼�������
	 */
	public static void setControlListener(ControlListener controlListener) {
		SystemData.controlListener = controlListener;
	}
	/**�õ���ǰActivity
	 * @return the currentActivity ��ǰActivity
	 */
	public static GameActivity getCurrentActivity() {
		return currentActivity;
	}
	/**ע�ᵱǰActivity
	 * @param currentActivity ��ע���Activity
	 */
	public static void setCurrentActivity(GameActivity currentActivity) {
		SystemData.currentActivity = currentActivity;
	}
	/**
	 * �õ���ǰView
	 * @return ��ǰView
	 */
	public static GameView getCurrentView() {
		return currentView;
	}
	/**
	 * ע�ᵱǰView
	 * @param currentView ��ע��View
	 */
	public static void setCurrentView(GameView currentView) {
		SystemData.currentView = currentView;
	}
	/**
	 * �õ���ǰScene
	 * @return ��ǰScene
	 */
	public static SceneInterface getCurrentScene() {
		return currentScene;
	}
	/**
	 * ע�ᵲǽScene
	 * @param currentScene ��ǰScene
	 */
	public static void setCurrentScene(SceneInterface currentScene) {
		SystemData.currentScene = currentScene;
	}
	/**
	 * �õ���ǰFPS
	 * @return ��ǰFPS
	 */
	public static int getCurrentFPS() {
		return currentFPS==0?DEFALUTFPS:currentFPS;
	}
	/**
	 * ע�ᵱǰFPS
	 * @param currentFPS ��ǰFPS
	 */
	public static void setCurrentFPS(int currentFPS) {
		SystemData.currentFPS = currentFPS;
	}
	/**
	 * ����FPS�õ�����˯�߻���ʱ��
	 * @return ˯�߻���ʱ�� ����
	 */
	public static int getSleepTime(){
		return ONESECOND/getCurrentFPS();
	}
	/**
	 * @return the currentComponentLevel
	 */
	public static ComponentLevel getCurrentComponentLevel() {
		return currentComponentLevel;
	}
	/**
	 * @param currentComponentLevel the currentComponentLevel to set
	 */
	public static void setCurrentComponentLevel(ComponentLevel currentComponentLevel) {
		SystemData.currentComponentLevel = currentComponentLevel;
	}
	/**
	 * ���ص�ǰ��Ļ�߶�
	 * @return ��ǰ��Ļ�߶�
	 */
	public static int getActivityHeight(){
		return currentActivity.getWindowManager().getDefaultDisplay().getHeight();
	}
	/**
	 * ���ص�ǰ��Ļ���
	 * @return ��ǰ��Ļ�߶�
	 */
	public static int getActivityWidth(){
		return currentActivity.getWindowManager().getDefaultDisplay().getWidth();
	}
	/**
	 * �Ƿ����SD��
	 * @return ����true/������false
	 */
	public static boolean hasSDCard(){
		return android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
	}
	
	public static void showToast(String str){
		Toast.makeText(getCurrentActivity(), str, 0).show();
	}
}
