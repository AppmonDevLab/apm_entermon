import java.net.ServerSocket;

// ���߳�HTTP������
public class MultiThreadServer {
	public static void main(String[] args) {
		String webRoot = "c:\\www";// ��Ŀ¼
		int port = 8000;// �����˿�
		ServerSocket listenSocket;// �����׽���
		try {
			if (args.length == 0) {
				System.out
						.println("�÷���java MultiThreadServer <webroot> [port]");
				return;
			}
			if (args.length == 1) {
				webRoot = args[0];
			}
			if (args.length == 2) {
				webRoot = args[0];
				try {
					port = Integer.parseInt(args[1]);
				} catch (NumberFormatException e) {
					System.out.println("����2������0��65535��������");
					return;
				}
			}
			listenSocket = new ServerSocket(port);
			System.out.println("\nHttp����������ڶ˿�" + listenSocket.getLocalPort()
					+ "������");
			while (true) {
				System.out.println("�ȴ�����...");
				StreamSocket client = new StreamSocket(listenSocket.accept());
				System.out.println("�ͻ���" + client.getSocket().getInetAddress()
						+ ":" + client.getSocket().getPort() + "������");
				HttpHandlerThread handlerThread = new HttpHandlerThread(
						webRoot, client);
				Thread thread = new Thread(handlerThread);
				thread.start();
			}
		} catch (Exception e) {

		}
	}
}
