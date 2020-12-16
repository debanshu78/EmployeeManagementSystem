import java.awt.BorderLayout;
import java.sql.*;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField password;
	public static String employee_id=null;

	public LoginPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setBounds(224, 103, 183, 23);
		contentPane.add(id);
		id.setColumns(10);
		
		password = new JTextField();
		password.setBounds(224, 151, 183, 23);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(135, 106, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(136, 154, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=connect.getOracleConeection();
				String sql=null;
				
				System.out.println(sql);
				try
				{
					Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					System.out.println(id.getText());
					employee_id=id.getText(); 
					sql="select password from employee where emp_id="+employee_id;
					ResultSet rs=st.executeQuery(sql);
					String pass=null;
					while(rs.next())
					{
						 pass=rs.getString("password");
					}
					System.out.println(pass);
					System.out.println(password.getText());
					if(pass.equals(password.getText()))
					{
						dispose();
						ViewPage a=new ViewPage();
						a.setVisible(true);
						JOptionPane.showMessageDialog(new JDialog(),"Login successfully");
					}
					else
					{
						throw new SQLException();
					}

				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(new JDialog(),"username or password does not matched");
					System.out.println(e);
					E.printStackTrace();
				}
			}
		});
		login.setBounds(166, 199, 106, 23);
		contentPane.add(login);
		
		JButton HomePage = new JButton("Back");
		HomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage h=new HomePage();
				h.setVisible(true);
				dispose();
			}
		});
		HomePage.setBounds(293, 199, 106, 23);
		contentPane.add(HomePage);
	}
}
