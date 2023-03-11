package com.railwayReservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener {

	JPanel panel;
	JLabel headLabel, userLabel, passLabel;
	JButton button1, button2, button3;
	JTextField txtField;
	JPasswordField passField;
	JOptionPane optionPane;
	Font myFont = new Font("TIMESNEWROMAN", Font.BOLD, 25);

	LoginPage() {
		getContentPane().setBackground(new Color(64, 0, 64));
		setTitle("Rail Connect");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		headLabel = new JLabel();
		headLabel.setForeground(new Color(255, 255, 255));
		headLabel.setText("Login Yourself");
		headLabel.setBounds(156, 11, 200, 50);
		headLabel.setFont(myFont);

		userLabel = new JLabel();
		userLabel.setForeground(new Color(255, 255, 255));
		userLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		userLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setText("UserName");
		userLabel.setBounds(10, 20, 137, 20);

		passLabel = new JLabel();
		passLabel.setForeground(new Color(255, 255, 255));
		passLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		passLabel.setText("Password");
		passLabel.setBounds(43, 59, 70, 20);

		txtField = new JTextField();
		txtField.setBounds(139, 19, 150, 25);

		passField = new JPasswordField();
		passField.setBounds(139, 58, 150, 25);

		button1 = new JButton();
		button1.setText("Login");
		button1.setBounds(20, 128, 65, 25);
		button1.addActionListener(this);

		button2 = new JButton();
		button2.setText("Cancel");
		button2.setBounds(100, 128, 80, 25);
		button2.addActionListener(this);

		button3 = new JButton();
		button3.setText("New Registration");
		button3.setBounds(190, 128, 150, 25);
		button3.addActionListener(this);

		panel = new JPanel();
		panel.setBackground(new Color(64, 0, 64));
		panel.setBounds(98, 72, 371, 208);
		panel.setLayout(null);
		panel.add(userLabel);
		panel.add(passLabel);
		panel.add(txtField);
		panel.add(passField);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		getContentPane().add(panel);
		getContentPane().add(headLabel);
		getContentPane().setLayout(null);
		setSize(567, 415);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String userName = txtField.getText();
		@SuppressWarnings("deprecation")
		String passWord = passField.getText();

		boolean userPresent = RailMySqlConnection.isUserPresent(userName, passWord);

		txtField.setText("");
		passField.setText("");
		txtField.requestFocus();

		if (userPresent && e.getSource() == button1) {
			JOptionPane.showMessageDialog(button1, "Successfully log In", "Congratulations",
					JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			MainPage second = new MainPage();
			second.setVisible(true);
		} else if (e.getSource() == button3) {
			this.dispose();
			NewRegistration myRegistration = new NewRegistration();
			myRegistration.setVisible(true);
		} else if (e.getSource() == button2) {
			if (JOptionPane.showConfirmDialog(button2, "Confirm if you want to exit", "Login System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		} else {
			JOptionPane.showMessageDialog(button1, "Login Failed", "Somthing went wrong", 0);
		}
	}

	public static void main(String[] args) {
		new LoginPage();
	}
}
