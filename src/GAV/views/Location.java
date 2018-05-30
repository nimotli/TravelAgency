package GAV.views;
import GAV.misc.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GAV.misc.RepetetiveEvents;
import GAV.misc.utility;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;

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
public class Location extends JPanel {
	String basePath = new File("").getAbsolutePath();
	String selectedMat="";
	boolean canListen=true;
	private HashMap<String , String> autocarMap = new HashMap<String , String>();
	private HashMap<String , String> chauffeurMap = new HashMap<String , String>();
	private JButton ajouter;
	private JButton modifier;
	private JButton supprimer;
	private JPanel ajoutpanel;
	private JPanel modpanel;
	private JPanel suppanel;
	private JPanel CrudPanelHolder;
	private JTextField benificiaremod;
	private JLabel label_4;
	private JButton modifierbtn;
	private JPanel panel_3;
	private JButton oui;
	private JButton non;
	private JPanel ajoutForm;
	private JPanel ajouttitle;
	private JLabel lblAjout;
	private JLabel lblBenificiaire;
	private JTextField benificaire;
	private JLabel label_12;
	private JButton ajouterbtn;
	private JPanel modificationForm;
	private JPanel modificationTitle;
	private JLabel lblModification;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblDateDebut;
	private JLabel lblDateFin;
	private JLabel lblAutocar;
	private JLabel lblChauffeur;
	private JComboBox autocar;
	private JComboBox chauffeur;
	private JSpinner datedebut;
	private JSpinner datefin;
	private JLabel label;
	private JLabel lblDateDebut_1;
	private JLabel lblDateFin_1;
	private JLabel lblAutocar_1;
	private JLabel lblChauffeur_1;
	private JComboBox autocarmod;
	private JComboBox chauffeurmod;
	private JSpinner datedebutmod;
	private JSpinner datefinmod;
	private JButton button;


	
	
	/**
	 * Create the panel.
	 */
	public Location() 
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
		background.setLayout(new MigLayout("", "[grow]", "[][182.00,fill][grow]"));
		
		JLabel title = new JLabel("Location");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		background.add(title, "cell 0 0");
		
		JPanel TablePanel = new JPanel();
		TablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		background.add(TablePanel, "cell 0 1,growx,aligny baseline");
		TablePanel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		TablePanel.add(scrollPane, BorderLayout.CENTER);
		
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
		ajoutForm.setLayout(new MigLayout("", "[][grow][][][grow]", "[grow][grow][grow][grow]"));
		
