package webd4201.termtest2.sturchflintn;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ClientFindServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
                            HttpServletResponse response) 
					throws ServletException, IOException
    {
    	String firstName = new String();
        
	   	try
        { 
            Connection c = ClientConnect.initialize();
            Client.initialize(c);
            HttpSession session = request.getSession(true);
            try 
            {   
                firstName = request.getParameter( "First_Name" ); 
                Client aClient = Client.retrieve(firstName);
                session.setAttribute("client", aClient);
				session.setAttribute("message", "");
				response.sendRedirect("./clientInfo.jsp");
            }catch(ClientNotFoundException nfe)
            {
                StringBuffer messageBuffer = new StringBuffer();
                messageBuffer.append("<strong>No client with the first name \'" + firstName + "\" exists in the system.<br/>");
                messageBuffer.append("Please try again.</strong>");
                session.setAttribute("message", messageBuffer.toString());
                response.sendRedirect("./clientFind.jsp");
			}
        }    
		catch (Exception e) //not connected
        {
            System.out.println(e);
            String line1="<h2>A network error has occurred!</h2>";
            String line2="<p>Please notify your system administrator and check log. "+e.toString()+"</p>";
            formatErrorPage(line1, line2,response);
        }
    }
    public void doGet(HttpServletRequest request,
                            HttpServletResponse response)
                                    throws ServletException, IOException {
        doPost(request, response);
    }

    public void formatErrorPage( String first, String second,
            HttpServletResponse response) throws IOException
    {
        PrintWriter output = response.getWriter();
        response.setContentType( "text/html" );
        output.println(first);
        output.println(second);
        output.close();
    }
}