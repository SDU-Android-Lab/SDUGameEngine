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
 * 数据库测试类
 * 
 * @author ls
 * 
 */
public class DBTest extends Activity {
	/** BaseDB对象 */
	private BaseDB db;
	/** cursor对象 */
	private Cursor mCursor;
	/** ListView对象 */
	private ListView list;
	/** add menu */
	protected final static int MENU_INSERT = Menu.FIRST;
	/** delete menu */
	protected final static int MENU_DELETE = Menu.FIRST + 1;
	/** update menu */
	protected final static int MENU_UPDATE = Menu.FIRST + 2;
	/** createTB menu */
	protected final static int MENU_CREATETB = MENU_DELETE + 2;
	/** 测试用String */
	private String test = "test";
	/** 测试用String */
	private String title = "title1";
	/** 测试用String */
	private final static String MY_TABLE = "myTable";
	/** 测试用String */
	private final static String MY_ID = "id";
	/** 测试用String */
	private final static String MY_NAME = "name";
	/**
	 * 自定义表创建语句
	 */
	private static final String CREATEDB = "create table " + MY_TABLE
			+ "("+ MY_NAME+" text not null);";

	/**
	 * 入口函数
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
	 * 添加menu
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
	 * menu的响应函数
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
			/**新建表*/
//			if (db.execSQL(CREATEDB)) {
//				Toast.makeText(this, "自定义表成功", Toast.LENGTH_SHORT).show();
//			} else {
//				Toast.makeText(this, "自定义失败", Toast.LENGTH_SHORT).show();
//			}
			/**删除表*/
//			db.dropTable(MY_TABLE);
			/**插入数据*/
//          db.insert("second",MY_NAME, MY_TABLE);
			/**查询数据*/
//		     mCursor = db.select(MY_TABLE);
//    		 list.setAdapter(new MyListAdapter(DBTest.this, mCursor));
//			 mCursor = db.queryAll();
//			 list.setAdapter(new MyListAdapter(DBTest.this, mCursor));
			 break;
		}
		
		return super.onMenuItemSelected(featureId, item);
	}

	/**
	 * 继承于BaseAdapter的内部类
	 * 
	 * @author asus
	 * 
	 */
	public class MyListAdapter extends BaseAdapter {
		/** 上下文 */
		private Context mContext;
		/** cursor对象 */
		private Cursor myCursor;

		/**
		 * 构造方法
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
		 * 实现BaseAdapter的抽象方法
		 * 
		 * @return int
		 */
		@Override
		public int getCount() {
			return myCursor.getCount();
		}

		/**
		 * 实现BaseAdapter的抽象方法
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
		 * 实现BaseAdapter的抽象方法
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
		 * 实现BaseAdapter的抽象方法
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
