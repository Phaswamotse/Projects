import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunnable implements Runnable{
	
	protected Socket clientSocket = null;
	
	public SocketServerRunnable(Socket clientSocket){
		
		this.clientSocket = clientSocket;
	}
	
	public void run(){
		
		try{
			
			Scanner sc = new Scanner(clientSocket.getInputStream());

			String str =  sc.nextLine();
			char b = sc.next().charAt(0);

			PrintStream p = new PrintStream(clientSocket.getOutputStream());

			//System.out.println("Client data: " + str);

			int count = 0;
			p.println("Your randomly generated string is " + str);

			for(int i = 0; i < str.length(); i++) {

				if(b == str.charAt(i)) {

					count++;
				}
			}

			if(count==1) {
				p.println("your character " + b + " appears once in " + str );
			}

			else if(count == 0) {

				p.println("your character " + b + " doesn't appear in " + str );
			}
			else {

				p.println("your character " + b + " appears " + count + " times in " + str );
			}

			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
		
		
	}

}
