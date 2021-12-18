

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

public class BusinessGoals extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnGoal;
	private JButton btnGoal_1;
	private JButton btnGoal_2;
	private JButton btnGoal_3;
	private JButton btnGoal_4;
	private JButton btnGoal_5;
	private JButton btnGoal_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessGoals frame = new BusinessGoals();
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
	public BusinessGoals() {
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
		
		btnGoal = new JButton("Goal 1");
		btnGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String goalName = "Profit or loss of each branch";
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select r.name as BranchName, emp.branchid as BranchId, (total_sales - total_salary - total_expense) as profit\r\n"
		        	 		+ "from\r\n"
		        	 		+ "(select em.branchid,sum(em.salary) as total_salary\r\n"
		        	 		+ "from F21_S003_7_Employee em\r\n"
		        	 		+ "Group by em.branchid ) emp inner join \r\n"
		        	 		+ "(select ex.branchid , sum(ex.cost) as total_expense\r\n"
		        	 		+ "from F21_S003_7_Expenses ex\r\n"
		        	 		+ "where ex.expensedate like '%20'\r\n"
		        	 		+ "Group by ex.branchid) exp\r\n"
		        	 		+ "on emp.branchid = exp.branchid\r\n"
		        	 		+ "inner join \r\n"
		        	 		+ "(select t.branchid, sum(price) as total_sales\r\n"
		        	 		+ "from F21_S003_7_Orders o , F21_S003_7_Transactions t\r\n"
		        	 		+ "where o.customerid = t.customerid\r\n"
		        	 		+ "group by t.branchid) or_tr\r\n"
		        	 		+ "on or_tr.branchid = exp.branchid\r\n"
		        	 		+ "inner join F21_S003_7_RestaurantBranch r\r\n"
		        	 		+ "on r.branchid = exp.branchid";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowGoals showgoals = new ShowGoals(result, goalName);
		                	showgoals.setVisible(true);
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
		btnGoal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal.setBounds(39, 142, 167, 40);
		contentPane.add(btnGoal);
		
		btnGoal_1 = new JButton("Goal 2");
		btnGoal_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String goalName = "Branch with highest Revenue";
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select r.name, r.branchid, rev.revenue from F21_S003_7_RestaurantBranch r inner join\r\n"
		        	 		+ "(select branchid, sum(price) as revenue\r\n"
		        	 		+ "from F21_S003_7_Orders o , F21_S003_7_Transactions t\r\n"
		        	 		+ "where o.customerid = t.customerid\r\n"
		        	 		+ "group by rollup(branchid)\r\n"
		        	 		+ "order by revenue desc) rev\r\n"
		        	 		+ "on r.branchid = rev.branchid\r\n"
		        	 		+ "fetch first 1 row only";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowGoals showgoals = new ShowGoals(result, goalName);
		                	showgoals.setVisible(true);
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
		btnGoal_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_1.setBounds(39, 227, 167, 40);
		contentPane.add(btnGoal_1);
		
		btnGoal_2 = new JButton("Goal 4");
		btnGoal_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String goalName = "Which time of the day gets more orders (rush hours for restaurants)";
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select time, count(orderid) as no_of_orders\r\n"
		        	 		+ "from F21_S003_7_Orders \r\n"
		        	 		+ "group by time \r\n"
		        	 		+ "having count(orderid) = \r\n"
		        	 		+ "(select max(count(a.orderid)) \r\n"
		        	 		+ "from F21_S003_7_Orders a group by a.time)";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowGoals showgoals = new ShowGoals(result, goalName);
		                	showgoals.setVisible(true);
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
		btnGoal_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_2.setBounds(39, 311, 167, 40);
		contentPane.add(btnGoal_2);
		
		btnGoal_3 = new JButton("Goal 6");
		btnGoal_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String goalName = "Which are our regular customers?";
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select c.fname, c.lname, ord.customerid, ord.No_Of_Orders\r\n"
		        	 		+ "from F21_S003_7_Customer c inner join\r\n"
		        	 		+ "(select customerid, count(orderid) as No_Of_Orders\r\n"
		        	 		+ "from F21_S003_7_Orders\r\n"
		        	 		+ "group by rollup(customerid)\r\n"
		        	 		+ "having count(orderid) >=2 ) ord\r\n"
		        	 		+ "on ord.customerid  = c.customerid";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowGoals showgoals = new ShowGoals(result, goalName);
		                	showgoals.setVisible(true);
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
		btnGoal_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_3.setBounds(39, 394, 167, 40);
		contentPane.add(btnGoal_3);
		
		btnGoal_4 = new JButton("Goal 7");
		btnGoal_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String goalName = "Which branch has more expenses?";
				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "select r.name,\r\n"
		        	 		+ "(select sum(e.cost)\r\n"
		        	 		+ "from F21_S003_7_Expenses e\r\n"
		        	 		+ "Where expensedate like '%-20'\r\n"
		        	 		+ "and r.branchid = e.branchid\r\n"
		        	 		+ "group by e.branchid ) as total_expense\r\n"
		        	 		+ "from F21_S003_7_RestaurantBranch r\r\n"
		        	 		+ "order by total_expense desc \r\n"
		        	 		+ "fetch first 1 row only";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		                try (ResultSet result = pStatement.executeQuery()) {
		                	ShowGoals showgoals = new ShowGoals(result, goalName);
		                	showgoals.setVisible(true);
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
		btnGoal_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_4.setBounds(39, 472, 167, 40);
		contentPane.add(btnGoal_4);
		
		btnGoal_5 = new JButton("Dynamic Goal 2");
		btnGoal_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DynamicGoal2 dg2 = new DynamicGoal2();
				dg2.setVisible(true);
				dispose();
			}
		});
		btnGoal_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_5.setBounds(330, 227, 167, 40);
		contentPane.add(btnGoal_5);
		
		btnGoal_6 = new JButton("Dynamic Goal 5");
		btnGoal_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DynamicGoal5 dg5 = new DynamicGoal5();
				dg5.setVisible(true);
				dispose();
			}
		});
		btnGoal_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_6.setBounds(330, 394, 167, 40);
		contentPane.add(btnGoal_6);
		
	}

}
