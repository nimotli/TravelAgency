package GAV.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import GAV.misc.RepetetiveEvents;
import GAV.misc.utility;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.BevelBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ListSelectionModel;
public class Voyage extends JPanel {
	String basePath = new File("").getAbsolutePath();
	Boolean canListen=true;
	private String selectedMat="";
	private HashMap<String , Integer> ligneMap = new HashMap<String , Integer>();
	private HashMap<String , String> autocarMap = new HashMap<String , String>();
	private HashMap<String , String> chauffeurMap = new HashMap<String , String>();
	private JButton ajouter;
	private JButton modifier;
	private JButton supprimer;
	private JPanel ajoutpanel;
	private JPanel modpanel;
	private JPanel suppanel;
	private JPanel CrudPanelHolder;
	private JLabel lblLigne_1;
	private JLabel lblAutocar_1;
	private JLabel label_4;
	private JLabel lblChauffeur_1;
	private JLabel lblDateVoyage_1;
	private JButton btnModifier;
	private JPanel panel_3;
	private JButton oui;
	private JButton non;
	private JPanel ajoutForm;
	private JPanel ajouttitle;
	private JLabel lblAjout;
	private JLabel lblLigne;
	private JLabel label_12;
	private JButton ajoutervoyage;
	private JPanel modificationForm;
	private JPanel modificationTitle;
	private JLabel lblModification;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel Etap1;
	private JLabel lblAutocar;
	private JComboBox ligne;
	private JLabel lblChauffeur;
	private JList chauffeur;
	private JComboBox autocar;
	private JSpinner datevoyage;
	private JLabel lblDateVoyage;
	private JComboBox lignemod;
	private JComboBox autocarmod;
	private JSpinner datevoyagemod;
	private JList chauffeurmod;
	private JPanel panel_4;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_1;
	private JButton button;


	
	
	/**
	 * Create the panel.
	 */
	public Voyage() 
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
		background.setLayout(new MigLayout("", "[grow]", "[][127.00,fill][grow]"));
		
		JLabel title = new JLabel("Voyage");
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
		ajoutForm.setLayout(new CardLayout(0, 0));
		
		Etap1 = new JPanel();
		ajoutForm.add(Etap1, "name_581937275735033");
		Etap1.setLayout(new MigLayout("", "[][grow][][][grow]", "[grow][grow][grow]"));
		
		lblLigne = new JLabel("Ligne");
		Etap1.add(lblLigne, "cell 0 0,alignx trailing");
		lblLigne.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		ligne = new JComboBox();
		ligne.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Etap1.add(ligne, "cell 1 0,growx");
		
		label_12 = new JLabel("           ");
		Etap1.add(label_12, "cell 2 0");
		
		lblAutocar = new JLabel("Autocar");
		lblAutocar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Etap1.add(lblAutocar, "cell 3 0,alignx trailing");
		
		autocar = new JComboBox();
		autocar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Etap1.add(autocar, "cell 4 0,growx");
		
		lblChauffeur = new JLabel("Chauffeur");
		lblChauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Etap1.add(lblChauffeur, "cell 0 1");
		
		chauffeur = new JList();
		chauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		chauffeur.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		Etap1.add(chauffeur, "cell 1 1,grow");
		
		lblDateVoyage = new JLabel("Date voyage");
		lblDateVoyage.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Etap1.add(lblDateVoyage, "cell 3 1");
		
		datevoyage = new JSpinner();
		
		datevoyage.setModel(new SpinnerDateModel(new Date(1513987200000L), null, null, Calendar.DAY_OF_YEAR));
		datevoyage.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Etap1.add(datevoyage, "cell 4 1,growx");
		
		ajoutervoyage = new JButton("Ajouter");
		
		Etap1.add(ajoutervoyage, "cell 4 2,alignx center");
		ajoutervoyage.setForeground(Color.WHITE);
		ajoutervoyage.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutervoyage.setBackground(new Color(60, 179, 113));
		
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
		modificationForm.setLayout(new MigLayout("", "[65px][339px,grow][33px][65px][339px,grow]", "[25px,grow][25px,grow][25px,grow]"));
		
		lblLigne_1 = new JLabel("Ligne");
		modificationForm.add(lblLigne_1, "cell 0 0,alignx trailing");
		lblLigne_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		lignemod = new JComboBox();
		lignemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(lignemod, "cell 1 0,growx");
		
		label_4 = new JLabel("           ");
		modificationForm.add(label_4, "cell 2 0,alignx left,aligny center");
		
