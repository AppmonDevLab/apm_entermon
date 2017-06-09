// ����RFC1945ʵ��GET�����HTTP1.0
package rfc;

import http.AbstractProtocol;
import http.ConstantValues;
import http.Fields;
import http.HttpException;
import http.Method;
import http.Request;

import java.net.URI;

import basic.BadRequest;
import basic.BadRequestHandlerMethod;
import basic.DefaultMethod;
import basic.SyntaxException;

public class HttpProtocol extends AbstractProtocol {
	String root = "e:\\www";
	public HttpProtocol() {
	}
	public HttpProtocol(String root) {
		this.root = root;
	}
	// ��������
	public Request generateRequest(String message) {
		try {
			return buildRequest(message);
		} catch (HttpException e) {
			if (getOldProtocol() != null) {// ��Ϣ�﷨���汾��ƥ�䣬����ʹ�þɵ�Э����н���
				return getOldProtocol().generateRequest(message);
			} else {
				return new BadRequest();
			}
		} catch (Exception e) {
			return new BadRequest();
		}
	}
	// ��������
	public Method handleRequest(Request request) {
		try {
			if (request instanceof BadRequest) {
				return new BadRequestHandlerMethod();
			}
			if (request.getMethodName().equals("GET")) {
				return new GetMethod();
			}
			if (getOldProtocol() != null) {
				return getOldProtocol().handleRequest(request);
			}
		} catch (Exception e) {
		}
		return new DefaultMethod();
	}
	// ������Ϣ��ʽ����������

	private Request buildRequest(String message) throws HttpException {
		FullRequest request = new FullRequest();
		String[] requestLine = analyseRequestLine(message);
		if (requestLine == null) {// �޷��������RequestLine�������þ�Э�����
			throw new SyntaxException("�޷�����RequestLine");
		}
		Fields fields = getFields(message);
		request.setMethodName(requestLine[0]);
		String temp = requestLine[1];// .replaceAll("/", "\\\\");
		String uri = null;
		uri = uriToAbsolutePath(temp);// ��URIת���������ַ
		request.setUri(uri);
		// if(!requestLine[2].equalsIgnoreCase("HTTP1.1")){//||!requestLine[2].equalsIgnoreCase("HTTP1.0")){
		// Ϊ�˼�����������Э��Ҳ֧��HTTP1.1����
		// throw new VersionUnmatchException("�汾������");
		// }

		request.setVersion(requestLine[2]);
		request.setFields(fields);
		return request;
	}
	/**
	 * ����Ϣ�л��RequestLine
	 * 
	 * @param msg
	 * @return
	 */
	private String[] analyseRequestLine(String msg) {
		String[] requstLine = new String[3];
		int firstCRLF = msg.indexOf(ConstantValues.CRLF);
		if (firstCRLF == -1)
			return null;
		String requestLine = msg.substring(0, firstCRLF);
		String[] parts = requestLine.split("\\s+");
		if (parts.length != 3)
			return null;
		requstLine[0] = (parts[0]);
		requstLine[1] = (parts[1]);
		requstLine[2] = (parts[2]);
		return requstLine;
	}
	// ����Ϣ�л��ͷ����
	public Fields getFields(String msg) {
		Fields fields = new HeaderFields();
		int firstCRLF = msg.indexOf(ConstantValues.CRLF);
		if (firstCRLF == -1)
			return null;
		String headerFields = msg.substring(firstCRLF, msg.length());
		String[] lines = headerFields.split(ConstantValues.CRLF);
		for (int i = 0; i < lines.length; i++) {
			String[] details = lines[i].split(":");
			if (details != null && details.length == 2)
				fields.addFieldValue(details[0], details[1]);
		}
		return fields;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}
	protected String uriToAbsolutePath(String string) {

		try {
			URI uri = URI.create(string);
			String path = uri.getPath();
			if (path == null)
				return null;
			char[] chars = path.toCharArray();
			boolean isFile = false;
			for (int i = chars.length - 1; i > 0; i--) {
				if (chars[i] == '.' && chars[i - 1] != '/') {
					isFile = true;
					break;
				}
			}
			if (!isFile) {
				if (path.endsWith("/")) {
					path = path + "index.html";
				} else {
					path = path + "/index.html";
				}
			}
			if (path.startsWith("/")) {
				path = root + path;
			} else {
				path = root + "/" + path;
			}
			return path.replaceAll("/", "\\\\");
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
