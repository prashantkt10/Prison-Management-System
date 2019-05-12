import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
class AddPrisoner extends JFrame implements ActionListener
{
	private JLabel lblheader, lblfooter, lblid, lblname, lblage, lblgender, lblcrime, lblslevel, lblcrimedt, lbljoindt, lblreleasedt;
	private JTextField txtname, txtage, txtid;
	private JPanel header, footer, center;
	private Font f1, f2, f3, f4;
	private JButton btadd, btclear, btcancel, btsearch;
	private JComboBox cmbgender, cmbcrime, cmbslevel, cmbcrimedt, cmbcrimem, cmbcrimey, cmbjoindt, cmbjoinm, cmbjoiny, cmbreleasedt, cmbreleasem, cmbreleasey; 
	private String id, name, age, gender, crime, sl, cd, cm, cy, jd, jm, jy, rm, ry,rd;
	
	public AddPrisoner()
	{
		lblheader=new JLabel("___Add Prisoner___");
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
		btadd=new JButton("Add");
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
		cmbcrimedt=new JComboBox();
		cmbcrimem=new JComboBox();
		cmbcrimey=new JComboBox();
		cmbjoindt=new JComboBox();
		cmbjoinm=new JComboBox();
		cmbjoiny=new JComboBox();
		cmbreleasedt=new JComboBox();
		cmbreleasem=new JComboBox();
		cmbreleasey=new JComboBox();

	}

	public void ItemsAdd()
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
		center.add(cmbcrime);
		center.add(cmbslevel);
		center.add(cmbcrimedt);
		center.add(cmbcrimem);
		center.add(cmbcrimey);
		center.add(cmbjoindt);
		center.add(cmbjoinm);
		center.add(cmbjoiny);
		center.add(cmbreleasedt);
		center.add(cmbreleasem);
		center.add(cmbreleasey);
		center.add(txtname);
		center.add(txtage);
		center.add(txtid);
		center.add(lblid);
		center.add(btsearch);
		center.add(btadd);
		center.add(btclear);
		center.add(btcancel);

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
		cmbcrimedt.setBounds(300,277, 55,20);
		cmbcrimem.setBounds(360,277, 55,20);
		cmbcrimey.setBounds(420,277, 55,20);
		cmbjoindt.setBounds(300,317, 55,20);
		cmbjoinm.setBounds(360,317, 55,20);
		cmbjoiny.setBounds(420,317, 55,20);
		cmbreleasedt.setBounds(300,357, 55,20);
		cmbreleasem.setBounds(360,357, 55,20);
		cmbreleasey.setBounds(420,357, 55,20);
		btsearch.setBounds(470,37, 80,20);
		btadd.setBounds(120,410, 80,40);
		btclear.setBounds(260,410, 80,40);
		btcancel.setBounds(400,410, 80,40);

		cmbgender.addItem("Male");
		cmbgender.addItem("Female");
		cmbcrime.addItem("Murder");
		cmbcrime.addItem("Theft");
		cmbcrime.addItem("Terrorism");
		cmbcrime.addItem("Other");
		cmbslevel.addItem("Low");
		cmbslevel.addItem("Moderate");
		cmbslevel.addItem("High");

		cmbcrimedt.addItem("Date");
		cmbcrimem.addItem("Month");
		cmbcrimey.addItem("Year");

		cmbjoindt.addItem("Date");
		cmbjoinm.addItem("Month");
		cmbjoiny.addItem("Year");

		cmbreleasedt.addItem("Date");
		cmbreleasem.addItem("Month");
		cmbreleasey.addItem("Year");

		for(int count=1; count<=31; count++)
		{
			String s=new Integer (count).toString();
			cmbcrimedt.addItem(s);
		}

		for(int count=1; count<=12; count++)
		{
			String s=new Integer (count).toString();
			cmbcrimem.addItem(s);
		}

