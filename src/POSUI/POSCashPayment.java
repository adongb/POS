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
public class POSCashPayment extends JPanel {
	private JTextField textField_2;

	/**
	 * Create the payment cash panel.
	 */
	public POSCashPayment(JFrame currentFrame, Store store, final Session session,final Sale sale, final JTextField saleTotal,final JTextField AmtTendered,final JButton btnPaymentComplete) {
		setLayout(null);
		
		JLabel lblEnterCashPayment = new JLabel("Enter Cash Payment");
		lblEnterCashPayment.setBounds(27, 25, 139, 16);
		add(lblEnterCashPayment);
		
		JLabel lblAmountTendered_1 = new JLabel("Amount Tendered:");
		lblAmountTendered_1.setBounds(27, 54, 116, 16);
		add(lblAmountTendered_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(27, 84, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		
		
		JButton btnSave = new JButton("Save");
	    btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal amt1=new BigDecimal(textField_2.getText());
				Cash cash = new Cash(sale.calcAmountForPayment(amt1).toString(),new BigDecimal(textField_2.getText()).toString());
				session.getRegister().getCashDrawer().addCash(sale.calcAmountForPayment(new BigDecimal(textField_2.getText())));
				sale.addPayment(cash);
				
				System.out.println(new BigDecimal(textField_2.getText()).toString());
				saleTotal.setText(sale.calcAmountForPayment(new BigDecimal(textField_2.getText())).toString());
				AmtTendered.setText(sale.calcAmtTendered().toString());
				if(sale.isPaymentEnough())
					btnPaymentComplete.setEnabled(true);
				else
					btnPaymentComplete.setEnabled(false);
			}
		});
		btnSave.setBounds(27, 130, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				
			}
		});
		btnCancel.setBounds(162, 130, 97, 25);
		add(btnCancel);

	}
}
