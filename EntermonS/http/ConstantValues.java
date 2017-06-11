// HTTPЭ������ʹ�õ��ĳ���
package http;

public class ConstantValues {
	// �س�����
	public static final String CRLF = System.getProperty("line.separator");
	// ����������Ӧ״̬��
	public enum StatusCode {
		OK(200), BAD_REQUEST(400), NOT_FOUND(404), INTERNAL_SERVER_ERROR(500), NOT_IMPLEMENTED(
				501);
		private StatusCode(int code) {
			this.code = code;
		}
		private int code; // ״̬����

		public int getCode() {
			return code;
		}
		public static void main(String[] args) {
			System.out.print(StatusCode.BAD_REQUEST);
		}

	}
}
