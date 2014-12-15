package J2R;

import rcaller.*;

public class J2RTestStart {

	private static String skriptPath = "RScripts/RSkript.R";
	private static J2R testJ2R = new J2R(skriptPath);
	static private String[] colNames;
	static private double[][] vMatrix;
	static private String[] rowNames;
	private static int[] mydim;
	static private String vMatrixResultName = "vMatrix";
	static private String rowNamesResultName = "rownames";
	static private String colNamesResultName = "colnames";
	private static boolean suggestVmatrixResults;
	@SuppressWarnings("unused")
	static private boolean resultsAvailable;

	public static void main(String[] args) {

		// Dieser Abschnitt muss nach der Verknüpfung mit dem Kontroller wieder
		// erweitert werden
		
		String[] role = {"Controled"};
		startRCallerWithSuggestVmatrix(setCodeToSuggestVmatrix(new String[] {
				"Test1", "Test2", "Test3", "Test4", "Test5" },

		new double[][] { { 1, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0 },
				{ 3, 0, -3, -1, 0, 0, 0 } }, role, true));

		double results[][] = vMatrix;
		String[] n = rowNames;
		String[] cn = colNames;
		testJ2R.stopRCaller();

		for (int i = 0; i < mydim[1]; i++) {
			if (i < n.length)
				System.out.print(n[i] + " ");
			for (int j = 0; j < mydim[0]; j++) {
				System.out.print(results[i][j]);// Spalte /Zeilen
				System.out.print(" ");
			}

			System.out.println(cn[i]);
			System.out.print('\n');
		}

		// -------------------------------------------------------------------------------------------
	}

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

		suggestVmatrixResults = true;
		return code;
	}

	public static void startRCallerWithSuggestVmatrix(RCode c) {

		// RCaller caller = testJ2R.getRCaller();
		RCode code = c;
		try {
			if (suggestVmatrixResults) {

				testJ2R.setCode(code);
				code.addRCode(vMatrixResultName.concat("<-t(vMatrix)"));

				testJ2R.runAndReturnResultOnline(vMatrixResultName);

				mydim = testJ2R.getParser().getDimensions(vMatrixResultName);
				System.out.println("----------------------------------------");
				vMatrix = testJ2R.getParser().getAsDoubleMatrix(
						vMatrixResultName, mydim[1], mydim[0]);

				code.clear();
				code.addRCode(rowNamesResultName.concat("<-rownames(vMatrix)"));
				testJ2R.runAndReturnResultOnline(rowNamesResultName);
				rowNames = testJ2R.getParser().getAsStringArray(
						rowNamesResultName);
				code.clear();
				code.addRCode(colNamesResultName.concat("<-colnames(vMatrix)"));
				testJ2R.runAndReturnResultOnline(colNamesResultName);
				colNames = testJ2R.getParser().getAsStringArray(
						colNamesResultName);
				
				System.out.println(colNames[0]);
				code.clear();
				
				System.out.println("----------------------------------------");
				resultsAvailable = true;
			} else {
				System.out.println("Don`t forget setCodeToSuggestVmatrix");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}