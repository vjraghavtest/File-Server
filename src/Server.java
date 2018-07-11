import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int PORT=5555;
	public static final String HOST="127.0.0.1";
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null;
		
		try {
			serverSocket=new ServerSocket(PORT);
			System.out.println("Server started");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (true) {
			try {
				socket=serverSocket.accept();
				System.out.println("client connected");
			} catch (IOException e) {
				e.printStackTrace();
			}
			new FileReceiver(socket).start();
		}
	}

}
