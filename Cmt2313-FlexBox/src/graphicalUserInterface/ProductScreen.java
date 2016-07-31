package graphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import product.BoxType;
import product.CardGrade;
import product.Product;

public class ProductScreen extends BoxType implements ActionListener {
	
	//Used to set properties upon button press
	BoxType bt;
	ArrayList<BoxType> selectedBoxes = new ArrayList<BoxType>();
	ArrayList<Boolean> sealableOptions = new ArrayList<Boolean>();
	ArrayList<Double> sealablePercentage = new ArrayList<Double>();
	ArrayList<String> selectedBoxesDimension = new ArrayList<String>();
	ArrayList<Integer> selectedBoxesQty = new ArrayList<Integer>();
	ArrayList<Double> selectedBoxesCost = new ArrayList<Double>();
	
	InvoiceScreen is;
	
	JPanel mainPanel = new JPanel();
	
	//BoxType related components will be placed in the productPanel
	JPanel productPanel = new JPanel();
	JPanel endPanel = new JPanel();
	JPanel footerPanel = new JPanel();
	
	//Components
	JLabel cardGradeLbl  = new JLabel("Card Grade:    ");
	JComboBox cardGradeDD  = new JComboBox();
	
	JLabel cardGradeCostPerMLbl  = new JLabel("Card Grade Cost:    ");
	JTextField cardGradeCostPerMTxt  = new JTextField();
	
	JLabel colourPrintLbl = new JLabel("Print Options:    ");
	JComboBox colourPrintDD = new JComboBox();

	JLabel reinfBotLbl = new JLabel("Reinforced Bottom:    ");
	JComboBox reinfBotDD  = new JComboBox();
	
	JLabel reinfCornLbl = new JLabel("Reinforced Corners:    ");
	JComboBox reinfCornDD  = new JComboBox();
	
	JLabel sealableLbl = new JLabel("Sealble Top:    ");
	JComboBox sealableDD  = new JComboBox();
	
	JButton resetOptionsBtn = new JButton("Reset");
	
	JLabel qtyLbl = new JLabel("Quantity:    ");
	JTextField qtyTxt  = new JTextField();
	
	JLabel totalCostLbl = new JLabel("Total Cost:    ");
	JTextField totalCostTxt  = new JTextField();

	JLabel lengthLbl = new JLabel("L:  ");
	JFormattedTextField lengthTxt  = new JFormattedTextField();
	
	JLabel widthLbl = new JLabel("W:  ");
	JTextField widthTxt  = new JTextField();
	
	JLabel heightLbl = new JLabel("H:  ");
	JTextField heightTxt  = new JTextField();
	
	//Component Dimensions
	Dimension largeDimension = new Dimension(100,40);
	Dimension mediumDimension = new Dimension(90,40);
	Dimension smallDimension = new Dimension(60,40);
	Dimension smallestDimension = new Dimension(50,40);	
	
	JButton calcCostBtn = new JButton("Calculate");
	
	JButton addToCartBtn = new JButton("Add To Cart");
	
	JButton viewQuoteBtn = new JButton("View Quote");
	
	JButton checkoutBtn = new JButton("Checkout");
	
	JButton backBtn = new JButton(" Back ");
	
	//Accessors and mutators
	public String getCardGradeSelectedItem() {
		return cardGradeDD.getSelectedItem().toString();
	}

	public void setCardGradeSelectedIndex(int cardGradeIndex) {
		cardGradeDD.setSelectedIndex(cardGradeIndex);
	}

	public String getColourPrintSelectedItem() {
		return colourPrintDD.getSelectedItem().toString();
	}

	public void setColourPrintSelectedIndex(int colourPrintIndex) {
		colourPrintDD.setSelectedIndex(colourPrintIndex);
	}

	public String getReinfBotSelectedItem() {
		return reinfBotDD.getSelectedItem().toString();
	}

