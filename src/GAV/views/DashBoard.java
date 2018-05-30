package GAV.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import GAV.misc.utility;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashBoard extends JPanel 
{
	private JLabel locationTotal;
	private JLabel chauffeurTotal;
	private JLabel chauffeurConge;
	private JLabel chauffeurDispo;
	private JLabel autocarPanne;
	private JLabel autocarVoyage;
	private JLabel autocarDispo;
	private JLabel ligneActive;
	private JLabel ligneHors;
	private JLabel ligneTotal;
	private JLabel locationEnloc;
	private JLabel locationTermine;

	/**
	 * Create the panel.
	 */
	public DashBoard() 
	{
		initComponent();
		eventHandler();
	}
	
	
	void initComponent()
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(37, 47, 59));
		add(panel);
		
		JLabel label = new JLabel("Tableau de bord");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Century Gothic", Font.PLAIN, 21));
		
		JPanel autocarPanel = new JPanel();
		autocarPanel.setBackground(new Color(60, 179, 113));
		autocarPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel titleA = new JPanel();
		titleA.setBorder(new LineBorder(new Color(0, 0, 0)));
		titleA.setBackground(new Color(60, 179, 113));
		autocarPanel.add(titleA, BorderLayout.WEST);
		titleA.setLayout(new MigLayout("", "[173.00,grow]", "[grow]"));
		
		JPanel panel_7 = new JPanel();
		titleA.add(panel_7, "cell 0 0,grow");
		panel_7.setLayout(new MigLayout("", "[71.00px,grow]", "[19px,grow,fill]"));
		
		JLabel label_1 = new JLabel("Autocar");
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_7.add(label_1, "cell 0 0,alignx center,aligny center");
		
		JPanel contentA = new JPanel();
		contentA.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentA.setBackground(new Color(60, 179, 113));
		autocarPanel.add(contentA, BorderLayout.CENTER);
		contentA.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		
		JPanel panel_9 = new JPanel();
		contentA.add(panel_9, "cell 0 0,grow");
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel label_2 = new JLabel("   Diponible");
		label_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_9.add(label_2, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		contentA.add(panel_12, "cell 1 0,grow");
		panel_12.setLayout(new BorderLayout(0, 0));
		
		autocarDispo = new JLabel("27");
		autocarDispo.setHorizontalAlignment(SwingConstants.CENTER);
		autocarDispo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_12.add(autocarDispo, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		contentA.add(panel_10, "cell 0 1,grow");
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("   En voyage");
		label_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_10.add(label_3, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		contentA.add(panel_13, "cell 1 1,grow");
		panel_13.setLayout(new BorderLayout(0, 0));
		
		autocarVoyage = new JLabel("27");
		autocarVoyage.setHorizontalAlignment(SwingConstants.CENTER);
		autocarVoyage.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_13.add(autocarVoyage, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		contentA.add(panel_11, "cell 0 2,grow");
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel label_4 = new JLabel("   En panne");
		label_4.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_11.add(label_4, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		contentA.add(panel_14, "cell 1 2,grow");
		panel_14.setLayout(new BorderLayout(0, 0));
		
		autocarPanne = new JLabel("27");
		autocarPanne.setHorizontalAlignment(SwingConstants.CENTER);
		autocarPanne.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_14.add(autocarPanne, BorderLayout.CENTER);
		
		JPanel chauffeurPanel = new JPanel();
		chauffeurPanel.setBackground(new Color(60, 179, 113));
		chauffeurPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel titleC = new JPanel();
		titleC.setBorder(new LineBorder(new Color(0, 0, 0)));
		titleC.setBackground(new Color(60, 179, 113));
		chauffeurPanel.add(titleC, BorderLayout.WEST);
		titleC.setLayout(new MigLayout("", "[173.00,grow]", "[grow]"));
		
		JPanel panel_16 = new JPanel();
		titleC.add(panel_16, "cell 0 0,grow");
		panel_16.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JLabel label_11 = new JLabel("Chauffeur");
		label_11.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_16.add(label_11, "cell 0 0,alignx center");
		
		JPanel contentC = new JPanel();
		contentC.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentC.setBackground(new Color(60, 179, 113));
		chauffeurPanel.add(contentC, BorderLayout.CENTER);
		contentC.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		
		JPanel panel_18 = new JPanel();
		contentC.add(panel_18, "cell 0 0,grow");
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JLabel label_8 = new JLabel("   Diponible");
		label_8.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_18.add(label_8, BorderLayout.CENTER);
		
		JPanel panel_21 = new JPanel();
		contentC.add(panel_21, "cell 1 0,grow");
		panel_21.setLayout(new BorderLayout(0, 0));
		
		chauffeurDispo = new JLabel("27");
		chauffeurDispo.setHorizontalAlignment(SwingConstants.CENTER);
		chauffeurDispo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_21.add(chauffeurDispo, BorderLayout.CENTER);
		
		JPanel panel_19 = new JPanel();
		contentC.add(panel_19, "cell 0 1,grow");
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JLabel label_9 = new JLabel("    En conge");
		label_9.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_19.add(label_9, BorderLayout.CENTER);
		
		JPanel panel_22 = new JPanel();
		contentC.add(panel_22, "cell 1 1,grow");
		panel_22.setLayout(new BorderLayout(0, 0));
		
		chauffeurConge = new JLabel("27");
		chauffeurConge.setHorizontalAlignment(SwingConstants.CENTER);
		chauffeurConge.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_22.add(chauffeurConge, BorderLayout.CENTER);
		
		JPanel panel_20 = new JPanel();
		contentC.add(panel_20, "cell 0 2,grow");
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JLabel label_10 = new JLabel("    Totale");
		label_10.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_20.add(label_10, BorderLayout.CENTER);
		
		JPanel panel_23 = new JPanel();
		contentC.add(panel_23, "cell 1 2,grow");
		panel_23.setLayout(new BorderLayout(0, 0));
		
		chauffeurTotal = new JLabel("27");
		chauffeurTotal.setHorizontalAlignment(SwingConstants.CENTER);
		chauffeurTotal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_23.add(chauffeurTotal, BorderLayout.CENTER);
		
		JPanel lignePanel = new JPanel();
		lignePanel.setBackground(new Color(60, 179, 113));
		lignePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel titleL = new JPanel();
		titleL.setBorder(new LineBorder(new Color(0, 0, 0)));
		titleL.setBackground(new Color(60, 179, 113));
		lignePanel.add(titleL, BorderLayout.WEST);
		titleL.setLayout(new MigLayout("", "[163.00,grow]", "[grow]"));
		
		JPanel panel_26 = new JPanel();
		titleL.add(panel_26, "cell 0 0,grow");
		panel_26.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JLabel label_21 = new JLabel("Ligne");
		label_21.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_26.add(label_21, "cell 0 0,alignx center");
		
		JPanel contentL = new JPanel();
		contentL.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentL.setBackground(new Color(60, 179, 113));
		lignePanel.add(contentL, BorderLayout.CENTER);
		contentL.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		
		JPanel panel_27 = new JPanel();
		contentL.add(panel_27, "cell 0 0,grow");
		panel_27.setLayout(new BorderLayout(0, 0));
		
		JLabel label_15 = new JLabel("   Active");
		label_15.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_27.add(label_15, BorderLayout.CENTER);
		
		JPanel panel_30 = new JPanel();
		contentL.add(panel_30, "cell 1 0,grow");
		panel_30.setLayout(new BorderLayout(0, 0));
		
		ligneActive = new JLabel("27");
		ligneActive.setHorizontalAlignment(SwingConstants.CENTER);
		ligneActive.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_30.add(ligneActive, BorderLayout.CENTER);
		
		JPanel panel_28 = new JPanel();
		contentL.add(panel_28, "cell 0 1,grow");
		panel_28.setLayout(new BorderLayout(0, 0));
		
		JLabel label_16 = new JLabel("   Hors travail");
		label_16.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_28.add(label_16, BorderLayout.CENTER);
		
		JPanel panel_31 = new JPanel();
		contentL.add(panel_31, "cell 1 1,grow");
		panel_31.setLayout(new BorderLayout(0, 0));
		
		ligneHors = new JLabel("27");
		ligneHors.setHorizontalAlignment(SwingConstants.CENTER);
		ligneHors.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_31.add(ligneHors, BorderLayout.CENTER);
		
		JPanel panel_29 = new JPanel();
		contentL.add(panel_29, "cell 0 2,grow");
		panel_29.setLayout(new BorderLayout(0, 0));
		
		JLabel label_17 = new JLabel("   Totale");
		label_17.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_29.add(label_17, BorderLayout.CENTER);
		
		JPanel panel_32 = new JPanel();
		contentL.add(panel_32, "cell 1 2,grow");
		panel_32.setLayout(new BorderLayout(0, 0));
		
		ligneTotal = new JLabel("27");
		ligneTotal.setHorizontalAlignment(SwingConstants.CENTER);
		ligneTotal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_32.add(ligneTotal, BorderLayout.CENTER);
		
		JPanel locationPanel = new JPanel();
		locationPanel.setBackground(new Color(60, 179, 113));
		locationPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel titileLO = new JPanel();
		titileLO.setBorder(new LineBorder(new Color(0, 0, 0)));
		titileLO.setBackground(new Color(60, 179, 113));
		locationPanel.add(titileLO, BorderLayout.CENTER);
		titileLO.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		
		JPanel panel_36 = new JPanel();
		titileLO.add(panel_36, "cell 0 0,grow");
		panel_36.setLayout(new BorderLayout(0, 0));
		
		JLabel label_23 = new JLabel("   En location");
		label_23.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_36.add(label_23, BorderLayout.CENTER);
		
		JPanel panel_39 = new JPanel();
		titileLO.add(panel_39, "cell 1 0,grow");
		panel_39.setLayout(new BorderLayout(0, 0));
		
		locationEnloc = new JLabel("27");
		locationEnloc.setHorizontalAlignment(SwingConstants.CENTER);
		locationEnloc.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_39.add(locationEnloc, BorderLayout.CENTER);
		
		JPanel panel_37 = new JPanel();
		titileLO.add(panel_37, "cell 0 1,grow");
		panel_37.setLayout(new BorderLayout(0, 0));
		
		JLabel label_28 = new JLabel("   Termin\u00E9");
		label_28.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_37.add(label_28, BorderLayout.CENTER);
		
		JPanel panel_40 = new JPanel();
		titileLO.add(panel_40, "cell 1 1,grow");
		panel_40.setLayout(new BorderLayout(0, 0));
		
		locationTermine = new JLabel("27");
		locationTermine.setHorizontalAlignment(SwingConstants.CENTER);
		locationTermine.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_40.add(locationTermine, BorderLayout.CENTER);
		
		JPanel panel_38 = new JPanel();
		titileLO.add(panel_38, "cell 0 2,grow");
		panel_38.setLayout(new BorderLayout(0, 0));
		
		JLabel label_24 = new JLabel("   Totale");
		label_24.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_38.add(label_24, BorderLayout.CENTER);
		
		JPanel panel_41 = new JPanel();
		titileLO.add(panel_41, "cell 1 2,grow");
		panel_41.setLayout(new BorderLayout(0, 0));
		
		locationTotal = new JLabel("27");
		locationTotal.setHorizontalAlignment(SwingConstants.CENTER);
		locationTotal.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_41.add(locationTotal, BorderLayout.CENTER);
		
		JPanel contentLO = new JPanel();
		contentLO.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentLO.setBackground(new Color(60, 179, 113));
		locationPanel.add(contentLO, BorderLayout.WEST);
		contentLO.setLayout(new MigLayout("", "[163.00,grow,fill]", "[grow]"));
		
		JPanel panel_35 = new JPanel();
		contentLO.add(panel_35, "cell 0 0,alignx center,growy");
		panel_35.setLayout(new MigLayout("", "[grow][grow]", "[grow]"));
		
		JLabel label_22 = new JLabel("Location");
		label_22.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panel_35.add(label_22, "cell 0 0 2 1,alignx center");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(autocarPanel, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
								.addComponent(chauffeurPanel, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(locationPanel, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
								.addComponent(lignePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lignePanel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(autocarPanel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(locationPanel, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
						.addComponent(chauffeurPanel, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addGap(32))
		);
		panel.setLayout(gl_panel);
	}
	
	void eventHandler()
	{
		 autocarStatestics();
		 chauffeurStatestics();
		 locationStatestics();
	}
	
	void autocarStatestics()
	{
		int dispo = 0,voyage=0,panne=0;
		ResultSet rs=utility.query("select * from autocar");
		ResultSet rs2=utility.query("select matricule from autocar where matricule in(select idAutocar from voyage where datevoyage = CURDATE())");
		
		try 
		{
			while (rs.next())
			{
				if(rs.getString(4).equals("disponible"))
				{
					dispo++;
				}
				else
				{
					panne++;
				}
				
			}
			while(rs2.next())
			{
				voyage++;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		autocarDispo.setText(String.valueOf(dispo));
		autocarVoyage.setText(String.valueOf(voyage));
		autocarPanne.setText(String.valueOf(panne));
		ligneStatestics();
	}
	
	void chauffeurStatestics()
	{
		int dispo = 0,conge=0,total=0;
		ResultSet rs=utility.query("select * from chauffeur");
		ResultSet rs2=utility.query("select * from chauffeur where matricule in (select matricule from conge where CURRENT_DATE between datedebut and datefin) ");
		
		try 
		{
			while (rs.next())
			{
				total++;
			}
			while(rs2.next())
			{
				conge++;
			}
			dispo=total-conge;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		chauffeurConge.setText(String.valueOf(conge));
		chauffeurDispo.setText(String.valueOf(dispo));
		chauffeurTotal.setText(String.valueOf(total));
	}
	void ligneStatestics()
	{
		int actif = 0,inactifs=0,total=0;
		ResultSet rs=utility.query("select etat from ligne");
		
		try 
		{
			while (rs.next())
			{
				total++;
				if(rs.getString(1).equals("actif"))
				{
					actif++;
				}
				else
				{
					inactifs++;
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		ligneActive.setText(String.valueOf(actif));
		ligneHors.setText(String.valueOf(inactifs));
		ligneTotal.setText(String.valueOf(total));
	}
	void locationStatestics()
	{
		int enloc = 0,termine=0,total=0;
		ResultSet rs=utility.query("select * from location");
		ResultSet rs2=utility.query("select * from location where CURRENT_DATE between dateDebut and datefin");		
		try 
		{
			while (rs.next())
			{
				total++;
			}
			while(rs2.next())
			{
				enloc++;
			}
			termine=total-enloc;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		locationEnloc.setText(String.valueOf(enloc));
		locationTermine.setText(String.valueOf(termine));
		locationTotal.setText(String.valueOf(total));
	}
}
