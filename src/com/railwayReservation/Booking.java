package com.railwayReservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Booking extends JFrame implements ActionListener {
	private JTextField amount;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtEmail;
	JButton addPassenger_btn;
	private JTable table;
	@SuppressWarnings("rawtypes")
	JComboBox txtGender;
	JComboBox trainNumber_comboBox;
	JComboBox from_comboBox;
	JComboBox to_comboBox;
	JFormattedTextField date_textField;
	JButton main_btn;

	Booking() {
		getContentPane().setBackground(new Color(64, 0, 64));

		setAlwaysOnTop(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(771, 520);
		setTitle("Booking");
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 64));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		panel.setForeground(new Color(0, 139, 139));
		panel.setBorder(new TitledBorder(null, "Book Ticket", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 734, 445);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel to_lbl = new JLabel("To");
		to_lbl.setForeground(Color.WHITE);
		to_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		to_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		to_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		to_lbl.setBounds(10, 168, 27, 14);
		panel.add(to_lbl);

		JLabel from_lbl = new JLabel("From");
		from_lbl.setForeground(Color.WHITE);
		from_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		from_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		from_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		from_lbl.setBounds(10, 115, 48, 14);
		panel.add(from_lbl);

		JButton btnSubmit = new JButton("Book Ticket");
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String TrainNumber = trainNumber_comboBox.getSelectedItem().toString();
				String fromAddress = (String) from_comboBox.getSelectedItem();
				String toAddress = (String) to_comboBox.getSelectedItem();
				String date = (String) date_textField.getText();
				int amountVale = Integer.parseInt(amount.getText());

				DefaultTableModel model = (DefaultTableModel) table.getModel();

				for (int i = 0; model.getRowCount() > i; i++) {

					String name = (String) model.getValueAt(i, 0);
					String address = (String) model.getValueAt(i, 1);
					String email = (String) model.getValueAt(i, 2);
					String age = (String) model.getValueAt(i, 3);
					String gender = (String) model.getValueAt(i, 4);
					int age1 = Integer.parseInt(age);
					int trainNumer = Integer.parseInt(TrainNumber);
					BookingSql.insertDataIntoBookingTable(trainNumer, fromAddress, toAddress, date, amountVale, name,
							address, email, age1, gender);
				}

				JOptionPane.showMessageDialog(btnSubmit, "Successfully booked!");

			}
		});
		btnSubmit.setBounds(10, 338, 138, 30);
		// btnSubmit.add(addPassenger_btn);
		panel.add(btnSubmit);

		JButton btn_Cancel = new JButton("Exit");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showConfirmDialog(btn_Cancel, " Are You confirm to Exit From the Page", "Exit",
						JOptionPane.YES_NO_OPTION);
				{
					System.exit(0);
				}
			}
		});
		btn_Cancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_Cancel.setBounds(158, 338, 138, 30);
		panel.add(btn_Cancel);

		JLabel trainNumber_lbl = new JLabel("Train Number");
		trainNumber_lbl.setForeground(Color.WHITE);
		trainNumber_lbl.setHorizontalTextPosition(SwingConstants.LEFT);
		trainNumber_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		trainNumber_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		trainNumber_lbl.setBounds(10, 60, 138, 14);
		panel.add(trainNumber_lbl);

		trainNumber_comboBox = new JComboBox();
		trainNumber_comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		trainNumber_comboBox.setMaximumRowCount(10);
		trainNumber_comboBox.setModel(new DefaultComboBoxModel(new String[] { "12026", "12150", "12164", "12196",
				"12206", "12222", "19106", "17032", "14258", "14318" }));
		trainNumber_comboBox.setName("");
		trainNumber_comboBox.setToolTipText("here");
		trainNumber_comboBox.setBounds(116, 53, 158, 30);
		panel.add(trainNumber_comboBox);

		from_comboBox = new JComboBox();
		from_comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		from_comboBox.setModel(new DefaultComboBoxModel(new String[] { "Pune", "Pune", "Dadar", "Agra", "Delhi", "Pune",
				"Ahmedabad", "Mumbai ( CST )", "Varanasi", "Indore" }));
		from_comboBox.setBounds(116, 108, 158, 30);

		panel.add(from_comboBox);

		to_comboBox = new JComboBox();
		to_comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		to_comboBox.setModel(new DefaultComboBoxModel(new String[] { "Secundrabad", "Patna", "Chennai", "Ajmer",
				"Dehradun", "Howra", "Haridwar", "Hyderabad", "NewDelhi", "Dehradun" }));
		to_comboBox.setBounds(116, 161, 158, 30);
		panel.add(to_comboBox);

		JLabel date_lbl = new JLabel("Date");
		date_lbl.setForeground(Color.WHITE);
		date_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		date_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		date_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		date_lbl.setBounds(10, 224, 37, 14);
		panel.add(date_lbl);

		date_textField = new JFormattedTextField();
		date_textField.setAlignmentX(Component.LEFT_ALIGNMENT);
		date_textField.setText("YYYY-MM-DD");
		date_textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		date_textField.setBounds(116, 217, 158, 30);
		panel.add(date_textField);

		JLabel amount_lbl = new JLabel("Amount");
		amount_lbl.setForeground(Color.WHITE);
		amount_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		amount_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		amount_lbl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		amount_lbl.setBounds(10, 268, 62, 23);
		panel.add(amount_lbl);

		amount = new JTextField();
		amount.setAlignmentX(Component.LEFT_ALIGNMENT);
		amount.setBounds(114, 265, 98, 30);
		panel.add(amount);
		amount.setColumns(10);

		addPassenger_btn = new JButton("Add Passenger");
		addPassenger_btn.setHorizontalTextPosition(SwingConstants.CENTER);
		addPassenger_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		addPassenger_btn.setBounds(354, 264, 138, 30);

		addPassenger_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();

				model.addRow(new Object[] { txtName.getText(), txtAddress.getText(),

						txtEmail.getText(), txtAge.getText(), txtGender.getSelectedItem(),

				});
				if (table.getSelectedRow() == -1) {
				}
				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Passenger Details Updated", "Booking System",
							JOptionPane.OK_OPTION);
				}
			}

		});
		panel.add(addPassenger_btn);

		Panel passenger_panel = new Panel();
		passenger_panel.setBackground(new Color(245, 255, 250));
		passenger_panel.setBounds(314, 49, 410, 198);
		panel.add(passenger_panel);
		passenger_panel.setLayout(null);

		JLabel name_passenger = new JLabel("Name");
		name_passenger.setFont(new Font("Times New Roman", Font.BOLD, 14));
		name_passenger.setBounds(10, 11, 41, 21);
		passenger_panel.add(name_passenger);

		JLabel Address_passenger = new JLabel("Address");
		Address_passenger.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Address_passenger.setBounds(10, 45, 60, 21);
		passenger_panel.add(Address_passenger);

		JLabel age_passenger = new JLabel("Age");
		age_passenger.setFont(new Font("Times New Roman", Font.BOLD, 14));
		age_passenger.setBounds(10, 128, 41, 21);
		passenger_panel.add(age_passenger);

		JLabel gender_passenger = new JLabel("Gender");
		gender_passenger.setFont(new Font("Times New Roman", Font.BOLD, 14));
		gender_passenger.setBounds(10, 165, 50, 21);
		passenger_panel.add(gender_passenger);

		txtName = new JTextField();
		txtName.setBounds(75, 9, 288, 26);
		passenger_panel.add(txtName);
		txtName.setColumns(10);

		txtAge = new JTextField();
		txtAge.setBounds(75, 127, 86, 25);
		passenger_panel.add(txtAge);
		txtAge.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(75, 43, 288, 26);
		passenger_panel.add(txtAddress);
		txtAddress.setColumns(10);

		JLabel email_passenger_1 = new JLabel("Email_ID");
		email_passenger_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		email_passenger_1.setBounds(10, 82, 65, 21);
		passenger_panel.add(email_passenger_1);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(75, 80, 288, 26);
		passenger_panel.add(txtEmail);

		txtGender = new JComboBox();
		txtGender.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		txtGender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		txtGender.setBounds(70, 165, 91, 25);
		passenger_panel.add(txtGender);

		JLabel heading_lbl = new JLabel("Booking");
		heading_lbl.setForeground(Color.WHITE);
		heading_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
		heading_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		heading_lbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		heading_lbl.setBounds(10, 11, 714, 23);
		panel.add(heading_lbl);

		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.PINK);
		separator.setBackground(Color.PINK);
		separator.setBounds(306, 49, 2, 385);
		panel.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 305, 410, 129);
		panel.add(scrollPane);

		table = new JTable();
		table.setGridColor(new Color(0, 0, 0));
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Address", "Email", "Age", "Gender" }));
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(64, 0, 64));
		table.setRowHeight(30);

		JButton reset_btn = new JButton("Reset");
		reset_btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		reset_btn.setBounds(560, 264, 111, 30);
		reset_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtName.setText("");
				txtAddress.setText("");
				txtEmail.setText("");
				txtAge.setText("");
				txtGender.setSelectedItem("Male");

			}

		});
		panel.add(reset_btn);

		main_btn = new JButton("Main Page");
		main_btn.addActionListener(this);
		main_btn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		main_btn.setBounds(91, 379, 127, 30);
		panel.add(main_btn);

		table.getColumnModel().getColumn(0).setPreferredWidth(107);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == main_btn) {
			this.dispose();
			MainPage back = new MainPage();
			back.setVisible(true);
		}
	}
}