		lblBenificiaire = new JLabel("Benificiaire");
		lblBenificiaire.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblBenificiaire, "cell 0 0,alignx trailing");
		
		benificaire = new JTextField();
		benificaire.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		benificaire.setColumns(10);
		ajoutForm.add(benificaire, "cell 1 0,growx");
		
		label_12 = new JLabel("           ");
		ajoutForm.add(label_12, "cell 2 0");
		
		lblAutocar = new JLabel("Autocar");
		lblAutocar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblAutocar, "cell 3 0,alignx trailing");
		
		autocar = new JComboBox();
		autocar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(autocar, "cell 4 0,growx");
		
		lblDateDebut = new JLabel("Date debut");
		lblDateDebut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblDateDebut, "cell 0 1");
		
		datedebut = new JSpinner();
		datedebut.setModel(new SpinnerDateModel(new Date(1514332800000L), null, null, Calendar.DAY_OF_YEAR));
		datedebut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(datedebut, "cell 1 1,growx");
		
		lblChauffeur = new JLabel("Chauffeur");
		lblChauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblChauffeur, "cell 3 1,alignx trailing");
		
		chauffeur = new JComboBox();
		chauffeur.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(chauffeur, "cell 4 1,growx");
		
		lblDateFin = new JLabel("Date fin");
		lblDateFin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lblDateFin, "cell 0 2");
		
		datefin = new JSpinner();
		datefin.setModel(new SpinnerDateModel(new Date(1514332800000L), null, null, Calendar.DAY_OF_YEAR));
		datefin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(datefin, "cell 1 2,growx");
		
		ajouterbtn = new JButton("Ajouter");
		
		ajouterbtn.setForeground(Color.WHITE);
		ajouterbtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajouterbtn.setBackground(new Color(60, 179, 113));
		ajoutForm.add(ajouterbtn, "cell 4 3,alignx center");
		
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
		modificationForm.setLayout(new MigLayout("", "[65px][339px,grow][33px][][65px][339px,grow]", "[25px,grow][25px,grow][25px,grow][27px,grow]"));
		
		label = new JLabel("Benificiaire");
		label.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(label, "cell 0 0,alignx trailing");
		
		benificiaremod = new JTextField();
		modificationForm.add(benificiaremod, "cell 1 0,growx,aligny center");
		benificiaremod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		benificiaremod.setColumns(10);
		
		label_4 = new JLabel("           ");
		modificationForm.add(label_4, "cell 2 0,alignx left,aligny center");
		
		lblAutocar_1 = new JLabel("Autocar");
		lblAutocar_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(lblAutocar_1, "cell 3 0");
		
		autocarmod = new JComboBox();
		autocarmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(autocarmod, "cell 5 0,growx");
		
		lblDateDebut_1 = new JLabel("Date debut");
		lblDateDebut_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(lblDateDebut_1, "cell 0 1");
		
		datedebutmod = new JSpinner();
		datedebutmod.setModel(new SpinnerDateModel(new Date(1514332800000L), null, null, Calendar.DAY_OF_YEAR));
		datedebutmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(datedebutmod, "cell 1 1,growx");
		
		lblChauffeur_1 = new JLabel("Chauffeur");
		lblChauffeur_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(lblChauffeur_1, "cell 3 1");
		
		chauffeurmod = new JComboBox();
		chauffeurmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(chauffeurmod, "cell 5 1,growx");
		
		lblDateFin_1 = new JLabel("Date fin");
		lblDateFin_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(lblDateFin_1, "cell 0 2");
		
		datefinmod = new JSpinner();
		datefinmod.setModel(new SpinnerDateModel(new Date(1514332800000L), null, null, Calendar.DAY_OF_YEAR));
		datefinmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modificationForm.add(datefinmod, "cell 1 2,growx");
		
		modifierbtn = new JButton("Modifier");
		
		modificationForm.add(modifierbtn, "cell 5 3,alignx center,aligny center");
		modifierbtn.setForeground(Color.WHITE);
		modifierbtn.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modifierbtn.setBackground(new Color(60, 179, 113));
		
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
		
		
		RepetetiveEvents.remplirTable("SELECT * FROM location", table);
	}
	void eventHandler()
	{
		RepetetiveEvents.CrudButtonsHandler(ajouter,"acajoutpanel",CrudPanelHolder,table,1);
		RepetetiveEvents.CrudButtonsHandler(modifier,"acmodpanel",CrudPanelHolder,table,2);
		RepetetiveEvents.CrudButtonsHandler(supprimer,"acsuppanel",CrudPanelHolder,table,3);
		fillAutoCar(0);
		fillChauffeur(0);
		selectionChanged();
		ajouterbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				canListen=false;
				String date1=new SimpleDateFormat("yyyy/MM/dd").format(datedebut.getValue());
				String date2=new SimpleDateFormat("yyyy/MM/dd").format(datefin.getValue());
				String requete="insert into location (benificiaire ,dateDebut,dateFin,autocarId,ChauffeurId) values('"+benificaire.getText()+"','"+date1+"','"+date2+"','"+autocarMap.get(autocar.getSelectedItem())+"','"+chauffeurMap.get(chauffeur.getSelectedItem())+"')";
				if(utility.insert(requete))
				{
					RepetetiveEvents.infoBox("Location ajouté", "info");
					RepetetiveEvents.remplirTable("SELECT * FROM location", table);
				}
				else
				{
					RepetetiveEvents.infoBox("Location non ajouté", "erreur");
				}
				canListen=true;
			}
		});
		modifierbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					canListen=false;
					String date1=new SimpleDateFormat("yyyy/MM/dd").format(datedebutmod.getValue());
					String date2=new SimpleDateFormat("yyyy/MM/dd").format(datefinmod.getValue());
					String requete="Update location set benificiaire='"+benificiaremod.getText()+"',datedebut='"+date1+"' ,datefin='"+date2+"' ,autocarId ='"+autocarMap.get(autocarmod.getSelectedItem())+"' , chauffeurId='"+chauffeurMap.get(chauffeurmod.getSelectedItem())+"' Where id="+selectedMat;
					if(utility.insert(requete))
					{
						CardLayout carddLayoutt = (CardLayout) CrudPanelHolder.getLayout();
						carddLayoutt.show(CrudPanelHolder, "acajoutpanel");
						RepetetiveEvents.infoBox("Location modifié", "info");
						RepetetiveEvents.remplirTable("SELECT * FROM location", table);
					}
					else
					{
						RepetetiveEvents.infoBox("Location non modifié", "erreur");
					}
					canListen=true;
			}
		});
		
		datedebut.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				fillChauffeur(1);
				fillAutoCar(1);
			}
		});
		datefin.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				fillChauffeur(1);
				fillAutoCar(1);
			}
		});
		datedebutmod.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				fillChauffeur(2);
				fillAutoCar(2);
			}
		});
		datefinmod.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				fillChauffeur(2);
				fillAutoCar(2);
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
				String requete="delete from location where id="+selectedMat;
				if(utility.update(requete))
				{
					RepetetiveEvents.infoBox("Location Supprimé", "info");
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
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(basePath+"\\ListeLocation.pdf"));
					doc.open();
					Image img = Image.getInstance(basePath+"\\logob.png");
					img.scaleAbsolute(200, 150);
					img.setAlignment(Image.ALIGN_LEFT);
					doc.add(img);
					doc.add(new Paragraph("                                                                    Liste locations"));
					doc.add(new Paragraph("   "));

					PdfPTable table = new PdfPTable(6);
					table.setWidthPercentage(100);
					
					PdfPCell cell = new PdfPCell(new Phrase("ID", FontFactory.getFont("Comic Sans MS ", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell);
					
					PdfPCell cell1 = new PdfPCell(new Phrase("BENIFICIAIRE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell1);

                                        PdfPCell cell2 = new PdfPCell(new Phrase("DATE DEBUT", FontFactory.getFont("Comic Sans MS ", 12)));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell2);

					PdfPCell cell3 = new PdfPCell(new Phrase("DATE FIN", FontFactory.getFont("Comic Sans MS ", 12)));
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell3);

                                        PdfPCell cell4 = new PdfPCell(new Phrase("ID AUTOCAR", FontFactory.getFont("Comic Sans MS ", 12)));
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell4);

                                        PdfPCell cell5 = new PdfPCell(new Phrase("ID CHAUFFEUR", FontFactory.getFont("Comic Sans MS ", 12)));
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell5);

					//
					String req = "select * from location";
					java.sql.PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(req);
					ResultSet rs = stm.executeQuery();
					while(rs.next()){
						PdfPCell cell11 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("id")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell11.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell11);
						
						PdfPCell cell22 = new PdfPCell(new Phrase(rs.getString("benificiaire"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell22.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell22);
           
                                                PdfPCell cell33 = new PdfPCell(new Phrase(new SimpleDateFormat("yyyy/MM/dd").format(rs.getDate("dateDebut")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell33.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell33);

						PdfPCell cell44 = new PdfPCell(new Phrase(new SimpleDateFormat("yyyy/MM/dd").format(rs.getDate("dateFin")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell44.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell44);


                                                PdfPCell cell66 = new PdfPCell(new Phrase(rs.getString("chauffeurId"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell66.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell66);
						
						PdfPCell cell55 = new PdfPCell(new Phrase(rs.getString("autocarId"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell55.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell66);
					}
					
					
					doc.add(table);
					
					doc.close();
					Desktop.getDesktop().open(new  File(basePath+"\\ListeLocation.pdf"));
					
					
				}
				catch (Exception e) 
				{
					RepetetiveEvents.infoBox("Document est déjà ouvert"+e.getMessage(), "erreur");
				}
			}
		});
	}
	
	
	void fillAutoCar(int index)
	{
		ResultSet rs;
		String date1=new SimpleDateFormat("yyyy/MM/dd").format(datedebut.getValue());
		String date2=new SimpleDateFormat("yyyy/MM/dd").format(datefin.getValue());
		String date3=new SimpleDateFormat("yyyy/MM/dd").format(datedebutmod.getValue());
		String date4=new SimpleDateFormat("yyyy/MM/dd").format(datefinmod.getValue());
		if(index==0)
			rs=utility.query("select * from autocar where etat='disponible' and matricule not in(select idAutocar from voyage where  datevoyage = CURDATE())");
		else if(index==1)
			rs=utility.query("select * from autocar where etat='disponible' and matricule not in(select idAutocar from voyage where datevoyage between '"+date1+"' and '"+date2+"')");
		else
			rs=utility.query("select * from autocar where etat='disponible' and matricule not in(select idAutocar from voyage where datevoyage between '"+date3+"' and '"+date4+"')");
		
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
		String date1=new SimpleDateFormat("yyyy/MM/dd").format(datedebut.getValue());
		String date2=new SimpleDateFormat("yyyy/MM/dd").format(datefin.getValue());
		String date3=new SimpleDateFormat("yyyy/MM/dd").format(datedebutmod.getValue());
		String date4=new SimpleDateFormat("yyyy/MM/dd").format(datefinmod.getValue());
		if(index == 0)
			rs=utility.query("select matricule,nomChauffeur,prenom from chauffeur where matricule not in (select matricule from conge where CURRENT_DATE between datedebut and datefin) ");
		else if(index==1)
			rs=utility.query("select matricule,nomChauffeur,prenom from chauffeur where matricule not in (select matricule from conge where (datedebut between '"+date1+"' and '"+date2+"') or (datefin between '"+date1+"' and '"+date2+"')) ");
		else
			rs=utility.query("select matricule,nomChauffeur,prenom from chauffeur where matricule not in (select matricule from conge where (datedebut between '"+date3+"' and '"+date4+"') or (datefin between '"+date3+"' and '"+date4+"')) ");

		DefaultComboBoxModel cbm = new DefaultComboBoxModel();
		DefaultComboBoxModel cbm2 = new DefaultComboBoxModel();
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
			public void valueChanged(ListSelectionEvent e) 
			{
				if (!e.getValueIsAdjusting() && canListen) {
					
					for (String key : autocarMap.keySet()) 
					{
						if(autocarMap.get(key).equals(table.getModel().getValueAt(table.getSelectedRow(), 4).toString()))
						{
							autocarmod.setSelectedItem(key);
						}
					}
					for (String key : chauffeurMap.keySet()) 
					{
						if(chauffeurMap.get(key).equals(table.getModel().getValueAt(table.getSelectedRow(), 5).toString()))
						{
							chauffeurmod.setSelectedItem(key);
						}
					}
					try 
					{
						
						selectedMat=table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
						Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
						Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
						datedebutmod.setValue(date1);
						datefinmod.setValue(date2);
						benificiaremod.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
					}
					catch (Exception e2) 
					{
						System.out.println(e2);
					}
					
					
		        }
			}
		});
	}
}
