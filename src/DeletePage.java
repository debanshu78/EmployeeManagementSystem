import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DeletePage extends JFrame {

	private JPanel contentPane;
	private JTextField emp_id;

	public DeletePage() {
		setTitle("Delete Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		emp_id = new JTextField();
		emp_id.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(new JDialog(),"You can not delete any other employee's data...");
			}
		});
		emp_id.setEditable(false);
		emp_id.setText(LoginPage.employee_id);
		emp_id.setBounds(186, 73, 146, 20);
		contentPane.add(emp_id);
		emp_id.setColumns(10);
		
		JLabel userName = new JLabel("Employee Id:");
		userName.setBounds(88, 73, 106, 14);
		contentPane.add(userName);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=connect.getOracleConeection();
				String sql=null;
				sql="Delete from Employee where emp_id=?";
				PreparedStatement pst = null;
				try {
					con.setAutoCommit(true);
					pst = con.prepareStatement(sql);
					pst.setString(1,LoginPage.employee_id);
					int status2=pst.executeUpdate();
					if(status2==1)
					{
						JOptionPane.showMessageDialog(new JDialog(),"Successfully delete");
						DeletePage d=new DeletePage();
						d.setVisible(true);
						dispose();
					}
					else
					{
						throw new Exception();
					}
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(new JDialog(),"Error in delete");
					DeletePage d=new DeletePage();
					d.setVisible(true);
					dispose();
				}
		}
		});
		btnNewButton.setBounds(105, 135, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton back = new JButton("Return");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPage h=new ViewPage();
				h.setVisible(true);
				dispose();
			}
		});
		back.setBounds(218, 135, 89, 23);
		contentPane.add(back);
	}
}
