package POSUI;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * 
 *
 */
public class CashierEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblNewLabel_1;
	/**
	 * Create the cashier edit panel.
	 */
	public CashierEditPanel(final JFrame currentFrame, final Store store, final Cashier cashier,final  boolean isAdd) {
		setLayout(null);
		
       String label= "Cashier Add";
       
		
		
       
		if(isAdd)
			lblNewLabel_1 = new JLabel(label);
		else 
		{
			label ="Cashier Edit";
			lblNewLabel_1 = new JLabel(label);
		}
		lblNewLabel_1.setBounds(194, 13, 133, 16);
		add(lblNewLabel_1);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setBounds(12, 50, 56, 16);
		add(lblNumber);
		
		textField = new JTextField(cashier.getNumber());
		textField.setBounds(80, 47, 103, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(208, 50, 56, 16);
		add(lblSsn);
		
		textField_1 = new JTextField(cashier.getPerson().getSsn());
		textField_1.setBounds(279, 50, 127, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 90, 56, 16);
		add(lblName);
		
		textField_2 = new JTextField(cashier.getPerson().getName());
		textField_2.setBounds(67, 87, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 129, 56, 16);
		add(lblAddress);
		
		textField_3 = new JTextField(cashier.getPerson().getAddress());
		textField_3.setBounds(67, 126, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(12, 158, 56, 16);
		add(lblCity);
		
		textField_4 = new JTextField(cashier.getPerson().getCity());
		textField_4.setBounds(67, 155, 116, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(208, 158, 56, 16);
		add(lblState);
		
		textField_5 = new JTextField(cashier.getPerson().getState());
		textField_5.setBounds(254, 155, 24, 22);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblZip = new JLabel("Zip:");
		lblZip.setBounds(290, 158, 56, 16);
		add(lblZip);
		
		textField_6 = new JTextField(cashier.getPerson().getZip());
		textField_6.setBounds(322, 155, 88, 22);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(12, 196, 56, 16);
		add(lblPhone);
		
		textField_7 = new JTextField(cashier.getPerson().getPhone());
		textField_7.setBounds(67, 193, 116, 22);
		add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 225, 77, 16);
		add(lblPassword);
		
		textField_8 = new JTextField(cashier.getPassword());
		textField_8.setBounds(84, 222, 116, 22);
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashier.setNumber(textField.getText());
				cashier.setPassword(textField_8.getText());
				Person person =cashier.getPerson();
				person.setSsn(textField_1.getText());
				person.setName(textField_2.getText());
				person.setAddress(textField_3.getText());
				person.setCity(textField_4.getText());
				person.setState(textField_5.getText());
				person.setZip(textField_6.getText());
				person.setPhone(textField_7.getText());
				
				if(isAdd)
				{
					if(cashier != null)
					     store.addCashier(cashier);
				}
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
				
				
			}
		});
		btnSave.setBounds(468, 330, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(45, 330, 97, 25);
		add(btnCancel);
		
		
		
		
		
		
		
		
		

	}

}
