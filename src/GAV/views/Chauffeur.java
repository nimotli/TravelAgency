package GAV.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import GAV.misc.ConnectDB;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;
import com.mysql.jdbc.PreparedStatement;
import com.itextpdf.text.*;

import GAV.misc.ConnectDB;
import GAV.misc.RepetetiveEvents;
import GAV.misc.utility;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ListSelectionModel;

public class Chauffeur extends JPanel {
	String basePath = new File("").getAbsolutePath();
	String s="";
	String m="";
	Boolean canlisten=true;
	String selectedMat="";
	byte[] modByte;
	private JTable congetable;
	private JButton ajouter;
	private JButton modifier;
	private JButton supprimer;
	private JPanel ajoutpanel;
	private JPanel modpanel;
	private JPanel suppanel;
	private JPanel CrudPanelHolder;
	private JPanel congePanel;
	private JLabel label;
	private JButton supprimerconge;
	private JLabel label_2;
	private JTextField matriculemod;
	private JLabel lblCnss_1;
	private JTextField cnssmod;
	private JLabel label_4;
	private JLabel lblNom_1;
	private JLabel lblPrenom_1;
	private JLabel lblCin_1;
	private JTextField nommod;
	private JTextField prenommod;
	private JTextField cinmod;
	private JButton btnModifier;
	private JPanel panel_3;
	private JButton oui;
	private JButton non;
	private JPanel ajoutForm;
	private JPanel ajouttitle;
	private JLabel lblAjout;
	private JLabel label2;
	private JTextField matriculeAj;
	private JLabel lblCnss;
	private JTextField cnssaj;
	private JTextField cinaj;
	private JTextField nomAj;
	private JTextField prenomaj;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblCin;
	private JLabel label_12;
	private JButton ajouterbtn;
	private JPanel modificationForm;
	private JPanel modificationTitle;
	private JLabel lblModification;
	private JScrollPane scrollPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblAdresse;
	private JLabel lblNumTelephon;
	private JTextField phonaj;
	private JTextField adresseaj;
	private JTextField phonmod;
	private JLabel label_1;
	private JLabel lblAdresse_1;
	private JTextField adresmod;
	private JButton btnAjouterConge;
	public Chauffeur chauf;
	private JButton button;
	private JButton btnParcourir;
	private JPanel panel_4;
	private JLabel picaj;
	private JButton parcmod;
	private JPanel panel_5;
	private JLabel picmod;

	
	
	/**
	 * Create the panel.
	 */
	public Chauffeur() 
	{
		initComponent();
		eventHandler();
	}
	
	void initComponent()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel background = new JPanel();
		background.setBackground(new Color(37, 47, 59));
		add(background);
		background.setLayout(new MigLayout("", "[grow]", "[][223.00,fill][grow]"));
		
		JLabel title = new JLabel("Chauffeur");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		background.add(title, "cell 0 0");
		
		JPanel TablePanel = new JPanel();
		TablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		background.add(TablePanel, "cell 0 1,growx,aligny baseline");
		TablePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		scrollPane = new JScrollPane();
		TablePanel.add(scrollPane);
		
		table = new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		congePanel = new JPanel();
		TablePanel.add(congePanel);
		congePanel.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		congePanel.setBackground(Color.WHITE);
		congePanel.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		label = new JLabel("Conges");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		congePanel.add(label, "cell 0 0");
		
		scrollPane_1 = new JScrollPane();
		congePanel.add(scrollPane_1, "cell 0 1,grow");
		
		btnAjouterConge = new JButton("Ajouter conge");
		
		btnAjouterConge.setForeground(Color.WHITE);
		btnAjouterConge.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAjouterConge.setBackground(new Color(60, 179, 113));
		congePanel.add(btnAjouterConge, "flowx,cell 0 2,alignx right");
		
		supprimerconge = new JButton("Supprimer conge");
		
		supprimerconge.setForeground(Color.WHITE);
		supprimerconge.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		supprimerconge.setBackground(new Color(60, 179, 113));
		congePanel.add(supprimerconge, "cell 0 2,alignx center");
		
		JPanel EditPanel = new JPanel();
		EditPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		background.add(EditPanel, "cell 0 2,grow");
		EditPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel MenuHolder = new JPanel();
		MenuHolder.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		EditPanel.add(MenuHolder, BorderLayout.NORTH);
		MenuHolder.setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[]"));
		
