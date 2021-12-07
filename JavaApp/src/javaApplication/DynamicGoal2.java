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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class DynamicGoal2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textFieldName;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DynamicGoal2 frame = new DynamicGoal2();
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
	public DynamicGoal2() {
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
				BusinessGoals businessgoals = new BusinessGoals();
				businessgoals.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(744, 37, 167, 40);
		contentPane.add(btnBack);
		
		lblNewLabel_1 = new JLabel("Branch Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(34, 111, 100, 40);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Enter existing branch name to get the revenue of the branch example: Chicago");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(27, 60, 444, 40);
		contentPane.add(lblNewLabel_2);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(173, 116, 224, 30);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(174, 292, 751, 290);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select r.name, r.branchid, rev.revenue from F21_S003_7_RestaurantBranch r inner join\r\n"
		        	 		+ "(select branchid, sum(price) as revenue\r\n"
		        	 		+ "from F21_S003_7_Orders o , F21_S003_7_Transactions t\r\n"
		        	 		+ "where o.customerid = t.customerid\r\n"
		        	 		+ "group by rollup(branchid)\r\n"
		        	 		+ "order by revenue desc) rev\r\n"
		        	 		+ "on r.branchid = rev.branchid and r.name = ?";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		        		pStatement.setString(1, textFieldName.getText());
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
		btnSubmit.setBounds(173, 171, 167, 40);
		contentPane.add(btnSubmit);
		
		
		
		
	}
}
