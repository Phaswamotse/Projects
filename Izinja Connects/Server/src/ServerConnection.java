import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerConnection {

	static int count_character(String a, char b){
		
		int count = 0;
		
		for(int i = 0; i < a.length(); i++){
			
			if(b==a.charAt(i)){
				
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String args[])throws Exception{
		
		System.out.println("Server has started");
		ServerSocket ss = new ServerSocket(20000);
		Socket s = ss.accept();
		System.out.println("Client Connected");
		Scanner sc = new Scanner(s.getInputStream());
		PrintStream ps = new PrintStream(s.getOutputStream());
		
		String data = sc.nextLine();
		
		char character = sc.nextLine().charAt(0);
		long start_time = System.currentTimeMillis();
		int total = count_character(data, character);
		ps.println(String.valueOf(total));
		long end_time = System.currentTimeMillis();
		
		ps.println(Long.toString(end_time-start_time));
		
		
		
		
		
		
	}
	
}
