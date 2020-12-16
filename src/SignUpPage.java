import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.print.PrintException;
import javax.print.attribute.standard.PrinterState;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.*;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpPage extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField emp_id;
	private JTextField name;
	private JTextField post;
	private JTextField salary;
	private JTextField password;
	public SignUpPage() {
		setTitle("Sign Up Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		email = new JTextField();
		email.setToolTipText("enter your email");
		email.setBounds(302, 76, 265, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		emp_id = new JTextField();
		emp_id.setToolTipText("enter your emp id");
		emp_id.setBounds(302, 156, 265, 20);
		contentPane.add(emp_id);
		emp_id.setColumns(10);
		
		name = new JTextField();
		name.setToolTipText("enter your name");
		name.setBounds(302, 195, 265, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		post = new JTextField();
		post.setToolTipText("enter your post");
		post.setBounds(302, 228, 265, 20);
		contentPane.add(post);
		post.setColumns(10);
		
		salary = new JTextField();
		salary.setToolTipText("enter your salary");
		salary.setBounds(302, 259, 265, 20);
		contentPane.add(salary);
		salary.setColumns(10);
		
		JLabel l1 = new JLabel("Email:");
		l1.setBounds(195, 79, 116, 14);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Password:");
		l2.setBounds(195, 122, 116, 14);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Emploee_Id:");
		l3.setBounds(195, 159, 116, 14);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Name:");
		l4.setBounds(195, 198, 116, 14);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Post:");
		l5.setBounds(195, 231, 105, 14);
		contentPane.add(l5);
		
		JLabel l6 = new JLabel("Salary:");
		l6.setBounds(195, 262, 105, 14);
		contentPane.add(l6);
	
	
		
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Connection con=connect.getOracleConeection();
				String sql=null;
				sql="insert into employee(email,password,emp_id,name,post,salary) values(?,?,?,?,?,?)";
				try
				{
					con.setAutoCommit(true);
					PreparedStatement pst=con.prepareStatement(sql);
					pst.setString(1,email.getText());
					pst.setString(2,password.getText());
					pst.setInt(3,Integer.parseInt(emp_id.getText()));
					pst.setString(4,name.getText());
					pst.setString(5,post.getText());
					pst.setInt(6,Integer.parseInt(salary.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(new JDialog(),"successfully signup....");
					HomePage l=new HomePage();
					l.setVisible(true);
					dispose();
				}
				
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(new JDialog(),"Error in sign Up. Every place must be field.Email must be unique.salary,Employee id must be filled numeric value");
					E.printStackTrace();
				}
				
			}
		});
		signup.setBounds(251, 327, 105, 29);
		contentPane.add(signup);
		
		
		password = new JTextField();
		password.setBounds(302, 119, 265, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage h=new HomePage();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(397, 327, 110, 29);
		contentPane.add(btnNewButton);
		
		
	}
}
