package POSUI;

import javax.swing.JFrame;

import javax.swing.JPanel;


import POSPD.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 *
 */
public class TaxCategoryEditPanel extends JPanel {
	private JTextField textField;
    private JLabel lblEditTaxCategory;
    private DefaultListModel listModel;
	/**
	 * Create the Tax category Edit panel.
	 */
	public TaxCategoryEditPanel(final JFrame currentFrame,final Store store,final TaxCategory taxCat,final boolean isAdd) {
		setLayout(null);
		JPanel currentPanel=this;
		
		String label= "Tax Category Add";
		
		
		if(isAdd)
			lblEditTaxCategory = new JLabel(label);
		else 
		{
			label ="Tax Category Edit";
			lblEditTaxCategory = new JLabel(label);
		}
		
		lblEditTaxCategory.setBounds(141, 34, 131, 16);
		add(lblEditTaxCategory);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(34, 93, 56, 16);
		add(lblCategory);
		
		textField = new JTextField(taxCat.getCategory());
		textField.setBounds(102, 90, 116, 22);
		add(textField);
		textField.setColumns(10);
		
	
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxCat.setCategory(textField.getText());
				if(isAdd)
				{
					store.addTaxCategory(taxCat);
				}
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnSave.setBounds(88, 283, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		
		btnCancel.setBounds(501, 283, 97, 25);
		add(btnCancel);
		
		
		listModel= new DefaultListModel();
		for(TaxRate taxRate:taxCat.getTaxRates())
		   listModel.addElement(taxRate);
		
		final JList<TaxRate> list = new JList<TaxRate>(listModel);
	
		list.setBounds(270, 78, 222, 80);
		add(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                currentFrame.getContentPane().removeAll();				
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame,store,taxCat,new TaxRate(),true));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnAdd.setBounds(299, 192, 97, 25);
		add(btnAdd);
		
		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 currentFrame.getContentPane().removeAll();				
				 currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame,store,taxCat,list.getSelectedValue(),false));
				 currentFrame.getContentPane().revalidate();
				
			}
		});
		btnEdit.setBounds(121, 192, 97, 25);
		add(btnEdit);
		
		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taxCat.removeTaxRate(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				//currentFrame.getContentPane().removeAll();
				//currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,taxCat,isAdd));
				//currentFrame.getContentPane().revalidate();
			}
		});
		btnDelete.setBounds(465, 192, 97, 25);
		add(btnDelete);
		btnEdit.setEnabled(false);
		btnDelete.setEnabled(false);
		
		JLabel lblTaxRates = new JLabel("Tax Rates:");
		lblTaxRates.setBounds(270, 49, 72, 16);
		add(lblTaxRates);
	list.addListSelectionListener(new ListSelectionListener() {
		  public void valueChanged(ListSelectionEvent e) {
						
			 
		    if (list.getSelectedValue() != null) 
			{
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				
			}
					
		  }
	});

	}
}
