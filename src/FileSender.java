import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FileSender extends Thread{
	Socket socket=null;
	String path=null;
	public FileSender(Socket socket,String path) {
		this.socket=socket;
		this.path=path;
		
	}
	
	public void run() {
 //		this.path="D:\\Default Software's-E7450\\npp.6.9.1.Installer.exe";
		FileInputStream fileInputStream=null;
		DataInputStream inputStream=null;
//		BufferedOutputStream outputStream=null;
		DataOutputStream outputStream=null;
		BufferedReader bufferedReader=null;
		PrintWriter printWriter=null;
		String checksum=Checksum.getChecksum(path);
		
		
				
		
		int bytesRead;
		System.out.println("Connected with server");
		System.out.println("File path - "+path);
		File file=new File(path);
		try {
			System.out.println("Reading file");
//			outputStream=new BufferedOutputStream(socket.getOutputStream());
			fileInputStream=new FileInputStream(file);
			outputStream=new DataOutputStream(socket.getOutputStream());
			printWriter=new PrintWriter(socket.getOutputStream());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] buffer=new byte[8*1024];
		
		inputStream=new DataInputStream(new BufferedInputStream(fileInputStream));
		try {
			bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Transferring file data");
				
		
		try {
			
			System.out.println("Transferring file");
			printWriter.println(file.length());
			System.out.println(file.length());
//			dataOutputStream.writeUTF(checksum);
//			inputStream.readUTF();
			

//			while((bytesRead=inputStream.read(buffer))>0){
//				System.out.println("Sent "+bytesRead+" bytes");
//				outputStream.write(buffer, 0, bytesRead);
//			}
			printWriter.flush();
			inputStream.close();
			outputStream.flush();
//			outputStream.close();
			
			
			
			System.out.println("File sent");
			System.out.println("Checksum"+checksum);
//			System.out.println(ack.readUTF());
//			System.out.println("Received checksum is "+bufferedReader.readLine());
//			socket.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
