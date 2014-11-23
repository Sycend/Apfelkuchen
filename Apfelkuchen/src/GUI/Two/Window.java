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
		
		super(XMLDate.dateLabels("title"));
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
		((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] { 80, 80, 80, 80, 80, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		
		JMenuBar mb = new JMenuBar();
		
		// ---- labelName ----
		labelName = new JLabel();
		labelName.setText(XMLDate.dateLabels("nameFeld"));
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelName.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelName, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		
		// ---- label Abrevetation ----
		labelAbr = new JLabel();
		labelAbr.setText(" " + "Abkuerzung");
		labelAbr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAbr.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelAbr, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		
		// ---- label Rolle ----
		labelRolle = new JLabel();
		labelRolle.setText(XMLDate.dateLabels("labelRolle"));
		labelRolle.setHorizontalAlignment(SwingConstants.CENTER);
		labelRolle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelRolle, new GridBagConstraints(2, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		
		// ---- label Dimensions ----
		labelDim = new JLabel();
		labelDim.setText(XMLDate.dateLabels("labelDimension"));
		labelDim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelDim.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelDim, new GridBagConstraints(3, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label Einheit----
		labelEinheit = new JLabel();
		labelEinheit.setText(XMLDate.dateLabels("labelSIUnit"));
		labelEinheit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEinheit.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelEinheit, new GridBagConstraints(4, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label low ----
		labelLow = new JLabel();
		labelLow.setText(XMLDate.dateLabels("labelLow") + " ");
		labelLow.setHorizontalAlignment(SwingConstants.CENTER);
		labelLow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelLow, new GridBagConstraints(5, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		
		// ---- label high ----
		labelHigh = new JLabel();
		labelHigh.setText(XMLDate.dateLabels("labelHigh") + " ");
		labelHigh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelHigh.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelHigh, new GridBagConstraints(6, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		
		// ---- label m ----
		labelM = new JLabel();
		labelM.setText("m" + "  ");
		labelM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelM.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelM, new GridBagConstraints(7, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label k ----
		labelK = new JLabel();
		labelK.setText("k");
		labelK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelK.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelK, new GridBagConstraints(8, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label s ----
		labelS = new JLabel();
		labelS.setText("s" + "  ");
		labelS.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelS.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelS, new GridBagConstraints(9, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label kel ----
		labelKel = new JLabel();
		labelKel.setText("kel" + "  ");
		labelKel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelKel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelKel, new GridBagConstraints(10, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label mol ----
		labelMol = new JLabel();
		labelMol.setText("mol" + "  ");
		labelMol.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMol.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelMol, new GridBagConstraints(11, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label amp ----
		labelAmp = new JLabel();
		labelAmp.setText("amp" + "  ");
		labelAmp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAmp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelAmp, new GridBagConstraints(12, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		// ---- label cand ----
		labelCand = new JLabel();
		labelCand.setText("cand" + "  ");
		labelCand.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCand.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelCand, new GridBagConstraints(13, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		
		System.out.println(Run.getNumComp() + " adition");
		
		// ---- label SI-Min ----
		
		labelMinMaxSi = new JLabel();
		labelMinMaxSi.setText(XMLDate.dateLabels("labelSIMin") + " ");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelMinMaxSi, new GridBagConstraints(14, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		// --- label SI Max
		labelMinMaxSi = new JLabel();
		labelMinMaxSi.setText(XMLDate.dateLabels("labelSIMax") + " ");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelMinMaxSi, new GridBagConstraints(15, 13, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
		
		for (int i = 0; i < Run.getNumComp(); i = i + 1) {
			// --- Label Name -----
			JLabel labelName = new JLabel();
			System.out.println(nameOfValue.get(i).toString() + "*");
			
			labelName.setText(nameOfValue.get(i).toString());
			labelName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
			contentPanel.add(labelName, new GridBagConstraints(0, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- Text Field Abrevetation ----
			fieldAbrev = new JTextField();
			if (numExp == 0) {
				fieldAbrev.setEnabled(true);
			} else {
				fieldAbrev.setEnabled(true);
			}
			fieldAbrev.setMinimumSize(new Dimension(80, 20));
			fieldAbrev.setMaximumSize(new Dimension(80, 20));
			contentPanel.add(fieldAbrev, new GridBagConstraints(1, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// --- JComboBox Rolle------
			if (numExp == 0) {
				comboBoxRolle = new JComboBox();
				comboBoxRolle.setEnabled(false);
			} else {
				comboBoxRolle = new JComboBox(Run.getRolle());
				comboBoxRolle.setEnabled(true);
				comboBoxRolle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selectedItem = comboBoxRolle.getSelectedItem();
					}
				});
			}
			contentPanel.add(comboBoxRolle, new GridBagConstraints(2, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
			
			// --- JComboBox Dimensions------
			if (numExp == 0) {
				comboBoxDim = new JComboBox();
				comboBoxDim.setMinimumSize(new Dimension(30, 20));
				comboBoxDim.setPreferredSize(new Dimension(40, 20));
				comboBoxDim.setMaximumSize(new Dimension(40, 20));
				comboBoxDim.setEnabled(false);
			} else {
				comboBoxDim = new JComboBox();
				comboBoxDim.setMinimumSize(new Dimension(40, 20));
				comboBoxDim.setPreferredSize(new Dimension(40, 20));
				comboBoxDim.setMaximumSize(new Dimension(50, 20));
				comboBoxDim.setEnabled(true);
				comboBoxDim.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selectedItem = comboBoxDim.getSelectedItem();
					}
				});
			}
			contentPanel.add(comboBoxDim, new GridBagConstraints(3, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
			
			// --- JComboBox Einheit------
			if (numExp == 0) {
				comboBoxEinheit = new JComboBox();
				comboBoxEinheit.setMinimumSize(new Dimension(30, 20));
				comboBoxEinheit.setPreferredSize(new Dimension(20, 20));
				comboBoxEinheit.setEnabled(false);
			} else {
				comboBoxEinheit = new JComboBox(Run.getUnits());
				comboBoxEinheit.setEnabled(true);
				comboBoxEinheit.setMinimumSize(new Dimension(30, 20));
				comboBoxEinheit.setPreferredSize(new Dimension(20, 20));
				comboBoxEinheit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selectedItem = comboBoxEinheit.getSelectedItem();
					}
				});
			}
			contentPanel.add(comboBoxEinheit, new GridBagConstraints(4, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 0), 0, 0));
			
			// ---- textField Low- ----
			textFieldLow = new JTextField();
			textFieldLow.setMinimumSize(new Dimension(40, 20));
			textFieldLow.setMaximumSize(new Dimension(40, 20));
			textFieldLow.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldLow, new GridBagConstraints(5, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
			
			// ---- textField High----
			textFieldHigh = new JTextField();
			textFieldHigh.setMaximumSize(new Dimension(40, 20));
			textFieldHigh.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldHigh, new GridBagConstraints(6, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
			
			// ---- textField m----
			textFieldM = new JTextField();
			textFieldM.setMaximumSize(new Dimension(40, 20));
			textFieldM.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldM, new GridBagConstraints(7, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField k----
			textFieldK = new JTextField();
			textFieldK.setMaximumSize(new Dimension(20, 20));
			textFieldK.setPreferredSize(new Dimension(20, 20));
			contentPanel.add(textFieldK, new GridBagConstraints(8, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField s----
			textFieldS = new JTextField();
			textFieldS.setMaximumSize(new Dimension(40, 20));
			textFieldS.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldS, new GridBagConstraints(9, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField Kel----
			textFieldKel = new JTextField();
			textFieldKel.setMaximumSize(new Dimension(40, 20));
			textFieldKel.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldKel, new GridBagConstraints(10, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField mol----
			textFieldMol = new JTextField();
			textFieldMol.setMaximumSize(new Dimension(40, 20));
			textFieldMol.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldMol, new GridBagConstraints(11, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField amp----
			textFieldAmp = new JTextField();
			textFieldAmp.setMaximumSize(new Dimension(40, 20));
			textFieldAmp.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldAmp, new GridBagConstraints(12, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			// ---- textField cand----
			textFieldCand = new JTextField();
			textFieldCand.setMaximumSize(new Dimension(40, 20));
			textFieldCand.setPreferredSize(new Dimension(40, 20));
			contentPanel.add(textFieldCand, new GridBagConstraints(13, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			fieldSILow = new JTextField();
			fieldSILow.setMaximumSize(new Dimension(40, 20));
			fieldSILow.setPreferredSize(new Dimension(40, 20));
			if (numExp == 0) {
				fieldSILow.setEnabled(false);
			} else {
				fieldSILow.setEnabled(true);
			}
			
			contentPanel.add(fieldSILow, new GridBagConstraints(14, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
			
			fieldSIHigh = new JTextField();
			fieldSIHigh.setMaximumSize(new Dimension(40, 20));
			textFieldKel.setPreferredSize(new Dimension(40, 20));
			if (numExp == 0) {
				fieldSIHigh.setEnabled(false);
			} else {
				fieldSIHigh.setEnabled(true);
			}
			
			contentPanel.add(fieldSIHigh, new GridBagConstraints(15, 14 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));
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
