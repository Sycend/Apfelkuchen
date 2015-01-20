package J2R;



public class SingeltonTestMainStart{

	public static void calculate() {

//		//Beispiel
//		//---------------------------------------------------------
//		String[] u_roles = { "contr", "contr", "contr", "contr", "contr" };
////		String[] u_roles = PrepareForR.createRoles();
//		String[] role = { "Controlled" };
//		String[] colNames = { "m", "k", "s", "kel", "mol", "amp", "cand" };
//		String[] rowNames = PrepareForR.createRowNames();
		double[][] dMatrix = PrepareForR.createDMatrix();
//
		boolean debug = true;
//		//--------------------------------------------------------------
//		
//			
		String[] u_roles = { "contr", "contr", "contr", "contr", "contr" };
//		String[] u_roles = { "controll", "controll", "controll", "controll", "controll" };
//		String[] u_roles=PrepareForR.createRoles();
		String[] role = { "Controlled" };
		String[] colNames= {"m","k","s","kel","mol","amp","cand"};
		String[] rowNames= PrepareForR.createRowNames();
//		double[][] dMatrix= { { 1, 0, 0, 0, 0, 0, 0 },
//				{ 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
//				{ 0, 0, 1, 0, 0, 0, 0 }, { 3, 0, -3, -1, 0, 0, 0 } };
//		boolean debug = true;
//				
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 7; j++) {
//				System.out.print(dMatrix[i][j]+" ");
//				
//			}
//			System.out.println();
//		}
//		
//		System.out.println("++++++++++++++++++++++++++++++");
//		PrepareForR.createDMatrix();
		
		
		
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
		
//		//Beispiel
//		//---------------------------------------------------------
//		double[] u_lowArray = PrepareForR.createMin();
//		double[] u_highArray = PrepareForR.createMax();
//		
//		//---------------------------------------------------------
		
		
		double[] u_lowArray = new double[] { -1, -2, -3, -4, -5 };
		double[] u_highArray = new double[] { 1, 2, 3, 4, 5 };
		MinMaxTestMainFürController minMax = new MinMaxTestMainFürController(results, rn, cn, u_lowArray, u_highArray);
		
		double[] x_low = minMax.getX_lowDoubleArray();
		double[] x_high =  minMax.getX_highDoubleArray();

		String[] x_lowColNames =  minMax.getX_lowColnamesStringArray();
		String[] x_lowRowNames =  minMax.getX_lowRownamesStringArray();

		String[] x_highColNames =  minMax.getX_highColnamesStringArray();
		String[] x_highRowNames =  minMax.getX_highRownamesStringArray();

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
