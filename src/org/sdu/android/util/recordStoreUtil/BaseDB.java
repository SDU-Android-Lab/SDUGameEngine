package org.sdu.android.util.recordStoreUtil;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * 基表，用于管理应用数据库，作为元数据库使用
 * 
 * @author yes_coffee
 * 
 */
public class BaseDB extends MySQLiteHelper {

	/**
	 * 模式FIELD_NEXTID代号
	 */
	final static int MODE_FIELD_NEXTID = 1;

	/**
	 * 模式FIELD_NUMBER_OF_RES代号
	 */
	final static int MODE_FIELD_NUMBER_OF_RES = 2;

	/**
	 * 模式FIELD_SIZE代号
	 */
	final static int MODE_FIELD_SIZE = 3;

	/**
	 * 系统数据库名称
	 */
	private final static String DATABASE_NAME = "android_db";

	/**
	 * 系统数据库名称版本号
	 */
	private final static int DATABASE_VERSION = 1;

	/**
	 * 系统数据库表名
	 */
	private final static String TABLE_NAME = "android_db_res";

	/**
	 * 系统数据库表索引
	 */
	private final static String FIELD_ID = "_id";

	/**
	 * 系统数据库表项名(表示类别要求唯一)
	 */
	private final static String FIELD_TITLE = "res_Title";

	/**
	 * 系统数据库表下一数据位置
	 */
	private final static String FIELD_NEXTID = "nextId";

	/**
	 * 系统数据库表某项其资源数
	 */
	private final static String FIELD_NUMBER_OF_RES = "number_of_res";

	/**
	 * 系统数据库表当前容量
	 */
	private final static String FIELD_SIZE = "current_size";

//	/**
//	 * ResTable实例，用于删除时清空Res表中项
//	 */
//	private final ResTable myTable = new ResTable();

	/**
	 * 系统数据库表创建语句
	 */
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ " (" + FIELD_ID + " integer primary key autoincrement, "
			+ FIELD_TITLE + " text not null, " + FIELD_NEXTID
			+ " int default 1, " + FIELD_NUMBER_OF_RES + " int default 0, "
			+ FIELD_SIZE + " int default 0);";

	/**
	 * 为实现单件模式而写的实例
	 */
	private static BaseDB instance = null;

	/**
	 * 构造方法
	 * 
	 * @param context
	 *            上下文
	 */
	private BaseDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * 单件模式
	 * 
	 * @param context
	 *            上下文
	 * @return BaseDB实例
	 */
	public static synchronized BaseDB getInstance(Context context) {
		if (instance == null) {
			instance = new BaseDB(context);
		}
		return instance;
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return DATABASE_NAME;
	}

	/**
	 * @return the databaseVersion
	 */
	public int getDatabaseVersion() {
		return DATABASE_VERSION;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return TABLE_NAME;
	}

	/**
	 * @return the fieldId
	 */
	public String getFieldId() {
		return FIELD_ID;
	}

	/**
	 * @return the fieldTitle
	 */
	public String getFieldTitle() {
		return FIELD_TITLE;
	}

	/**
	 * @return the fieldNextid
	 */
	public String getFieldNextid() {
		return FIELD_NEXTID;
	}

	/**
	 * @return the fieldNumberOfRes
	 */
	public String getFieldNumberOfRes() {
		return FIELD_NUMBER_OF_RES;
	}

	/**
	 * @return the fieldSize
	 */
	public String getFieldSize() {
		return FIELD_SIZE;
	}

	/**
	 * 创建数据库
	 * 
	 * @param dbName
	 *            数据库名称
	 * @param version
	 *            数据库版本
	 * @param factory
	 *            指针工厂
	 * @return true 建立成功 false 建立失败
	 */
	@Override
	public boolean createDatabase(String dbName, int version,
			CursorFactory factory) {
		if (exist(dbName)) {
			return false;// 已存在无需创建
		} else {
			final BaseDB dbheler = getInstance(getCtx());
			final SQLiteDatabase db = dbheler.getWritableDatabase();
			db.execSQL(DATABASE_CREATE);
			return exist(dbName);
		}
	}

