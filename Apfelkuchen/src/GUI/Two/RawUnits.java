package GUI.Two;

/**
 * @author Dominik Hofmann, Mark Leibmann
 * @version 1.1.0
 */

public class RawUnits {
	
	/** TODO **/
	//put m,k,s,kel,mol,amp,cand in an array
	//(remove settters ?) and replace them with constructors 
	//show resultSI values in GUI etc
	private String typeName = "";
	private String unitName = "";
	private int m = 0;
	private int k = 0;
	private int s = 0;
	private int kel = 0;
	private int mol = 0;
	private int amp = 0;
	private int cand = 0;
	private double offset = 0.0;
	private double gradient = 0.0;
	private double low = 0;
	private double high = 0;
	
	
	public double getResultSILow() {
		return this.getLow() * this.getGradient() + this.getOffset();
	}
	
	public double getResultSIHigh() {
		return this.getHigh() * this.getGradient() + this.getOffset();
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getUnitName() {
		return unitName;
	}
	
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public double getLow() {
		return low;
	}
	
	public void setLow(double low) {
		this.low = low;
	}
	
	public double getHigh() {
		return high;
	}
	
	public void setHigh(double high) {
		this.high = high;
	}
	
	public double getGradient() {
		return gradient;
	}
	
	public void setGradient(double gradient) {
		this.gradient = gradient;
	}
	
	public double getOffset() {
		return offset;
	}
	
	public void setOffset(double offset) {
		this.offset = offset;
	}
	
	public int getM() {
		return m;
	}
	
	public void setM(int m) {
		this.m = m;
	}
	
	public int getK() {
		return k;
	}
	
	public void setK(int k) {
		this.k = k;
	}
	
	public int getS() {
		return s;
	}
	
	public void setS(int s) {
		this.s = s;
	}
	
	public int getKel() {
		return kel;
	}
	
	public void setKel(int kel) {
		this.kel = kel;
	}
	
	public int getMol() {
		return mol;
	}
	
	public void setMol(int mol) {
		this.mol = mol;
	}
	
	public int getAmp() {
		return amp;
	}
	
	public void setAmp(int amp) {
		this.amp = amp;
	}
	
	public int getCand() {
		return cand;
	}
	
	public void setCand(int cand) {
		this.cand = cand;
	}
	
}
