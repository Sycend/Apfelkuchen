package J2R;

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

			vMatrix = SuggestVMatrix.getVMatrix();
			vMatrixColNames = SuggestVMatrix.getVMatrixColNames();
			vMatrixRowNames = SuggestVMatrix.getVMatrixRowNames();

		} else {
			
			dMatrix = PrepareForR.createDMatrix();

			vMatrixColNames = WindowDimensionlessFactors.getVMatrixColNames();
			vMatrixRowNames = WindowDimensionlessFactors.getVMatrixRowNames();

			vMatrix = WindowDimensionlessFactors.getVMatrix();
		}

		double[] u_lowArray = PrepareForR.createMin();
		double[] u_highArray = PrepareForR.createMax();

		MinMaxTestMainFürController minMaxController = new MinMaxTestMainFürController(
				callerInstance, vMatrix, vMatrixRowNames, vMatrixColNames,
				u_lowArray, u_highArray);

		double[] x_low = minMaxController.getX_lowDoubleArray();
		double[] x_high = minMaxController.getX_highDoubleArray();

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
		} else {
			Menu.WDF.ResetValues(vMatrix, rowNames, vMatrixColNames, minmax,dimensionlessCheck,true);

		}

	}
}
