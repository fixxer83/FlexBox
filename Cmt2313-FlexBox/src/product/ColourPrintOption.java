package product;

public enum ColourPrintOption {
	
	NoColour (0, 0),
	OneColour (1, 12),
	TwoColour (2, 15);
	
	private int colOpt;
	private double percentage;
	
	public int getColOpt() {
		return colOpt;
	}
	
	//Enum Accessors and Mutators
	public void setColOpt(int colOpt) {
		this.colOpt = colOpt;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	//Constructor
	private ColourPrintOption(int colOpt, double percentage){
		this.setColOpt(colOpt);
		this.setPercentage(percentage);
	}
	
}
