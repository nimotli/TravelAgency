package GAV.views;

import GAV.misc.ConnectDB;
import GAV.misc.RepetetiveEvents;
import GAV.misc.utility;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
public class AutoCar extends JPanel {
	String basePath = new File("").getAbsolutePath();
	Boolean canListen=true;
	String selectedMat="";
	private JButton ajouter;
	private JButton modifier;
	private JButton supprimer;
	private JPanel ajoutpanel;
	private JPanel modpanel;
	private JPanel suppanel;
	private JPanel CrudPanelHolder;
	private JLabel label_2;
	private JTextField Matriculemod;
	private JLabel label_4;
	private JLabel lblMarque;
	private JLabel label_8;
	private JTextField Marquemod;
	private JTextField Modelmod;
	private JButton modifierbtn;
	private JPanel panel_3;
	private JButton oui;
	private JButton non;
	private JPanel ajoutForm;
	private JPanel ajouttitle;
	private JLabel lblAjout;
	private JLabel label111;
	private JTextField matriculeaj;
	private JLabel lab7827858;
	private JTextField modelaj;
	private JTextField marqueaj;
	private JLabel lab1524254;
	private JLabel label_12;
	private JButton ajouterbtn;
	private JPanel modificationForm;
	private JPanel modificationTitle;
	private JLabel lblModification;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_4;
	private JScrollPane scrollPane_1;
	private JLabel lblPannes;
	private JButton panne;
	private JButton dispo;
	private JButton btnImpression;


	
	
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public AutoCar() throws SQLException 
	{
		initComponent();
		eventHandler();
	}
	
	void initComponent() throws SQLException
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JPanel background = new JPanel();
		background.setBackground(new Color(37, 47, 59));
		add(background);
		background.setLayout(new MigLayout("", "[grow]", "[][259.00,fill][grow]"));
		
		JLabel title = new JLabel("Autocar");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		background.add(title, "cell 0 0");
		
		JPanel TablePanel = new JPanel();
		TablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		background.add(TablePanel, "cell 0 1,growx");
		TablePanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		scrollPane = new JScrollPane();
		TablePanel.add(scrollPane);
		
		table = new JTable() {
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
		
		btnImpression = new JButton("Impression");
		
		btnImpression.setForeground(Color.WHITE);
		btnImpression.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnImpression.setBackground(new Color(60, 179, 113));
		MenuHolder.add(btnImpression, "cell 3 0,growx");
		
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
		
		label111 = new JLabel("Matricule");
		label111.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(label111, "cell 0 0,alignx trailing");
		
		matriculeaj = new JTextField();
		matriculeaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		matriculeaj.setColumns(10);
		ajoutForm.add(matriculeaj, "cell 1 0,growx");
		
		label_12 = new JLabel("           ");
		ajoutForm.add(label_12, "cell 2 0");
		
		lab7827858 = new JLabel("Modele");
		lab7827858.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lab7827858, "cell 3 0,alignx trailing");
		
		modelaj = new JTextField();
		modelaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		modelaj.setColumns(10);
		ajoutForm.add(modelaj, "cell 4 0,growx");
		
		lab1524254 = new JLabel("Marque");
		lab1524254.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajoutForm.add(lab1524254, "cell 0 1,alignx trailing");
		
		marqueaj = new JTextField();
		marqueaj.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		marqueaj.setColumns(10);
		ajoutForm.add(marqueaj, "cell 1 1,growx");
		
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
		modificationForm.setLayout(new MigLayout("", "[65px][339px,grow][33px][65px][339px,grow]", "[25px,grow][25px,grow][25px,grow][27px,grow]"));
		
		label_2 = new JLabel("Matricule");
		modificationForm.add(label_2, "cell 0 0,alignx trailing");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		Matriculemod = new JTextField();
		modificationForm.add(Matriculemod, "cell 1 0,growx,aligny center");
		Matriculemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Matriculemod.setColumns(10);
		
		label_4 = new JLabel("           ");
		modificationForm.add(label_4, "cell 2 0,alignx left,aligny center");
		
