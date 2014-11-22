package GUI.Two;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
//import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Window extends JFrame {

	JScrollPane scrollpane;
	private JButton buttonRemove;
	private JButton buttonOk;
	private JButton buttonNext;
	private JButton buttonNewField;
	private JLabel labelName;
	private JLabel labelLow;
	private JLabel labelHigh;
	private JLabel labelRolle;
	private JLabel labelEinheit;
	private JLabel labelM;
	private JLabel labelK;
	private JLabel labelS;
	private JLabel labelKel;
	private JLabel labelMol;
	private JLabel labelAmp;
	private JLabel labelCand;
	private JLabel expTitle;
	private JLabel labelAbr;
	private JLabel labelMinMaxSi;
	private JLabel labelAbrev;
	private JLabel labelDim;
	private JTextField labelNameofValue;
	private JTextField textFieldM;
	private JTextField textFieldK;
	private JTextField textFieldS;
	private JTextField textFieldKel;
	private JTextField textFieldMol;
	private JTextField textFieldAmp;
	private JTextField textFieldCand;
	private JTextField textFieldLow;
	private JTextField textFieldHigh;
	private JTextField fieldAbrev;
	private JTextField fieldSILow;
	private JTextField fieldSIHigh;
	private JTextField fieldExpon;
	private JComboBox comboBoxRolle;
	private JComboBox comboBoxEinheit;
	private JComboBox comboBoxDim;
	private int numExp;
	private String nameValue;


	public Window() {

		super("Tile");
		setSize(1194, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		numExp = Run.getNumExp();
		init();
		setVisible(true);
	}

	public void init() {

		int numberOfComp = 0;
		Vector nameOfValue = new Vector();
		nameOfValue = Run.getNameOfValue();

		setVisible(false);// Window widow =new Window();
		JComboBox form = new JComboBox();

		JPanel contentPanel = new JPanel();
		contentPanel.setSize(100, 100);

		// ======== contentPanel ========

		contentPanel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.setLayout(new GridBagLayout());
		((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {
				0, 66, 66, 134, 0 };
		((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] { 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

		JMenuBar mb = new JMenuBar();

		// ---- labelName ----
		labelName = new JLabel();
		labelName.setText(XMLDate.dateLabels("nameFeld"));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelName, new GridBagConstraints(0, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		
		// ---- label Abrevetation ----
		labelAbr = new JLabel();
		labelAbr.setText(" " + "Abkuerzung");
		labelAbr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAbr.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelAbr, new GridBagConstraints(1, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Rolle ---- 
		labelRolle = new JLabel();
		labelRolle.setText("Rolle");
		labelRolle.setHorizontalAlignment(SwingConstants.CENTER);
		labelRolle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelRolle, new GridBagConstraints(2, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		
		// ---- label Dimensions ----
		labelDim = new JLabel();
		labelDim.setText("Dimension");
		labelDim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDim.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelDim, new GridBagConstraints(3, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label Einheit----
		labelEinheit = new JLabel();
		labelEinheit.setText("Einheit");
		labelEinheit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEinheit.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelEinheit, new GridBagConstraints(4, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label low ----
		labelLow = new JLabel();
		labelLow.setText("Low");
		labelLow.setHorizontalAlignment(SwingConstants.CENTER);
		labelLow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelLow, new GridBagConstraints(5, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label high ----
		labelHigh = new JLabel();
		labelHigh.setText("high");
		labelHigh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelHigh.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelHigh, new GridBagConstraints(6, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label m ----
		labelM = new JLabel();
		labelM.setText("m");
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
		labelS.setText("s");
		labelS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelS.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelS, new GridBagConstraints(9, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));
		
		// ---- label kel ----
		labelKel = new JLabel();
		labelKel.setText("kel");
		labelKel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelKel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelKel, new GridBagConstraints(10, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));
		
		// ---- label mol ----
		labelMol = new JLabel();
		labelMol.setText("mol");
		labelMol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMol.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelMol, new GridBagConstraints(11, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));
		
		// ---- label amp ----
		labelAmp = new JLabel();
		labelAmp.setText("amp");
		labelAmp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAmp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelAmp, new GridBagConstraints(12, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));
		
		// ---- label cand ----
		labelCand = new JLabel();
		labelCand.setText("cand");
		labelCand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCand.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelCand, new GridBagConstraints(13, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		System.out.println(Run.getNumComp() + " adition");
		for (int i = 0; i < Run.getNumComp(); i = i + 1) {
			// --- Label Name -----
			JLabel labelName = new JLabel();
			System.out.println(nameOfValue.get(i).toString() + "*");

			labelName.setText(nameOfValue.get(i).toString());
			labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));

			contentPanel.add(labelName, new GridBagConstraints(0, 14 + i, 1, 1,
					0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			// ---- Text Field Abrevetation ----
			fieldAbrev = new JTextField();
			if (numExp == 0) {
				fieldAbrev.setEnabled(false);
			} else {
				fieldAbrev.setEnabled(true);
			}
			fieldAbrev.setMinimumSize(new Dimension(80, 20));
			fieldAbrev.setMaximumSize(new Dimension(80, 20));
			contentPanel.add(fieldAbrev, new GridBagConstraints(1, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			// --- JComboBox Rolle------
			if (numExp == 0) {
				comboBoxRolle = new JComboBox();
				comboBoxRolle.setEnabled(false);
			} else {
				comboBoxRolle = new JComboBox();
				comboBoxRolle.setEnabled(true);
				comboBoxRolle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						Object selectedItem = comboBoxRolle.getSelectedItem();
						}
				});
				}	
			contentPanel.add(comboBoxRolle, new GridBagConstraints(2, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
						
			// --- JComboBox Dimensions------
			if (numExp == 0) {
				comboBoxDim = new JComboBox();
				comboBoxDim.setEnabled(false);
			} else {
				comboBoxDim = new JComboBox();
				comboBoxDim.setEnabled(true);
				comboBoxDim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object selectedItem = comboBoxDim.getSelectedItem();
				}
				});
			}
			contentPanel.add(comboBoxDim, new GridBagConstraints(3, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
			
			// --- JComboBox Einheit------
			if (numExp == 0) {
				comboBoxEinheit = new JComboBox();
				comboBoxEinheit.setEnabled(false);
			} else {
				comboBoxEinheit = new JComboBox();
				comboBoxEinheit.setEnabled(true);
				comboBoxEinheit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object selectedItem = comboBoxEinheit.getSelectedItem();
				}
				});
			}
			contentPanel.add(comboBoxEinheit, new GridBagConstraints(4, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
						
			// ---- textField Low- ----
			textFieldLow = new JTextField();
			textFieldLow.setMinimumSize(new Dimension(70, 20));
			textFieldLow.setMaximumSize(new Dimension(70, 20));
			contentPanel.add(textFieldLow, new GridBagConstraints(5, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			// ---- textField High----
			textFieldHigh = new JTextField();
			textFieldHigh.setMaximumSize(new Dimension(70, 20));
			textFieldHigh.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldHigh, new GridBagConstraints(6, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField m----
			textFieldM = new JTextField();
			textFieldM.setMaximumSize(new Dimension(70, 20));
			textFieldM.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldM, new GridBagConstraints(7, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField k----
			textFieldK = new JTextField();
			textFieldK.setMaximumSize(new Dimension(70, 20));
			textFieldK.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldK, new GridBagConstraints(8, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField s----
			textFieldS = new JTextField();
			textFieldS.setMaximumSize(new Dimension(70, 20));
			textFieldS.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldS, new GridBagConstraints(9, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField Kel----
			textFieldKel = new JTextField();
			textFieldKel.setMaximumSize(new Dimension(70, 20));
			textFieldKel.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldKel, new GridBagConstraints(10, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField mol----
			textFieldMol = new JTextField();
			textFieldMol.setMaximumSize(new Dimension(70, 20));
			textFieldMol.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldMol, new GridBagConstraints(11, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField amp----
			textFieldAmp = new JTextField();
			textFieldAmp.setMaximumSize(new Dimension(70, 20));
			textFieldAmp.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldAmp, new GridBagConstraints(12, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField cand----
			textFieldCand = new JTextField();
			textFieldCand.setMaximumSize(new Dimension(70, 20));
			textFieldCand.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldCand, new GridBagConstraints(13, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			// ---- end of contentpanel Centre ------
		}

		JPanel p2 = new JPanel();
		
		buttonNewField = new JButton(XMLDate.dateLabels("buttonNewField"));
		if (numExp == 0) {
			buttonNewField.setEnabled(true);
		} else {
			buttonNewField.setEnabled(false);
		}
		buttonNewField.setFocusPainted(false);
		buttonNewField.setSize(110, 20);
		buttonNewField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNewField) {
					Run.changeNumComp();
					WindowOne window = new WindowOne();
					window.initWindowOne();
					System.out.println("qw");
					setVisible(false);
					Window windowTwo = new Window();

				}
			}
		});

		p2.add(buttonNewField);

		buttonRemove = new JButton(XMLDate.dateLabels("buttonRemove"));
		if (numExp == 0) {
			buttonRemove.setEnabled(true);
		} else {
			buttonRemove.setEnabled(false);
		}
		buttonRemove.setFocusPainted(false);
		buttonRemove.setSize(110, 20);
		buttonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonRemove) {
					Run.remove();
					setVisible(false);
					Window window = new Window();
				}
			}
		});
		p2.add(buttonRemove);
		
		if (numExp == 0) {
			buttonOk = new JButton(XMLDate.dateLabels("buttonOkStart"));
		} else {
			buttonOk = new JButton(XMLDate.dateLabels("buttonOkExp"));
		}
		buttonOk.setFocusPainted(false);
		buttonOk.setSize(110, 20);
		buttonOk.setLocation(16, 16);
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOk) {
					Run.changeNumExp();
					setVisible(false);
					Window window = new Window();

				}
			}
		});
		p2.add(buttonOk);

		buttonNext = new JButton(XMLDate.dateLabels("buttonNext"));
		buttonNext.setFocusPainted(false);
		if (numExp == 0) {
			buttonNext.setEnabled(false);
		} else {
			buttonNext.setEnabled(true);
		}
		buttonNext.setSize(110, 20);
		buttonNext.setLocation(16, 16);
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNext) {

					setVisible(false);
					WindowOptim window = new WindowOptim();
					window.setWindow();

				}
			}
		});
		p2.add(buttonNext);	
		getContentPane().add(p2, BorderLayout.SOUTH);
		
		JPanel p4 = new JPanel();
		expTitle = new JLabel();
		expTitle.setText(Window.getExpTitle());
		expTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		expTitle.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(expTitle);
		getContentPane().add(p4, BorderLayout.NORTH);

		scrollpane = new JScrollPane(contentPanel);

		getContentPane().add(scrollpane, BorderLayout.CENTER);
		// --- content Panel East
		JPanel contentPanelEST = new JPanel();
		contentPanelEST.setSize(100, 100);
		contentPanelEST.setLayout(new GridBagLayout());
		((GridBagLayout) contentPanelEST.getLayout()).columnWidths = new int[] {
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanelEST.getLayout()).rowHeights = new int[] {
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanelEST.getLayout()).columnWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		((GridBagLayout) contentPanelEST.getLayout()).rowWeights = new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

		// ---- label SI-Min ----

		labelMinMaxSi = new JLabel();
		labelMinMaxSi.setText("SI-Low");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanelEST.add(labelMinMaxSi, new GridBagConstraints(9, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		// --- label SI Max
		labelMinMaxSi = new JLabel();
		labelMinMaxSi.setText("SI_High");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanelEST.add(labelMinMaxSi, new GridBagConstraints(10, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		for (int i = 0; i < Run.getNumComp(); i = i + 1) {

			fieldSILow = new JTextField();
			if (numExp == 0) {
				fieldSILow.setEnabled(false);
			} else {
				fieldSILow.setEnabled(true);
			}
			fieldSILow.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanelEST.add(fieldSILow, new GridBagConstraints(9, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			fieldSIHigh = new JTextField();
			if (numExp == 0) {
				fieldSIHigh.setEnabled(false);
			} else {
				fieldSIHigh.setEnabled(true);
			}
			fieldSIHigh.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanelEST.add(fieldSIHigh, new GridBagConstraints(10, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			for (int j = 0; j < Run.getNumComp(); j++) {

				fieldExpon = new JTextField();
				if (numExp == 0) {
					fieldExpon.setEnabled(false);
				} else {
					fieldExpon.setEnabled(true);
				}
				fieldExpon.setFont(new Font("Tahoma", Font.PLAIN, 16));
				contentPanelEST.add(fieldExpon, new GridBagConstraints(12 + j,
						14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			}

		}
		scrollpane = new JScrollPane(contentPanelEST);
		getContentPane().add(scrollpane, BorderLayout.EAST);
	}

	private static String getExpTitle() {
		int number = Run.getNumExp();
		if (number > 0) {
			return XMLDate.dateLabels("experimentLabel") + number;
		} else {
			return "";
		}
	}

}
