package POSUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POSPD.Store;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POSFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void open(final Store store) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POSFrame frame = new POSFrame(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public POSFrame(final Store store) {
		final JFrame currentFrame =this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 436);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMaintenance = new JMenu("Maintenance");
		menuBar.add(mnMaintenance);
		
		JMenuItem mntmStore = new JMenuItem("Store");
		mntmStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				 getContentPane().add(new StoreEditPanel(currentFrame,store));
				 getContentPane().revalidate();

			}
		});
		mnMaintenance.add(mntmStore);
		
		JMenuItem mntmRegisters = new JMenuItem("Registers");
		mntmRegisters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				 getContentPane().add(new RegisterListPanel(currentFrame,store));
				 getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmRegisters);
		
		JMenuItem mntmCashiers = new JMenuItem("Cashiers");
		mntmCashiers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmCashiers);
		
		JMenuItem mntmTaxCategories = new JMenuItem("Tax categories");
		mntmTaxCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmTaxCategories);
		
		JMenuItem mntmItems = new JMenuItem("items");
		mntmItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmItems);
		
		JMenu mnPos = new JMenu("POS");
		menuBar.add(mnPos);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSLogin(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		mnPos.add(mntmLogin);
		
		JMenu mnReport = new JMenu("Report");
		menuBar.add(mnReport);
		
		JMenuItem mntmItemReport = new JMenuItem("Item Report");
		mntmItemReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemReportPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		mnReport.add(mntmItemReport);
		
		JMenuItem mntmCashierReport = new JMenuItem("Cashier Report");
		mntmCashierReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierReportPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		mnReport.add(mntmCashierReport);
		
		JMenuItem mntmDailySalesReport = new JMenuItem("Daily Sales Report");
		mntmDailySalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DailySalesReportsPanel(currentFrame,store));
				currentFrame.getContentPane().revalidate();
			}
		});
		mnReport.add(mntmDailySalesReport);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		currentFrame.getContentPane().removeAll();
		currentFrame.getContentPane().add(new POSHomePanel(store));
		currentFrame.getContentPane().revalidate();
	}

}
