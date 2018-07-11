import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		Socket socket=null;
		String cmd=null;
		File file=null;
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Connecting to server");
		try {
			socket=new Socket(Server.HOST, Server.PORT);
			System.out.println("Connected to server");
		} catch (UnknownHostException e) {
			System.out.println("Server is not up");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true){
			System.out.println("Enter file path(EXIT to exit)");
			try {
				cmd=reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(cmd.toUpperCase().equals("EXIT")){
				System.out.println("Ending connection");
				break;
			}
			cmd=cmd.replace("\"", "");
			if((new File(cmd).isFile()))
					new FileSender(socket, cmd).start();
			else
				System.out.println("File not found");
			
		}
//		System.out.println("1.Send/n2.View");
//		try {
//			switch(Integer.parseInt(reader.readLine())){
//			case 1:System.out.println("Enter the file path");
//			       
//			}
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}
