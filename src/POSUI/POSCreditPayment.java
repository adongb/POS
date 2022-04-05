package POSUI;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.*;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
/**
 * 
 *
 */
public class POSCreditPayment extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	 private DefaultComboBoxModel<String> ComboBoxModel;
	/**
	 * Create the credit payment panel.
	 */
	public POSCreditPayment(final JFrame currentFrame,final Store store,final Session session, final Sale sale,final JTextField saleTotal,final JTextField AmtTendered,final JButton btnPaymentComplete) {
		setLayout(null);
		
		JLabel lblEnterCreditPayment = new JLabel("Enter Credit Payment");
		lblEnterCreditPayment.setBounds(12, 0, 121, 16);
		add(lblEnterCreditPayment);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(22, 28, 56, 16);
		add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(90, 25, 129, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblCardType = new JLabel("Card Type:");
		lblCardType.setBounds(12, 57, 75, 16);
		add(lblCardType);
		ComboBoxModel= new DefaultComboBoxModel<String>();
		
		    ComboBoxModel.addElement("VISA");
		    ComboBoxModel.addElement("MasterCard");
		final JComboBox<String> comboBox = new JComboBox<String>(ComboBoxModel);
		comboBox.setBounds(100, 54, 129, 22);
		add(comboBox);
		
		JLabel lblAccountNum = new JLabel("Account Num:");
		lblAccountNum.setBounds(12, 89, 97, 16);
		add(lblAccountNum);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 86, 129, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setBounds(12, 118, 85, 16);
		add(lblExpiryDate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 127, 129, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BigDecimal amt =new BigDecimal(textField.getText());
				Credit credit = new Credit(textField_1.getText().toString(),sale.calcAmountForPayment(amt).toString(),textField_2.getText().toString(), textField.getText().toString(), textField.getText().toString());
				if(credit.isAuthorized())
				{
				sale.addPayment(credit);
				//System.out.println("Text:"+ textField.getText());
				String text = sale.calcAmountForPayment(new BigDecimal(textField.getText())).toString(); 
				saleTotal.setText(text);
				
				AmtTendered.setText(sale.calcAmtTendered().toString());
				if(sale.isPaymentEnough())
					btnPaymentComplete.setEnabled(true);
				else
					btnPaymentComplete.setEnabled(false);
				}
			
			}
		});
		btnSave.setBounds(12, 159, 97, 25);
		add(btnSave);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnCancle.setBounds(143, 162, 97, 25);
		add(btnCancle);
		
		JLabel lblDdmyyyy = new JLabel("MM/d/YYYY");
		lblDdmyyyy.setBounds(12, 130, 85, 16);
		add(lblDdmyyyy);

	}
}
