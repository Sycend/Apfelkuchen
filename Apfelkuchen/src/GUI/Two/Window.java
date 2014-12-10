package GUI.Two;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Main Window
 * 
 * @author Yuri Kalinin, Florian Then, Dominik Hofmann
 * @version 1.1.1
 */
public class Window extends JFrame {

	JScrollPane scrollpane;
	private JButton buttonRemove;
	private JButton buttonOptimize;
	private JButton buttonNewField;
	private JLabel labelName;
	private JLabel labelAbbreviation;
	private JLabel labelRolle;
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
	protected static ArrayList<JTextField> fieldExpon = new ArrayList<JTextField>();
	protected static ArrayList<JComboBox<String>> comboBoxRolle = new ArrayList<JComboBox<String>>();
	protected static ArrayList<JButton> buttonUpdateCSV = new ArrayList<JButton>();

	// Save information from Name and Abbr fields
	protected static ArrayList<String> dateFromFieldString = new ArrayList<String>();
	private JPanel contentPanel = new JPanel();

	public Window() {
		super(XMLDate.dateLabels("title"));
		setSize(1194, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		init();
		setVisible(true);
	}

	public void init() {

		// JPanel contentPanel = new JPanel();
		contentPanel.setSize(100, 100);

		// ======== contentPanel ========

		contentPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.setLayout(new GridBagLayout());
		((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {
				80, 80, 80, 80, 80, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] { 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

		// JMenuBar mb = new JMenuBar();

		JPanel p2 = new JPanel();

		// ---- label Name ----
		labelName = new JLabel();
		labelName.setText(XMLDate.dateLabels("nameFeld"));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelName, new GridBagConstraints(0, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 5, 5), 0, 0));

		// ---- label Abbreviation ----
		labelAbbreviation = new JLabel();
		labelAbbreviation.setText(" " + "Abkuerzung");
		labelAbbreviation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAbbreviation.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelAbbreviation, new GridBagConstraints(1, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Rolle ----
		labelRolle = new JLabel();
		labelRolle.setText(XMLDate.dateLabels("labelRolle"));
		labelRolle.setHorizontalAlignment(SwingConstants.CENTER);
		labelRolle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelRolle, new GridBagConstraints(2, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Dimension ----
		labelDimension = new JLabel();
		labelDimension.setText(XMLDate.dateLabels("labelDimension"));
		labelDimension.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDimension.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelDimension, new GridBagConstraints(3, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label Unit ----
		labelUnit = new JLabel();
		labelUnit.setText(XMLDate.dateLabels("labelSIUnit"));
		labelUnit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUnit.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelUnit, new GridBagConstraints(4, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label Low ----
		labelLow = new JLabel();
		labelLow.setText(XMLDate.dateLabels("labelLow") + " ");
		labelLow.setHorizontalAlignment(SwingConstants.CENTER);
		labelLow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelLow, new GridBagConstraints(5, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label High ----
		labelHigh = new JLabel();
		labelHigh.setText(XMLDate.dateLabels("labelHigh") + " ");
		labelHigh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelHigh.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelHigh, new GridBagConstraints(6, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label m ----
		labelM = new JLabel();
		labelM.setText("m" + "  ");
		labelM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelM.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelM, new GridBagConstraints(7, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- label k ----
		labelK = new JLabel();
		labelK.setText("k");
		labelK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelK.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelK, new GridBagConstraints(8, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- label s ----
		labelS = new JLabel();
		labelS.setText("s" + "  ");
		labelS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelS.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelS, new GridBagConstraints(9, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- label kel ----
		labelKel = new JLabel();
		labelKel.setText("kel" + "  ");
		labelKel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelKel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelKel, new GridBagConstraints(10, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label mol ----
		labelMol = new JLabel();
		labelMol.setText("mol" + "  ");
		labelMol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMol.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelMol, new GridBagConstraints(11, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label amp ----
		labelAmp = new JLabel();
		labelAmp.setText("amp" + "  ");
		labelAmp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAmp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelAmp, new GridBagConstraints(12, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label cand ----
		labelCand = new JLabel();
		labelCand.setText("cand" + "  ");
		labelCand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCand.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelCand, new GridBagConstraints(13, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label SI Min ----
		labelResultSIMin = new JLabel();
		labelResultSIMin.setText(XMLDate.dateLabels("labelSIMin") + " ");
		labelResultSIMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelResultSIMin, new GridBagConstraints(14, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 20, 5, 5), 0, 0));

		// ---- label SI Max ----
		labelResultSIMax = new JLabel();
		labelResultSIMax.setText(XMLDate.dateLabels("labelSIMax") + " ");
		labelResultSIMax.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelResultSIMax, new GridBagConstraints(15, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		buttonNewField = new JButton(XMLDate.dateLabels("buttonNewField"));
		buttonNewField.setFocusPainted(false);
		buttonNewField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNewField) {
					Run.addRow();
					newField();
					contentPanel.revalidate();
					contentPanel.repaint();
				}
			}
		});

		p2.add(buttonNewField);

		buttonRemove = new JButton(XMLDate.dateLabels("buttonRemove"));
		buttonRemove.setFocusPainted(false);
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonRemove) {
					if (textFieldName.size() > 0) {
						contentPanel.remove(textFieldName.get(Run.rows - 1));
						contentPanel.remove(textFieldAbbreviation.get(Run.rows - 1));
						contentPanel.remove(comboBoxRolle.get(Run.rows - 1));
						contentPanel.remove(textFieldDimension.get(Run.rows - 1));
						contentPanel.remove(textFieldUnit.get(Run.rows - 1));
						contentPanel.remove(textFieldLow.get(Run.rows - 1));
						contentPanel.remove(textFieldHigh.get(Run.rows - 1));
						contentPanel.remove(textFieldM.get(Run.rows - 1));
						contentPanel.remove(textFieldK.get(Run.rows - 1));
						contentPanel.remove(textFieldS.get(Run.rows - 1));
						contentPanel.remove(textFieldKel.get(Run.rows - 1));
						contentPanel.remove(textFieldMol.get(Run.rows - 1));
						contentPanel.remove(textFieldAmp.get(Run.rows - 1));
						contentPanel.remove(textFieldCand.get(Run.rows - 1));
						contentPanel.remove(textFieldResultSILow.get(Run.rows - 1));
						contentPanel.remove(textFieldResultSIHigh.get(Run.rows - 1));
						contentPanel.remove(buttonUpdateCSV.get(Run.rows - 1));
						textFieldName.remove(Run.rows - 1);
						textFieldAbbreviation.remove(Run.rows - 1);
						comboBoxRolle.remove(Run.rows - 1);
						textFieldDimension.remove(Run.rows - 1);
						textFieldUnit.remove(Run.rows - 1);
						textFieldLow.remove(Run.rows - 1);
						textFieldHigh.remove(Run.rows - 1);
						textFieldM.remove(Run.rows - 1);
						textFieldK.remove(Run.rows - 1);
						textFieldS.remove(Run.rows - 1);
						textFieldKel.remove(Run.rows - 1);
						textFieldMol.remove(Run.rows - 1);
						textFieldAmp.remove(Run.rows - 1);
						textFieldCand.remove(Run.rows - 1);
						textFieldResultSILow.remove(Run.rows - 1);
						textFieldResultSIHigh.remove(Run.rows - 1);
						buttonUpdateCSV.remove(Run.rows - 1);
						Run.removeRow();
						contentPanel.revalidate();
						contentPanel.repaint();
					}
				}
			}
		});
		p2.add(buttonRemove);

		buttonOptimize = new JButton(XMLDate.dateLabels("buttonNext"));
		buttonOptimize.setFocusPainted(false);
		buttonOptimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOptimize) {
					// --- check field Abbreviation---
					String message = XMLDate.dateLabels("errorTextDialog")
							+ " für ";
					String title = XMLDate.dateLabels("errorTitleDialog");
					for (int i = 0; i < textFieldAbbreviation.size(); i++) {
						String input = textFieldAbbreviation.get(i).getText();

						// Shows an error dialog if false
						if ((new StringCheck().abbreviationCheck(input)) == false) {
							JOptionPane.showMessageDialog(new JFrame(), message
									+ labelAbbreviation.getText(), title,
									JOptionPane.ERROR_MESSAGE);
							return;
						}

					}

					setVisible(false);
					// WindowOptim window = new WindowOptim();
					// window.setWindow();

					// test window 2. just for testing

					Window2 test = new Window2(
							new double[][] { { 1.0, 2.0 }, { -1.0, -2.0 },
									{ 1.0, 2.0 }, { -1.0, 0.0 }, { 0.0, -2.0 } },// ,{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0}},
							new String[] { "Höhe", "Breite", "Dichte",
									"Temperatur", "Verhältnis" },// ,"Test 1","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3"},
							new String[] { "Alpha", "Beta" }, new String[][] {
									{ "-5", "0" }, { "5", "10" } },
							new String[][] { { "0", "0" }, { "0", "0" },
									{ "0", "0" }, { "0", "0" }, { "0", "0" },
									{ "0", "0" }, { "0", "0" } });

					for (int i = 0; i < Run.rows; i++) {
						dateFromFieldString.add(textFieldName.get(i).getText());
						dateFromFieldString.add(textFieldAbbreviation.get(i)
								.getText());
						dateFromFieldString.add(comboBoxRolle.get(i)
								.getSelectedItem().toString());
						dateFromFieldString.add(textFieldDimension.get(i)
								.getText());
						dateFromFieldString.add(textFieldUnit.get(i).getText());
						dateFromFieldString.add(textFieldM.get(i).getText());
						dateFromFieldString.add(textFieldK.get(i).getText());
						dateFromFieldString.add(textFieldS.get(i).getText());
						dateFromFieldString.add(textFieldKel.get(i).getText());
						dateFromFieldString.add(textFieldMol.get(i).getText());
						dateFromFieldString.add(textFieldAmp.get(i).getText());
						dateFromFieldString.add(textFieldCand.get(i).getText());
						dateFromFieldString.add(textFieldLow.get(i).getText());
						dateFromFieldString.add(textFieldHigh.get(i).getText());
						dateFromFieldString.add(textFieldResultSILow.get(i)
								.getText());
						dateFromFieldString.add(textFieldResultSIHigh.get(i)
								.getText());
					}

					Run.savaDateFromFields();
					dispose();
				}

			}
		});
		p2.add(buttonOptimize);
		getContentPane().add(p2, BorderLayout.NORTH);

		scrollpane = new JScrollPane(contentPanel);

		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}// end Init

	public static void setSelectionItem(String newSelectionItemParent,
			String newSelectionItem, JTextField textFieldDimension,
			JTextField textFieldUnit) {
		textFieldDimension.setText(newSelectionItemParent);
		textFieldUnit.setText(newSelectionItem);
	}

	public ArrayList<String> getDateFromFields() {
		return dateFromFieldString;
	}

	public void newField() {		
		// ---- Declaration of Temp Objects ----
		//we do this to have access to these Temp objects
		//in action / mouselisteners
		JTextField textFieldNameTemp = new JTextField();
		JTextField textFieldAbbreviationTemp = new JTextField();
		JTextField textFieldDimensionTemp = new JTextField();
		JTextField textFieldUnitTemp = new JTextField();
		JTextField textFieldLowTemp = new JTextField();
		JTextField textFieldHighTemp = new JTextField();
		JComboBox<String> comboBoxRolleTemp = new JComboBox<String>(Run.getRole());
		
		// ---- JTextField Name ----
		textFieldNameTemp.setMinimumSize(new Dimension(80, 20));
		textFieldNameTemp.setMaximumSize(new Dimension(80, 20));
		contentPanel.add(textFieldNameTemp, new GridBagConstraints(0,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
		textFieldName.add(textFieldNameTemp);

		// ---- JTextField Abbreviation ----
		textFieldAbbreviationTemp.setMinimumSize(new Dimension(80, 20));
		textFieldAbbreviationTemp.setMaximumSize(new Dimension(80, 20));
		contentPanel.add(textFieldAbbreviationTemp, new GridBagConstraints(1,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldAbbreviation.add(textFieldAbbreviationTemp);
		
		// ---- JComboBox Rolle ----
		comboBoxRolleTemp.setEnabled(true);
		comboBoxRolleTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxRolleTemp.getSelectedItem() == "constant"){
					textFieldHighTemp.setEnabled(false);
					textFieldHighTemp.setText(textFieldLowTemp.getText());
				} else {
					textFieldHighTemp.setEnabled(true);
				}
			}
		});
		contentPanel.add(comboBoxRolleTemp, new GridBagConstraints(2,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		comboBoxRolle.add(comboBoxRolleTemp);

		// ---- JTextField Dimension ----
		textFieldDimensionTemp.setMinimumSize(new Dimension(40, 20));
		textFieldDimensionTemp.setPreferredSize(new Dimension(40, 20));
		textFieldDimensionTemp.setMaximumSize(new Dimension(50, 20));
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
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

		});

		contentPanel.add(textFieldDimensionTemp, new GridBagConstraints(3,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
		textFieldDimension.add(textFieldDimensionTemp);

		// ---- JTextField Unit ----
		textFieldUnitTemp.setMinimumSize(new Dimension(30, 20));
		textFieldUnitTemp.setPreferredSize(new Dimension(20, 20));
		textFieldUnitTemp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("textFieldUnit.size: "
						+ textFieldUnit.size());
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

		contentPanel.add(textFieldUnitTemp, new GridBagConstraints(4,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
		textFieldUnit.add(textFieldUnitTemp);

		// ---- JTextField Low ----
		// textFieldLowTemp.setColumns(4);
		textFieldLowTemp.setMinimumSize(new Dimension(40, 20));
		textFieldLowTemp.setMaximumSize(new Dimension(40, 20));
		textFieldLowTemp.setPreferredSize(new Dimension(40, 20));

		textFieldLowTemp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (Run.unitsArray.size() > 0) {
					for (int i = 0; i < Window.textFieldDimension.size(); i++) {
						for (int n = 0; n < Run.unitsArray.size(); n++) {
							if (Window.textFieldDimension.get(i).getText().equals(Run.unitsArray.get(n).getDimension())) {
								if (Window.textFieldUnit.get(i).getText().equals(Run.unitsArray.get(n).getUnit())) {
									if (Window.textFieldLow.get(i).getText() != "") {
										try {
											Run.unitsArray.get(n).setLow(Double.parseDouble(Window.textFieldLow.get(i).getText()));
											Window.textFieldResultSILow.get(i).setText("" + Run.unitsArray.get(n).getResultSILow());
										} catch (NumberFormatException e) {
											// we discard the Exception
										}
									}
								}
							}
						}
					}
				} else {
					System.out.println("Run.unitsArray is empty");
				}
				if (comboBoxRolleTemp.getSelectedItem() == "constant"){
					textFieldHighTemp.setText(textFieldLowTemp.getText());
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		contentPanel.add(textFieldLowTemp, new GridBagConstraints(5,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
		textFieldLow.add(textFieldLowTemp);

		// ---- JTextField High ----
		// textFieldHighTemp.setColumns(4);
		textFieldHighTemp.setMaximumSize(new Dimension(40, 20));
		textFieldHighTemp.setPreferredSize(new Dimension(40, 20));
		textFieldHighTemp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (Run.unitsArray.size() > 0) {
					for (int i = 0; i < Window.textFieldDimension.size(); i++) {
						for (int n = 0; n < Run.unitsArray.size(); n++) {
							if (Window.textFieldDimension.get(i).getText().equals(Run.unitsArray.get(n).getDimension())) {
								if (Window.textFieldUnit.get(i).getText().equals(Run.unitsArray.get(n).getUnit())) {
									if (Window.textFieldHigh.get(i).getText() != "") {
										try {
											Run.unitsArray.get(n).setHigh(Double.parseDouble(Window.textFieldHigh.get(i).getText()));
											Window.textFieldResultSIHigh.get(i).setText("" + Run.unitsArray.get(n).getResultSIHigh());
										} catch (NumberFormatException e) {
											// we discard the Exception
										}
									}
								}
							}
						}
					}
				} else {
					System.out.println("Run.unitsArray is empty");
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		contentPanel.add(textFieldHighTemp, new GridBagConstraints(6,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldHigh.add(textFieldHighTemp);
		
		// ---- JTextField m ----
		JTextField textFieldMTemp = new JTextField();
		textFieldMTemp.setMaximumSize(new Dimension(40, 20));
		textFieldMTemp.setPreferredSize(new Dimension(40, 20));
		contentPanel.add(textFieldMTemp, new GridBagConstraints(7,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldM.add(textFieldMTemp);

		// ---- JTextField k ----
		JTextField textFieldKTemp = new JTextField();
		textFieldKTemp.setMaximumSize(new Dimension(20, 20));
		textFieldKTemp.setPreferredSize(new Dimension(20, 20));
		contentPanel.add(textFieldKTemp, new GridBagConstraints(8,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldK.add(textFieldKTemp);

		// ---- JTextField s ----
		JTextField textFieldSTemp = new JTextField();
		textFieldSTemp.setMaximumSize(new Dimension(40, 20));
		textFieldSTemp.setPreferredSize(new Dimension(40, 20));
		contentPanel.add(textFieldSTemp, new GridBagConstraints(9,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldS.add(textFieldSTemp);

		// ---- JTextField kel ----
		JTextField textFieldKelTemp = new JTextField();
		textFieldKelTemp.setMaximumSize(new Dimension(40, 20));
		textFieldKelTemp.setPreferredSize(new Dimension(40, 20));
		contentPanel.add(textFieldKelTemp, new GridBagConstraints(10,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldKel.add(textFieldKelTemp);

		// ---- JTextField mol ----
		JTextField textFieldMolTemp = new JTextField();
		textFieldMolTemp.setMaximumSize(new Dimension(40, 20));
		textFieldMolTemp.setPreferredSize(new Dimension(40, 20));
		contentPanel.add(textFieldMolTemp, new GridBagConstraints(11,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldMol.add(textFieldMolTemp);

		// ---- JTextField amp ----
		JTextField textFieldAmpTemp = new JTextField();
		textFieldAmpTemp.setMaximumSize(new Dimension(40, 20));
		textFieldAmpTemp.setPreferredSize(new Dimension(40, 20));
		contentPanel.add(textFieldAmpTemp, new GridBagConstraints(12,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldAmp.add(textFieldAmpTemp);

		// ---- JTextField cand ----
		JTextField textFieldCandTemp = new JTextField();
		textFieldCandTemp.setMaximumSize(new Dimension(40, 20));
		textFieldCandTemp.setPreferredSize(new Dimension(40, 20));
		contentPanel.add(textFieldCandTemp, new GridBagConstraints(13,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		textFieldCand.add(textFieldCandTemp);

		// ---- JTextField SI Low ----
		JTextField textFieldResultSILowTemp = new JTextField();
		textFieldResultSILowTemp.setMaximumSize(new Dimension(60, 20));
		textFieldResultSILowTemp.setPreferredSize(new Dimension(60, 20));
		contentPanel.add(textFieldResultSILowTemp, new GridBagConstraints(14,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 20, 5, 5), 0, 0));
		textFieldResultSILow.add(textFieldResultSILowTemp);

		// ---- JTextField SI High ----
		JTextField textFieldResultSIHighTemp = new JTextField();
		textFieldResultSIHighTemp.setMaximumSize(new Dimension(60, 20));
		textFieldResultSIHighTemp.setPreferredSize(new Dimension(60, 20));
		contentPanel.add(textFieldResultSIHighTemp, new GridBagConstraints(15,
				14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 10), 0, 0));
		textFieldResultSIHigh.add(textFieldResultSIHighTemp);
		
		// ---- buttonUpdateCSV ----
		JButton buttonUpdateCSVTemp = new JButton("UpdateCSV");
		buttonUpdateCSVTemp.setFocusPainted(false);
		buttonUpdateCSVTemp.setEnabled(false);
		buttonUpdateCSVTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonUpdateCSVTemp) {
					System.out.println("UpdateCSV: Start");
					try {
						double gradient = (Double.parseDouble(textFieldResultSIHighTemp.getText()) - Double.parseDouble(textFieldResultSILowTemp.getText())) / (Double.parseDouble(textFieldHighTemp.getText()) - Double.parseDouble(textFieldLowTemp.getText()));
						System.out.println("gradient: " + gradient);
						double offset = (Double.parseDouble(textFieldResultSILowTemp.getText()) - Double.parseDouble(textFieldLowTemp.getText())) * gradient;
						System.out.println("offset: " + offset);
						RawUnits tempRaw = new RawUnits(textFieldDimensionTemp.getText(), textFieldUnitTemp.getText(), Double.parseDouble(textFieldLowTemp.getText()), Double.parseDouble(textFieldHighTemp.getText()), Integer.parseInt(textFieldMTemp.getText()), Integer.parseInt(textFieldKTemp
						.getText()), Integer.parseInt(textFieldSTemp.getText()), Integer.parseInt(textFieldKelTemp.getText()), Integer.parseInt(textFieldMolTemp.getText()), Integer.parseInt(textFieldAmpTemp.getText()), Integer.parseInt(textFieldCandTemp.getText()), offset, gradient);
						Run.unitsArray.add(tempRaw);
						CSV.writeCSV(Run.csvName);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					System.out.println("UpdateCSV: done.");
					textFieldDimensionTemp.setText("");
					textFieldUnitTemp.setText("");
					textFieldLowTemp.setText("");
					textFieldHighTemp.setText("");
					textFieldMTemp.setText("");
					textFieldKTemp.setText("");
					textFieldSTemp.setText("");
					textFieldKelTemp.setText("");
					textFieldMolTemp.setText("");
					textFieldAmpTemp.setText("");
					textFieldCandTemp.setText("");
					textFieldResultSILowTemp.setText("");
					textFieldResultSIHighTemp.setText("");
					buttonUpdateCSVTemp.setEnabled(false);
				}
			}
		});
		buttonUpdateCSVTemp.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!textFieldDimensionTemp.getText().isEmpty() && !textFieldUnitTemp.getText().isEmpty() && !textFieldResultSILowTemp.getText().isEmpty() && !textFieldResultSIHighTemp.getText().isEmpty()){
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
		
		contentPanel.add(buttonUpdateCSVTemp, new GridBagConstraints(16,
		14 + Run.rows, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
		GridBagConstraints.BOTH, new Insets(0, 0, 5, 10), 0, 0));
		buttonUpdateCSV.add(buttonUpdateCSVTemp);
	}
}