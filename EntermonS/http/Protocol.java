// HTTPЭ���Ƕ�һ��������Ϣ���д���,���Ѵ�������Ϊ��Ӧ����
package http;

public interface Protocol {
	// ������Ϣ����������
	public Request generateRequest(String message);
	// �������󣬷��ش�������������
	public Method handleRequest(Request request);
}
