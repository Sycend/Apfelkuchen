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
 * @author Dominik Hofmann, Yuri Kalinin
 * @version 1.0.5
 */
public class Util {
	protected int row = 0;
	protected final String CSV_FILENAME = "spezifikation.csv";
	protected final String USER_CSV_FILENAME = "user_spezifikation.csv";
	protected final String RELEVANTFACTORS_FILENAME = "RelevantFactors.tmp";
	protected final String DIMENSIONLESSFACTORS_FILENAME = "DimensionlessFactors.tmp";
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

	protected void restorePersistentRelevantFactors(WindowRelevantFactors WRF) {
		ArrayList<ArrayList<JTextField>> textFieldsContainer = new ArrayList<ArrayList<JTextField>>();
		ArrayList<JComboBox<String>> comboBoxRoleTmp = new ArrayList<JComboBox<String>>();
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(RELEVANTFACTORS_FILENAME));
			textFieldsContainer = (ArrayList<ArrayList<JTextField>>) input.readObject();
			comboBoxRoleTmp = (ArrayList<JComboBox<String>>) input.readObject();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (textFieldsContainer.size() > 0) {
			// textFieldsContainer.get(0).size() == Number of Rows
			for (int i = 0; i < textFieldsContainer.get(0).size(); i++) {
				row++;
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
	 * @param A
	 *            String[] Array that contains duplicates
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
		String message = dataLabels("errorTextDialog0");
		String title = dataLabels("errorTitleDialog0");
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).getText().matches("[a-zA-Z0-9]{1,12}") != true) {
				fields.get(i).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				fields.get(i).setBackground(bgColor);
				JOptionPane.showMessageDialog(new JFrame(), message + " " + dataLabels(label), title, JOptionPane.ERROR_MESSAGE);
				fields.get(i).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
				fields.get(i).setBackground(Color.WHITE);
				return false;
			}
		}
		return true;
	}

	protected boolean fieldsCheck(JTextField fields, String label) {

		String message = dataLabels("errorTextDialog0");
		String title = dataLabels("errorTitleDialog0");

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

		String message = dataLabels("errorTextDialog1");
		String title = dataLabels("errorTitleDialog0");
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

	protected String dataLabels(String nodeName) {
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

}// end Util Class