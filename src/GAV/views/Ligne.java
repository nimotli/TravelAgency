package GAV.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import GAV.misc.*;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GAV.misc.ConnectDB;
import GAV.misc.RepetetiveEvents;
import GAV.misc.utility;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;

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
import javax.swing.ListSelectionModel;

public class Ligne extends JPanel {
	String basePath = new File("").getAbsolutePath();
	ArrayList<String> escaleList=new ArrayList<String>();
	private String selectedMat;
	private JButton ajouter;
	private JButton modifier;
	private JButton supprimer;
	private JPanel ajoutpanel;
	private JPanel modpanel;
	private JPanel suppanel;
	private JPanel CrudPanelHolder;
	private JPanel panel_3;
	private JButton oui;
	private JButton non;
	private JPanel ajoutForm;
	private JPanel ajouttitle;
	private JLabel lblAjout;
	private JButton next1aj;
	private JButton next1mod;
	private JPanel modificationForm;
	private JPanel modificationTitle;
	private JLabel lblModification;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel etap1;
	private JPanel etap2;
	private JPanel etap1Panel;
	private JLabel lblHeureDeDepart;
	private JLabel lblKilometrage;
	private JLabel lblDureeDeRepot;
	private JLabel lblDuree;
	private JLabel label_14;
	private JPanel etap2Panel;
	private JLabel lblDureeDimmobilisation;
	private JSpinner immobilisationaj;
	private JSpinner attentaj;
	private JSpinner repotaj;
	private JSpinner kilometrageaj;
	private JSpinner heuredepaj;
	private JSpinner mindepaj;
	private JButton retouraj;
	private JList escaleaj;
	private JComboBox departaj;
	private JComboBox arriveaj;
	private JButton Valideraj;
	
	private JSpinner immobilisationmod;
	private JSpinner attentmod;
	private JSpinner repotmod;
	private JSpinner kilometragemod;
	private JSpinner heuredepmod;
	private JSpinner mindepmod;
	private JPanel etap3Panmod;
	private JButton retourmod;
	private JList escalemod;
	private JComboBox departmod;
	private JComboBox arrivemod;
	private JButton Validermod;
	private JPanel etap1modPanel;
	private JPanel etap2modPanel;
	private JPanel panel_4;
	private JScrollPane scrollPane_1;
	private JLabel lblEscale;
	private JLabel lblEtat;
	private JComboBox etat;
	private JButton btnAjouterEscal;
	private JButton button;


	
	
	/**
	 * Create the panel.
	 */
	public Ligne() 
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
		background.setLayout(new MigLayout("", "[grow]", "[][194.00,fill][grow]"));
		
		JLabel title = new JLabel("Ligne");
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
		MenuHolder.setLayout(new MigLayout("", "[grow][grow][grow][grow,fill]", "[]"));
		
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
		
		etap1Panel = new JPanel();
		ajoutForm.add(etap1Panel, "etap1");
		etap1Panel.setLayout(new MigLayout("", "[][grow][][][grow]", "[grow][grow][grow]"));
		
		lblHeureDeDepart = new JLabel("Heure de depart");
		lblHeureDeDepart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(lblHeureDeDepart, "flowy,cell 0 0,alignx trailing");
		
		heuredepaj = new JSpinner();
		heuredepaj.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		heuredepaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(heuredepaj, "flowx,cell 1 0,growx");
		
		label_14 = new JLabel("           ");
		etap1Panel.add(label_14, "cell 2 0");
		
		lblDuree = new JLabel("Duree d'attent");
		lblDuree.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(lblDuree, "cell 3 0,alignx trailing");
		
		attentaj = new JSpinner();
		attentaj.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		attentaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(attentaj, "cell 4 0,growx");
		
		lblKilometrage = new JLabel("Kilometrage");
		lblKilometrage.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(lblKilometrage, "cell 0 1,alignx trailing");
		
		kilometrageaj = new JSpinner();
		kilometrageaj.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		kilometrageaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(kilometrageaj, "cell 1 1,growx");
		
		lblDureeDimmobilisation = new JLabel("Duree d'immobilisation");
		lblDureeDimmobilisation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(lblDureeDimmobilisation, "cell 3 1,alignx trailing");
		
		immobilisationaj = new JSpinner();
		immobilisationaj.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		immobilisationaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(immobilisationaj, "cell 4 1,growx");
		
