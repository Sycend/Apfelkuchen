

package J2R;

import java.util.ArrayList;

import javax.swing.JTextField;

import java.math.*;

import GUI.Two.*;

/**
 * There are methods in this class to get the information or strings of the WindowRelevantFactors.
 * There information will be transformed into differnt data frames
 *  
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 */
public class PrepareForR {

	/**
	 * This method creates the D-Matrix by getting the information of the textfields of the Window RelevantFactors.
	 * These textfields contains the necessary information about the D-Matrix (SI-Einheiten)
	 * 	(M,K,S,Kel,Mol,Amp,Cand)
	 * These information will be added to a new Arraylist.
	 * This Arraylist will be transformed into a double [][]
	 * This method returns the double [][]
	 */
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

	/**
	 * This method creates the Rownames by getting the information of the textfields of the Window RelevantFactors.
	 * These textfields contains the necessary information about the Rownames
	 * These information be transformed into a String[]
	 * This method returns the String[]
	 */
	public static String[] createRowNames() {

		String[] rowNames = new String [WindowRelevantFactors.getTextFieldAbbr().size()];

		for (int i = 0; i < WindowRelevantFactors.getTextFieldAbbr().size(); i++) {
			rowNames[i] = WindowRelevantFactors.getTextFieldAbbr().get(i)
					.getText();
		}
			
			System.out.println();
		for (int i = 0; i < WindowRelevantFactors.getTextFieldAbbr().size(); i++) {
			System.out.println(rowNames[i]);
		}

		
		
		return rowNames;
	}

	/**
	 * This method creates the Min by getting the information of the textfields of the Window RelevantFactors.
	 * These textfields contains the necessary information about the Min
	 * These information be transformed into a double[]
	 * This method returns the double[]
	 */
	public static double[] createMin() {

		double[] min = new double [WindowRelevantFactors.getTextFieldSILow().size()];
System.out.println("-------------MIN-------------");
		for (int i = 0; i < WindowRelevantFactors.getTextFieldSILow().size(); i++) {
			min[i] = Double.parseDouble(WindowRelevantFactors
					.getTextFieldSILow().get(i).getText());
			System.out.println("N:"+min[i]);
			
			min[i]=Math.log10(min[i]);
			System.out.println("L:"+min[i]);
		}
		
		for (int i = 0; i < WindowRelevantFactors.getTextFieldSILow().size(); i++) {
			System.out.println(min[i]);
		}

		return min;
	}

	/**
	 * This method creates the Max by getting the information of the textfields of the Window RelevantFactors.
	 * These textfields contains the necessary information about the Max
	 * These information be transformed into a double[]
	 * This method returns the double[]
	 */
	public static double[] createMax() {

		double[] max = new double [WindowRelevantFactors.getTextFieldAbbr().size()];

		System.out.println("------------MAX----------");
		for (int i = 0; i < WindowRelevantFactors.getTextFieldAbbr().size(); i++) {
			max[i] = Double.parseDouble(WindowRelevantFactors
					.getTextFieldSIHigh().get(i).getText());
			System.out.println("N:"+ max[i]);
				max[i]=Math.log10(max[i]);
				
				System.out.println("L:"+max[i]);

			//max[i]=Math.log(max[i]) / Math.log(10);
			
		}

		for (int i = 0; i < WindowRelevantFactors.getTextFieldAbbr().size(); i++) {
			System.out.println(max[i]);
		}
		
		return max;
	}
	
	/**
	 * This method creates the roles by getting the information of the combobox of the Window RelevantFactors.
	 * These combobox contains the necessary information about the roles
	 * These information be transformed into a String[]
	 * This method returns the String[]
	 */
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