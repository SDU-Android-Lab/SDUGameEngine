package org.sdu.android.util.sensorUtil;

import org.sdu.android.GameActivity;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/**
 * 重力感应类，需要使用重力感应效果时，继承此类
 * 重载act方法，添加具体操作
 * 可以控制开启或关闭重力感应效果
 * @author yyt
 * 
 */
public class Sensor extends GameActivity {
	/** x轴方向参数 */
	public float x;
	/** y轴方向参数 */
	public float y;
	/** z轴方向参数 */
	public float z;

	/** SensorManager对象 */
	SensorManager sensorMgr;
	/** Sensor对象 */
	android.hardware.Sensor sensor;
	/** SensorEventListener对象,用于监听 */
	SensorEventListener lsn;

	/**
	 * 入口方法
	 * 
	 * @param savedInstanceState
	 *            Bundle对象
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/** SensorManager对象 */
		sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		/** Sensor对象 */
		/*
		 * TYPE注解 intTYPE_ACCELEROMETER 加速度 ;intTYPE_ALL 所有类型，NexusOne默认为
		 * 加速度;intTYPE_GYROSCOPE 回转仪(这个不太懂) intTYPE_LIGHT
		 * 光线感应;intTYPE_MAGNETIC_FIELD 磁场;intTYPE_ORIENTATION
		 * 定向（指北针）和角度;intTYPE_PRESSUR 压力计 intTYPE_PROXIMITY 距离？不太懂
		 * ;intTYPE_TEMPERATURE 温度
		 */
		sensor = sensorMgr
				.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER);
		lsn = new SensorEventListener() {
			public void onSensorChanged(SensorEvent e) {
				x = e.values[SensorManager.DATA_X];
				y = e.values[SensorManager.DATA_Y];
				z = e.values[SensorManager.DATA_Z];
				act(x, y, z);
			}
			@Override
			public void onAccuracyChanged(android.hardware.Sensor sensor,
					int accuracy) {
			}
		};
		// 注册listener，第三个参数是检测的灵敏度
		sensorMgr
				.registerListener(lsn, sensor, SensorManager.SENSOR_DELAY_GAME);
		/*
		 * SENSOR_DELAY_FASTEST 最灵敏，快的无语
		 * SENSOR_DELAY_GAME游戏的时候用这个，不过一般用这个就够了，和上一个很难看出区别 
		 * SENSOR_DELAY_NORMAL比较慢。 SENSOR_DELAY_UI 最慢的，几乎就是横和纵的区别
		 */
	}

	/**
	 * 设置相应操作
	 * 
	 * @param x
	 *            x坐标
	 * @param y
	 *            y坐标
	 * @param z
	 *            z坐标
	 */
	public void act(float x, float y, float z) {

	}

	/**
	 * 取消重力感应
	 */
	public void close() {
		sensorMgr.unregisterListener(lsn, sensor);
		}
	/**
	 * 开启重力感应
	 */
	public void start(){
		sensorMgr
				.registerListener(lsn, sensor, SensorManager.SENSOR_DELAY_GAME);
	}

}
