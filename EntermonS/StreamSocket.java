// �Զ����������׽���
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class StreamSocket {
	// �����׽���
	private Socket socket;
	// ���뻺��
	private BufferedReader input;
	// �������
	private PrintWriter output;
	private OutputStream outStream;
	// �������е��׽��ִ����Զ������׽���
	public StreamSocket(Socket s) throws IOException {
		socket = s;
		setStreams();
	}
	// �����������������˿ڽ������׽���
	public StreamSocket(String acceptorHost, int acceptorPort)
			throws UnknownHostException, IOException {
		socket = new Socket(acceptorHost, acceptorPort);
		setStreams();
	}
	// ������ ������Ϣ
	public void sendMessage(String message) {
		output.print(message);
		output.flush();
	}
	// �ӷ���˽�����Ϣ
	public String receiveMessage() throws IOException {
		String message = input.readLine();
		return message;
	}
	// ����������
	private void setStreams() throws IOException {
		InputStream inStream = socket.getInputStream();
		input = new BufferedReader(new InputStreamReader(inStream));
		outStream = socket.getOutputStream();
		output = new PrintWriter(new OutputStreamWriter(outStream));
	}
	// ���ļ�������������
	public void sendBytes(String filename) throws Exception {
		InputStream file = new FileInputStream(filename);
		byte[] data = new byte[file.available()];
		file.read(data);
		outStream.write(data);
		file.close();
	}
	// �ر����롢������漰�׽���
	public void close() throws IOException {
		input.close();
		output.close();
		socket.close();
	}
	// ȡ�׽���
	public Socket getSocket() {
		return socket;
	}
	// �����׽���
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
