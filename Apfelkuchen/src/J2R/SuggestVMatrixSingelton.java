package J2R;

import rcaller.RCode;

public class SuggestVMatrixSingelton {
	
	J2R callerInstance = null;
	
	
	public SuggestVMatrixSingelton(J2R caller)
	{
		callerInstance = caller;
		ControleSuggestVMatrix();
	}

   private void ControleSuggestVMatrix()
   {
	    String[] u_roles = { "contr", "contr", "contr", "contr", "contr" };
		String[] role = { "Controlled" };
		String[] colNames = { "m", "k", "s", "kel", "mol", "amp", "cand" };
		String[] rowNames = { "d", "h", "Te", "ti", "alp" };
		double[][] dMatrix = { { 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 }, { 3, 0, -3, -1, 0, 0, 0 } };
		boolean debug = true;

		SuggestVMatrix sVM = new SuggestVMatrix(u_roles, dMatrix, colNames,
				rowNames, role, debug, callerInstance.getRCode());

		RCode code = new RCode();
		code = sVM.SuggestVMatrixCode();
		callerInstance.setCode(code);
		callerInstance.runAndReturnResultOnline(sVM
				.getRunandReturnOnlineString());

		int mydim[] = callerInstance.getParser().getDimensions(
				sVM.getVDoubleMatrix());

		double[][] vMatrix = callerInstance.getParser().getAsDoubleMatrix(
				sVM.getVDoubleMatrix(), mydim[1], mydim[0]);
		String[] vMatrixRowNames = callerInstance.getParser().getAsStringArray(
				sVM.getVRownamesStringArray());
		String[] vMatrixColNames = callerInstance.getParser().getAsStringArray(
				sVM.getVColnamesStringArray());

		// Test Ausgabe bei Übernahme unnötig
		double results[][] = vMatrix;
		String[] cn = vMatrixColNames;
		String[] rn = vMatrixRowNames;

		// -------------------------Ausgabe-------------------------------
		System.out.println("-----VMatrix----");
		for (int i = 0; i < mydim[1]; i++) {
			if (i < rn.length)
				System.out.print("  " + rn[i] + " ");
			for (int j = 0; j < mydim[0]; j++) {
				System.out.print(results[i][j]);// Spalte /Zeilen
				System.out.print(" ");
			}
			if (i < cn.length) {
				System.out.print(cn[i]);
			}
			System.out.print('\n');
		}

		// -------------------------------------------------------------------------------------------

   }
}
