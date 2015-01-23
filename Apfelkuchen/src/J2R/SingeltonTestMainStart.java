package J2R;

import GUI.Two.Menu;
import GUI.Two.WindowDimensionlessFactors;

public class SingeltonTestMainStart {

	public static void calculate(boolean calculateVMatrix, J2R callerInstance) {

		String[] colNames = { "m", "k", "s", "kel", "mol", "amp", "cand" };
		String[] rowNames = PrepareForR.createRowNames();
		double vMatrix[][];
	
		VMatrixControllerMain SuggestVMatrix;

		String[] vMatrixColNames;
		String[] vMatrixRowNames;

		if (calculateVMatrix) {
			String[] u_roles = PrepareForR.createRoles();
			double[][] dMatrix = PrepareForR.createDMatrix();

			boolean debug = true;

			String[] role = { "Controlled" };

			SuggestVMatrix = new VMatrixControllerMain(callerInstance, u_roles,
					dMatrix, colNames, rowNames, role, debug);

			// Test Ausgabe bei Übernahme unnötig
			vMatrix = SuggestVMatrix.getVMatrix();
			vMatrixColNames = SuggestVMatrix.getVMatrixColNames();
			vMatrixRowNames = SuggestVMatrix.getVMatrixRowNames();

			for (int i = 0; i < vMatrixRowNames.length; i++)
				System.out.println("Test: " + vMatrixRowNames[i]);

			// -------------------------Ausgabe-------------------------------

			for (int i = 0; i < vMatrixRowNames.length; i++) {
				if (i < vMatrixRowNames.length)
					System.out.print("  " + vMatrixRowNames[i] + " ");
				for (int j = 0; j < vMatrixColNames.length; j++) {
					System.out.print(vMatrix[i][j]);// Spalte /Zeilen
					System.out.print(" ");
				}
				if (i < vMatrixColNames.length) {
					System.out.print(vMatrixColNames[i]);
				}
				System.out.print('\n');
			}

			// -------------------------------------------------------------------------------------------

		} else {

			vMatrixColNames = WindowDimensionlessFactors.getVMatrixColNames();
			vMatrixRowNames = WindowDimensionlessFactors.getVMatrixRowNames();

			vMatrix = WindowDimensionlessFactors.getVMatrix();
		}

		// double[] u_lowArray = new double[] { -1, -2, -3, -4, -5 };
		// double[] u_highArray = new double[] { 1, 2, 3, 4, 5 };

		double[] u_lowArray = PrepareForR.createMin();
		double[] u_highArray = PrepareForR.createMax();

		MinMaxTestMainFürController minMaxController = new MinMaxTestMainFürController(
				vMatrix, vMatrixRowNames, vMatrixColNames, u_lowArray,
				u_highArray);

		double[] x_low = minMaxController.getX_lowDoubleArray();
		double[] x_high = minMaxController.getX_highDoubleArray();

		String[] x_lowColNames = minMaxController.getX_lowColnamesStringArray();
		String[] x_lowRowNames = minMaxController.getX_lowRownamesStringArray();

		String[] x_highColNames = minMaxController
				.getX_highColnamesStringArray();
		String[] x_highRowNames = minMaxController
				.getX_highRownamesStringArray();

		// Test Ausgabe (Bei übernahme nicht nötig)

		for (int i = 0; i < x_low.length; i++) {
			System.out.print(x_lowRowNames[i]);
			System.out.print(" ");
			System.out.print(x_low[i]);
			System.out.println("");
			System.out.print(x_highRowNames[i]);
			System.out.print(" ");
			System.out.print(x_high[i]);
			System.out.println("");

		}
		System.out.println(x_lowColNames[0]);
		System.out.println(x_highColNames[0]);

		// callerInstance.stopRCaller();
		String minmax[][] = new String[x_low.length][2];

		for (int i = 0; i < x_low.length; i++) {
			minmax[i][0] = Double.valueOf(x_low[i]).toString();
			minmax[i][1] = Double.valueOf(x_high[i]).toString();
		}

		if (Menu.WDF == null) {
			Menu.WDF = new WindowDimensionlessFactors(vMatrix, rowNames,
					vMatrixColNames, minmax, new String[][] { { "0", "0" },
							{ "0", "0" }, { "0", "0" }, { "0", "0" },
							{ "0", "0" }, { "0", "0" }, { "0", "0" } });
		} else {
			Menu.WDF.ResetValues(vMatrix, rowNames, vMatrixColNames, minmax,
					new String[][] { { "0", "0" }, { "0", "0" }, { "0", "0" },
							{ "0", "0" }, { "0", "0" }, { "0", "0" },
							{ "0", "0" } }, true);
		}

	}
}