		lblAutocar_1 = new JLabel("Autocar");
		modificationForm.add(lblAutocar_1, "cell 3 0,alignx trailing");
		lblAutocar_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		autocarmod = new JComboBox();
		autocarmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(autocarmod, "cell 4 0,growx");
		
		lblChauffeur_1 = new JLabel("Chauffeur");
		modificationForm.add(lblChauffeur_1, "cell 0 1,alignx trailing");
		lblChauffeur_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		chauffeurmod = new JList();
		chauffeurmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		chauffeurmod.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		modificationForm.add(chauffeurmod, "cell 1 1,grow");
		
		lblDateVoyage_1 = new JLabel("Date voyage");
		modificationForm.add(lblDateVoyage_1, "cell 3 1,alignx trailing");
		lblDateVoyage_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		datevoyagemod = new JSpinner();
		
		datevoyagemod.setModel(new SpinnerDateModel(new Date(1513987200000L), null, null, Calendar.DAY_OF_YEAR));
		datevoyagemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(datevoyagemod, "cell 4 1,growx");
		
		btnModifier = new JButton("Modifier");
		
		modificationForm.add(btnModifier, "cell 4 2,alignx center,aligny center");
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
		
		RepetetiveEvents.remplirTable("SELECT * FROM voyage", table);
		
		panel_4 = new JPanel();
		TablePanel.add(panel_4);
		panel_4.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		lblNewLabel_1 = new JLabel("Chauffeur");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_4.add(lblNewLabel_1, "cell 0 0");
		
		scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, "cell 0 1,grow");
	}
	void eventHandler()
	{
		RepetetiveEvents.CrudButtonsHandler(ajouter,"acajoutpanel",CrudPanelHolder,table,1);
		RepetetiveEvents.CrudButtonsHandler(modifier,"acmodpanel",CrudPanelHolder,table,2);
		RepetetiveEvents.CrudButtonsHandler(supprimer,"acsuppanel",CrudPanelHolder,table,3);
		fillLigne();
		fillAutoCar(0);
		fillChauffeur(0);
		selectionChanged();
		ajoutervoyage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				canListen=false;
				String date=new SimpleDateFormat("yyyy/MM/dd").format(datevoyage.getValue());
				String requete="insert into voyage (dateVoyage,idAutocar,idLigne) values ('"+date+"',"+autocarMap.get(autocar.getSelectedItem())+","+ligneMap.get(ligne.getSelectedItem())+")";
				if(utility.insert(requete))
				{
					ResultSet rs =utility.query("select max(id) from voyage");
					int id=-1;
					try
					{
						while (rs.next()) 
						{
							id=rs.getInt(1);
						}
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					for (Object  obj: chauffeur.getSelectedValues()) 
					{
						String req ="insert into voyagechauffeur values("+id+",'"+chauffeurMap.get(obj)+"')";
						utility.insert(req);
					}
					RepetetiveEvents.infoBox("Voyage ajouté", "info");
					RepetetiveEvents.remplirTable("SELECT * FROM voyage", table);
				}
				else
				{
					RepetetiveEvents.infoBox("Voyage non ajouté", "erreur");
				}
				canListen=true;
			}
		});
		
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				canListen=false;
				String date=new SimpleDateFormat("yyyy/MM/dd").format(datevoyagemod.getValue());
				String requete="Update voyage set dateVoyage='"+date+"' ,idAutocar='"+autocarMap.get(autocarmod.getSelectedItem())+"' , idLigne="+ligneMap.get(lignemod.getSelectedItem())+" Where id="+selectedMat;
				if(utility.insert(requete))
				{
					utility.update("delete from voyagechauffeur where idVoyage="+selectedMat);
					if(chauffeurmod.getSelectedIndices().length > 0)
					{
						for (Object  obj: chauffeurmod.getSelectedValues()) 
						{
							String req = "INSERT INTO voyagechauffeur values("+selectedMat+",'"+chauffeurMap.get((String)obj)+"')";
							utility.insert(req);
						}
					}
					CardLayout carddLayoutt = (CardLayout) CrudPanelHolder.getLayout();
					carddLayoutt.show(CrudPanelHolder, "acajoutpanel");
					RepetetiveEvents.infoBox("Voyage modifié", "info");
					RepetetiveEvents.remplirTable("SELECT * FROM voyage", table);
				}
				else
				{
					RepetetiveEvents.infoBox("Voyage non modifié", "erreur");
				}
				canListen=true;
			}
		});
		
		non.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout carddLayout = (CardLayout) CrudPanelHolder.getLayout();
				carddLayout.show(CrudPanelHolder, "acajoutpanel");
			}
		});
		
		oui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				canListen=false;
				String requete="delete from voyage where id="+selectedMat;
				if(utility.update(requete))
				{
					utility.update("delete from voyagechauffeur where idVoyage="+selectedMat);
					RepetetiveEvents.infoBox("Voyage Supprimé", "info");
					DefaultTableModel dm =(DefaultTableModel)table.getModel();
					dm.removeRow(table.getSelectedRow());
					table.setRowSelectionInterval(0, 0);
					CardLayout carddLayout = (CardLayout) CrudPanelHolder.getLayout();
					carddLayout.show(CrudPanelHolder, "acajoutpanel");
				}
				else
				{
					RepetetiveEvents.infoBox("Erreur de suppression", "Erreur");
				}
				canListen=true;
			}
		});
		datevoyage.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				fillChauffeur(1);
				fillAutoCar(1);
			}
		});
		datevoyagemod.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				fillChauffeur(2);
				fillAutoCar(2);
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(basePath+"\\ListeVoyage.pdf"));
					doc.open();
					Image img = Image.getInstance(basePath+"\\logob.png");
					img.scaleAbsolute(200, 150);
					img.setAlignment(Image.ALIGN_LEFT);
					doc.add(img);
					doc.add(new Paragraph("                                                                    Liste voyages"));
					doc.add(new Paragraph("   "));

					PdfPTable table = new PdfPTable(4);
					table.setWidthPercentage(100);
					
					PdfPCell cell = new PdfPCell(new Phrase("ID", FontFactory.getFont("Comic Sans MS ", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell);
					
					PdfPCell cell1 = new PdfPCell(new Phrase("DATE VOYAGE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell1);

                                        PdfPCell cell2 = new PdfPCell(new Phrase("ID AUTOCAR", FontFactory.getFont("Comic Sans MS ", 12)));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell2);

					PdfPCell cell3 = new PdfPCell(new Phrase("ID LIGNE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell3);


					//
					String req = "select * from voyage";
					java.sql.PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(req);
					ResultSet rs = stm.executeQuery();
					while(rs.next()){
						PdfPCell cell11 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("id")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell11.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell11);
						
						PdfPCell cell22 = new PdfPCell(new Phrase(new SimpleDateFormat("yyyy/MM/dd").format(rs.getDate("dateVoyage")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell22.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell22);
           
                                                PdfPCell cell33 = new PdfPCell(new Phrase(rs.getString("idAutocar"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell33.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell33);

						PdfPCell cell44 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("idLigne")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell44.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell44);

                                              
					}
					
					
					doc.add(table);
					
					doc.close();
					Desktop.getDesktop().open(new  File(basePath+"\\ListeVoyage.pdf"));
					
					
				} 
				catch (Exception e)
				{
					RepetetiveEvents.infoBox("Document est déjà ouvert"+e.getMessage(), "erreur");
				}
			}
		});
	}

	void fillLigne()
	{
		ResultSet rs=utility.query("select idLigne,depart,arrive from ligne where etat='actif'");
		DefaultComboBoxModel cbm = new DefaultComboBoxModel<>();
		DefaultComboBoxModel cbm2 = new DefaultComboBoxModel<>();
		try
		{
			while(rs.next())
			{
				String value = rs.getString(2) +" - "+rs.getString(3);
				int key =rs.getInt(1);
				cbm.addElement(value);
				cbm2.addElement(value);
				ligneMap.put(value, key);
			}
			ligne.setModel(cbm);
			lignemod.setModel(cbm);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	void fillAutoCar(int index)
	{
		ResultSet rs;
		String date1=new SimpleDateFormat("yyyy/MM/dd").format(datevoyage.getValue());
		String date2=new SimpleDateFormat("yyyy/MM/dd").format(datevoyagemod.getValue());
		if(index==0)
			rs=utility.query("select * from autocar where etat='disponible' and matricule not in(select idAutocar from voyage where  datevoyage = CURDATE())");
		else if(index==1)
			rs=utility.query("select * from autocar where etat='disponible' and matricule not in(select idAutocar from voyage where datevoyage = '"+date1+"')");
		else
			rs=utility.query("select * from autocar where etat='disponible' and matricule not in(select idAutocar from voyage where datevoyage = '"+date2+"')");
		
		DefaultComboBoxModel cbm = new DefaultComboBoxModel<>();
		DefaultComboBoxModel cbm2 = new DefaultComboBoxModel<>();
		try
		{
			while(rs.next())
			{
				String value = rs.getString(1) +" - "+rs.getString(3);
				String key =rs.getString(1);
				if(index==1 || index == 0)
					cbm.addElement(value);
				if(index==2 || index == 0)
					cbm2.addElement(value);
				autocarMap.put(value, key);
			}
			if(index==1 || index == 0)
				autocar.setModel(cbm);
			if(index==2 || index == 0)
				autocarmod.setModel(cbm2);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	void fillChauffeur( int index )
	{
		ResultSet rs;
		String date1=new SimpleDateFormat("yyyy/MM/dd").format(datevoyage.getValue());
		String date2=new SimpleDateFormat("yyyy/MM/dd").format(datevoyagemod.getValue());
		if(index == 0)
			rs=utility.query("select matricule,nomChauffeur,prenom from chauffeur where matricule not in (select matricule from conge where CURRENT_DATE between datedebut and datefin) and matricule not in(select idChauffeur from voyagechauffeur where idVoyage in(select id from voyage where datevoyage=CURDATE())) ");
		else if(index==1)
			rs=utility.query("select matricule,nomChauffeur,prenom from chauffeur where matricule not in (select matricule from conge where '"+date1+"' between datedebut and datefin) and matricule not in(select idChauffeur from voyagechauffeur where idVoyage in(select id from voyage where datevoyage='"+date1+"')) ");
		else
			rs=utility.query("select matricule,nomChauffeur,prenom from chauffeur where matricule not in (select matricule from conge where '"+date2+"' between datedebut and datefin) and matricule in(select idChauffeur from voyagechauffeur where idVoyage not in(select id from voyage where datevoyage='"+date2+"' and id != "+selectedMat+")) ");

		DefaultListModel cbm = new DefaultListModel();
		DefaultListModel cbm2 = new DefaultListModel();
		try
		{
			while(rs.next())
			{
				String value = rs.getString(2) +" - "+rs.getString(3);
				String key =rs.getString(1);
				if(index==1 || index == 0)
					cbm.addElement(value);
				if(index==2 || index == 0)
					cbm2.addElement(value);
				chauffeurMap.put(value, key);
			}
			if(index==1 || index == 0)
				chauffeur.setModel(cbm);
			if(index==2 || index == 0)
				chauffeurmod.setModel(cbm2);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	void selectionChanged()
	{
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && canListen) {
					ArrayList<Integer> indexes=new ArrayList<>();
					for (String key : ligneMap.keySet()) 
					{
						if(ligneMap.get(key)==Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 3).toString()))
						{
							lignemod.setSelectedItem(key);
						}
					}
					for (String key : autocarMap.keySet()) 
					{
						if(autocarMap.get(key).equals(table.getModel().getValueAt(table.getSelectedRow(), 2).toString()))
						{
							autocarmod.setSelectedItem(key);
						}
					}
					try 
					{
						
						selectedMat=table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
						Date date = new SimpleDateFormat("yyyy-MM-dd").parse(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
						datevoyagemod.setValue(date);
					}
					catch (Exception e2) 
					{
						System.out.println(e2);
					}
					
					
					ResultSet rs = utility.query("select idChauffeur from voyagechauffeur where idVoyage='"+selectedMat+"'");
					try {
						while(rs.next())
						{
							for (int i =0 ; i<chauffeurmod.getModel().getSize();i++) 
							{
								if(chauffeurMap.get((String)chauffeurmod.getModel().getElementAt(i)).equals(rs.getString(1)))
								{
									indexes.add(i);
								}
							}
						}
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
					int[] inds = indexes.stream().mapToInt(i->i).toArray();
					chauffeurmod.setSelectedIndices(inds);
					
					String requete="SELECT c.matricule,c.nomChauffeur,c.prenom  FROM chauffeur c,voyagechauffeur v where v.idVoyage="+selectedMat+" and v.idChauffeur = c.matricule";
					try 
					{
						DefaultTableModel dtm = utility.buildTableModel(utility.query(requete));
						if(dtm!=null)
						{
							JTable congetable = new JTable(dtm);
							scrollPane_1.setViewportView(congetable);
						}
						
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
		        }
			}
		});
	}
}
