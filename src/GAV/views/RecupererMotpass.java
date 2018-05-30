package GAV.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GAV.misc.ConnectDB;
import GAV.misc.utility;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

public class RecupererMotpass extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;


	/**
	 * Create the frame.
	 */
	public RecupererMotpass() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 328);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(37, 47, 59));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[505px,grow]", "[120.00px,top][grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(37, 47, 59));
		contentPane.add(panel_3, "cell 0 0,grow");
		
		JLabel lblNewLabel_1 = new JLabel("");
		java.awt.Image logoImg = new ImageIcon(this.getClass().getResource("/logob.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(utility.getScaledImage(logoImg, 300, 170)));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(157)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(158, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[101.00][grow]", "[grow]"));
		
		JLabel lblNewLabel = new JLabel("UserName");
		panel_1.add(lblNewLabel, "cell 0 0,alignx left");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		txtuser = new JTextField();
		txtuser.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panel_1.add(txtuser, "cell 1 0,growx");
		txtuser.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "cell 0 1,grow");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtindication = new JTextPane();
		panel_4.add(txtindication, BorderLayout.CENTER);
		txtindication.setFont(new Font("Tahoma", Font.ITALIC, 14));
		txtindication.addKeyListener(new KeyAdapter() {
			
		});
		txtuser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				String username = txtuser.getText().toString();
				String req = "select password from users where username = ?";
				try {
					PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(req);
					stm.setString(1, username);
					ResultSet rs = stm.executeQuery();
					if (rs.next()) {
						String pass = rs.getString("password");
						String pass1 = pass.substring(0,2);
						txtindication.setText("les deux premier caractere de votre mot de passe sont : " +pass1+"******");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
	}

}
