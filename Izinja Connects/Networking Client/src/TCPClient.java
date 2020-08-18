import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

	public static void main(String args[])throws Exception {
		
		Socket s = new Socket("localhost", 50000);
		String rr = "Percy";
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter pw = new PrintWriter(os);
		os.write(rr);
		os.flush();
		}
}
