package product;


public enum ReinforcementOption {
	
	NoReinforcement(false, false, 0),
	ReinforcedBottom(true, false, 10),
	ReinfBottomAndCorner(true, true, 17);
	
	private boolean reinfBottom;
	private boolean reinfCorner;
	private double reinfPercentage;
	
	public boolean isReinfBottom() {
		return reinfBottom;
	}

	public void setReinfBottom(boolean reinfBottom) {
		this.reinfBottom = reinfBottom;
	}

	public boolean isReinfCorner() {
		return reinfCorner;
	}

	public void setReinfCorner(boolean reinfCorner) {
		this.reinfCorner = reinfCorner;
	}

	public double getReinfPercentage() {
		return reinfPercentage;
	}

	public void setReinfPercentage(double reinfPercentage) {
		this.reinfPercentage = reinfPercentage;
	}
	
	private ReinforcementOption(boolean reinfBottom, boolean reinfCorners, double reinfPercentage){
		this.setReinfBottom(reinfBottom);
		this.setReinfCorner(reinfCorners);
		this.setReinfPercentage(reinfPercentage);
	}

}
