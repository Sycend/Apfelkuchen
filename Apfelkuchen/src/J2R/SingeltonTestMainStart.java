package J2R;

import com.sun.org.apache.bcel.internal.generic.DMUL;

import GUI.Two.Menu;
import GUI.Two.WindowDimensionlessFactors;
/**
 * Contains the method calculate which calculates the V-Matrix and Min/Max
 *  
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 */
public class SingeltonTestMainStart {

	/**
	 * Contains the method calculate which calculates the V-Matrix and Min/Max
	 * This method calls methods of the PrepareforR class to get the information of WindowRelevantFactors 
	 * Then the method calls both controllers to build and run the code
	 * At the end of the method the windowDimensionless Windows will be build up with all necessary values
	 * 
	 * @param calculateVMatrix check if the V Matrix must be calculated or not
	 * @param callerInstance contains the caller
	 */
	public static void calculate(boolean calculateVMatrix, J2R callerInstance) {

		String[] colNames = { "m", "k", "s", "kel", "mol", "amp", "cand" };
		String[] rowNames = PrepareForR.createRowNames();
		double vMatrix[][];
		double[][] dMatrix =null;
		VMatrixControllerMain SuggestVMatrix;

		String[] vMatrixColNames;
		String[] vMatrixRowNames;

		if (calculateVMatrix) {
			String[] u_roles = PrepareForR.createRoles();
			dMatrix = PrepareForR.createDMatrix();

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
			
			dMatrix = PrepareForR.createDMatrix();

			vMatrixColNames = WindowDimensionlessFactors.getVMatrixColNames();
			vMatrixRowNames = WindowDimensionlessFactors.getVMatrixRowNames();

			vMatrix = WindowDimensionlessFactors.getVMatrix();
		}

		// double[] u_lowArray = new double[] { -1, -2, -3, -4, -5 };
		// double[] u_highArray = new double[] { 1, 2, 3, 4, 5 };

		double[] u_lowArray = PrepareForR.createMin();
		double[] u_highArray = PrepareForR.createMax();

		MinMaxTestMainFürController minMaxController = new MinMaxTestMainFürController(
				callerInstance, vMatrix, vMatrixRowNames, vMatrixColNames,
				u_lowArray, u_highArray);

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
		String[][]dimensionlessCheck=new String[dMatrix[0].length][vMatrix[0].length];
		for(int i=0;i<vMatrix[0].length;i++){
			for(int j=0;j<dMatrix[0].length;j++){
				dimensionlessCheck[j][i]="0";
				for(int k=0;k<dMatrix.length;k++){
					dimensionlessCheck[j][i]=String.valueOf(Double.parseDouble(dimensionlessCheck[j][i])+dMatrix[k][j]*vMatrix[k][i]);
				}
			}
		}

		if (Menu.WDF == null) {
			Menu.WDF = new WindowDimensionlessFactors(vMatrix, rowNames,
					vMatrixColNames, minmax, dimensionlessCheck);
//							new String[][] { { "0", "0" },
//							{ "0", "0" }, { "0", "0" }, { "0", "0" },
//							{ "0", "0" }, { "0", "0" }, { "0", "0" } });
		} else {
			Menu.WDF.ResetValues(vMatrix, rowNames, vMatrixColNames, minmax,dimensionlessCheck,true);
//					new String[][] { { "0", "0" }, { "0", "0" }, { "0", "0" },
//							{ "0", "0" }, { "0", "0" }, { "0", "0" },
//							{ "0", "0" } }, true);
		}

	}
}
