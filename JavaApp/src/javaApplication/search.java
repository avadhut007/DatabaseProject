package javaApplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class search extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnRestaurantBranch;
	private JButton btnOrders;
	private JButton btnTransactions;
	private JButton btnEmployees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search frame = new search();
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
	public search() {
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
				App app = new App();
				app.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(744, 37, 167, 40);
		contentPane.add(btnBack);
		
		btnRestaurantBranch = new JButton("Restaurant Branch");
		btnRestaurantBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select * from F21_S003_7_RestaurantBranch";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowRelations showrelations = new ShowRelations(result);
		                	showrelations.setVisible(true);
		    				dispose();
		                }
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
		btnRestaurantBranch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRestaurantBranch.setBounds(62, 158, 167, 40);
		contentPane.add(btnRestaurantBranch);
		
		btnOrders = new JButton("Orders");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select * from F21_S003_7_Orders";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowRelations showrelations = new ShowRelations(result);
		                	showrelations.setVisible(true);
		    				dispose();
		                }
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
		btnOrders.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrders.setBounds(62, 239, 167, 40);
		contentPane.add(btnOrders);
		
		btnTransactions = new JButton("Departments");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select * from F21_S003_7_Department";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowRelations showrelations = new ShowRelations(result);
		                	showrelations.setVisible(true);
		    				dispose();
		                }
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
		btnTransactions.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTransactions.setBounds(62, 324, 167, 40);
		contentPane.add(btnTransactions);
		
		btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select * from F21_S003_7_Employee";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowRelations showrelations = new ShowRelations(result);
		                	showrelations.setVisible(true);
		    				dispose();
		                }
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
		btnEmployees.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEmployees.setBounds(62, 406, 167, 40);
		contentPane.add(btnEmployees);
	}
}
