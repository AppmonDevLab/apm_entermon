package http;

import java.io.InputStream;

public abstract class Response {
	// �����ͷ��
	StringBuffer header = new StringBuffer();
	// WEB��������򻯳���������ʽ�����
	InputStream input;
	// Ϊͷ�����һ��
	public void addHeader(String line) {
		header.append(line);
	}
	public StringBuffer getHeader() {
		return header;
	}

	public void setHeader(StringBuffer header) {
		this.header = header;
	}
	public InputStream getInput() {
		return input;
	}
	public void setInput(InputStream input) {
		this.input = input;
	}
}