package org.sdu.android.util.recordStoreUtil;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * �������ڹ���Ӧ�����ݿ⣬��ΪԪ���ݿ�ʹ��
 * 
 * @author yes_coffee
 * 
 */
public class BaseDB extends MySQLiteHelper {

	/**
	 * ģʽFIELD_NEXTID����
	 */
	final static int MODE_FIELD_NEXTID = 1;

	/**
	 * ģʽFIELD_NUMBER_OF_RES����
	 */
	final static int MODE_FIELD_NUMBER_OF_RES = 2;

	/**
	 * ģʽFIELD_SIZE����
	 */
	final static int MODE_FIELD_SIZE = 3;

	/**
	 * ϵͳ���ݿ�����
	 */
	private final static String DATABASE_NAME = "android_db";

	/**
	 * ϵͳ���ݿ����ư汾��
	 */
	private final static int DATABASE_VERSION = 1;

	/**
	 * ϵͳ���ݿ����
	 */
	private final static String TABLE_NAME = "android_db_res";

	/**
	 * ϵͳ���ݿ������
	 */
	private final static String FIELD_ID = "_id";

	/**
	 * ϵͳ���ݿ������(��ʾ���Ҫ��Ψһ)
	 */
	private final static String FIELD_TITLE = "res_Title";

	/**
	 * ϵͳ���ݿ����һ����λ��
	 */
	private final static String FIELD_NEXTID = "nextId";

	/**
	 * ϵͳ���ݿ��ĳ������Դ��
	 */
	private final static String FIELD_NUMBER_OF_RES = "number_of_res";

	/**
	 * ϵͳ���ݿ��ǰ����
	 */
	private final static String FIELD_SIZE = "current_size";

//	/**
//	 * ResTableʵ��������ɾ��ʱ���Res������
//	 */
//	private final ResTable myTable = new ResTable();

	/**
	 * ϵͳ���ݿ�������
	 */
	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ " (" + FIELD_ID + " integer primary key autoincrement, "
			+ FIELD_TITLE + " text not null, " + FIELD_NEXTID
			+ " int default 1, " + FIELD_NUMBER_OF_RES + " int default 0, "
			+ FIELD_SIZE + " int default 0);";

	/**
	 * Ϊʵ�ֵ���ģʽ��д��ʵ��
	 */
	private static BaseDB instance = null;

	/**
	 * ���췽��
	 * 
	 * @param context
	 *            ������
	 */
	private BaseDB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/**
	 * ����ģʽ
	 * 
	 * @param context
	 *            ������
	 * @return BaseDBʵ��
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
	 * �������ݿ�
	 * 
	 * @param dbName
	 *            ���ݿ�����
	 * @param version
	 *            ���ݿ�汾
	 * @param factory
	 *            ָ�빤��
	 * @return true �����ɹ� false ����ʧ��
	 */
	@Override
	public boolean createDatabase(String dbName, int version,
			CursorFactory factory) {
		if (exist(dbName)) {
			return false;// �Ѵ������贴��
		} else {
			final BaseDB dbheler = getInstance(getCtx());
			final SQLiteDatabase db = dbheler.getWritableDatabase();
			db.execSQL(DATABASE_CREATE);
			return exist(dbName);
		}
	}

	/**
	 * �鿴���ݿ��Ƿ����
	 * 
	 * @param dbName
	 *            ���ݿ����ƣ�·����
	 * @return true ���� false ������
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
	 * �����ݿ�
	 * 
	 * @param dbName
	 *            ���ݿ�����
	 * @param factory
	 *            ָ�빤��
	 * @param created
	 *            �Ƿ��ڲ������Ǵ���
	 * @return ���ݿ�
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
	 * �������ݿ�
	 * 
	 * @param db
	 *            ���ݿ�
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	/**
	 * �������ݿ�
	 * 
	 * @param db
	 *            ���ݿ�
	 * @param oldVersion
	 *            �ɰ汾��
	 * @param newVersion
	 *            �°汾��
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	/**
	 * ɾ������
	 * 
	 * @param title
	 *            �������
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
	 * �������
	 * 
	 * @param title
	 *            �������
	 * @return ��ֵ
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
	 * ���±���
	 * 
	 * @param title
	 *            �������(����)
	 * @param num
	 *            �������(Ŀ��)
	 * @param mode
	 *            ģʽ:1-FIELD_NEXTID 2-FIELD_NUMBER_OF_RES 3-FIELD_SIZE
	 * @throws ModeException
	 *             ģʽ����
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
	 * ����FIELD_TITLE
	 * 
	 * @param title
	 *            �������(����)
	 * @param theTitle
	 *            �������(Ŀ��)
	 */
	public void update(String title, String theTitle) {
		this.update(title, FIELD_TITLE, theTitle, FIELD_TITLE, TABLE_NAME);
	}

	/**
	 * ��ѯ���б���
	 * 
	 * @return Cursor ָ�룬��ָ����Բٿؽ����
	 */
	public Cursor queryAll() {
		final Cursor aCursor = this.select(TABLE_NAME);
		return aCursor;
	}

	/**
	 * ��ѯ�ض���(������)BaseDB
	 * 
	 * @param title
	 *            ������������
	 * 
	 * @param fieldTitle
	 *            ������(����)
	 * @param theFieldTitle
	 *            ������(Ŀ��)
	 * @param tableName
	 *            ����
	 * @return �����
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
	 * ��ѯ�ض���(������)
	 * 
	 * @param title
	 *            �����������������
	 * @param fieldTitle
	 *            ������(����)
	 * @param aimFieldTitle
	 *            ������(Ŀ��)
	 * @param tableName
	 *            ����
	 * @return �����
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
	 * ��ѯ�ض���(������)
	 * 
	 * @param title
	 *            �����������������
	 * @param fieldTitle
	 *            �����������(����)
	 * @param theFieldTitle
	 *            �����������(Ŀ��)
	 * @param tableName
	 *            ���������
	 * @return �����
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
	 * �鿴�Ƿ���ڱ���
	 * 
	 * @param title
	 *            ����
	 * @return true ���� false ������
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