		lblDureeDeRepot = new JLabel("Duree de repot");
		lblDureeDeRepot.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(lblDureeDeRepot, "cell 0 2,alignx trailing");
		
		repotaj = new JSpinner();
		repotaj.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		repotaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(repotaj, "cell 1 2,growx");
		
		next1aj = new JButton("Suivant");
		
		
		etap1Panel.add(next1aj, "cell 4 2,alignx center");
		next1aj.setForeground(Color.WHITE);
		next1aj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		next1aj.setBackground(new Color(60, 179, 113));
		
		mindepaj = new JSpinner();
		mindepaj.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		mindepaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1Panel.add(mindepaj, "cell 1 0,growx");
		
		
		
		etap2Panel = new JPanel();
		ajoutForm.add(etap2Panel, "etap2");
		etap2Panel.setLayout(new MigLayout("", "[][grow][][][grow]", "[grow][grow][grow]"));
		
		JLabel lblDepart = new JLabel("Depart");
		lblDepart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2Panel.add(lblDepart, "cell 0 0,alignx trailing");
		
		departaj = new JComboBox();
		departaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2Panel.add(departaj, "cell 1 0,growx");
		
		JLabel label_1 = new JLabel("           ");
		etap2Panel.add(label_1, "cell 2 0");
		
		JLabel lblArrive = new JLabel("Arrive");
		lblArrive.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2Panel.add(lblArrive, "cell 3 0,alignx trailing");
		
		arriveaj = new JComboBox();
		arriveaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2Panel.add(arriveaj, "cell 4 0,growx");
		
		JLabel lblEscales = new JLabel("Escales");
		lblEscales.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2Panel.add(lblEscales, "cell 0 1");
		
		escaleaj = new JList();
		escaleaj.setBorder(new LineBorder(new Color(0, 0, 0)));
		escaleaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2Panel.add(escaleaj, "cell 1 1,grow");
		
		retouraj = new JButton("Retour");
		
		retouraj.setForeground(Color.WHITE);
		retouraj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		retouraj.setBackground(new Color(60, 179, 113));
		etap2Panel.add(retouraj, "flowx,cell 4 2,alignx center");
		
		Valideraj = new JButton("Valider");
		
		Valideraj.setForeground(Color.WHITE);
		Valideraj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Valideraj.setBackground(new Color(60, 179, 113));
		etap2Panel.add(Valideraj, "cell 4 2");
		
		ajouttitle = new JPanel();
		ajouttitle.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		ajoutpanel.add(ajouttitle, BorderLayout.NORTH);
		ajouttitle.setLayout(new BorderLayout(0, 0));
		
		lblAjout = new JLabel("Ajout");
		lblAjout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjout.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajouttitle.add(lblAjout, BorderLayout.NORTH);
		
		JPanel etap = new JPanel();
		etap.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		ajouttitle.add(etap, BorderLayout.CENTER);
		etap.setLayout(new MigLayout("", "[grow][grow]", "[grow]"));
		
		etap1 = new JPanel();
		etap1.setBackground(new Color(60, 179, 113));
		etap.add(etap1, "cell 0 0,growx");
		etap1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEtap = new JLabel("Etap 1");
		lblEtap.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtap.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblEtap.setForeground(new Color(255, 255, 255));
		etap1.add(lblEtap, BorderLayout.CENTER);
		
		etap2 = new JPanel();
		etap2.setBackground(new Color(60, 179, 113));
		etap.add(etap2, "cell 1 0,grow");
		etap2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEtap_1 = new JLabel("Etap 2");
		lblEtap_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtap_1.setForeground(Color.WHITE);
		lblEtap_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		etap2.add(lblEtap_1, BorderLayout.CENTER);
		
		modpanel = new JPanel();
		modpanel.setBackground(UIManager.getColor("CheckBox.background"));
		CrudPanelHolder.add(modpanel, "acmodpanel");
		modpanel.setLayout(new BorderLayout(0, 0));
		
		modificationForm = new JPanel();
		modpanel.add(modificationForm);
		modificationForm.setLayout(new CardLayout(0, 0));
		//////////////////////////HERERERERERERER
		etap1modPanel = new JPanel();
		modificationForm.add(etap1modPanel, "etap1");
		etap1modPanel.setLayout(new MigLayout("", "[][grow][][][grow]", "[grow][grow][grow]"));
		
