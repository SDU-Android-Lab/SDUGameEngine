package org.sdu.android.util.sensorUtil;

import org.sdu.android.GameActivity;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/**
 * ������Ӧ�࣬��Ҫʹ��������ӦЧ��ʱ���̳д���
 * ����act��������Ӿ������
 * ���Կ��ƿ�����ر�������ӦЧ��
 * @author yyt
 * 
 */
public class Sensor extends GameActivity {
	/** x�᷽����� */
	public float x;
	/** y�᷽����� */
	public float y;
	/** z�᷽����� */
	public float z;

	/** SensorManager���� */
	SensorManager sensorMgr;
	/** Sensor���� */
	android.hardware.Sensor sensor;
	/** SensorEventListener����,���ڼ��� */
	SensorEventListener lsn;

	/**
	 * ��ڷ���
	 * 
	 * @param savedInstanceState
	 *            Bundle����
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/** SensorManager���� */
		sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		/** Sensor���� */
		/*
		 * TYPEע�� intTYPE_ACCELEROMETER ���ٶ� ;intTYPE_ALL �������ͣ�NexusOneĬ��Ϊ
		 * ���ٶ�;intTYPE_GYROSCOPE ��ת��(�����̫��) intTYPE_LIGHT
		 * ���߸�Ӧ;intTYPE_MAGNETIC_FIELD �ų�;intTYPE_ORIENTATION
		 * ����ָ���룩�ͽǶ�;intTYPE_PRESSUR ѹ���� intTYPE_PROXIMITY ���룿��̫��
		 * ;intTYPE_TEMPERATURE �¶�
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
		// ע��listener�������������Ǽ���������
		sensorMgr
				.registerListener(lsn, sensor, SensorManager.SENSOR_DELAY_GAME);
		/*
		 * SENSOR_DELAY_FASTEST ���������������
		 * SENSOR_DELAY_GAME��Ϸ��ʱ�������������һ��������͹��ˣ�����һ�����ѿ������� 
		 * SENSOR_DELAY_NORMAL�Ƚ����� SENSOR_DELAY_UI �����ģ��������Ǻ���ݵ�����
		 */
	}

	/**
	 * ������Ӧ����
	 * 
	 * @param x
	 *            x����
	 * @param y
	 *            y����
	 * @param z
	 *            z����
	 */
	public void act(float x, float y, float z) {

	}

	/**
	 * ȡ��������Ӧ
	 */
	public void close() {
		sensorMgr.unregisterListener(lsn, sensor);
		}
	/**
	 * ����������Ӧ
	 */
	public void start(){
		sensorMgr
				.registerListener(lsn, sensor, SensorManager.SENSOR_DELAY_GAME);
	}

}
