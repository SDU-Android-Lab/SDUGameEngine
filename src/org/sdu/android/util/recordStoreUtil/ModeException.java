package org.sdu.android.util.recordStoreUtil;

/**
 * ģʽ������
 * 
 * @author yes_coffee
 *
 */
public class ModeException extends Exception{

	/**
	 * ���л�
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���캯������������
	 * 
	 * @param message ������Ϣ
	 */
	public ModeException(String message) {
		super(message);
	}

	/**
	 * ���캯��
	 * 
	 */
	public ModeException() {
		super();
	}
}
