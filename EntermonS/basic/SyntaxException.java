package basic;

import http.HttpException;

/**
 * �ͻ��˵�������Ϣ�﷨�����ʽ����
 */
public class SyntaxException extends HttpException {

	public SyntaxException(String msg) {
		super(msg);
	}
}