	public void setReinfBotSelectedIndex(int reinfBotIndex) {
		reinfBotDD.setSelectedIndex(reinfBotIndex);;
	}

	public String getReinfCornSelectedItem() {
		return reinfCornDD.getSelectedItem().toString();
	}

	public void setReinfCornSelectedIndex(int reinfCornIndex) {
		reinfCornDD.setSelectedIndex(reinfCornIndex);;
	}

	public String getSealableSelectedItem() {
		return sealableDD.getSelectedItem().toString();
	}

	public void setSealableSelectedIndex(int sealableIndex) {
		sealableDD.setSelectedIndex(sealableIndex);
	}
	
	public String getCardGradeCostPerM(){
		return cardGradeCostPerMTxt.getText();
	}
	
	public void setCardGradeCostPerM(String cost){
		cardGradeCostPerMTxt.setText(cost);
	}
	
	public String getQtyTxt() {
		return qtyTxt.getText();
	}

	public void setQtyTxt(String qtyTxt) {
		this.qtyTxt.setText(qtyTxt);
	}

	public String getTotalCostTxt() {
		return totalCostTxt.getText();
	}

	public void setTotalCostTxt(String totalCostTxt) {
		this.totalCostTxt.setText(totalCostTxt);
	}

	public String getLengthTxt() {
		return lengthTxt.getText();
	}

	public void setLengthTxt(String length) {
		this.lengthTxt.setText(length);
	}

	public String getWidthTxt() {
		return widthTxt.getText();
	}

	public void setWidthTxt(String width) {
		this.widthTxt.setText(width);
	}

	public String getHeightTxt() {
		return heightTxt.getText();
	}

	public void setHeightTxt(String height) {
		this.heightTxt.setText(height);
	}
	
