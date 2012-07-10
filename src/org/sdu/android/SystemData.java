package org.sdu.android;

import org.sdu.android.control.ControlListener;
import org.sdu.android.control.window.UIManager;
import org.sdu.android.map.painter.level.ComponentLevel;
import org.sdu.android.map.painter.scene.SceneInterface;

import android.widget.Toast;



/**
 * 运行时核心数据
 * @author shadow
 *
 */
public class SystemData {
	/**当前Activity*/
	public static GameActivity currentActivity;
	/**当前View*/
	public static GameView currentView;
	/**当前Scene*/
	public static SceneInterface currentScene;
	/**当前FPS*/
	public static int currentFPS;
	/**事件监听器*/
	public static ControlListener controlListener;
	/**当前组件层*/
	public static ComponentLevel currentComponentLevel;
	/**一秒*/
	public final static int ONESECOND=1000;
	/**默认FPS 30*/
	public final static int DEFALUTFPS=30;
	/**
	 * 获取当前UIManager
	 * @return the uiManager
	 */
	public static UIManager getUiManager() {
		return currentComponentLevel.uiManager;
	}

	
	/**
	 * 得到当前事件管理器
	 * @return 当前事件管理器
	 */
	public static ControlListener getControlListener() {
		return controlListener;
	}
	/**
	 * 注册当前事件管理器
	 * @param controlListener 事件管理器
	 */
	public static void setControlListener(ControlListener controlListener) {
		SystemData.controlListener = controlListener;
	}
	/**得到当前Activity
	 * @return the currentActivity 当前Activity
	 */
	public static GameActivity getCurrentActivity() {
		return currentActivity;
	}
	/**注册当前Activity
	 * @param currentActivity 需注册的Activity
	 */
	public static void setCurrentActivity(GameActivity currentActivity) {
		SystemData.currentActivity = currentActivity;
	}
	/**
	 * 得到当前View
	 * @return 当前View
	 */
	public static GameView getCurrentView() {
		return currentView;
	}
	/**
	 * 注册当前View
	 * @param currentView 被注册View
	 */
	public static void setCurrentView(GameView currentView) {
		SystemData.currentView = currentView;
	}
	/**
	 * 得到当前Scene
	 * @return 当前Scene
	 */
	public static SceneInterface getCurrentScene() {
		return currentScene;
	}
	/**
	 * 注册挡墙Scene
	 * @param currentScene 当前Scene
	 */
	public static void setCurrentScene(SceneInterface currentScene) {
		SystemData.currentScene = currentScene;
	}
	/**
	 * 得到当前FPS
	 * @return 当前FPS
	 */
	public static int getCurrentFPS() {
		return currentFPS==0?DEFALUTFPS:currentFPS;
	}
	/**
	 * 注册当前FPS
	 * @param currentFPS 当前FPS
	 */
	public static void setCurrentFPS(int currentFPS) {
		SystemData.currentFPS = currentFPS;
	}
	/**
	 * 根据FPS得到画面睡眠基础时间
	 * @return 睡眠基础时间 毫秒
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
	 * 返回当前屏幕高度
	 * @return 当前屏幕高度
	 */
	public static int getActivityHeight(){
		return currentActivity.getWindowManager().getDefaultDisplay().getHeight();
	}
	/**
	 * 返回当前屏幕宽度
	 * @return 当前屏幕高度
	 */
	public static int getActivityWidth(){
		return currentActivity.getWindowManager().getDefaultDisplay().getWidth();
	}
	/**
	 * 是否存在SD卡
	 * @return 存在true/不存在false
	 */
	public static boolean hasSDCard(){
		return android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED);
	}
	
	public static void showToast(String str){
		Toast.makeText(getCurrentActivity(), str, 0).show();
	}
}