		lblHeureDeDepart = new JLabel("Heure de depart");
		lblHeureDeDepart.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(lblHeureDeDepart, "flowy,cell 0 0,alignx trailing");
		
		heuredepmod = new JSpinner();
		heuredepmod.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		heuredepmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(heuredepmod, "flowx,cell 1 0,growx");
		
		label_14 = new JLabel("           ");
		etap1modPanel.add(label_14, "cell 2 0");
		
		lblDuree = new JLabel("Duree d'attent");
		lblDuree.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(lblDuree, "cell 3 0,alignx trailing");
		
		attentmod = new JSpinner();
		attentmod.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		attentmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(attentmod, "cell 4 0,growx");
		
		lblKilometrage = new JLabel("Kilometrage");
		lblKilometrage.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(lblKilometrage, "cell 0 1,alignx trailing");
		
		kilometragemod = new JSpinner();
		kilometragemod.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		kilometragemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(kilometragemod, "cell 1 1,growx");
		
		lblDureeDimmobilisation = new JLabel("Duree d'immobilisation");
		lblDureeDimmobilisation.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(lblDureeDimmobilisation, "cell 3 1,alignx trailing");
		
		immobilisationmod = new JSpinner();
		immobilisationmod.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		immobilisationmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(immobilisationmod, "cell 4 1,growx");
		
		lblDureeDeRepot = new JLabel("Duree de repot");
		lblDureeDeRepot.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(lblDureeDeRepot, "cell 0 2,alignx trailing");
		
		repotmod = new JSpinner();
		repotmod.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		repotmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(repotmod, "cell 1 2,growx");
		
		next1mod = new JButton("Suivant");
		
		etap1modPanel.add(next1mod, "cell 4 2,alignx center");
		next1mod.setForeground(Color.WHITE);
		next1mod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		next1mod.setBackground(new Color(60, 179, 113));
		
		mindepmod = new JSpinner();
		mindepmod.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		mindepmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap1modPanel.add(mindepmod, "cell 1 0,growx");
		
		//herehrehrhehreh
		
		
		etap2modPanel = new JPanel();
		modificationForm.add(etap2modPanel, "etap2");
		etap2modPanel.setLayout(new MigLayout("", "[][grow][][][grow]", "[grow][grow][grow]"));
		
		JLabel lblDepartmod = new JLabel("Depart");
		lblDepartmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(lblDepartmod, "cell 0 0,alignx trailing");
		
		departmod = new JComboBox();
		departmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(departmod, "cell 1 0,growx");
		
		JLabel label_1mod = new JLabel("           ");
		etap2modPanel.add(label_1mod, "cell 2 0");
		
		JLabel lblArrivemod = new JLabel("Arrive");
		lblArrivemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(lblArrivemod, "cell 3 0,alignx trailing");
		
		arrivemod = new JComboBox();
		arrivemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(arrivemod, "cell 4 0,growx");
		
		JLabel lblEscalesmod = new JLabel("Escales");
		lblEscalesmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(lblEscalesmod, "cell 0 1");
		
		escalemod = new JList();
		escalemod.setBorder(new LineBorder(new Color(0, 0, 0)));
		escalemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(escalemod, "cell 1 1,grow");
		
		lblEtat = new JLabel("Etat");
		lblEtat.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(lblEtat, "cell 3 1,alignx trailing");
		
		etat = new JComboBox();
		etat.setModel(new DefaultComboBoxModel(new String[] {"actif", "inactif"}));
		etat.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		etap2modPanel.add(etat, "cell 4 1,growx");
		
		retourmod = new JButton("Retour");

		
		retourmod.setForeground(Color.WHITE);
		retourmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		retourmod.setBackground(new Color(60, 179, 113));
		etap2modPanel.add(retourmod, "flowx,cell 4 2,alignx center");
		
		Validermod = new JButton("Valider");
		
		
		Validermod.setForeground(Color.WHITE);
		Validermod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Validermod.setBackground(new Color(60, 179, 113));
		etap2modPanel.add(Validermod, "cell 4 2");
		
		
		
		
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
		//RepetetiveEvents.remplirTable("SELECT * FROM ligne", table);
		fillMainTable();
		panel_4 = new JPanel();
		TablePanel.add(panel_4);
		panel_4.setLayout(new MigLayout("", "[2px,grow]", "[][2px,grow][]"));
		
