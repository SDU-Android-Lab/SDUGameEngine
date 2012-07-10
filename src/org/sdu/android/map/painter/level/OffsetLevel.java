package org.sdu.android.map.painter.level;


/**
 * ��ƫ������Level�ࣨ�����ࣩ
 * 
 * @author Joycery & Sww
 * 
 */
public abstract class OffsetLevel extends Level {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ļ���Ͻ��ڲ��ϵĺ�����
	 */
	protected int offsetX;

	/**
	 * ��Ļ���Ͻ��ڲ��ϵ�������
	 */
	protected int offsetY;

	/**
	 * ���� ��Ļ���Ͻ��ڲ��ϵĺ������������
	 * @param x
	 *            ��Ļ���Ͻ��ڲ��ϵĺ�����
	 * @param y
	 *            ��Ļ���Ͻ��ڲ��ϵ�������
	 */
	public void setOffsetXY(int x, int y) {
		offsetX = x;
		offsetY = y;
	}
}
