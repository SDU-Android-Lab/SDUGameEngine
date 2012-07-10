package org.sdu.android.sprite;

import org.sdu.android.sprite.change.Change;

import android.graphics.Paint;

/**
 * ���徫���Ƿ���Է�����ɫ��͸���ȵȱ仯
 * */
public interface Changeable {
	/**
	 * ���ָ���仯�¼�
	 * 
	 * @param change
	 *            ָ���ı仯
	 * */
	void addChanges(Change change);

	/**
	 * �Ƴ�ָ���ı仯�¼�
	 * 
	 * @param change
	 *            ָ���ı仯
	 * */
	void removeChanges(Change change);

	/**
	 * �Ƴ�ȫ���ı仯�¼�
	 * */
	void removeAllChanges();

	/**
	 * ��Ӧ�仯�¼�
	 * 
	 * @param paint
	 *            ���д����paint
	 * */
	void change(Paint paint);
}
