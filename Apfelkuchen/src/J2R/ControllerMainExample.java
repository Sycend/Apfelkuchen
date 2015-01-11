package J2R;

import rcaller.RCode;

public class ControllerMainExample {

	public static void main(String[] args) {

		J2R callerInstance = new J2R("RScripts/RSkript.R");

		String[] u_roles = { "contr", "contr", "contr", "contr", "contr",
				"contr" };
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
		String [] vMatrixRowNames = callerInstance.getParser().getAsStringArray(sVM.getVRownamesStringArray());
		String [] vMatrixColNames = callerInstance.getParser().getAsStringArray(sVM.getVColnamesStringArray());

		// Test Ausgabe (Bei übernahme nicht nötig)

		// Test Ausgabe bei Übernahme unnötig
		double results[][] = vMatrix;
		String[] cn = vMatrixColNames;
		String[] rn = vMatrixRowNames;

		// -------------------------Ausgabe-------------------------------
		System.out.println("-----VMatrix----");
		for (int i = 0; i < mydim[1]; i++) {
			if (i < rn.length)
				System.out.print("  "+rn[i] + " ");
			for (int j = 0; j < mydim[0]; j++) {
				System.out.print(results[i][j]);// Spalte /Zeilen
				System.out.print(" ");
			}
			if(i<cn.length){
				System.out.print(cn[i]);
			}
			System.out.print('\n');
		}

		// -------------------------------------------------------------------------------------------
		//

		// -------------------------------------------------------------------------------------------

		double[] u_lowArray = new double[] { -1, -2, -3, -4, -5 };
		double[] u_highArray = new double[] { 1, 2, 3, 4, 5 };

		MinMax minMax = new MinMax(vMatrix, vMatrixRowNames, vMatrixColNames,
				u_lowArray, u_highArray, callerInstance.getRCode());

		// code = new RCode();
		code = minMax.MinMaxCode();
		callerInstance.setCode(code);
		callerInstance.runAndReturnResultOnline(minMax
				.getRunandReturnOnlineString());

		double[] x_low = callerInstance.getParser().getAsDoubleArray(
				minMax.getX_lowDoubleArray());
		double[] x_high = callerInstance.getParser().getAsDoubleArray(
				minMax.getX_highDoubleArray());

		String[] x_lowColNames = callerInstance.getParser().getAsStringArray(
				minMax.getX_lowColnamesStringArray());
		String[] x_lowRowNames = callerInstance.getParser().getAsStringArray(
				minMax.getX_lowRownamesStringArray());

		String[] x_highColNames = callerInstance.getParser().getAsStringArray(
				minMax.getX_highColnamesStringArray());
		String[] x_highRowNames = callerInstance.getParser().getAsStringArray(
				minMax.getX_highRownamesStringArray());

		callerInstance.stopRCaller();

		//
		System.out.println("-----MinMax----");
		for (int i = 0; i < x_low.length; i++) {
			System.out.print(x_lowRowNames[i]);
			System.out.print(" ");
			System.out.print(x_low[i]);
			// System.out.print(x_lowColNames[i]);
			System.out.println("");
			System.out.print(x_highRowNames[i]);
			System.out.print(" ");
			System.out.print(x_high[i]);
			// System.out.print(x_highColNames[i]);
			System.out.println("");

		}
		System.out.println(x_lowColNames[0]);
		System.out.println(x_highColNames[0]);
		//
	}

}
