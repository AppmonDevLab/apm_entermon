package rfc;

import http.Request;

/**
 * HTTP1.0������ʵ�ֵ��������� HTTP1.0֮ǰ������GET URI HTTP1.0������GET URI HTTP_VERSION
 */
public class FullRequest extends Request {
	// ��������HTTP�İ汾
	String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
