package GUI.Two;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import J2R.*;

/**
 * Window1
 * 
 * @author Yuri Kalinin, Florian Then, Dominik Hofmann, Christoph Wütschner,
 *         Clemens Kretzer
 * @version 1.2.7
 */
public class WindowRelevantFactors extends JFrame {
	// serialVersionUID is generated
	private static final long serialVersionUID = 1970058653625662918L;
	private JScrollPane scrollpane;
	private JButton buttonRemoveFactor;
	private JButton buttonNext;
	private JButton buttonNewFactor;
	private JButton buttonNewCommandVariable;
	private JButton buttonRemoveCommandVariable;
	private JLabel labelName;
	private JLabel labelAbbreviation;
	private JLabel labelRole;
	private JLabel labelDimension;
	private JLabel labelUnit;
	private JLabel labelLow;
	private JLabel labelHigh;
	private JLabel labelM;
	private JLabel labelK;
	private JLabel labelS;
	private JLabel labelKel;
	private JLabel labelMol;
	private JLabel labelAmp;
	private JLabel labelCand;
	private JLabel labelResultSIMin;
	private JLabel labelResultSIMax;

	protected static ArrayList<JTextField> textFieldName = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldAbbreviation = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldDimension = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldUnit = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldLow = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldHigh = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldM = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldK = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldS = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldKel = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldMol = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldAmp = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldCand = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldResultSILow = new ArrayList<JTextField>();
	protected static ArrayList<JTextField> textFieldResultSIHigh = new ArrayList<JTextField>();
	protected static ArrayList<JComboBox<String>> comboBoxRole = new ArrayList<JComboBox<String>>();
	protected static ArrayList<JButton> buttonUpdateCSV = new ArrayList<JButton>();

	protected JPanel contentPanel = new JPanel();
	protected boolean checkFields = false;
	protected static int countErrors = 0;

	public WindowRelevantFactors() {
		super(Util.getInstance().dataLabels("title"));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(Util.getInstance().currentWidth, Util.getInstance().currentHeight);
		
		init();
		setVisible(true);
	}

