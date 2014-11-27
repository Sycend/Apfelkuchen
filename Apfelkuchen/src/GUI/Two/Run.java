package GUI.Two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * @author Yury Kalinin, Dominik Hofmann
 * @version 2.0.4 Start of window with 1194, 550 size
 */
public class Run {
	private static Vector<String> nameOfValue = new Vector<String>();
	private static String[] rolle = new String[] { "controlled", "constant", "scale-up", "dependent" };
	private static int numberOfComp = 0;
	private static int numExp = 0;
	public static ArrayList Si;
	public static List<RawUnits> unitsArray = new ArrayList<RawUnits>();
	
	public static void main(String args[]) {
		long startTime = System.nanoTime();
		Thread readCSVThread = new Thread(new Runnable() {
			@Override
			public void run() {
				CSV.readCSV("spezifikation.csv");
			}
		});
		Window window = new Window();
		readCSVThread.start();
		long endTime = System.nanoTime();
		long durationExecution = endTime - startTime;
		long durationMilliSec = TimeUnit.MILLISECONDS.convert(durationExecution, TimeUnit.NANOSECONDS);
		System.out.println("Execution Time: " + durationMilliSec + " MilliSec");
	}
	
	public static void remove() {
		System.out.println(numberOfComp + "run comp");
		nameOfValue.remove(numberOfComp - 1);
		numberOfComp--;
	}
	
	public static int getNumExp() {
		return numExp;
	}
	
	public static void changeNumExp() {
		numExp++;
	}
	
	public static void changeNumExp(int value) {
		numExp = value;
	}
	
	public static void changeNumComp() {
		System.out.println(numberOfComp);
		numberOfComp++;
	}
	
	public static int getNumComp() {
		return nameOfValue.size();
	}
	
	public static Vector<String> getNameOfValue() {
		return nameOfValue;
	}
	
	public static void addNameValue(String nameValue) {
		System.out.println(nameValue + " Run");
		nameOfValue.add(nameValue);
		for (int i = 1; i < nameOfValue.size(); i++) {
			System.out.println(nameOfValue.get(i).toString());
		}
	}
	
	public static int getNameOfValueSize() {
		return nameOfValue.size();
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