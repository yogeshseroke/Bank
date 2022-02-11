

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class BankSer
 */
@WebServlet("/BankSer")
public class BankSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank","root","");
			Statement st=conn.createStatement();
			//int x=st.executeUpdate("INSERT INTO `bankinfo` (`branchname`,`customername`,`branchid`,`customeraccount`) VALUES('"+request.getParameter("txtbn")+"','"+request.getParameter("txtcn")+"','"+request.getParameter("txtbid")+"','"+request.getParameter("txtca")+"')");
	        //int x=st.executeUpdate("UPDATE bankinfo SET branchname='Madhya Pradesh',customername='Yogesh' WHERE branchid=4");
			//int x=st.executeUpdate("DELETE FROM bankinfo WHERE branchid=5");
			
			//int x=st.executeUpdate("CREATE TABLE customerinfo(branchid int(50),customername varchar(50),customerid int(50),customeraccount int(50),PRIMARY KEY(customerid),FOREIGN KEY(branchid) REFERENCES bankinfo(branchid))");
			int x=st.executeUpdate("INSERT INTO `customerinfo` (`branchid`,`customername`,`customerid`,`customeraccount`) VALUES('"+request.getParameter("txtbid")+"','"+request.getParameter("txtcn")+"','"+request.getParameter("txtcid")+"','"+request.getParameter("txtca")+"')");
		//	ResultSet res=st.executeQuery("DELETE FROM `bankinfo` WHERE `bankinfo`.`branchid`=4");
			
			//ResultSet res=st.executeQuery("SELECT * FROM bankinfo");
			
		//	ResultSet res=st.executeQuery("SELECT customername,customeraccount FROM customerinfo");
			//conn.close();
	   /*   
	      while(res!=null)
	      {
	    	  out.print(res.getString(1)+res.getString(2)+res.getString(3)+res.getString(4));
	    	  out.write("Data successfully deleted");
	      }
		*/	
			
  		  if(x!=0)
	        {
	        	out.write("Data successfully inserted");
	        }
	        else
	        {
	        	out.write("failed");
	        }
		
		}
		catch(Exception ex) {
			out.write(ex.getMessage().toString());
		}
		
		
		
	}

}
