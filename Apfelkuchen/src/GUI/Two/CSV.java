package GUI.Two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Dominik Hofmann, Mark Leibmann
 * @version 1.2.0
 */
public class CSV {
	
	/**
	 * @param Inputfile
	 * @throws IOException
	 *             if it can't access the file
	 * @throws IOException
	 *             if it can't write to the file
	 * @throws IOException
	 *             if it can't close the FileWriter
	 */
	public static void writeCSV(String Inputfile) {
		//FIXME currently we only append values we might
		// want to delete the file we write to first
		BufferedWriter fw = null;
		try {
			fw = new BufferedWriter(new FileWriter(new File(Inputfile), true));
		} catch (IOException e) {
			System.out.println("Can't access the file.");
			e.printStackTrace();
		}
		try {
			fw.append("typeName;unitName;m;k;s;kel;mol;amp;cand;offset;gradient");
			fw.newLine();
			for (int i = 0; i < Run.unitsArray.size(); i++) {
				fw.append(Run.unitsArray.get(i).getTypeName());
				fw.append(";");
				fw.append(Run.unitsArray.get(i).getUnitName());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getM());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getK());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getS());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getKel());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getMol());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getAmp());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getCand());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getOffset());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getGradient());
				fw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Can't write to file.");
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			System.out.println("Can't close the FileWriter.");
			e.printStackTrace();
		}
	}
	
	/**
	 * @param Inputfile
	 * @throws IOException
	 *             if it can't access the file
	 * @throws IOException
	 *             if it can't write to the file
	 * @throws IOException
	 *             if it can't close the FileWriter
	 */
	public static void writeCSV(File Inputfile) {
		BufferedWriter fw = null;
		try {
			fw = new BufferedWriter(new FileWriter(Inputfile, true));
		} catch (IOException e) {
			System.out.println("Can't access the file.");
			e.printStackTrace();
		}
		try {
			fw.append("typeName;unitName;m;k;s;kel;mol;amp;cand;offset;gradient");
			fw.newLine();
			for (int i = 0; i < Run.unitsArray.size(); i++) {
				fw.append(Run.unitsArray.get(i).getTypeName());
				fw.append(";");
				fw.append(Run.unitsArray.get(i).getUnitName());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getM());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getK());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getS());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getKel());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getMol());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getAmp());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getCand());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getOffset());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getGradient());
				fw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("Can't write to file.");
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			System.out.println("Can't close the FileWriter.");
			e.printStackTrace();
		}
	}
	
	/**
	 * @param Inputfile
	 */
	public static void readCSV(String Inputfile) {
		//FIXME make method hanlde comma and point spearated double values
		//currently we handle only comma separated double values
		System.out.println("Reading: " + Inputfile);
		ArrayList<String> content = new ArrayList<String>();
		try {
			content = readFile(Inputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Starts at 1 so that the first row is ignored
		for (int i = 1; i < content.size(); i++) {
			try {
				//System.out.println("- Neue Zeile -"); 
				//typeName;unitName;m;k;s;kel;mol;amp;cand;offset;gradient
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
				NumberFormat format = NumberFormat.getInstance(Locale.GERMANY);
				Number number = format.parse(parts[9]);
				NumberFormat format1 = NumberFormat.getInstance(Locale.GERMANY);
				Number number1 = format1.parse(parts[10]);
				RawUnits tempRawUnits = new RawUnits(parts[0],parts[1], Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),Integer.parseInt(parts[7]),Integer.parseInt(parts[8]),number.doubleValue(),number1.doubleValue());

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
		System.out.println("Done reading: " + Inputfile);
		
	}
	
	/**
	 * @param Inputfile
	 */
	public static void readCSV(File Inputfile) {
		System.out.println("Reading: " + Inputfile.toString());
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
		System.out.println("Done reading: " + Inputfile.toString());
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
