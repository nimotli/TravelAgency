package GAV.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GAV.misc.RepetetiveEvents;
import GAV.misc.utility;
import GAV.ressources.chauffeur;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class congeForm extends JFrame {
	String selectedMat;
	private JPanel contentPane;
	private JTextField typeconge;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					congeForm frame = new congeForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public congeForm(String selectedMat,Chauffeur chauf) {
		this.selectedMat=selectedMat;
		setType(Type.UTILITY);
		setTitle("Ajouter Conge");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[grow][grow][grow][grow]"));
		
		JLabel lblDateDebut = new JLabel("Date debut");
		lblDateDebut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		contentPane.add(lblDateDebut, "cell 0 0,alignx trailing");
		
		JSpinner datedebut = new JSpinner();
		datedebut.setModel(new SpinnerDateModel(new Date(1514332800000L), null, null, Calendar.DAY_OF_YEAR));
		datedebut.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		contentPane.add(datedebut, "cell 1 0,growx");
		
		JLabel lblDateFin = new JLabel("Date fin");
		lblDateFin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		contentPane.add(lblDateFin, "cell 0 1");
		
		JSpinner datefin = new JSpinner();
		datefin.setModel(new SpinnerDateModel(new Date(1514332800000L), null, null, Calendar.DAY_OF_YEAR));
		datefin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		contentPane.add(datefin, "cell 1 1,growx");
		
		JLabel lblTypeConge = new JLabel("Type conge");
		lblTypeConge.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		contentPane.add(lblTypeConge, "cell 0 2");
		
		typeconge = new JTextField();
		typeconge.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		typeconge.setColumns(10);
		contentPane.add(typeconge, "cell 1 2,growx");
		
		JButton ajouter = new JButton("Ajouter");
		ajouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String date1=new SimpleDateFormat("yyyy/MM/dd").format(datedebut.getValue());
				String date2=new SimpleDateFormat("yyyy/MM/dd").format(datefin.getValue());
				String requete="insert into conge values('"+selectedMat+"','"+date1+"','"+date2+"','"+typeconge.getText()+"')";
				if(utility.insert(requete))
				{
					RepetetiveEvents.infoBox("Conge ajouté", "info");
					chauf.updateSubTable();
					dispose();
				}
				else
				{
					RepetetiveEvents.infoBox("Conge non ajouté", "erreur");
					dispose();
				}
			}
		});
		ajouter.setForeground(Color.WHITE);
		ajouter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ajouter.setBackground(new Color(60, 179, 113));
		contentPane.add(ajouter, "cell 1 3,alignx center");
	}

}
