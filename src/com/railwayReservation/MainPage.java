package com.railwayReservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MainPage extends JFrame implements ActionListener {

	ImageIcon icon = new ImageIcon("train.png");
	ImageIcon icon1 = new ImageIcon("icon1.png");
	ImageIcon icon2 = new ImageIcon("icon2.png");
	ImageIcon icon3 = new ImageIcon("icon3.png");
	ImageIcon icon4 = new ImageIcon("icon4.png");
	ImageIcon icon5 = new ImageIcon("icon5.png");
	ImageIcon icon6 = new ImageIcon("icon6.png");
	ImageIcon icon7 = new ImageIcon("icon7.png");

	JPanel panel;
	JButton bookTicket_btn, myBooking_btn, cancelTicket_btn, upComingJourney_btn;
	JButton back_btn, cancelProgram_btn, love_btn;
	JLabel heading, bookTicket_lbl, myBooking_lbl, cancelTickt_lbl, upComingJourney_lbl;
	JLabel back_lbl, cancelProgram_lbl, love_lbl;

	Font myFont = new Font("TimesNewRoman", Font.BOLD, 13);
	JOptionPane optionPane;

	MainPage() {
		getContentPane().setBackground(new Color(64, 0, 64));

		heading = new JLabel();
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setText("Welcome to RailConnect");
		heading.setHorizontalTextPosition(JLabel.CENTER);
		heading.setVerticalTextPosition(JLabel.TOP);
		heading.setFont(new Font("TimesNewRoman", Font.BOLD, 18));
		heading.setForeground(new Color(255, 255, 255));
		heading.setBounds(10, 15, 384, 20);

		panel = new JPanel();
		panel.setBounds(50, 52, 300, 420);
		panel.setBackground(new Color(64, 0, 64));
		panel.setLayout(null);
		panel.setBorder(new TitledBorder("Click On Button & Proceed Further"));

		bookTicket_btn = new JButton();
		bookTicket_btn.addActionListener(this);
		bookTicket_btn.setIcon(icon1);
		bookTicket_btn.setBounds(120, 30, 45, 40);
		bookTicket_btn.setBorder(new BevelBorder(2));
		bookTicket_btn.setBorderPainted(true);
		bookTicket_btn.setFocusPainted(true);
		bookTicket_btn.setPressedIcon(icon1);
		bookTicket_btn.setOpaque(true);
		bookTicket_btn.setSelectedIcon(icon1);
		bookTicket_btn.setBackground(Color.white);

		panel.add(bookTicket_btn);

		bookTicket_lbl = new JLabel();
		bookTicket_lbl.setForeground(Color.WHITE);
		bookTicket_lbl.setText("Book Ticket");
		bookTicket_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		bookTicket_lbl.setBounds(90, 60, 100, 40);
		bookTicket_lbl.setFont(myFont);
		panel.add(bookTicket_lbl);

		myBooking_btn = new JButton();
		myBooking_btn.setIcon(icon2);
		myBooking_btn.setBounds(120, 100, 45, 45);
		myBooking_btn.setBorder(new BevelBorder(2));
		myBooking_btn.setBorderPainted(true);
		myBooking_btn.setFocusPainted(true);
		myBooking_btn.setPressedIcon(icon2);
		myBooking_btn.setOpaque(true);
		myBooking_btn.setSelectedIcon(icon2);
		myBooking_btn.setBackground(Color.white);
		myBooking_btn.addActionListener(this);
		panel.add(myBooking_btn);

		myBooking_lbl = new JLabel();
		myBooking_lbl.setForeground(Color.WHITE);
		myBooking_lbl.setText("My Booking");
		myBooking_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		myBooking_lbl.setBounds(90, 138, 100, 33);
		myBooking_lbl.setFont(myFont);
		panel.add(myBooking_lbl);

		cancelTicket_btn = new JButton();
		cancelTicket_btn.setIcon(icon3);
		cancelTicket_btn.setBounds(120, 170, 45, 40);
		cancelTicket_btn.setBorder(new BevelBorder(2));
		cancelTicket_btn.setBorderPainted(true);
		cancelTicket_btn.setFocusPainted(true);
		cancelTicket_btn.setPressedIcon(icon3);
		cancelTicket_btn.setOpaque(true);
		cancelTicket_btn.setSelectedIcon(icon3);
		cancelTicket_btn.setBackground(Color.white);
		cancelTicket_btn.addActionListener(this);
		panel.add(cancelTicket_btn);

		cancelTickt_lbl = new JLabel();
		cancelTickt_lbl.setForeground(Color.WHITE);
		cancelTickt_lbl.setText("Cancel Ticket");
		cancelTickt_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		cancelTickt_lbl.setBounds(90, 200, 100, 40);
		cancelTickt_lbl.setFont(myFont);
		panel.add(cancelTickt_lbl);

		upComingJourney_btn = new JButton();
		upComingJourney_btn.setIcon(icon4);
		upComingJourney_btn.setBounds(120, 240, 45, 40);
		upComingJourney_btn.setBorder(new BevelBorder(2));
		upComingJourney_btn.setBorderPainted(true);
		upComingJourney_btn.setFocusPainted(true);
		upComingJourney_btn.setPressedIcon(icon4);
		upComingJourney_btn.setOpaque(true);
		upComingJourney_btn.setSelectedIcon(icon4);
		upComingJourney_btn.setBackground(Color.white);
		upComingJourney_btn.addActionListener(this);
		panel.add(upComingJourney_btn);

		upComingJourney_lbl = new JLabel();
		upComingJourney_lbl.setForeground(Color.WHITE);
		upComingJourney_lbl.setText("Upcoming Journey");
		upComingJourney_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		upComingJourney_lbl.setBounds(90, 272, 120, 40);
		upComingJourney_lbl.setFont(myFont);
		panel.add(upComingJourney_lbl);

		back_btn = new JButton();
		back_btn.setIcon(icon5);
		back_btn.setBounds(30, 315, 45, 40);
		back_btn.setBorder(new BevelBorder(2));
		back_btn.setBorderPainted(true);
		back_btn.setFocusPainted(true);
		back_btn.setPressedIcon(icon5);
		back_btn.setOpaque(true);
		back_btn.setSelectedIcon(icon5);
		back_btn.setBackground(Color.white);
		back_btn.addActionListener(this);
		panel.add(back_btn);

		back_lbl = new JLabel();
		back_lbl.setForeground(Color.WHITE);
		back_lbl.setText("Back");
		back_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		back_lbl.setBounds(30, 345, 50, 40);
		back_lbl.setFont(myFont);
		panel.add(back_lbl);

		cancelProgram_btn = new JButton();
		cancelProgram_btn.setIcon(icon6);
		cancelProgram_btn.setBounds(120, 315, 45, 40);
		cancelProgram_btn.setBorder(new BevelBorder(2));
		cancelProgram_btn.setBorderPainted(true);
		cancelProgram_btn.setFocusPainted(true);
		cancelProgram_btn.setPressedIcon(icon6);
		cancelProgram_btn.setOpaque(true);
		cancelProgram_btn.setSelectedIcon(icon6);
		cancelProgram_btn.setBackground(Color.white);
		cancelProgram_btn.addActionListener(this);
		panel.add(cancelProgram_btn);

		cancelProgram_lbl = new JLabel();
		cancelProgram_lbl.setForeground(Color.WHITE);
		cancelProgram_lbl.setText("Cancel Program");
		cancelProgram_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		cancelProgram_lbl.setBounds(80, 345, 120, 40);
		cancelProgram_lbl.setFont(myFont);
		panel.add(cancelProgram_lbl);

		love_btn = new JButton();
		love_btn.setIcon(icon7);
		love_btn.setBounds(210, 315, 45, 40);
		love_btn.setBorder(new BevelBorder(2));
		love_btn.setBorderPainted(true);
		love_btn.setFocusPainted(true);
		love_btn.setPressedIcon(icon7);
		love_btn.setOpaque(true);
		love_btn.setSelectedIcon(icon7);
		love_btn.setBackground(Color.white);
		love_btn.addActionListener(this);
		panel.add(love_btn);

		love_lbl = new JLabel();
		love_lbl.setForeground(Color.WHITE);
		love_lbl.setText("Love");
		love_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		love_lbl.setBounds(170, 345, 120, 40);
		love_lbl.setFont(myFont);
		panel.add(love_lbl);

		getContentPane().add(heading);
		getContentPane().add(panel);
		this.setAlwaysOnTop(isAlwaysOnTop());
		this.setIconImage(icon.getImage());
		this.setTitle("Train");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420, 550);
		this.setBackground(Color.white);
		getContentPane().setLayout(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent eve) {
		if (eve.getSource() == bookTicket_btn) {
			this.dispose();
			Booking booking = new Booking();
			booking.setVisible(true);
		} else if (eve.getSource() == myBooking_btn) {
			this.dispose();
			MyBooking myBooking = new MyBooking();
			myBooking.setVisible(true);
		} else if (eve.getSource() == cancelTicket_btn) {
			this.dispose();
			CancelTicket cancelTicket = new CancelTicket();
			cancelTicket.setVisible(true);
		} else if (eve.getSource() == upComingJourney_btn) {
			this.dispose();
			UpComingJourney journey = new UpComingJourney();
			journey.setVisible(true);
		} else if (eve.getSource() == back_btn) {
			this.dispose();
			LoginPage backPage = new LoginPage();
			backPage.setVisible(true);
		} else if (eve.getSource() == cancelProgram_btn) {
			if (JOptionPane.showConfirmDialog(cancelProgram_btn, "Confirm if you want to exit", "To Quite",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}
	}
}
