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
 * @version 1.2.4
 */
public class CSV {
	
	/**
	 * This method writes the Util.getInstance().unitsArray ArrayList into a File, which is
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
			fw.append("dimension,unit,low,high,m,k,s,kel,mol,amp,cand,offset,gradient");
			fw.newLine();
			for (int i = 0; i < Util.getInstance().unitsArray.size(); i++) {
				fw.append(Util.getInstance().unitsArray.get(i).getDimension());
				fw.append(";");
				fw.append(Util.getInstance().unitsArray.get(i).getUnit());
				fw.append(";");
				fw.append("" + Util.getInstance().unitsArray.get(i).getM());
				fw.append(";");
				fw.append("" + Util.getInstance().unitsArray.get(i).getK());
				fw.append(";");
				fw.append("" + Util.getInstance().unitsArray.get(i).getS());
				fw.append(";");
				fw.append("" + Util.getInstance().unitsArray.get(i).getKel());
				fw.append(";");
				fw.append("" + Util.getInstance().unitsArray.get(i).getMol());
				fw.append(";");
				fw.append("" + Util.getInstance().unitsArray.get(i).getAmp());
				fw.append(";");
				fw.append("" + Util.getInstance().unitsArray.get(i).getCand());
				fw.append(";");
				fw.append("" + String.valueOf(Util.getInstance().unitsArray.get(i).getOffset()).replace(".", ","));
				fw.append(";");
				fw.append("" + String.valueOf(Util.getInstance().unitsArray.get(i).getGradient()).replace(".", ","));
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
	 * values in a temp RawUnits Class which is then put in the Util.getInstance().unitsArray
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
				//FIXME make read in more robust
				//dimension;unit;m;k;s;kel;mol;amp;cand;offset;gradient
				String test = content.get(i);
				int count = test.length() - test.replace(";", "").length();
				String[] parts = content.get(i).split(";");
				if ((count+1) != 11){
					System.out.println("Error in line: "+(i+1));
					System.out.println("count: "+(count+1));
					System.out.println("----");
				}
				
				RawUnits tempRawUnits = new RawUnits(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Double.parseDouble(parts[9].replace(",", ".")), Double.parseDouble(parts[10].replace(",", ".")));
				Util.getInstance().unitsArray.add(tempRawUnits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done reading: " + Inputfile);
	}
	public static void readCSVTest(String Inputfile,WindowRelevantFactors WRF) {
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
				//FIXME make read in more robust
				// dimension;unit;m;k;s;kel;mol;amp;cand;offset;gradient
				String test = content.get(i);
				int count = test.length() - test.replace(";", "").length();
				String[] parts = content.get(i).split(";");
				if ((count + 1) != 11) {
					System.out.println("Error in line: " + (i + 1));
					System.out.println("count: " + (count + 1));
					System.out.println("----");
				}

				Util.getInstance().row++;
				WRF.newFactor();
				WindowRelevantFactors.textFieldName.get(Util.getInstance().row-1).setText(parts[0]);
				WindowRelevantFactors.textFieldAbbreviation.get(Util.getInstance().row-1).setText(parts[1]);
				
				if (parts[2].equals("controlled")) {
					WindowRelevantFactors.comboBoxRole.get(Util.getInstance().row-1).setSelectedIndex(0);
				}
				if (parts[2].equals("constant")) {
					WindowRelevantFactors.comboBoxRole.get(Util.getInstance().row-1).setSelectedIndex(1);
				}			
				if (parts[2].equals("scale-up")) {
					WindowRelevantFactors.comboBoxRole.get(Util.getInstance().row-1).setSelectedIndex(2);
				}
				if (parts[2].equals("dependent")) {
					WindowRelevantFactors.comboBoxRole.get(Util.getInstance().row-1).setSelectedIndex(3);
				}
				WindowRelevantFactors.textFieldDimension.get(Util.getInstance().row-1).setText(parts[3]);
				WindowRelevantFactors.textFieldUnit.get(Util.getInstance().row-1).setText(parts[4]);
				WindowRelevantFactors.textFieldLow.get(Util.getInstance().row-1).setText(parts[5]);
				WindowRelevantFactors.textFieldHigh.get(Util.getInstance().row-1).setText(parts[6]);
				WindowRelevantFactors.textFieldM.get(Util.getInstance().row-1).setText(parts[7]);
				WindowRelevantFactors.textFieldK.get(Util.getInstance().row-1).setText(parts[8]);
				WindowRelevantFactors.textFieldS.get(Util.getInstance().row-1).setText(parts[9]);
				WindowRelevantFactors.textFieldKel.get(Util.getInstance().row-1).setText(parts[10]);
				WindowRelevantFactors.textFieldMol.get(Util.getInstance().row-1).setText(parts[11]);
				WindowRelevantFactors.textFieldAmp.get(Util.getInstance().row-1).setText(parts[12]);
				WindowRelevantFactors.textFieldCand.get(Util.getInstance().row-1).setText(parts[13]);
				WindowRelevantFactors.textFieldResultSILow.get(Util.getInstance().row-1).setText(parts[14]);
				WindowRelevantFactors.textFieldResultSIHigh.get(Util.getInstance().row-1).setText(parts[15]);

				WRF.contentPanel.revalidate();
				WRF.contentPanel.repaint();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Done reading: " + Inputfile);
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
}