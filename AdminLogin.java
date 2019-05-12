/**
importing packages
*/

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
declaring class which extends JFRame and implementing ActionListener
*/
class AdminLogin extends JFrame implements ActionListener
{
	private JLabel title,  id, pass, loginas;
	private JButton login, reset, btcancel;
	private JTextField uname;
	private JPasswordField password;
	private JPanel header, footer, main;
	private Font f1, f2, f3;
	private Color c1, c2, c3;
	private JComboBox role;

		/**Declaring Constructor as public
		*/
		public AdminLogin()
	   {
			/**
			instantiating variables
			*/
			title=new JLabel("-_LOGIN HERE_-");
			id=new JLabel("ID :");
			pass=new JLabel("Password :");
			loginas=new JLabel("Login As:");
			login=new JButton("Login");
			reset=new JButton("Reset");
			btcancel=new JButton("Cancel");
			uname=new JTextField(5);
			password=new JPasswordField(5);
			header=new JPanel();
			footer=new JPanel();
			main=new JPanel();
			f1=new Font("Felix Titling", 1,23);
			f2=new Font("Lucida Sans Typewriter", 2, 18);
			f3=new Font("Lucida Sans Unicode", 1, 15);
			role=new JComboBox();
	   }
	   /**
	   declaring method to add all parts on fram*/

	   void ShowFrame()
	{
		   setTitle("Admin Login");
		   header.add(title);
		   header.setBackground(new Color(0, 153, 204));
		   title.setFont(f1);
		   add(header, BorderLayout.NORTH);
		   main.setLayout(null);
		   main.add(id);
		   main.add(uname);
		   main.add(pass);
		   main.add(password);
		   main.add(loginas);
		   main.add(role);
		   role.addItem("Admin");
		   role.addItem("Warden");
		   id.setBounds(130,67, 50,20);
		   uname.setBounds(210,69, 100,20);
		   pass.setBounds(130,107, 70,20);
		   password.setBounds(210,107, 100,20);
		   loginas.setBounds(130,147, 60,20);
		   role.setBounds(210,147, 70,20);
		   add(main, BorderLayout.CENTER);
		   footer.add(login);
		   login.setToolTipText("Click here to login");
		   reset.setToolTipText("Click here to Reset");
		   btcancel.setToolTipText("Click here to Cancel");
		   footer.add(reset);
		   footer.add(btcancel);
		   add(footer, BorderLayout.SOUTH);

		   setBounds(400,200, 400,400);
		   setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		   setVisible(true);
		   setResizable(false);
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   	login.addActionListener(this);
			btcancel.addActionListener(this);
		   
	}
	/**actionPerformed method*/
	public void actionPerformed (ActionEvent e)
	{
		String a,b,c;
		a=uname.getText();
		b=password.getText();
		c= (String) role.getSelectedItem();
		if( e.getSource()==login )
		{
			if( a.equals("") && b.equals("") )
			{
				JOptionPane.showMessageDialog(null, "Fields are empty !");
				setVisible(true);
			}
			else if(a.equals("admin") && b.equals("1234")  && c.equals("Admin"))
			{
				JOptionPane.showMessageDialog(null, "Login Successful");
				setVisible(false);
				ControlPanel cp=new ControlPanel();
				cp.adding();
				JOptionPane.showMessageDialog(null, "Welcome Admin !");
			}

			else if(a.equals("warden") && b.equals("1234")  && c.equals("Warden"))
			{
				JOptionPane.showMessageDialog(null, "Login Successful");
				setVisible(false);
				WardenControlPanel cp=new WardenControlPanel();
				cp.adding();
				JOptionPane.showMessageDialog(null, "Welcome Warden !");
			}

			else if ( a.equals("admin") && b.equals("") && c.equals("Admin"))
			{
				JOptionPane.showMessageDialog(null, "Password field is empty Admin !");
			}

			else if ( a.equals("") && b.equals("1234") && c.equals("Admin"))
			{
				JOptionPane.showMessageDialog(null, "ID field is empty Admin !");
			}


			else if ( a.equals("warden") && b.equals("") && c.equals("Warden"))
			{
				JOptionPane.showMessageDialog(null, "Password field is empty Warden !");
			}

			else if ( a.equals("") && b.equals("1234") && c.equals("Warden"))
			{
				JOptionPane.showMessageDialog(null, "ID field is empty Warden!");
			}


			else if( !a.equals("admin") && b.equals("1234") && c.equals("Admin") )
			{
				JOptionPane.showMessageDialog(null, "Wrong id Admin !");
			}

			else if( a.equals("admin") && !b.equals("1234") && c.equals("Admin") )
			{
				JOptionPane.showMessageDialog(null, "Wrong Password Admin !");
			}


			else if( !a.equals("Warden") && b.equals("1234") && c.equals("Warden") )
			{
				JOptionPane.showMessageDialog(null, "Wrong id Warden !");
			}

			else if( a.equals("Warden") && !b.equals("1234") && c.equals("Warden") )
			{
				JOptionPane.showMessageDialog(null, "Wrong Password Warden !");
			}


		
			else if( !a.equals("admin") && !b.equals("1234")  && c.equals("Admin"))
			{
				JOptionPane.showMessageDialog(null, "Wrong ID and Password of Admin !");
			}

			else if( !a.equals("Warden") && !b.equals("1234")  && c.equals("Warden"))
			{
				JOptionPane.showMessageDialog(null, "Wrong ID and Password of Warden!");
			}

		}
		else if (e.getSource()==btcancel)
		{
			System.exit(0);
		}
		
	}
	/**This is main method, calling will start from here*/
	public static void main(String args[])
	{
		AdminLogin al=new AdminLogin();
		al.ShowFrame();
		System.out.println("Execution Done !");
	}
}
