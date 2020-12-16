import java.awt.BorderLayout;
import java.sql.*;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class HomePage extends JFrame {

	private JPanel contentPane;
	public static boolean time=false;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
						HomePage frame = new HomePage();
						frame.setVisible(true);	
				} catch (Exception e) {	
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		setForeground(Color.CYAN);
		setResizable(false);
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 370);
		contentPane = new JPanel();
		contentPane.setForeground(Color.CYAN);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Sign Up or Log in to proceed.......\r\n");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(89, 40, 404, 26);
		contentPane.add(lblNewLabel);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage a=new LoginPage();
				a.setVisible(true);
				dispose();
			}
		});
		login.setBounds(210, 103, 103, 36);
		contentPane.add(login);
		
		JButton signup = new JButton("SignUp");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpPage a=new SignUpPage();
				a.setVisible(true);
				dispose();
			}
		});
		signup.setBounds(210, 172, 109, 36);
		contentPane.add(signup);
	}
}
