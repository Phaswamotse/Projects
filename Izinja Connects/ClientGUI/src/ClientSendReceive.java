import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class ClientSendReceive extends JFrame {

	private JPanel contentPane;
	String result = "";
	static ServerSocket ss;
	static Socket s;
	static Scanner sc;
	static PrintStream ps;
	static JTextArea randTextArea;
	static JTextArea replyTextArea;
	Random rand = new Random();
	String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int strlength = 100;
	char[] mixture = new char[strlength];
	int n = 100;
	int a = 0;
	char to_be_checked;
	static JTextArea chartextArea ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSendReceive frame = new ClientSendReceive();
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
	public ClientSendReceive() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 11, 994, 673);
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
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(115, 11, 96, 47);
		panel_1.add(label_5);
		
		JPanel calculateBtn = new JPanel();
		calculateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					sc = new Scanner(ClientConnects.s.getInputStream());
					to_be_checked = (chartextArea.getText().toString().trim()).charAt(0);
					ps = new PrintStream(ClientConnects.s.getOutputStream());
					ps.println(result);
					ps.println(to_be_checked);
					
					int r1 = Integer.parseInt(sc.nextLine());
					long resp_time = Long.parseLong(sc.nextLine());
					
					replyTextArea.setText(replyTextArea.getText().trim() + "\n" + to_be_checked + " appears " + r1 + " in " + result);
					replyTextArea.setText(replyTextArea.getText().trim() + "\n" + "total time taken is " + resp_time + " millisecconds");
					
					
				}catch(Exception g) {
					g.printStackTrace();
				}
			}
		});
		calculateBtn.setLayout(null);
		calculateBtn.setBackground(new Color(0, 0, 51));
		calculateBtn.setBounds(678, 607, 295, 55);
		panel.add(calculateBtn);
		
		JLabel lblCalculateNooccurences = new JLabel("Calculate no_occurences");
		lblCalculateNooccurences.setForeground(new Color(204, 0, 0));
		lblCalculateNooccurences.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		lblCalculateNooccurences.setBounds(10, 11, 267, 35);
		calculateBtn.add(lblCalculateNooccurences);
		
		JLabel label_14 = new JLabel("");
		label_14.setBounds(141, 41, 66, 76);
		calculateBtn.add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(239, 41, 66, 76);
		calculateBtn.add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setBounds(339, 41, 66, 76);
		calculateBtn.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setBounds(239, 0, 66, 57);
		calculateBtn.add(label_17);
		
		JPanel genRanNoBtn = new JPanel();
		genRanNoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
				for(int i = 0; i < strlength; i++) {

					mixture[i] = characters.charAt(rand.nextInt(characters.length()));

				}

				for(int i = 0; i < strlength; i++) {

					result+= mixture[i];
				}
				
				randTextArea.setText((randTextArea.getText().trim() + result).substring(a, n) + "\n");
				n+=100;
				a+=100;
				//randTextArea.setText("  " + "\n");
				
				}catch(Exception f) {
					
					f.printStackTrace();
				}
			}
		});
		genRanNoBtn.setLayout(null);
		genRanNoBtn.setBackground(new Color(0, 0, 51));
		genRanNoBtn.setBounds(337, 213, 295, 55);
		panel.add(genRanNoBtn);
		
		JLabel lblGenerateRandomCharacters = new JLabel("Generate Random Characters");
		lblGenerateRandomCharacters.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					for(int i = 0; i < strlength; i++) {

						mixture[i] = characters.charAt(rand.nextInt(characters.length()));

					}

					for(int i = 0; i < strlength; i++) {

						result+= mixture[i];
					}
					

					randTextArea.setText((randTextArea.getText().trim() + result).substring(a, n) + "\n");
					n+=100;
					a+=100;
					
					}catch(Exception f) {
						
						f.printStackTrace();
					}
			}
		});
		lblGenerateRandomCharacters.setForeground(new Color(204, 0, 0));
		lblGenerateRandomCharacters.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		lblGenerateRandomCharacters.setBounds(10, 11, 275, 35);
		genRanNoBtn.add(lblGenerateRandomCharacters);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(141, 41, 66, 76);
		genRanNoBtn.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(239, 41, 66, 76);
		genRanNoBtn.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(339, 41, 66, 76);
		genRanNoBtn.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(239, 0, 66, 57);
		genRanNoBtn.add(label_13);
		
		randTextArea = new JTextArea();
		randTextArea.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		randTextArea.setBounds(10, 279, 974, 46);
		panel.add(randTextArea);
		
		chartextArea = new JTextArea();
		chartextArea.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		chartextArea.setBounds(10, 361, 167, 38);
		panel.add(chartextArea);
		
		JLabel lblEnterCharacterTo = new JLabel("Enter Character To Be Counted");
		lblEnterCharacterTo.setForeground(Color.WHITE);
		lblEnterCharacterTo.setFont(new Font("Algerian", Font.BOLD, 22));
		lblEnterCharacterTo.setBounds(231, 361, 407, 55);
		panel.add(lblEnterCharacterTo);
		
		replyTextArea = new JTextArea();
		replyTextArea.setFont(new Font("Palatino Linotype", Font.BOLD, 14));
		replyTextArea.setBounds(10, 453, 974, 146);
		panel.add(replyTextArea);
		
		JLabel lblServerReplies = new JLabel("Server Replies");
		lblServerReplies.setForeground(new Color(255, 255, 255));
		lblServerReplies.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblServerReplies.setBounds(408, 407, 205, 55);
		panel.add(lblServerReplies);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			ClientConnects ccs = new ClientConnects();
			ccs.setVisible(true);
			}
		});
		label_6.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_left_circular_52px.png"));
		label_6.setBounds(57, 597, 66, 76);
		panel.add(label_6);
	}

}