	public void init() {
		// ======== contentPanel ========
		contentPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.setLayout(new GridBagLayout());
		((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] { Util.getInstance().currentGridSizeHigh, Util.getInstance().currentGridSizeHigh, Util.getInstance().currentGridSizeHigh, Util.getInstance().currentGridSizeHigh, Util.getInstance().currentGridSizeHigh,
				Util.getInstance().currentGridSizeLow + 10, Util.getInstance().currentGridSizeLow + 6, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow,
				Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

		JPanel p2 = new JPanel();

		// ---- label Name ----
		labelName = new JLabel();
		labelName.setText(Util.getInstance().dataLabels("labelName"));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelName, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

		// ---- label Abbreviation ----
		labelAbbreviation = new JLabel();
		labelAbbreviation.setText(Util.getInstance().dataLabels("labelAbbr"));
		labelAbbreviation.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelAbbreviation.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelAbbreviation, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Role ----
		labelRole = new JLabel();
		labelRole.setText(Util.getInstance().dataLabels("labelRole"));
		labelRole.setHorizontalAlignment(SwingConstants.CENTER);
		labelRole.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		contentPanel.add(labelRole, new GridBagConstraints(2, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Dimension ----
		labelDimension = new JLabel();
		labelDimension.setText(Util.getInstance().dataLabels("labelDimension"));
		labelDimension.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelDimension.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelDimension, new GridBagConstraints(3, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label Unit ----
		labelUnit = new JLabel();
		labelUnit.setText(Util.getInstance().dataLabels("labelUnit"));
		labelUnit.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelUnit.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelUnit, new GridBagConstraints(4, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label Low ----
		labelLow = new JLabel();
		labelLow.setText(Util.getInstance().dataLabels("labelLow"));
		labelLow.setHorizontalAlignment(SwingConstants.CENTER);
		labelLow.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		contentPanel.add(labelLow, new GridBagConstraints(5, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		// ---- label High ----
		labelHigh = new JLabel();
		labelHigh.setText(Util.getInstance().dataLabels("labelHigh"));
		labelHigh.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelHigh.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelHigh, new GridBagConstraints(6, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		// ---- label m ----
		labelM = new JLabel();
		labelM.setText("m");
		labelM.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelM.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelM, new GridBagConstraints(7, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label k ----
		labelK = new JLabel();
		labelK.setText("k");
		labelK.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelK.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelK, new GridBagConstraints(8, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label s ----
		labelS = new JLabel();
		labelS.setText("s");
		labelS.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelS.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelS, new GridBagConstraints(9, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label kel ----
		labelKel = new JLabel();
		labelKel.setText("kel");
		labelKel.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelKel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelKel, new GridBagConstraints(10, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label mol ----
		labelMol = new JLabel();
		labelMol.setText("mol");
		labelMol.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelMol.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelMol, new GridBagConstraints(11, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label amp ----
		labelAmp = new JLabel();
		labelAmp.setText("amp");
		labelAmp.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelAmp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelAmp, new GridBagConstraints(12, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// ---- label cand ----
		labelCand = new JLabel();
		labelCand.setText("cand");
		labelCand.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		labelCand.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelCand, new GridBagConstraints(13, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		// ---- label SI Min ----
		labelResultSIMin = new JLabel();
		labelResultSIMin.setText(Util.getInstance().dataLabels("labelSIMin"));
		labelResultSIMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultSIMin.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		contentPanel.add(labelResultSIMin, new GridBagConstraints(14, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

		// ---- label SI Max ----
		labelResultSIMax = new JLabel();
		labelResultSIMax.setText(Util.getInstance().dataLabels("labelSIMax"));
		labelResultSIMax.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultSIMax.setFont(new Font("Tahoma", Font.PLAIN, Util.getInstance().currentFontSize));
		contentPanel.add(labelResultSIMax, new GridBagConstraints(15, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiLoadTMPFile = new JMenuItem("Load from tmp file");
		JMenuItem jmiLoadTestCaseCSV = new JMenuItem("Load TestCase.csv");
		JMenuItem jmiSave = new JMenuItem("Save to tmp file");
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmFile.add(jmiLoadTMPFile);
		jmFile.add(jmiLoadTestCaseCSV);
		jmFile.add(jmiSave);
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		jmiLoadTMPFile.addActionListener(ae -> {
			//FIXME fix multiple blank rows bug
			System.out.println("Load from tmp file");
			Util.getInstance().restorePersistentRelevantFactors(Menu.WRF);
		});
		jmiLoadTestCaseCSV.addActionListener(ae -> {
			System.out.println("Load TestCase.csv");
			Util.getInstance().readTestCaseCSV(Util.getInstance().TESTCASE_CSV_FILENAME, Menu.WRF);
		});
		jmiSave.addActionListener(ae -> {
			System.out.println("Save to tmp file");
			Util.getInstance().persistentSaveRelevantFactors();
		});
		jmiExit.addActionListener(ae -> {
			System.out.println("Exit");
			System.exit(0);
		});
		JMenu jmHelp = new JMenu("Help");
		JMenuItem jmiAbout = new JMenuItem("About");
		jmHelp.add(jmiAbout);
		jmb.add(jmHelp);
		setJMenuBar(jmb);
		
		buttonNewFactor = new JButton(Util.getInstance().dataLabels("buttonNewFactor"));
		buttonNewFactor.setFocusPainted(false);
		buttonNewFactor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNewFactor) {
					Util.getInstance().row++;
					newFactor();
					contentPanel.revalidate();
					contentPanel.repaint();
				}
			}
		});
		p2.add(buttonNewFactor);

		buttonRemoveFactor = new JButton(Util.getInstance().dataLabels("buttonRemoveFactor"));
		buttonRemoveFactor.setFocusPainted(false);
		buttonRemoveFactor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonRemoveFactor) {
					if (textFieldName.size() > 0) {
						contentPanel.remove(textFieldName.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldAbbreviation.get(Util.getInstance().row - 1));
						contentPanel.remove(comboBoxRole.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldDimension.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldUnit.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldLow.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldHigh.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldM.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldK.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldS.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldKel.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldMol.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldAmp.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldCand.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldResultSILow.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldResultSIHigh.get(Util.getInstance().row - 1));
						contentPanel.remove(buttonUpdateCSV.get(Util.getInstance().row - 1));
						textFieldName.remove(Util.getInstance().row - 1);
						textFieldAbbreviation.remove(Util.getInstance().row - 1);
						comboBoxRole.remove(Util.getInstance().row - 1);
						textFieldDimension.remove(Util.getInstance().row - 1);
						textFieldUnit.remove(Util.getInstance().row - 1);
						textFieldLow.remove(Util.getInstance().row - 1);
						textFieldHigh.remove(Util.getInstance().row - 1);
						textFieldM.remove(Util.getInstance().row - 1);
						textFieldK.remove(Util.getInstance().row - 1);
						textFieldS.remove(Util.getInstance().row - 1);
						textFieldKel.remove(Util.getInstance().row - 1);
						textFieldMol.remove(Util.getInstance().row - 1);
						textFieldAmp.remove(Util.getInstance().row - 1);
						textFieldCand.remove(Util.getInstance().row - 1);
						textFieldResultSILow.remove(Util.getInstance().row - 1);
						textFieldResultSIHigh.remove(Util.getInstance().row - 1);
						buttonUpdateCSV.remove(Util.getInstance().row - 1);
						Util.getInstance().row--;
						contentPanel.revalidate();
						contentPanel.repaint();
					}
				}
			}
		});
		p2.add(buttonRemoveFactor);

		buttonNewCommandVariable = new JButton(Util.getInstance().dataLabels("buttonNewCommandVariable"));
		buttonNewCommandVariable.setFocusPainted(false);
		buttonNewCommandVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNewCommandVariable) {
					// FIXME not yet working currently mirrors buttonNewFactor
					Util.getInstance().row++;
					newFactor();
					contentPanel.revalidate();
					contentPanel.repaint();
				}
			}
		});
		p2.add(buttonNewCommandVariable);

		buttonRemoveCommandVariable = new JButton(Util.getInstance().dataLabels("buttonRemoveCommandVariable"));
		buttonRemoveCommandVariable.setFocusPainted(false);
		buttonRemoveCommandVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonRemoveCommandVariable) {
					// FIXME not yet working currently mirrors
					// buttonRemoveFactor
					if (textFieldName.size() > 0) {
						contentPanel.remove(textFieldName.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldAbbreviation.get(Util.getInstance().row - 1));
						contentPanel.remove(comboBoxRole.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldDimension.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldUnit.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldLow.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldHigh.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldM.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldK.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldS.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldKel.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldMol.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldAmp.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldCand.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldResultSILow.get(Util.getInstance().row - 1));
						contentPanel.remove(textFieldResultSIHigh.get(Util.getInstance().row - 1));
						contentPanel.remove(buttonUpdateCSV.get(Util.getInstance().row - 1));
						textFieldName.remove(Util.getInstance().row - 1);
						textFieldAbbreviation.remove(Util.getInstance().row - 1);
						comboBoxRole.remove(Util.getInstance().row - 1);
						textFieldDimension.remove(Util.getInstance().row - 1);
						textFieldUnit.remove(Util.getInstance().row - 1);
						textFieldLow.remove(Util.getInstance().row - 1);
						textFieldHigh.remove(Util.getInstance().row - 1);
						textFieldM.remove(Util.getInstance().row - 1);
						textFieldK.remove(Util.getInstance().row - 1);
						textFieldS.remove(Util.getInstance().row - 1);
						textFieldKel.remove(Util.getInstance().row - 1);
						textFieldMol.remove(Util.getInstance().row - 1);
						textFieldAmp.remove(Util.getInstance().row - 1);
						textFieldCand.remove(Util.getInstance().row - 1);
						textFieldResultSILow.remove(Util.getInstance().row - 1);
						textFieldResultSIHigh.remove(Util.getInstance().row - 1);
						buttonUpdateCSV.remove(Util.getInstance().row - 1);
						Util.getInstance().row--;
						contentPanel.revalidate();
						contentPanel.repaint();
					}
				}
			}
		});
		p2.add(buttonRemoveCommandVariable);

		//TODO Add fields Checks
		buttonNext = new JButton(Util.getInstance().dataLabels("buttonNext"));
		buttonNext.setFocusPainted(false);
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNext) {
					if (Util.getInstance().fieldsStringCheck(textFieldAbbreviation, "labelAbbr") != true) {
						return;
					}
					if (Util.getInstance().fieldsStringCheck(textFieldUnit, "labelUnit") != true) {
						return;
					}
					if (Util.getInstance().fieldsStringCheck(textFieldDimension, "labelDimension") != true) {
						return;
					}

					if (Util.getInstance().fieldsArrayCheck(textFieldHigh) == false) {
						return;
					}
					if (Util.getInstance().fieldsArrayCheck(textFieldM) == false) {
						return;
					}

					if (Util.getInstance().fieldsArrayCheck(textFieldK) == false) {
						return;
					}
					if (Util.getInstance().fieldsArrayCheck(textFieldS) == false) {
						return;
					}
					if (Util.getInstance().fieldsArrayCheck(textFieldKel) == false) {
						return;
					}
					if (Util.getInstance().fieldsArrayCheck(textFieldMol) == false) {
						return;
					}

					if (Util.getInstance().fieldsArrayCheck(textFieldAmp) == false) {
						return;
					}
					if (Util.getInstance().fieldsArrayCheck(textFieldCand) == false) {
						return;
					}
					if (Util.getInstance().fieldsArrayCheck(textFieldResultSILow) == false) {
						return;
					}
					if (Util.getInstance().fieldsArrayCheck(textFieldResultSIHigh) == false) {
						return;
					}

					if (Util.getInstance().SIMinMaxValuesCheck(textFieldResultSIHigh, textFieldResultSILow) == false) {

						return;
					}
					if (Util.getInstance().SIMinMaxValuesCheck(textFieldResultSIHigh, textFieldResultSILow) == false) {
						return;
					}
					//Util.getInstance().persistentSaveRelevantFactors();
					Menu.WRF.setVisible(false);

					// Test Window2
					//if (!new File(Util.getInstance().DIMENSIONLESSFACTORS_FILENAME).exists()) {
						System.out.println("new WindowDimensionlessFactors(Testvalues)");
						//Menu.WDF = new WindowDimensionlessFactors(new double[][] { { 1.0, 2.0 }, { -1.0, -2.0 }, { 1.0, 2.0 }, { -1.0, 0.0 }, { 0.0, -2.0 } }, new String[] { "Höhe", "Breite", "Dichte", "Temperatur", "Verhältnis" }, new String[] { "Alpha", "Beta" }, new String[][] { { "-5", "0" },
							//	{ "5", "10" } }, new String[][] { { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" }, { "0", "0" } });
					//} else {
						//System.out.println("restoreDimensionlessFactors()");					
						SingeltonTestMainStart.calculate(true);
						//Util.getInstance().restorePersistentDimensionlessFactors();
						//Menu.WDF = new WindowDimensionlessFactors();
					//}
				}
			}
		});
		p2.add(buttonNext);
		getContentPane().add(p2, BorderLayout.NORTH);

		scrollpane = new JScrollPane(contentPanel);

		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}// end Init

