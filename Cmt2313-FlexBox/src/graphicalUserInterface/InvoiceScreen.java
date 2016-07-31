package graphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import product.BoxType;
import customers.UserClass;

public class InvoiceScreen {
	UserClass user = new UserClass();
	DefaultTableModel defaultTableModel;
	JTable invoiceTable;
	
	public JPanel mainPanel = new JPanel();
	JPanel headerPanel = new JPanel();
	JPanel invoiceItemsPanel = new JPanel();
	JLabel dateLbl = new JLabel();
	JLabel fullNameLbl = new JLabel();
	JLabel addressLbl = new JLabel();
	JLabel totalLbl = new JLabel("0.00");
	Font font = new Font("Verdana", Font.BOLD, 12);
	double totalCost = 0.00;
	ArrayList<JLabel> dimensionsLbl = new ArrayList<JLabel>();
	ArrayList<JLabel> invoiceLineLbl = new ArrayList<JLabel>();
	ArrayList<JLabel> costLbl = new ArrayList<JLabel>();
	ArrayList<Object> contentsList = new ArrayList<Object>();

	public InvoiceScreen(ArrayList<BoxType> invoiceItems, ArrayList<String> dimensions, ArrayList<Integer> qty, ArrayList<Double> cost){
		//Calling method to populate invoice
		
		//Layout properties
		mainPanel.setLayout(new BorderLayout());
		headerPanel.setLayout(new GridBagLayout());
		invoiceItemsPanel.setLayout(new FlowLayout());
		
		headerPanel.add(dateLbl);
		headerPanel.add(fullNameLbl);
		headerPanel.add(addressLbl);
		headerPanel.add(totalLbl);
		totalLbl.setFont(font);
		getInvoiceItems(invoiceItems, dimensions, qty, cost);
		invoiceItemsPanel.setVisible(true);
		invoiceItemsPanel.setPreferredSize(new Dimension(600, 350));
		mainPanel.add(headerPanel, BorderLayout.PAGE_START);
		mainPanel.add(invoiceItemsPanel, BorderLayout.CENTER);
		mainPanel.setVisible(true);
	}
	
	/**
	 * Getting parameters and using them to populate table
	 * and labels
	 * 
	 * @param invoiceItems
	 * @param dimensions
	 * @param qty
	 * @param cost
	 */
	private void getInvoiceItems(ArrayList<BoxType> invoiceItems,  ArrayList<String> dimensions, 
			ArrayList<Integer> qty, ArrayList<Double> cost){
		//Setting date
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		dateLbl.setText("Date of invoice: " + sdf.format(date).toString());
		
		fullNameLbl.setText(", Client: " + MainScreen.currentUser.getFirstName() + 
				" " + MainScreen.currentUser.getLastName());
		addressLbl.setText(", Address: " + MainScreen.currentUser.getAddress());

		String[] header = {"Dimensions","Card Grades","Colour Print","Colour Print %","Reinforced Bottom",
				"Reinforced Corner","Reinforced %","Sealable","Sealable Percentage", "Qty", "Price"};
		
		Object[][] boxesList = new Object[invoiceItems.size()][11];
		
		for(int i=0; i< invoiceItems.size(); i++){
			boxesList[i][0] = dimensions.get(i);
			boxesList[i][1] = invoiceItems.get(i).getCardGrade();
			boxesList[i][2] = invoiceItems.get(i).getColourOption();
			boxesList[i][3] = invoiceItems.get(i).getColourOptionPercentage();
			boxesList[i][4] = invoiceItems.get(i).isReinfBottom();
			boxesList[i][5] = invoiceItems.get(i).isReinfCorn();
			boxesList[i][6] = invoiceItems.get(i).getReinfPercentage();
			boxesList[i][7] = invoiceItems.get(i).isSealableTop();
			boxesList[i][8] = invoiceItems.get(i).getSealablePercentage();
			boxesList[i][9] = qty.get(i);
			boxesList[i][10] = String.valueOf(cost.get(i));
			totalCost+= cost.get(i);
		}
		totalLbl.setForeground(Color.RED);
		totalLbl.setText("  Total Cost: €" + String.valueOf(totalCost));
		
		defaultTableModel = new DefaultTableModel(boxesList, header);
		invoiceTable = new JTable(defaultTableModel);
		invoiceTable.setEnabled(false);
		invoiceTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		invoiceTable.setPreferredScrollableViewportSize(new Dimension(500, 100));
		invoiceTable.setFillsViewportHeight(true);
		invoiceItemsPanel.add(new JScrollPane(invoiceTable));		
	}
	
	
	
	
	
	

}
