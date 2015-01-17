package J2R;

import java.util.ArrayList;

import javax.swing.JTextField;

import GUI.Two.*;

public class PrepareForR {

	public static double[][] createDMatrix() {
		double[][] dMatrix = null;

		ArrayList<ArrayList<JTextField>> siEinheiten = new ArrayList<ArrayList<JTextField>>();

		siEinheiten.add( WindowRelevantFactors.getTextFieldM());
		siEinheiten.add( WindowRelevantFactors.getTextFieldK());
		siEinheiten.add( WindowRelevantFactors.getTextFieldS());
		siEinheiten.add( WindowRelevantFactors.getTextFieldKel());
		siEinheiten.add( WindowRelevantFactors.getTextFieldMol());
		siEinheiten.add( WindowRelevantFactors.getTextFieldAmp());
		siEinheiten.add( WindowRelevantFactors.getTextFieldCand());

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < siEinheiten.get(1).size(); j++) {

				dMatrix[i][j] = Double.parseDouble(siEinheiten.get(i).get(j)
						.toString());
			}
		}

		return dMatrix;
	}

	public static String[] createRowNames() {

		String[] rowNames = null;

		for (int i = 0; i < WindowRelevantFactors.getTextFieldName().size(); i++) {
			rowNames[i] = WindowRelevantFactors.getTextFieldName().get(i)
					.toString();
		}

		return rowNames;
	}

	public static double[] createMin() {

		double[] min = null;

		for (int i = 0; i < WindowRelevantFactors.getTextFieldSILow().size(); i++) {
			min[i] = Double.parseDouble(WindowRelevantFactors
					.getTextFieldSILow().get(i).toString());
		}

		return min;
	}

	public static double[] createMax() {

		double[] max = null;

		for (int i = 0; i < WindowRelevantFactors.getTextFieldName().size(); i++) {
			max[i] = Double.parseDouble(WindowRelevantFactors
					.getTextFieldSIHigh().get(i).toString());
		}

		return max;
	}

	public static String[] createRoles() {

		String[] roles = null;

		for (int i = 0; i < WindowRelevantFactors.getComboBoxRole().size(); i++) {
			roles[i] = WindowRelevantFactors.getComboBoxRole().get(i)
					.toString();
		}

		return roles;
	}

}
//test
