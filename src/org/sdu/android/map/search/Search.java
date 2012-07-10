package org.sdu.android.map.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.sdu.android.map.painter.ground.Map;
import org.sdu.android.map.painter.ground.SimpleMap;

import android.graphics.Point;
import android.util.Log;

/**
 * 
 * @author Owner
 * 
 */
public class Search {
	/** ���Թ��ı�� */
	final static int TRY = 38794;

	/** �ĸ������Ӧ�ĺ������ֵ */
	private final static int[] M = { 0, 0, 1, -1 };

	/** �ĸ������Ӧ���������ֵ */
	private final static int[] N = { 1, -1, 0, 0 };
	/** ��ͼ�� */
	private SimpleMap simpleMap;

	/** �Ѿ��߹��ĵ� */
	private Set<PointFen> kai;

	/** ���� */
	private int[][] map;

	/** �յ� */
	private Point end;

	/** ��� */
	private Point start;

	/** �����С��gֵ */
	private int[][] g;

	/** �Ƿ�ɹ��ҵ�·�� */
	private boolean succeed = false;

	/** �洢������� */
	private ArrayList<Point> arr=new ArrayList<Point>();

	/**
	 * ����Search
	 * 
	 * @param simpleMap
	 *            �򵥵�ͼ
	 */
	public Search(SimpleMap simpleMap) {
		this.simpleMap = simpleMap;
	}

	/**
	 * �����ҵ���·��
	 * 
	 * @return �������·�����򷵻�·�������򷵻�null
	 */
	public Route getRoute() {
		if (succeed) {
			ArrayList<Point> re=new ArrayList<Point>();
			for (Point old:arr){
				re.add(new Point(old.x*simpleMap.getTileWidth(),old.y*simpleMap.getTileHeight()));
			}
			Log.i("route",re.toString());
			return new Route(re);
		} else {
			return null;
		}
	}

	/**
	 * ��������
	 * 
	 * @param a
	 *            ԭ����
	 * @return �õ�������
	 */
	private static int[][] copy(int[][] a) {
		final int[][] b = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				b[i][j] = a[i][j];
			}
		}
		return b;
	}

	/**
	 * Ѱ��·��
	 * 
	 * @param sta
	 *            ���
	 * @param en
	 *            �յ�
	 */
	public void search(Point sta, Point en) {
		arr=new ArrayList<Point>();
		start = sta;
		end = en;
		map = copy(simpleMap.getArray());
		g = new int[map.length][map[0].length];
		kai = new TreeSet<PointFen>();
		final PointFen s = new PointFen(start);
		map[start.x][start.y] = TRY;
		kai.add(s);
		succeed = false;
		while (!succeed && !kai.isEmpty()) {
			final Iterator<PointFen> it = kai.iterator();
			final PointFen first = it.next();
			kai.remove(first);
			side(first);
		}
	}

	/**
	 * �õ�ĳ���hֵ
	 * 
	 * @param p
	 *            ��
	 * @return �õ��hֵ
	 */
	private int getH(Point p) {
		return (Math.abs(end.x - p.x) + Math.abs(end.y - p.y));
	}

	/**
	 * ��ĳ��Ϊ������ɢ
	 * 
	 * @param pf
	 *            �ڵ�
	 */
	private void side(PointFen pf) {
		final Point p = pf.p;
		map[p.y][p.x] = Map.NO;
		for (int i = 0; i < M.length; i++) {
			final Point ph = nextPoint(p, i);
			if (ph.x >= 0 && ph.y < map.length && ph.y >= 0&& ph.x < map[0].length) {
				if (ph.equals(end)) {
					PointFen position = pf;
					arr.add(end);
					while (position.pf != null) {
						arr.add(position.p);
						position = position.pf;
					}
					arr.add(start);
					succeed = true;
					return;
				}
				searchContinue(pf,ph);
			}
		}
	}
	/**
	 * û����Ŀ�꣬��������
	 * @param pf ��һ���ڵ�
	 * @param ph ��
	 */
	private void searchContinue(PointFen pf, Point ph){
		int gh = pf.g + 1;
		final PointFen pointfen = new PointFen(ph, g[ph.x][ph.y],getH(ph), pf);
		if (map[ph.y][ph.x] == Map.ALLOWED) {
			kai.add(pointfen);
			g[ph.y][ph.x] = gh;
			map[ph.y][ph.x] = TRY;
		} else if (map[ph.y][ph.x] == TRY) {
			gh = pointfen.g;
			if (gh < g[ph.y][ph.x]) {
				final Iterator<PointFen> it = kai.iterator();
				while (it.hasNext()) {
					final PointFen pif = it.next();
					if (pif.p.equals(ph)) {
						kai.remove(pif);
						kai.add(pointfen);
						g[ph.y][ph.x] = gh;
						break;
					}
				}
			}
		}
	}
	/**
	 * ĳ���������õ��ĵ�
	 * @param p ��
	 * @param d ����
	 * @return �µ�
	 */
	private static Point nextPoint(Point p, int d) {
		return new Point(p.x + M[d], p.y + N[d]);
	}
}
