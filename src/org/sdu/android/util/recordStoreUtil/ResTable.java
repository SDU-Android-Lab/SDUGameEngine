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
	 * ���ϵͳ���ݿ�
	 */
	BaseDB myDB = BaseDB.getInstance(SystemData.getCurrentActivity());

	/**
	 * ��Դ����
	 */
	private final static String TABLE_NAME_RES = "android_res";

	/**
	 * ��Դ��ID
	 */
	private final static String FIELD_RES_ID = "res_id";

	/**
	 * ��Դ����Դ��
	 */
	private final static String FIELD_RES_NAME = "res_name";

	/**
	 * ��Դ���Ӧϵͳ�������
	 */
	private final static String FIELD_RES_ANDROID_DB_TITLE = "android_db_title";

	/**
	 * ��Դ����Դ����
	 */
	private final static String FIELD_RES_NUMBER = "res_number";

	/**
	 * ��Դ����Դ����
	 */
	private final static String FIELD_RES_DATA = "bytes";

	/**
	 * Log����־
	 */
	private final static String TAG = "ResTableCommand";

	/**
	 * �ʺ�����־
	 */
	private final static String TAG_WENHAO = "?";

	/**
	 * SQL��ѯ������β��־
	 */
	private final static String SQLINFO = "='?'; ";

	/**
	 * ģʽFIELD_RES_NAME����
	 */
	final static int MODE_FIELD_RES_NAME = 1;

	/**
	 * ģʽFIELD_RES_ANDROID_DB_TITLE����
	 */
	final static int MODE_FIELD_RES_ANDROID_DB_TITLE = 2;

	/**
	 * ϵͳ���ݿ�������
	 */
	private static final String RES_TABLE_CREATE = "create table "
			+ TABLE_NAME_RES + " (" + FIELD_RES_ID
			+ " integer primary key autoincrement, " + FIELD_RES_NAME
			+ " text not null, " + FIELD_RES_ANDROID_DB_TITLE
			+ " int not null, " + FIELD_RES_NUMBER + " int default 1, "
			+ FIELD_RES_DATA + " BLOB); ";

	/**
	 * ���캯��
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
	 * �鿴�Ƿ���ڱ�
	 * 
	 * @param tableName
	 *            ����
	 * @return true ���� false ������
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
	 * �������
	 * 
	 * @param name
	 *            ��Դ��
	 * @param date
	 *            ����
	 * @param title
	 *            ���������
	 * @return ��ֵ
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
	 * ɾ������
	 * 
	 * @param title
	 *            �������(����)
	 * @param mode
	 *            ģʽ:1-FIELD_RES_NAME 2-FIELD_RES_ANDROID_DB_TITLE
	 * @throws ModeException
	 *             ģʽ����
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
	 * ���±���(������)
	 * @param title
	 *            �������(����)
	 * @param fieldTitle
	 *            ������(����)
	 * @param theTitle
	 *            �������(Ŀ��)
	 * @param mode
	 *            ģʽ:1-FIELD_RES_NAME 2-FIELD_RES_ANDROID_DB_TITLE
	 * @throws ModeException
	 *             ģʽ����
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
	 * ���±���(������)
	 * 
	 * @param title
	 *            �������(����)
	 * @param fieldTitle
	 *            ������(����)
	 * @param theNum
	 *            �������(Ŀ��)
	 */
	public void update(String title, String fieldTitle, int theNum) {
		myDB
				.update(title, fieldTitle, theNum, FIELD_RES_NUMBER,
						TABLE_NAME_RES);
	}

	/**
	 * ���±���(������)
	 * 
	 * @param title
	 *            �������(����)
	 * @param fieldTitle
	 *            ������(����)
	 * @param data
	 *            �������(Ŀ��)
	 */
	public void update(String title, String fieldTitle, byte[] data) {
		myDB.update(title, fieldTitle, data, FIELD_RES_NUMBER, TABLE_NAME_RES);
	}

	/**
	 * ��ѯ���б���
	 * 
	 * @return Cursor ָ�룬��ָ����Բٿؽ����
	 */
	public Cursor queryAll() {
		final Cursor aCursor = myDB.select(TABLE_NAME_RES);
		return aCursor;
	}

	/**
	 * ��ѯ�ض���(������) 
	 * @param title
	 *            ������������
	 * @param fieldTitle
	 *            ������(����)
	 * @param theFieldTitle ������(Ŀ��)           
	 * @param tableName
	 *            ����
	 * @return �����
	 */
	public String[] queryString(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		return myDB.queryString(title, fieldTitle, theFieldTitle, tableName);
	}

	/**
	 * ��ѯ�ض���(������)
	 * 
	 * @param title
	 *            �����������������
	 * @param fieldTitle
	 *            ������(����)
	 * @param theFieldTitle
	 *            ������(Ŀ��)
	 * @param tableName
	 *            ����
	 * @return �����
	 */
	public int[] queryInt(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		return myDB.queryInt(title, fieldTitle, theFieldTitle, tableName);
	}

	/**
	 * ��ѯ�ض���(������)
	 * 
	 * @param title
	 *            ������������
	 * @param fieldTitle
	 *            ������(����)
	 * @param theFieldTitle
	 *            ������(Ŀ��)
	 * @param tableName
	 *            ����
	 * @return �����
	 */
	public byte[][] queryDate(String title, String fieldTitle,
			String theFieldTitle, String tableName) {
		return myDB.queryDate(title, fieldTitle, theFieldTitle, tableName);
	}

}
