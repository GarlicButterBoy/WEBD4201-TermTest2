package webd4201.termtest2.sturchflintn;

import java.sql.*;

public class ClientDA
{
	static Client aClient;

	static Connection aConnection;
	static Statement aStatement;

	static String firstName;
	static String lastName;
	static String emailAddress;
	static String phoneNumber;

	public static void initialize(Connection c)
	{
		try {
			aConnection=c;
			aStatement=aConnection.createStatement();
		}
		catch (SQLException e)
		{ 
			System.out.println(e);	
		}
	}

	public static void terminate()
	{
		try
 		{ 	
    		aStatement.close();
		}
		catch (SQLException e)
		{ 
			System.out.println(e);	
		}
	}

	public static Client retrieve(String aFirstName) throws ClientNotFoundException
	{ 
		aClient = null;
		String sqlQuery = "SELECT firstName, lastName, emailAddress, phoneNumber " +
                                      	"FROM clients " +
                                        " WHERE firstName = '" + aFirstName +"'" ;
                
        try
 		{
	    	ResultSet rs = aStatement.executeQuery(sqlQuery);
			boolean gotIt = rs.next();
	    	if (gotIt)
	    	{	
	    		firstName = rs.getString("firstName");
	    		lastName = rs.getString("lastName");
	    		emailAddress = rs.getString("emailAddress");
				phoneNumber = rs.getString("phoneNumber");
				aClient = new Client(firstName, lastName, emailAddress, phoneNumber);
					
				}
			else	
			{
				throw (new ClientNotFoundException(aFirstName + " not found in the system."));
			}
			rs.close();
	   	}
		catch (SQLException e)
		{ 
			System.out.println(e);
		}
		return aClient;
	}
}

