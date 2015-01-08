package J2R;

import rcaller.RCode;

public class MinMax {
	
	private RCode code;
	private double [][] V; 
	private String [] rownames; 
	private String [] colnames; 
	private double [] u_low; 
	private double [] u_high;
	
	public MinMax(double [][] VMatrix, String [] rownamesArray, String [] colnamesArray, double [] u_lowArray, double [] u_highArray) {
		V = VMatrix;
		rownames = rownamesArray;
		colnames = colnamesArray;
		u_low = u_lowArray;
		u_high = u_highArray;
		berechneMinMax();
	}

	private void berechneMinMax() {
		
		RCode code = new RCode();
		
	
		code.addStringArray("VcolNames", colnames);
		code.addStringArray("VrowNames", rownames);
		
		
		code.addDoubleMatrix("V", V);
		code.addDoubleArray("u_low", u_low);
		code.addDoubleArray("u_high", u_high);
		

		code.addRCode("rownames(V)<-VrowNames");
		code.addRCode("colnames(V)<-VcolNames");
		
		
		
	};
	
}
