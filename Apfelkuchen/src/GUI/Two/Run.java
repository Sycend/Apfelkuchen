package GUI.Two;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTextField;

/**
 * Main used to Start Window1 + ReadCSV
 * @author Yuri Kalinin, Dominik Hofmann
 * @version 2.0.15
 */
public class Run {
	private static ArrayList<String> dateFromWindowOne = new ArrayList<String>();
	protected static int rows = 0;
	protected static String csvName = "spezifikation.csv";
	protected static String saveFileName = "RelevantFactors.tmp";
	protected static final int DEFAULT_WIDTH = 1100; //1194
	protected static final int DEFAULT_HEIGHT = 500; //550
	protected static final int DEFAULT_FONT_SIZE = 16;
	//this needs testing on resolutions that are > 1366*x
	protected static int currentWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() * ((double)DEFAULT_WIDTH / (double)1366));
	protected static int currentHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * ((double)DEFAULT_HEIGHT / (double)768));
	protected static int currentFontSize = (int)((double)DEFAULT_FONT_SIZE * Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double)1366);
	protected static int currentGridSizeHigh = (int)((double)80 * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double)1366));
	protected static int currentGridSizeLow = (int)((double)40 * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double)1366));
	public static List<RawUnits> unitsArray = new ArrayList<RawUnits>();
	
	public static void main(String args[]) {
		if (!new File(saveFileName).exists()){
			System.out.println("new WindowRelevantFactors()");
			new WindowRelevantFactors();
		} else {
			System.out.println("restoreWRF()");
			WindowRelevantFactors WRF = new WindowRelevantFactors();
			restoreWRF(WRF);
		}
		
		new Thread(new ReadCSVRunnable()).start();
	}
	
	protected static void saveWRF(){
		if (new File(saveFileName).exists()){
			new File(saveFileName).delete();
		}
		//FIXME JCombobox role is still missing
		ArrayList<ArrayList<JTextField>> tmp = new ArrayList<ArrayList<JTextField>>();
		tmp.add(WindowRelevantFactors.textFieldName);
		tmp.add(WindowRelevantFactors.textFieldAbbreviation);
		tmp.add(WindowRelevantFactors.textFieldDimension);
		tmp.add(WindowRelevantFactors.textFieldUnit);
		tmp.add(WindowRelevantFactors.textFieldLow);
		tmp.add(WindowRelevantFactors.textFieldHigh);
		tmp.add(WindowRelevantFactors.textFieldM);
		tmp.add(WindowRelevantFactors.textFieldK);
		tmp.add(WindowRelevantFactors.textFieldS);
		tmp.add(WindowRelevantFactors.textFieldKel);
		tmp.add(WindowRelevantFactors.textFieldMol);
		tmp.add(WindowRelevantFactors.textFieldAmp);
		tmp.add(WindowRelevantFactors.textFieldCand);
		tmp.add(WindowRelevantFactors.textFieldResultSILow);
		tmp.add(WindowRelevantFactors.textFieldResultSIHigh);
		Run.writeArrayList(saveFileName, tmp);
	}
	
	protected static void restoreWRF(WindowRelevantFactors WRF){
		ArrayList<ArrayList<JTextField>> tmp = new ArrayList<ArrayList<JTextField>>();
		tmp = Run.readObject(saveFileName);
		if (tmp.size() > 0){
			int x = tmp.get(0).size(); //Number of Rows
			for (int i = 0; i < x; i++){
				Run.rows++;
				WRF.newFactor();
				WindowRelevantFactors.textFieldName.get(i).setText(tmp.get(0).get(i).getText());
				WindowRelevantFactors.textFieldAbbreviation.get(i).setText(tmp.get(1).get(i).getText());
				WindowRelevantFactors.textFieldDimension.get(i).setText(tmp.get(2).get(i).getText());
				WindowRelevantFactors.textFieldUnit.get(i).setText(tmp.get(3).get(i).getText());
				WindowRelevantFactors.textFieldLow.get(i).setText(tmp.get(4).get(i).getText());
				WindowRelevantFactors.textFieldHigh.get(i).setText(tmp.get(5).get(i).getText());
				WindowRelevantFactors.textFieldM.get(i).setText(tmp.get(6).get(i).getText());
				WindowRelevantFactors.textFieldK.get(i).setText(tmp.get(7).get(i).getText());
				WindowRelevantFactors.textFieldS.get(i).setText(tmp.get(8).get(i).getText());
				WindowRelevantFactors.textFieldKel.get(i).setText(tmp.get(9).get(i).getText());
				WindowRelevantFactors.textFieldMol.get(i).setText(tmp.get(10).get(i).getText());
				WindowRelevantFactors.textFieldAmp.get(i).setText(tmp.get(11).get(i).getText());
				WindowRelevantFactors.textFieldCand.get(i).setText(tmp.get(12).get(i).getText());
				WindowRelevantFactors.textFieldResultSILow.get(i).setText(tmp.get(13).get(i).getText());
				WindowRelevantFactors.textFieldResultSIHigh.get(i).setText(tmp.get(14).get(i).getText());
				WRF.contentPanel.revalidate();
				WRF.contentPanel.repaint();
			}
		}
	}
	
	/**
	 * @return A duplicate free String[] Array that contains all Dimensions found in unitsArray
	 */
	public static String[] getDimensions() {
		String[] tmp = new String[Run.unitsArray.size()];
		for (int i = 0; i < Run.unitsArray.size(); i++) {
			tmp[i] = Run.unitsArray.get(i).getDimension();
		}
		tmp = removeDuplicates(tmp);
		return tmp;
	}
	
	/**
	 * @param A String[] Array that contains duplicates
	 * @return A String[] Array that contains no more duplicates
	 */
	public static String[] removeDuplicates(String[] containsDuplicates) {
		List<String> containsDuplicatesTmp = Arrays.asList(containsDuplicates);
		List<String> tmp0 = new ArrayList<String>();
		boolean duplicate = false;
		if (containsDuplicatesTmp.size() > 0) {
			for (int i = 0; i < containsDuplicatesTmp.size(); i++) {
				if (tmp0.size() < 1) {
					tmp0.add(containsDuplicatesTmp.get(i));
				} else if (tmp0.size() > 0) {
					for (int n = 0; n < tmp0.size(); n++) {
						if (tmp0.get(n).equals(containsDuplicatesTmp.get(i))) {
							duplicate = true;
						}
					}
					if (duplicate == false) {
						tmp0.add(containsDuplicatesTmp.get(i));
					}
					duplicate = false;
				}
			}
		}
		String[] tmp = new String[tmp0.size()];
		return tmp0.toArray(tmp);
	}
	
	// Save date from Window one for using in R functions. All elements of array
	// are string
	public static void savaDateFromFields() {
		// copy array with date from field of window one into array in the run
		// funk.
		dateFromWindowOne = WindowRelevantFactors.dateFromFieldString;
		// print out the array for testing
		for (int i = 0; i < 16 * Run.rows; i++) {
			System.out.println(dateFromWindowOne.get(i).toString() + " Ausgabe");
			System.out.println(dateFromWindowOne.size() + " size");
		}
	}
	
	public static class ReadCSVRunnable implements Runnable {		
		@Override
		public void run() {
			CSV.readCSV(csvName);
		}
	}
	
	/**
	 * @param filename
	 * @param data
	 * @throws Exception 
	 */
	public static void writeArrayList(String filename, ArrayList<?> data) {
		try {
			FileOutputStream fileoutput = new FileOutputStream(filename);
			ObjectOutputStream outputstream = new ObjectOutputStream(fileoutput);
			outputstream.writeObject(data);
			outputstream.flush();
			outputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param Inputfile
	 * @return description here soon TM
	 */
	public static ArrayList<ArrayList<JTextField>> readObject(String Inputfile){
		ArrayList<ArrayList<JTextField>> tmp = new ArrayList<ArrayList<JTextField>>();
		try{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(Inputfile));			
			tmp = (ArrayList<ArrayList<JTextField>>) input.readObject();
			input.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return tmp;
	}
	
}