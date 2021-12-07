package javaApplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class UpdateEmployee extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textFieldID;
	private JTextField textFieldSalary;
	private JButton btnSubmit;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Restaurant Chain Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 297, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update update = new Update();
				update.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(744, 37, 167, 40);
		contentPane.add(btnBack);
		
		lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(70, 186, 72, 40);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New Salary");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(70, 269, 93, 40);
		contentPane.add(lblNewLabel_2);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(188, 196, 102, 31);
		contentPane.add(textFieldID);
		
		textFieldSalary = new JTextField();
		textFieldSalary.setColumns(10);
		textFieldSalary.setBounds(188, 279, 145, 31);
		contentPane.add(textFieldSalary);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "Update F21_S003_7_Employee set salary = ? where empid = ?";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		        		pStatement.setInt(1, Integer.parseInt(textFieldSalary.getText()));
		        		pStatement.setInt(2, Integer.parseInt(textFieldID.getText()));
		                int result = pStatement.executeUpdate();
		        
		            }catch (SQLException e1) {

		                System.out.println("Error connecting to the DB");
		                System.exit(1);
		                e1.printStackTrace();
		            }
			       
			       
		           conn.close();
		        }
		        catch (SQLException e1) {
		 
					System.out.println("Error in accessing the relation");
					e1.printStackTrace();	
		 
				} 
			}
			
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubmit.setBounds(125, 364, 167, 40);
		contentPane.add(btnSubmit);
		
		lblNewLabel_3 = new JLabel("For EmployeeID put exisitng EmployeeID and for Salary enter any number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(43, 84, 444, 40);
		contentPane.add(lblNewLabel_3);
		
		
	}

}
