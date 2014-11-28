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
	
	int siWerte[] = new int [7];
	
	private String typeName = "";
	private String unitName = "";
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
	
	
	public String getUnitName() {
		return unitName;
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
		return this.siWerte[0];
		
	}
	
	
	public int getK() {
		return this.siWerte[1];
		
	}
	
	public int getS() {
		return this.siWerte[2];
		
	}
	
	
	public int getKel() {
		return this.siWerte[3];
		
	}
	
	
	public int getMol() {
		return this.siWerte[4];

	}
	
	
	public int getAmp() {
		return 	this.siWerte[5];
		
	}
	
	
	public int getCand() {
		return this.siWerte[6];
	}
	
	
	RawUnits(){  //StandardKonstruktor
		
	}
	
	
	
	
	RawUnits(String typeName, String unitName,int m, int k, int s,int kel, int mol, int amp, int cand, double offset, double gradient) {
		
		//ZuweisungsKonstruktor
		
		this.siWerte[0] = m;
		this.siWerte[1] = k;
		this.siWerte[2] = s;
		this.siWerte[3] = kel;
		this.siWerte[4] = mol;
		this.siWerte[5] = amp;
		this.siWerte[6] = cand;
		
		this.typeName = typeName;
		this.unitName = unitName;
		this.offset = offset;
		this.gradient = gradient;
		
	}
	
}