		for(int count=1990; count<=2050; count++)
		{
			String s=new Integer (count).toString();
			cmbcrimey.addItem(s);
		}

		for(int count=1; count<=31; count++)
		{
			String s=new Integer (count).toString();
			cmbjoindt.addItem(s);
		}

		for(int count=1; count<=12; count++)
		{
			String s=new Integer (count).toString();
			cmbjoinm.addItem(s);
		}

		for(int count=1990; count<=2050; count++)
		{
			String s=new Integer (count).toString();
			cmbjoiny.addItem(s);
		}

		for(int count=1; count<=31; count++)
		{
			String s=new Integer (count).toString();
			cmbreleasedt.addItem(s);
		}

		for(int count=1; count<=12; count++)
		{
			String s=new Integer (count).toString();
			cmbreleasem.addItem(s);
		}

		for(int count=1990; count<=2050; count++)
		{
			String s=new Integer (count).toString();
			cmbreleasey.addItem(s);
		}
		
		setTitle("Prisoner Details");
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setIconImage (getToolkit().getImage ("prisoner.png"));
		setBounds(400,70, 600,600);
		setResizable(false);
		setVisible(true);
		btsearch.setEnabled(false);

		btadd.addActionListener(this);
		btclear.addActionListener(this);
		btcancel.addActionListener(this);
	}

	void clear()
	{
		txtid.setText("");
		txtname.setText("");
		txtage.setText("");
		cmbcrimedt.setSelectedIndex(0);
		cmbcrimem.setSelectedIndex(0);
		cmbcrimey.setSelectedIndex(0);
		cmbjoindt.setSelectedIndex(0);
		cmbjoinm.setSelectedIndex(0);
		cmbjoiny.setSelectedIndex(0);
		cmbreleasedt.setSelectedIndex(0);
		cmbreleasem.setSelectedIndex(0);
		cmbreleasey.setSelectedIndex(0);
		cmbgender.setSelectedIndex(0);
		cmbcrime.setSelectedIndex(0);
		cmbslevel.setSelectedIndex(0);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btadd)
		{
			Add();
		}
		if (e.getSource()==btcancel)
		{
			dispose();
		}
		if (e.getSource()==btclear)
		{
			clear();
		}
	}

	public static void main(String args[])
	{
		AddPrisoner api=new AddPrisoner();
		api.ItemsAdd();
		System.out.println("Execution Done !");
	}


public void Add()
	{
	String jdate;
	String cdate;
	String rdate;
Connection con=null;
		id=txtid.getText();
		name=txtname.getText();
		age=txtage.getText();
		gender= (String) cmbgender.getSelectedItem();
		crime= (String) cmbcrime.getSelectedItem();
		sl= (String) cmbslevel.getSelectedItem();
		cd= (String) cmbcrimedt.getSelectedItem();
		cm= (String) cmbcrimem.getSelectedItem();
		cy= (String) cmbcrimey.getSelectedItem();
		jd= (String) cmbjoindt.getSelectedItem();
		jm= (String) cmbjoinm.getSelectedItem();
		jy= (String) cmbjoiny.getSelectedItem();
		rd= (String) cmbreleasedt.getSelectedItem();
		rm= (String) cmbreleasem.getSelectedItem();
		ry= (String) cmbreleasey.getSelectedItem();
		cdate=cd+"/"+cm+"/"+cy;
		jdate=jd+"/"+jm+"/"+jy;
		rdate=rd+"/"+rm+"/"+ry;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","123");
			Statement st=con.createStatement();
		
			String x="insert into  PRDB (PUD, PNM, PAGE, PGEN, PCR, PSL, PCD, PJD, PRD) values ('" + id + "','" + name + "', '"+age+"', '"+gender+"', '"+crime+"', '"+sl+"', '"+cdate+"', '"+jdate+"', '"+rdate+"')";
			st.execute(x);
			JOptionPane.showMessageDialog(null, "New Entry addedd Sucessfuly");
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