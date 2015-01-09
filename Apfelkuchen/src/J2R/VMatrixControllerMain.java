package J2R;

import rcaller.RCode;

public class VMatrixControllerMain {

	public static void main(String[] args) {

		J2R test = new J2R("RScripts/RSkript.R");

		String[] u_roles={"contr","contr","contr","contr","contr","contr"};
		String[] role = { "Controled" };
		String[] colNames= {"m","k","s","kel","mol","amp","cand"};
		String[] rowNames= {"d", "h", "Te", "ti", "alp"};
		double[][] dMatrix= { { 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 }, { 3, 0, -3, -1, 0, 0, 0 } };
		boolean debug = true;
				
				
		SuggestVMatrix sVM= new SuggestVMatrix(u_roles,dMatrix,colNames,rowNames,role,debug,test.getRCode());
		
		RCode code = new RCode();
		code = sVM.SuggestVMatrixCode();
		test.setCode(code);
		test.runAndReturnResultOnline("vMatrix");
		
		int mydim[] = test.getParser().getDimensions(sVM.getVDoubleMatrix());
		
		double [][] vMatrix = test.getParser().getAsDoubleMatrix(sVM.getVDoubleMatrix(),
				mydim[1], mydim[0]);
		String [] vMatrixColNames = test.getParser().getAsStringArray(sVM.getVColnamesStringArray());
		String [] vMatrixRowNames = test.getParser().getAsStringArray(sVM.getVRownamesStringArray());
		
		test.stopRCaller();
		
		
		// Test Ausgabe bei Übernahme unnötig
		double results[][] = vMatrix;
		String[] n = vMatrixRowNames;
		String[] cn = vMatrixColNames;

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
		//
	}

}
