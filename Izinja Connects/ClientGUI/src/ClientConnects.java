import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnects extends JFrame {

	private JPanel contentPane;
	static ServerSocket ss;
	static Socket s;
	String ip1 = "",ip2 = "",ip3= "";
	int port3 = 50000,port1 = 20000,port2 = 35000;
	Scanner sc;
	PrintStream ps;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientConnects frame = new ClientConnects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientConnects() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 994, 673);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 994, 202);
		panel.add(panel_1);
		
		JLabel label = new JLabel("IzinjaTheDogs");
		label.setForeground(new Color(153, 0, 0));
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 42));
		label.setBounds(0, 35, 338, 55);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\JAVA\\ClientGUI\\images\\icons8_black_panther_mask_filled_100px_12.png"));
		label_1.setBounds(334, 0, 124, 119);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(115, 11, 96, 47);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Client Side");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Algerian", Font.BOLD, 46));
		label_3.setBounds(344, 130, 338, 55);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_dog_sit_128px.png"));
		label_4.setBounds(868, 0, 116, 128);
		panel_1.add(label_4);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_horizontal_line_96px.png"));
		label_17.setBounds(115, 11, 96, 47);
		panel_1.add(label_17);
		
		JLabel prevIcon = new JLabel("");
		prevIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ClientWelcomeScreen cws = new ClientWelcomeScreen();
				cws.setVisible(true);
				
			}
		});
		prevIcon.setBounds(10, 597, 66, 76);
		panel.add(prevIcon);
		prevIcon.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_left_circular_52px.png"));
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_server_96px.png"));
		label_5.setBounds(87, 249, 96, 76);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_server_96px.png"));
		label_6.setBounds(87, 361, 96, 76);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_server_96px.png"));
		label_7.setBounds(87, 469, 96, 86);
		panel.add(label_7);
		
		JTextArea ip1textArea = new JTextArea();
		ip1textArea.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		ip1textArea.setBounds(223, 279, 267, 46);
		panel.add(ip1textArea);
		
		JTextArea ip2textArea = new JTextArea();
		ip2textArea.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		ip2textArea.setBounds(223, 391, 267, 46);
		panel.add(ip2textArea);
		
		JTextArea ip3textArea = new JTextArea();
		ip3textArea.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		ip3textArea.setBounds(223, 509, 267, 46);
		panel.add(ip3textArea);
		
		JLabel lblServerIp = new JLabel("Server 1 IP Address");
		lblServerIp.setForeground(Color.WHITE);
		lblServerIp.setFont(new Font("Algerian", Font.BOLD, 30));
		lblServerIp.setBounds(521, 284, 358, 55);
		panel.add(lblServerIp);
		
		JLabel lblServerIp_1 = new JLabel("Server 2 ip address");
		lblServerIp_1.setForeground(Color.WHITE);
		lblServerIp_1.setFont(new Font("Algerian", Font.BOLD, 30));
		lblServerIp_1.setBounds(521, 399, 358, 55);
		panel.add(lblServerIp_1);
		
		JLabel lblServerIp_2 = new JLabel("Server 3 IP address");
		lblServerIp_2.setForeground(Color.WHITE);
		lblServerIp_2.setFont(new Font("Algerian", Font.BOLD, 30));
		lblServerIp_2.setBounds(521, 517, 358, 55);
		panel.add(lblServerIp_2);
		
		JPanel nextBtn = new JPanel();
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ClientSendReceive csr = new ClientSendReceive();
			csr.setVisible(true);
			}
		});
		nextBtn.setLayout(null);
		nextBtn.setBackground(new Color(0, 0, 51));
		nextBtn.setBounds(678, 607, 295, 55);
		panel.add(nextBtn);
		
		JLabel lblConnectToServers = new JLabel("Connect To Servers");
		lblConnectToServers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					ip1 = ip1textArea.getText().toString().trim();
					ip2 = ip2textArea.getText().toString().trim();
					ip3 = ip3textArea.getText().toString().trim();
					s = new Socket("localhost",port1);
					//sc = new Scanner(s.getInputStream());
					
					
				}catch(Exception f) {
					
					f.printStackTrace();
				}
				ClientSendReceive csr = new ClientSendReceive();
				csr.setVisible(true);
			}
		});
		lblConnectToServers.setForeground(new Color(204, 0, 0));
		lblConnectToServers.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		lblConnectToServers.setBounds(10, 11, 226, 35);
		nextBtn.add(lblConnectToServers);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(141, 41, 66, 76);
		nextBtn.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(239, 41, 66, 76);
		nextBtn.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(339, 41, 66, 76);
		nextBtn.add(label_12);
		
		JLabel nextIcon = new JLabel("");
		nextIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientSendReceive csr = new ClientSendReceive();
				csr.setVisible(true);
			}
		});
		nextIcon.setBounds(239, 0, 66, 57);
		nextBtn.add(nextIcon);
		nextIcon.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_right_circular_52px.png"));
	}

}
