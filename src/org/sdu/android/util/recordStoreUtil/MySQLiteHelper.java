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
 * ���࣬���ڷ�װһ��SQLiteOpenHelper������Ϊ���ݿ����Ļ�����Ӧ����ĸ���
 * 
 * @author yes_coffee
 * 
 */
public abstract class MySQLiteHelper extends SQLiteOpenHelper {
	/*
	 * onCreate������onUpgrade�����Ĳο� private static class DatabaseHelper extends
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
	 * ���ݿ�ʵ��
	 */
	private SQLiteDatabase db = this.getWritableDatabase();;

	/**
	 * ������ʵ��
	 */
	private Context ctx = SystemData.getCurrentActivity();

	/**
	 * ָ�빤��
	 */
	private CursorFactory factory = null;

	/**
	 * �汾��
	 */
	private int version = 1;

	/**
	 * ��Ϣ��־
	 */
	final String tag = "SQLite Conmand";

	/**
	 * SQL�����Ұ벿��
	 */
	final String sqlInfo = "=?";

	/**
	 * ���췽��
	 * 
	 * @param context
	 *            ������
	 * @param name
	 *            ���ݿ���
	 * @param factory
	 *            ָ�빤��
	 * @param version
	 *            �汾��
	 */
	public MySQLiteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	/**
	 * ���췽��
	 * 
	 * @param context
	 *            ������
	 * @param name
	 *            �ļ���
	 */
	public MySQLiteHelper(Context context, String name) {
		super(context, name, null, 1);
	}

	/**
	 * ��ʼ������
	 */
	public void init() {
		db = null;
		ctx = null;
		factory = null;
		version = 1;
	}

	/**
	 * ȡ�����ݿ�
	 * 
	 * @return �������ݿ�
	 */
	public SQLiteDatabase getDb() {
		return db;
	}

	/**
	 * �������ݿ�
	 * 
	 * @param db
	 *            ���ݿ�
	 */
	public void setDb(SQLiteDatabase db) {
		this.db = db;
	}

	/**
	 * ȡ��������
	 * 
	 * @return ����������
	 */
	public Context getCtx() {
		return ctx;
	}

	/**
	 * ����������
	 * 
	 * @param ctx
	 *            ������
	 */
	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	/**
	 * ȡ��ָ�빤��
	 * 
	 * @return ����ָ�빤��
	 */
	public CursorFactory getFactory() {
		return factory;
	}

	/**
	 * ����ָ�빤��
	 * 
	 * @param factory
	 *            ָ�빤��
	 */
	public void setFactory(CursorFactory factory) {
		this.factory = factory;
	}

	/**
	 * ȡ�ð汾��
	 * 
	 * @return ���ذ汾��
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * ���ð汾��
	 * 
	 * @param version
	 *            �汾��
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * �ж����ݿ��Ƿ����
	 * 
	 * @param dbName
	 *            ���ݿ�����
	 * @return true���� false������
	 */
	public abstract boolean exist(String dbName);

	/**
	 * �����ݿ�
	 * 
	 * @param dbName
	 *            ���ݿ�����
	 * @param created
	 *            �Ƿ��ڲ������Ǵ���
	 * @return true �򿪳ɹ� false��ʧ��
	 */
	public SQLiteDatabase openDatabase(String dbName, boolean created) {
		return openDatabase(dbName, null, created);
	}

	/**
	 * �����ݿ�
	 * 
	 * @param dbName ���ݿ�����
	 * @param factory
	 *            ָ�빤��
	 * @param created
	 *            �Ƿ��ڲ������Ǵ���
	 * @return ���ݿ�
	 */
	public abstract SQLiteDatabase openDatabase(String dbName,
			CursorFactory factory, boolean created);

	/**
	 * �������ݿ�
	 * @param dbName
	 *            ���ݿ�����
	 * @param version
	 *            ���ݿ�汾
	 * @param factory
	 *            ָ�빤��
	 * @return true �����ɹ� false ����ʧ��
	 */
	public abstract boolean createDatabase(String dbName, int version,
			CursorFactory factory);

	/**
	 * �������ݿ�
	 * 
	 * @param dbName
	 *            ���ݿ�����
	 * @return true �򿪳ɹ� false ��ʧ��
	 */
	public boolean createDatabase(String dbName) {
		return createDatabase(dbName, version, factory);
	}

	/**
	 * �ر����ݿ�
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
	 * ִ��SQL���
	 * 
	 * @param sql
	 *            Ҫִ�е�SQL���
	 * @return true�ɹ� falseʧ��
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
	 * ɾ����
	 * 
	 * @param tableName
	 *            ����
	 * @return �ɹ��򷵻� ���� ʧ���򷵻�null
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
	 * ��ѯ���б���
	 * 
	 * @param tableName
	 *            ����
	 * @return ָ��
	 */
	public Cursor select(String tableName) {
		final SQLiteDatabase db = this.getReadableDatabase();
		final Cursor cursor = db.query(tableName, null, null, null, null, null,
				null);
		return cursor;
	}

	/**
	 * �������
	 * 
	 * @param title
	 *            �������
	 * @param fieldTitle
	 *            ������
	 * @param tableName
	 *            ����
	 * @return ��ֵ
	 */
	public long insert(String title, String fieldTitle, String tableName) {
	//	final SQLiteDatabase db = this.getWritableDatabase();
		final ContentValues cv = new ContentValues();
		cv.put(fieldTitle, title);
		final long row = db.insert(tableName, null, cv);
		return row;
	}

	/**
	 * �������
	 * 
	 * @param bytes
	 *            �������
	 * @param fieldTitle
	 *            ������
	 * @param tableName
	 *            ����
	 * @return ��ֵ
	 */
	public long insert(byte[] bytes, String fieldTitle, String tableName) {
		final SQLiteDatabase db = this.getWritableDatabase();
		final ContentValues cv = new ContentValues();
		cv.put(fieldTitle, bytes);
		final long row = db.insert(tableName, null, cv);
		return row;
	}

	/**
	 * ɾ������
	 * 
	 * @param title
	 *            �������
	 * @param fieldTitle
	 *            ������
	 * @param tableName
	 *            ����
	 */
	public void delete(String title, String fieldTitle, String tableName) {
		final SQLiteDatabase db = this.getWritableDatabase();
		final String where = fieldTitle + sqlInfo;
		final String[] whereValue = { title };
		db.delete(tableName, where, whereValue);
	}

	/**
	 * ���±���(String)
	 * 
	 * @param title
	 *            �������(����)
	 * @param fieldTitle
	 *            ������(����)
	 * @param theTitle
	 *            �������(Ŀ��)(������)
	 * @param theFieldTitle
	 *            ������(Ŀ��)
	 * @param tableName
	 *            ����
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
	 * ���±���(int)
	 * 
	 * @param title
	 *            �������(����)
	 * @param fieldTitle
	 *            ������(����)
	 * @param theNum
	 *            �������(Ŀ��)(������)
	 * @param theFieldTitle
	 *            ������(Ŀ��)
	 * @param tableName
	 *            ����
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
	 * ���±���(data)
	 * 
	 * @param title
	 *            �������(����)
	 * @param fieldTitle
	 *            ������(����)
	 * @param data
	 *            �������(Ŀ��)(������)
	 * @param theFieldTitle
	 *            ������(Ŀ��)
	 * @param tableName
	 *            ����
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
