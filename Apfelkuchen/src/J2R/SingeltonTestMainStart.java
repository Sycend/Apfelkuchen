package J2R;

public class SingeltonTestMainStart {

	public static void main(String[] args) {

		String[] u_roles = { "contr", "contr", "contr", "contr", "contr" };
		String[] role = { "Controlled" };
		String[] colNames = { "m", "k", "s", "kel", "mol", "amp", "cand" };
		String[] rowNames = { "d", "h", "Te", "ti", "alp" };
		double[][] dMatrix = { { 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0 }, { 3, 0, -3, -1, 0, 0, 0 } };

		boolean debug = true;

		J2R callerInstance = J2R.getInstance();
		new ControllerMainExample(callerInstance, u_roles, dMatrix, colNames,
				rowNames, role, debug);

	}

}
