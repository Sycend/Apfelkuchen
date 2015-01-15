package GUI.Two;

/**
 * This is the base Class that works
 * as a container for relevant factors
 * @author Dominik Hofmann, Mark Leibmann
 * @version 1.1.2
 */

public class RawUnits {
	private String dimension = null;
	private String unit = null;
	int valuesSI[] = new int [7];
	private double offset = 0.0;
	private double gradient = 0.0;
	private double low = 0;
	private double high = 0;
	
	RawUnits(){
		
	}
	
	RawUnits(String dimension, String unit, int m, int k, int s, int kel, int mol, int amp, int cand, double offset, double gradient) { //double low, double high
		this.dimension = dimension;
		this.unit = unit;
		//this.low = low;
		//this.high = high;
		this.valuesSI[0] = m;
		this.valuesSI[1] = k;
		this.valuesSI[2] = s;
		this.valuesSI[3] = kel;
		this.valuesSI[4] = mol;
		this.valuesSI[5] = amp;
		this.valuesSI[6] = cand;
		this.offset = offset;
		this.gradient = gradient;
	}
	
	/** Getters **/
	
	public double getResultSILow() {
		return this.getLow() * this.getGradient() + this.getOffset();
	}
	
	public double getResultSIHigh() {
		return this.getHigh() * this.getGradient() + this.getOffset();
	}
	
	public void setLow(double low) {
		this.low = low;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public String getDimension() {
		return dimension;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public double getLow() {
		return low;
	}
	
	public double getHigh() {
		return high;
	}
	
	public double getGradient() {
		return gradient;
	}
	
	public double getOffset() {
		return offset;
	}
	
	public int getM() {
		return this.valuesSI[0];
		
	}
	
	public int getK() {
		return this.valuesSI[1];
		
	}
	
	public int getS() {
		return this.valuesSI[2];
		
	}
	
	public int getKel() {
		return this.valuesSI[3];
		
	}
	
	public int getMol() {
		return this.valuesSI[4];

	}
	
	public int getAmp() {
		return 	this.valuesSI[5];
		
	}
	
	public int getCand() {
		return this.valuesSI[6];
	}	
}
