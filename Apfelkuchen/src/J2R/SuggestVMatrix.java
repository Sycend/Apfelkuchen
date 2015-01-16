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
	
	public String getRunandReturnOnlineString(){	
		return "vMatrixListe";
	}
	
	public String getVDoubleMatrix(){	
		return "r1";
	}
	
	public String getVColnamesStringArray(){	
		return "r3";
	}
	
	public String getVRownamesStringArray(){	
		return "r2";
	}
	
}