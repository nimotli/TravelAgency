package GAV.misc;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class utility {
    
	public static ResultSet query(String requete){
		    try {
				  Statement stm = ConnectDB.getConnetion().createStatement();
				  ResultSet rs = stm.executeQuery(requete);
				  return rs ;
			} catch (Exception e) {
				 return null ;
			}
	}
	
	public static boolean insert(String requete){
		  try
		  {
			  Statement stm = ConnectDB.getConnetion().createStatement();
			  int i = stm.executeUpdate(requete);
			  return true ;  
		}
		  catch (Exception e)
		{
			return false ;
		}
	}
	
	public static boolean update(String requete){
		try {
			  Statement stm = ConnectDB.getConnetion().createStatement();
			  int i = stm.executeUpdate(requete);
			  return i > 0 ;  
		} catch (Exception e) {
			return false ;
		}
	}
	
	public static ArrayList findAll(String requete){
	    try {
	    	   ArrayList liste = new ArrayList();
			  Statement stm = ConnectDB.getConnetion().createStatement();
			  ResultSet rs = stm.executeQuery(requete);
			  while (rs.next()) {
				  liste.add(rs);
			}
			  return liste ;   
		} catch (Exception e) {
			 return null ;
		}
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

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
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	public static Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	
	

}
