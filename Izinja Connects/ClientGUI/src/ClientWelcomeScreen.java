import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientWelcomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWelcomeScreen frame = new ClientWelcomeScreen();
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
	public ClientWelcomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 23, 994, 673);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBounds(0, 0, 994, 202);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("IzinjaTheDogs");
		label.setForeground(new Color(153, 0, 0));
		label.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 42));
		label.setBounds(0, 35, 338, 55);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(334, 0, 124, 119);
		panel_1.add(label_1);
		label_1.setIcon(new ImageIcon("D:\\JAVA\\ClientGUI\\images\\icons8_black_panther_mask_filled_100px_12.png"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(115, 11, 96, 47);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_horizontal_line_96px.png"));
		
		JLabel lblClientSide = new JLabel("Client Side");
		lblClientSide.setForeground(new Color(255, 255, 255));
		lblClientSide.setFont(new Font("Algerian", Font.BOLD, 46));
		lblClientSide.setBounds(344, 130, 338, 55);
		panel_1.add(lblClientSide);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_dog_sit_128px.png"));
		label_2.setBounds(868, 0, 116, 128);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBounds(55, 257, 168, 150);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(54, 11, 66, 76);
		panel_2.add(label_3);
		label_3.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_info_52px_2.png"));
		
		JLabel lblReadDocumentation = new JLabel("Documentation");
		lblReadDocumentation.setBounds(10, 98, 147, 35);
		panel_2.add(lblReadDocumentation);
		lblReadDocumentation.setForeground(new Color(204, 0, 0));
		lblReadDocumentation.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		
		JPanel connServerBtn = new JPanel();
		connServerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClientConnects cc = new ClientConnects();
				cc.setVisible(true);
			}
		});
		connServerBtn.setBackground(new Color(0, 0, 51));
		connServerBtn.setBounds(383, 257, 168, 150);
		panel.add(connServerBtn);
		connServerBtn.setLayout(null);
		
		JLabel connectIcon = new JLabel("");
		connectIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ClientConnects cc = new ClientConnects();
				cc.setVisible(true);
			}
		});
		connectIcon.setBounds(51, 11, 66, 76);
		connServerBtn.add(connectIcon);
		connectIcon.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_connection_sync_60px.png"));
		
		JLabel lblConnectTo = new JLabel("Connect To");
		lblConnectTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ClientConnects cc = new ClientConnects();
				cc.setVisible(true);
			}
		});
		lblConnectTo.setForeground(new Color(204, 0, 0));
		lblConnectTo.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblConnectTo.setBounds(31, 79, 127, 29);
		connServerBtn.add(lblConnectTo);
		
		JLabel lblServers = new JLabel("Servers");
		lblServers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ClientConnects cc = new ClientConnects();
				cc.setVisible(true);			
			}
		});
		lblServers.setForeground(new Color(204, 0, 0));
		lblServers.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblServers.setBounds(54, 110, 82, 29);
		connServerBtn.add(lblServers);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 51));
		panel_4.setBounds(743, 257, 168, 150);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(63, 11, 66, 76);
		panel_4.add(label_5);
		label_5.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_download_52px_2.png"));
		
		JLabel lblUpdateToV = new JLabel("Update To v1.2");
		lblUpdateToV.setForeground(new Color(204, 0, 0));
		lblUpdateToV.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 20));
		lblUpdateToV.setBounds(10, 98, 147, 35);
		panel_4.add(lblUpdateToV);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 51));
		panel_5.setBounds(255, 543, 437, 122);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblConnectWithUs = new JLabel("Connect With Us On");
		lblConnectWithUs.setBounds(113, 11, 246, 35);
		panel_5.add(lblConnectWithUs);
		lblConnectWithUs.setForeground(new Color(204, 0, 0));
		lblConnectWithUs.setFont(new Font("Bell MT", Font.BOLD, 24));
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_facebook_48px.png"));
		label_6.setBounds(37, 41, 66, 70);
		panel_5.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_twitter_48px.png"));
		label_7.setBounds(141, 41, 66, 76);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_instagram_new_48px.png"));
		label_8.setBounds(239, 41, 66, 76);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("D:\\JAVA\\SampleServer\\images\\icons8_whatsapp_48px.png"));
		label_9.setBounds(339, 41, 66, 76);
		panel_5.add(label_9);
	}
}
