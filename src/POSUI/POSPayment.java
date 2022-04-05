package POSUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
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
public class POSPayment extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
    private JPanel currentPaymentPanel;
    private JPanel currentPanel;

	/**
	 * Create the Payment panel.
	 */
	public POSPayment(final JPanel panel,final JFrame currentFrame,final Sale sale,final Session session,final Store store) {
		currentPanel = this;
		setLayout(null);
		//bool isCash
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPayment.setBounds(213, 13, 107, 16);
		add(lblPayment);
		
		JLabel lblPaymentDue = new JLabel("Payment Due:");
		lblPaymentDue.setBounds(26, 54, 87, 16);
		add(lblPaymentDue);
		
		textField = new JTextField(sale.calcTotal().toString());
		textField.setBounds(26, 80, 116, 22);
		add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		JLabel lblAmountTendered = new JLabel("Amount Tendered:");
		lblAmountTendered.setBounds(26, 115, 130, 16);
		add(lblAmountTendered);
		
		textField_1 = new JTextField(sale.calcAmtTendered().toString());
		textField_1.setBounds(26, 147, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		final JButton btnPaymentComplete = new JButton("Payment Complete");
		JButton btnCash = new JButton("Cash");
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPaymentPanel!=null)
					   remove(currentPaymentPanel);
				 
				currentPaymentPanel = new POSCashPayment(currentFrame, store, session, sale,textField, textField_1,btnPaymentComplete);
				currentPaymentPanel.setBounds(150, 54, 307, 191);
				
				add(currentPaymentPanel);
				currentFrame.getContentPane().repaint();
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCash.setBounds(26, 246, 97, 25);
		add(btnCash);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPaymentPanel!=null)
					   currentPanel.remove(currentPaymentPanel);
				currentPaymentPanel= new POSCheckPayment(currentFrame, store, session, sale,textField, textField_1,btnPaymentComplete);
				currentPaymentPanel.setBounds(150, 54, 307, 191);
				
				add(currentPaymentPanel);
				currentFrame.getContentPane().repaint();
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnCheck.setBounds(172, 246, 97, 25);
		add(btnCheck);
		
		JButton btnCredit = new JButton("Credit");
		
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPaymentPanel!=null)
					  currentPanel.remove(currentPaymentPanel);
				currentPaymentPanel = new POSCreditPayment(currentFrame, store, session, sale,textField, textField_1,btnPaymentComplete);
				currentPaymentPanel.setBounds(150, 54, 307, 191);
			
				add(currentPaymentPanel);
				currentFrame.getContentPane().repaint();
				currentFrame.getContentPane().revalidate();
		
			}
		});
		btnCredit.setBounds(348, 246, 97, 25);
		add(btnCredit);
		
	
		btnPaymentComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POSSale.updateFields(sale);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(panel);
				currentFrame.getContentPane().repaint();
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnPaymentComplete.setBounds(45, 279, 145, 25);
		add(btnPaymentComplete);
		btnPaymentComplete.setEnabled(false);
		if(sale.isPaymentEnough())
			btnPaymentComplete.setEnabled(true);
		else
			btnPaymentComplete.setEnabled(false);
		JButton btnReturnToSale = new JButton("Return to Sale ");
		btnReturnToSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POSSale.updateFields(sale);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(panel);
				currentFrame.getContentPane().repaint();
				 currentFrame.getContentPane().revalidate();
			}
		});
		btnReturnToSale.setBounds(263, 279, 130, 25);
		add(btnReturnToSale);
		
		
		
		
		
	
		

	}
}
