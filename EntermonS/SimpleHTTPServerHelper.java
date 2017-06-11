// HTTP������������
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.Socket;
import java.util.StringTokenizer;

public class SimpleHTTPServerHelper {
	private final static String CRLF = System.getProperty("line.separator");
	private StreamSocket streamSocket;

	public SimpleHTTPServerHelper(Socket socket) throws Exception {
		streamSocket = new StreamSocket(socket);
	}

	// ���� HTTP�ͻ��˵�����
	public void processRequest() throws Exception {
		String statusLine = null;
		String entityBody = null;
		// ��ȡ����ʾ HTTP�ͻ����ύ��������Ϣ
		while (true) {
			String headerLine = streamSocket.receiveMessage();
			if (headerLine.trim().equals(".")) {
				System.out.println("�Ự������");
				break;
			} else {
				if (headerLine.length() != 0)
					System.out.println("�ͻ��˵������ǣ�" + headerLine);
				StringTokenizer s = new StringTokenizer(headerLine);
				if ((s.countTokens() >= 2) && s.nextToken().equals("GET")) {
					// ��������ȡ���ĵ����ļ�����֧��Ĭ�������ļ�
					String filename = s.nextToken();
					if (filename.startsWith("/"))
						filename = filename.substring(1);
					if (filename.endsWith("/"))
						filename += "index.html";
					if (filename.equals(""))
						filename += "index.html";
					// ����������ļ�
					FileInputStream fis = null;
					boolean fileExists = true;
					try {
						fis = new FileInputStream(filename);
						fis.close();
					} catch (FileNotFoundException e) {
						fileExists = false;
					}
					// ��ȡ�ļ��е����ݲ�д��socket�������
					if (fileExists) {
						statusLine = "HTTP/1.0 200 OK" + CRLF;
					} else {
						statusLine = "HTTP/1.0 404 Not Found" + CRLF;
						entityBody = "��HTML��" + "��HEAD��" + CRLF
								+ "��TITLE��404 Not Found��/TITLE��" + CRLF
								+ "��/HEAD����BODY��" + CRLF + "<h1>Not Found</h1>"
								+ CRLF + "<p>The request URI " + filename
								+ " was not found on this server.</p>" + CRLF
								+ "��/BODY����/HTML��" + CRLF;
					}
					streamSocket.sendMessage(statusLine);
					streamSocket.sendMessage(CRLF);
					if (fileExists) {
						streamSocket.sendBytes(filename);
						streamSocket.sendMessage(CRLF);
						streamSocket.sendMessage(CRLF);
					} else {
						streamSocket.sendMessage(entityBody);
						streamSocket.sendMessage(CRLF);
					}
				}
			}
		}
	}
}