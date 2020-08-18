import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	int portNumber = 6668;
	ServerSocket serverSocket = null;
	
	public void runServer(){
		
		try{
			
			serverSocket = new ServerSocket(portNumber);
			
		} catch(IOException e){
			System.out.println(e.getMessage());
			
		}
		
		while(true){
			
			try{
				Socket clientSocket = serverSocket.accept();
				SocketServerRunnable m = new SocketServerRunnable(clientSocket);
				new Thread(m);
				
			} catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}

}
