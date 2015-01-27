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
	
	/**
	 * Constructor for MinMax 
	 * overtakes given Attributes
	 * @param VMatrix		:from SuggestVmatrix
	 * @param rownamesArray	:from Vmatrix
	 * @param colnamesArray :from Vmatrix
	 * @param u_lowArray	:from SI_Low
	 * @param u_highArray	:from SI_High
	 * @param codeStart		: RCode
	 */
	public MinMax(double [][] VMatrix, String [] rownamesArray, String [] colnamesArray, double [] u_lowArray, double [] u_highArray, RCode codeStart) {
		V = VMatrix;
		rownames = rownamesArray;
		colnames = colnamesArray;
		u_low = u_lowArray;
		u_high = u_highArray;
		code = codeStart;
		
	}
	/**
	 * Prepares RCode for MinMax Execution in R 
	 * @return
	 * RCode ready for MinMax Execution in R
	 */
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
	/**
	 * 
	 * @return
	 * String for runAndReturnResultOnline with MinMax
	 */
	public String getRunandReturnOnlineString(){	
		return "MinMaxListe";
	}
	/**
	 * 
	 * @return
	 * String for getting the x_low from the Parser
	 */
	public String getX_lowDoubleArray(){	
		return "mm1";
	}
	/**
	 * 
	 * @return
	 * String for getting the x_low-colnames from the Parser
	 */
	public String getX_lowColnamesStringArray(){	
		return "mm2";
	}
	/**
	 * 
	 * @return
	 * String for getting the x_low-rownames from the Parser
	 */
	public String getX_lowRownamesStringArray(){	
		return "mm3";
	}
	/**
	 * 
	 * @return
	 * String for getting the x_high from the Parser
	 */
	public String getX_highDoubleArray(){	
		return "mm4";
	}
	/**
	 * 
	 * @return
	 * String for getting the x_high-rownames from the Parser
	 */
	public String getX_highColnamesStringArray(){	
		return "mm5";
	}
	/**
	 * 
	 * @return
	 * String for getting the x_high-rownames from the Parser
	 */	
	public String getX_highRownamesStringArray(){	
		return "mm6";
	}
	
	
	
}
