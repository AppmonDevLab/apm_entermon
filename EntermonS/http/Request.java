// �����û�������
package http;

public abstract class Request {
	// ����Ҫִ�еķ���������
	String methodName;
	// ִ�з���ʱ����Ҫ����Դλ��
	String uri;
	// ִ�з���ʱ��Ҫ����������
	Fields fields;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}
}