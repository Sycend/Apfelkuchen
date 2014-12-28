package GUI.Two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author Dominik Hofmann, Mark Leibmann
 * @version 1.2.2
 */
public class CSV {
	
	/**
	 * This method writes the Run.unitsArray ArrayList into a File, which is
	 * converted from the String Inputfile, using the csv ; delimiter separated format
	 * 
	 * @param Inputfile A String which will be turned into a file and then written to
	 * @throws IOException
	 *             if it can't access the file
	 * @throws IOException
	 *             if it can't write to the file
	 * @throws IOException
	 *             if it can't close the FileWriter
	 */
	public static void writeCSV(String Inputfile) {
		//note: we overwrite the Inputfile
		BufferedWriter fw = null;
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(new File(Inputfile)), "UTF-8");
			fw = new BufferedWriter(writer);
		} catch (IOException e) {
			System.out.println("Can't access the file.");
			e.printStackTrace();
		}
		try {
			fw.append("dimension;unit;low;high;m;k;s;kel;mol;amp;cand;offset;gradient");
			fw.newLine();
			for (int i = 0; i < Run.unitsArray.size(); i++) {
				fw.append(Run.unitsArray.get(i).getDimension());
				fw.append(";");
				fw.append(Run.unitsArray.get(i).getUnit());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getLow());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getHigh());
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
			writer.close();
		} catch (IOException e) {
			System.out.println("Can't close the FileWriter.");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method writes the Run.unitsArray ArrayList into a File Inputfile
	 * using the csv ; delimiter separated format
	 * 
	 * @param Inputfile A File which will be written to
	 * @throws IOException
	 *             if it can't access the file
	 * @throws IOException
	 *             if it can't write to the file
	 * @throws IOException
	 *             if it can't close the FileWriter
	 */
	public static void writeCSV(File Inputfile) {
		//note: we overwrite the Inputfile
		BufferedWriter fw = null;
		Writer writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(Inputfile), "UTF-8");
			fw = new BufferedWriter(writer);
		} catch (IOException e) {
			System.out.println("Can't access the file.");
			e.printStackTrace();
		}
		try {
			fw.append("dimension;unit;low;high;m;k;s;kel;mol;amp;cand;offset;gradient");
			fw.newLine();
			for (int i = 0; i < Run.unitsArray.size(); i++) {
				fw.append(Run.unitsArray.get(i).getDimension());
				fw.append(";");
				fw.append(Run.unitsArray.get(i).getUnit());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getLow());
				fw.append(";");
				fw.append("" + Run.unitsArray.get(i).getHigh());
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
			writer.close();
		} catch (IOException e) {
			System.out.println("Can't close the FileWriter.");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method reads a String Inputfile line by line via the readFile method
	 * and proceeds to split every line at the ; delimiter and puts those
	 * values in a temp RawUnits Class which is then put in the Run.unitsArray
	 * ArrayList
	 * 
	 * @param Inputfile A String that will be turned into a File and read
	 */
	public static void readCSV(String Inputfile) {
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
				//dimension;unit;low;high;m;k;s;kel;mol;amp;cand;offset;gradient
				String[] parts = content.get(i).split(";");
				RawUnits tempRawUnits = new RawUnits(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Integer.parseInt(parts[10]), Double.parseDouble(parts[11]), Double.parseDouble(parts[12]));
				Run.unitsArray.add(tempRawUnits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done reading: " + Inputfile);
	}
	
	/**
	 * This method reads a File Inputfile line by line via the readFile method
	 * and proceeds to split every line at the ; delimiter and then puts those
	 * values in a temp RawUnits Class which is then put in the Run.unitsArray
	 * 
	 * @param Inputfile A File that will be read
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
				//dimension;unit;low;high;m;k;s;kel;mol;amp;cand;offset;gradient
				String[] parts = content.get(i).split(";");
				RawUnits tempRawUnits = new RawUnits(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Integer.parseInt(parts[10]), Double.parseDouble(parts[11]), Double.parseDouble(parts[12]));
				Run.unitsArray.add(tempRawUnits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done reading: " + Inputfile.toString());
	}
	
	/**
	 * This method takes a String as Inputfile and converts it into a File and reads it
	 * line by line and returns an Arraylist containing every line that has been read from the
	 * File located in Inputfile String
	 * 
	 * @param Inputfile A String that will be turned into a File and read line by line
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
	 * This method takes a File as Inputfile and reads it
	 * line by line and returns an Arraylist containing every line that has been read from the
	 * File located in Inputfile File
	 * 
	 * @param Inputfile A File that will be read line by line
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