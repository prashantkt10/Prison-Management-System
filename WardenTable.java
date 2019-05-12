import javax.swing.*;  
public class WardenTable 
{  
    JFrame f;  
	WardenTable()
	{  
		f=new JFrame();  
		String data[][]={ {"101","Amit","670000","5"}, {"102","Jai","780000","5"}, {"101","Sachin","700000","5"}};  
		String column[]={"UNIQUE ID","FULL NAME","RANK,", "Date of Joinning"};  
        JTable jt=new JTable(data,column);  
		jt.setBounds(10,10,1000,700);  
		JScrollPane sp=new JScrollPane(jt);  
		f.add(sp);  
		f.setBounds(50,50, 1200,600); 
		f.setVisible(true);  
	}
	public static void main(String[] args) {  
    new WardenTable();  
	}  
}  
