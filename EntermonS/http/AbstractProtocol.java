// Ϊ���Э��ĸ��汾�ļ����ԣ�������ṩ��Э�������/
package http;

public abstract class AbstractProtocol implements Protocol {
	// ��ǰЭ��İ汾��
	protected String version;
	// �ɵ�Э��
	protected Protocol oldProtocol;

	abstract public Request generateRequest(String message);

	abstract public Method handleRequest(Request request);

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	public Protocol getOldProtocol() {
		return oldProtocol;
	}
	public void setOldProtocol(Protocol oldProtocol) {
		this.oldProtocol = oldProtocol;
	}
}
