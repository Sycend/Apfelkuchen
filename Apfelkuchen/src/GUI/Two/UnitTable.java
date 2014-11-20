package GUI.Two;

/**
 * @author Dominik Hofmann
 * @version 1.1.0
 */

public class UnitTable {
	
	/** Usage Example **/
	/*	List<UnitTable> unitTable = new ArrayList<UnitTable>();
		UnitTable tempUnitTable = new UnitTable();
        tempUnitTable.setTypeName("Temperature");
        tempUnitTable.setUnitName("C");
        tempUnitTable.setLow(120);
        tempUnitTable.setHigh(200);
        tempUnitTable.setGradient(1);
        tempUnitTable.setOffset(273.15);
        tempUnitTable.setKel(1);
        unitTable.add(tempUnitTable);
        System.out.println("Type Name: "+unitTable.get(0).getTypeName());
        System.out.println("Unit Name: "+unitTable.get(0).getUnitName());
        System.out.println("Low: "+unitTable.get(0).getLow());
        System.out.println("High: "+unitTable.get(0).getHigh());
        System.out.println("resultSILow: "+unitTable.get(0).getResultSILow());
        System.out.println("resultSIHigh: "+unitTable.get(0).getResultSIHigh());*/

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