	/**
	 *Method to add components to a JPanel 
	 * 
	 * @param panel
	 */
	final void addProducts(JPanel panel){
		productPanel.removeAll();
		Font font = new Font("Verdana", Font.BOLD, 12);
		productPanel.setLayout(new GridBagLayout());
		mainPanel.setLayout(new BorderLayout());
		
		//Setting gridbag constraints for left and right components
		GridBagConstraints leftSide = new GridBagConstraints();
		leftSide.anchor = GridBagConstraints.WEST;
		GridBagConstraints rightSide = new GridBagConstraints();
		rightSide.ipadx = GridBagConstraints.HORIZONTAL;
		rightSide.gridwidth = GridBagConstraints.REMAINDER;
		
		//Components dimensions
		cardGradeDD.setPreferredSize(largeDimension);
		cardGradeDD.setFont(font);
		cardGradeCostPerMTxt.setPreferredSize(largeDimension);
		cardGradeCostPerMTxt.setFont(new Font("Verdana", Font.BOLD, 14));
		colourPrintDD.setPreferredSize(largeDimension);
		colourPrintDD.setFont(font);
		reinfBotDD.setPreferredSize(largeDimension);
		reinfBotDD.setFont(font);
		reinfCornDD.setPreferredSize(largeDimension);
		reinfCornDD.setFont(font);
		addToCartBtn.setPreferredSize(largeDimension);
		resetOptionsBtn.setPreferredSize(largeDimension);
		backBtn.setPreferredSize(largeDimension);
		checkoutBtn.setPreferredSize(largeDimension);
		
		sealableDD.setPreferredSize(largeDimension);
		sealableDD.setFont(font);
	
		//Small
		totalCostTxt.setPreferredSize(mediumDimension);
		totalCostTxt.setFont(new Font("Verdana", Font.BOLD, 14));
		lengthTxt.setPreferredSize(smallestDimension);
		lengthTxt.setFont(font);
		widthTxt.setPreferredSize(smallestDimension);
		widthTxt.setFont(font);
		heightTxt.setPreferredSize(smallestDimension);
		heightTxt.setFont(font);
		qtyTxt.setPreferredSize(smallDimension);
		qtyTxt.setFont(font);
		endPanel.setLayout(new FlowLayout());
		
		//Component alignment / adding
		
		//CardGrade
		productPanel.add(cardGradeLbl, leftSide);
		productPanel.add(cardGradeDD, rightSide);
		//Colour Print Components
		productPanel.add(colourPrintLbl, leftSide);
		productPanel.add(colourPrintDD, rightSide);
		//Reinforcement Components
		productPanel.add(reinfBotLbl, leftSide);
		productPanel.add(reinfBotDD, rightSide);
		productPanel.add(reinfCornLbl, leftSide);
		productPanel.add(reinfCornDD, rightSide);
		//Sealed Box Options
		productPanel.add(sealableLbl, leftSide);
		productPanel.add(sealableDD, rightSide);
		productPanel.add(cardGradeCostPerMLbl, leftSide);
		productPanel.add(cardGradeCostPerMTxt, rightSide);
		cardGradeCostPerMTxt.setEditable(false);
		productPanel.add(addToCartBtn, leftSide);
		productPanel.add(resetOptionsBtn, rightSide);
		mainPanel.add(productPanel, BorderLayout.NORTH);

		//Box dimensions and related properties
		endPanel.add(lengthLbl);
		endPanel.add(lengthTxt);
		endPanel.add(widthLbl);
		endPanel.add(widthTxt);
		endPanel.add(heightLbl);
		endPanel.add(heightTxt);
		//Quantity
		endPanel.add(qtyLbl);
		endPanel.add(qtyTxt);
		//Calculate Cost
		endPanel.add(calcCostBtn);
		//Total Cost
		endPanel.add(totalCostLbl);
		endPanel.add(totalCostTxt);
		totalCostTxt.setEditable(false);
		//Checkout
		endPanel.add(viewQuoteBtn);
		mainPanel.add(endPanel,BorderLayout.SOUTH);
		
		panel.add(mainPanel);
		
		populateComponents();
	}
	public void populateComponents(){
		if((cardGradeDD.getItemCount() != 0) && (colourPrintDD.getItemCount() != 0) 
			&& (reinfBotDD.getItemCount() != 0) && (reinfCornDD.getItemCount() != 0) && (sealableDD.getItemCount() != 0)){
				//Avoiding re-populating dimensions
			}else{
				CardGrade cg = new CardGrade();
	
				cardGradeDD.addItem("select");
			
			for(int i=0; i< cg.getList(cg.CG_PATH).size(); i++){			
				cardGradeDD.addItem(cg.getList(cg.CG_PATH).get(i));
				i+=2;	
			}
			bt = new BoxType();
			
			bt.getList(bt.PRODUCT_PATH);
			
			//Colour Print Options
			colourPrintDD.addItem("select");
			
			for(int col=0; col<Product.getColourPrintOptions().size(); col++){
				String[] colours = Product.getColourPrintOptions().get(col).toString().split(",");
				colourPrintDD.addItem(colours[0]);
				
				//Resetting colours[]
				colours = null;
			}
			//Reinforcement Dimensions
			reinfBotDD.addItem("select");
			reinfBotDD.addItem("true");
			reinfBotDD.addItem("false");
			reinfCornDD.addItem("select");
			reinfCornDD.addItem("true");
			reinfCornDD.addItem("false");
			//Sealable box Dimensions
			sealableDD.addItem("select");
			sealableDD.addItem("true");
			sealableDD.addItem("false");
			
			//Adding action listener to dds and buttons
			cardGradeDD.addActionListener(this);
			colourPrintDD.addActionListener(this);
			reinfBotDD.addActionListener(this);
			reinfCornDD.addActionListener(this);
			calcCostBtn.addActionListener(this);
			viewQuoteBtn.addActionListener(this);		
			sealableDD.addActionListener(this);
			addToCartBtn.addActionListener(this);
			resetOptionsBtn.addActionListener(this);
			checkoutBtn.addActionListener(this);
			backBtn.addActionListener(this);
			}
		}

