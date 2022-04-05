package POSUI;

import javax.swing.JPanel;

import POSPD.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 *
 */
public class PriceEditPanel extends JPanel {
    private JLabel lblNewLabel;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private Price price;
	/**
	 * Create the price edit panel.
	 */
	public PriceEditPanel(final JFrame currentFrame,final Store store,final Item item,final Price inprice,final boolean isAdd) {
		setLayout(null);
		price =inprice;
		 String label= "Add Price";
		 String endDate="";
		 boolean isPromo = false;
		 
			if(isAdd)
				lblNewLabel = new JLabel(label);
			else 
			{
				label ="Edit Price";
				lblNewLabel = new JLabel(label);
			}
			
			
			if(price instanceof PromoPrice)
			{
				isPromo=true;
			}
			if(isPromo)
			{
				if(!isAdd) {
			  	
			  	endDate = ((PromoPrice)price).getEndDate().toString();
				}
				
			}
			
		lblNewLabel.setBounds(152, 13, 98, 16);
		add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(12, 90, 56, 16);
		add(lblPrice);
		
		textField = new JTextField(price.getPrice().toString());
		textField.setBounds(74, 84, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEffectiveDate = new JLabel("Effective Date:");
		lblEffectiveDate.setBounds(12, 127, 93, 16);
		add(lblEffectiveDate);
		String effDate = "";
		if (price.getEffectiveDate() != null) effDate = price.getEffectiveDate().toString();
		textField_1 = new JTextField(effDate);
		textField_1.setBounds(98, 124, 93, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		final JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(12, 163, 56, 16);
		add(lblEndDate);
		lblEndDate.setVisible(false);
		textField_2 = new JTextField(endDate);
		textField_2.setBounds(89, 156, 116, 22);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setVisible(false);
		if(!isAdd&&price.isPromo())
		{
			lblEndDate.setVisible(true);
			textField_2.setVisible(true);
		}
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(price.isPromo())
				{
					price.setPrice(textField.getText());
					price.setEffectiveDate(textField_1.getText());
					((PromoPrice) price).setEndDate(textField_2.getText());
					
				}
				else
				{
					price.setPrice(textField.getText());
					price.setEffectiveDate(textField_1.getText());
				}
					
				if(isAdd)
				{
					item.addPrice(price);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,item,isAdd));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnSave.setBounds(139, 279, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,item,isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(442, 279, 97, 25);
		add(btnCancel);
		
		final JCheckBox chckbxPromoPrice = new JCheckBox("Promo Price");
		chckbxPromoPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxPromoPrice.isSelected())
				{
					lblEndDate.setVisible(true);
					textField_2.setVisible(true);
					price =new PromoPrice();
					
				}
				else 
				{
					lblEndDate.setVisible(false);
				    textField_2.setVisible(false);
				    price = new Price();
				}
			}
		});
		chckbxPromoPrice.setBounds(226, 57, 113, 25);
		add(chckbxPromoPrice);
		if(!isAdd)
			chckbxPromoPrice.setEnabled(false);
		

	}
}