	public static void setSelectionItem(String newSelectionItemParent, String newSelectionItem, JTextField textFieldDimension, JTextField textFieldUnit) {
		textFieldDimension.setText(newSelectionItemParent);
		textFieldUnit.setText(newSelectionItem);
	}

	public static void doSICalculationLow() {
		if (Util.getInstance().unitsArray.size() > 0) {
			for (int i = 0; i < WindowRelevantFactors.textFieldDimension.size(); i++) {
				for (int n = 0; n < Util.getInstance().unitsArray.size(); n++) {
					if (WindowRelevantFactors.textFieldDimension.get(i).getText().equals(Util.getInstance().unitsArray.get(n).getDimension()) && WindowRelevantFactors.textFieldUnit.get(i).getText().equals(Util.getInstance().unitsArray.get(n).getUnit())
							&& WindowRelevantFactors.textFieldLow.get(i).getText() != "") {
						try {
							Util.getInstance().unitsArray.get(n).setLow(Double.parseDouble(WindowRelevantFactors.textFieldLow.get(i).getText()));
							WindowRelevantFactors.textFieldResultSILow.get(i).setText(("" + Util.getInstance().unitsArray.get(n).getResultSILow()).toString());
						} catch (NumberFormatException e) {
							// we discard the Exception
						}
					}
				}
			}
		} else {
			System.out.println("Util.getInstance().unitsArray is empty");
		}
	}

