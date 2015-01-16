package J2R;

import rcaller.RCode;

public class MinMaxTestMainFürController {

	public static void main(String[] args) {
		J2R vMatrix = new J2R("RScript/RSkript.R");
		
		//Bei Controllerübernahme ersetzten
		
		double [][] VMatrix = new double [][] {{-3,-1},{0,1},{1,0},{3,0},{1,0}}; 
		String [] rowNamesArray = new String [] {"d", "h", "Te", "ti", "alp"};
		String [] colNamesArray = new String [] {"PI1", "PI2"};
		double [] u_lowArray = new double [] {-1,-2,-3,-4,-5};
		double [] u_highArray = new double [] {1,2,3,4,5};
				
		MinMax minMax = new MinMax(VMatrix, rowNamesArray, colNamesArray,u_lowArray, u_highArray, vMatrix.getRCode());
		
		
		
		RCode code = new RCode();
		code = minMax.MinMaxCode();
		vMatrix.setCode(code);
		vMatrix.runAndReturnResultOnline(minMax.getRunandReturnOnlineString());
		
		
		
		double [] x_low = vMatrix.getParser().getAsDoubleArray(minMax.getX_lowDoubleArray());
		double [] x_high = vMatrix.getParser().getAsDoubleArray(minMax.getX_highDoubleArray());
		
		String [] x_lowColNames = vMatrix.getParser().getAsStringArray(minMax.getX_lowColnamesStringArray());
		String [] x_lowRowNames =vMatrix.getParser().getAsStringArray(minMax.getX_lowRownamesStringArray());
		
		String [] x_highColNames = vMatrix.getParser().getAsStringArray(minMax.getX_highColnamesStringArray());
		String [] x_highRowNames = vMatrix.getParser().getAsStringArray(minMax.getX_highRownamesStringArray());
		
		
		vMatrix.stopRCaller();
		
		// Test Ausgabe (Bei übernahme nicht nötig)
		
		for(int i = 0; i < x_low.length; i++){
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

	}

}