		label_8 = new JLabel("Modele");
		modificationForm.add(label_8, "cell 3 0,alignx trailing");
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		Modelmod = new JTextField();
		modificationForm.add(Modelmod, "cell 4 0,growx,aligny center");
		Modelmod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Modelmod.setColumns(10);
		
		lblMarque = new JLabel("Marque");
		modificationForm.add(lblMarque, "cell 0 1,alignx trailing");
		lblMarque.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		Marquemod = new JTextField();
		modificationForm.add(Marquemod, "cell 1 1,growx,aligny center");
		Marquemod.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		Marquemod.setColumns(10);
		
		modifierbtn = new JButton("Modifier");
		
		modificationForm.add(modifierbtn, "cell 4 3,alignx center,aligny center");
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
		RepetetiveEvents.remplirTable("SELECT * FROM autocar", table);
		
		panel_4 = new JPanel();
		TablePanel.add(panel_4);
		panel_4.setLayout(new MigLayout("", "[2px,grow]", "[][2px,grow][]"));
		
		lblPannes = new JLabel("Pannes");
		lblPannes.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_4.add(lblPannes, "cell 0 0");
		
		scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, "cell 0 1,grow");
		
		dispo = new JButton("Rend disponible");
		
		dispo.setForeground(Color.WHITE);
		dispo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		dispo.setBackground(new Color(60, 179, 113));
		panel_4.add(dispo, "flowx,cell 0 2,alignx right");
		
		panne = new JButton("Mettre en panne");
		
		panne.setForeground(Color.WHITE);
		panne.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		panne.setBackground(new Color(60, 179, 113));
		panel_4.add(panne, "cell 0 2,alignx right");
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
				canListen=false;
				if(matriculeaj.getText()!="" && marqueaj.getText()!="" && modelaj.getText()!="")
				{
					if(matriculeaj.getText().length()<=7)
					{
						String requete ="insert into autocar values('"+ matriculeaj.getText() +"','"+ marqueaj.getText() +"','"+ modelaj.getText() +"','disponible')";
						if(utility.insert(requete))
							RepetetiveEvents.infoBox("Autocar ajouté", "Info");
						else
							RepetetiveEvents.infoBox("Autocar non ajouté", "Info");
						RepetetiveEvents.remplirTable("SELECT * FROM autocar", table);
					}
					else
						RepetetiveEvents.infoBox("le champ matricule doit etre inferieur a 8 lettres", "Info");
						
				}
				canListen=true;
			}
		});
		
		
		modifierbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Matriculemod.getText()!="" && Marquemod.getText()!="" && Modelmod.getText()!="")
				{
					if(matriculeaj.getText().length()<=7)
					{	
						String requete ="update autocar set matricule ='"+Matriculemod.getText()+"' , modele='"+Modelmod.getText()+"' , marque='"+Marquemod.getText()+"' where matricule ='"+selectedMat+"'";
						if(utility.insert(requete))
						{
							RepetetiveEvents.infoBox("Autocar modifié", "Info");
							table.setRowSelectionInterval(0, 0);	
						}
							
						else
							RepetetiveEvents.infoBox("Autocar non modifié", "Info");
						table.setRowSelectionInterval(0, 0);
						//RepetetiveEvents.remplirTable("SELECT * FROM autocar", table);
						CardLayout carddLayout = (CardLayout) CrudPanelHolder.getLayout();
						carddLayout.show(CrudPanelHolder, "acajoutpanel");
						canListen=false;
						try 
						{
							DefaultTableModel dtm = utility.buildTableModel(utility.query("SELECT * FROM autocar"));
							table.setModel(dtm);
							
						} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
						canListen=true;
						table.setRowSelectionInterval(0, 0);
					}
					else
						RepetetiveEvents.infoBox("le champ matricule doit etre inferieur a 8 lettres", "Info");
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
			public void mouseClicked(MouseEvent arg0) {
				String requete ="delete from autocar where matricule = '"+selectedMat+"'";
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
		
		panne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()!=-1){
					canListen=false;
					String requete="update autocar set etat='en panne' where matricule='"+selectedMat+"'";
					if(utility.update(requete))
					{
						String message = JOptionPane.showInputDialog(null, "Type d'échec");
						String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
						String reqq="insert into panne values('"+selectedMat+"','"+date+"','"+message+"')";
						utility.insert(reqq);
						try 
						{
							DefaultTableModel dtm = utility.buildTableModel(utility.query("SELECT * FROM autocar"));
							table.setModel(dtm);
							
						} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
						String req="SELECT datep , type FROM panne where autocarId='"+selectedMat+"'";
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
						RepetetiveEvents.infoBox("Etat modifié", "Info");
						
					}
					else
					{
						RepetetiveEvents.infoBox("Etat non modifié", "Info");
					}
					canListen=true;
				}
				else
				{
					RepetetiveEvents.infoBox("Veuillez selectionner un autocar", "Erreur");
				}
			}
		});
		dispo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.getSelectedRow()!=-1){
					canListen=false;
					String requete="update autocar set etat='disponible' where matricule='"+selectedMat+"'";
					if(utility.update(requete))
					{
						try 
						{
							DefaultTableModel dtm = utility.buildTableModel(utility.query("SELECT * FROM autocar"));
							table.setModel(dtm);
							
						} 
						catch (SQLException e1) 
						{
							e1.printStackTrace();
						}
						RepetetiveEvents.infoBox("Etat modifié", "Info");
					}
					else
					{
						RepetetiveEvents.infoBox("Etat non modifié", "Info");
					}
					canListen=true;
				}
				else
				{
					RepetetiveEvents.infoBox("Veuillez selectionner un autocar", "Erreur");
				}
			}
		});
		btnImpression.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
				try {
					PdfWriter.getInstance(doc, new FileOutputStream(basePath+"\\ListeAutoCar.pdf"));
					doc.open();
					Image img = Image.getInstance(basePath+"\\logob.png");
					img.scaleAbsolute(200, 150);
					img.setAlignment(Image.ALIGN_LEFT);
					doc.add(img);
					doc.add(new Paragraph("                                                                    Liste autocars"));
					doc.add(new Paragraph("   "));

					PdfPTable table = new PdfPTable(4);
					table.setWidthPercentage(100);
					
					PdfPCell cell = new PdfPCell(new Phrase("MATRICULE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell);
					
					PdfPCell cell1 = new PdfPCell(new Phrase("MARQUE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell1);

                                        PdfPCell cell2 = new PdfPCell(new Phrase("MODELE", FontFactory.getFont("Comic Sans MS ", 12)));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell2);

                                        PdfPCell cell3 = new PdfPCell(new Phrase("ETAT", FontFactory.getFont("Comic Sans MS ", 12)));
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
					table.addCell(cell3);

					//
					String req = "select * from autocar";
					PreparedStatement stm = ConnectDB.getConnetion().prepareStatement(req);
					ResultSet rs = stm.executeQuery();
					while(rs.next()){
						PdfPCell cell33 = new PdfPCell(new Phrase(rs.getString("matricule"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell33.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell33);
						
						PdfPCell cell14 = new PdfPCell(new Phrase(rs.getString("marque"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell14.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell14);
           
                                                PdfPCell cell15 = new PdfPCell(new Phrase(rs.getString("modele"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell15.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell15);

                                                PdfPCell cell16 = new PdfPCell(new Phrase(rs.getString("etat"), FontFactory.getFont("Comic Sans MS ", 12)));
						cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell16.setBackgroundColor(BaseColor.WHITE);
						table.addCell(cell16);
					}
					
					
					doc.add(table);
					doc.close();
					Desktop.getDesktop().open(new  File(basePath+"\\ListeAutoCar.pdf"));
					
					
				} 
				catch (Exception e)
				{
					RepetetiveEvents.infoBox("Document est déjà ouvert"+e.getMessage(), "erreur");
				}
			}
		});
	}
	
	void selectionChanged()
	{
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()) {
					if(canListen)
					{
						selectedMat=table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
						Matriculemod.setText(table.getModel().getValueAt(table.getSelectedRow(), 0).toString());
						Modelmod.setText(table.getModel().getValueAt(table.getSelectedRow(), 2).toString());
						Marquemod.setText(table.getModel().getValueAt(table.getSelectedRow(), 1).toString());
						
						String req="SELECT datep , type FROM panne where autocarId='"+selectedMat+"'";
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
			}
		});
	}

}
