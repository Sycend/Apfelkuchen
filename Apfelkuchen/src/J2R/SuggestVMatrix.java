package J2R;

import rcaller.RCode;

/**
 * Class for SuggestVMatrix-Code.
 * 
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 *Return Value in R = vMatrixListe => runAndReturnResultOnline("vMatrixListe");
 *SuggestVMatrix returned: vMatrixListe => Liste aus VMatrix[DoubelMatrix], colnames(VMatrix)[StringArray],
 *							 rownames(VMatrix)[StringArray]
 */
public class SuggestVMatrix {

	private String[] u_roles;
	private String[] dColNames;
	private String[] dRowNames;
	private String[] role;
	private double[][] dMatrix;
	private boolean debug;
	private RCode code;
	/**
	 * Constructor for SuggestVMatrix 
	 * overtakes given Attributes
	 * @param u_Roles
	 * @param d_Matrix
	 * @param d_ColNames
	 * @param d_Rownames
	 * @param roleArray
	 * @param debugBool
	 * @param codeStart
	 */
	public SuggestVMatrix(String[] u_Roles,
			double[][] d_Matrix,String[] d_ColNames,String[] d_Rownames, String[] roleArray, boolean debugBool,RCode codeStart){
		u_roles=u_Roles;
		dColNames=d_ColNames;
		dRowNames=d_Rownames;
		role=roleArray;
		dMatrix=d_Matrix;
		debug=debugBool;
		code=codeStart;		
	}
	/**
	 * Prepares RCode for SuggestVmatrix Execution in R 
	 * @return
	 * RCode ready for SuggestVmatrix Execution in R
	 */
	public RCode SuggestVMatrixCode() {
				
		
		code.addStringArray("DcolNames", dColNames);
		code.addStringArray("DrowNames", dRowNames);
		code.addDoubleMatrix("D", dMatrix);
		
		code.addStringArray("u_roles", u_roles);
		code.addStringArray("role", role);
		
		code.addRCode("rownames(D)<-DrowNames");
		code.addRCode("colnames(D)<-DcolNames");
		code.addRCode("u_roles<-as.data.frame(u_roles)");
		
		if (debug)
			code.addRCode("vMatrixListe<-suggestVmatrix(u_roles,D,role[1],TRUE)");
		else
			code.addRCode("vMatrixListe<-suggestVmatrix(u_roles,D,role[1],FALSE)");

		return code;
	}
	/**
	 * 
	 * @return
	 * String for runAndReturnResultOnline with SuggestVmatrix
	 */
	public String getRunandReturnOnlineString(){	
		return "vMatrixListe";
	}
	/**
	 * 
	 * @return
	 * String for getting the Vmatrix from the Parser
	 */
	public String getVDoubleMatrix(){	
		return "svm1";
	}
	/**
	 * 
	 * @return
	 * String for getting the Vmatrix-Colnames from the Parser
	 */
	public String getVColnamesStringArray(){	
		return "svm3";
	}
	/**
	 * 
	 * @return
	 * String for getting the Vmatrix-rownames from the Parser
	 */
	public String getVRownamesStringArray(){	
		return "svm2";
	}
	
}