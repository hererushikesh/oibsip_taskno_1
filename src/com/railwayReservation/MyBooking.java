package com.railwayReservation;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MyBooking extends JFrame implements ActionListener {
	public JTable table;
	JButton mainbtn;

	MyBooking() {
		getContentPane().setBackground(new Color(64, 0, 64));
		setForeground(new Color(64, 0, 64));
		setBackground(new Color(64, 0, 64));

		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setTitle("MyBooking");
		setSize(1500, 600);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 64));
		panel.setBorder(new TitledBorder(null, "MyBooking", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(228, 53, 1113, 472);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 22, 1093, 439);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel heading_lbl = new JLabel("MyBooking");
		heading_lbl.setForeground(new Color(255, 255, 255));
		heading_lbl.setVerticalTextPosition(SwingConstants.TOP);
		heading_lbl.setVerticalAlignment(SwingConstants.TOP);
		heading_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		heading_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		heading_lbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
		heading_lbl.setBounds(10, 11, 1350, 31);
		getContentPane().add(heading_lbl);

		JButton showBtn = new JButton("Show Details");
		showBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = MySQLConnection.getConnection();

					Statement st = con.createStatement();
					String sql = "SELECT * FROM booking_details";
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
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		showBtn.setSize(new Dimension(10, 10));
		showBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		showBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		showBtn.setForeground(new Color(64, 0, 64));
		showBtn.setBackground(new Color(0, 128, 128));
		showBtn.setBounds(30, 118, 147, 44);
		getContentPane().add(showBtn);

		mainbtn = new JButton("Main Page");
		mainbtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mainbtn.setBounds(28, 185, 149, 44);
		mainbtn.addActionListener(this);
		getContentPane().add(mainbtn);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mainbtn) {
			this.dispose();
			MainPage main = new MainPage();
			main.setVisible(true);
		}
	}
}
