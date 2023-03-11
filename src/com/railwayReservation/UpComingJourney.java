package com.railwayReservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UpComingJourney extends JFrame implements ActionListener {
	int i = 0, num = 0;
	JProgressBar progressBar;
	private JTable table2;
	private JTable table;
	private JButton mainpage_btn;
	public UpComingJourney() {
		getContentPane().setBackground(new Color(64, 0, 64));
		getContentPane().setForeground(new Color(255, 255, 255));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,700);
		setTitle("Up_Coming_Journey");
		getContentPane().setLayout(null);
		
		JLabel headingLbl = new JLabel("UpComing Journey");
		headingLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		headingLbl.setHorizontalAlignment(SwingConstants.CENTER);
		headingLbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
		headingLbl.setForeground(new Color(255, 255, 255));
		headingLbl.setBounds(10, 11, 1164, 28);
		getContentPane().add(headingLbl);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 346, 1184, 2);
		getContentPane().add(separator);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel2.setBorder(new TitledBorder(null, "Completed Journey", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel2.setBounds(215, 359, 959, 270);
		getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 17, 939, 246);
		panel2.add(scrollPane_2);
		
		table2 = new JTable();
		scrollPane_2.setViewportView(table2);
		
		JButton upcomingBtn = new JButton("UpComing Journey");
		upcomingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = MySQLConnection.getConnection();
					Statement st = con.createStatement();

					String sql = "SELECT * FROM rail.booking_details WHERE date> DATE_SUB(CURDATE(), INTERVAL 1 DAY)";
					ResultSet rs = st.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i = 0; i < cols; i++) {
						colName[i] = rsmd.getColumnName(i + 1);
						model.setColumnIdentifiers(colName);

						String srNo;
						String trainNo;
						String amount;
						String age;
						String fromAddress, toAddress, date, name, address, email, gender;

						while (rs.next()) {
							srNo = rs.getString(1);
							trainNo = rs.getString(2);
							fromAddress = rs.getString(3);
							toAddress = rs.getString(4);
							date = rs.getString(5);
							amount = rs.getString(6);
							name = rs.getString(7);
							address = rs.getString(8);
							email = rs.getString(9);
							age = rs.getString(10);
							gender = rs.getString(11);
							String[] row = { srNo, trainNo, fromAddress, toAddress, date, amount, name, address, email,
									age, gender };
							model.addRow(row);
						}
					}
					st.close();
					con.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		upcomingBtn.setBackground(new Color(0, 64, 64));
		upcomingBtn.setForeground(new Color(255, 255, 255));
		upcomingBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		upcomingBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		upcomingBtn.setBounds(10, 167, 168, 40);
		getContentPane().add(upcomingBtn);
		
		JButton completedBtn = new JButton("Completed Journey");
		completedBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = MySQLConnection.getConnection();

					Statement st = con.createStatement();

					String sql = "SELECT * FROM rail.booking_details WHERE date < DATE_SUB(CURDATE(), INTERVAL 1 DAY)";
					ResultSet rs = st.executeQuery(sql);
					ResultSetMetaData rsmd = rs.getMetaData();

					DefaultTableModel model = (DefaultTableModel) table2.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i = 0; i < cols; i++) {
						colName[i] = rsmd.getColumnName(i + 1);
						model.setColumnIdentifiers(colName);

						String srNo;
						String trainNo;
						String amount;
						String age;
						String fromAddress, toAddress, date, name, address, email, gender;

						while (rs.next()) {
							srNo = rs.getString(1);
							trainNo = rs.getString(2);
							fromAddress = rs.getString(3);
							toAddress = rs.getString(4);
							date = rs.getString(5);
							amount = rs.getString(6);
							name = rs.getString(7);
							address = rs.getString(8);
							email = rs.getString(9);
							age = rs.getString(10);
							gender = rs.getString(11);
							String[] row = { srNo, trainNo, fromAddress, toAddress, date, amount, name, address, email,
									age, gender };
							model.addRow(row);
						}
					}
					st.close();
					con.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		completedBtn.setBackground(new Color(0, 64, 64));
		completedBtn.setForeground(new Color(255, 255, 255));
		completedBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		completedBtn.setBounds(10, 495, 168, 40);
		getContentPane().add(completedBtn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "UpComing", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(215, 50, 959, 270);
		getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 16, 939, 246);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		mainpage_btn = new JButton("Main-Page");
		mainpage_btn.addActionListener(this);
		mainpage_btn.setForeground(Color.WHITE);
		mainpage_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		mainpage_btn.setBackground(new Color(0, 64, 64));
		mainpage_btn.setBounds(10, 568, 168, 40);
		getContentPane().add(mainpage_btn);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mainpage_btn) {
			MainPage main=new MainPage();
			main.setVisible(true);
			this.dispose();
		}
	}
}
