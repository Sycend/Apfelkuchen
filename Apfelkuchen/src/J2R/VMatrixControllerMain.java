package J2R;

import rcaller.RCode;

public class VMatrixControllerMain {

	private J2R callerInstance = null;
	private SuggestVMatrix sVM;

	public VMatrixControllerMain(J2R caller, String[] u_Roles,
			double[][] d_Matrix, String[] d_ColNames, String[] d_Rownames,
			String[] roleArray, boolean debugBool) {

		callerInstance = caller;

		sVM = new SuggestVMatrix(u_Roles, d_Matrix, d_ColNames, d_Rownames,
				roleArray, debugBool, callerInstance.getRCode());
		runVMatrix();
	}

	public void runVMatrix() {
		System.out.println("-------------------Test--------------");
		RCode code = new RCode();
		code = sVM.SuggestVMatrixCode();
		callerInstance.setCode(code);
		callerInstance.runAndReturnResultOnline(sVM
				.getRunandReturnOnlineString());

	}

	public String[] getVMatrixRowNames() {
		return callerInstance.getParser().getAsStringArray(
				sVM.getVRownamesStringArray());
	}

	public String[] getVMatrixColNames() {
		return callerInstance.getParser().getAsStringArray(
				sVM.getVColnamesStringArray());
	}

	public double[][] getVMatrix() {
		int mydim[] = callerInstance.getParser().getDimensions(
				sVM.getVDoubleMatrix());
		return callerInstance.getParser().getAsDoubleMatrix(
				sVM.getVDoubleMatrix(), mydim[1], mydim[0]);
	}

}
