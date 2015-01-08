package J2R;

import rcaller.RCode;

/**
 * Class for MinMax-Code.
 * 
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 *Return Value in R = MinMaxListe => runAndReturnResultOnline("MinMaxListe");
 */
public class MinMax {
	
	private RCode code;
	private double [][] V; 
	private String [] rownames; 
	private String [] colnames; 
	private double [] u_low; 
	private double [] u_high;
	
	public MinMax(double [][] VMatrix, String [] rownamesArray, String [] colnamesArray, double [] u_lowArray, double [] u_highArray, RCode codeStart) {
		V = VMatrix;
		rownames = rownamesArray;
		colnames = colnamesArray;
		u_low = u_lowArray;
		u_high = u_highArray;
		code = codeStart;
		MinMaxCode();
	}

	private RCode MinMaxCode() {
		
	
		code.addStringArray("VcolNames", colnames);
		code.addStringArray("VrowNames", rownames);
		
		
		code.addDoubleMatrix("V", V);
		code.addDoubleArray("u_low", u_low);
		code.addDoubleArray("u_high", u_high);
		

		code.addRCode("rownames(V)<-VrowNames");
		code.addRCode("colnames(V)<-VcolNames");
		
		code.addRCode("MinMaxListe<-berchneMinMax(V,u_low,u_high)");
		
		return code;
		
	};
	
	public String getU_low_DoubleArray(){	
		return "r1";
	}
	
	public String getU_low_colnames(){	
		return "r2";
	}
	
	public String getU_low_rownamesy(){	
		return "r3";
	}
	
	public String getU_high_DoubleArray(){	
		return "r4";
	}
	
	public String getU_high_colnames(){	
		return "r5";
	}
	
	public String getU_high_rownames(){	
		return "r6";
	}
	
	
	
}
