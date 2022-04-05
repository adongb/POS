package POSUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import POSPD.*;

import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.Color;
import java.awt.event.ActionEvent;
/**
 *
 *
 */
public class POSLogin extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	 private DefaultComboBoxModel<Cashier> ComboBoxModel;
	 private DefaultComboBoxModel<Register> ComboBoxModel_1;
	/**
	 * Create the login panel.
	 */
	public POSLogin(final JFrame currentFrame, final Store store) {
		
		
		final JLabel label_1 = new JLabel("");
		label_1.setBounds(113, 42, 286, 16);
		add(label_1);
		label_1.setForeground(Color.RED);;
		setLayout(null);
		
		
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(154, 13, 56, 16);
		add(lblLogin);
		//Cashier comboBox
		//JComboBox comboBox = new JComboBox();
		ComboBoxModel = new DefaultComboBoxModel<Cashier>();
		for(Cashier cashier:store.getCashiers().values()) {
		    ComboBoxModel.addElement(cashier);
		    System.out.println(cashier.getNumber());
		    }
		final JComboBox<Cashier> comboBox = new JComboBox<Cashier>(ComboBoxModel);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(113, 73, 90, 22);
		add(comboBox);
		
		JLabel lblCashier = new JLabel("Cashier Number:");
		lblCashier.setBounds(27, 76, 56, 16);
		add(lblCashier);
		//Register comboBox
		JLabel lblRegister = new JLabel("Register Number:");
		lblRegister.setBounds(27, 127, 56, 16);
		add(lblRegister);
		
		//JComboBox comboBox_1 = new JComboBox();
		ComboBoxModel_1 = new DefaultComboBoxModel<Register>();
		for(Register register:store.getRegisters().values())
		    ComboBoxModel_1.addElement(register);
		final JComboBox<Register> comboBox_1 = new JComboBox<Register>(ComboBoxModel_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox_1.setBounds(113, 124, 90, 22);
		add(comboBox_1);
		//Starting Cash 
		JLabel lblStartingCash = new JLabel("Starting Cash:");
		lblStartingCash.setBounds(27, 176, 110, 16);
		add(lblStartingCash);
		
		textField = new JTextField();
		textField.setBounds(124, 173, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(27, 215, 76, 16);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(134, 212, 106, 22);
	 	add(passwordField);
		final Cashier cashier1 = (Cashier)comboBox.getSelectedItem();
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(passwordField.getText().toString());
			System.out.println(cashier1.getPassword());
			System.out.println(cashier1.getNumber());	
				if(cashier1.isAuthorized(passwordField.getText()))
				{
					label_1.setText("");
					
					currentFrame.getContentPane().removeAll();
					Cashier cashier=(Cashier)comboBox.getSelectedItem();
					Register register=(Register)comboBox_1.getSelectedItem();
					if(!textField.getText().trim().isEmpty())
					{
						CashDrawer cashDrawer=new CashDrawer(new BigDecimal(textField.getText()),1);
					    register.setCashDrawer(cashDrawer);
					}
					Session session = new Session(cashier,register);
					store.addSession(session);
					cashier.addSession(session);
					currentFrame.getContentPane().add(new POSSale(currentFrame,store, new Sale(), session));
					currentFrame.getContentPane().revalidate();
				}
				else if(!cashier1.isAuthorized(passwordField.getText()))
					label_1.setText("Error! Incorrect Login info!");
				else if((textField.getText()==null))
					 label_1.setText("Error! Enter Starting Cash!");
				
			}
		});
		btnLogin.setBounds(40, 262, 97, 25);
		add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(265, 262, 97, 25);
		add(btnCancel);
		
		

	}
}
