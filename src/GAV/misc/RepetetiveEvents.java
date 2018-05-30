package GAV.misc;
import net.proteanit.sql.DbUtils;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class RepetetiveEvents 
{
	public static void CrudButtonsHandler(JButton but,String contentPanelName,JPanel theContentPanel,JTable table,int index)
	{
		but.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(index == 1 || ((index==2 || index==3) && table.getSelectedRow()!=-1))
				{
					CardLayout carddLayout = (CardLayout) theContentPanel.getLayout();
					carddLayout.show(theContentPanel, contentPanelName);
				}
				else
				{
					infoBox("Veuillez selectionner un ligne", "Aucune ligne n'a été sélectionnée");
				}
				
			}
		});
		
	}
	/////////////////////////////////
	
	public static void remplirTable(String requete,JTable table){
			
			try
			{
				PreparedStatement pstm = ConnectDB.getConnetion().prepareStatement(requete);
				ResultSet rs = pstm.executeQuery();
				DefaultTableModel tm = (DefaultTableModel)DbUtils.resultSetToTableModel(rs);
				table.setModel(tm);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	/////////////////////////////////
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	
}
