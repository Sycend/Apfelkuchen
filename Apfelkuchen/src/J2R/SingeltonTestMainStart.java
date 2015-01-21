package J2R;



public class SingeltonTestMainStart{

	public static void calculate() {


		String[] u_roles = PrepareForR.createRoles();
		double[][] dMatrix = PrepareForR.createDMatrix();

		boolean debug = true;

		String[] role = { "Controlled" };
		String[] colNames= {"m","k","s","kel","mol","amp","cand"};
		String[] rowNames= PrepareForR.createRowNames();

		
		
		
		J2R callerInstance = J2R.getInstance();
		VMatrixControllerMain SuggestVMatrix = new VMatrixControllerMain(
				callerInstance, u_roles, dMatrix, colNames, rowNames, role,
				debug);

		// Test Ausgabe bei Übernahme unnötig
		double results[][] = SuggestVMatrix.getVMatrix();
		String[] cn = SuggestVMatrix.getVMatrixColNames();
		String[] rn = SuggestVMatrix.getVMatrixRowNames();
		
		// -------------------------Ausgabe-------------------------------

		for (int i = 0; i < cn.length; i++) {
			if (i < rn.length)
				System.out.print("  " + rn[i] + " ");
			for (int j = 0; j < rn.length; j++) {
				System.out.print(results[i][j]);// Spalte /Zeilen
				System.out.print(" ");
			}
			if (i < cn.length) {
				System.out.print(cn[i]);
			}
			System.out.print('\n');
		}

		// -------------------------------------------------------------------------------------------
		

		
		
//		double[] u_lowArray = new double[] { -1, -2, -3, -4, -5 };
//		double[] u_highArray = new double[] { 1, 2, 3, 4, 5 };
		
		
		double[] u_lowArray = PrepareForR.createMin();
		double[] u_highArray = PrepareForR.createMax();
		
		MinMaxTestMainFürController minMaxController = new MinMaxTestMainFürController(results, rn, cn, u_lowArray, u_highArray);
		
		double[] x_low = minMaxController.getX_lowDoubleArray();
		double[] x_high =  minMaxController.getX_highDoubleArray();

		String[] x_lowColNames =  minMaxController.getX_lowColnamesStringArray();
		String[] x_lowRowNames =  minMaxController.getX_lowRownamesStringArray();

		String[] x_highColNames =  minMaxController.getX_highColnamesStringArray();
		String[] x_highRowNames =  minMaxController.getX_highRownamesStringArray();

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

//		callerInstance.stopRCaller();
				
		
	}

}
