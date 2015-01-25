package J2R;

import java.util.ArrayList;

import javax.swing.JTextField;

import GUI.Two.*;

public class PrepareForR {

	public static double[][] createDMatrix() {
		

		ArrayList<ArrayList<JTextField>> siEinheiten = new ArrayList<ArrayList<JTextField>>();

		siEinheiten.add( WindowRelevantFactors.getTextFieldM());
		siEinheiten.add( WindowRelevantFactors.getTextFieldK());
		siEinheiten.add( WindowRelevantFactors.getTextFieldS());
		siEinheiten.add( WindowRelevantFactors.getTextFieldKel());
		siEinheiten.add( WindowRelevantFactors.getTextFieldMol());
		siEinheiten.add( WindowRelevantFactors.getTextFieldAmp());
		siEinheiten.add( WindowRelevantFactors.getTextFieldCand());

		double[][] dMatrix = new double [siEinheiten.get(1).size()][7];
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < siEinheiten.get(1).size(); j++) {
				dMatrix[j][i] = Integer.parseInt(siEinheiten.get(i).get(j)
						.getText());
				
				

			}
		}
		
//		for (int i = 0; i < siEinheiten.get(1).size(); i++) {
//			for (int j = 0; j < 7; j++) {
//				System.out.print(dMatrix[j][i]+" ");
//				
//			}
//			System.out.println();
//		}
		
		
		
		return dMatrix;
	}

	public static String[] createRowNames() {

		String[] rowNames = new String [WindowRelevantFactors.getTextFieldName().size()];

		for (int i = 0; i < WindowRelevantFactors.getTextFieldName().size(); i++) {
			rowNames[i] = WindowRelevantFactors.getTextFieldName().get(i)
					.getText();
		}
			
			System.out.println();
		for (int i = 0; i < WindowRelevantFactors.getTextFieldName().size(); i++) {
			System.out.println(rowNames[i]);
		}

		
		
		return rowNames;
	}

	public static double[] createMin() {

		double[] min = new double [WindowRelevantFactors.getTextFieldSILow().size()];

		for (int i = 0; i < WindowRelevantFactors.getTextFieldSILow().size(); i++) {
			min[i] = Double.parseDouble(WindowRelevantFactors
					.getTextFieldSILow().get(i).getText());
		}
		
		for (int i = 0; i < WindowRelevantFactors.getTextFieldSILow().size(); i++) {
			System.out.println(min[i]);
		}

		return min;
	}

	public static double[] createMax() {

		double[] max = new double [WindowRelevantFactors.getTextFieldName().size()];

		for (int i = 0; i < WindowRelevantFactors.getTextFieldName().size(); i++) {
			max[i] = Double.parseDouble(WindowRelevantFactors
					.getTextFieldSIHigh().get(i).getText());
		}

		for (int i = 0; i < WindowRelevantFactors.getTextFieldName().size(); i++) {
			System.out.println(max[i]);
		}
		
		return max;
	}

	public static String[] createRoles() {

		String[] roles = new String [WindowRelevantFactors.getComboBoxRole().size()];

		for (int i = 0; i < WindowRelevantFactors.getComboBoxRole().size(); i++) {
			roles[i] = WindowRelevantFactors.getComboBoxRole().get(i)
					.getSelectedItem().toString();
		}
		
		for (int i = 0; i < WindowRelevantFactors.getComboBoxRole().size(); i++) {
			System.out.println(roles[i]);
		}

		return roles;
	}

}
//test
