package GUI.Two;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Util Singleton
 * 
 * @author Dominik Hofmann, Yuri Kalinin, Mark Leibmann
 * @version 6.6.6
 */
public class Util {
	protected int row = 0;
	protected String CSV_FILENAME = "spezifikation.csv";
	protected String USER_CSV_FILENAME = "user_spezifikation.csv";
	protected String TESTCASE_CSV_FILENAME = "TestCase.csv";
	protected String RELEVANTFACTORS_FILENAME = "RelevantFactors.tmp";
	protected String DIMENSIONLESSFACTORS_FILENAME = "DimensionlessFactors.tmp";
	protected File CSV_FILE = new File(CSV_FILENAME);
	protected File USER_CSV_FILE = new File(USER_CSV_FILENAME);
	protected File TESTCASE_CSV_FILE = new File(TESTCASE_CSV_FILENAME);
	protected File RELEVANTFACTORS_FILE = new File(RELEVANTFACTORS_FILENAME);
	protected File DIMENSIONLESSFACTORS_FILE = new File(DIMENSIONLESSFACTORS_FILENAME);
	protected final int DEFAULT_WIDTH = 1200;
	protected final int DEFAULT_HEIGHT = 550;
	protected final int DEFAULT_FONT_SIZE = 16;
	// this needs testing on resolutions that are > 1366*x
	protected int currentWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * ((double) DEFAULT_WIDTH / (double) 1366));
	protected int currentHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * ((double) DEFAULT_HEIGHT / (double) 768));
	protected int currentFontSize = (int) ((double) DEFAULT_FONT_SIZE * Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double) 1366);
	protected int currentGridSizeHigh = (int) ((double) 80 * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double) 1366));
	protected int currentGridSizeLow = (int) ((double) 40 * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double) 1366));
	protected List<RawUnits> unitsArray = new ArrayList<RawUnits>();
	private String inputFieldSug;
	private static Util utilInstance = null;
	public Color bgColor = new Color(0xFFC1C1);

	private Util() {
	}

	public static Util getInstance() {
		if (utilInstance == null) {
			utilInstance = new Util();
		}
		return utilInstance;
	}

	/**
	 * This method is used to perform a persistent save, that means
	 * that this method takes ALL THE TEXTFIELDS from WindowRelevantFactors
	 * and puts them into a container Arraylist which is then written into
	 * a tmp file also the combobox as well
	 * 
	 */
	protected void persistentSaveRelevantFactors() {
		if (new File(RELEVANTFACTORS_FILENAME).exists()) {
			new File(RELEVANTFACTORS_FILENAME).delete();
		}
		ArrayList<ArrayList<JTextField>> textFieldsContainer = new ArrayList<ArrayList<JTextField>>();
		textFieldsContainer.add(WindowRelevantFactors.textFieldName);
		textFieldsContainer.add(WindowRelevantFactors.textFieldAbbreviation);
		textFieldsContainer.add(WindowRelevantFactors.textFieldDimension);
		textFieldsContainer.add(WindowRelevantFactors.textFieldUnit);
		textFieldsContainer.add(WindowRelevantFactors.textFieldLow);
		textFieldsContainer.add(WindowRelevantFactors.textFieldHigh);
		textFieldsContainer.add(WindowRelevantFactors.textFieldM);
		textFieldsContainer.add(WindowRelevantFactors.textFieldK);
		textFieldsContainer.add(WindowRelevantFactors.textFieldS);
		textFieldsContainer.add(WindowRelevantFactors.textFieldKel);
		textFieldsContainer.add(WindowRelevantFactors.textFieldMol);
		textFieldsContainer.add(WindowRelevantFactors.textFieldAmp);
		textFieldsContainer.add(WindowRelevantFactors.textFieldCand);
		textFieldsContainer.add(WindowRelevantFactors.textFieldResultSILow);
		textFieldsContainer.add(WindowRelevantFactors.textFieldResultSIHigh);
		try {
			FileOutputStream fileoutput = new FileOutputStream(RELEVANTFACTORS_FILENAME);
			ObjectOutputStream outputstream = new ObjectOutputStream(fileoutput);
			outputstream.writeObject(textFieldsContainer);
			outputstream.writeObject(WindowRelevantFactors.comboBoxRole);
			outputstream.flush();
			outputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method restores ALL THE TEXTFIELDS and also the combobox from WindowRelevantFactors.
	 * The Objects are first read into a Temp Object and then drawn to the WRF Object.
	 * @param WRF Object which is drawn to
	 */
	protected void restorePersistentRelevantFactors(WindowRelevantFactors WRF) {
		ArrayList<ArrayList<JTextField>> textFieldsContainer = new ArrayList<ArrayList<JTextField>>();
		ArrayList<JComboBox<String>> comboBoxRoleTmp = new ArrayList<JComboBox<String>>();
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(RELEVANTFACTORS_FILENAME));
			textFieldsContainer = (ArrayList<ArrayList<JTextField>>) input.readObject();
			comboBoxRoleTmp = (ArrayList<JComboBox<String>>) input.readObject();
			input.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Util.getInstance().RELEVANTFACTORS_FILENAME+" Konnte nicht gefunden werden.", "Warnung", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		if (textFieldsContainer.size() > 0) {
			// textFieldsContainer.get(0).size() == Number of Rows
			for (int i = 0; i < textFieldsContainer.get(0).size(); i++) {
				row++;
				WRF.newFactor();
				WindowRelevantFactors.textFieldName.get(row-1).setText(textFieldsContainer.get(0).get(i).getText()); //i
				WindowRelevantFactors.textFieldAbbreviation.get(row-1).setText(textFieldsContainer.get(1).get(i).getText());
				WindowRelevantFactors.comboBoxRole.get(row-1).setSelectedIndex(comboBoxRoleTmp.get(i).getSelectedIndex());
				WindowRelevantFactors.textFieldDimension.get(row-1).setText(textFieldsContainer.get(2).get(i).getText());
				WindowRelevantFactors.textFieldUnit.get(row-1).setText(textFieldsContainer.get(3).get(i).getText());
				WindowRelevantFactors.textFieldLow.get(row-1).setText(textFieldsContainer.get(4).get(i).getText());
				WindowRelevantFactors.textFieldHigh.get(row-1).setText(textFieldsContainer.get(5).get(i).getText());
				WindowRelevantFactors.textFieldM.get(row-1).setText(textFieldsContainer.get(6).get(i).getText());
				WindowRelevantFactors.textFieldK.get(row-1).setText(textFieldsContainer.get(7).get(i).getText());
				WindowRelevantFactors.textFieldS.get(row-1).setText(textFieldsContainer.get(8).get(i).getText());
				WindowRelevantFactors.textFieldKel.get(row-1).setText(textFieldsContainer.get(9).get(i).getText());
				WindowRelevantFactors.textFieldMol.get(row-1).setText(textFieldsContainer.get(10).get(i).getText());
				WindowRelevantFactors.textFieldAmp.get(row-1).setText(textFieldsContainer.get(11).get(i).getText());
				WindowRelevantFactors.textFieldCand.get(row-1).setText(textFieldsContainer.get(12).get(i).getText());
				WindowRelevantFactors.textFieldResultSILow.get(row-1).setText(textFieldsContainer.get(13).get(i).getText());
				WindowRelevantFactors.textFieldResultSIHigh.get(row-1).setText(textFieldsContainer.get(14).get(i).getText());
				WRF.contentPanel.revalidate();
				WRF.contentPanel.repaint();
			}
		}
	}
	
	/**
	 * This method performs a persistend save of Objects from WindowDimensionlessFactors
	 * that means that these Objects are written into a tmp file.
	 */
	protected void persistentSaveDimensionlessFactors() {
		if (new File(DIMENSIONLESSFACTORS_FILENAME).exists()) {
			new File(DIMENSIONLESSFACTORS_FILENAME).delete();
		}
		try {
			FileOutputStream fileoutput = new FileOutputStream(DIMENSIONLESSFACTORS_FILENAME);
			ObjectOutputStream outputstream = new ObjectOutputStream(fileoutput);
			outputstream.writeObject(WindowDimensionlessFactors.vMatrix);
			outputstream.writeObject(WindowDimensionlessFactors.rowNames);
			outputstream.writeObject(WindowDimensionlessFactors.colNames);
			outputstream.writeObject(WindowDimensionlessFactors.minV);
			outputstream.writeObject(WindowDimensionlessFactors.maxV);
			outputstream.writeObject(WindowDimensionlessFactors.dimensionlessControlSI);
			outputstream.flush();
			outputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method restores Objects from WindowDimensionlessFactors
	 * from a tmp file.
	 */
	protected void restorePersistentDimensionlessFactors() {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(DIMENSIONLESSFACTORS_FILENAME));
			WindowDimensionlessFactors.vMatrix = (double[][]) input.readObject();
			WindowDimensionlessFactors.rowNames = (String[]) input.readObject();
			WindowDimensionlessFactors.colNames = (String[]) input.readObject();
			WindowDimensionlessFactors.minV = (String[]) input.readObject();
			WindowDimensionlessFactors.maxV = (String[]) input.readObject();
			WindowDimensionlessFactors.dimensionlessControlSI = (String[][]) input.readObject();
			input.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Util.getInstance().DIMENSIONLESSFACTORS_FILENAME+" Konnte nicht gefunden werden.", "Warnung", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * @return A duplicate free String[] Array that contains all Dimensions
	 *         found in unitsArray
	 */
	protected String[] getDimensions() {
		String[] tmp = new String[unitsArray.size()];
		for (int i = 0; i < unitsArray.size(); i++) {
			tmp[i] = unitsArray.get(i).getDimension();
		}
		tmp = removeDuplicates(tmp);
		return tmp;
	}

	/**
	 * @param A String[] Array that contains duplicates
	 * @return A String[] Array that contains no more duplicates
	 */
	protected String[] removeDuplicates(String[] containsDuplicates) {
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

	protected boolean fieldsStringCheck(ArrayList<JTextField> fields, String label) {
		String message = getStringFromXML("errorTextDialog0");
		String title = getStringFromXML("errorTitleDialog0");
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).getText().matches("[a-zA-Z0-9]{1,12}") != true) {
				fields.get(i).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				fields.get(i).setBackground(bgColor);
				JOptionPane.showMessageDialog(new JFrame(), message + " " + getStringFromXML(label), title, JOptionPane.ERROR_MESSAGE);
				fields.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
				fields.get(i).setBackground(Color.WHITE);
				return false;
			}
		}
		return true;
	}

	protected boolean fieldsCheck(JTextField fields, String label) {

		String message = getStringFromXML("errorTextDialog0");
		String title = getStringFromXML("errorTitleDialog0");

		if (fields.getText().matches("([-]{1})?\\d+([.]{1})?(\\d+)?") == false) {
			fields.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			fields.setBackground(bgColor);
			// JOptionPane.showMessageDialog(new JFrame(), message + " " +
			// dataLabels(label), title, JOptionPane.ERROR_MESSAGE);

			return false;
		} else {
			fields.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			fields.setBackground(Color.WHITE);
			return true;
		}

	}

	protected boolean fieldsArrayCheck(ArrayList<JTextField> fields) {
		String re1 = "([-]?\\d+)"; // Integer Number 1
		String re2 = "([\\.]?)"; // Any Single Character 1
		String re3 = "([\\d]?)"; // Integer Number 1 }

		String reg4 = "((?:[a-z][a-z]*))"; // Word 1
		for (int i = 0; i < fields.size(); i++) {
			// if (fields.get(i).getText().equals("-")) {
			// return false;
			// }
			Pattern p2 = Pattern.compile(reg4, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher m2 = p2.matcher(fields.get(i).getText());

			Pattern p = Pattern.compile(re1 + re2 + re3, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher m = p.matcher(fields.get(i).getText());
			// if (m.find()) {
			// if (m2.find() == false) {
			if (fields.get(i).getText().matches("([-]{1})?\\d+([.]{1})?(\\d+)?") == true) {
				return true;

			}
		}
		// }

		return false;

	}

	protected boolean SIMinMaxValuesCheck(ArrayList<JTextField> siMaxFields, ArrayList<JTextField> siMinFields) {

		String message = getStringFromXML("errorTextDialog1");
		String title = getStringFromXML("errorTitleDialog0");
		for (int i = 0; i < siMaxFields.size(); i++) {

			if (!WindowRelevantFactors.comboBoxRole.get(i).getSelectedItem().equals("constant")) {
				if (Double.parseDouble(siMaxFields.get(i).getText()) == Double.parseDouble(siMinFields.get(i).getText())) {

					siMaxFields.get(i).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					siMaxFields.get(i).setBackground(bgColor);
					siMinFields.get(i).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					siMinFields.get(i).setBackground(bgColor);
					JOptionPane.showMessageDialog(new JFrame(), message, title, JOptionPane.ERROR_MESSAGE);

					return false;
				} else {

					siMaxFields.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
					siMaxFields.get(i).setBackground(Color.WHITE);
					siMinFields.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
					siMinFields.get(i).setBackground(Color.WHITE);
				}

				if (!WindowRelevantFactors.comboBoxRole.get(i).getSelectedItem().equals("constant")) {
					if (Double.parseDouble(siMaxFields.get(i).getText()) < 0) {
						siMaxFields.get(i).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
						siMaxFields.get(i).setBackground(bgColor);
						JOptionPane.showMessageDialog(new JFrame(), message, title, JOptionPane.ERROR_MESSAGE);

						return false;
					} else {
						siMaxFields.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
					}
				}
				if (Double.parseDouble(siMinFields.get(i).getText()) < 0) {
					siMinFields.get(i).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					siMinFields.get(i).setBackground(bgColor);
					JOptionPane.showMessageDialog(new JFrame(), message, title, JOptionPane.ERROR_MESSAGE);
					return false;
				} else {
					siMinFields.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
					siMinFields.get(i).setBackground(Color.WHITE);
				}

				if (Double.parseDouble(siMaxFields.get(i).getText()) < Double.parseDouble(siMinFields.get(i).getText())) {
					siMaxFields.get(i).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
					siMaxFields.get(i).setBackground(bgColor);
					JOptionPane.showMessageDialog(new JFrame(), message, title, JOptionPane.ERROR_MESSAGE);
					return false;
				} else {

					siMaxFields.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
					siMaxFields.get(i).setBackground(Color.WHITE);
				}

			}

		}
		return true;
	}

	protected String getStringFromXML(String nodeName) {
		final String fileName = "labels.xml";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(fileName);
			NodeList tableNameNodeList = document.getElementsByTagName(nodeName);
			nodeName = tableNameNodeList.item(0).getChildNodes().item(0).getTextContent();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nodeName;
	}

	public String getSuggestionInput() {
		return inputFieldSug;
	}
	
	/**
	 * This method writes a RawUnits Object into a File, which is
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
	protected void writeCSV(String filename, RawUnits tempRaw) {
		BufferedWriter fw = null;
		try {
			fw = new BufferedWriter(new FileWriter(new File(filename), true));
		} catch (IOException e) {
			System.out.println("Can't access the file.");
			e.printStackTrace();
		}
		try {
			fw.append(tempRaw.getDimension());
			fw.append(";");
			fw.append(tempRaw.getUnit());
			fw.append(";");
			fw.append("" + tempRaw.getM());
			fw.append(";");
			fw.append("" + tempRaw.getK());
			fw.append(";");
			fw.append("" + tempRaw.getS());
			fw.append(";");
			fw.append("" + tempRaw.getKel());
			fw.append(";");
			fw.append("" + tempRaw.getMol());
			fw.append(";");
			fw.append("" + tempRaw.getAmp());
			fw.append(";");
			fw.append("" + tempRaw.getCand());
			fw.append(";");
			fw.append("" + String.valueOf(tempRaw.getOffset()).replace(".", ","));
			fw.append(";");
			fw.append("" + String.valueOf(tempRaw.getGradient()).replace(".", ","));
			fw.newLine();
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
	 * This method writes the unitsArray ArrayList into a File, which is
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
	protected void writeCSV(String Inputfile) {
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
			fw.append("dimension;unit;m;k;s;kel;mol;amp;cand;offset;gradient");
			fw.newLine();
			for (int i = 0; i < unitsArray.size(); i++) {
				fw.append(unitsArray.get(i).getDimension());
				fw.append(";");
				fw.append(unitsArray.get(i).getUnit());
				fw.append(";");
				fw.append("" + unitsArray.get(i).getM());
				fw.append(";");
				fw.append("" + unitsArray.get(i).getK());
				fw.append(";");
				fw.append("" + unitsArray.get(i).getS());
				fw.append(";");
				fw.append("" + unitsArray.get(i).getKel());
				fw.append(";");
				fw.append("" + unitsArray.get(i).getMol());
				fw.append(";");
				fw.append("" + unitsArray.get(i).getAmp());
				fw.append(";");
				fw.append("" + unitsArray.get(i).getCand());
				fw.append(";");
				fw.append("" + String.valueOf(unitsArray.get(i).getOffset()).replace(".", ","));
				fw.append(";");
				fw.append("" + String.valueOf(unitsArray.get(i).getGradient()).replace(".", ","));
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
	 * values in a temp RawUnits Object which is then put in the unitsArray
	 * ArrayList. This method adds a * to the Units, since it is assumed that
	 * the Units are from a user csv file and user are retards.
	 * 
	 * @param Inputfile A String that will be turned into a File and read
	 */
	protected void readUserCSV(String Inputfile) {
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
				//dimension;unit;m;k;s;kel;mol;amp;cand;offset;gradient
				String test = content.get(i);
				int count = test.length() - test.replace(";", "").length();
				String[] parts = content.get(i).split(";");
				if ((count+1) != 11){
					System.out.println("Error in line: "+(i+1));
					System.out.println("count: "+(count+1));
					System.out.println("----");
				}
				
				RawUnits tempRawUnits = new RawUnits(parts[0], parts[1]+"*", Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Double.parseDouble(parts[9].replace(",", ".")), Double.parseDouble(parts[10].replace(",", ".")));
				unitsArray.add(tempRawUnits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done reading: " + Inputfile);
	}
	
	/**
	 * This method reads a String Inputfile line by line via the readFile method
	 * and proceeds to split every line at the ; delimiter and puts those
	 * values in a temp RawUnits Object which is then put in the unitsArray
	 * ArrayList
	 * 
	 * @param Inputfile A String that will be turned into a File and read
	 */
	protected void readCSV(String Inputfile) {
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
				unitsArray.add(tempRawUnits);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done reading: " + Inputfile);
	}
	
	/**
	 * This method reads a String Inputfile line by line via the readFile method
	 * and proceeds to split every line at the ; delimiter, it then creates
	 * number of rows of the (Inputfile -1) and draws them on the WRF Object
	 * that is given to the Method. It proceeds to fill those drawn rows 
	 * with values given from the Inputfile.
	 * 
	 * @param Inputfile A String that will be turned into a File and read
	 * @param WRF The WindowRelevantFactors Object that will be drawn on
	 */
	protected void readTestCaseCSV(String Inputfile, WindowRelevantFactors WRF) {
		System.out.println("Reading: " + Inputfile);
		ArrayList<String> content = new ArrayList<String>();
		try {
			content = readFile(Inputfile);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Inputfile+" Konnte nicht gefunden werden.", "Warnung", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		
		//Starts at 1 so that the first row is ignored
		for (int i = 1; i < content.size(); i++) {
			try {
				//name;abbr;role;dimension;unit;low;high;m;k;s;kel;mol;amp;cand;SI-Low;SI-High
				String test = content.get(i);
				int count = test.length() - test.replace(";", "").length();
				String[] parts = content.get(i).split(";");
				
				if ((count + 1) != 16) {
					System.out.println("Error in line: " + (i + 1));
					System.out.println("count: " + (count + 1));
					System.out.println("----");
				}
				
				row++;
				WRF.newFactor();
				WindowRelevantFactors.textFieldName.get(row-1).setText(parts[0]);
				WindowRelevantFactors.textFieldAbbreviation.get(row-1).setText(parts[1]);
				
				if (parts[2].equals("controlled")) {
					WindowRelevantFactors.comboBoxRole.get(row-1).setSelectedIndex(0);
				}
				if (parts[2].equals("constant")) {
					WindowRelevantFactors.comboBoxRole.get(row-1).setSelectedIndex(1);
				}			
				if (parts[2].equals("scale-up")) {
					WindowRelevantFactors.comboBoxRole.get(row-1).setSelectedIndex(2);
				}
				if (parts[2].equals("dependent")) {
					WindowRelevantFactors.comboBoxRole.get(row-1).setSelectedIndex(3);
				}
				
				WindowRelevantFactors.textFieldDimension.get(row-1).setText(parts[3]);
				WindowRelevantFactors.textFieldUnit.get(row-1).setText(parts[4]);
				WindowRelevantFactors.textFieldLow.get(row-1).setText(parts[5]);
				WindowRelevantFactors.textFieldHigh.get(row-1).setText(parts[6]);
				WindowRelevantFactors.textFieldM.get(row-1).setText(parts[7]);
				WindowRelevantFactors.textFieldK.get(row-1).setText(parts[8]);
				WindowRelevantFactors.textFieldS.get(row-1).setText(parts[9]);
				WindowRelevantFactors.textFieldKel.get(row-1).setText(parts[10]);
				WindowRelevantFactors.textFieldMol.get(row-1).setText(parts[11]);
				WindowRelevantFactors.textFieldAmp.get(row-1).setText(parts[12]);
				WindowRelevantFactors.textFieldCand.get(row-1).setText(parts[13]);
				WindowRelevantFactors.textFieldResultSILow.get(row-1).setText(parts[14]);
				WindowRelevantFactors.textFieldResultSIHigh.get(row-1).setText(parts[15]);
				
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
	private ArrayList<String> readFile(String Inputfile) throws Exception {
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
			JOptionPane.showMessageDialog(null, file.getAbsoluteFile()+" Konnte nicht gefunden werden.", "Warnung", JOptionPane.WARNING_MESSAGE);
			System.out.println("Could not find: " + file.getAbsolutePath());
		}
		return tmp;
	}
	
}// end Util Class