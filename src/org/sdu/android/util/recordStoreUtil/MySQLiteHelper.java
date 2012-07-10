package org.sdu.android.util.recordStoreUtil;

import org.sdu.android.SystemData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

/**
 * 虚类，用于封装一层SQLiteOpenHelper，并作为数据库管理的基类与应用类的父类
 * 
 * @author yes_coffee
 * 
 */
public abstract class MySQLiteHelper extends SQLiteOpenHelper {
	/*
	 * onCreate（）与onUpgrade（）的参考 private static class DatabaseHelper extends
	 * SQLiteOpenHelper { DatabaseHelper(Context context) { super(context,
	 * DATABASE_NAME, null, DATABASE_VERSION); }
	 * 
	 * @Override public void onCreate(SQLiteDatabase db) {
	 * db.execSQL(DATABASE_CREATE); }
	 * 
	 * @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int
	 * newVersion) { Log.w(TAG, "Upgrading database from version " + oldVersion
	 * + " to " + newVersion + ", which will destroy all old data");
	 * db.execSQL("DROP TABLE IF EXISTS titles"); onCreate(db); } } }
	 */

	/**
	 * 数据库实例
	 */
	private SQLiteDatabase db = this.getWritableDatabase();;

	/**
	 * 上下文实例
	 */
	private Context ctx = SystemData.getCurrentActivity();

	/**
	 * 指针工厂
	 */
	private CursorFactory factory = null;

	/**
	 * 版本号
	 */
	private int version = 1;

	/**
	 * 信息标志
	 */
	final String tag = "SQLite Conmand";

	/**
	 * SQL语句的右半部分
	 */
	final String sqlInfo = "=?";

	/**
	 * 构造方法
	 * 
	 * @param context
	 *            上下文
	 * @param name
	 *            数据库名
	 * @param factory
	 *            指针工厂
	 * @param version
	 *            版本号
	 */
	public MySQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	/**
	 * 构造方法
	 * 
	 * @param context
	 *            上下文
	 * @param name
	 *            文件名
	 */
	public MySQLiteHelper(Context context, String name) {
		super(context, name, null, 1);
	}

	/**
	 * 初始化参数
	 */
	public void init() {
		db = null;
		ctx = null;
		factory = null;
		version = 1;
	}

	/**
	 * 取得数据库
	 * 
	 * @return 返回数据库
	 */
	public SQLiteDatabase getDb() {
		return db;
	}

