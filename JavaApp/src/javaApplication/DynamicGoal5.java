package javaApplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DynamicGoal5 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textFieldDay;
	private JTable table;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DynamicGoal5 frame = new DynamicGoal5();
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
	public DynamicGoal5() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Enter weekday to get the count of orders example: Monday");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(25, 61, 444, 40);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Week Day");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(25, 132, 100, 40);
		contentPane.add(lblNewLabel_1);
		
		textFieldDay = new JTextField();
		textFieldDay.setColumns(10);
		textFieldDay.setBounds(120, 142, 224, 30);
		contentPane.add(textFieldDay);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select count(orderid) as total_orders , weekday\r\n"
		        	 		+ "from F21_S003_7_Orders \r\n"
		        	 		+ "where weekday = ?\r\n"
		        	 		+ "group by weekday \r\n"
		        	 		+ "order by count(orderid) asc \r\n";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		        		pStatement.setString(1, textFieldDay.getText());
		        		ResultSet result = pStatement.executeQuery();
		        		table.setModel(DbUtils.resultSetToTableModel(result));
		        		
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
		btnSubmit.setBounds(120, 206, 167, 40);
		contentPane.add(btnSubmit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 294, 772, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessGoals businessgoals = new BusinessGoals();
				businessgoals.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(750, 34, 167, 40);
		contentPane.add(btnBack);
		

		
		
		
	}
}
