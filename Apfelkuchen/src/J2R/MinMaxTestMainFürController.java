package J2R;

import rcaller.RCode;

/**
 * This class is an interface which is used to use the MinMax function
 * from R
 * 
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 */
public class MinMaxTestMainFürController {

	private J2R callerInstance ;
	private MinMax minMax;

	/**
	 * The caller gets all the values which are needed to calculate the values vor Min and Max.
	 * A instance of MinMax is created to set the code for the
	 * calculations in R after that the runMinMax() method is called
	 * 
	 * @param caller - an instance of the RCaller
	 * @param VMatrix - the values of a VMatrix as double matrix
	 * @param rowNamesArray - The row names of the VMatrix
	 * @param colNamesArray - The col names of the VMatrix
	 * @param u_lowArray - The SI low values of the Attributes as Array
	 * @param u_highArray - The SI high values of the Attributes as Array
	 */
	public MinMaxTestMainFürController(J2R caller, double[][] VMatrix,
			String[] rowNamesArray, String[] colNamesArray,
			double[] u_lowArray, double[] u_highArray) {

		callerInstance = caller;
		minMax = new MinMax(VMatrix, rowNamesArray, colNamesArray, u_lowArray,
				u_highArray, callerInstance.getRCode());

		runMinMax();

	}

	/**
	 * In this method the code for the computations in R is transfered from the
	 * MinMax instance to the caller. After that the code is executed to
	 * get all the calculated values in the OutPutParser form R.
	 */
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
