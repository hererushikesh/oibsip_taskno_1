package com.railwayReservation;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class CancelTicket extends JFrame implements ActionListener {

	private JTable table;
	JButton mainbtn;

	CancelTicket() {
		getContentPane().setBackground(new Color(64, 0, 64));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 500);
		setTitle("Cancel_Ticket");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Cancellation Ticket");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 1164, 32);
		getContentPane().add(lblNewLabel);

		JButton Cancelbtn = new JButton("Cancel Ticket");
		Cancelbtn.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
			DefaultTableModel model=(DefaultTableModel) table.getModel();
		
				int row = table.getSelectedRow();
				String cell = (String) table.getModel().getValueAt(row, 0);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rail", "root", "admin");
					PreparedStatement ps = con.prepareStatement("DELETE FROM booking_details where srNo=" + cell);

					ps.executeUpdate();

					JOptionPane.showMessageDialog(null, "Successfully Canceled");

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				model.removeRow(table.getSelectedRow());

			}
		});
		Cancelbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		Cancelbtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		Cancelbtn.setBounds(47, 183, 137, 32);
		getContentPane().add(Cancelbtn);

		mainbtn = new JButton("Main Page");
		mainbtn.addActionListener(this);

		mainbtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		mainbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		mainbtn.setBounds(47, 226, 137, 32);
		getContentPane().add(mainbtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 54, 916, 379);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton seebtn = new JButton("Show Ticket");
		seebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/rail", "root", "admin");

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
						String fromAddress, toAddress, date, name, address, email, gender,pnr;

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
							pnr=rs.getString(12);
							
							String[] row = { srNo, trainNo, fromAddress, toAddress, date, amount, name, address, email,
									age, gender,pnr};
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
		seebtn.setFont(new Font("Times New Roman", Font.BOLD, 17));
		seebtn.setBounds(47, 140, 137, 32);
		getContentPane().add(seebtn);

		setVisible(true);
	}

	public static void main(String[] args) {

		new CancelTicket();

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