		lblEscale = new JLabel("Escale");
		lblEscale.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_4.add(lblEscale, "cell 0 0");
		
		scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, "cell 0 1,grow");
		
		btnAjouterEscal = new JButton("Ajouter Escale");
		
		btnAjouterEscal.setForeground(Color.WHITE);
		btnAjouterEscal.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnAjouterEscal.setBackground(new Color(60, 179, 113));
		panel_4.add(btnAjouterEscal, "cell 0 2,alignx right");
	}
	void eventHandler()
	{
		RepetetiveEvents.CrudButtonsHandler(ajouter,"acajoutpanel",CrudPanelHolder,table,1);
		RepetetiveEvents.CrudButtonsHandler(modifier,"acmodpanel",CrudPanelHolder,table,2);
		RepetetiveEvents.CrudButtonsHandler(supprimer,"acsuppanel",CrudPanelHolder,table,3);
		fillEscaleList();
		fillDepartArrive();
		selectionChanged();
		retouraj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(true)
				{
					CardLayout carddLayout = (CardLayout) ajoutForm.getLayout();
					carddLayout.show(ajoutForm, "etap1");
				}
			}
		});
		next1aj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout carddLayout = (CardLayout) ajoutForm.getLayout();
				carddLayout.show(ajoutForm, "etap2");
			}
		});
		
		Valideraj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//int heureArrive = (int)heuredepaj.getValue() + (int)immobilisationaj.getValue() + (int)repotaj.getValue()+(int)attentaj.getValue();
				int timetoinsert=Integer.parseInt( heuredepaj.getValue().toString())*60+Integer.parseInt(mindepaj.getValue().toString());
				String requete="INSERT INTO ligne (heureDepart,kilometrage,dureeAttente,dureeRepos,dureeImmobilisation,depart,arrive) values("+timetoinsert+","+kilometrageaj.getValue()+","+attentaj.getValue()+","+repotaj.getValue()+","+immobilisationaj.getValue()+",'"+departaj.getSelectedItem()+"','"+arriveaj.getSelectedItem()+"')";
				utility.insert(requete);
				if(escaleaj.getSelectedIndices().length > 0)
				{
					
					ResultSet rs = utility.query("select max(idLigne) from ligne");
					RepetetiveEvents.infoBox("Ligne ajouté", "info");
					int ligneId=-1;
					try 
					{
						while (rs.next())
						{
							ligneId = rs.getInt(1);
						}
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					for (Object  obj: escaleaj.getSelectedValues()) 
					{
						String req = "INSERT INTO escaleLigne values("+ligneId+",'"+(String)obj+"')";
						utility.insert(req);
					}
				}
				CardLayout carddLayout = (CardLayout) ajoutForm.getLayout();
				carddLayout.show(ajoutForm, "etap1");
				//RepetetiveEvents.remplirTable("SELECT * FROM ligne", table);
				fillMainTable();
			}
		});
		
		retourmod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CardLayout carddLayout = (CardLayout) modificationForm.getLayout();
				carddLayout.show(modificationForm, "etap1");
			}
		});
		next1mod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(true)
				{
					CardLayout carddLayout = (CardLayout) modificationForm.getLayout();
					carddLayout.show(modificationForm, "etap2");
				}
			}
		});
		Validermod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int timetoinsert=Integer.parseInt( heuredepmod.getValue().toString())*60+Integer.parseInt(mindepmod.getValue().toString());
				String requete ="update ligne set heureDepart="+ timetoinsert+",kilometrage="+ kilometragemod.getValue() +",dureeAttente="+ attentmod.getValue() +",dureeRepos="+ repotmod.getValue() +",dureeImmobilisation="+ immobilisationmod.getValue() +",depart='"+ departmod.getSelectedItem() +"',arrive='"+ arrivemod.getSelectedItem() +"' , etat ='"+etat.getSelectedItem()+"'where idLigne="+selectedMat;
				if(utility.update(requete))
				{
					
					utility.update("delete from escaleligne where idLigne="+selectedMat);
					if(escalemod.getSelectedIndices().length > 0)
					{
						for (Object  obj: escalemod.getSelectedValues()) 
						{
							String req = "INSERT INTO escaleLigne values("+selectedMat+",'"+(String)obj+"')";
							utility.insert(req);
						}
					}
					
					RepetetiveEvents.infoBox("Ligne modifié", "info");
					CardLayout carddLayout = (CardLayout) modificationForm.getLayout();
					carddLayout.show(modificationForm, "etap1");
					CardLayout carddLayoutt = (CardLayout) CrudPanelHolder.getLayout();
					carddLayoutt.show(CrudPanelHolder, "acajoutpanel");
					//RepetetiveEvents.remplirTable("SELECT * FROM ligne", table);
					fillMainTable();
				}
				else
				{
					RepetetiveEvents.infoBox("Erreur de modification", "Erreur");
				}
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
				String requete="delete from ligne where idLigne="+selectedMat;
				if(utility.update(requete))
				{
					utility.update("delete from escaleligne where idLigne="+selectedMat);
					RepetetiveEvents.infoBox("Ligne Supprimé", "info");
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
			}
		});
		btnAjouterEscal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String message = JOptionPane.showInputDialog(null, "Nom d'escale");
				if(message!="")
				{
					String requete ="insert into escale(nom) values ('"+message+"')";
					if(utility.insert(requete))
					{
						RepetetiveEvents.infoBox("Escale ajouté", "info");
						fillEscaleList();
					}
					else
					{
						RepetetiveEvents.infoBox("Escale non ajouté", "Erreur");
					}
				}
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(basePath+"\\ListeLigne.pdf"));
					doc.open();
					Image img = Image.getInstance(basePath+"\\logob.png");
					img.scaleAbsolute(200, 150);
					img.setAlignment(Image.ALIGN_LEFT);
					doc.add(img);
					doc.add(new Paragraph("                                                                    Liste lignes"));
					doc.add(new Paragraph("   "));

					PdfPTable table = new PdfPTable(9);
					table.setWidthPercentage(100);
					
					PdfPCell cell = new PdfPCell(new Phrase("ID LIGNE", FontFactory.getFont("Arial", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell);
					
					PdfPCell cell1 = new PdfPCell(new Phrase("HEURE DEPART", FontFactory.getFont("Arial", 12)));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell1);

                                        PdfPCell cell2 = new PdfPCell(new Phrase("KILOMETRAGE", FontFactory.getFont("Arial", 12)));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell2);
                                        
                                         PdfPCell cell3 = new PdfPCell(new Phrase("DUREE ATTENTE", FontFactory.getFont("Arial", 12)));
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell3);

          				PdfPCell cell4 = new PdfPCell(new Phrase("DUREE REPOS", FontFactory.getFont("Arial", 12)));
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell4);
					
					PdfPCell cell5 = new PdfPCell(new Phrase("DUREE IMMOBILISATION", FontFactory.getFont("Arial", 12)));
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell5);

					PdfPCell cell6 = new PdfPCell(new Phrase("DEPART", FontFactory.getFont("Arial", 12)));
					cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell6);

					PdfPCell cell7 = new PdfPCell(new Phrase("ARRIVE", FontFactory.getFont("Arial", 12)));
					cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell7.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell7);

                                        PdfPCell cell8 = new PdfPCell(new Phrase("ETAT", FontFactory.getFont("Comic Sans MS ", 12)));
					cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell8.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell8);
                                        
					//
					String req = "select * from ligne";
					java.sql.PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(req);
					ResultSet rs = stm.executeQuery();
					while(rs.next()){
						PdfPCell cell11 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("idLigne")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell11.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell11);
						
						PdfPCell cell22 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("heureDepart")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell22.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell22);
           
                                                PdfPCell cell33 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("kilometrage")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell33.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell33);

						PdfPCell cell44 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("dureeAttente")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell44.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell44);

						PdfPCell cell55 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("dureeRepos")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell55.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell55);

						PdfPCell cell66 = new PdfPCell(new Phrase(String.valueOf(rs.getInt("dureeImmobilisation")), FontFactory.getFont("Comic Sans MS ", 12)));
						cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell66.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell66);

						PdfPCell cell77 = new PdfPCell(new Phrase(rs.getString("depart"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell77.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell77);

						PdfPCell cell88 = new PdfPCell(new Phrase(rs.getString("arrive"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell88.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell88);

                                               PdfPCell cell99 = new PdfPCell(new Phrase(rs.getString("etat"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell99.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell99);


					}
					
					
					doc.add(table);
					
					doc.close();
					Desktop.getDesktop().open(new  File(basePath+"\\ListeLigne.pdf"));
					
					
				} 
				catch (Exception e) 
				{
					RepetetiveEvents.infoBox("Document est déjà ouvert"+e.getMessage(), "erreur");
				}
			}
		});
	}

	void fillEscaleList()
	{
		ResultSet rs=utility.query("Select * from escale");
		DefaultListModel<Object> listModel = new DefaultListModel();
		try
		{
			while (rs.next())
			{
				listModel.addElement(rs.getString(2));
				escaleList.add(rs.getString(2));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		escaleaj.setModel(listModel);
		escalemod.setModel(listModel);
	}
	void fillDepartArrive()
	{
		ResultSet rs=utility.query("Select * from agence");
		DefaultComboBoxModel<Object> cm1,cm2,cm3,cm4;
		cm1 = new DefaultComboBoxModel();
		cm2 = new DefaultComboBoxModel();
		cm3 = new DefaultComboBoxModel();
		cm4 = new DefaultComboBoxModel();
		try
		{
			while (rs.next())
			{
				cm1.addElement(rs.getString(2));
				cm2.addElement(rs.getString(2));
				cm3.addElement(rs.getString(2));
				cm4.addElement(rs.getString(2));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		departaj.setModel(cm1);
		arriveaj.setModel(cm2);
		departmod.setModel(cm3);
		arrivemod.setModel(cm4);
		
	}
	
	void fillMainTable()
	{
		 try
		 {
			 DefaultTableModel dtm = new DefaultTableModel();
			  Statement stm = ConnectDB.getConnetion().createStatement();
			  ResultSet rs = stm.executeQuery("select * from ligne");
			  ResultSetMetaData metaData = rs.getMetaData();

			    Vector<String> columnNames = new Vector<String>();
			    int columnCount = metaData.getColumnCount();
			    for (int column = 1; column <= columnCount; column++) {
			        columnNames.add(metaData.getColumnName(column));
			    }

			    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			    while (rs.next()) {
			        Vector<Object> vector = new Vector<Object>();
			        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
			        	if(columnIndex != 2)
			        		vector.add(rs.getObject(columnIndex));
			        	else
			        	{
			        		int time=rs.getInt(2),hours=0,min=0;
							hours = time/60;
							min=time-hours*60;
							String timeString=hours +":"+min;
				        	vector.add(timeString);
			        	}
			        }
			        data.add(vector);
			    }

			    dtm= new DefaultTableModel(data, columnNames);
			  table.setModel(dtm);
		} 
		 catch (Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
	}
	void selectionChanged()
	{
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting() ) {
					String requete="SELECT dateDebut,dateFin,congetype  FROM conge where matricule='"+selectedMat+"'";
					ArrayList<Integer> indexes=new ArrayList<>();
					try 
					{
						selectedMat=table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
						String timeString=table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
						int hours=0,min=0;
						hours=Integer.parseInt(timeString.substring(0, timeString.indexOf(":")));
						min=Integer.parseInt(timeString.substring(timeString.indexOf(":")+1));
						heuredepmod.setValue(hours);
						mindepmod.setValue(min);
						kilometragemod.setValue(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 2).toString()));
						attentmod.setValue(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 3).toString()));
						repotmod.setValue(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 4).toString()));
						immobilisationmod.setValue(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 5).toString()));
						departmod.setSelectedItem(table.getModel().getValueAt(table.getSelectedRow(), 6).toString());
						arrivemod.setSelectedItem(table.getModel().getValueAt(table.getSelectedRow(), 7).toString());
						etat.setSelectedItem(table.getModel().getValueAt(table.getSelectedRow(), 8).toString());
					}
					catch (Exception e2) 
					{
						System.out.println(e2);
					}
					
					
					ResultSet rs = utility.query("select nomEscale from escaleligne where idligne="+selectedMat);
					try {
						while(rs.next())
						{
							for (int i =0 ; i<escalemod.getModel().getSize();i++) 
							{
								if(((String)escalemod.getModel().getElementAt(i)).equals(rs.getString(1)))
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
					escalemod.setSelectedIndices(inds);;
					String req="SELECT nomEscale as 'Escale' FROM escaleligne where idLigne="+selectedMat;
					try 
					{
						DefaultTableModel dtm = utility.buildTableModel(utility.query(req));
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
