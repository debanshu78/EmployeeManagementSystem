import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditPage extends JFrame {

	private JPanel contentPane;
	private JTextField emp_id;
	private JTextField field;
	private JTextField value;
	public EditPage() {
		setTitle("Edit Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Id:");
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setBounds(99, 66, 109, 14);
		contentPane.add(lblNewLabel);
		
		emp_id = new JTextField();
		emp_id.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(new JDialog(),"You can not edit any other employee's data...");
			}
		});
		emp_id.setEditable(false);
		emp_id.setText(LoginPage.employee_id);
		emp_id.setBounds(234, 63, 132, 20);
		contentPane.add(emp_id);
		emp_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Field wants to modified:");
		lblNewLabel_1.setBounds(99, 100, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		field = new JTextField();
		field.setBounds(234, 97, 132, 20);
		contentPane.add(field);
		field.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Value:");
		lblNewLabel_2.setBounds(99, 140, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		value = new JTextField();
		value.setBounds(234, 137, 132, 20);
		contentPane.add(value);
		value.setColumns(10);
		
		JButton modify = new JButton("Modify");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=connect.getOracleConeection();
				
				String sql=null;
				sql="update employee set "+field.getText()+"=? where emp_id=? ";
				PreparedStatement pst = null;
				try {
					pst = con.prepareStatement(sql);
					con.setAutoCommit(true);
					if(field.getText().equals("salary") ||field.getText().equals("emp_id"))
					{
						pst.setInt(1,Integer.parseInt(value.getText()));	
					}
					else if(field.getText().equals("email") || field.getText().equals("name") || field.getText().equals("post") || field.getText().equals("password"))
					{
						pst.setString(1,value.getText());
					}
					pst.setInt(2,Integer.parseInt(LoginPage.employee_id));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(new JDialog(),"Successfully Modified");
					EditPage j=new EditPage();
					j.setVisible(true);
					dispose();
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(new JDialog(),"Problem in update");
					EditPage f=new EditPage();
					f.setVisible(true);
					dispose();
					System.out.println("Error in update");
				}
			}
		});
		modify.setBounds(119, 178, 89, 23);
		contentPane.add(modify);
		
		JButton Back = new JButton("Return");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPage h=new ViewPage();
				h.setVisible(true);
				dispose();
			}
		});
		Back.setBounds(234, 178, 89, 23);
		contentPane.add(Back);
	}
}
