import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.awt.Frame;
public class Window2 extends JFrame {

	private JPanel contentPane;
	static boolean maximized = true;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 frame = new Window2();
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
	public Window2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 591);
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
		panel_1.setBounds(0, 0, 877, 160);
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
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		exitBtn.setBounds(828, 0, 39, 28);
		panel_1.add(exitBtn);
		exitBtn.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_delete_sign_32px_2.png"));
		
		JButton minBtn = new JButton("");
		minBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Window2.this.setState(JFrame.ICONIFIED);
				
			}
		});
		minBtn.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_minimize_window_32px_2.png"));
		minBtn.setBounds(779, 0, 39, 28);
		panel_1.add(minBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(52, 214, 178, 108);
		panel_2.setBackground(new Color(230, 230, 250));
		panel.add(panel_2);
		
		JLabel label_4 = new JLabel("Read Documentation");
		label_4.setForeground(new Color(65, 105, 225));
		label_4.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_info_52px.png"));
		label_5.setForeground(new Color(51, 51, 153));
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label_4)
					.addGap(12))
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addGap(57)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		Timer timer = new Timer();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//try {
					/*System.out.println("Server just went online");
					ServerSocket ss = new ServerSocket(50000);
					System.out.println("Server is waiting for connection...");
					Socket s = ss.accept();
					System.out.println("Connection with client established");
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String str = br.readLine();
					System.out.println("Client : " + str);*/
					
					ConnectServer cs = new ConnectServer();
					cs.setVisible(true);
					//ss.close();
					//}catch(IOException f) {
						
					//	f.printStackTrace();
					//}
				
			}
		});
		panel_3.setBounds(364, 214, 178, 108);
		panel_3.setBackground(new Color(230, 230, 250));
		panel.add(panel_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(new Color(51, 51, 153));
		label_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_7 = new JLabel("Start Server");
		label_7.setForeground(new Color(65, 105, 225));
		label_7.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		
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
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(16))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(256, 427, 326, 95);
		panel_4.setBackground(new Color(230, 230, 250));
		panel.add(panel_4);
		
		JLabel lblConnectWithUs = new JLabel("Connect With Us On");
		lblConnectWithUs.setForeground(new Color(65, 105, 225));
		lblConnectWithUs.setFont(new Font("Georgia", Font.BOLD, 15));
		
		JLabel label_9 = new JLabel("");
		label_9.setForeground(new Color(51, 51, 153));
		label_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_10 = new JLabel("");
		label_10.setForeground(new Color(51, 51, 153));
		label_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_facebook_48px.png"));
		label_11.setForeground(new Color(51, 51, 153));
		label_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_twitter_48px.png"));
		label_12.setForeground(new Color(51, 51, 153));
		label_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_instagram_new_48px.png"));
		label_17.setForeground(new Color(51, 51, 153));
		label_17.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addGap(84)
					.addComponent(lblConnectWithUs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(22)
					.addComponent(label_10)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
						.addComponent(lblConnectWithUs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_17, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(660, 214, 178, 108);
		panel_5.setBackground(new Color(230, 230, 250));
		panel.add(panel_5);
		
		JLabel label_13 = new JLabel("");
		label_13.setForeground(new Color(51, 51, 153));
		label_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_download_52px.png"));
		label_14.setForeground(new Color(51, 51, 153));
		label_14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		JLabel label_15 = new JLabel("Update Server To v1.2");
		label_15.setForeground(new Color(65, 105, 225));
		label_15.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 14));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(58)
					.addComponent(label_13)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(60))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_15)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_15, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
					.addGap(16))
		);
		panel_5.setLayout(gl_panel_5);
	}
}
