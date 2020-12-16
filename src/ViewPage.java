import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public ViewPage() {
		setBackground(Color.CYAN);
		setTitle("Data View Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton edit = new JButton("Modify");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					EditPage a=new EditPage();
					a.setVisible(true);
					dispose();
			}
		});
		edit.setBounds(66, 329, 165, 34);
		contentPane.add(edit);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					DeletePage d=new DeletePage();
					d.setVisible(true);
					dispose();
				
			}
		});
		delete.setBounds(66, 387, 165, 34);
		contentPane.add(delete);
		
		JButton signOut = new JButton("Log Out");
		signOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage h=new LoginPage();
				h.setVisible(true);
				JOptionPane.showMessageDialog(new JDialog(),"LogOut successfully");
			}
		});
		signOut.setBounds(311, 354, 149, 34);
		contentPane.add(signOut);
		
		
		
		
		
		
		Connection con=connect.getOracleConeection();
		String d[][];
		try
		{
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		String sql=null;
		
		sql="select email,emp_id,name,post,salary from employee";
		ResultSet rs=st.executeQuery(sql);
		rs.last();
		int row=rs.getRow();
		rs.beforeFirst();
		d=new String[row][5]; 
		int i=0;
		while(rs.next())
		{
			d[i][0]=rs.getString("name");
			d[i][1]=rs.getString("email");
			d[i][2]=rs.getInt("emp_id")+"";
			d[i][3]=rs.getString("post");
			d[i][4]=rs.getInt("salary")+"";
			i++;
		}

			rs.first();
			rs.last();
			System.out.println(rs.getRow());
			String coloumn[]= {"Name","Email","Employee_Id","Post","Salary"};
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 928, 307);
			contentPane.add(scrollPane);
			table = new JTable(d,coloumn);
			table.setFillsViewportHeight(true);
			table.setEnabled(false);
			table.setRowSelectionAllowed(false);
			scrollPane.setViewportView(table);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
