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
	/** 尝试过的标记 */
	final static int TRY = 38794;

	/** 四个方向对应的横坐标差值 */
	private final static int[] M = { 0, 0, 1, -1 };

	/** 四个方向对应的纵坐标差值 */
	private final static int[] N = { 1, -1, 0, 0 };
	/** 地图类 */
	private SimpleMap simpleMap;

	/** 已经走过的点 */
	private Set<PointFen> kai;

	/** 数组 */
	private int[][] map;

	/** 终点 */
	private Point end;

	/** 起点 */
	private Point start;

	/** 标记最小的g值 */
	private int[][] g;

	/** 是否成功找到路径 */
	private boolean succeed = false;

	/** 存储点的数组 */
	private ArrayList<Point> arr=new ArrayList<Point>();

	/**
	 * 构造Search
	 * 
	 * @param simpleMap
	 *            简单地图
	 */
	public Search(SimpleMap simpleMap) {
		this.simpleMap = simpleMap;
	}

	/**
	 * 返回找到的路径
	 * 
	 * @return 如果存在路径，则返回路径，否则返回null
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
	 * 复制数组
	 * 
	 * @param a
	 *            原数组
	 * @return 得到的数组
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
	 * 寻找路径
	 * 
	 * @param sta
	 *            起点
	 * @param en
	 *            终点
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
	 * 得到某点的h值
	 * 
	 * @param p
	 *            点
	 * @return 该点的h值
	 */
	private int getH(Point p) {
		return (Math.abs(end.x - p.x) + Math.abs(end.y - p.y));
	}

	/**
	 * 以某点为中心扩散
	 * 
	 * @param pf
	 *            节点
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
	 * 没到达目标，继续搜索
	 * @param pf 上一个节点
	 * @param ph 点
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
	 * 某点各个方向得到的点
	 * @param p 点
	 * @param d 方向
	 * @return 新点
	 */
	private static Point nextPoint(Point p, int d) {
		return new Point(p.x + M[d], p.y + N[d]);
	}
}