		ajouter = new JButton("Ajout");
		ajouter.setForeground(Color.WHITE);
		ajouter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajouter.setBackground(new Color(60, 179, 113));
		MenuHolder.add(ajouter, "cell 0 0,growx");
		
		modifier = new JButton("Modification");
		modifier.setForeground(Color.WHITE);
		modifier.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modifier.setBackground(new Color(60, 179, 113));
		MenuHolder.add(modifier, "cell 1 0,growx");
		
		supprimer = new JButton("Suppression");
		supprimer.setForeground(Color.WHITE);
		supprimer.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		supprimer.setBackground(new Color(60, 179, 113));
		MenuHolder.add(supprimer, "cell 2 0,growx");
		
		button = new JButton("Impression");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		button.setBackground(new Color(60, 179, 113));
		MenuHolder.add(button, "cell 3 0,growx");
		
		CrudPanelHolder = new JPanel();
		EditPanel.add(CrudPanelHolder, BorderLayout.CENTER);
		CrudPanelHolder.setLayout(new CardLayout(0, 0));
		ajoutpanel = new JPanel();
		ajoutpanel.setBackground(UIManager.getColor("CheckBox.background"));
		CrudPanelHolder.add(ajoutpanel, "acajoutpanel");
		ajoutpanel.setLayout(new BorderLayout(0, 0));
		
		ajoutForm = new JPanel();
		ajoutpanel.add(ajoutForm, BorderLayout.CENTER);
		ajoutForm.setLayout(new MigLayout("", "[][grow][][][grow]", "[grow][grow][grow][grow][grow][]"));
		
		label2 = new JLabel("Matricule");
		label2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(label2, "cell 0 0,alignx trailing");
		
		matriculeAj = new JTextField();
		matriculeAj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		matriculeAj.setColumns(10);
		ajoutForm.add(matriculeAj, "cell 1 0,growx");
		
		label_12 = new JLabel("           ");
		ajoutForm.add(label_12, "cell 2 0");
		
