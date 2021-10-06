package crms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

private static Connection connect;
	
	public static Connection getConnected()
	{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
			
		}
		catch(Exception e)
		{
			System.out.println("Database not connected"+e);
		}
		
		return connect;
	}
}
