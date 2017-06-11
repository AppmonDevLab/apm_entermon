package basic;

import http.ConstantValues;
import http.Method;
import http.Request;
import http.Response;
import rfc.FullResponse;

/**
 * �Բ��Ϸ���������д���ķ���
 */
public class BadRequestHandlerMethod extends Method {

	@Override
	public Response execute(Request request) {
		Response response = new FullResponse();
		String status = "HTTP/1.0 "// ����״̬��
				+ ConstantValues.StatusCode.BAD_REQUEST.getCode()
				+ " "
				+ ConstantValues.StatusCode.BAD_REQUEST + ConstantValues.CRLF;
		response.addHeader(status);
		// response.addHeader(ConstantValues.CRLF);
		return response;
	}

}
