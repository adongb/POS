package POSUI;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POSPD.*;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
/**
 * 
 *
 *
 */
public class ItemListPanel extends JPanel {
	private DefaultListModel listModel;
	/**
	 * Create the item list panel.
	 */
	public ItemListPanel(final JFrame currentFrame,final Store store) {
		setLayout(null);
		
		JLabel lblSelectItem = new JLabel("Select Item:");
		lblSelectItem.setBounds(170, 13, 76, 16);
		add(lblSelectItem);
		
		listModel= new DefaultListModel();
		for(Item item:store.getItems().values())
		   listModel.addElement(item);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 67, 386, 114);
		add(scrollPane);
		
		final JList<Item> list = new JList<Item>(listModel);
		
		
		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,list.getSelectedValue(),false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(12, 233, 97, 25);
		add(btnEdit);
		
		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.removeItem(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
			}
		});
		btnDelete.setBounds(322, 233, 97, 25);
		add(btnDelete);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,new Item(),true));
					currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(170, 233, 97, 25);
		add(btnAdd);
		 btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);
			scrollPane.setViewportView(list);
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
