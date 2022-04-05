package POSUI;

import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import POSPD.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
/**
 * 
 *
 */
public class POSCheckPayment extends JPanel {
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the check payment panel.
	 */
	public POSCheckPayment(final JFrame currentFrame,final Store store,final Session session, final Sale sale,final JTextField saleTotal,final JTextField AmtTendered,final JButton btnPaymentComplete) {
		setLayout(null);
		
		JLabel lblEnterCheck = new JLabel("Enter Check");
		lblEnterCheck.setBounds(49, 0, 80, 16);
		add(lblEnterCheck);
	
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(12, 29, 56, 16);
		add(lblAmount);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 26, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRoutingNum = new JLabel("Routing Num:");
		lblRoutingNum.setBounds(12, 68, 90, 16);
		add(lblRoutingNum);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 65, 116, 22);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAccountNum = new JLabel("Account Num:");
		lblAccountNum.setBounds(12, 103, 97, 16);
		add(lblAccountNum);
		
		textField_4 = new JTextField();
		textField_4.setBounds(140, 99, 116, 22);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCheckNum = new JLabel("Check Num:");
		lblCheckNum.setBounds(12, 138, 80, 16);
		add(lblCheckNum);
		
		textField_5 = new JTextField();
		textField_5.setBounds(114, 135, 116, 22);
		add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amt =sale.calcAmountForPayment(new BigDecimal(textField_2.getText())).toString();
				Check check = new Check(amt,textField_2.getText(),textField_2.getText(),textField_3.getText(),textField_5.getText());
				sale.addPayment(check);
				saleTotal.setText(sale.remainingPay().toString());
				AmtTendered.setText(sale.calcAmtTendered().toString());
				if(sale.isPaymentEnough())
					btnPaymentComplete.setEnabled(true);
				else
					btnPaymentComplete.setEnabled(false);
			}
		});
		btnSave.setBounds(12, 159, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
			}
		});
		btnCancel.setBounds(144, 159, 97, 25);
		add(btnCancel);
		

	}

}
