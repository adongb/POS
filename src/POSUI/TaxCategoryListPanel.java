package POSUI;

import javax.swing.JPanel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import POSPD.*;

import javax.swing.JList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
/**
 * 
 * 
 *
 */
public class TaxCategoryListPanel extends JPanel {

	private DefaultListModel listModel;
	/**
	 * Create the Tax category list panel.
	 */
	public TaxCategoryListPanel(final JFrame currentFrame, final Store store) {
		setLayout(null);
		
		listModel= new DefaultListModel();
		for(TaxCategory taxCat:store.getTaxCategories().values())
		   listModel.addElement(taxCat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 100, 190, 97);
		add(scrollPane);
		
		final JList<TaxCategory> list = new JList<TaxCategory>(listModel);
		scrollPane.setViewportView(list);
		
		
		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,list.getSelectedValue(),false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(25, 274, 97, 25);
		add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame,store,new TaxCategory(),true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(278, 274, 97, 25);
		add(btnAdd);
		
		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.removeTaxCategory(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
			}
		});
		btnDelete.setBounds(488, 274, 97, 25);
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
	}

}
