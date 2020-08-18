import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class ConnectServer extends JFrame {

	private JPanel contentPane;
	static ServerSocket ss;
	static Socket s;
	static Scanner sc;
	static PrintStream ps;
	static JTextArea Comms_Area;
	static JTextArea statustextArea;
	static JTextArea w4conntextArea;
	/**
	 * Launch the application.
	 * 
	 * 
	 */
	static int count_character(String a, char c) {
		
		int occurences = 0;
		
		for(int i = 0; i < a.length(); i++) {
			
			if(c == a.charAt(i)) {
				
				occurences++;
			}
		}
		
		return occurences;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectServer frame = new ConnectServer();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//String gen_str = "";
		///char x;
		//try {
			
			//ss = new ServerSocket(20000);
			//s = ss.accept();
			//Comms_Area.setText(Comms_Area.getText().trim() + "\n" + "Client Connected");
			//sc = new Scanner(s.getInputStream());
			//ps = new PrintStream(s.getOutputStream());
			
				
		//	gen_str = sc.nextLine();
		//	long start_Time = System.currentTimeMillis();
		//	x = sc.next().charAt(0);
		//	String occs = String.valueOf(count_character(gen_str, x));
		//	ps.println(occs);
		//	long end_Time = System.currentTimeMillis();
		//	String time = Long.toString(end_Time-start_Time);
		//	ps.println(time);
			
			//Comms_Area.setText(Comms_Area.getText().trim() + "\n" + "Random String from client: " + gen_str );
			//Comms_Area.setText(Comms_Area.getText().trim() + "\n" + "Character to be counted: " + x);
			//Comms_Area.setText(Comms_Area.getText().trim() + "\n"+ "\n" + "Results sent back successfully to the client" );
			//Comms_Area.setText(Comms_Area.getText().trim() + "\n" +mssg);
			
			
	//	}catch(Exception f) {
		//	f.printStackTrace();
	//	}
	}

	/**
	 * Create the frame.
	 */
	public ConnectServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.setBackground(new Color(153, 153, 153));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 954, 160);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel.add(panel_1);
		
		JLabel label = new JLabel("IzinjaTheDogs");
		label.setForeground(new Color(204, 0, 0));
		label.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 38));
		label.setBounds(31, 25, 266, 55);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Server Side");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Bell MT", Font.BOLD, 38));
		label_1.setBounds(344, 75, 239, 85);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_dog_sit_64px.png"));
		label_2.setForeground(new Color(51, 51, 153));
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_2.setBounds(282, 0, 159, 73);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(new Color(51, 51, 153));
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_3.setBounds(118, 11, 194, 36);
		panel_1.add(label_3);
		
		
		
		JButton exitBtn = new JButton("");
		exitBtn.setBackground(new Color(25, 25, 112));
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		exitBtn.setBounds(837, 0, 39, 28);
		panel_1.add(exitBtn);
		exitBtn.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_delete_sign_32px_2.png"));
		
		JButton minBtn = new JButton("");
		minBtn.setBackground(new Color(0, 0, 139));
		minBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConnectServer.this.setState(JFrame.ICONIFIED);
				
			}
		});
		minBtn.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_minimize_window_32px_2.png"));
		minBtn.setBounds(788, 0, 39, 28);
		panel_1.add(minBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
					statustextArea.setForeground(Color.red);
					statustextArea.setText("Offline");
					w4conntextArea.setText(" ");
					
				
				
				//Window2 back = new Window2();
				//back.setVisible(true);
				
			}
		});
		panel_3.setBounds(505, 444, 178, 108);
		panel_3.setBackground(new Color(230, 230, 250));
		panel.add(panel_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(new Color(51, 51, 153));
		label_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblStopServer = new JLabel("Stop Server");
		lblStopServer.setForeground(new Color(65, 105, 225));
		lblStopServer.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_shutdown_52px_1.png"));
		label_16.setForeground(new Color(51, 51, 153));
		label_16.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(58)
					.addComponent(label_6)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(lblStopServer, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStopServer, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(16))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblServerStatusOnline = new JLabel("Server Status: ");
		lblServerStatusOnline.setForeground(new Color(65, 105, 225));
		lblServerStatusOnline.setFont(new Font("Bell MT", Font.BOLD, 36));
		lblServerStatusOnline.setBounds(234, 171, 239, 46);
		panel.add(lblServerStatusOnline);
		
		Comms_Area = new JTextArea();
		Comms_Area.setFont(new Font("Monospaced", Font.BOLD, 17));
		Comms_Area.setBackground(SystemColor.inactiveCaption);
		Comms_Area.setBounds(0, 285, 954, 139);
		panel.add(Comms_Area);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				statustextArea.setForeground(Color.green);
				statustextArea.setText("ONLINE");
				w4conntextArea.setForeground(Color.getHSBColor(65, 105, 225));
				w4conntextArea.setText("Waiting for connection....");
				
				String gen_str = "";
				char x;
				try {
					
					ss = new ServerSocket(20000);
					s = ss.accept();
					Comms_Area.setText(Comms_Area.getText().trim() + "\n" + "Client Connected");
					sc = new Scanner(s.getInputStream());
					ps = new PrintStream(s.getOutputStream());
					
						
					gen_str = sc.nextLine();
					long start_Time = System.currentTimeMillis();
					x = sc.next().charAt(0);
					String occs = String.valueOf(count_character(gen_str, x));
					ps.println(occs);
					long end_Time = System.currentTimeMillis();
					String time = Long.toString(end_Time-start_Time);
					ps.println(time);
					
					Comms_Area.setText(Comms_Area.getText().trim() + "\n" + "Random String from client: " + gen_str );
					Comms_Area.setText(Comms_Area.getText().trim() + "\n" + "Character to be counted: " + x);
					Comms_Area.setText(Comms_Area.getText().trim() + "\n"+ "\n" + "Results sent back successfully to the client" );
					//Comms_Area.setText(Comms_Area.getText().trim() + "\n" +mssg);
					
					
				}catch(Exception f) {
					f.printStackTrace();
				}
				
			
			}
		});
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(151, 444, 178, 108);
		panel.add(panel_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(new Color(51, 51, 153));
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_shutdown_52px_1.png"));
		label_5.setForeground(new Color(51, 51, 153));
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel lblRunServer = new JLabel("Run Server");
		lblRunServer.setForeground(new Color(65, 105, 225));
		lblRunServer.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 178, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(58)
					.addComponent(label_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addComponent(lblRunServer, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 108, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRunServer, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(16))
		);
		panel_2.setLayout(gl_panel_2);
		
		statustextArea = new JTextArea();
		statustextArea.setBackground(new Color(153, 153, 153));
		statustextArea.setForeground(new Color(0, 102, 255));
		statustextArea.setFont(new Font("Bell MT", Font.BOLD, 36));
		statustextArea.setBounds(472, 172, 172, 46);
		panel.add(statustextArea);
		
		w4conntextArea = new JTextArea();
		w4conntextArea.setForeground(new Color(65, 105, 225));
		w4conntextArea.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 24));
		w4conntextArea.setBackground(new Color(153, 153, 153));
		w4conntextArea.setBounds(10, 228, 350, 57);
		panel.add(w4conntextArea);
	
	}
}
