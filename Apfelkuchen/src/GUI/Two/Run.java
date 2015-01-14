package GUI.Two;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * Main used to Start Window1 + ReadCSV
 * @author Yuri Kalinin, Dominik Hofmann
 * @version 2.1.2
 */
public class Run {
	protected static int rows = 0;
	protected static String csvName = "spezifikation.csv";
	protected static String saveFileNameRelevantFactors = "RelevantFactors.tmp";
	protected static String saveFileNameDimensionlessFactors = "DimensionlessFactors.tmp";
	protected static final int DEFAULT_WIDTH = 1200; //1100
	protected static final int DEFAULT_HEIGHT = 550; //500
	protected static final int DEFAULT_FONT_SIZE = 16;
	//this needs testing on resolutions that are > 1366*x
	protected static int currentWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() * ((double)DEFAULT_WIDTH / (double)1366));
	protected static int currentHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() * ((double)DEFAULT_HEIGHT / (double)768));
	protected static int currentFontSize = (int)((double)DEFAULT_FONT_SIZE * Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double)1366);
	protected static int currentGridSizeHigh = (int)((double)80 * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double)1366));
	protected static int currentGridSizeLow = (int)((double)40 * (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / (double)1366));
	protected static WindowRelevantFactors WRF;
	protected static WindowDimensionlessFactors WDF;
	public static List<RawUnits> unitsArray = new ArrayList<RawUnits>();
	
	public static void main(String args[]) {
		if (!new File(saveFileNameRelevantFactors).exists()){
			System.out.println("new WindowRelevantFactors()");
			WRF = new WindowRelevantFactors();
		} else {
			System.out.println("restoreRelevantFactors()");
			WRF = new WindowRelevantFactors();
			restorePersistentRelevantFactors(WRF);
		}
		
		new Thread(() -> CSV.readCSV(csvName)).start();
	}
	
	protected static void persistentSaveRelevantFactors(){
		if (new File(saveFileNameRelevantFactors).exists()){
			new File(saveFileNameRelevantFactors).delete();
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
			FileOutputStream fileoutput = new FileOutputStream(saveFileNameRelevantFactors);
			ObjectOutputStream outputstream = new ObjectOutputStream(fileoutput);
			outputstream.writeObject(textFieldsContainer);
			outputstream.writeObject(WindowRelevantFactors.comboBoxRole);
			outputstream.flush();
			outputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void restorePersistentRelevantFactors(WindowRelevantFactors WRF){
		ArrayList<ArrayList<JTextField>> textFieldsContainer = new ArrayList<ArrayList<JTextField>>();
		ArrayList<JComboBox<String>> comboBoxRoleTmp = new ArrayList<JComboBox<String>>();
		try{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(saveFileNameRelevantFactors));
			textFieldsContainer = (ArrayList<ArrayList<JTextField>>) input.readObject();
			comboBoxRoleTmp = (ArrayList<JComboBox<String>>) input.readObject();
			input.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		if (textFieldsContainer.size() > 0){
			//textFieldsContainer.get(0).size() == Number of Rows
			for (int i = 0; i < textFieldsContainer.get(0).size(); i++){
				Run.rows++;
				WRF.newFactor();
				WindowRelevantFactors.textFieldName.get(i).setText(textFieldsContainer.get(0).get(i).getText());
				WindowRelevantFactors.textFieldAbbreviation.get(i).setText(textFieldsContainer.get(1).get(i).getText());
				WindowRelevantFactors.comboBoxRole.get(i).setSelectedIndex(comboBoxRoleTmp.get(i).getSelectedIndex());
				WindowRelevantFactors.textFieldDimension.get(i).setText(textFieldsContainer.get(2).get(i).getText());
				WindowRelevantFactors.textFieldUnit.get(i).setText(textFieldsContainer.get(3).get(i).getText());
				WindowRelevantFactors.textFieldLow.get(i).setText(textFieldsContainer.get(4).get(i).getText());
				WindowRelevantFactors.textFieldHigh.get(i).setText(textFieldsContainer.get(5).get(i).getText());
				WindowRelevantFactors.textFieldM.get(i).setText(textFieldsContainer.get(6).get(i).getText());
				WindowRelevantFactors.textFieldK.get(i).setText(textFieldsContainer.get(7).get(i).getText());
				WindowRelevantFactors.textFieldS.get(i).setText(textFieldsContainer.get(8).get(i).getText());
				WindowRelevantFactors.textFieldKel.get(i).setText(textFieldsContainer.get(9).get(i).getText());
				WindowRelevantFactors.textFieldMol.get(i).setText(textFieldsContainer.get(10).get(i).getText());
				WindowRelevantFactors.textFieldAmp.get(i).setText(textFieldsContainer.get(11).get(i).getText());
				WindowRelevantFactors.textFieldCand.get(i).setText(textFieldsContainer.get(12).get(i).getText());
				WindowRelevantFactors.textFieldResultSILow.get(i).setText(textFieldsContainer.get(13).get(i).getText());
				WindowRelevantFactors.textFieldResultSIHigh.get(i).setText(textFieldsContainer.get(14).get(i).getText());
				WRF.contentPanel.revalidate();
				WRF.contentPanel.repaint();
			}
		}
	}
	
	protected static void persistentSaveDimensionlessFactors() {
		if (new File(saveFileNameDimensionlessFactors).exists()) {
			new File(saveFileNameDimensionlessFactors).delete();
		}
		try {
			FileOutputStream fileoutput = new FileOutputStream(saveFileNameDimensionlessFactors);
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
	
	protected static void restorePersistentDimensionlessFactors() {
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(saveFileNameDimensionlessFactors));
			WindowDimensionlessFactors.vMatrix = (double[][]) input.readObject();
			WindowDimensionlessFactors.rowNames = (String[]) input.readObject();
			WindowDimensionlessFactors.colNames = (String[]) input.readObject();
			WindowDimensionlessFactors.minV = (String[]) input.readObject();
			WindowDimensionlessFactors.maxV = (String[]) input.readObject();
			WindowDimensionlessFactors.dimensionlessControlSI = (String[][]) input.readObject();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
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
	
	protected static boolean abbreviationStringCheck() {
		String message = Run.dataLabels("errorTextDialog0");
		String title = Run.dataLabels("errorTitleDialog0");
		for (int i = 0; i < WindowRelevantFactors.textFieldAbbreviation.size(); i++) {
			if (WindowRelevantFactors.textFieldAbbreviation.get(i).getText().matches("[a-zA-Z0-9]{1,8}") != true) {
				WindowRelevantFactors.textFieldAbbreviation.get(i).setBackground(Color.RED);
				JOptionPane.showMessageDialog(new JFrame(), message + " " + Run.dataLabels("labelAbbr"), title, JOptionPane.ERROR_MESSAGE);
				WindowRelevantFactors.textFieldAbbreviation.get(i).setBackground(Color.WHITE);
				return false;
			}
		}
		return true;
	}
	
	public static String dataLabels(String nodeName) {
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
	
}