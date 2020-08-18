import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;


public class TCPClient {

	public static void main(String args[])throws Exception {

		Scanner in = new Scanner(System.in);
		Socket s = new Socket("localhost", 6668);
		Scanner sc = new Scanner(s.getInputStream());

		String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 100;

		char[] mixture = new char[length];
		String result = "";
		String a = result.substring(1);
		Random rand = new Random();

		for(int i = 0; i < length; i++) {

			mixture[i] = characters.charAt(rand.nextInt(characters.length()));

		}

		for(int i = 0; i < mixture.length; i++) {

			result+= mixture[i];
		}

		System.out.println("Enter your character");

		//OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		char a = in.next().charAt(0);
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println(mixture);
		ps.println(a);
		String temp = sc.nextLine();
		String r = sc.nextLine();
		System.out.println(temp);
		System.out.println(r);
		//PrintWriter out = new PrintWriter(os);
		//os.write(a);
		//os.close();
	}

}
