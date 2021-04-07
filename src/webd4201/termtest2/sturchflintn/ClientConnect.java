package webd4201.termtest2.sturchflintn;

import java.sql.*;

public class ClientConnect
{
	static String url = "jdbc:postgresql://127.0.0.1:5432/XXXX";
	static Connection aConnection;
	static String user = "XXXXX";
	static String password = "XXXXX";
	
	public static Connection initialize()
	{
		try
 		{ 	
			Class.forName("org.postgresql.Driver");
			aConnection = DriverManager.getConnection(url, user, password);
	    	
	 	}
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch (SQLException e)
			{ System.out.println(e); }
		return aConnection;
	}

	public static void terminate()
	{
		try
 		{
    		aConnection.close();
		}
		catch (SQLException e)
			{ System.out.println(e);	}
	}
}