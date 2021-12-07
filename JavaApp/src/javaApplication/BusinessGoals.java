package javaApplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			}
		});
		btnGoal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal.setBounds(39, 142, 167, 40);
		contentPane.add(btnGoal);
		
		btnGoal_1 = new JButton("Goal 2");
		btnGoal_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_1.setBounds(39, 227, 167, 40);
		contentPane.add(btnGoal_1);
		
		btnGoal_2 = new JButton("Goal 4");
		btnGoal_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_2.setBounds(39, 311, 167, 40);
		contentPane.add(btnGoal_2);
		
		btnGoal_3 = new JButton("Goal 6");
		btnGoal_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoal_3.setBounds(39, 394, 167, 40);
		contentPane.add(btnGoal_3);
		
		btnGoal_4 = new JButton("Goal 7");
		btnGoal_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