	/**
	 * 查看数据库是否存在
	 * 
	 * @param dbName
	 *            数据库名称（路径）
	 * @return true 存在 false 不存在
	 */
	@Override
	public boolean exist(String dbName) {
		boolean flag = false;
		SQLiteDatabase db = null;
		try {
			db = SQLiteDatabase.openDatabase(dbName, null,
					SQLiteDatabase.OPEN_READONLY);
			if (db != null) {
				flag = true;
			}
		} catch (SQLException e) {
			flag = false;
		} finally {
			if (db != null) {
				db.close();
			}
		}
		return flag;
	}

	/**
	 * 打开数据库
	 * 
	 * @param dbName
	 *            数据库名称
	 * @param factory
	 *            指针工厂
	 * @param created
	 *            是否在不存在是创建
	 * @return 数据库
	 */
	@Override
	public SQLiteDatabase openDatabase(String dbName, CursorFactory factory,
			boolean created) {
		SQLiteDatabase db = null;
		if (exist(dbName)) {
			db = SQLiteDatabase.openDatabase(dbName, null,
					SQLiteDatabase.OPEN_READWRITE);
		} else {
			if (created) {
				createDatabase(dbName, 1, factory);
				db = SQLiteDatabase.openDatabase(dbName, null,
						SQLiteDatabase.OPEN_READWRITE);
			} else {
				return null;
			}
		}
		return db;
	}

	/**
	 * 创建数据库
	 * 
	 * @param db
	 *            数据库
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	/**
	 * 更新数据库
	 * 
	 * @param db
	 *            数据库
	 * @param oldVersion
	 *            旧版本号
	 * @param newVersion
	 *            新版本号
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	/**
	 * 删除表项
	 * 
	 * @param title
	 *            具体表项
	 */
	public void delete(String title) {
//		try {
//			myTable.delete(title, ResTable.MODE_FIELD_RES_ANDROID_DB_TITLE);
//		} catch (ModeException e) {
//			e.printStackTrace();
//		}
		this.delete(title, FIELD_TITLE, TABLE_NAME);
	}

	/**
	 * 插入表项
	 * 
	 * @param title
	 *            具体表项
	 * @return 行值
	 */
	public long insert(String title) {
		final long rowNum = this.insert(title, FIELD_TITLE, TABLE_NAME);
		try {
			this.update(title, (int) rowNum, MODE_FIELD_NEXTID);
		} catch (ModeException e) {
			e.printStackTrace();
		}
		return rowNum;
	}

	/**
	 * 更新表项
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param num
	 *            具体表项(目标)
	 * @param mode
	 *            模式:1-FIELD_NEXTID 2-FIELD_NUMBER_OF_RES 3-FIELD_SIZE
	 * @throws ModeException
	 *             模式错误
	 */
	public void update(String title, int num, int mode) throws ModeException {
		if (mode == MODE_FIELD_NEXTID) {
			this.update(title, FIELD_TITLE, num, FIELD_NEXTID, TABLE_NAME);
		} else if (mode == MODE_FIELD_NUMBER_OF_RES) {
			this.update(title, FIELD_TITLE, num, FIELD_NUMBER_OF_RES,
					TABLE_NAME);
		} else if (mode == MODE_FIELD_SIZE) {
			this.update(title, FIELD_TITLE, num, FIELD_SIZE, TABLE_NAME);
		} else {
			throw new ModeException("The Mode Error");
		}

	}

	/**
	 * 更新FIELD_TITLE
	 * 
	 * @param title
	 *            具体表项(条件)
	 * @param theTitle
	 *            具体表项(目标)
	 */
	public void update(String title, String theTitle) {
		this.update(title, FIELD_TITLE, theTitle, FIELD_TITLE, TABLE_NAME);
	}

