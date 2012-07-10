package org.sdu.android.util.recordStoreUtil;

import org.sdu.android.SystemData;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * 
 * @author yes_coffee
 * 
 */
public class ResTable {

	/**
	 * 获得系统数据库
	 */
	BaseDB myDB = BaseDB.getInstance(SystemData.getCurrentActivity());

	/**
	 * 资源表名
	 */
	private final static String TABLE_NAME_RES = "android_res";

	/**
	 * 资源表ID
	 */
	private final static String FIELD_RES_ID = "res_id";

	/**
	 * 资源表资源名
	 */
	private final static String FIELD_RES_NAME = "res_name";

	/**
	 * 资源表对应系统表中类别
	 */
	private final static String FIELD_RES_ANDROID_DB_TITLE = "android_db_title";

	/**
	 * 资源表资源数量
	 */
	private final static String FIELD_RES_NUMBER = "res_number";

	/**
	 * 资源表资源数据
	 */
	private final static String FIELD_RES_DATA = "bytes";

	/**
	 * Log语句标志
	 */
	private final static String TAG = "ResTableCommand";

	/**
	 * 问号语句标志
	 */
	private final static String TAG_WENHAO = "?";

	/**
	 * SQL查询条件结尾标志
	 */
	private final static String SQLINFO = "='?'; ";

	/**
	 * 模式FIELD_RES_NAME代号
	 */
	final static int MODE_FIELD_RES_NAME = 1;

	/**
	 * 模式FIELD_RES_ANDROID_DB_TITLE代号
	 */
	final static int MODE_FIELD_RES_ANDROID_DB_TITLE = 2;

	/**
	 * 系统数据库表创建语句
	 */
	private static final String RES_TABLE_CREATE = "create table "
			+ TABLE_NAME_RES + " (" + FIELD_RES_ID
			+ " integer primary key autoincrement, " + FIELD_RES_NAME
			+ " text not null, " + FIELD_RES_ANDROID_DB_TITLE
			+ " int not null, " + FIELD_RES_NUMBER + " int default 1, "
			+ FIELD_RES_DATA + " BLOB); ";

	/**
	 * 构造函数
	 */
	public ResTable() {
		if (!existTable(TABLE_NAME_RES)) {
			final boolean result = myDB.execSQL(RES_TABLE_CREATE);
			if (result) {
				Log.w(TAG, "Create Ok");
			} else {
				Log.w(TAG, "Create Error");
			}
		}
	}

	/**
	 * 查看是否存在表
	 * 
	 * @param tableName
	 *            表名
	 * @return true 存在 false 不存在
	 */
	private boolean existTable(String tableName) {
		boolean flag = false;
		final SQLiteDatabase db = myDB.getReadableDatabase();
		final String sqlString = "SELECT name FROM sqlite_master "
				+ "WHERE type='table' and name" + SQLINFO;
		sqlString.replace(TAG_WENHAO, tableName);
		final Cursor aCursor = db.rawQuery(sqlString, null);
		final int acount = aCursor.getCount();
		if (acount == 1) {
			flag = true;
		}
		aCursor.close();
		return flag;
	}

	/**
	 * 插入表项
	 * 
	 * @param name
	 *            资源名
	 * @param date
	 *            数据
	 * @param title
	 *            具体表项（类别）
	 * @return 行值
	 */
	public long insert(String name, byte[] date, String title) {
		final SQLiteDatabase db = myDB.getWritableDatabase();
		final ContentValues cv = new ContentValues();
		cv.put(FIELD_RES_NAME, name);
		cv.put(FIELD_RES_DATA, date);
		cv.put(FIELD_RES_ANDROID_DB_TITLE, title);
		final long rowNum = db.insert(TABLE_NAME_RES, null, cv);
		if (!myDB.existTitle(title)) {
			myDB.insert(title);
		} else {
			final String sql = "update " + myDB.getTableName() + " set "
					+ myDB.getFieldNumberOfRes() + "="
					+ myDB.getFieldNumberOfRes() + "+1" + " where "
					+ myDB.getFieldTitle() + SQLINFO;
			sql.replace(TAG_WENHAO, title);
			db.execSQL(sql);
		}
		return rowNum;
	}

	/**
	 * 删除表项
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param mode
	 *            模式:1-FIELD_RES_NAME 2-FIELD_RES_ANDROID_DB_TITLE
	 * @throws ModeException
	 *             模式错误
	 */
	public void delete(String title, int mode) throws ModeException {
		if (mode == MODE_FIELD_RES_NAME) {
			myDB.delete(title, FIELD_RES_NAME, TABLE_NAME_RES);
		} else if (mode == MODE_FIELD_RES_ANDROID_DB_TITLE) {
			myDB.delete(title, FIELD_RES_ANDROID_DB_TITLE, TABLE_NAME_RES);
		} else {
			throw new ModeException("The Mode Error!");
		}
	}

	/**
	 * 更新表项(文字类)
	 * @param title
	 *            具体表项(条件)
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theTitle
	 *            具体表项(目标)
	 * @param mode
	 *            模式:1-FIELD_RES_NAME 2-FIELD_RES_ANDROID_DB_TITLE
	 * @throws ModeException
	 *             模式错误
	 */
	public void update(String title, String fieldTitle, String theTitle,
			int mode) throws ModeException {
		if (mode == MODE_FIELD_RES_NAME) {
			myDB.update(title, fieldTitle, theTitle, FIELD_RES_NAME,
					TABLE_NAME_RES);
		} else if (mode == MODE_FIELD_RES_ANDROID_DB_TITLE) {
			myDB.update(title, fieldTitle, theTitle,
					FIELD_RES_ANDROID_DB_TITLE, TABLE_NAME_RES);
		} else {
			throw new ModeException("The Mode Error");
		}
	}

	/**
	 * 更新表项(数字类)
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theNum
	 *            具体表项(目标)
	 */
	public void update(String title, String fieldTitle, int theNum) {
		myDB
				.update(title, fieldTitle, theNum, FIELD_RES_NUMBER,
						TABLE_NAME_RES);
	}

	/**
	 * 更新表项(数据类)
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param data
	 *            具体表项(目标)
	 */
	public void update(String title, String fieldTitle, byte[] data) {
		myDB.update(title, fieldTitle, data, FIELD_RES_NUMBER, TABLE_NAME_RES);
	}

	/**
	 * 查询所有表项
	 * 
	 * @return Cursor 指针，由指针可以操控结果集
	 */
	public Cursor queryAll() {
		final Cursor aCursor = myDB.select(TABLE_NAME_RES);
		return aCursor;
	}

	/**
	 * 查询特定项(文字类) 
	 * @param title
	 *            具体表项（条件）
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theFieldTitle 表项名(目标)           
	 * @param tableName
	 *            表名
	 * @return 文字项集
	 */
	public String[] queryString(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		return myDB.queryString(title, fieldTitle, theFieldTitle, tableName);
	}

	/**
	 * 查询特定项(数字类)
	 * 
	 * @param title
	 *            数字类具体表项（条件）
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theFieldTitle
	 *            表项名(目标)
	 * @param tableName
	 *            表名
	 * @return 文字项集
	 */
	public int[] queryInt(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		return myDB.queryInt(title, fieldTitle, theFieldTitle, tableName);
	}

	/**
	 * 查询特定项(数据类)
	 * 
	 * @param title
	 *            具体表项（条件）
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theFieldTitle
	 *            表项名(目标)
	 * @param tableName
	 *            表名
	 * @return 文字项集
	 */
	public byte[][] queryDate(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		return myDB.queryDate(title, fieldTitle, theFieldTitle, tableName);
	}

}
