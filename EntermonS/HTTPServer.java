// 基于命令行界面的HTTP服务程序
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
			System.out.println("\nHttp服务程序正在端口" + listenSocket.getLocalPort()
					+ "处运行");
			while (true) {
				System.out.println("等待连接...");
				Socket socket = listenSocket.accept();
				System.out.println("\n 客户端："
						+ socket.getInetAddress().toString() + " 在端口："
						+ socket.getPort() + "的请求连接已经接受！");
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