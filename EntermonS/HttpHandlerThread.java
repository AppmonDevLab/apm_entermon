import http.ConstantValues;
import http.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import rfc.HttpHandler;
import rfc.HttpProtocol;

// ����һ��HTTP������߳�
public class HttpHandlerThread implements Runnable {
	// �ͻ������׽���
	StreamSocket client;
	// HTTP��������Ŀ¼
	String root;
	// HTTPЭ�鴦����
	HttpHandler handler;
	// �ͻ��˵�IP
	String clientInetAddress;
	// �ͻ��˶˿�
	int clientPort;

	// ����һ��HTTP�����߳�
	public HttpHandlerThread(String webRoot, StreamSocket client) {
		this.client = client;
		this.root = webRoot;
		clientInetAddress = client.getSocket().getInetAddress().toString();
		clientPort = client.getSocket().getPort();
		handler = new HttpHandler(new HttpProtocol(root));
	}

	// ����HTTP����
	public void run() {
		String temp = null;
		StringBuffer message = new StringBuffer();
		Response response = null;
		try {
			temp = client.receiveMessage();
			while (temp != null && !temp.isEmpty()) {
				message.append(temp);
				message.append(ConstantValues.CRLF);
				temp = client.receiveMessage();
			}
			message.append(ConstantValues.CRLF);
			response = handler.handle(message.toString());
			client.sendMessage(response.getHeader().toString());
			if (response.getInput() != null) { // �ж���Ӧ���Ƿ���WEB������Ҫ���͸��ͻ���
				InputStream inputStream = response.getInput();
				OutputStream outputStream = client.getSocket()
						.getOutputStream();
				byte[] bytes = new byte[1024];
				int length = 0;
				while ((length = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, length);
					outputStream.flush();
				}
				inputStream.close();
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out
				.println("�ͻ���" + clientInetAddress + ":" + clientPort + "�ѶϿ�");
	}
}
