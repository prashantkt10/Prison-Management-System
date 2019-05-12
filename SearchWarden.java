import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class SearchWarden extends JFrame implements ActionListener
{
	private JButton btadd, btclear, btcancel, btsearch;
	private JLabel lblid, lblname, lbldoj, lblcd, lblrank, lbldor, lbladdress, lblh, lblf;
	private JTextField txtid, txtname;
	private JTextArea txtaddress;
	private JPanel header, footer, center;
	private Font f1, f2, f3, f4;
	private JComboBox cmbrank, cmbdate, cmbmonth, cmbyear, cmbdor, cmbmor, cmbyor, cmbcd;
	int counter;
	String id, name, rank, doj, moj, yoj, dor, mor, yor, cd, address;

	public SearchWarden()
	{
		f1=new Font("Felix Titling", 1,30);
		f2=new Font("Felix Titling", 1,15);
		f3=new Font("Felix Titling" ,1,15);
		header=new JPanel();
		footer=new JPanel();
		center=new JPanel();
		lblh=new JLabel("____Search Warden____");
		lblf=new JLabel("Developed by Prashant");
		lblid=new JLabel("Unique ID :");
		lblname=new JLabel("Full Name :");
		lblrank=new JLabel("Rank :");
		lbldoj=new JLabel("Date of Joining :");
		lbldor=new JLabel("Date of Retirement :");
		lblcd=new JLabel("Crime Department :");
		lbladdress=new JLabel("Address :");
		txtid=new JTextField();
		txtname=new JTextField();
		cmbrank=new JComboBox();
		cmbdate=new JComboBox();
		cmbmonth=new JComboBox();
		cmbyear=new JComboBox();
		cmbdor=new JComboBox();
		cmbmor=new JComboBox();
		cmbyor=new JComboBox();
		cmbcd=new JComboBox();
		btadd=new JButton("Submit");
		btclear=new JButton("Clear");
		btcancel=new JButton("Cancel");
		btsearch=new JButton("Search");

		txtaddress =new JTextArea();
	}

	public void ItemsAdd()
	{
		add(header, BorderLayout.NORTH);
		add(footer, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);
		header.setBackground(new Color(139,0, 0));
		header.add(lblh);
		footer.setBackground(new Color(139,0, 0));
		footer.add(lblf);
		center.add(lblid);
		center.add(lblname);
		center.add(lblrank);
		center.add(lbldoj);
		center.add(lbldor);
		center.add(lblcd);
		center.add(lbladdress);
		center.add(txtid);
		center.add(txtname);
		txtname.setEnabled(false);
		center.add(cmbrank);
		cmbrank.setEnabled(false);
		center.add(cmbdate);
		cmbdate.setEnabled(false);
		center.add(cmbmonth);
		cmbmonth.setEnabled(false);
		center.add(cmbyear);
		cmbyear.setEnabled(false);
		center.add(cmbdor);
		cmbdor.setEnabled(false);
		center.add(cmbmor);
		cmbmor.setEnabled(false);
		center.add(cmbyor);
		cmbyor.setEnabled(false);
		center.add(cmbcd);
		cmbcd.setEnabled(false);
		center.add(txtaddress);
		txtaddress.setEnabled(false);
		center.add(btadd);
		btadd.setEnabled(false);
		center.add(btclear);
		btclear.setEnabled(false);
		center.add(btcancel);
		center.add(btsearch);
		center.setLayout(null);

		lblh.setFont(f1);
		lblf.setFont(f2);
		lblh.setForeground(new Color(255, 255, 255));
		lblf.setForeground(new Color(255, 255, 255)); 
		lblid.setBounds(120,20, 200,50);
		lblid.setFont(f3);
		lblname.setBounds(120,60, 165,50);
		lblname.setFont(f3);
		lblrank.setBounds(120,100, 100,50);
		lblrank.setFont(f3);
		lbldoj.setBounds(120,140, 190,50);
		lbldoj.setFont(f3);
		lbldor.setBounds(120,180, 190,50);
		lbldor.setFont(f3);
		lblcd.setBounds(120,220, 190,50);
		lblcd.setFont(f3);
		lbladdress.setBounds(120,260, 190,50);
		lbladdress.setFont(f3);
		txtid.setBounds(330,35, 130,20);
		btsearch.setBounds(470, 35, 80,20);
		txtname.setBounds(330,75, 130,20);
		cmbrank.setBounds(330,115, 40,20);
		cmbdate.setBounds(330,155, 55,20);
		cmbmonth.setBounds(395,155, 60,20);
		cmbyear.setBounds(465,155, 55,20);
		cmbdor.setBounds(330,195, 55,20);
		cmbmor.setBounds(395,195, 60,20);
		cmbyor.setBounds(465,195, 55,20);
		cmbcd.setBounds(330,235, 70,20);
		txtaddress.setBounds(330,275, 165,100);
		btadd.setBounds(120,415, 80,40);
		btclear.setBounds(250,415, 80,40);
		btcancel.setBounds(380,415, 80,40);

		for(counter= 1; counter <= 5; counter ++)
		{
			String s=new Integer (counter).toString();
			cmbrank.addItem(s);
		}

		cmbdate.addItem("Date");

		for (counter=1; counter<=31 ;counter++ )
		{
			String s=new Integer (counter).toString();
			cmbdate.addItem(s);
		}

		cmbyear.addItem("Year");

		for (counter=1990; counter<=2050 ; counter++ )
		{
			String s=new Integer (counter).toString();
			cmbyear.addItem(s);
		}

		cmbmonth.addItem("Month");

		for (counter=1; counter<=12 ; counter++ )
		{
			String s=new Integer (counter).toString();
			cmbmonth.addItem(s);
		}

		cmbdor.addItem("Date");

		for (counter=1; counter<=31 ;counter++ )
		{
			String s=new Integer (counter).toString();
			cmbdor.addItem(s);
		}

		cmbyor.addItem("Year");

		for (counter=1990; counter<=2050 ; counter++ )
		{
			String s=new Integer (counter).toString();
			cmbyor.addItem(s);
		}

		cmbmor.addItem("Month");

		for (counter=1; counter<=12 ; counter++ )
		{
			String s=new Integer (counter).toString();
			cmbmor.addItem(s);
		}

		cmbcd.addItem("Murder");
		cmbcd.addItem("Theft");
		cmbcd.addItem("Terrorism");
		cmbcd.addItem("Other");

		setIconImage (getToolkit().getImage ("prisoner.png"));
		setTitle("Warden Details");
		setBounds(400,70, 600,600);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setResizable(false);
		setVisible(true);

		btcancel.addActionListener(this);
		btsearch.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btcancel)
		{
			dispose();
		}

		if(e.getSource()==btsearch)
		{
			Find();
		}
	}

	public static void main(String args[])
	{
		SearchWarden aw=new SearchWarden();
		aw.ItemsAdd();
		System.out.println("Execution Done !");
	}

	public void Find()
	{
		id=txtid.getText();
		name=txtname.getText();
		rank= (String) cmbrank.getSelectedItem();
		doj= (String) cmbdate.getSelectedItem();
		moj= (String) cmbmonth.getSelectedItem();
		yoj= (String) cmbyear.getSelectedItem();
		dor= (String) cmbdor.getSelectedItem();
		mor= (String) cmbmor.getSelectedItem();
		yor= (String) cmbyor.getSelectedItem();
		cd= (String) cmbcd.getSelectedItem();
		address= txtaddress.getText();

		Connection con=null;
	
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","123");
			System.out.println("Connection established successfully");
				
				
				Statement st=con.createStatement();
				String sql = "select * from WARDENDB where UD="+id ;
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
                {
				
					txtname.setText(rs.getString("NM"));
					cmbrank.setSelectedItem(rs.getString("RANK"));
					cmbdate.setSelectedItem(rs.getString("DOJ"));
					cmbmonth.setSelectedItem(rs.getString("MOJ"));
					cmbyear.setSelectedItem(rs.getString("YOJ"));
					cmbdor.setSelectedItem(rs.getString("DOR"));
					cmbmor.setSelectedItem(rs.getString("MOR"));
					cmbyor.setSelectedItem(rs.getString("YOR"));
					cmbcd.setSelectedItem(rs.getString("CR_DES"));
					txtaddress.setText(rs.getString("ADDRESS"));
					JOptionPane.showMessageDialog(null, "Record Found Successfully");
					System.out.println("Statement executed successfully");
                }
				else
				{
					JOptionPane.showMessageDialog(null, "Record not Found !");
				}
			    rs.close();
				
			}
		catch (SQLException e  )
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
   }
}
