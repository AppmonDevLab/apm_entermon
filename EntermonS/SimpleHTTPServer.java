// ���������н����HTTP�������
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHTTPServer {
	public static void main(String args[]) {
		int port;
		ServerSocket listenSocket;

		// ��ȡServer�˿ں�
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			port = 8000;
		}

		// ����Server�˿ڣ��ȴ�����������ʾ������Ϣ
		try {
			listenSocket = new ServerSocket(port);
			System.out.println("\nHttp����������ڶ˿�" + listenSocket.getLocalPort()
					+ "������");
			while (true) {
				System.out.println("�ȴ�����...");
				Socket socket = listenSocket.accept();
				System.out.println("\n �ͻ��ˣ�"
						+ socket.getInetAddress().toString() + " �ڶ˿ڣ�"
						+ socket.getPort() + "�����������Ѿ����ܣ�");
				try {
					SimpleHTTPServerHelper helper = new SimpleHTTPServerHelper(
							socket);
					helper.processRequest();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}