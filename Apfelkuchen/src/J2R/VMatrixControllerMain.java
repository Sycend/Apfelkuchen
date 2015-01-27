package J2R;

import rcaller.RCode;

/**
 * This class is an interface which is used to use the suggestVMatrix function
 * from R
 * 
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 */
public class VMatrixControllerMain {

	private J2R callerInstance = null;
	private SuggestVMatrix sVM;

	/**
	 * The caller gets all the values which are needed to suggest a VMatrix. 
	 * A instance of SuggestVMatrix is created to set the code for the
	 * calculations in R after that the runVMatrix() method is called
	 * 
	 * @param caller
	 *            - an instance of the RCaller
	 * @param u_Roles
	 *            - The roles of the Attributes
	 * @param d_Matrix
	 *            - The DMatrix form the Attributes
	 * @param d_ColNames
	 *            - The col names which are the same like the SI Units
	 * @param d_Rownames
	 *            - The row names which are the Abbreviations
	 * @param roleArray
	 *            - ???
	 * @param debugBool
	 *            - if the debug part of the suggestVMatrix function should run
	 */
	public VMatrixControllerMain(J2R caller, String[] u_Roles,
			double[][] d_Matrix, String[] d_ColNames, String[] d_Rownames,
			String[] roleArray, boolean debugBool) {

		callerInstance = caller;

		sVM = new SuggestVMatrix(u_Roles, d_Matrix, d_ColNames, d_Rownames,
				roleArray, debugBool, callerInstance.getRCode());
		runVMatrix();
	}

	/**
	 * In this method the code for the computations in R is transfered from the
	 * suggestVMatrix instance to the caller. After that the code is executed to
	 * get all the calculated values in the OutPutParser form R.
	 */
	public void runVMatrix() {
		RCode code = new RCode();
		code = sVM.SuggestVMatrixCode();
		callerInstance.setCode(code);

		callerInstance.runAndReturnResultOnline(sVM
				.getRunandReturnOnlineString());

	}

	/**
	 * gets the RowNames of the VMatrix from R and returns them as an Array of
	 * Strings
	 * 
	 * @return String[]
	 */
	public String[] getVMatrixRowNames() {
		return callerInstance.getParser().getAsStringArray(
				sVM.getVRownamesStringArray());
	}

	/**
	 * gets the ColNames of the VMatrix from R and returns them as an Array of
	 * Strings
	 * 
	 * @return String[]
	 */
	public String[] getVMatrixColNames() {
		return callerInstance.getParser().getAsStringArray(
				sVM.getVColnamesStringArray());
	}

	/**
	 * gets the values of the VMatrix itself from R and returns them as an Array
	 * of doubles
	 * 
	 * @return double[]
	 */
	public double[][] getVMatrix() {
		int mydim[] = callerInstance.getParser().getDimensions(
				sVM.getVDoubleMatrix());
		return callerInstance.getParser().getAsDoubleMatrix(
				sVM.getVDoubleMatrix(), mydim[1], mydim[0]);
	}

}
