import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
public static void main(String args[])throws Exception{
		
		System.out.println("Server just went online");
		ServerSocket ss = new ServerSocket(50000);
		System.out.println("Server is waiting for connection...");
		Socket s = ss.accept();
		System.out.println("Connection with client established");
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine();
		System.out.println("Client : " + str);
		ss.close();
	}

}
