package org.sdu.android.util.recordStoreUtil;

/**
 * 模式错误类
 * 
 * @author yes_coffee
 *
 */
public class ModeException extends Exception{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 构造函数（含参数）
	 * 
	 * @param message 错误消息
	 */
	public ModeException(String message) {
		super(message);
	}

	/**
	 * 构造函数
	 * 
	 */
	public ModeException() {
		super();
	}
}