	/**
	 * 查询所有表项
	 * 
	 * @return Cursor 指针，由指针可以操控结果集
	 */
	public Cursor queryAll() {
		final Cursor aCursor = this.select(TABLE_NAME);
		return aCursor;
	}

	/**
	 * 查询特定项(文字类)BaseDB
	 * 
	 * @param title
	 *            具体表项（条件）
	 * 
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param theFieldTitle
	 *            表项名(目标)
	 * @param tableName
	 *            表名
	 * @return 文字项集
	 */
	public String[] queryString(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		final SQLiteDatabase db = this.getReadableDatabase();
		final Cursor aCursor = db.query(tableName,
				new String[] { theFieldTitle }, fieldTitle + sqlInfo,
				new String[] { title }, null, null, null);
		String[] result;
		try {
			final int num = aCursor.getCount();
			if (num == 0) {
				return null;
			}
			aCursor.moveToFirst();
			result = new String[num];
			for (int i = 0; i < num; i++) {
				result[i] = aCursor.getString(0);
				aCursor.moveToNext();
			}
		} finally {
			aCursor.close();
		}
		return result;
	}

	/**
	 * 查询特定项(数字类)
	 * 
	 * @param title
	 *            数字类具体表项（条件）
	 * @param fieldTitle
	 *            表项名(条件)
	 * @param aimFieldTitle
	 *            表项名(目标)
	 * @param tableName
	 *            表名
	 * @return 文字项集
	 */
	public int[] queryInt(String title, String fieldTitle,
			String aimFieldTitle, String tableName) {
		final SQLiteDatabase db = this.getReadableDatabase();
		final Cursor aCursor = db.query(tableName,
				new String[] { aimFieldTitle }, fieldTitle + sqlInfo,
				new String[] { title }, null, null, null);
		int[] result;
		try {
			final int num = aCursor.getCount();
			if (num == 0) {
				return null;
			}
			aCursor.moveToFirst();
			result = new int[num];
			for (int i = 0; i < num; i++) {
				result[i] = aCursor.getInt(0);
				aCursor.moveToNext();
			}
		} finally {
			aCursor.close();
		}
		return result;
	}

	/**
	 * 查询特定项(数据类)
	 * 
	 * @param title
	 *            数据类具体表项（条件）
	 * @param fieldTitle
	 *            数据类表项名(条件)
	 * @param theFieldTitle
	 *            数据类表项名(目标)
	 * @param tableName
	 *            数据类表名
	 * @return 文字项集
	 */
	public byte[][] queryDate(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		final SQLiteDatabase db = this.getReadableDatabase();
		final Cursor aCursor = db.query(tableName,
				new String[] { theFieldTitle }, fieldTitle + sqlInfo,
				new String[] { title }, null, null, null);
		byte[][] result;
		try {
			final int num = aCursor.getCount();
			if (num == 0) {
				return null;
			}
			aCursor.moveToFirst();
			result = new byte[num][];
			for (int i = 0; i < num; i++) {
				result[i] = aCursor.getBlob(0);
				aCursor.moveToNext();
			}
		} finally {
			aCursor.close();
		}
		return result;
	}

	/**
	 * 查看是否存在表项
	 * 
	 * @param title
	 *            表名
	 * @return true 存在 false 不存在
	 */
	public boolean existTitle(String title) {
		boolean flag = false;
		final SQLiteDatabase db = this.getReadableDatabase();
		final String sqlString = "SELECT " + FIELD_TITLE + " FROM "
				+ TABLE_NAME + " WHERE " + FIELD_TITLE + "='?'; ";
		sqlString.replace("?", title);
		final Cursor aCursor = db.rawQuery(sqlString, null);
		final int acount = aCursor.getCount();
		if (acount == 1) {
			flag = true;
		}
		aCursor.close();
		return flag;
	}
}
