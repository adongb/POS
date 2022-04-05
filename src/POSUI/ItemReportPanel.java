package POSUI;

import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import POSPD.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Color;
import java.awt.Font;
/**
 * 
 *
 */
public class ItemReportPanel extends JPanel {

private	DatePicker datePicker;
private JLabel lblError;
	/**
	 * Create the item report panel.
	 */
	public ItemReportPanel(final JFrame currentFrame,final Store store) {
		setLayout(null);
		
		JLabel lblItemReport = new JLabel("Item Report");
		lblItemReport.setBounds(144, 13, 138, 16);
		add(lblItemReport);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(12, 55, 56, 16);
		add(lblDate);
		
		final JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Courier New", Font.PLAIN, 13));
		textPane.setBounds(12, 102, 415, 127);
		add(textPane);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(datePicker.getDate()!=null)
				{
				  textPane.setText(getReport(store,datePicker.getDate()));
				  lblError.setText("");
				}
				else
					lblError.setText("Error! Pick date.");
					
				
					
			}
		});
		btnGenerate.setBounds(22, 242, 97, 25);
		add(btnGenerate);
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnClose.setBounds(276, 242, 97, 25);
		add(btnClose);
		
		datePicker = new DatePicker();
		datePicker.getComponentDateTextField().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		datePicker.setBounds(92, 53, 160, 22);
		add(datePicker);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(264, 55, 147, 16);
		add(lblError);

	}
	
	public String getReport(Store store, LocalDate date)
	{
		String r="";
		String t="\t";
		String nl="\n";
		r+="Item Report for:"+date.toString()+nl+nl;
		for(Item item:store.getItems().values())
		{
			r+=item.getNumber()+" "+rightPad(item.getDescription(),30)+item.soldCount(date)+nl;
		}
		return r;
	}
	private String rightPad(String text,int length)
	{
		return String.format("%-"+length+"s",text);
	}
}
