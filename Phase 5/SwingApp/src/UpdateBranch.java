

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
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class UpdateBranch extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textFieldBName;
	private JTextField textFieldID;
	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBranch frame = new UpdateBranch();
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
	public UpdateBranch() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Branch ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(44, 132, 72, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New Branch Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(44, 204, 119, 40);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldBName = new JTextField();
		textFieldBName.setBounds(217, 209, 205, 31);
		contentPane.add(textFieldBName);
		textFieldBName.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(217, 137, 102, 31);
		contentPane.add(textFieldID);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn = DBconnection.DBconnect();
				try {
		        	 String query = "Update F21_S003_7_RestaurantBranch set name = ? where branchid = ?";
		        	try (PreparedStatement pStatement = conn.prepareStatement(query)) {
		        		pStatement.setString(1, textFieldBName.getText());
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
		btnSubmit.setBounds(44, 305, 167, 40);
		contentPane.add(btnSubmit);
		
		lblNewLabel_2 = new JLabel("For BranchID put exisitng BranchID and for Branch Name enter any city name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(44, 64, 444, 40);
		contentPane.add(lblNewLabel_2);
		
		
		
		
	}
}
