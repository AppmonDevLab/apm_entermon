// ���������н����HTTP�������
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
	public static void main(String args[]) {
		int port;
		ServerSocket listenSocket;

		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			port = 8000;
		}

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
					HTTPServerHelper helper = new HTTPServerHelper(
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