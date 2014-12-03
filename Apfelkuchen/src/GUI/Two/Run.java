package GUI.Two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Start of window with 1194, 550 size
 * @author Yuri Kalinin, Dominik Hofmann
 * @version 2.0.6
 */
public class Run {
	private static String[] rolle = new String[] { "controlled", "constant",
			"scale-up", "dependent" };
	protected static int rows = 0;
	public static List<RawUnits> unitsArray = new ArrayList<RawUnits>();

	public static void main(String args[]) {
		long startTime = System.nanoTime();
		Thread readCSVThread = new Thread(new Runnable() {
			@Override
			public void run() {
				CSV.readCSV("spezifikation.csv");
				// writeCSV Test
				/*
				 * RawUnits tempRaw = new RawUnits("Durchmesser", "cm", 1, 0, 0,
				 * 0, 0, 0, 0, 0.84, 0.9999); unitsArray.add(tempRaw);
				 * CSV.writeCSV("test.csv");
				 */
			}
		});
		new Window();
		readCSVThread.start();
		long endTime = System.nanoTime();
		long durationExecution = endTime - startTime;
		long durationMilliSec = TimeUnit.MILLISECONDS.convert(
				durationExecution, TimeUnit.NANOSECONDS);
		System.out.println("Execution Time: " + durationMilliSec + " MilliSec");
	}

	public static void addRow(){
		rows++;
	}
	
	public static void removeRow(){
		rows--;
	}

	public static String[] getRolle() {
		return rolle;
	}

	public static String[] getUnits() {
		String[] tmp = new String[Run.unitsArray.size()];
		for (int i = 0; i < Run.unitsArray.size(); i++) {
			tmp[i] = Run.unitsArray.get(i).getUnitName();
		}
		tmp = removeDuplicates(tmp);
		return tmp;
	}

	public static String[] getDimensions() {
		String[] tmp = new String[Run.unitsArray.size()];
		for (int i = 0; i < Run.unitsArray.size(); i++) {
			tmp[i] = Run.unitsArray.get(i).getTypeName();
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
}
