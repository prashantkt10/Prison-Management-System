//generarting list using list we can use Jtextarea
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class PrisonerReports extends JFrame
{
	//JTable lstrpt;
	List lstrpt;
	//constructor
	public PrisonerReports()
	{
		lstrpt=new List(); 
		add(lstrpt);
		lstrpt.setBounds(10,40,400,300);
		//size and demension of frame
		setSize(800,350);
		setVisible(true);
	}
	/**for first student*/
		public void PRSON()
		{

			setTitle("Report of Prisoner");
		try
		{	 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","123");
			System.out.println("Connection established successfully");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select *from PRDB ");
			String st="";
			while (rs.next())
			{
				st = rs.getString("PUD")+"       "+rs.getString("PNM")+"           "+rs.getString("PAGE")+"           "+rs.getString("PGEN")+"           "+rs.getString("PCR")+"           "+rs.getString("PSL");
				lstrpt.add(st); 
			}
			
		}
		catch (Exception e)
		{
		}
		}
		
	
	//main method
		public static void main(String args[])
		{
			PrisonerReports r=new PrisonerReports();
				r.PRSON();
		}
}
