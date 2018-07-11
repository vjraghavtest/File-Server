import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FileReceiver extends Thread{
	Socket socket=null;
	public FileReceiver(Socket socket){
		this.socket=socket;
	}
	public void run() {
		BufferedReader reader=null;
		DataInputStream inputStream=null;
		BufferedOutputStream bufferedOutputStream=null;
		PrintWriter printWriter=null;
		String path="C:\\Users\\Administrator\\Desktop\\output-newp.exe";
		int bytesRead = 0;
		byte[] buffer=new byte[8*1024];
		try {
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			inputStream=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			System.out.println("got client in stream");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(new File(path)));
			System.out.println("New File loaded");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Receiving file");
			
//			String receivedChecksum=inputStream.readUTF();
//			dataOutputStream.writeUTF("");
			System.out.println(reader.readLine());
			
			
//			while(bytesRead>-1){
//				System.out.println("Receiving");
//				bytesRead=inputStream.read(buffer);
//				System.out.println(bytesRead+" bytes received");
//				bufferedOutputStream.write(buffer, 0, bytesRead);
//				System.out.println(bytesRead+" bytes written to file");
//			}
				
			
//			printWriter=new PrintWriter(socket.getOutputStream());
//			bufferedOutputStream.close();
			System.out.println("being flushed");
			bufferedOutputStream.flush();
			System.out.println("flushed");
			bufferedOutputStream.close();
			System.out.println("File transfereddddd completly");
//			dataOutputStream.writeUTF(Checksum.getChecksum(path));
//			printWriter.write(Checksum.getChecksum(path));
//			printWriter.flush();
			System.out.println("checksum sent");
			System.out.println("Checksum"+Checksum.getChecksum(path));
//			System.out.println("Checksum received from client is "+receivedChecksum);
//			String checksum=Checksum.getChecksum(path);
//			System.out.println("Calculated checksum "+checksum);
//			if(checksum.equals(receivedChecksum))
//				System.out.println("File are same");
//			else
//				System.out.println("File not same");
//			bufferedOutputStream.close();
//			bufferedInputStream.close();
//			socket.close();
		} catch (IOException  e) {
			e.printStackTrace();
		}
	}

}
