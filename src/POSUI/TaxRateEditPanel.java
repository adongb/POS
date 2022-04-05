package POSUI;

import javax.swing.JFrame;

import javax.swing.JPanel;

import POSPD.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 */
public class TaxRateEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
    private JLabel lblNewLabel;
	/**
	 * Create the tax rate edit panel.
	 */
	public TaxRateEditPanel(final JFrame currentFrame,final Store store,final TaxCategory taxCat,final TaxRate taxRate,final boolean isAdd) {
		setLayout(null);
		
		String label= "Add Tax Rate";
		
		
		if(isAdd)
			lblNewLabel = new JLabel(label);
		else 
		{
			label ="Edit Tax Rate";
			lblNewLabel = new JLabel(label);
		}
		
		lblNewLabel.setBounds(301, 27, 178, 16);
		add(lblNewLabel);
		
		String effectiveDateTxt,rateTxt;
		effectiveDateTxt =taxRate.getEffectiveDate()+"";
		rateTxt =taxRate.getTaxRate()+"";
		if(isAdd)
		{
			effectiveDateTxt ="";
			rateTxt ="";
		}
		JLabel lblTaxRate = new JLabel("Tax Rate:");
		lblTaxRate.setBounds(27, 108, 56, 16);
		add(lblTaxRate);
		
		textField = new JTextField(rateTxt);
		textField.setBounds(87, 105, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(27, 152, 56, 16);
		add(lblDate);
		
		textField_1 = new JTextField(effectiveDateTxt);
		textField_1.setBounds(87, 149, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxRate.setTaxRate(textField.getText().toString());
				taxRate.setEffectiveDate(textField_1.getText());
				if(isAdd)
				{
					System.out.println("89.0");
					if(taxRate != null)
					   taxCat.addTaxRate(taxRate);
					
				}
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,taxCat,isAdd));
				currentFrame.getContentPane().revalidate();
				
				
			}
		});
		btnSave.setBounds(75, 259, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,taxCat,isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(466, 259, 97, 25);
		add(btnCancel);
		
		
		
		

	}

}