	/**
	 * 设置数据库
	 * 
	 * @param db
	 *            数据库
	 */
	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}

	/**
	 * 取得上下文
	 * 
	 * @return 返回上下文
	 */
	public Context getCtx() {
		return ctx;
	}

	/**
	 * 设置上下文
	 * 
	 * @param ctx
	 *            上下文
	 */
	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	/**
	 * 取得指针工厂
	 * 
	 * @return 返回指针工厂
	 */
	public CursorFactory getFactory() {
		return factory;
	}

	/**
	 * 设置指针工厂
	 * 
	 * @param factory
	 *            指针工厂
	 */
	public void setFactory(CursorFactory factory) {
		this.factory = factory;
	}

	/**
	 * 取得版本号
	 * 
	 * @return 返回版本号
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * 设置版本号
	 * 
	 * @param version
	 *            版本号
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * 判断数据库是否存在
	 * 
	 * @param dbName
	 *            数据库名称
	 * @return true存在 false不存在
	 */
	public abstract boolean exist(String dbName);

	/**
	 * 打开数据库
	 * 
	 * @param dbName
	 *            数据库名称
	 * @param created
	 *            是否在不存在是创建
	 * @return true 打开成功 false打开失败
	 */
	public SQLiteDatabase openDatabase(String dbName, boolean created) {
		return openDatabase(dbName, null, created);
	}

	/**
	 * 打开数据库
	 * 
	 * @param dbName 数据库名称
	 * @param factory
	 *            指针工厂
	 * @param created
	 *            是否在不存在是创建
	 * @return 数据库
	 */
	public abstract SQLiteDatabase openDatabase(String dbName,
			CursorFactory factory, boolean created);

	/**
	 * 创建数据库
	 * @param dbName
	 *            数据库名称
	 * @param version
	 *            数据库版本
	 * @param factory
	 *            指针工厂
	 * @return true 建立成功 false 建立失败
	 */
	public abstract boolean createDatabase(String dbName, int version,
			CursorFactory factory);

	/**
	 * 创建数据库
	 * 
	 * @param dbName
	 *            数据库名称
	 * @return true 打开成功 false 打开失败
	 */
	public boolean createDatabase(String dbName) {
		return createDatabase(dbName, version, factory);
	}

	/**
	 * 关闭数据库
	 * 
	 */
	public void closeDatabase() {
		Log.i(tag, "close database");
		if (db != null) {
			db.close();
			init();
		}
	}

	/**
	 * 执行SQL语句
	 * 
	 * @param sql
	 *            要执行的SQL语句
	 * @return true成功 false失败
	 */
	public boolean execSQL(String sql) {
		boolean flag = false;
		Log.i(tag, "called fun execSQL()");
		Log.i(tag, "SQL:" + sql);
		try {
			db.execSQL(sql);
			Log.i(tag, "sql exec successfully!");
			flag = true;
		} catch (RuntimeException e) {
			Log.i(tag, "sql exec not successfully!");
			flag = false;
		}
		return flag;
	}

	/**
	 * 删除表
	 * 
	 * @param tableName
	 *            表名
	 * @return 成功则返回 表名 失败则返回null
	 */
	public String dropTable(String tableName) {
		Log.i(tag, "called fun dropTable()");
		if (tableName == null) {
			Log.i(tag, "table name is error! " + tableName + " is null !");
			return null;
		}
		final String DROP_TABLE = "DROP TABLE IF EXISTS " + tableName;
		db.execSQL(DROP_TABLE);
		Log.i(tag, "table/" + tableName + " is dropped successfully");
		return tableName;
	}

	/**
	 * 查询所有表项
	 * 
	 * @param tableName
	 *            表名
	 * @return 指针
	 */
	public Cursor select(String tableName) {
		final SQLiteDatabase db = this.getReadableDatabase();
		final Cursor cursor = db.query(tableName, null, null, null, null, null,
				null);
		return cursor;
	}

	/**
	 * 插入表项
	 * 
	 * @param title
	 *            具体表项
	 * @param fieldTitle
	 *            表项名
	 * @param tableName
	 *            表名
	 * @return 行值
	 */
	public long insert(String title, String fieldTitle, String tableName) {
	//	final SQLiteDatabase db = this.getWritableDatabase();
		final ContentValues cv = new ContentValues();
		cv.put(fieldTitle, title);
		final long row = db.insert(tableName, null, cv);
		return row;
	}

	/**
	 * 插入表项
	 * 
	 * @param bytes
	 *            具体表项
	 * @param fieldTitle
	 *            表项名
	 * @param tableName
	 *            表名
	 * @return 行值
	 */
	public long insert(byte[] bytes, String fieldTitle, String tableName) {
		final SQLiteDatabase db = this.getWritableDatabase();
		final ContentValues cv = new ContentValues();
		cv.put(fieldTitle, bytes);
		final long row = db.insert(tableName, null, cv);
		return row;
	}

	/**
	 * 删除表项
	 * 
	 * @param title
	 *            具体表项
	 * @param fieldTitle
	 *            表项名
	 * @param tableName
	 *            表名
	 */
	public void delete(String title, String fieldTitle, String tableName) {
		final SQLiteDatabase db = this.getWritableDatabase();
		final String where = fieldTitle + sqlInfo;
		final String[] whereValue = { title };
		db.delete(tableName, where, whereValue);
	}

	/**
	 * 更新表项(String)
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theTitle
	 *            具体表项(目标)(文字类)
	 * @param theFieldTitle
	 *            表项名(目标)
	 * @param tableName
	 *            表名
	 */
	public void update(String title, String fieldTitle, String theTitle,
			String theFieldTitle, String tableName) {
		final SQLiteDatabase db = this.getWritableDatabase();
		final String where = fieldTitle + sqlInfo;
		final String[] whereValue = { title };
		final ContentValues cv = new ContentValues();
		cv.put(theFieldTitle, theTitle);
		db.update(tableName, cv, where, whereValue);
	}

	/**
	 * 更新表项(int)
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theNum
	 *            具体表项(目标)(数字类)
	 * @param theFieldTitle
	 *            表项名(目标)
	 * @param tableName
	 *            表名
	 */
	public void update(String title, String fieldTitle, int theNum,
			String theFieldTitle, String tableName) {
		final SQLiteDatabase db = this.getWritableDatabase();
		final String where = fieldTitle + sqlInfo;
		final String[] whereValue = { title };
		final ContentValues cv = new ContentValues();
		cv.put(theFieldTitle, theNum);
		db.update(tableName, cv, where, whereValue);
	}
	
	/**
	 * 更新表项(data)
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param data
	 *            具体表项(目标)(数据类)
	 * @param theFieldTitle
	 *            表项名(目标)
	 * @param tableName
	 *            表名
	 */
	public void update(String title, String fieldTitle, byte[] data,
			String theFieldTitle, String tableName) {
		final SQLiteDatabase db = this.getWritableDatabase();
		final String where = fieldTitle + sqlInfo;
		final String[] whereValue = { title };
		final ContentValues cv = new ContentValues();
		cv.put(theFieldTitle, data);
		db.update(tableName, cv, where, whereValue);
	}

}
