// ����GET����ķ���
package rfc;

import http.ConstantValues;
import http.Fields;
import http.Method;
import http.Request;
import http.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import util.FileTypeManager;

public class GetMethod extends Method {
	@Override
	public Response execute(Request request) {
		try {
			Response response = new FullResponse();
			Fields fields = request.getFields();
			String path = request.getUri();
			if (path == null) {// �����е�uriΪ�գ�BAD_REQUEST
				String status = "HTTP/1.0 "
						+ ConstantValues.StatusCode.BAD_REQUEST.getCode()
						+ ConstantValues.StatusCode.BAD_REQUEST
						+ ConstantValues.CRLF; // ״̬��
				response.addHeader(status);
				return response;
			}
			File file = new File(path);
			if (fields != null) {
				String modifiedSince = fields.getValue("If-Modified-Since");
				if (modifiedSince != null) {// ����GET
				}
			}
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				String status = "HTTP/1.0 "
						+ ConstantValues.StatusCode.OK.getCode() + " "
						+ ConstantValues.StatusCode.OK + ConstantValues.CRLF; // ״̬��
				String server = "Server:BenHuang's server "
						+ ConstantValues.CRLF; // ����������
				String contentType = "Content-type:"
						+ FileTypeManager.getType(file) + ConstantValues.CRLF; // �ļ�������Ϣ
				String contentLength = "Content-length:" + file.length()
						+ ConstantValues.CRLF;
				response.addHeader(status);
				response.addHeader(server);
				response.addHeader(contentType);
				response.addHeader(contentLength);
				response.setInput(fileInputStream);
				return response;
			} catch (FileNotFoundException e) {// �ļ�������
				response = new FullResponse();
				String status = "HTTP/1.0 "
						+ ConstantValues.StatusCode.NOT_FOUND.getCode() + " "
						+ ConstantValues.StatusCode.NOT_FOUND
						+ ConstantValues.CRLF; // ״̬��
				response.addHeader(status);
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Response response = new FullResponse();
			String status = "HTTP/1.0 "
					+ ConstantValues.StatusCode.INTERNAL_SERVER_ERROR.getCode()
					+ " " + ConstantValues.StatusCode.INTERNAL_SERVER_ERROR
					+ ConstantValues.CRLF; // ״̬��
			response.addHeader(status);
			return response;
		}
	}
}