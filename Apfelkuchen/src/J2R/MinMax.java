package J2R;

import rcaller.RCode;

/**
 * Class for MinMax-Code.
 * 
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 *Return Value in R = MinMaxListe => runAndReturnResultOnline("MinMaxListe");
 *MinMax returned: MinMaxListe => Liste aus x_low[DoubleArray], colnames(x_low)[StringArray],
 *							 rownames(x_low)[StringArray], x_high[DoubleArray],
 *							 rownames(x_high)[StringArray], colnames(x_high)[StringArray]
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
		
	}

	public RCode MinMaxCode() {
		
	
		code.addStringArray("VcolNames", colnames);
		code.addStringArray("VrowNames", rownames);
		
		
		code.addDoubleMatrix("V", V);
		code.addDoubleArray("u_low", u_low);
		code.addDoubleArray("u_high", u_high);
		

		code.addRCode("rownames(V)<-VrowNames");
		code.addRCode("colnames(V)<-VcolNames");
		
		code.addRCode("MinMaxListe<-berechneMinMax(V,u_low,u_high)");
		
		return code;
		
	};
	
	public String getRunandReturnOnlineString(){	
		return "MinMaxListe";
	}
	
	public String getX_lowDoubleArray(){	
		return "mm1";
	}
	
	public String getX_lowColnamesStringArray(){	
		return "mm2";
	}
	
	public String getX_lowRownamesStringArray(){	
		return "mm3";
	}
	
	public String getX_highDoubleArray(){	
		return "mm4";
	}
	
	public String getX_highColnamesStringArray(){	
		return "mm5";
	}
	
	public String getX_highRownamesStringArray(){	
		return "mm6";
	}
	
	
	
}
