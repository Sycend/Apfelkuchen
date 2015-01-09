package J2R;

import rcaller.RCode;

public class VMatrixControllerMain {

	static private String[] colNames;
	static private double[][] vMatrix;
	static private String[] rowNames;
	private static int[] mydim;

	static private String vMatrixResultName = "vMatrix";
	static private String rowNamesResultName = "rownames";
	static private String colNamesResultName = "colnames";

	public static void main(String[] args) {

		J2R test = new J2R("RScripts/RSkript.R");

		String[] role = { "Controled" };
		RCode codeOfSuggestVMatrix = SuggestVMatrix.setCodeToSuggestVmatrix(
				new String[] { "Test1", "Test2", "Test3", "Test4", "Test5" },

				new double[][] { { 1, 0, 0, 0, 0, 0, 0 },
						{ 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
						{ 0, 0, 1, 0, 0, 0, 0 }, { 3, 0, -3, -1, 0, 0, 0 } },
				role, true);

		// RCaller caller = testJ2R.getRCaller();

		try {
			test.setCode(codeOfSuggestVMatrix);
			codeOfSuggestVMatrix.addRCode(vMatrixResultName
					.concat("<-t(vMatrix)"));

			System.out.println("test1----");

			test.runAndReturnResultOnline(vMatrixResultName);

			System.out.println("test222222222----");

			mydim = test.getParser().getDimensions(vMatrixResultName);
			vMatrix = test.getParser().getAsDoubleMatrix(vMatrixResultName,
					mydim[1], mydim[0]);

			System.out.println("test2----");

			codeOfSuggestVMatrix.clear();
			codeOfSuggestVMatrix.addRCode(rowNamesResultName
					.concat("<-rownames(vMatrix)"));
			test.runAndReturnResultOnline(rowNamesResultName);
			rowNames = test.getParser().getAsStringArray(rowNamesResultName);

			System.out.println("test3----");

			codeOfSuggestVMatrix.clear();
			codeOfSuggestVMatrix.addRCode(colNamesResultName
					.concat("<-colnames(vMatrix)"));
			test.runAndReturnResultOnline(colNamesResultName);
			colNames = test.getParser().getAsStringArray(colNamesResultName);

			System.out.println("test4----");

			System.out.println(colNames[0]);
			codeOfSuggestVMatrix.clear();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		double results[][] = vMatrix;
		String[] n = rowNames;
		String[] cn = colNames;

		test.stopRCaller();

		// -------------------------Ausgabe-------------------------------

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

}
