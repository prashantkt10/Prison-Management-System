import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class SearchPrisoner extends JFrame implements ActionListener
{
	private JLabel lblheader, lblfooter, lblid, lblname, lblage, lblgender, lblcrime, lblslevel, lblcrimedt, lbljoindt, lblreleasedt;
	private JTextField txtname, txtage, txtid, txtdoc, txtdoj, txtdor;
	private JPanel header, footer, center;
	private Font f1, f2, f3, f4;
	private JButton btupdate, btclear, btcancel, btsearch;
	private JComboBox cmbgender, cmbcrime, cmbslevel; 
	private String id, name, age, gender, crime, sl, cd, cm, cy, jd, jm, jy, rd, rm, ry;
	public SearchPrisoner()
	{
		lblheader=new JLabel("___Search Prisoner___");
		lblfooter=new JLabel("Developed by Prashant");
		lblname=new JLabel("Name :");
		lblage=new JLabel("Age :");
		lblgender=new JLabel("Gender :");
		lblcrime=new JLabel("Crime :");
		lblslevel=new JLabel("Secuirty Level :");
		lblcrimedt=new JLabel("Crime Date :");
		lbljoindt=new JLabel("Join Date :");
		lblreleasedt=new JLabel("Release Date :");
		lblid=new JLabel("Unique ID :");
		txtname=new JTextField();
		txtage=new JTextField();
		txtid=new JTextField();
		btupdate=new JButton("Update");
		btclear=new JButton("Clear");
		btcancel=new JButton("Cancel");
		btsearch=new JButton("Search");
		f1=new Font("Felix Titling", 1,30);
		f2=new Font("Felix Titling", 1,15);
		f3=new Font("Felix Titling", 1,15);
		header=new JPanel();
		center=new JPanel();
		footer=new JPanel();
		cmbgender=new JComboBox();
		cmbcrime=new JComboBox();
		cmbslevel=new JComboBox();
		txtdoc=new JTextField();
		txtdoj=new JTextField();
		txtdor=new JTextField();
	}

	public void AddItem()
	{
		add(header);
		add(center);
		add(footer);
		center.add(lblname);
		center.add(lblage);
		center.add(lblgender);
		center.add(lblcrime);
		center.add(lblslevel);
		center.add(lblcrimedt);
		center.add(lbljoindt);
		center.add(lblreleasedt);
		center.add(cmbgender);
		cmbgender.setEnabled(false);
		center.add(cmbcrime);
		cmbcrime.setEnabled(false);
		center.add(cmbslevel);
		cmbslevel.setEnabled(false);
		
		center.add(txtname);
		txtname.setEnabled(false);
		center.add(txtage);
		txtage.setEnabled(false);
		center.add(txtid);
		center.add(lblid);
		center.add(btsearch);
		center.add(btupdate);
		btupdate.setEnabled(false);
		center.add(btclear);
		btclear.setEnabled(false);
		center.add(btcancel);
		center.add(txtdoc);
		center.add(txtdoj);
		center.add(txtdor);

		add(header, BorderLayout.NORTH);
		header.add(lblheader);
		header.setBackground(new Color(255, 64, 64));
		lblheader.setFont(f1);
		add(footer, BorderLayout.SOUTH);
		footer.add(lblfooter);
		footer.setBackground(new Color(255, 64, 64));
		add(center, BorderLayout.CENTER);
		center.setLayout(null);
		lblfooter.setFont(f2);
		lblid.setBounds(120,20, 200,50);
		lblid.setFont(f3);
		lblname.setBounds(120,60, 165,50);
		lblname.setFont(f3);
		lblage.setBounds(120,100, 100,50);
		lblage.setFont(f3);
		lblgender.setBounds(120,140, 190,50);
		lblgender.setFont(f3);
		lblcrime.setBounds(120,180, 190,50);
		lblcrime.setFont(f3);
		lblslevel.setBounds(120,220, 195,50);
		lblslevel.setFont(f3);
		lblcrimedt.setBounds(120,260, 190,50);
		lblcrimedt.setFont(f3);
		lbljoindt.setBounds(120,300, 190,50);
		lbljoindt.setFont(f3);
		lblreleasedt.setBounds(120,340, 190,50);
		lblreleasedt.setFont(f3);
		txtid.setBounds(300,37, 150,20);
		txtname.setBounds(300,77, 150,20);
		txtage.setBounds(300,117, 150,20);
		cmbgender.setBounds(300,157, 70,20);
		cmbcrime.setBounds(300,197, 70,20);
		cmbslevel.setBounds(300,237, 80,20);

		btsearch.setBounds(470,37, 80,20);
		btupdate.setBounds(120,410, 80,40);
		btclear.setBounds(260,410, 80,40);
		btcancel.setBounds(400,410, 80,40);
		txtdoc.setBounds(300,277, 150,20);
		txtdoj.setBounds(300,317, 150,20);
		txtdor.setBounds(300,357, 150,20);

		txtdoc.setEnabled(false);
		txtdoj.setEnabled(false);
		txtdor.setEnabled(false);

		cmbgender.addItem("Male");
		cmbgender.addItem("Female");
		cmbcrime.addItem("Murder");
		cmbcrime.addItem("Theft");
		cmbcrime.addItem("Terrorism");
		cmbcrime.addItem("Other");
		cmbslevel.addItem("Low");
		cmbslevel.addItem("Moderate");
		cmbslevel.addItem("High");
		
		setTitle("Prisoner Details");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setIconImage (getToolkit().getImage ("prisoner.png"));
		setBounds(400,70, 600,600);
		setResizable(false);
		setVisible(true);

		btsearch.addActionListener(this);
		btupdate.addActionListener(this);
		btclear.addActionListener(this);
		btcancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btsearch)
		{
			Find();
		}
		else if (e.getSource()==btcancel)
		{
			dispose();
		}
	}

	public static void main(String args[])
	{
		SearchPrisoner api=new SearchPrisoner();
		api.AddItem();
		System.out.println("Execution Done !");
	}

	public void Find()
	{
		id=txtid.getText();
		
		Connection con=null;
	
			try
			{
				
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","123");
			System.out.println("Connection established successfully");
				
				Statement st=con.createStatement();
				String sql = "select * from PRDB where PUD="+id ;
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
                {
					txtid.setText(rs.getString("PUD"));
					txtname.setText(rs.getString("PNM"));
					txtage.setText(rs.getString("PAGE"));
					cmbgender.setSelectedItem(rs.getString("PGEN"));
					cmbcrime.setSelectedItem(rs.getString("PCR"));
					cmbslevel.setSelectedItem(rs.getString("PSL"));
					txtdoc.setText(rs.getString("PCD"));
					txtdoj.setText(rs.getString("PJD"));
					txtdor.setText(rs.getString("PRD"));
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