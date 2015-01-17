package J2R;

public class SingeltonTestMainStart {

	public static void main(String[] args) {

		String[] u_roles = { "contr", "contr", "contr", "contr", "contr" };
		String[] role = { "Controlled" };
		String[] colNames = { "m", "k", "s", "kel", "mol", "amp", "cand" };
		String[] rowNames = { "d", "h", "Te", "ti", "alp" };
		double[][] dMatrix = { { 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 }, { 3, 0, -3, -1, 0, 0, 0 } };

		boolean debug = true;

		J2R callerInstance = J2R.getInstance();
		VMatrixControllerMain SuggestVMatrix = new VMatrixControllerMain(
				callerInstance, u_roles, dMatrix, colNames, rowNames, role,
				debug);

		// Test Ausgabe bei Übernahme unnötig
		double results[][] = SuggestVMatrix.getVMatrix();
		String[] cn = SuggestVMatrix.getVMatrixColNames();
		String[] rn = SuggestVMatrix.getVMatrixRowNames();
		
		// -------------------------Ausgabe-------------------------------

		for (int i = 0; i < 5; i++) {
			if (i < rn.length)
				System.out.print("  " + rn[i] + " ");
			for (int j = 0; j < 2; j++) {
				System.out.print(results[i][j]);// Spalte /Zeilen
				System.out.print(" ");
			}
			if (i < cn.length) {
				System.out.print(cn[i]);
			}
			System.out.print('\n');
		}

		// -------------------------------------------------------------------------------------------
		//

		callerInstance.stopRCaller();

	}

}
