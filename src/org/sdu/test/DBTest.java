package org.sdu.test;

import org.sdu.android.util.recordStoreUtil.BaseDB;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * ���ݿ������
 * 
 * @author ls
 * 
 */
public class DBTest extends Activity {
	/** BaseDB���� */
	private BaseDB db;
	/** cursor���� */
	private Cursor mCursor;
	/** ListView���� */
	private ListView list;
	/** add menu */
	protected final static int MENU_INSERT = Menu.FIRST;
	/** delete menu */
	protected final static int MENU_DELETE = Menu.FIRST + 1;
	/** update menu */
	protected final static int MENU_UPDATE = Menu.FIRST + 2;
	/** createTB menu */
	protected final static int MENU_CREATETB = MENU_DELETE + 2;
	/** ������String */
	private String test = "test";
	/** ������String */
	private String title = "title1";
	/** ������String */
	private final static String MY_TABLE = "myTable";
	/** ������String */
	private final static String MY_ID = "id";
	/** ������String */
	private final static String MY_NAME = "name";
	/**
	 * �Զ���������
	 */
	private static final String CREATEDB = "create table " + MY_TABLE
			+ "("+ MY_NAME+" text not null);";

	/**
	 * ��ں���
	 * 
	 * @param savedInstanceState
	 *            Bundle
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbtest);

		db = BaseDB.getInstance(this);

		list = (ListView) findViewById(R.id.list);
//		mCursor = db.queryAll();
//		list.setAdapter(new MyListAdapter(this, mCursor));

	}

	/**
	 * ���menu
	 * 
	 * @param menu
	 *            Menu
	 * @return boolean
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, MENU_INSERT, 0, "insert");
		menu.add(Menu.NONE, MENU_DELETE, 0, "delete");
		menu.add(Menu.NONE, MENU_UPDATE, 0, "update");
		menu.add(Menu.NONE, MENU_CREATETB, 0, "createTB");
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * menu����Ӧ����
	 * 
	 * @param featureId
	 *            int
	 * @param item
	 *            MenuItem
	 * @return boolean
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case MENU_INSERT:
			db.insert("first");
			break;
		case MENU_DELETE:
			db.delete(test);
			break;
		case MENU_UPDATE:
			db.update(title, test);
			break;
		case MENU_CREATETB:
			/**�½���*/
//			if (db.execSQL(CREATEDB)) {
//				Toast.makeText(this, "�Զ����ɹ�", Toast.LENGTH_SHORT).show();
//			} else {
//				Toast.makeText(this, "�Զ���ʧ��", Toast.LENGTH_SHORT).show();
//			}
			/**ɾ����*/
//			db.dropTable(MY_TABLE);
			/**��������*/
//          db.insert("second",MY_NAME, MY_TABLE);
			/**��ѯ����*/
//		     mCursor = db.select(MY_TABLE);
//    		 list.setAdapter(new MyListAdapter(DBTest.this, mCursor));
//			 mCursor = db.queryAll();
//			 list.setAdapter(new MyListAdapter(DBTest.this, mCursor));
			 break;
		}
		
		return super.onMenuItemSelected(featureId, item);
	}

	/**
	 * �̳���BaseAdapter���ڲ���
	 * 
	 * @author asus
	 * 
	 */
	public class MyListAdapter extends BaseAdapter {
		/** ������ */
		private Context mContext;
		/** cursor���� */
		private Cursor myCursor;

		/**
		 * ���췽��
		 * 
		 * @param context
		 *            Context
		 * @param cursor
		 *            Cursor
		 */
		public MyListAdapter(Context context, Cursor cursor) {

			mContext = context;
			myCursor = cursor;
		}

		/**
		 * ʵ��BaseAdapter�ĳ��󷽷�
		 * 
		 * @return int
		 */
		@Override
		public int getCount() {
			return myCursor.getCount();
		}

		/**
		 * ʵ��BaseAdapter�ĳ��󷽷�
		 * 
		 * @param position
		 *            int
		 * @return Object
		 */
		@Override
		public Object getItem(int position) {
			return null;
		}

		/**
		 * ʵ��BaseAdapter�ĳ��󷽷�
		 * 
		 * @param position
		 *            int
		 * @return long
		 */
		@Override
		public long getItemId(int position) {
			return 0;
		}

		/**
		 * ʵ��BaseAdapter�ĳ��󷽷�
		 * 
		 * @param position
		 *            int
		 * @param convertView
		 *            View
		 * @param parent
		 *            ViewGroup
		 * @return View
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final TextView mTextView = new TextView(mContext);
			myCursor.moveToPosition(position);
			mTextView.setText(myCursor.getString(0));
			return mTextView;
		}
	}
}
