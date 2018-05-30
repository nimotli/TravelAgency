package GAV.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {
   
	
	public static Connection getConnetion(){
		Connection cnx = null ;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestions", "root", "");
		} catch (Exception e) {
			 cnx = null ;
		}
		return cnx ;
	}
}
