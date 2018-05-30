package GAV.views;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import com.itextpdf.text.Image;

import GAV.misc.ConnectDB;
import GAV.misc.utility;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;

public class application {

	private JFrame frmLogin;
	private JPasswordField txtpassword;
	private JTextField txtusername;
     
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public application() {
		initialize();
		try {
			connecter();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(new Color(37, 47, 59));
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 812, 416);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:\\Users\\ASUS\\Desktop\\logob.png");
		java.awt.Image myimg = img.getImage();
		ImageIcon image = new ImageIcon(myimg);
		java.awt.Image newimage =myimg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		java.awt.Image logoImg = new ImageIcon(this.getClass().getResource("/logob.png")).getImage();
		frmLogin.getContentPane().setLayout(new MigLayout("", "[539px,grow]", "[127.00px][227px,grow]"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(37, 47, 59));
		frmLogin.getContentPane().add(panel_4, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(utility.getScaledImage(logoImg, 300, 170)));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(246)
					.addComponent(lblNewLabel)
					.addContainerGap(246, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(37, 47, 59));
		frmLogin.getContentPane().add(panel_3, "flowx,cell 0 1,grow");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(new MigLayout("", "[grow]", "[grow][]"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel.add(panel_2, "cell 0 0,grow");
		panel_2.setLayout(new MigLayout("", "[105.00][grow]", "[grow][grow]"));
		
		JLabel usernameLabel = new JLabel("UserName ");
		panel_2.add(usernameLabel, "cell 0 0");
		usernameLabel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		usernameLabel.setForeground(Color.BLACK);
		
		txtusername = new JTextField();
		panel_2.add(txtusername, "cell 1 0,growx");
		txtusername.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		txtusername.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		panel_2.add(lblPassword, "cell 0 1");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		txtpassword = new JPasswordField();
		panel_2.add(txtpassword, "cell 1 1,growx");
		txtpassword.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new MigLayout("", "[103px,grow]", "[][25px]"));
		
		JLabel lblNewLabel_2 = new JLabel("mot de passe oublier");
		panel_1.add(lblNewLabel_2, "cell 0 0,alignx right");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblNewLabel_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				RecupererMotpass obj = new RecupererMotpass();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
                				
				
			}
		});
		lblNewLabel_2.setForeground(Color.RED);
		
		JButton btnConnecter = new JButton("CONNECTER");
		btnConnecter.setForeground(new Color(255, 255, 255));
		btnConnecter.setBackground(new Color(60, 179, 113));
		panel_1.add(btnConnecter, "cell 0 1,alignx center,aligny top");
		btnConnecter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(142)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(152, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		btnConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username1 = txtusername.getText().toString();
				 String password1 = txtpassword.getText().toString();
				 String req = "select username , password from users";
				 try {
					PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(req);
					ResultSet rs = stm.executeQuery();
					int valide = 0 ;
					if (username1.equals("") || password1.equals("")) {
						JOptionPane.showMessageDialog(null, "remplir tout les champs ! ");
					}else{
						while (rs.next()) {
							String user = rs.getString("username");
							String pass = rs.getString("password");
							if (user.equals(username1)&& pass.equals(password1)) {
								//JOptionPane.showMessageDialog(null, "Connexion reussit !! ");
								MainForm obj = new MainForm();
								obj.setVisible(true);
								obj.setLocationRelativeTo(null);
								valide = 1 ;
								frmLogin.dispose();
								
							}
							
						}
						
						if (valide==0) {
							JOptionPane.showMessageDialog(null, "information invalide !! ");
						}
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 
			}
			
		});
		
		
		
	
	}
       public void connecter() throws SQLException{
    	   Connection cnx = ConnectDB.getConnetion();
    	   if (cnx != null) {
			System.out.println("application.connecter()");
		}
    	   Statement stm = cnx.createStatement();
    	   ResultSet rs = stm.executeQuery("select * from agence");
    	   while (rs.next()) {
                 System.out.println(rs.getString(1));			
		}
    	   
       }
}
