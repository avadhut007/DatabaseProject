package javaApplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class App extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Search Queries");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search search = new search();
				search.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(62, 181, 167, 40);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Restaurant Chain Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 297, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnUpdata = new JButton("Update");
		btnUpdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update update = new Update();
				update.setVisible(true);
				dispose();
			}
		});
		btnUpdata.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdata.setBounds(361, 181, 167, 40);
		contentPane.add(btnUpdata);
		
		JButton btnBusinessGoals = new JButton("Business Goals");
		btnBusinessGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessGoals goal = new BusinessGoals();
				goal.setVisible(true);
				dispose();
			}
		});
		btnBusinessGoals.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBusinessGoals.setBounds(647, 181, 167, 40);
		contentPane.add(btnBusinessGoals);
		
		
		
		
		/*
		try {
		System.out.println("Closing the connection");	
		conn.close();
		} catch (SQLException e) {

            System.out.println("error when closing the connection");
            System.exit(1);
            e.printStackTrace();
        } */
		
	}


}
