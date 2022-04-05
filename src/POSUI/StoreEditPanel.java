package POSUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreEditPanel extends JPanel {
	
	private JTextField textField;
	/**
	 * Create the store edit panel.
	 */
	public StoreEditPanel(final JFrame currentFrame,final Store store) {
		setLayout(null);
		
		JLabel lblStoreEdit = new JLabel("Store Edit");
		lblStoreEdit.setBounds(180, 47, 110, 16);
		add(lblStoreEdit);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(41, 106, 56, 16);
		add(lblName);
		
		textField = new JTextField(store.getName());
		textField.setBounds(96, 103, 194, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				store.setName(textField.getText());
				 currentFrame.getContentPane().removeAll();
				 currentFrame.getContentPane().add(new POSHomePanel(store));
				 currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(96, 270, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(494, 270, 97, 25);
		add(btnCancel);
    
	}
}
