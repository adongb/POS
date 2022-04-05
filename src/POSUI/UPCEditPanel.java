package POSUI;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 *
 */
public class UPCEditPanel extends JPanel {
	private JTextField textField;
	 private JLabel lblNewLabel;
	/**
	 * Create the UPC edit panel.
	 */
	public UPCEditPanel(final JFrame currentFrame,final Store store,final Item item, final UPC upc,final boolean isAdd) {
		setLayout(null);
		

		 String label= "Add UPC";
		 
			if(isAdd)
				lblNewLabel = new JLabel(label);
			else 
			{
				label ="Edit UPC";
				lblNewLabel = new JLabel(label);
			}
		lblNewLabel.setBounds(192, 23, 56, 16);
		add(lblNewLabel);
		
		textField = new JTextField(upc.toString());
		textField.setBounds(87, 91, 116, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblUpcCode = new JLabel("UPC Code:");
		lblUpcCode.setBounds(12, 94, 75, 16);
		add(lblUpcCode);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    upc.setUpc(textField.getText());
				if(isAdd)
				{
					if(upc!=null)
					   item.addUPC(upc);
				}
								
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,item,isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(168, 249, 97, 25);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame,store,item,isAdd));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(520, 249, 97, 25);
		add(btnCancel);
		

	}

}
