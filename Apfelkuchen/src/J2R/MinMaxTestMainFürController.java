package J2R;

import rcaller.RCode;

public class MinMaxTestMainFürController {

	private J2R callerInstance = J2R.getInstance();
	private MinMax minMax;

	public MinMaxTestMainFürController(double[][] VMatrix,
			String[] rowNamesArray, String[] colNamesArray,
			double[] u_lowArray, double[] u_highArray) {

		
		minMax = new MinMax(VMatrix, rowNamesArray, colNamesArray, u_lowArray,
				u_highArray, callerInstance.getRCode());

		runMinMax();

	}

	public void runMinMax() {

		RCode code = new RCode();
		code = minMax.MinMaxCode();
		callerInstance.setCode(code);
		callerInstance.runAndReturnResultOnline(minMax
				.getRunandReturnOnlineString());

	}

	public double[] getX_lowDoubleArray() {
		return callerInstance.getParser().getAsDoubleArray(
				minMax.getX_lowDoubleArray());
	}

	public String[] getX_lowColnamesStringArray() {
		return callerInstance.getParser().getAsStringArray(
				minMax.getX_lowColnamesStringArray());
	}

	public String[] getX_lowRownamesStringArray() {
		return callerInstance.getParser().getAsStringArray(
				minMax.getX_lowRownamesStringArray());
	}

	public double[] getX_highDoubleArray() {
		return callerInstance.getParser().getAsDoubleArray(
				minMax.getX_highDoubleArray());
	}

	public String[] getX_highColnamesStringArray() {
		return callerInstance.getParser().getAsStringArray(
				minMax.getX_highColnamesStringArray());
	}

	public String[] getX_highRownamesStringArray() {
		return callerInstance.getParser().getAsStringArray(
				minMax.getX_highRownamesStringArray());
	}

}
