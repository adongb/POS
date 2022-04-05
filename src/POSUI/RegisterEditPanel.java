package POSUI;

import javax.swing.JPanel;

import POSPD.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * 
 *
 */
public class RegisterEditPanel extends JPanel {
	private JTextField textField;
	private JLabel lblRegisterEdit;
	/**
	 * Create the register edit panel.
	 */
	public RegisterEditPanel(final JFrame currentFrame,final Store store, final Register register,final boolean isAdd) {
		setLayout(null);
		String labelAdd= "Register Add";
		String labelEdit="Register Edit";
		
		if(isAdd)
		    lblRegisterEdit = new JLabel(labelAdd);
		else 
		    lblRegisterEdit = new JLabel(labelEdit);
		
		lblRegisterEdit.setBounds(147, 42, 86, 16);
		add(lblRegisterEdit);
		
		JLabel lblRegisterNumber = new JLabel("Register Number: ");
		lblRegisterNumber.setBounds(36, 131, 105, 16);
		add(lblRegisterNumber);
		
		textField = new JTextField(register.getNumber());
		textField.setBounds(142, 128, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(161, 294, 97, 25);
		add(btnCancel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register.setNumber(textField.getText());
				if(isAdd)
				{
					if(register!=null)
					   store.addRegister(register);
				}
								
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(521, 294, 97, 25);
		add(btnSave);
      
		
	}
}
