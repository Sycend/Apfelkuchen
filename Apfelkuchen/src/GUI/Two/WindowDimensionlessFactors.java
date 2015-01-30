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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
 * @author Florian Then, Dominik Hofmann, Christoph Wütschner
 * @version 1.0.6
 * Window2
 */
public class WindowDimensionlessFactors extends JFrame {
	// serialVersionUID is generated
	private static final long serialVersionUID = 1988266173955497269L;
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
	private JPanel contentPanel;
	private boolean isInit;
	private JToggleButton toggle = new JToggleButton();
	
	/**
	 * Konstruktor für WindowDimensionlessFactors
	 * @param vMatrix
	 * @param rowNames
	 * @param colNames
	 * @param minMax
	 * @param dimensionlessControlSI
	 */
	public WindowDimensionlessFactors(double[][] vMatrix, String[] rowNames, String[] colNames, String[][] minMax,
	String[][] dimensionlessControlSI) {
		
		 ResetValues(vMatrix, rowNames, colNames,  minMax, dimensionlessControlSI,false);
		 
		//Testausgabe um Matrix-Ausmaße zu überprüfen
		System.out.println("lengthVMatrix: " + lengthVMatrix);
		System.out.println("vMatrix[0].length: " + vMatrix[0].length);
		lengthVMatrix = vMatrix.length;
		widthVMatrix = vMatrix[0].length;
		
		setSize(Util.getInstance().currentWidth, Util.getInstance().currentHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(Util.getInstance().getStringFromXML("title"));
		init();
		setVisible(true);
	}
	
	/**
	 * DefaultKonstruktor für WindowDimensionlessFactors
	 */
	public WindowDimensionlessFactors() {
		lengthVMatrix = vMatrix.length;
		widthVMatrix = vMatrix[0].length;
		
		setSize(Util.getInstance().currentWidth, Util.getInstance().currentHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(Util.getInstance().getStringFromXML("title"));
		init();
		setVisible(true);
	}
	
	/**
	 * Init WindowDimensionlessFactors-Content
	 */
	private void init() {
		setLayout(new BorderLayout());
		initMenuePanel();
		initContentPanel();
		isInit=true;
	}
	
	/**
	 * Init WindowDimensionlessFactors-Content auf Contentpanel
	 */
	private void initContentPanel() {
		contentPanel = new JPanel();
		contentPanel.setLayout(new GridBagLayout());
		//40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40
		((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] { Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow,
		Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow,	Util.getInstance().currentGridSizeLow,
		Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow,	Util.getInstance().currentGridSizeLow, 
		Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, 
		Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow,
		Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow,
		Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow, Util.getInstance().currentGridSizeLow };
		((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] { 25, 25, 25, 25, 25, };
		
		contentPanel.add(new JLabel("V-Matrix"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		
		//Spalten-Namen
		for (int i = 0; i < widthVMatrix; i++) {
			JTextField textFieldColNamesTemp = new JTextField();
			textFieldColNamesTemp.setMaximumSize(new Dimension(50, 25));
			textFieldColNamesTemp.setPreferredSize(new Dimension(50, 25));
			textFieldColNamesTemp.setColumns(10);
			textFieldColNamesTemp.setText(colNames[i]);
			textFieldColNamesTemp.setHorizontalAlignment(SwingConstants.CENTER);
			
			contentPanel.add(textFieldColNamesTemp, new GridBagConstraints(1 + 3 * i, 0, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 10, 5), 0, 0));
			if(!isInit)
				textFieldColNames.add(textFieldColNamesTemp);
			else{
				textFieldColNames.set(i,textFieldColNamesTemp);
				System.out.println("***********************");
			//	System.out.println(colNames[i]);
				System.out.println(textFieldColNamesTemp.getText());
			}
				
			
		}
		
		
		//MinWerte
		contentPanel.add(new JLabel("MinV"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
		GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
		
		for (int i = 0; i < widthVMatrix; i++) {
			JTextField textFieldMinVTemp = new JTextField();
			textFieldMinVTemp.setMaximumSize(new Dimension(50, 25));
			textFieldMinVTemp.setPreferredSize(new Dimension(50, 25));
			textFieldMinVTemp.setColumns(10);
			textFieldMinVTemp.setText(minV[i]);
			contentPanel.add(textFieldMinVTemp, new GridBagConstraints(1 + 3 * i, 1, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			textFieldMinV.add(textFieldMinVTemp);
			if (i == widthVMatrix - 1) {
				buttonRMin = new JButton("R");
				contentPanel.add(buttonRMin, new GridBagConstraints(1 + 3 * i + 3, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			}
		}
		
		//MaxWerte
		contentPanel.add(new JLabel("MaxV"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
		GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
		for (int i = 0; i < widthVMatrix; i++) {
			JTextField textFieldMaxVTemp = new JTextField();
			textFieldMaxVTemp.setMaximumSize(new Dimension(50, 25));
			textFieldMaxVTemp.setPreferredSize(new Dimension(50, 25));
			textFieldMaxVTemp.setColumns(10);
			textFieldMaxVTemp.setText(maxV[i]);
			
			contentPanel.add(textFieldMaxVTemp, new GridBagConstraints(1 + 3 * i, 2, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			textFieldMaxV.add(textFieldMaxVTemp);
			if (i == widthVMatrix - 1) {
				buttonRMax = new JButton("R");
				contentPanel.add(buttonRMax, new GridBagConstraints(1 + 3 * i + 3, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
			}
		}
		
		//VMatrix
		for (int i = 0; i < lengthVMatrix; i++) {
			
			String tempName = rowNames[i];
			if (i == 0) {
				contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + i, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			} else {
				if (i == lengthVMatrix - 1) {
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
				if (i == lengthVMatrix - 1) {
					contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1, 3 + i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				} else {
					contentPanel.add(checkBoxVMatrixTemp, new GridBagConstraints(1, 3 + i, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
					checkBoxsVMatrix.add(checkBoxVMatrixTemp);
				}
			}
			ArrayList<JTextField> row = new ArrayList<JTextField>();
			for (int j = 0; j < widthVMatrix; j++) {
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
					if (i == lengthVMatrix - 1) {
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
		
		//Lineare Abhängigkeits Matrix
		for (int i = 0; i < widthVMatrix; i++) {
			String tempName = colNames[i];
			if (i == 0) {
				contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + lengthVMatrix + i, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
			} else {
				if (i == lengthVMatrix - 1) {
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + lengthVMatrix + i, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 10, 5), 0, 0));
				} else {
					contentPanel.add(new JLabel(tempName), new GridBagConstraints(0, 3 + lengthVMatrix + i, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 5, 1, 5), 0, 0));
				}
			}
			ArrayList<JTextField> row = new ArrayList<JTextField>();
			for (int j = 0; j < widthVMatrix; j++) {
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
					if (i == lengthVMatrix - 1) {
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
			if(!isInit)
				linearDependenceTextFields.add(row);
			else
				linearDependenceTextFields.set(i,row);
		}
		
		//MWerte
		contentPanel.add(new JLabel("M"), new GridBagConstraints(0, 3 + lengthVMatrix + widthVMatrix, 1, 1, 0.0, 0.0,
		GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 1, 5), 0, 0));
		for (int i = 0; i < widthVMatrix; i++) {
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
		for (int i = 0; i < widthVMatrix; i++) {
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
		for (int i = 0; i < widthVMatrix; i++) {
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
		for (int i = 0; i < widthVMatrix; i++) {
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
		for (int i = 0; i < widthVMatrix; i++) {
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
		for (int i = 0; i < widthVMatrix; i++) {
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
		for (int i = 0; i < widthVMatrix; i++) {
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
	
	/**
	 * Init WindowDimensionlessFactors-Content auf MenuePanel
	 */
	private void initMenuePanel() {
		JPanel menuePanel = new JPanel();
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		//JMenuItem jmiLoadTMPFile = new JMenuItem("Load from tmp file");
		JMenuItem jmiSave = new JMenuItem("Save to tmp file");
		JMenuItem jmiExit = new JMenuItem("Exit");
		//jmFile.add(jmiLoadTMPFile);
		jmFile.add(jmiSave);
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		/*jmiLoadTMPFile.addActionListener(ae -> {
			System.out.println("Load from tmp file");
			Util.getInstance().restorePersistentDimensionlessFactors();
		});*/
		jmiSave.addActionListener(ae -> {
			System.out.println("Save to tmp file");
			Util.getInstance().persistentSaveDimensionlessFactors();
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
		buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colNamesTextFieldsToColNames();
				for(int i=0;i<widthVMatrix;i++){
					if(checkLinearMatrixForDeleteColumn(i))
					{
						int check=JOptionPane.showConfirmDialog(null, 
                                "Do you wanna Delete this column? "+colNames[i], 
                                "Choose", 
                                JOptionPane.YES_NO_OPTION); 
						if(check==JOptionPane.YES_OPTION)
						{
							colNamesTextFieldsToColNames();
							deleteVMatrixColumn(i);
							refreshWindowContent();
							return;
						}
					}
				}
				if(checkLinearMatrix()){
					System.out.println(linearDependenceTextFields.get(1).get(0).getText());
					ArrayList<ArrayList<JTextField>> vMatrixTextFieldsTemp = vMatrixTextFields;
					vMatrix= new double[lengthVMatrix][widthVMatrix];
					for(int l=0;l<widthVMatrix;l++){
						for(int i=0;i<lengthVMatrix;i++){							
							for(int j=0;j<widthVMatrix;j++){
								vMatrix[i][l]=vMatrix[i][l]+Double.parseDouble((linearDependenceTextFields.get(j).get(l).getText()))*
										Double.parseDouble(vMatrixTextFieldsTemp.get(i).get(j).getText());
							}
						}
					}
					System.out.println("TempArrayList");
					for(int i=0;i<lengthVMatrix;i++){
						ArrayList<JTextField> tempArrayList=new ArrayList<JTextField>();
						for(int j=0;j<widthVMatrix;j++){
							JTextField tempTextField = new JTextField();
							tempTextField.setText(String.valueOf(vMatrix[i][j]));
							tempArrayList.add(tempTextField);
						}
						vMatrixTextFields.set(i,tempArrayList);
					}			
					
					J2R.SingeltonTestMainStart.calculate(false, Menu.callerInstance);
					colNamesTextFieldsToColNames();
					refreshWindowContent();
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(),"Please change the linear Matrix","No change !",  JOptionPane.INFORMATION_MESSAGE);
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
		
		buttonBack = new JButton(Util.getInstance().getStringFromXML("buttonBack"));
		buttonBack.setFocusPainted(false);
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonBack) {
					Menu.WDF.setVisible(false);
					//Util.getInstance().persistentSaveDimensionlessFactors();
					Menu.WRF.setVisible(true);
				}
			}
		});
		menuePanel.add(buttonBack);
		getContentPane().add(menuePanel, BorderLayout.NORTH);
	}
	
	/**
	 * Colnames in Textfields in Colnames in ColnamesArray
	 */
	private void colNamesTextFieldsToColNames() {
		for (int i = 0; i < colNames.length; i++) {
			colNames[i] = textFieldColNames.get(i).getText();
		}
	}
	
	/**
	 * check LinearMatrix
	 * isLinearMatrix changed?
	 * @return boolean für Check
	 */
	private boolean checkLinearMatrix() {
		boolean isDiagonalOK = true;
		boolean isRestOK = false;
		for (int i = 0; i < widthVMatrix; i++) {
			for (int j = 0; j < widthVMatrix; j++) {
				if (i == j && !linearDependenceTextFields.get(i).get(j).getText().equals("1") && isDiagonalOK == true)
					isDiagonalOK = false;
				if (i != j && !linearDependenceTextFields.get(i).get(j).getText().equals("0") && isRestOK == false)
					isRestOK = true;
			}
		}
		if (isDiagonalOK == true && isRestOK == true)
			return true;
		return false;
	}
	/**
	 * checks given column:
	 * is the column deleteable?
	 * @param column
	 * 	selected column for check
	 * @return
	 */
	private boolean checkLinearMatrixForDeleteColumn(int column) {
		boolean isDeleteable = true;
		for (int i = 0; i < widthVMatrix; i++) {
			if (!linearDependenceTextFields.get(column).get(i).getText().equals("0")) {
				isDeleteable = false;
			}
		}
		
		return isDeleteable;
	}
	/**
	 * refresh WindowContent:
	 * -	MenuePanel
	 * -	ContentPanel
	 */
	private void refreshWindowContent()
	{
		getContentPane().removeAll();
		
		initMenuePanel();
		initContentPanel();
		
		getContentPane().revalidate();
		getContentPane().repaint();
		setVisible(true);
	}
	/**
	 * delete the given column(dimensionless-factor)
	 * @param column
	 * 	column which will get deleted
	 */
	private void deleteVMatrixColumn(int column) {
		for (int col = column; col < widthVMatrix - 1; col++) {
			for (int i = 0; i < widthVMatrix; i++) {
				vMatrix[i][col] = vMatrix[i][col + 1];
			}
			colNames[col] = colNames[col + 1];
			minV[col] = minV[col + 1];
			maxV[col] = maxV[col + 1];
			for (int j = 0; j < 7; j++) {
				dimensionlessControlSI[j][col] = dimensionlessControlSI[j][col];
			}
		}
		widthVMatrix--;
		refreshWindowContent();
	}
	/**
	 * This mehtode sets the internal values to the ones recived in the Attribute list.
	 * @param vMatrix - the VMatrix as double array
	 * @param rowNames - the RowNames of the VMatrix as String array
	 * @param colNames - the ColNames of the VMatrix as String array
	 * @param minMax - the values for MinMax as String Matrix [min][max] 
	 * @param dimensionlessControlSI - the control if the matrix is demensionless
	 * @param refresh - should the window be refreshed 
	 */
	public void ResetValues(double[][] vMatrix, String[] rowNames, String[] colNames, String[][] minMax, String[][] dimensionlessControlSI, boolean refresh) {
		
		WindowDimensionlessFactors.vMatrix = vMatrix;
		WindowDimensionlessFactors.rowNames = rowNames;
		WindowDimensionlessFactors.colNames = colNames;
		
		lengthVMatrix = vMatrix.length;
		widthVMatrix = vMatrix[0].length;
		
		for(int i = 0; i < colNames.length; i++ )
		System.out.println("++++++++++++++++++++++++++++++++++++"+colNames[i]);
		
		minV = new String[minMax.length];
		maxV = new String[minMax.length];
		for (int i = 0; i < minMax.length; i++) {
			minV[i] = minMax[i][0];
			maxV[i] = minMax[i][1];
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
		
		if (refresh)
			refreshWindowContent();
	}
	
	public static double[][] getVMatrix() {
		
		return WindowDimensionlessFactors.vMatrix;
		
	}
	
	public static String[] getVMatrixRowNames() {
		
		return WindowDimensionlessFactors.rowNames;
	}
	
	public static String[] getVMatrixColNames() {
		
		return WindowDimensionlessFactors.colNames;
	}
}