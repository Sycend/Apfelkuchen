package J2R;

public class MinMaxSingelton {
	
	J2R callerInstance = null;
	
	public MinMaxSingelton(J2R caller, double vmatrix)
	{
		callerInstance = caller;
	
	}

	private void ControleMinMax()
	{
		double[] u_lowArray = new double[] { -1, -2, -3, -4, -5 };
		double[] u_highArray = new double[] { 1, 2, 3, 4, 5 };

		MinMax minMax = new MinMax(vMatrix, vMatrixRowNames, vMatrixColNames,
				u_lowArray, u_highArray, callerInstance.getRCode());


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

		System.out.println("-----MinMax----");
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

	}

	}
}
