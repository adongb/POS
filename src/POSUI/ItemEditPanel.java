package POSUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POSPD.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 *
 */
public class ItemEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel listModel;
	private DefaultListModel listModel1;
	 private JLabel lblNewLabel;
	 private DefaultComboBoxModel<TaxCategory> ComboBoxModel;
	/**
	 * Create the Item Edit panel.
	 */
	public ItemEditPanel(final JFrame currentFrame,final Store store,final Item item,final  boolean isAdd) {
		setLayout(null);
		
		 String label= "Add Item";
		 
			if(isAdd)
				lblNewLabel = new JLabel(label);
			else 
			{
				label ="Edit Item";
				lblNewLabel = new JLabel(label);
			}
		lblNewLabel.setBounds(178, 13, 100, 16);
		add(lblNewLabel);
		
		JLabel lblItemNumber = new JLabel("Item Number:");
		lblItemNumber.setBounds(12, 59, 80, 16);
		add(lblItemNumber);
		
		textField = new JTextField(item.getNumber());
		textField.setBounds(95, 56, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(12, 100, 80, 16);
		add(lblDescription);
		
		textField_1 = new JTextField(item.getDescription());
		textField_1.setBounds(95, 97, 116, 22);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTaxCategory = new JLabel("Tax Category:");
		lblTaxCategory.setBounds(12, 147, 100, 16);
		add(lblTaxCategory);
		
		//JComboBox comboBox = new JComboBox();
		ComboBoxModel= new DefaultComboBoxModel<TaxCategory>();
		
		for(TaxCategory taxCat:store.getTaxCategories().values())
		    ComboBoxModel.addElement(taxCat);
		
		final JComboBox<TaxCategory> comboBox = new JComboBox<TaxCategory>(ComboBoxModel);
		comboBox.setBounds(105, 144, 87, 22);
		add(comboBox);
		
		JLabel lblUpc = new JLabel("UPC:");
		lblUpc.setBounds(323, 27, 56, 16);
		add(lblUpc);
		//UPC List
		listModel= new DefaultListModel();
		for(UPC upc:item.getUPCs().values())
		   listModel.addElement(upc);
		
		final JList<UPC> list = new JList<UPC>(listModel);
		list.setBounds(371, 44, 135, 58);
		add(list);
		
		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame,store,item,list.getSelectedValue(),false));
				currentFrame.getContentPane().revalidate();
				
				
			}
		});
		btnEdit.setBounds(373, 115, 56, 25);
		add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame,store,item,new UPC(),true));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnAdd.setBounds(531, 115, 56, 25);
		add(btnAdd);
		
		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.removeUPC(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				
			}
		});
		btnDelete.setBounds(452, 143, 75, 25);
		add(btnDelete);
		 btnEdit.setEnabled(false);
		 btnDelete.setEnabled(false);
		list.addListSelectionListener(new ListSelectionListener() {
			  public void valueChanged(ListSelectionEvent e) {
							
				 
			    if (list.getSelectedValue() != null) 
				{
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
					
				}
			  }
		});
		//Price List
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(323, 188, 56, 16);
		add(lblPrice);
		
		listModel1= new DefaultListModel();
		for(Price price:item.getPrices())
		   listModel1.addElement(price);
		
		final JList<Price> list_1 = new JList<Price>(listModel1);
		list_1.setBounds(376, 181, 197, 79);
		add(list_1);
		
		final JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame,store,item,list_1.getSelectedValue(),false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit_1.setBounds(386, 273, 56, 25);
		add(btnEdit_1);
		
		JButton btnAdd_1 = new JButton("Add");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Price newPrice = new Price();
				//item.addPrice(newPrice);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame,store,item,newPrice ,true));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnAdd_1.setBounds(520, 273, 67, 25);
		add(btnAdd_1);
		
		final JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.removePrice(list_1.getSelectedValue());
				listModel1.removeElement(list_1.getSelectedValue());
				btnEdit_1.setEnabled(false);
				btnDelete_1.setEnabled(false);
			}
		});
		btnDelete_1.setBounds(447, 311, 80, 25);
		add(btnDelete_1);
		 btnEdit_1.setEnabled(false);
		 btnDelete_1.setEnabled(false);
		list_1.addListSelectionListener(new ListSelectionListener() {
			  public void valueChanged(ListSelectionEvent e) {
							
				 
			    if (list_1.getSelectedValue() != null) 
				{
					btnEdit_1.setEnabled(true);
					btnDelete_1.setEnabled(true);
					
				}
			     
				
				
			  }
		});
		
		//Save & Cancel Buttons
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setNumber(textField.getText());
				item.setDescription(textField_1.getText());
				item.setTaxCategory((TaxCategory)comboBox.getSelectedItem());
	
				if(isAdd)
				{
					if(item != null)
					    store.addItem(item);
				}
								
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(12, 299, 75, 45);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(214, 299, 97, 45);
		add(btnCancel);
		

	}
}
