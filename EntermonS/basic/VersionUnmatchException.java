package basic;

import http.HttpException;

/**
 * �ͻ��������HTTP����İ汾�뵱ǰʵ�ֵİ汾��ƥ��
 */
public class VersionUnmatchException extends HttpException {

	public VersionUnmatchException(String msg) {
		super(msg);
	}

}
