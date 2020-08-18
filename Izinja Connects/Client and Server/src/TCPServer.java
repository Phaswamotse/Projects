import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;

public class TCPServer {

	public static void main(String args[])throws Exception{

		System.out.println("Server has started");
		ServerSocket ss = new ServerSocket(6668);
		int counter = 1;
		System.out.println("Server is waiting for client to connect...");
		
		Socket s = ss.accept();

		System.out.println("Client " + counter + " connected");
		counter++;

		Scanner sc = new Scanner(s.getInputStream());

		String str =  sc.nextLine();
		char b = sc.next().charAt(0);

		PrintStream p = new PrintStream(s.getOutputStream());

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

			//p.println(b);


	}



	}


