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
	static private String rowNamesResultName = "rowNames";
	static private String colNamesResultName = "colNames";
	private static boolean suggestVmatrixResults;
	static private boolean resultsAvailable;

	public static void main(String[] args) {

		startRCallerWithSuggestVmatrix(setCodeToSuggestVmatrix(new String[] {
				"Test1", "Test2", "Test3", "Test4", "Test5" },

		new double[][] { { 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 3, 4, 5, 6, 7 }, { 1, 2, 3, 4, 5, 6, 7 },
				{ 1, 2, 3, 4, 5, 6, 7 } }, true));

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
	}

	public static RCode setCodeToSuggestVmatrix(String[] abkuerzungen,
			double[][] dMatrix, boolean debug) {
		RCode code = testJ2R.getRCode(); // wenn mehrere Skripte benutzt
											// werden ebenfalls anpassen//
											// bei einem Startpunkt
											// festlegen
											// starten und dann weglassen //
											// nach Run ist es vorhanden
		code.addDoubleMatrix("D", dMatrix);
		code.addStringArray("u_abbr", abkuerzungen);

		if (debug)
			code.addRCode(vMatrixResultName
					.concat("<-suggestVmatrix(u_abbr,D,TRUE)"));
		else
			code.addRCode(vMatrixResultName
					.concat("<-suggestVmatrix(u_abbr,D,FALSE)"));

		suggestVmatrixResults = true;
		return code;
	}

	public static void startRCallerWithSuggestVmatrix(RCode c) {

		RCaller caller = testJ2R.getRCaller();
		RCode code = c;
		try {
			if (suggestVmatrixResults) {

				caller.setRCode(code);
				code.addRCode(vMatrixResultName.concat("<-t(vMatrix)"));
				
				caller.runAndReturnResultOnline(vMatrixResultName);
				
				mydim = caller.getParser().getDimensions(vMatrixResultName);
	
				vMatrix = caller.getParser().getAsDoubleMatrix(
						vMatrixResultName, mydim[1], mydim[0]);
	
				code.clear();
				code.addRCode(rowNamesResultName.concat("<-rownames(vMatrix)"));
				caller.runAndReturnResultOnline(rowNamesResultName);
				rowNames = caller.getParser().getAsStringArray(
						rowNamesResultName);
				code.clear();
				code.addRCode(colNamesResultName.concat("<-colnames(vMatrix)"));
				caller.runAndReturnResultOnline(colNamesResultName);
				colNames = caller.getParser().getAsStringArray(
						colNamesResultName);
				code.clear();
				resultsAvailable = true;
			} else {
				System.out.println("Don`t forget setCodeToSuggestVmatrix");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}