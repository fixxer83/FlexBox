package product;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fileIO.FileOperations;
import graphicalUserInterface.MainScreen;

public abstract class Product {
	
	/**
	 * This method will get all ColourPrint options
	 * available in the ColourPrintOption enum
	 * and return them in a single
	 * arrayList
	 * 
	 * @return ArrayList<Object>
	 */
	public static ArrayList<Object> getColourPrintOptions(){
		
		//ColourPrintOptions Properties
		//All colour option types available in the ColourPrintOption enum
		int[] colour = new int[]{ColourPrintOption.NoColour.getColOpt(), 
				ColourPrintOption.OneColour.getColOpt(),ColourPrintOption.TwoColour.getColOpt()};
		
		//All colour option percentage cost available in the ColourPrintOption enum
		double[] colPerc = new double[]{ColourPrintOption.NoColour.getPercentage(), 
				ColourPrintOption.OneColour.getPercentage(),ColourPrintOption.TwoColour.getPercentage()};
				
		ArrayList<Object> colPrintOptions = new ArrayList<Object>();
		
		for(int i=0; i<= colour.length-1; i++){
			
			colPrintOptions.add(colour[i] + "," + colPerc[i]);
		}
		return colPrintOptions;
	}
	
	/**
	 * This method will get all reinforcement options
	 * available in the ReinforcementOptions enum
	 * and return them in a single
	 * arrayList
	 * 
	 * @return ArrayList<Object>
	 */
	public ArrayList<Object> getReinforcementOptions(){
		
		//ReinforcementOptions Properties
		
		//All reinforcedBottom options available in the ReinforcementOptions enum
		boolean[] reinfBottom = new boolean[]{ReinforcementOption.NoReinforcement.isReinfBottom(),
				ReinforcementOption.ReinforcedBottom.isReinfBottom(),
				ReinforcementOption.ReinfBottomAndCorner.isReinfBottom()};
		
		//All reinforcedCorners options available in the ReinforcementOptions enum
		boolean[] reinfCorner = new boolean[]{ReinforcementOption.NoReinforcement.isReinfCorner(),
				ReinforcementOption.ReinforcedBottom.isReinfCorner(),
				ReinforcementOption.ReinfBottomAndCorner.isReinfCorner()};
		
		//All reinforcement option percentage costs available in the ReinforcementOption enum
		double[] reinfPerc = new double[]{ReinforcementOption.NoReinforcement.getReinfPercentage(), 
				ReinforcementOption.ReinforcedBottom.getReinfPercentage(),
				ReinforcementOption.ReinfBottomAndCorner.getReinfPercentage()};
				
		ArrayList<Object> reinfOptions = new ArrayList<Object>();
		
		for(int i=0; i<= reinfBottom.length; i++){
			
			reinfOptions.add(reinfBottom[i] + "," + reinfCorner[i] + "," + reinfPerc[i]);
		}
		
		return reinfOptions;
	}
	
	/**
	 * Writing headerPanel and table content to invoice
	 */
	public static void writeToInvoice(JTable invoiceTable, JLabel dateLbl, JLabel fullNameLbl,
			JLabel addressLbl, JLabel totalLbl,	DefaultTableModel defaultTableModel){
		
		FileOperations fio = new FileOperations();
		fio.exportInvoiceToFIle(invoiceTable, dateLbl.getText(), fullNameLbl.getText(),
				addressLbl.getText(), MainScreen.currentUser.getUsername(), totalLbl.getText());
		removeRowsFromDefaultTableModel(defaultTableModel);
	}
	
	/**
	 * Emptying / removing all rows from table
	 */
	public static void removeRowsFromDefaultTableModel(DefaultTableModel defaultTableModel){
		if (defaultTableModel.getRowCount() > 0) {
		    for (int i = defaultTableModel.getRowCount() - 1; i > -1; i--) {
		    	defaultTableModel.removeRow(i);
		    }
		}
	}
	
}