	public static void doSICalculationHigh() {
		if (Util.getInstance().unitsArray.size() > 0) {
			for (int i = 0; i < WindowRelevantFactors.textFieldDimension.size(); i++) {
				for (int n = 0; n < Util.getInstance().unitsArray.size(); n++) {
					if (WindowRelevantFactors.textFieldDimension.get(i).getText().equals(Util.getInstance().unitsArray.get(n).getDimension()) && WindowRelevantFactors.textFieldUnit.get(i).getText().equals(Util.getInstance().unitsArray.get(n).getUnit())
							&& WindowRelevantFactors.textFieldHigh.get(i).getText() != "") {
						try {
							Util.getInstance().unitsArray.get(n).setHigh(Double.parseDouble(WindowRelevantFactors.textFieldHigh.get(i).getText()));
							WindowRelevantFactors.textFieldResultSIHigh.get(i).setText(("" + Util.getInstance().unitsArray.get(n).getResultSIHigh()).toString());
						} catch (NumberFormatException e) {
							// we discard the Exception
						}
					}
				}
			}
		} else {
			System.out.println("Util.getInstance().unitsArray is empty");
		}
	}

	public void newFactor() {
		// ---- Declaration of Temp Objects ----
		// we do this to have access to these Temp objects
		// in action / mouselisteners
		JTextField textFieldNameTemp = new JTextField();
		JTextField textFieldAbbreviationTemp = new JTextField();
		JTextField textFieldDimensionTemp = new JTextField();
		JTextField textFieldUnitTemp = new JTextField();
		JTextField textFieldLowTemp = new JTextField();
		JTextField textFieldHighTemp = new JTextField();
		JComboBox<String> comboBoxRoleTemp = new JComboBox<String>(new String[] { "controlled", "constant", "scale-up", "dependent" });
		JTextField textFieldResultSILowTemp = new JTextField();
		JTextField textFieldResultSIHighTemp = new JTextField();

		// ---- JTextField Name ----
		textFieldNameTemp.setColumns(3);
		textFieldNameTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		contentPanel.add(textFieldNameTemp, new GridBagConstraints(0, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
		textFieldName.add(textFieldNameTemp);

		// ---- JTextField Abbreviation ----
		textFieldAbbreviationTemp.setColumns(3);
		textFieldAbbreviationTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		contentPanel.add(textFieldAbbreviationTemp, new GridBagConstraints(1, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldAbbreviation.add(textFieldAbbreviationTemp);

		// ---- JComboBox Role ----
		comboBoxRoleTemp.setEnabled(true);
		comboBoxRoleTemp.setMinimumSize(getPreferredSize());
		comboBoxRoleTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		comboBoxRoleTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxRoleTemp.getSelectedItem() == "constant") {
					textFieldHighTemp.setEnabled(false);
					textFieldResultSIHighTemp.setEnabled(false);
					textFieldHighTemp.setText(textFieldLowTemp.getText());
					textFieldResultSIHighTemp.setText(textFieldResultSILowTemp.getText());
				} else {
					textFieldHighTemp.setEnabled(true);
					textFieldResultSIHighTemp.setEnabled(true);
				}
			}
		});
		contentPanel.add(comboBoxRoleTemp, new GridBagConstraints(2, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		comboBoxRole.add(comboBoxRoleTemp);

		// ---- JTextField Dimension ----
		textFieldDimensionTemp.setMinimumSize(getPreferredSize());
		textFieldDimensionTemp.setColumns(3);
		textFieldDimensionTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldDimensionTemp.setEnabled(true);
		textFieldDimensionTemp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TreeWindow(textFieldDimensionTemp, textFieldUnitTemp);
				repaint();
				setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		contentPanel.add(textFieldDimensionTemp, new GridBagConstraints(3, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
		textFieldDimension.add(textFieldDimensionTemp);

		// ---- JTextField Unit ----
		textFieldUnitTemp.setMinimumSize(getPreferredSize());
		textFieldUnitTemp.setColumns(3);
		textFieldUnitTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldUnitTemp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TreeWindow(textFieldDimensionTemp, textFieldUnitTemp);
				repaint();
				setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		contentPanel.add(textFieldUnitTemp, new GridBagConstraints(4, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
		textFieldUnit.add(textFieldUnitTemp);

		// ---- JTextField Low ----
		textFieldLowTemp.setMinimumSize(getPreferredSize());
		textFieldLowTemp.setColumns(5);
		textFieldLowTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldLowTemp.getDocument().addDocumentListener(new DocumentListener() {
			// note: statechanged is triggered on persistentRestore
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldLowTemp, "labelLow");
				System.out.println("insertUpdate");
				doSICalculationLow();
				doComboboxCheck();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldLowTemp, "labelLow");
				System.out.println("removeUpdate");
				doSICalculationLow();
				doComboboxCheck();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldLowTemp, "labelLow");
				System.out.println("changedUpdate");
				doSICalculationLow();
				doComboboxCheck();
			}

			public void doComboboxCheck() {
				if (comboBoxRoleTemp.getSelectedItem() == "constant") {
					textFieldHighTemp.setText(textFieldLowTemp.getText());
					textFieldResultSIHighTemp.setText(textFieldResultSILowTemp.getText());
				}
			}
		});
	
		contentPanel.add(textFieldLowTemp, new GridBagConstraints(5, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
		textFieldLow.add(textFieldLowTemp);

		// ---- JTextField High ----
		textFieldHighTemp.setMinimumSize(getPreferredSize());
		textFieldHighTemp.setColumns(5);
		textFieldHighTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldHighTemp.getDocument().addDocumentListener(new DocumentListener() {
			// note: statechanged is triggered on persistentRestore
			@Override
			public void insertUpdate(DocumentEvent e) {
				System.out.println("insertUpdate");
				if (!comboBoxRoleTemp.getSelectedItem().equals("constant")) {
					checkFields = Util.getInstance().fieldsCheck(textFieldHighTemp, "labelHigh");

				}
				doSICalculationHigh();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				System.out.println("removeUpdate");
				if (!comboBoxRoleTemp.getSelectedItem().equals("constant")) {
					checkFields = Util.getInstance().fieldsCheck(textFieldHighTemp, "labelHigh");

				}
				doSICalculationHigh();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				System.out.println("changedUpdate");
				if (!comboBoxRoleTemp.getSelectedItem().equals("constant")) {
					checkFields = Util.getInstance().fieldsCheck(textFieldHighTemp, "labelHigh");

				}
				doSICalculationHigh();
			}
		});
		
		contentPanel.add(textFieldHighTemp, new GridBagConstraints(6, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldHigh.add(textFieldHighTemp);

		// ---- JTextField m ----
		JTextField textFieldMTemp = new JTextField();
		textFieldMTemp.setMinimumSize(getPreferredSize());
		textFieldMTemp.setColumns(2);
		textFieldMTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldMTemp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldMTemp, "m");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldMTemp, "m");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				Util.getInstance().fieldsCheck(textFieldMTemp, "m");

			}
		});
		contentPanel.add(textFieldMTemp, new GridBagConstraints(7, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldM.add(textFieldMTemp);

		// ---- JTextField k ----
		JTextField textFieldKTemp = new JTextField();
		textFieldKTemp.setMinimumSize(getPreferredSize());
		textFieldKTemp.setColumns(2);
		textFieldKTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldKTemp.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldKTemp, "k");

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldKTemp, "k");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldKTemp, "k");

			}
		});
		contentPanel.add(textFieldKTemp, new GridBagConstraints(8, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldK.add(textFieldKTemp);

		// ---- JTextField s ----
		JTextField textFieldSTemp = new JTextField();
		textFieldSTemp.setMinimumSize(getPreferredSize());
		textFieldSTemp.setColumns(2);
		textFieldSTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldSTemp.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldSTemp, "s");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldSTemp, "s");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldSTemp, "s");

			}
		});
		contentPanel.add(textFieldSTemp, new GridBagConstraints(9, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldS.add(textFieldSTemp);

		// ---- JTextField kel ----
		JTextField textFieldKelTemp = new JTextField();
		textFieldKelTemp.setMinimumSize(getPreferredSize());
		textFieldKelTemp.setColumns(2);
		textFieldKelTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldKelTemp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldKelTemp, "kel");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldKelTemp, "kel");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldKelTemp, "kel");
			}
		});
		contentPanel.add(textFieldKelTemp, new GridBagConstraints(10, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldKel.add(textFieldKelTemp);

		// ---- JTextField mol ----
		JTextField textFieldMolTemp = new JTextField();
		textFieldMolTemp.setMinimumSize(getPreferredSize());
		textFieldMolTemp.setColumns(2);
		textFieldMolTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		contentPanel.add(textFieldMolTemp, new GridBagConstraints(11, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldMol.add(textFieldMolTemp);
		textFieldMolTemp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldMolTemp, "mol");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldMolTemp, "mol");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldMolTemp, "mol");
			}
		});
		// ---- JTextField amp ----
		JTextField textFieldAmpTemp = new JTextField();
		textFieldAmpTemp.setMinimumSize(getPreferredSize());
		textFieldAmpTemp.setColumns(2);
		textFieldAmpTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldAmpTemp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldAmpTemp, "amp");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldAmpTemp, "amp");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldAmpTemp, "amp");
			}
		});
		contentPanel.add(textFieldAmpTemp, new GridBagConstraints(12, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldAmp.add(textFieldAmpTemp);

		// ---- JTextField cand ----
		JTextField textFieldCandTemp = new JTextField();
		textFieldCandTemp.setMinimumSize(getPreferredSize());
		textFieldCandTemp.setColumns(2);
		textFieldCandTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldCandTemp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldCandTemp, "cand");
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldCandTemp, "cand");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldCandTemp, "cand");
			}
		});
		contentPanel.add(textFieldCandTemp, new GridBagConstraints(13, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldCand.add(textFieldCandTemp);

		// ---- JTextField SI Low ----
		textFieldResultSILowTemp.setMinimumSize(getPreferredSize());
		textFieldResultSILowTemp.setColumns(8);
		textFieldResultSILowTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldResultSILowTemp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldResultSILowTemp, "labelSIMin");

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldResultSILowTemp, "labelSIMin");

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkFields = Util.getInstance().fieldsCheck(textFieldCandTemp, "labelSIMin");
			}
		});

		contentPanel.add(textFieldResultSILowTemp, new GridBagConstraints(14, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldResultSILow.add(textFieldResultSILowTemp);

		// ---- JTextField SI High ----
		textFieldResultSIHighTemp.setMinimumSize(getPreferredSize());
		textFieldResultSIHighTemp.setColumns(8);
		textFieldResultSIHighTemp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		textFieldResultSIHighTemp.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				if (!comboBoxRoleTemp.getSelectedItem().equals("constant")) {
					checkFields = Util.getInstance().fieldsCheck(textFieldResultSIHighTemp, "labelSIMax");

				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!comboBoxRoleTemp.getSelectedItem().equals("constant")) {
					checkFields = Util.getInstance().fieldsCheck(textFieldResultSIHighTemp, "labelSIMax");

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if (!comboBoxRoleTemp.getSelectedItem().equals("constant")) {
					checkFields = Util.getInstance().fieldsCheck(textFieldResultSIHighTemp, "labelSIMax");

				}
			}
		});

		contentPanel.add(textFieldResultSIHighTemp, new GridBagConstraints(15, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldResultSIHigh.add(textFieldResultSIHighTemp);

		// ---- buttonUpdateCSV ----
		JButton buttonUpdateCSVTemp = new JButton(Util.getInstance().dataLabels("buttonUpdateCSV"));
		buttonUpdateCSVTemp.setToolTipText(Util.getInstance().dataLabels("textOverUpdateCSV"));
		buttonUpdateCSVTemp.setFocusPainted(false);
		buttonUpdateCSVTemp.setEnabled(false);
		buttonUpdateCSVTemp.setMinimumSize(getPreferredSize());
		buttonUpdateCSVTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonUpdateCSVTemp) {
					System.out.println("UpdateCSV: Start");
					try {
						double gradient = 0;
						double offset = 0;
						if (comboBoxRoleTemp.getSelectedItem() == "constant"){
							gradient = (Double.parseDouble(textFieldResultSILowTemp.getText())) / (Double.parseDouble(textFieldLowTemp.getText()));
							System.out.println("gradient: " + gradient);
							offset = 0;
							System.out.println("offset: " + offset);
						} else {
							gradient = (Double.parseDouble(textFieldResultSIHighTemp.getText()) - Double.parseDouble(textFieldResultSILowTemp.getText())) / (Double.parseDouble(textFieldHighTemp.getText()) - Double.parseDouble(textFieldLowTemp.getText()));
							System.out.println("gradient: " + gradient);
							offset = (Double.parseDouble(textFieldResultSILowTemp.getText()) - Double.parseDouble(textFieldLowTemp.getText())) * gradient;
							System.out.println("offset: " + offset);
						}
						RawUnits tempRaw = new RawUnits(textFieldDimensionTemp.getText(), textFieldUnitTemp.getText(), Integer.parseInt(textFieldMTemp.getText()), Integer.parseInt(textFieldKTemp.getText()), Integer.parseInt(textFieldSTemp.getText()), Integer.parseInt(textFieldKelTemp.getText()),
								Integer.parseInt(textFieldMolTemp.getText()), Integer.parseInt(textFieldAmpTemp.getText()), Integer.parseInt(textFieldCandTemp.getText()), offset, gradient);
						Util.getInstance().unitsArray.add(tempRaw);
						Util.getInstance().writeCSV(Util.getInstance().USER_CSV_FILENAME);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					System.out.println("UpdateCSV: done.");
					textFieldDimensionTemp.setText("");
					textFieldUnitTemp.setText("");
					textFieldLowTemp.setText(""+0);
					textFieldHighTemp.setText(""+0);
					textFieldMTemp.setText(""+0);
					textFieldKTemp.setText(""+0);
					textFieldSTemp.setText(""+0);
					textFieldKelTemp.setText(""+0);
					textFieldMolTemp.setText(""+0);
					textFieldAmpTemp.setText(""+0);
					textFieldCandTemp.setText(""+0);
					textFieldResultSILowTemp.setText(""+0);
					textFieldResultSIHighTemp.setText(""+0);
					buttonUpdateCSVTemp.setEnabled(false);
				}
			}
		});
		buttonUpdateCSVTemp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!textFieldLowTemp.getText().equals("0") 
				&& !textFieldHighTemp.getText().equals("0") 
				&& !textFieldResultSILowTemp.getText().equals("0") 
				&& !textFieldResultSIHighTemp.getText().equals("0")) {
					if (!buttonUpdateCSVTemp.isEnabled()) {
						buttonUpdateCSVTemp.setEnabled(true);
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		contentPanel.add(buttonUpdateCSVTemp, new GridBagConstraints(16, 14 + Util.getInstance().row, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 10), 0, 0));
		buttonUpdateCSV.add(buttonUpdateCSVTemp);
	} // end newFactor

	// Getter Methods
	public static ArrayList<JTextField> getTextFieldName() {
		return textFieldName;
	}

	public static ArrayList<JTextField> getTextFieldM() {
		return textFieldM;
	}

	public static ArrayList<JTextField> getTextFieldK() {
		return textFieldK;
	}

	public static ArrayList<JTextField> getTextFieldS() {
		return textFieldS;
	}

	public static ArrayList<JTextField> getTextFieldKel() {
		return textFieldKel;
	}

	public static ArrayList<JTextField> getTextFieldMol() {
		return textFieldMol;
	}

	public static ArrayList<JTextField> getTextFieldAmp() {
		return textFieldAmp;
	}

	public static ArrayList<JTextField> getTextFieldCand() {
		return textFieldCand;
	}

	public static ArrayList<JTextField> getTextFieldSILow() {
		return textFieldResultSILow;
	}

	public static ArrayList<JTextField> getTextFieldSIHigh() {
		return textFieldResultSIHigh;
	}

	public static ArrayList<JComboBox<String>> getComboBoxRole() {
		return comboBoxRole;
	}
}
