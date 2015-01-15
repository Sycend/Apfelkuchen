package GUI.Two;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Florian Then, Dominik Hofmann
 * @version 1.0.3
 * Window2
 */
public class WindowDimensionlessFactors extends JFrame {
	private static final long serialVersionUID = 1L;
	protected static double[][] vMatrix;
	protected static String[] rowNames;
	protected static String[] colNames;
	protected static String[] minV;
	protected static String[] maxV;
	protected static String[][] dimensionlessControlSI;
	private int lengthVMatrix;
	private int widthVMatrix;
	private ArrayList<JTextField> textFieldColNames = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMinV = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldMaxV = new ArrayList<JTextField>();
	private ArrayList<ArrayList<JTextField>> vMatrixTextFields = new ArrayList<ArrayList<JTextField>>();
	private ArrayList<ArrayList<JTextField>> linearDependenceTextFields = new ArrayList<ArrayList<JTextField>>();
	private ArrayList<ArrayList<JLabel>> labelSI = new ArrayList<ArrayList<JLabel>>();
	private ArrayList<JCheckBox> checkBoxsVMatrix = new ArrayList<JCheckBox>();
	private JButton buttonReset;
	private JButton buttonRMin;
	private JButton buttonRMax;
	private JButton buttonBack;
	private JToggleButton toggle = new JToggleButton();
	