		lblCnss = new JLabel("CNSS");
		lblCnss.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblCnss, "cell 3 0,alignx trailing");
		
		cnssaj = new JTextField();
		cnssaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cnssaj.setColumns(10);
		ajoutForm.add(cnssaj, "cell 4 0,growx");
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblNom, "cell 0 1,alignx trailing");
		
		nomAj = new JTextField();
		nomAj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		nomAj.setColumns(10);
		ajoutForm.add(nomAj, "cell 1 1,growx");
		
		lblCin = new JLabel("Cin");
		lblCin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblCin, "cell 3 1,alignx trailing");
		
		cinaj = new JTextField();
		cinaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cinaj.setColumns(10);
		ajoutForm.add(cinaj, "cell 4 1,growx");
		
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblPrenom, "cell 0 2,alignx trailing");
		
		prenomaj = new JTextField();
		prenomaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		prenomaj.setColumns(10);
		ajoutForm.add(prenomaj, "cell 1 2,growx");
		
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblAdresse, "cell 3 2,alignx trailing");
		
		adresseaj = new JTextField();
		adresseaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		adresseaj.setColumns(10);
		ajoutForm.add(adresseaj, "cell 4 2,growx");
		
		lblNumTelephon = new JLabel("Num Telephon");
		lblNumTelephon.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblNumTelephon, "cell 0 3,alignx trailing");
		
		phonaj = new JTextField();
		phonaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		phonaj.setColumns(10);
		ajoutForm.add(phonaj, "cell 1 3,growx");
		
		btnParcourir = new JButton("Parcourir");
		
		btnParcourir.setForeground(Color.WHITE);
		btnParcourir.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnParcourir.setBackground(new Color(60, 179, 113));
		ajoutForm.add(btnParcourir, "flowx,cell 0 4,alignx right");
		
		panel_4 = new JPanel();
		panel_4.setBorder(null);
		ajoutForm.add(panel_4, "cell 1 4,grow");
		panel_4.setLayout(new GridLayout(1, 1));
		
		picaj = new JLabel("");
		panel_4.add(picaj);
		
		ajouterbtn = new JButton("Ajouter");
		
		ajouterbtn.setForeground(Color.WHITE);
		ajouterbtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajouterbtn.setBackground(new Color(60, 179, 113));
		ajoutForm.add(ajouterbtn, "cell 4 5,alignx center");
		
		ajouttitle = new JPanel();
		ajouttitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ajoutpanel.add(ajouttitle, BorderLayout.NORTH);
		
		lblAjout = new JLabel("Ajout");
		lblAjout.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajouttitle.add(lblAjout);
		
		modpanel = new JPanel();
		modpanel.setBackground(UIManager.getColor("CheckBox.background"));
		CrudPanelHolder.add(modpanel, "acmodpanel");
		modpanel.setLayout(new BorderLayout(0, 0));
		
		modificationForm = new JPanel();
		modpanel.add(modificationForm);
		modificationForm.setLayout(new MigLayout("", "[65px][339px,grow][33px][65px][339px,grow]", "[25px,grow][25px,grow][25px,grow][27px,grow][grow]"));
		
		label_2 = new JLabel("Matricule");
		modificationForm.add(label_2, "cell 0 0,alignx trailing");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		matriculemod = new JTextField();
		matriculemod.setEditable(false);
		modificationForm.add(matriculemod, "cell 1 0,growx,aligny center");
		matriculemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		matriculemod.setColumns(10);
		
		label_4 = new JLabel("           ");
		modificationForm.add(label_4, "cell 2 0,alignx left,aligny center");
		
		lblCnss_1 = new JLabel("CNSS");
		modificationForm.add(lblCnss_1, "cell 3 0,alignx trailing");
		lblCnss_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		cnssmod = new JTextField();
		modificationForm.add(cnssmod, "cell 4 0,growx,aligny center");
		cnssmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cnssmod.setColumns(10);
		
		lblNom_1 = new JLabel("Nom");
		modificationForm.add(lblNom_1, "cell 0 1,alignx trailing");
		lblNom_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		nommod = new JTextField();
		modificationForm.add(nommod, "cell 1 1,growx,aligny center");
		nommod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		nommod.setColumns(10);
		
		lblCin_1 = new JLabel("Cin");
		modificationForm.add(lblCin_1, "cell 3 1,alignx trailing");
		lblCin_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		cinmod = new JTextField();
		modificationForm.add(cinmod, "cell 4 1,growx,aligny center");
		cinmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cinmod.setColumns(10);
		
		lblPrenom_1 = new JLabel("Prenom");
		modificationForm.add(lblPrenom_1, "cell 0 2,alignx trailing");
		lblPrenom_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		prenommod = new JTextField();
		modificationForm.add(prenommod, "cell 1 2,growx,aligny center");
		prenommod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		prenommod.setColumns(10);
		
		lblAdresse_1 = new JLabel("Adresse");
		lblAdresse_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(lblAdresse_1, "cell 3 2,alignx trailing");
		
		adresmod = new JTextField();
		adresmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		adresmod.setColumns(10);
		modificationForm.add(adresmod, "cell 4 2,growx");
		
		label_1 = new JLabel("Num Telephon");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(label_1, "cell 0 3,alignx trailing");
		
		phonmod = new JTextField();
		phonmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		phonmod.setColumns(10);
		modificationForm.add(phonmod, "cell 1 3,growx");
		
		parcmod = new JButton("Parcourir");
		
		parcmod.setForeground(Color.WHITE);
		parcmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		parcmod.setBackground(new Color(60, 179, 113));
		modificationForm.add(parcmod, "cell 0 4");
		
		panel_5 = new JPanel();
		modificationForm.add(panel_5, "cell 1 4,grow");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		picmod = new JLabel("");
		panel_5.add(picmod);
		
		btnModifier = new JButton("Modifier");
		
		modificationForm.add(btnModifier, "cell 4 4,alignx center,aligny center");
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnModifier.setBackground(new Color(60, 179, 113));
		
		modificationTitle = new JPanel();
		modificationTitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		modpanel.add(modificationTitle, BorderLayout.NORTH);
		
		lblModification = new JLabel("Modification");
		lblModification.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationTitle.add(lblModification);
		
		suppanel = new JPanel();
		suppanel.setBackground(UIManager.getColor("CheckBox.background"));
		CrudPanelHolder.add(suppanel, "acsuppanel");
		
		JPanel panel = new JPanel();
		suppanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3 = new JPanel();
		suppanel.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[491px,grow]", "[25px,grow]"));
		
		JLabel lblNewLabel = new JLabel("Voulez vous vraiment supprimer cette enregistrement");
		panel_3.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 19));
		suppanel.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow,fill][grow,fill][grow,fill]", "[grow,fill][grow,fill][grow,fill]"));
		
		oui = new JButton("Oui");
		
		oui.setForeground(Color.WHITE);
		oui.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		oui.setBackground(new Color(60, 179, 113));
		panel_1.add(oui, "cell 1 1");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		non = new JButton("Non");
		
		non.setForeground(Color.WHITE);
		non.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		non.setBackground(new Color(60, 179, 113));
		panel_2.add(non, "cell 1 1,grow");
		RepetetiveEvents.remplirTable("SELECT * FROM chauffeur", table);
	}
	void eventHandler()
	{
		RepetetiveEvents.CrudButtonsHandler(ajouter,"acajoutpanel",CrudPanelHolder,table,1);
		RepetetiveEvents.CrudButtonsHandler(modifier,"acmodpanel",CrudPanelHolder,table,2);
		RepetetiveEvents.CrudButtonsHandler(supprimer,"acsuppanel",CrudPanelHolder,table,3);
		selectionChanged();
		ajouterbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( matriculeAj.getText()!="" && nomAj.getText()!="" && prenomaj.getText()!=""&&cnssaj.getText()!=""&&cinaj.getText()!=""&&adresseaj.getText()!=""&&phonaj.getText()!="")
				{
					String requete ="insert into chauffeur(matricule,nomChauffeur,prenom,cnss,cin,adresse,phon,image) values(?,?,?,?,?,?,?,?)";
					try
					{
						java.io.InputStream imgg = new FileInputStream(new File(s));
						java.sql.PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(requete);
						stm.setString(1, matriculeAj.getText());
						stm.setString(2, nomAj.getText());
						stm.setString(3, prenomaj.getText());
						stm.setString(4, cnssaj.getText());
						stm.setString(5, cinaj.getText());
						stm.setString(6, adresseaj.getText());
						stm.setString(7, phonaj.getText());
						stm.setBlob(8, imgg);
						try
						{
							stm.execute();
							RepetetiveEvents.infoBox("chauffeur ajouté", "Info");
							matriculeAj.setText("");  
							nomAj.setText("");
							prenomaj.setText("");
							cnssaj.setText("");
							cinaj.setText("");
							adresseaj.setText("");
							phonaj.setText("");
						} 
						catch (Exception e2) 
						{
							RepetetiveEvents.infoBox("chauffeur non ajouté", "Info");
						}
					} 
					catch (Exception e2) 
					{
						System.out.println(e2.getMessage());
					}
					
					RepetetiveEvents.remplirTable("SELECT * FROM chauffeur ", table);
				}
				else
				{
					
				}
			}
		});
		
		
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if( matriculemod.getText()!="" && nommod.getText()!="" && prenommod.getText()!=""&&cnssmod.getText()!=""&&cinmod.getText()!=""&&adresmod.getText()!=""&&phonmod.getText()!="")
				{
					String requete ="update chauffeur set adresse=? ,cin=? ,cnss=? ,nomChauffeur=? ,phon=? ,prenom=?,image=? where matricule='"+selectedMat+"'";
					try
					{
						System.out.println("byte content"+modByte);
						java.io.InputStream imgg = new ByteArrayInputStream(modByte);
						System.out.println(requete);
						java.sql.PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(requete);
						System.out.println(stm.getWarnings());
						stm.setString(1, matriculemod.getText());
						stm.setString(1, adresmod.getText());
						stm.setString(2, cinmod.getText());
						stm.setString(3, cnssmod.getText());
						stm.setString(4, nommod.getText());
						stm.setString(5, phonmod.getText());
						stm.setString(6, prenommod.getText());
						stm.setBlob(7, imgg);
						try 
						{
							stm.execute();
							RepetetiveEvents.infoBox("chauffeur modifié", "Info");
							matriculemod.setText("");  
							nommod.setText("");
							prenommod.setText("");
							cnssmod.setText("");
							cinmod.setText("");
							adresmod.setText("");
							phonmod.setText("");
						} 
						catch (Exception e2) 
						{
							RepetetiveEvents.infoBox("chauffeur non modifié", "Info");
						}
						CardLayout carddLayout = (CardLayout) CrudPanelHolder.getLayout();
						carddLayout.show(CrudPanelHolder, "acajoutpanel");
						canlisten=false;
						try 
						{
							DefaultTableModel dtm = utility.buildTableModel(utility.query("SELECT * FROM chauffeur"));
							table.setModel(dtm);
							
						} 
						catch (SQLException e1) 
						{
							System.out.println("machi 7"+e1.getMessage());;
						}
						canlisten=true;
						table.setRowSelectionInterval(0, 0);
				}
					catch (Exception e2) 
					{
						System.out.println("pls"+e2.getMessage());
					}
				
			}
			}
		});
		
		oui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String requete ="delete from chauffeur where matricule = '"+selectedMat+"'";
				if(utility.insert(requete))
				{
					RepetetiveEvents.infoBox("Autocar supprimé", "Info");
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					int count=table.getSelectedRow();
					table.setRowSelectionInterval(0, 0);
					dm.removeRow(count);	
				}
				else
					RepetetiveEvents.infoBox("Autocar non supprimé", "Info");
				CardLayout carddLayout = (CardLayout) CrudPanelHolder.getLayout();
				carddLayout.show(CrudPanelHolder, "acajoutpanel");
			}
		});
		
		non.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout carddLayout = (CardLayout) CrudPanelHolder.getLayout();
				carddLayout.show(CrudPanelHolder, "acajoutpanel");
			}
		});
		supprimerconge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					if(congetable.getSelectedRow()!=-1)
					{
						String requete="delete from conge where matricule ='"+selectedMat+"'";
						if(utility.update(requete))
						{
							updateSubTable();
							RepetetiveEvents.infoBox("Conge supprimé", "Info");
						}
						else
						{
							RepetetiveEvents.infoBox("Conge non supprimé", "Erreur");
						}
					}
					else
					{
						RepetetiveEvents.infoBox("Veuillez selectionner le conge a supprimer", "Erreur");
					}
				}
				else
				{
					RepetetiveEvents.infoBox("Veuillez selectionner un chauffeur", "Erreur");
				}
			}
		});
		btnAjouterConge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRow()!=-1)
				{
					congeForm frame = new congeForm(selectedMat,chauf);
					frame.setVisible(true);
				}
				else
				{
					RepetetiveEvents.infoBox("Veuillez selectionner un chauffeur", "Erreur");
				}
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				try {
					
					PdfWriter.getInstance(doc, new FileOutputStream(basePath+"\\ListeChauffeur.pdf"));
					doc.open();
					Image img = Image.getInstance(basePath+"\\logob.png");
					img.scaleAbsolute(200, 150);
					img.setAlignment(Image.ALIGN_LEFT);
					doc.add(img);
					doc.add(new Paragraph("                                                                    Liste Chauffeurs"));
					doc.add(new Paragraph("   "));

					PdfPTable table = new PdfPTable(8);
					table.setWidthPercentage(100);
					
					PdfPCell cell = new PdfPCell(new Phrase("MATRICULE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell);
					
					PdfPCell cell1 = new PdfPCell(new Phrase("NOM CHAUFFEUR", FontFactory.getFont("Comic Sans MS ", 12)));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell1);
                                        
                                         PdfPCell cell3 = new PdfPCell(new Phrase("PRENOM", FontFactory.getFont("Comic Sans MS ", 12)));
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell3);

          				PdfPCell cell4 = new PdfPCell(new Phrase("CNSS", FontFactory.getFont("Comic Sans MS ", 12)));
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell4);
					
					PdfPCell cell5 = new PdfPCell(new Phrase("CIN", FontFactory.getFont("Comic Sans MS ", 12)));
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell5);

					PdfPCell cell6 = new PdfPCell(new Phrase("ADRESSE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell6);

					PdfPCell cell7 = new PdfPCell(new Phrase("PHONE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell7.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell7);

                                        PdfPCell cell8 = new PdfPCell(new Phrase("IMAGE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell8.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell8);
					//
					String req = "select * from chauffeur";
					java.sql.PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(req);
					ResultSet rs = stm.executeQuery();
					while(rs.next()){
						PdfPCell cell11 = new PdfPCell(new Phrase(rs.getString("matricule"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell11.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell11);
						
						PdfPCell cell22 = new PdfPCell(new Phrase(rs.getString("nomChauffeur"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell22.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell22);

						PdfPCell cell44 = new PdfPCell(new Phrase(rs.getString("prenom"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell44.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell44);

						PdfPCell cell55 = new PdfPCell(new Phrase(rs.getString("cnss"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell55.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell55);

						PdfPCell cell66 = new PdfPCell(new Phrase(rs.getString("cin"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell66.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell66);

						PdfPCell cell77 = new PdfPCell(new Phrase(rs.getString("adresse"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell77.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell77);

						PdfPCell cell88 = new PdfPCell(new Phrase(rs.getString("phon"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell88.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell88);

                                                Image img22 = Image.getInstance(rs.getBytes("image"));
						table.addCell(img22);



					}
					
					
					doc.add(table);
					
					doc.close();
					Desktop.getDesktop().open(new  File(basePath+"\\ListeChauffeur.pdf"));
					
					
				} 
				catch (Exception e) 
				{
					RepetetiveEvents.infoBox("Document est déjà ouvert"+e.getMessage(), "erreur");
				}
			}
		});
		btnParcourir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File("C:\\Users\\hp beste audio\\Desktop"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE","png","gif","lpg");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					String fileName = selectedFile.getName();          
					String fileExtension = fileName.substring(fileName.indexOf(".") + 1, selectedFile.getName().length());
					System.out.println(fileExtension);
					if(fileExtension.equals("png") || fileExtension.equals("gif") || fileExtension.equals("lpg") || fileExtension.equals("jpg") || fileExtension.equals("jpeg") )
					{
						System.out.println("shouldbehere");
						ImageIcon myImg = new ImageIcon(path);
						java.awt.Image img = myImg.getImage();
						java.awt.Image newimg = img.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
						ImageIcon finalimg = new ImageIcon(newimg);
						picaj.setIcon(finalimg);
						s = path ;
					}
					else
						RepetetiveEvents.infoBox("type de fichier non supporté (png,gif,lpg)", "erreur");
				}
				else
				{
					if (result == JFileChooser.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "T'a rien choisi");
					}
				}
			}
		});
		parcmod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File("C:\\Users\\hp beste audio\\Desktop"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE","png","gif","lpg");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) 
				{
					String fileName = file.getName();          
					String fileExtension = fileName.substring(fileName.indexOf(".") + 1, file.getName().length());
					if(fileExtension.equals("png") || fileExtension.equals("gif") || fileExtension.equals("lpg") || fileExtension.equals("jpg") || fileExtension.equals("jpeg") )
					{
						File selectedFile = file.getSelectedFile();
						String path = selectedFile.getAbsolutePath();
						ImageIcon myImg = new ImageIcon(path);
						java.awt.Image img = myImg.getImage();
						java.awt.Image newimg = img.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
						ImageIcon finalimg = new ImageIcon(newimg);
						picmod.setIcon(finalimg);
						m = path ;
					}
					else
						RepetetiveEvents.infoBox("type de fichier non supporté (png,gif,lpg)", "erreur");
					
				}
				else
				{
					if (result == JFileChooser.CANCEL_OPTION)
					{
						JOptionPane.showMessageDialog(null, "T'a rien choisi");
					}
				}
			}
		});
	}
	public void updateSubTable()
	{
		String requete="SELECT dateDebut,dateFin,congetype  FROM conge where matricule='"+selectedMat+"'";
		try 
		{
			DefaultTableModel dtm = utility.buildTableModel(utility.query(requete));
			if(dtm!=null)
			{
				congetable = new JTable(dtm);
				scrollPane_1.setViewportView(congetable);
			}
			
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	}
	void selectionChanged()
	{
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting() && canlisten) {
					selectedMat=table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
					matriculemod.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
					nommod.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
					prenommod.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
					cnssmod.setText(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
					cinmod.setText(table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
					adresmod.setText(table.getModel().getValueAt(table.getSelectedRow(), 5).toString());
					phonmod.setText(table.getModel().getValueAt(table.getSelectedRow(), 6).toString());
					
					ResultSet rs=utility.query("select image from chauffeur where matricule='"+selectedMat+"'");
					try 
					{
						if(rs.next())
						{
							modByte=rs.getBytes("image");
							ImageIcon myImg = new ImageIcon(modByte);
							java.awt.Image img = myImg.getImage();
							java.awt.Image newimg = img.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH);
							ImageIcon finalimg = new ImageIcon(newimg);
							picmod.setIcon(finalimg);
						}
						
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					
					updateSubTable();
		        }
			}
		});
	}


}
