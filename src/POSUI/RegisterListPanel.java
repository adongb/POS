package POSUI;

import javax.swing.JPanel; 
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POSPD.Register;
import POSPD.Store;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
/*
 *
 */
public class RegisterListPanel extends JPanel {

	private DefaultListModel listModel;
	/**
	 * Create the register list panel.
	 */
	public RegisterListPanel(final JFrame currentFrame,final Store store) {
		setLayout(null);
		
		JLabel lblRegisterEdit = new JLabel("Select Register");
		lblRegisterEdit.setBounds(189, 60, 129, 16);
		add(lblRegisterEdit);
		
		
		
		listModel= new DefaultListModel();
		for(Register register:store.getRegisters().values())
		   listModel.addElement(register);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 100, 181, 105);
		add(scrollPane);
		
		final JList<Register> list = new JList<Register>(listModel);
		

		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame,store,list.getSelectedValue(),false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(45, 295, 97, 25);
		add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame,store,new Register(),true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(298, 295, 97, 25);
		add(btnAdd);
		
		final JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.removeRegister(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				btnEdit.setEnabled(false);
				
				btnDelete.setEnabled(false);
				//currentFrame.getContentPane().removeAll();
				//currentFrame.getContentPane().add(new RegisterListPanel(currentFrame,store));
				//currentFrame.getContentPane().revalidate();
				
			}
		});
		btnDelete.setBounds(552, 295, 97, 25);
		add(btnDelete);
		 btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);
			scrollPane.setViewportView(list);
			list.addListSelectionListener(new ListSelectionListener() {
				  public void valueChanged(ListSelectionEvent e) {

						btnEdit.setEnabled(false);
						
						btnDelete.setEnabled(false);		
					 
				    if ((list.getSelectedValue() != null)&&(!(list.getSelectedValue().IsRegisterUsed()))) 
					{
						btnEdit.setEnabled(true);
						
						btnDelete.setEnabled(true);
						
					}
				  }});
			
			   
			
		
	}

	
}
