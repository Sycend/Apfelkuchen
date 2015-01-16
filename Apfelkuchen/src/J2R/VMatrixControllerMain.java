package J2R;

import rcaller.RCode;

public class VMatrixControllerMain {

	public static void main(String[] args) {

		J2R test = J2R.getInstance();

		String[] u_roles={"contr","contr","contr","contr","contr"};
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
		test.runAndReturnResultOnline(sVM.getRunandReturnOnlineString());
		
		int mydim[] = test.getParser().getDimensions(sVM.getVDoubleMatrix());
		
		double [][] vMatrix = test.getParser().getAsDoubleMatrix(sVM.getVDoubleMatrix(),
				mydim[1], mydim[0]);
		String [] vMatrixRowNames = test.getParser().getAsStringArray(sVM.getVRownamesStringArray());
		String [] vMatrixColNames = test.getParser().getAsStringArray(sVM.getVColnamesStringArray());
		
		test.stopRCaller();
		
		
		// Test Ausgabe bei Übernahme unnötig
		double results[][] = vMatrix;
		String[] cn = vMatrixColNames;
		String[] rn = vMatrixRowNames;

		// -------------------------Ausgabe-------------------------------

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
	}

}
