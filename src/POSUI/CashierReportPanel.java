package POSUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.*;
import javax.swing.JLabel;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
/**
 * 
 * 
 *
 */
public class CashierReportPanel extends JPanel {
	private DatePicker datePicker;
	private JLabel lblError;
	/**
	 * Create the cashier report panel.
	 */
	public CashierReportPanel(final JFrame currentFrame,final Store store) {
		setLayout(null);
		
		JLabel lblCashierReport = new JLabel("Cashier Report");
		lblCashierReport.setBounds(159, 13, 96, 16);
		add(lblCashierReport);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(26, 50, 56, 16);
		add(lblDate);
		
		datePicker = new DatePicker();
		datePicker.setBounds(70, 44, 160, 22);
		add(datePicker);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 100, 369, 105);
		add(scrollPane);
		
		final JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(datePicker.getDate()!=null)
				{
					textPane.setText(getReport(store,datePicker.getDate()));
					lblError.setText("");
				}
				else
					lblError.setText("Error! Pick a date.");
				
			}
		});
		btnGenerate.setBounds(90, 237, 97, 25);
		add(btnGenerate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();	
			}
		});
		btnClose.setBounds(273, 237, 97, 25);
		add(btnClose);
		
	    lblError = new JLabel();
	    lblError.setForeground(Color.RED);
		lblError.setBounds(242, 50, 196, 16);
		add(lblError);

	}
	
	public String getReport(Store store, LocalDate date)
	{
		String r="";
		String t="\t";
		String nl="\n";
		r+="Cashier Report for:"+date.toString()+nl+nl;
		r+="Number" +t+"Name"+t+t+"Count"+t+"Amount"+nl;
		for(Cashier cashier:store.getCashiers().values())
		{
			r+=cashier.getNumber()+t+cashier.getPerson().getName()+t+t+cashier.getNumberOfSales(date)+
					t+cashier.TotalSalesforCashier(date)+nl;
		}
		return r;
	}
	
}
