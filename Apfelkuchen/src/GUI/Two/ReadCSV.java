package GUI.Two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Dominik Hofmann, Mark Leibmann
 * @version 1.1.1
 */
public class ReadCSV {
	
	public static void readCSV(String Inputfile) {
		System.out.println("Reading: "+Inputfile);
		ArrayList<String> content = new ArrayList<String>();
		try {
			content = readFile(Inputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Starts at 1 so that the first row is ignored
		for (int i = 1; i < content.size(); i++) {
			try {
				//System.out.println("-------------------------- Neue Zeile:"); 
				String[] parts = content.get(i).split(";");
				/*System.out.println(parts[0]);
				System.out.println(parts[1]);
				System.out.println(parts[2]);
				System.out.println(parts[3]);
				System.out.println(parts[4]);
				System.out.println(parts[5]);
				System.out.println(parts[6]);
				System.out.println(parts[7]);
				System.out.println(parts[8]);
				System.out.println(parts[9]);
				System.out.println(parts[10]);*/
				RawUnits tempRawUnits = new RawUnits();
				tempRawUnits.setTypeName(parts[0]);
				tempRawUnits.setUnitName(parts[1]);
				tempRawUnits.setM(Integer.parseInt(parts[2]));
				tempRawUnits.setK(Integer.parseInt(parts[3]));
				tempRawUnits.setS(Integer.parseInt(parts[4]));
				tempRawUnits.setKel(Integer.parseInt(parts[5]));
				tempRawUnits.setMol(Integer.parseInt(parts[6]));
				tempRawUnits.setAmp(Integer.parseInt(parts[7]));
				tempRawUnits.setCand(Integer.parseInt(parts[8]));
				NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
				Number number = format.parse(parts[9]);
				tempRawUnits.setOffset(number.doubleValue());
				number = format.parse(parts[10]);
				tempRawUnits.setGradient(number.doubleValue());
				Run.unitsArray.add(tempRawUnits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*for (int i = 0; i < Run.unitTable.size(); i++) {
			System.out.println("typeName: " + Run.unitTable.get(i).getTypeName());
			System.out.println("unitName: " + Run.unitTable.get(i).getUnitName());
			System.out.println("m: " + Run.unitTable.get(i).getM());
			System.out.println("k: " + Run.unitTable.get(i).getK());
			System.out.println("s: " + Run.unitTable.get(i).getS());
			System.out.println("kel: " + Run.unitTable.get(i).getKel());
			System.out.println("mol: " + Run.unitTable.get(i).getMol());
			System.out.println("amp: " + Run.unitTable.get(i).getAmp());
			System.out.println("cand: " + Run.unitTable.get(i).getCand());
			System.out.println("offset: " + Run.unitTable.get(i).getOffset());
			System.out.println("gradient: " + Run.unitTable.get(i).getGradient());
			System.out.println("resultSILow: " + Run.unitTable.get(i).getResultSILow());
			System.out.println("resultSIHigh: " + Run.unitTable.get(i).getResultSIHigh());
		}*/
		System.out.println("Done reading: "+ Inputfile);
		
	}
	
	public static void readCSV(File Inputfile) {
		System.out.println("Reading: "+Inputfile.toString());
		ArrayList<String> content = new ArrayList<String>();
		try {
			content = readFile(Inputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Starts at 1 so that the first row is ignored
		for (int i = 1; i < content.size(); i++) {
			try {
				String[] parts = content.get(i).split(";");
				RawUnits tempRawUnits = new RawUnits();
				tempRawUnits.setTypeName(parts[0]);
				tempRawUnits.setUnitName(parts[1]);
				tempRawUnits.setM(Integer.parseInt(parts[2]));
				tempRawUnits.setK(Integer.parseInt(parts[3]));
				tempRawUnits.setS(Integer.parseInt(parts[4]));
				tempRawUnits.setKel(Integer.parseInt(parts[5]));
				tempRawUnits.setMol(Integer.parseInt(parts[6]));
				tempRawUnits.setAmp(Integer.parseInt(parts[7]));
				tempRawUnits.setCand(Integer.parseInt(parts[8]));
				NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
				Number number = format.parse(parts[9]);
				tempRawUnits.setOffset(number.doubleValue());
				number = format.parse(parts[10]);
				tempRawUnits.setGradient(number.doubleValue());
				Run.unitsArray.add(tempRawUnits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done reading: "+ Inputfile.toString());
	}
	
	/**
	 * @param Inputfile
	 * @return an Arraylist containing every line that has been read from the
	 *         file located in Inputfile String
	 * @throws Exception 
	 */
	public static ArrayList<String> readFile(String Inputfile) throws Exception {
		ArrayList<String> tmp = new ArrayList<String>();
		File file = new File(Inputfile);
		if (file.exists()) {
			System.out.println(file.getAbsolutePath() + " Exists.");
			FileInputStream f1 = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(f1, "UTF-8"));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				tmp.add(strLine);
			}
			br.close();
		} else {
			System.out.println("Could not find: " + file.getAbsolutePath());
		}
		return tmp;
	}
	
	/**
	 * @param Inputfile
	 * @return an Arraylist containing every line that has been read from the
	 *         file located in Inputfile File
	 * @throws Exception 
	 */
	public static ArrayList<String> readFile(File Inputfile) throws Exception {
		ArrayList<String> tmp = new ArrayList<String>();
		if (Inputfile.exists()) {
			System.out.println(Inputfile.getAbsolutePath() + " Exists.");
			FileInputStream f1 = new FileInputStream(Inputfile);
			BufferedReader br = new BufferedReader(new InputStreamReader(f1, "UTF-8"));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				tmp.add(strLine);
			}
			br.close();
		} else {
			System.out.println("Could not find: " + Inputfile.getAbsolutePath());
		}
		return tmp;
	}
	
}
