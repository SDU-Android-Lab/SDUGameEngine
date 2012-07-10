package org.sdu.android.sprite;

import java.util.LinkedList;

import org.sdu.android.sprite.change.Move;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ���ƶ��ľ��飬����ʵ����ɫ��͸���ȵı仯�Լ�����Ч�����ƶ�.
 * 
 * 
 * 
 */
public class DynamicSprite extends StaticSprite implements Moveable {
	/** ������ƶ��¼� */
	LinkedList<Move> moves;

	/**
	 * ���췽��
	 * 
	 * @param x
	 *            ����ڵ�ͼx����
	 * @param y
	 *            ����ڵ�ͼy����
	 * @param id
	 *            id
	 * @param resId
	 *            ͼ����Դ�ı�ʶ
	 * @param canPlay
	 *            �����Ƿ�ɲ���
	 * 
	 */
	public DynamicSprite(int x, int y, int id, int resId, boolean canPlay) {
		super(x, y, id, resId, canPlay);
		moves = new LinkedList<Move>();
	}

	/**
	 * ���췽��
	 * 
	 * @param x
	 *            ����ڵ�ͼx����
	 * @param y
	 *            ����ڵ�ͼy����
	 * @param id
	 *            id
	 * @param canPlay
	 *            �����Ƿ�ɲ���
	 * */

	public DynamicSprite(int x, int y, int id, boolean canPlay) {
		super(x, y, id, canPlay);
		moves = new LinkedList<Move>();
	}

	/**
	 * @param id
	 * @param b
	 */
	public DynamicSprite(int id, boolean b) {
		this(0, 0, id, b);
	}

	/**
	 * ����onDraw����
	 * 
	 * @param canvas
	 *            ��Ҫ���ƵĻ���
	 * @param paint
	 *            �����õĻ���
	 */
	public void onDraw(Canvas canvas, Paint paint) {
		super.onDraw(canvas, paint);
		move();
	}

	/**
	 * ����ƶ��¼�
	 * 
	 * @param move
	 *            ָ�����ƶ��¼�
	 * */
	public void addMoves(Move move) {
		moves.add(move);
	}

	/**
	 * ��Ӧ�ƶ��¼�
	 * */
	public void move() {
		if (!start) {
			return;
		}
		if (!moves.isEmpty()) {
			final Move m = moves.get(0);
			m.begin(this);
			if (!m.isAlive()) {
				moves.remove(0);
			}
		}
	}

	/**
	 * �Ƴ�ָ�����ƶ��¼�
	 * 
	 * @param move
	 *            Ҫ�Ƴ����ƶ��¼�
	 * 
	 * */
	public void removeMoves(Move move) {
		moves.remove(move);
	}

}