	public WindowDimensionlessFactors(double[][] vMatrix, String[] rowNames, String[] colNames, String[][] minMax,
	String[][] dimensionlessControlSI) {
		
		WindowDimensionlessFactors.vMatrix = vMatrix;
		WindowDimensionlessFactors.rowNames = rowNames;
		WindowDimensionlessFactors.colNames = colNames;
		
		minV = new String[minMax[0].length];
		maxV = new String[minMax[0].length];
		for (int i = 0; i < vMatrix[0].length; i++) {
			minV[i] = minMax[0][i];
			maxV[i] = minMax[1][i];
		}
		
		WindowDimensionlessFactors.dimensionlessControlSI = new String[7][dimensionlessControlSI[0].length];
		for (int j = 0; j < vMatrix[0].length; j++) {
			WindowDimensionlessFactors.dimensionlessControlSI[0][j] = dimensionlessControlSI[0][j]; //M
			WindowDimensionlessFactors.dimensionlessControlSI[1][j] = dimensionlessControlSI[1][j]; //K
			WindowDimensionlessFactors.dimensionlessControlSI[2][j] = dimensionlessControlSI[2][j]; //S
			WindowDimensionlessFactors.dimensionlessControlSI[3][j] = dimensionlessControlSI[3][j]; //Kel
			WindowDimensionlessFactors.dimensionlessControlSI[4][j] = dimensionlessControlSI[4][j]; //Mol
			WindowDimensionlessFactors.dimensionlessControlSI[5][j] = dimensionlessControlSI[5][j]; //Amp
			WindowDimensionlessFactors.dimensionlessControlSI[6][j] = dimensionlessControlSI[6][j]; //Cand
		}
		
		//Testausgabe um Matrix-Ausma�e zu �berpr�fen
		System.out.println("vMatrix.length: " + vMatrix.length);
		System.out.println("vMatrix[0].length: " + vMatrix[0].length);
		lengthVMatrix = vMatrix.length;
		widthVMatrix = vMatrix[0].length;
		
		setSize(Run.currentWidth, Run.currentHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(Run.dataLabels("title"));
		init();
		setVisible(true);
	}
	
	public WindowDimensionlessFactors() {
		lengthVMatrix = vMatrix.length;
		widthVMatrix = vMatrix[0].length;
		
		setSize(Run.currentWidth, Run.currentHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(Run.dataLabels("title"));
		init();
		setVisible(true);
	}
	
	public void init() {
		setLayout(new BorderLayout());
		
		JPanel menuePanel = new JPanel();
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkLinearMatrix()){
					ArrayList<ArrayList<JTextField>> vMatrixTextFieldsTemp = vMatrixTextFields;
					for(int l=0;l<widthVMatrix;l++){
						for(int i=0;i<lengthVMatrix;i++){
							double temp[]= new double[widthVMatrix];
							for(int j=0;j<widthVMatrix;j++){
								System.out.println("i="+i);
								System.out.println("j="+j);
								System.out.println("l="+l);
								temp[j]=temp[j]+Double.parseDouble((linearDependenceTextFields.get(j).get(l).getText()))*
										Double.parseDouble(vMatrixTextFieldsTemp.get(i).get(j).getText());
								System.out.println("123456789-----"+temp[j]);
							}
							System.out.println("TempArrayList");
							ArrayList<JTextField> tempArrayList=new ArrayList<JTextField>();
							for(int k=0;k<widthVMatrix;k++)
							{
								System.out.println(k);
								JTextField tempTextField = new JTextField();
								System.out.println("Test1");
								tempTextField.setText(String.valueOf(temp[k]));
								System.out.println("Test2");
								tempArrayList.add(tempTextField);
							}
							System.out.println("setTempArrayList");
							vMatrixTextFields.set(i,tempArrayList);
						}	
					}
					System.out.println("TestRepaint");
					revalidate();
					repaint();
					System.out.println(vMatrixTextFields.get(0).get(0).getText());
					System.out.println(vMatrixTextFields.get(0).get(1).getText());
					System.out.println(vMatrixTextFields.get(1).get(0).getText());
					System.out.println(vMatrixTextFields.get(1).get(1).getText());
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(),"Please change the linear Matrix","No change !",  JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		menuePanel.add(buttonReset);
		
		ArrayList<JLabel> labelM = new ArrayList<JLabel>();
		ArrayList<JLabel> labelK = new ArrayList<JLabel>();
		ArrayList<JLabel> labelS = new ArrayList<JLabel>();
		ArrayList<JLabel> labelKel = new ArrayList<JLabel>();
		ArrayList<JLabel> labelMol = new ArrayList<JLabel>();
		ArrayList<JLabel> labelAmp = new ArrayList<JLabel>();
		ArrayList<JLabel> labelCand = new ArrayList<JLabel>();
		labelSI.add(labelM);
		labelSI.add(labelK);
		labelSI.add(labelS);
		labelSI.add(labelMol);
		labelSI.add(labelKel);
		labelSI.add(labelAmp);
		labelSI.add(labelCand);
		
		//add Controller
		toggle.setText("Natursicht");
		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				if (toggle.getText() == "Natursicht") {
					toggle.setText("log-Sicht");
				} else {
					toggle.setText("Natursicht");
				}
			}
		};
		toggle.addActionListener(actionListener);
		menuePanel.add(toggle);
		
		buttonBack = new JButton(Run.dataLabels("buttonBack"));
		buttonBack.setFocusPainted(false);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonBack) {
					Run.WDF.setVisible(false);
					Run.persistentSaveDimensionlessFactors();
					Run.WRF.setVisible(true);
				}
			}
		});
		menuePanel.add(buttonBack);
		getContentPane().add(menuePanel, BorderLayout.NORTH);
		
		JPanel contentPanel = new JPanel();
		
		contentPanel.setLayout(new GridBagLayout());
		//40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40
		((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] { Run.currentGridSizeLow, Run.currentGridSizeLow,
		Run.currentGridSizeLow, Run.currentGridSizeLow,	Run.currentGridSizeLow,	Run.currentGridSizeLow,	Run.currentGridSizeLow,
		Run.currentGridSizeLow, Run.currentGridSizeLow,	Run.currentGridSizeLow, Run.currentGridSizeLow,	Run.currentGridSizeLow, 
		Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow, 
		Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow,
		Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow,
		Run.currentGridSizeLow, Run.currentGridSizeLow, Run.currentGridSizeLow };
		((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] { 25, 25, 25, 25, 25, };
		
		contentPanel.add(new JLabel("V-Matrix"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		//Spalten-Namen
		for (int i = 0; i < vMatrix[0].length; i++) {
			JTextField textFieldColNamesTemp = new JTextField();
			textFieldColNamesTemp.setMaximumSize(new Dimension(50, 25));
			textFieldColNamesTemp.setPreferredSize(new Dimension(50, 25));
			textFieldColNamesTemp.setColumns(10);
			textFieldColNamesTemp.setText(colNames[i]);
			textFieldColNamesTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(textFieldColNamesTemp, new GridBagConstraints(1 + 3 * i, 0, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 10, 5), 0, 0));

			textFieldColNames.add(textFieldColNamesTemp);
		}
		
		//MinWerte
		contentPanel.add(new JLabel("MinV"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
		GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));

		for (int i = 0; i < vMatrix[0].length; i++) {
			JTextField textFieldMinVTemp = new JTextField();
			textFieldMinVTemp.setMaximumSize(new Dimension(50, 25));
			textFieldMinVTemp.setPreferredSize(new Dimension(50, 25));
			textFieldMinVTemp.setColumns(10);
			textFieldMinVTemp.setText(minV[i]);
			contentPanel.add(textFieldMinVTemp, new GridBagConstraints(1 + 3 * i, 1, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			textFieldMinV.add(textFieldMinVTemp);
			if (i == vMatrix[0].length - 1) {
				buttonRMin = new JButton("R");
				contentPanel.add(buttonRMin, new GridBagConstraints(1 + 3 * i + 3, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			}
		}
		
		//MaxWerte
		contentPanel.add(new JLabel("MaxV"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
		GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JTextField textFieldMaxVTemp = new JTextField();
			textFieldMaxVTemp.setMaximumSize(new Dimension(50, 25));
			textFieldMaxVTemp.setPreferredSize(new Dimension(50, 25));
			textFieldMaxVTemp.setColumns(10);
			textFieldMaxVTemp.setText(maxV[i]);
			
			contentPanel.add(textFieldMaxVTemp, new GridBagConstraints(1 + 3 * i, 2, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			textFieldMaxV.add(textFieldMaxVTemp);
			if (i == vMatrix[0].length - 1) {
				buttonRMax = new JButton("R");
				contentPanel.add(buttonRMax, new GridBagConstraints(1 + 3 * i + 3, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			}
		}
		
		//VMatrix
		for (int i = 0; i < vMatrix.length; i++) {
			
			String tempName = rowNames[i];
			if (i == 0) {
				contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + i, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			} else {
				if (i == vMatrix.length - 1) {
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				} else {
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
				}
			}
			JCheckBox checkBoxVMatrixTemp = new JCheckBox();
			if (i == 0) {
				contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1, 3 + i, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			} else {
				if (i == vMatrix.length - 1) {
					contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1, 3 + i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				} else {
					contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1, 3 + i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
					checkBoxsVMatrix.add(checkBoxVMatrixTemp);
				}
			}
			ArrayList<JTextField> row = new ArrayList<JTextField>();
			for (int j = 0; j < vMatrix[0].length; j++) {
				JTextField vMatrixTextfieldsTemp = new JTextField();
				vMatrixTextfieldsTemp.setMaximumSize(new Dimension(50, 25));
				vMatrixTextfieldsTemp.setPreferredSize(new Dimension(50, 25));
				vMatrixTextfieldsTemp.setColumns(10);
				vMatrixTextfieldsTemp.setText(String.valueOf(vMatrix[i][j]));
				vMatrixTextfieldsTemp.setHorizontalAlignment(SwingConstants.CENTER);
				
				if (i == 0) {
					contentPanel.add(vMatrixTextfieldsTemp, new GridBagConstraints(2 + 3 * j, 3 + i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
				} else {
					if (i == vMatrix.length - 1) {
						contentPanel.add(vMatrixTextfieldsTemp, new GridBagConstraints(2 + 3 * j, 3 + i, 1, 1, 0.0,
						0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
					} else {
						
						contentPanel.add(vMatrixTextfieldsTemp, new GridBagConstraints(2 + 3 * j, 3 + i, 1, 1, 0.0,
						0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
					}
				}
				
				row.add(vMatrixTextfieldsTemp);
			}
			vMatrixTextFields.add(row);
		}
		
		//Lineare Abh�ngigkeits Matrix
		for (int i = 0; i < vMatrix[0].length; i++) {
			String tempName = colNames[i];
			if (i == 0) {
				contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + lengthVMatrix + i, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			} else {
				if (i == vMatrix.length - 1) {
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + lengthVMatrix + i, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				} else {
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + lengthVMatrix + i, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
				}
			}
			ArrayList<JTextField> row = new ArrayList<JTextField>();
			for (int j = 0; j < vMatrix[0].length; j++) {
				JTextField linearDependenceTextFieldsTemp = new JTextField();
				linearDependenceTextFieldsTemp.setMaximumSize(new Dimension(50, 25));
				linearDependenceTextFieldsTemp.setPreferredSize(new Dimension(50, 25));
				linearDependenceTextFieldsTemp.setColumns(10);
				if(i==j)
					linearDependenceTextFieldsTemp.setText(String.valueOf(1));
				else
					linearDependenceTextFieldsTemp.setText(String.valueOf(0));
				linearDependenceTextFieldsTemp.setHorizontalAlignment(SwingConstants.CENTER);
				
				if (i == 0) {
					contentPanel.add(linearDependenceTextFieldsTemp, new GridBagConstraints(2 + 3 * j, 3
					+ lengthVMatrix + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(10, 5, 1, 5), 0, 0));
				} else {
					if (i == vMatrix.length - 1) {
						contentPanel.add(linearDependenceTextFieldsTemp, new GridBagConstraints(2 + 3 * j, 3
						+ lengthVMatrix + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(1, 5, 10, 5), 0, 0));
					} else {
						
						contentPanel.add(linearDependenceTextFieldsTemp, new GridBagConstraints(2 + 3 * j, 3
						+ lengthVMatrix + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(1, 5, 1, 5), 0, 0));
					}
				}
				
				row.add(linearDependenceTextFieldsTemp);
			}
			linearDependenceTextFields.add(row);
		}
		
		//MWerte
		contentPanel.add(new JLabel("M"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JLabel labelMTemp = new JLabel();
			labelMTemp.setMaximumSize(new Dimension(50, 25));
			labelMTemp.setPreferredSize(new Dimension(50, 25));
			labelMTemp.setText(WindowDimensionlessFactors.dimensionlessControlSI[0][i]); //M
			labelMTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelMTemp, new GridBagConstraints(2 + 3 * i, 3 + lengthVMatrix + widthVMatrix, 1, 1, 0.0,
			0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			labelSI.get(0).add(labelMTemp);
		}
		
		//KWerte
		contentPanel.add(new JLabel("K"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix + 1, 1, 1, 0.0,
		0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JLabel labelKTemp = new JLabel();
			labelKTemp.setMaximumSize(new Dimension(50, 25));
			labelKTemp.setPreferredSize(new Dimension(50, 25));
			labelKTemp.setText(WindowDimensionlessFactors.dimensionlessControlSI[1][i]); //K
			labelKTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelKTemp, new GridBagConstraints(2 + 3 * i, 3 + lengthVMatrix + widthVMatrix + 1, 1, 1,
			0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelSI.get(1).add(labelKTemp);
		}
		
		//SWerte
		contentPanel.add(new JLabel("S"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix + 2, 1, 1, 0.0,
		0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JLabel labelSTemp = new JLabel();
			labelSTemp.setMaximumSize(new Dimension(50, 25));
			labelSTemp.setPreferredSize(new Dimension(50, 25));
			labelSTemp.setText(WindowDimensionlessFactors.dimensionlessControlSI[2][i]); //S
			labelSTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelSTemp, new GridBagConstraints(2 + 3 * i, 3 + lengthVMatrix + widthVMatrix + 2, 1, 1,
			0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelSI.get(2).add(labelSTemp);
		}

		//KelWerte
		contentPanel.add(new JLabel("Kel"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix + 3, 1, 1, 0.0,
		0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JLabel labelKelTemp = new JLabel();
			labelKelTemp.setMaximumSize(new Dimension(50, 25));
			labelKelTemp.setPreferredSize(new Dimension(50, 25));
			labelKelTemp.setText(WindowDimensionlessFactors.dimensionlessControlSI[3][i]); //Kel
			labelKelTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelKelTemp, new GridBagConstraints(2 + 3 * i, 3 + lengthVMatrix + widthVMatrix + 3, 1,
			1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelSI.get(3).add(labelKelTemp);
		}
		
		//MolWerte
		contentPanel.add(new JLabel("Mol"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix + 4, 1, 1, 0.0,
		0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JLabel labelMolTemp = new JLabel();
			labelMolTemp.setMaximumSize(new Dimension(50, 25));
			labelMolTemp.setPreferredSize(new Dimension(50, 25));
			labelMolTemp.setText(WindowDimensionlessFactors.dimensionlessControlSI[4][i]); //Mol
			labelMolTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelMolTemp, new GridBagConstraints(2 + 3 * i, 3 + lengthVMatrix + widthVMatrix + 4, 1,
			1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelSI.get(4).add(labelMolTemp);
		}
		
		//AmpWerte
		contentPanel.add(new JLabel("Amp"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix + 5, 1, 1, 0.0,
		0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JLabel labelAmpTemp = new JLabel();
			labelAmpTemp.setMaximumSize(new Dimension(50, 25));
			labelAmpTemp.setPreferredSize(new Dimension(50, 25));
			labelAmpTemp.setText(WindowDimensionlessFactors.dimensionlessControlSI[5][i]); //Amp
			labelAmpTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelAmpTemp, new GridBagConstraints(2 + 3 * i, 3 + lengthVMatrix + widthVMatrix + 5, 1,
			1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
			labelSI.get(5).add(labelAmpTemp);
		}
		
		//CandWerte
		contentPanel.add(new JLabel("Cand"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix + 6, 1, 1, 0.0,
		0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
		for (int i = 0; i < vMatrix[0].length; i++) {
			JLabel labelCandTemp = new JLabel();
			labelCandTemp.setMaximumSize(new Dimension(50, 25));
			labelCandTemp.setPreferredSize(new Dimension(50, 25));
			labelCandTemp.setText(WindowDimensionlessFactors.dimensionlessControlSI[6][i]); //Cand
			labelCandTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(labelCandTemp, new GridBagConstraints(2 + 3 * i, 3 + lengthVMatrix + widthVMatrix + 6, 1,
			1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			labelSI.get(6).add(labelCandTemp);
		}
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JScrollPane scrollpane = new JScrollPane(contentPanel);
		
		getContentPane().add(scrollpane, BorderLayout.CENTER);
	}
	private boolean checkLinearMatrix()
	{
		for(int i=0;i<widthVMatrix;i++){
			for(int j=0;j<widthVMatrix;j++){
//				if(i==j && !linearDependenceTextFields.get(i).get(j).getText().equals("1"))
//					return true;
				if(i!=j && !linearDependenceTextFields.get(i).get(j).getText().equals("0"))
					return true;					
			}
		}		
		return false;
	}
	
}