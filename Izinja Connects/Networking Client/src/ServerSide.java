import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
public class ServerSide {
	
	public static void main(String args[])throws Exception{
		
		System.out.println("Server has started");
		ServerSocket ss = new ServerSocket(6666);
		System.out.println("Server is waiting for client to connect...");
		Socket s = ss.accept();
		
		System.out.println("Client connected");
		
		Scanner sc = new Scanner(s.getInputStream());
		
		String str =  sc.nextLine();
		char b = sc.next().charAt(0);
		
		PrintStream p = new PrintStream(s.getOutputStream());
		
		//System.out.println("Client data: " + str);
		
		int count = 0;
		//p.println("hello " + str);
		
		for(int i = 0; i < str.length(); i++) {
			
			if(b == str.charAt(i)) {
				
				count++;
			}
		}
		
		if(count==1) {
			p.println(b + " appears once in " + str );
		}
		
		else if(count == 0) {
			
			p.println(b + " doesn't appear in " + str );
		}
		else {
			
			p.println(b + " appears " + count + " times in " + str );
		}
		
		//p.println(b);
	
	
	}
	
	

}
