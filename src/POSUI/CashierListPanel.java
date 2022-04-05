package POSUI;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POSPD.*;
import POSPD.TaxCategory;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class CashierListPanel extends JPanel {
	private DefaultListModel listModel;
	/**
	 * Create the cashier list panel.
	 */
	public CashierListPanel(final JFrame currentFrame, final Store store) {
		setLayout(null);
		
		listModel= new DefaultListModel();
		for(Cashier cashier:store.getCashiers().values())
		   listModel.addElement(cashier);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 71, 346, 151);
		add(scrollPane);
		
		final JList<Cashier> list = new JList<Cashier>(listModel);
		scrollPane.setViewportView(list);
	
		
		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame,store,list.getSelectedValue(),false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(29, 288, 97, 25);
		add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame,store,new Cashier("",new Person("",""),""),true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(303, 288, 97, 25);
		add(btnAdd);
		
		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.removeCashier(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
			}
		});
		btnDelete.setBounds(556, 288, 97, 25);
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
