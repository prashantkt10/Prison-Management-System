import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class PrisonerReport extends JFrame
{
	JPanel pnl_second;
	JLabel lab_1;
	Font fnt_second = new Font("Serif",Font.PLAIN, 20);
	Font fnt_third = new Font("Serif",Font.PLAIN, 16);
	//connection connect= new connection();j
	String lab[]={"Id","Name","Age","Gender","Crime","S_Level","CrimeDt","JoinDT","ReleaseDT","Status"};	
	int xcod=10, ycod=30;
	public PrisonerReport()
	{
		setSize(1000,500);
		setLocation(300,20);
		setTitle("Prisoner Management System");
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setBackground(Color.lightGray);
        
		pnl_second=new JPanel();
		pnl_second.setBounds(0,0,1000,500);
		pnl_second.setLayout(null);
		pnl_second.setBackground(new Color(171, 123, 128));
		this.add(pnl_second);
		for(int i=0;i<10;i++)
		{
			lab_1= new JLabel(lab[i]);
			lab_1.setBounds(xcod,ycod,87,50);
			lab_1.setFont(fnt_second);
			pnl_second.add(lab_1);
			
			xcod+=90;
		}
		ycod+=30;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","123");
			System.out.println("Connection established successfully");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select *from PRDB ");
			while(rs.next())
			{
				xcod=10;
				for(int i=0;i<10;i++)
				{
					lab_1= new JLabel(rs.getString(i+1));
					lab_1.setBounds(xcod,ycod,87,50);
					lab_1.setFont(fnt_third);
					pnl_second.add(lab_1);
			
					xcod+=90;
				}
			ycod+=30;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		
		pnl_second.updateUI();
		}
		
	public static void main(String args[])
	{
		new PrisonerReport();
	}
}