	/**
	 * Getting the user's input (Yes / No)
	 * from the JOptionPane
	 * 
	 * @param message
	 * @return
	 */
	public boolean getJOptionSelection(String message){
		int select = JOptionPane.showConfirmDialog(productPanel, message, "Confirm", JOptionPane.YES_NO_OPTION);
		
		boolean selection;
		
		if(select == JOptionPane.OK_OPTION){
			
			selection = true;
		}else{
			selection = false;
		}
		return selection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		bt = new BoxType();
		CardGrade cg = new CardGrade();
		
		if(e.getSource() == cardGradeDD){
			
			if(!getCardGradeSelectedItem().equals("select")){
				
				setCardGradeCostPerM(String.valueOf(cg.getCardGradeCost(cardGradeDD)));
				cardGradeDD.setEnabled(false);
			}

		}else if(e.getSource() == colourPrintDD){
			
			if(getCardGradeSelectedItem().equals("select")){
				
				setColourPrintSelectedIndex(0);
				
			}else if (!getColourPrintSelectedItem().equals("select")){
				
				for(int col=0; col< Product.getColourPrintOptions().size(); col++){
					
					int count = 0;
					String[] colours = ((String) Product.getColourPrintOptions().get(col)).split(",");
					
					if(getColourPrintSelectedItem().equals(colours[count])){
						
						col++;
						count++;
						
						setCardGradeCostPerM(super.returnBoxCost(cg.getCardGradeCost(cardGradeDD), getColourPrintSelectedItem(), 
								getReinfBotSelectedItem(),getReinfCornSelectedItem(), getSealableSelectedItem()));
					}
					
					colourPrintDD.setEnabled(false);	
				}
			}
			
		}else if(e.getSource() == reinfBotDD){
			
			if(getCardGradeSelectedItem().equals("select")){
				
				setReinfBotSelectedIndex(0);
				
			}else if (!getReinfBotSelectedItem().equals("select")){
				
				if(getReinfBotSelectedItem().equals("true")){
				
					setCardGradeCostPerM(returnBoxCost(cg.getCardGradeCost(cardGradeDD), getColourPrintSelectedItem(),
							getReinfBotSelectedItem(),getReinfCornSelectedItem(), getSealableSelectedItem()));
				
				}else if(getReinfBotSelectedItem().equals("false")){
					
					setCardGradeCostPerM(returnBoxCost(cg.getCardGradeCost(cardGradeDD), getColourPrintSelectedItem(),
							getReinfBotSelectedItem(),getReinfCornSelectedItem(), getSealableSelectedItem()));
				}
				
				reinfBotDD.setEnabled(false);
			}
			
		}else if(e.getSource() == reinfCornDD){
			
			if(getClass().equals("select")){
				
				setReinfCornSelectedIndex(0);
				
			}else if (!getReinfCornSelectedItem().equals("select")){
				
				if(getReinfCornSelectedItem().equals("true")){

					setCardGradeCostPerM(returnBoxCost(cg.getCardGradeCost(cardGradeDD), getColourPrintSelectedItem(), 
							getReinfBotSelectedItem(),getReinfCornSelectedItem(), getSealableSelectedItem()));
						
				}else if(getReinfCornSelectedItem().equals("false")){
					
					setCardGradeCostPerM(returnBoxCost(cg.getCardGradeCost(cardGradeDD), getColourPrintSelectedItem(), 
							getReinfBotSelectedItem(),getReinfCornSelectedItem(), getSealableSelectedItem()));
				}
				
				reinfCornDD.setEnabled(false);
			}
			
		}else if(e.getSource() == sealableDD){
			
			if(getCardGradeSelectedItem().equals("select")){
				
				setSealableSelectedIndex(0);
				
			}else if (!getSealableSelectedItem().equals("select")){
				
				if(getSealableSelectedItem().equals("true")){

					setCardGradeCostPerM(returnBoxCost(cg.getCardGradeCost(cardGradeDD), getColourPrintSelectedItem(), 
							getReinfBotSelectedItem(),getReinfCornSelectedItem(), getSealableSelectedItem()));
					
				}else if(getSealableSelectedItem().equals("false")){

					setCardGradeCostPerM(returnBoxCost(cg.getCardGradeCost(cardGradeDD), getColourPrintSelectedItem(), 
							getReinfBotSelectedItem(),getReinfCornSelectedItem(), getSealableSelectedItem()));
				}
				
				sealableDD.setEnabled(false);
			}
			
		}else if(e.getSource() == resetOptionsBtn){
			cardGradeDD.setEnabled(true);
			setCardGradeSelectedIndex(0);
			
			colourPrintDD.setEnabled(true);
			reinfBotDD.setEnabled(true);
			reinfCornDD.setEnabled(true);
			sealableDD.setEnabled(true);
				
			setColourPrintSelectedIndex(0);
			setReinfBotSelectedIndex(0);
			setReinfCornSelectedIndex(0);			
			setSealableSelectedIndex(0);
			cardGradeCostPerMTxt.setText("");
			
			lengthTxt.setText("");
			widthTxt.setText("");
			heightTxt.setText("");
			qtyTxt.setText("");
			totalCostTxt.setText("");
			
		}else if(e.getSource() == calcCostBtn){
			
			if(areAllValuesSelected() == false){
				
				setCardGradeSelectedIndex(0);
				cardGradeCostPerMTxt.setText("");
				
			}else if(areDimensionTextFieldsNumeric() == false){
				
				JOptionPane.showMessageDialog(productPanel, "You can only input numerical values only", "Value Not Allowed", JOptionPane.ERROR_MESSAGE);
				
			}else if(areAllValuesSelected() == true){
				
				if(areAllValuesSelected() == false){
					
					JOptionPane.showMessageDialog(productPanel, "Please, enter box dimensions!");
					viewQuoteBtn.setEnabled(false);
									
				}else if(lengthTxt.getText().equals("")){
					
					JOptionPane.showMessageDialog(productPanel, "Please, enter box length!");
					viewQuoteBtn.setEnabled(false);
									
				}else if(widthTxt.getText().equals("")){
					
					JOptionPane.showMessageDialog(productPanel, "Please, enter box width!");
					viewQuoteBtn.setEnabled(false);
				
				}else if(heightTxt.getText().equals("")){						
					
					JOptionPane.showMessageDialog(productPanel, "Please, enter box height!");
					viewQuoteBtn.setEnabled(false);
				
				}else{
					
					totalCostTxt.setText(String.valueOf(calcSurfaceAreaOfBox(Double.valueOf(getLengthTxt()), Double.valueOf(getWidthTxt()),
							Double.valueOf(getHeightTxt()), Double.valueOf(getCardGradeCostPerM()),
						Integer.valueOf(qtyTxt.getText()))));
					
					viewQuoteBtn.setEnabled(true);
				}
			}
			//Validating singular dimensions
			if(getCardGradeSelectedItem().equals("select")){
				
				JOptionPane.showMessageDialog(productPanel, "Kindly select Card Grade!");
				viewQuoteBtn.setEnabled(false);
			}
			
			if(getColourPrintSelectedItem().equals("select")){
				
				JOptionPane.showMessageDialog(productPanel, "Kindly select Colour Print option!");
				viewQuoteBtn.setEnabled(false);
			}
			
			if(getReinfBotSelectedItem().equals("select")){
				
				JOptionPane.showMessageDialog(productPanel, "Kindly select Reinforced Bottom option!");
				viewQuoteBtn.setEnabled(false);
			}
			
			if(getReinfCornSelectedItem().equals("select")){
				
				JOptionPane.showMessageDialog(productPanel, "Kindly select Reinforced Corners option!");
				viewQuoteBtn.setEnabled(false);
			}
			
			if(getSealableSelectedItem().equals("select")){
				
				JOptionPane.showMessageDialog(productPanel, "Kindly select whether you require a Sealble box or not!");
				viewQuoteBtn.setEnabled(false);
			}						
		
		}else if(e.getSource() == addToCartBtn){
			
			//Verifying that all dimensions are selected
			if((areAllValuesSelected() == false) || (totalCostTxt.getText().equals(""))){
				
				JOptionPane.showMessageDialog(productPanel, "Kindly select all values in order to add boxes to the cart!", 
						"Not all values are selected", JOptionPane.WARNING_MESSAGE);
				
			}else{
			
			//To get box type and pass values to the following (invoice) screen
			bt.setCardGrade(getCardGradeSelectedItem().toString());
			
			try{
			bt.setColourOption(Integer.parseInt(getColourPrintSelectedItem().toString()));
			}catch(NumberFormatException nme){
				
			}
			bt.setReinfBottom(Boolean.valueOf(getReinfBotSelectedItem().toString()));
			bt.setReinfCorn(Boolean.valueOf(getReinfCornSelectedItem().toString()));			
			bt.setSealableTop(Boolean.valueOf(getSealableSelectedItem().toString()));
			
			if(getSealableSelectedItem().equals("true")){
				
				bt.setSealablePercentage(5.00);
				
			}else{
				
				bt.setSealablePercentage(0.00);
			}
			
			ArrayList<Object> selectionList = new ArrayList<Object>();
			selectionList.add(bt.getCardGrade().replace("\n", ""));
			selectionList.add(bt.getColourOption());
			selectionList.add(bt.isReinfBottom());
			selectionList.add(bt.isReinfCorn());
			selectionList.add(bt.isSealableTop());
			
			bt = bt.searchForBoxType(selectionList);
			
		if(bt == null){
			JOptionPane.showMessageDialog(productPanel, "Please note that your boxes cannot be "
					+ "constructed with the selected options, kindly select different options!", 
					"No match found", JOptionPane.WARNING_MESSAGE);
			
			cardGradeDD.setEnabled(true);
			colourPrintDD.setEnabled(true);
			reinfBotDD.setEnabled(true);
			reinfCornDD.setEnabled(true);
			sealableDD.setEnabled(true);
			qtyTxt.setText("");
			totalCostTxt.setText("");
		}else{
			bt = new BoxType();
			bt = bt.searchForBoxType(selectionList);
			
			while(bt!=null){
				
				if(getColourPrintSelectedItem().equals("2")){
					bt.setColourOptionPercentage(15.00);
				}else if(getColourPrintSelectedItem().equals("1")){
					bt.setColourOptionPercentage(12.00);	
				}else{
					bt.setColourOptionPercentage(0.00);
				}

				if((getReinfBotSelectedItem().equals("true")) && (getReinfCornSelectedItem().equals("true"))){
					bt.setReinfPercentage(17.00);
				}else if(getReinfBotSelectedItem().equals("true")){
					bt.setReinfPercentage(10.00);	
				}else if(getReinfCornSelectedItem().equals("true")){
					bt.setReinfPercentage(7.00);
				}else{
					bt.setReinfPercentage(0.00);
				}
				
				selectedBoxes.add(bt);
				
				//adding the sealable % according to the user's selection
				sealableOptions.add(Boolean.valueOf(getSealableSelectedItem()));
				if(getSealableSelectedItem().equals("true")){
					bt.setSealableTop(true);
					bt.setSealablePercentage(5.00);
				}else{
					bt.setSealableTop(false);
					bt.setSealablePercentage(0.00);
				}
				
				selectedBoxesDimension.add(getLengthTxt() + " x " + getWidthTxt() + " x " + getHeightTxt());
				
				try{
					selectedBoxesQty.add(Integer.valueOf(getQtyTxt()));
				
					selectedBoxesCost.add(super.returnBoxCost(cg.getCardGradeCost(cardGradeDD), bt.getColourOptionPercentage(),
							bt.getReinfPercentage(), bt.getSealablePercentage(), Integer.valueOf(getQtyTxt()),
							Double.valueOf(getLengthTxt()), Double.valueOf(getWidthTxt()), Double.valueOf(getHeightTxt())));				
				}catch(NumberFormatException ex){
					ex.printStackTrace();
				}
				bt = null;
			}
			setNullValueFields();
		}
			}

		}else if(e.getSource() == viewQuoteBtn){
			
			if(!selectedBoxes.isEmpty()){
				is = new InvoiceScreen(selectedBoxes, selectedBoxesDimension, selectedBoxesQty, selectedBoxesCost);
				mainPanel.removeAll();
				footerPanel.add(backBtn, BorderLayout.WEST);
				footerPanel.add(checkoutBtn, BorderLayout.EAST);
				mainPanel.add(is.mainPanel, BorderLayout.NORTH);
				mainPanel.add(footerPanel, BorderLayout.SOUTH);
				mainPanel.revalidate();
				mainPanel.repaint();
				checkoutBtn.setEnabled(true);
			}else{
				
				JOptionPane.showMessageDialog(productPanel, "Please add boxes to cart prior checkout!!", 
						"Cart is Empty", JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource() == backBtn){
			
			addProductAndEndPanelsToMainPanel();
		
		}else if(e.getSource() == checkoutBtn){
			
			Product.writeToInvoice(is.invoiceTable, is.dateLbl, is.fullNameLbl, is.addressLbl,
					is.totalLbl, is.defaultTableModel);
			
			bt = null;
			is = null;	
			
			selectedBoxes = new ArrayList<BoxType>();
			checkoutBtn.setEnabled(false);
		}
	}
	
	/**
	 * Verify that all values are selected
	 * 
	 * @return
	 */
	public boolean areAllValuesSelected(){
		
		if((getCardGradeSelectedItem().equals("select")) || (getColourPrintSelectedItem().equals("select")) || (getReinfBotSelectedItem().equals("select")) ||
				(getReinfCornSelectedItem().equals("select")) || (getSealableSelectedItem().equals("select"))|| (getCardGradeSelectedItem().equals("select"))
						|| (getLengthTxt().equals("")) || (getWidthTxt().equals("")) || (getHeightTxt().equals("")) || (getQtyTxt().equals(""))){
			
			return false;
		
		}else{
			
			return true;
		}
	}
	
	/**
	 * Verify if textfields in a numerical format
	 * 
	 * @return
	 */
	public boolean areDimensionTextFieldsNumeric(){
		
		try  
		  {  
		    Double.parseDouble(getLengthTxt());
		    Double.parseDouble(getWidthTxt());
		    Double.parseDouble(getHeightTxt());
		    Double.parseDouble(getQtyTxt());
		    return true;
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }    
	}
	
	/**
	 *Setting all fields to null (0) value
	 */
	public void setNullValueFields(){
		
		setCardGradeSelectedIndex(0);
		setColourPrintSelectedIndex(0);
		setReinfBotSelectedIndex(0);
		setReinfCornSelectedIndex(0);			
		setSealableSelectedIndex(0);
		
		cardGradeDD.setEnabled(true);
		colourPrintDD.setEnabled(true);
		reinfBotDD.setEnabled(true);
		reinfCornDD.setEnabled(true);
		sealableDD.setEnabled(true);
		
		setCardGradeCostPerM("");
		setQtyTxt("");
		setTotalCostTxt("");
		setLengthTxt("");
		setWidthTxt("");
		setHeightTxt("");
	}
	
	/**
	 * Adding the original components to the mainPanel
	 */
	public void addProductAndEndPanelsToMainPanel(){
		mainPanel.removeAll();
		mainPanel.add(productPanel, BorderLayout.NORTH);
		mainPanel.add(endPanel, BorderLayout.SOUTH);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
	
}
