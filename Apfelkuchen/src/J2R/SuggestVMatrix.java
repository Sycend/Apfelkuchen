package J2R;

import rcaller.*;

public class SuggestVMatrix {

	private static String skriptPath = "RScripts/RSkript.R";
	private static J2R testJ2R = new J2R(skriptPath);
	
	static private String vMatrixResultName = "vMatrix";
	static private String rowNamesResultName = "rownames";
	static private String colNamesResultName = "colnames";
	
	@SuppressWarnings("unused")
	static private boolean resultsAvailable;

	
	public static RCode setCodeToSuggestVmatrix(String[] u_roles,
			double[][] dMatrix, String[] role, boolean debug) {
		RCode code = testJ2R.getRCode(); // wenn mehrere Skripte benutzt
											// werden ebenfalls anpassen//
											// bei einem Startpunkt
											// festlegen
											// starten und dann weglassen //
											// nach Run ist es vorhanden
		
		
		String[] colNames_sub = new String[]{"PI1","PI2","PI3","PI4","PI5","PI6","PI7"}; //Colnames from R
		String[] rowNames_sub = new String[]{"test1","test2","test3","test4","test5"}; //Rownames from R
		
		
		code.addStringArray(colNamesResultName, colNames_sub);
		code.addStringArray(rowNamesResultName, rowNames_sub);
		
		
		code.addDoubleMatrix("D", dMatrix);
		code.addStringArray("u_roles", u_roles);
		code.addStringArray("role", role);
		
//		code.addRCode("D<-data.frame(D_Inhalt)");
		code.addRCode("rownames(D)<-".concat(rowNamesResultName));
		code.addRCode("colnames(D)<-".concat(colNamesResultName));
		
//		code.addRCode("D<-D_Inhalt");
		
		if (debug)
		{
			
			code.addRCode(vMatrixResultName
					.concat("<-suggestVmatrix(u_roles,D,role[1],TRUE)"));}
		else
			code.addRCode(vMatrixResultName
					.concat("<-suggestVmatrix(u_roles,D,role[1],FALSE)"));

		return code;
	}

	
}