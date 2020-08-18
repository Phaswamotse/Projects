import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;


public class ClientSide {
	
	public static void main(String args[])throws Exception {
		
		Scanner in = new Scanner(System.in);
		Socket s = new Socket("localhost", 15000);
		Scanner sc = new Scanner(s.getInputStream());
		
		String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 100;
		
		char[] mixture = new char[length];
		String result = "";
		
		Random rand = new Random();
		
		for(int i = 0; i < length; i++) {
			
			mixture[i] = characters.charAt(rand.nextInt(characters.length()));
			
		}
		
		for(int i = 0; i < mixture.length; i++) {
			
			result+= mixture[i];
		}
		
		System.out.println("Enter your character");
		
		//Send randomly generated string to server and the character to be counted
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println(mixture);
		
		char a = in.next().charAt(0);
		ps.println(a);
		String temp = sc.nextLine();
		String r = sc.nextLine();
		int no_occurences = Integer.parseInt(temp);
		long time_taken = Long.parseLong(r);
		
		if(no_occurences == 0) {
			
			System.out.println(a + " doesn't appear in " + mixture);
		}else if(no_occurences==1) {
			
			System.out.println(a + " appears once in " + mixture );
		}else {
		System.out.println(a + " appears " + no_occurences + " times in " + mixture);
		}
		
		System.out.println("The total time taken to count the number of occurences of " + a + "is " + time_taken + "milliseconds" );
		//System.out.println(r);
		//PrintWriter out = new PrintWriter(os);
		//os.write(a);
		//os.close();
	}

}
