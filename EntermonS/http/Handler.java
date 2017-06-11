// ����HTTPͷ����HeaderField=FieldName:FieldValue
package http;

public abstract class Handler {
	// ��������������Э��
	protected Protocol protocol;

	public Handler(Protocol protocol) {
		setProtocol(protocol);
	}
	// ��������Ϣ���д���������Ӧ
	public Response handle(String message) {
		//������Ϣ��������
		Request request = protocol.generateRequest(message);
		//�������󷵻���Ӧ�Ĵ�����
		Method method = protocol.handleRequest(request);
		//ִ�з�����������������Ӧ��Ϊ�������������ظ���Ӧ
		return method.execute(request);
	}
	public Protocol getProtocol() {
		return protocol;
	}
	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

}
