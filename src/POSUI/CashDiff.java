package POSUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.*;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CashDiff extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

		
	/**
	 * Create the panel.
	 */
	public CashDiff(final JFrame currentFrame,final Store store,final Session session) {
		setForeground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblEnterCashIn = new JLabel("Enter Cash in Drawer:");
		lblEnterCashIn.setBounds(12, 54, 127, 16);
		add(lblEnterCashIn);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal cashDiff=session.calcCashCountDiff(new BigDecimal(textField.getText()));
				textField_1.setText(cashDiff.toString());
				
			}
		});
		textField.setBounds(150, 51, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblCashDifference = new JLabel("cash Difference:");
		lblCashDifference.setBounds(12, 102, 116, 16);
		add(lblCashDifference);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 99, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSLogin(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnClose.setBounds(252, 222, 97, 25);
		add(btnClose);
		
		JLabel lbloverAndShort = new JLabel("(Over and short)");
		lbloverAndShort.setBounds(278, 102, 116, 16);
		add(lbloverAndShort);

	}
}
