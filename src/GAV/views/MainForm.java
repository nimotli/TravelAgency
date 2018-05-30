package GAV.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.CardLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import GAV.misc.utility;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.MouseMotionAdapter;

public class MainForm extends JFrame {
	int index =0;
	int[] oldSize = new int[4];
	boolean maximized=false;
	JComponent target;
	Point start_drag;
	Point start_loc;
	private DashBoard dashBoardPanel;
	private AutoCar autoCarPanel;
	private Ligne lignePanel;
	private Voyage voyagePanel;
	private Location locationPanel;
	private Chauffeur chauffeurPanel;
	
	
	private JPanel contentPane;
	private JPanel contentPanel;
	private JButton dashBoard;
	private JButton autoCar;
	private JButton ligne;
	private JButton voyage;
	private JButton chauffeur;
	private JButton location;
	private JPanel SidePanel;
	private JPanel ImgPanel;
	private JLabel logo;
	private JPanel header;
	private JLabel lblGestionDagenceDe;
	private JLabel lblX;
	private JLabel lblc;
	private JLabel lbl_;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MainForm() throws SQLException
	{
		initComponent();
		eventHandlers();
	}
	
	////////////////////////////////////////////////////////////////////////////////
	//Methode pour initialiser les components swing
	////////////////////////////////////////////////////////////////////////////////
	void initComponent() throws SQLException
	{
		
		setTitle("GAV");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPane.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		
		//////////////////////////////////////////////////////////////////
		//External Jpanels
		//////////////////////////////////////////////////////////////////
		dashBoardPanel=new DashBoard();
		contentPanel.add(dashBoardPanel, "dashboard");
		autoCarPanel=new AutoCar();
		contentPanel.add(autoCarPanel, "autocar");
		lignePanel=new Ligne();
		contentPanel.add(lignePanel, "ligne");
		voyagePanel=new Voyage();
		contentPanel.add(voyagePanel, "voyage");
		locationPanel=new Location();
		contentPanel.add(locationPanel, "location");
		chauffeurPanel=new Chauffeur();
		chauffeurPanel.chauf=chauffeurPanel;
		contentPanel.add(chauffeurPanel, "chauffeur");
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		SidePanel = new JPanel();
		SidePanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(SidePanel, BorderLayout.WEST);
		SidePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel menuPanel = new JPanel();
		SidePanel.add(menuPanel, BorderLayout.CENTER);
		menuPanel.setLayout(new GridLayout(0, 1, 0, 0));
		menuPanel.setBackground(new Color(25, 32, 40));
		dashBoard = new JButton("Tableau de bord");
		dashBoard.setHorizontalAlignment(SwingConstants.LEFT);
		
		dashBoard.setForeground(new Color(255, 255, 255));
		dashBoard.setBackground(new Color(0, 102, 203));
		dashBoard.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		menuPanel.add(dashBoard);
		
		autoCar = new JButton("Autocar");
		autoCar.setHorizontalAlignment(SwingConstants.LEFT);
		autoCar.setForeground(new Color(255, 255, 255));
		autoCar.setBackground(new Color(25, 32, 40));
		autoCar.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		menuPanel.add(autoCar);
		
		ligne = new JButton("Ligne");
		ligne.setHorizontalAlignment(SwingConstants.LEFT);
		ligne.setForeground(new Color(255, 255, 255));
		ligne.setBackground(new Color(25, 32, 40));
		ligne.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		menuPanel.add(ligne);
		
		voyage = new JButton("Voyage");
		voyage.setHorizontalAlignment(SwingConstants.LEFT);
		voyage.setForeground(new Color(255, 255, 255));
		voyage.setBackground(new Color(25, 32, 40));
		voyage.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		menuPanel.add(voyage);
		
		chauffeur = new JButton("Chauffeur");
		chauffeur.setHorizontalAlignment(SwingConstants.LEFT);
		chauffeur.setForeground(new Color(255, 255, 255));
		chauffeur.setBackground(new Color(25, 32, 40));
		chauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		menuPanel.add(chauffeur);
		
		location = new JButton("Location");
		location.setHorizontalAlignment(SwingConstants.LEFT);
		location.setForeground(new Color(255, 255, 255));
		location.setBackground(new Color(25, 32, 40));
		location.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		menuPanel.add(location);
		
		
		dashBoard.setBorder(emptyBorder);
		autoCar.setBorder(emptyBorder);
		ligne.setBorder(emptyBorder);
		voyage.setBorder(emptyBorder);
		chauffeur.setBorder(emptyBorder);
		location.setBorder(emptyBorder);
		
		ImgPanel = new JPanel();
		ImgPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ImgPanel.setBackground(new Color(25, 32, 40));
		SidePanel.add(ImgPanel, BorderLayout.NORTH);
		
		logo = new JLabel("");
		Image logoImg = new ImageIcon(this.getClass().getResource("/logob.png")).getImage();
		ImgPanel.setLayout(new GridLayout(0, 1, 0, 0));
		logo.setIcon(new ImageIcon(utility.getScaledImage(logoImg, 354, 209)));
		ImgPanel.add(logo);
		
		header = new JPanel();
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!maximized)
					pressing(e);
			}
		});
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(!maximized)
					dragging(e);
			}
		});
		
		
		header.setBackground(new Color(0, 102, 203));
		contentPane.add(header, BorderLayout.NORTH);
		
		lblGestionDagenceDe = new JLabel("Gestion d'agence de voyage");
		lblGestionDagenceDe.setForeground(Color.WHITE);
		lblGestionDagenceDe.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		lblc = new JLabel("\u25AD");
		lblc.setHorizontalAlignment(SwingConstants.CENTER);
		lblc.setForeground(Color.WHITE);
		lblc.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		
		lbl_ = new JLabel("-");
		lbl_.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_.setForeground(Color.WHITE);
		lbl_.setFont(new Font("Century Gothic", Font.BOLD, 18));
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGestionDagenceDe)
					.addPreferredGap(ComponentPlacement.RELATED, 913, Short.MAX_VALUE)
					.addComponent(lbl_, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblc, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
					.addComponent(lblGestionDagenceDe, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblc, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addComponent(lbl_, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
		);
		header.setLayout(gl_header);
		
		
		Image dashboardIcon = new ImageIcon(this.getClass().getResource("/dashboardIcon.png")).getImage();
		Image autocarIcon = new ImageIcon(this.getClass().getResource("/busIcon.png")).getImage();
		Image ligneIcon = new ImageIcon(this.getClass().getResource("/ligneIcon.png")).getImage();
		Image voyageIcon = new ImageIcon(this.getClass().getResource("/voyageIcon.png")).getImage();
		Image chauffeurIcon = new ImageIcon(this.getClass().getResource("/driverIcon.png")).getImage();
		Image locationIcon = new ImageIcon(this.getClass().getResource("/rentIcon.png")).getImage();

		dashBoard.setIcon(new ImageIcon(utility.getScaledImage(dashboardIcon, 40, 40)));
		autoCar.setIcon(new ImageIcon(utility.getScaledImage(autocarIcon, 40, 40)));
		ligne.setIcon(new ImageIcon(utility.getScaledImage(ligneIcon, 40, 40)));
		voyage.setIcon(new ImageIcon(utility.getScaledImage(voyageIcon, 40, 40)));
		chauffeur.setIcon(new ImageIcon(utility.getScaledImage(chauffeurIcon, 40, 40)));
		location.setIcon(new ImageIcon(utility.getScaledImage(locationIcon, 40, 40)));
		
		
	}
	
	////////////////////////////////////////////////////////////////////////////////
	//Methode pour gerer les event des components
	////////////////////////////////////////////////////////////////////////////////
	void eventHandlers()
	{
		//function calls
		menuCallInit();
		headerElementsHandler(lblX);
		headerElementsHandler(lbl_);
		headerElementsHandler(lblc);
		
		//other Events
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lbl_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		lblc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(maximized)
				{
					
					setSize(new Dimension(oldSize[0],oldSize[1]));
					setLocation(new Point(oldSize[2],oldSize[3]));
					maximized=false;
				}
				else
				{
					
					oldSize[0]=getSize().width;
					oldSize[1]=getSize().height;
					oldSize[2]=getLocation().x;
					oldSize[3]=getLocation().y;
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					maximized=true;
				}
			}
		});
		
		
		
		
	}
	
	////////////////////////////////////////////////////////////////////////////////
	//Utility Methodes
	////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	void menuCallInit()
	{
		ArrayList<JButton> buttons=new ArrayList<JButton>();
		buttons.add(dashBoard);
		buttons.add(autoCar);
		buttons.add(ligne);
		buttons.add(voyage);
		buttons.add(chauffeur);
		buttons.add(location);
		MenuHandler(dashBoard, buttons);
		MenuHandler(autoCar, buttons);
		MenuHandler(ligne, buttons);
		MenuHandler(voyage, buttons);
		MenuHandler(chauffeur, buttons);
		MenuHandler(location, buttons);
		
		
	}
	
	void MenuHandler(JButton button,ArrayList<JButton> buttons)
	{
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				
				for (int i = 0; i < buttons.size(); i++) 
				{
					if(buttons.get(i).equals(button))
					{
						 index = buttons.indexOf(button);
						 break;
					}
				}
				for(int i = 0; i < buttons.size(); i++) 
				{
					if(i!=index)
					{
						buttons.get(i).setBackground(new Color(25, 32, 40));
					}
					else
					{
						buttons.get(i).setBackground(new Color(0, 102, 203));
						CardLayout carddLayout = (CardLayout) contentPanel.getLayout();
						carddLayout.show(contentPanel, nameFromIndex(index));
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(new Color(0,102,203));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(!buttons.get(index).equals(button))
					button.setBackground(new Color(25, 32, 40));
			}
		});
	}
	
	void headerElementsHandler(JLabel lab)
	{
		lab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
	}

	String nameFromIndex(int index)
	{
		String name="";
		switch (index) {
		case 0:
			name="dashboard";
		break;

		case 1:
			name="autocar";
			break;
		case 2:
			name="ligne";
			break;
		case 3:
			name="voyage";
			break;
		case 4:
			name="chauffeur";
			break;
		case 5:
			name="location";
			break;
		}
		return name;
	}
	
	Point getScreenLocation(MouseEvent e) 
	{
	    Point cursor = e.getPoint();
	    Point target_location = getLocationOnScreen();
	    return new Point((int) (target_location.getX() + cursor.getX()),(int) (target_location.getY() + cursor.getY()));
	 }
	
	public void dragging(MouseEvent e) 
	{
		Point current = getScreenLocation(e);
	    Point offset = new Point((int) current.getX() - (int) start_drag.getX(),(int) current.getY() - (int) start_drag.getY());
	    Point new_location = new Point((int) (start_loc.getX() + offset.getX()), (int) (start_loc.getY() + offset.getY()));
	    setLocation(new_location);
	}
	public void pressing(MouseEvent e) 
	{
		start_drag=getScreenLocation(e);
		start_loc=getLocation();
	}
	
}
