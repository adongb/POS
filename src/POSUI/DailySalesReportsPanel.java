package POSUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.github.lgooddatepicker.components.DatePicker;

import POSPD.*;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
/**
 * generates a daily sales report of the store.
 * 
 * 
 *
 */
public class DailySalesReportsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DailySalesReportsPanel(final JFrame currentFrame, final Store store) {
		setLayout(null);
		final JLabel lblError = new JLabel();
		lblError.setForeground(Color.RED);
		lblError.setBounds(38, 80, 357, 16);
		add(lblError);
		
		JLabel lblDailySalesReport = new JLabel("Daily Sales Report");
		lblDailySalesReport.setBounds(152, 13, 109, 16);
		add(lblDailySalesReport);
		
		final DatePicker datePicker = new DatePicker();
		datePicker.setBounds(162, 49, 160, 22);
		add(datePicker);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(55, 51, 56, 16);
		add(lblDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 115, 372, 109);
		add(scrollPane);
		
		final JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Courier New", Font.PLAIN, 13));
		scrollPane.setViewportView(textPane);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(datePicker.getDate() != null)
				{
					lblError.setText("");
					textPane.setText(getReport(store,datePicker.getDate()));
				}
				
				else 
					lblError.setText("Error! Pick date.");
			
			}
		});
		btnGenerate.setBounds(43, 244, 97, 25);
		add(btnGenerate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHomePanel(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnClose.setBounds(319, 244, 97, 25);
		add(btnClose);
		
	

	}
	/**
	 * 
	 * @param store
	 * @param date
	 * @return complete report
	 */
	public String getReport(Store store, LocalDate date)
	{
		String r="";
		String t="\t";
		String nl="\n";
		r+="Daily Sales Report for: "+date.toString()+nl+nl;
		r+="Number"+t+"Description"+t+"Qty"+t+"Amount"+nl;
		int qty=0;
		BigDecimal amt=new BigDecimal("0");
		for(Session session:store.getSessions())
		{
			r+=session.getStartDateTime().toLocalTime().toString()+nl;
			for(Sale sale:session.getSales())
			{
				for(SaleLineItem sli:sale.getSaleLineItems())
				{
					r+=sli.getItem().getNumber()+t+rightPad(sli.getItem().getDescription(),18)+
							sli.getQuantity()+t+sli.calcSubTotal()+nl;
					qty+=(sli.getQuantity());
					amt=amt.add(sli.calcSubTotal());
					
				}
			}
		}
		r+=nl;
		r+="Total"+t+t+t+qty+t+amt.toString();	
		return r;
	}
	/**
	 * formats the passed string
	 * @param text
	 * @param length
	 * @return
	 */
	private String rightPad(String text,int length)
	{
		return String.format("%-"+length+"s",text);
	}
}
