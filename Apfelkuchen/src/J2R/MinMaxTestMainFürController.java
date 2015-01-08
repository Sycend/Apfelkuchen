package J2R;

import rcaller.RCode;

public class MinMaxTestMainFürController {

	public static void main(String[] args) {
		J2R test = new J2R("RScripts/RSkript.R");
		System.out.println("Test1");
		//Bei Controllerübnahme ersetzten
		
		double [][] VMatrix = new double [][] {{-3,-1},{0,1},{1,0},{3,0},{1,0}}; 
		String [] rowNamesArray = new String [] {"d", "h", "Te", "ti", "alp"};
		String [] colNamesArray = new String [] {"PI1", "PI2"};
		double [] u_lowArray = new double [] {-1,-2,-3,-4,-5};
		double [] u_highArray = new double [] {1,2,3,4,5};
		
		//
		
		MinMax minMax = new MinMax(VMatrix, rowNamesArray, colNamesArray,u_lowArray, u_highArray, test.getRCode());
		
		System.out.println("Test2");
		
		RCode code = new RCode();
		code = minMax.MinMaxCode();
		test.setCode(code);
		test.runAndReturnResultOnline("MinMaxListe");
		
		System.out.println("Test3");
		
		double [] x_low = test.getParser().getAsDoubleArray(minMax.getX_lowDoubleArray());
		double [] x_high = test.getParser().getAsDoubleArray(minMax.getX_highDoubleArray());
		
		String [] x_lowColNames = test.getParser().getAsStringArray(minMax.getX_lowColnamesStringArray());
		String [] x_lowRowNames =test.getParser().getAsStringArray(minMax.getX_lowRownamesStringArray());
		
		String [] x_highColNames = test.getParser().getAsStringArray(minMax.getX_highColnamesStringArray());
		String [] x_highRowNames = test.getParser().getAsStringArray(minMax.getX_highRownamesStringArray());
		
		
		test.stopRCaller();
		
		// Test Ausgabe (Bei übernahme nicht nötig)
		
		for(int i = 0; i < x_low.length; i++){
			System.out.println(x_low[i]);
			System.out.println("");
			System.out.println(x_high[i]);
			
			
		}
		
		// 
	}

}
