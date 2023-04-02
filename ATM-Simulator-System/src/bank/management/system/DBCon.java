package bank.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	Connection con;
	Statement st;
	public DBCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Munna@2000");
			 st = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
