package basic;

import http.ConstantValues;
import http.Method;
import http.Request;
import http.Response;
import rfc.FullResponse;

/**
 * ����ṩ��Ԥ���巽�� ��Э�鷢��һ�����󵫲�����Ӧ�Ĵ�����ʵ��ʱ�� ���Է��ظ÷�������ά����ܵ�һ�¡�
 */
public class DefaultMethod extends Method {

	@Override
	public Response execute(Request request) {
		Response response = new FullResponse();
		String status = "HTTP/1.0 "// ����״̬��
				+ ConstantValues.StatusCode.NOT_IMPLEMENTED.getCode()
				+ " "
				+ ConstantValues.StatusCode.NOT_IMPLEMENTED
				+ ConstantValues.CRLF;
		response.addHeader(status);
		response.addHeader(ConstantValues.CRLF);
		return response;
	}

}
