package GUI.Two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main used to Start MainWindow + ReadCSV
 * @author Yuri Kalinin, Dominik Hofmann
 * @version 2.0.7
 */
public class Run {
	private static String[] role = new String[] { "controlled", "constant",
			"scale-up", "dependent" };
	protected static int rows = 0;
	public static List<RawUnits> unitsArray = new ArrayList<RawUnits>();
	private static ArrayList<String> dateFromWindowOne = new ArrayList<String>();
	protected static String csvName = "spezifikation.csv";

	public static void main(String args[]) {
		new Window();
		new Thread(new ReadCSVRunnable()).start();
	}

	public static void addRow() {
		rows++;
	}

	public static void removeRow() {
		rows--;
	}

	public static String[] getRole() {
		return role;
	}

	public static String[] getUnits() {
		String[] tmp = new String[Run.unitsArray.size()];
		for (int i = 0; i < Run.unitsArray.size(); i++) {
			tmp[i] = Run.unitsArray.get(i).getUnit();
		}
		tmp = removeDuplicates(tmp);
		return tmp;
	}
	
	public static String[] getDimensions() {
		String[] tmp = new String[Run.unitsArray.size()];
		for (int i = 0; i < Run.unitsArray.size(); i++) {
			tmp[i] = Run.unitsArray.get(i).getDimension();
		}
		tmp = removeDuplicates(tmp);
		return tmp;
	}
	
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
		dateFromWindowOne = Window.dateFromFieldString;
		// print out the array for testing
		for (int i = 0; i < 16 * Run.rows; i++) {
			System.out
					.println(dateFromWindowOne.get(i).toString() + " Ausgabe");
			System.out.println(dateFromWindowOne.size() + " size");
		}
	}
	
	public static class ReadCSVRunnable implements Runnable {		
		@Override
		public void run() {
			CSV.readCSV(csvName);
		}
	}
	
}
