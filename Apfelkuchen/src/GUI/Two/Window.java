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
import javax.swing.JMenuBar;
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
	private JLabel labelMin;
	private JLabel labelMax;
	private JLabel labelSI;
	private JLabel expTitle;
	private JTextField labelNameofValue;
	private JTextField textFieldMin;
	private JTextField textFieldMax;
	private JComboBox comboBoxSi;
	private JTextField fieldAbrev;
	private JLabel labelAbr;
	private JLabel labelMinMaxSi;
	private JTextField fieldSIMin;
	private int numExp;
	private String nameValue;
	private JTextField fieldSIMax;
	private JTextField fieldExpon;
	private JLabel labelAbrev;

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

		// ---- label Min ----
		labelMin = new JLabel();
		labelMin.setText("Min");
		labelMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelMin, new GridBagConstraints(2, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Max ----
		labelMax = new JLabel();
		labelMax.setText("Max");
		labelMax.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMax.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelMax, new GridBagConstraints(3, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label SI ----
		labelSI = new JLabel();
		labelSI.setText("SI");
		labelSI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSI.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelSI, new GridBagConstraints(4, 13, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));
		// ---- label Abrevetation ----
		labelAbr = new JLabel();
		labelAbr.setText(" " + "Abkuerzung");
		labelAbr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelAbr.setHorizontalAlignment(SwingConstants.LEFT);
		contentPanel.add(labelAbr, new GridBagConstraints(1, 13, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

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

			// ---- textField Low- ----
			textFieldMin = new JTextField();
			if (numExp == 0) {
				textFieldMin.setEnabled(false);
			} else {
				textFieldMin.setEnabled(true);
			}
			textFieldMin.setMinimumSize(new Dimension(70, 20));
			textFieldMin.setMaximumSize(new Dimension(70, 20));
			contentPanel.add(textFieldMin, new GridBagConstraints(2, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			// ---- textField High----
			textFieldMax = new JTextField();
			if (numExp == 0) {
				textFieldMax.setEnabled(false);
			} else {
				textFieldMax.setEnabled(true);
			}

			textFieldMax.setMaximumSize(new Dimension(70, 20));
			textFieldMax.setPreferredSize(new Dimension(70, 20));
			contentPanel.add(textFieldMax, new GridBagConstraints(3, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			if (numExp == 0) {
				comboBoxSi = new JComboBox();

				comboBoxSi.setEnabled(false);
			} else {
				// System.out.println(nameOfValue.get(i).toString());
				comboBoxSi = new JComboBox();
				comboBoxSi.setEnabled(true);
				comboBoxSi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object selectedItem = comboBoxSi.getSelectedItem();

					}
				});
			}
			contentPanel.add(comboBoxSi, new GridBagConstraints(4, 14 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
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

			// ---- end of contentpanel Centre ------
		}

		JPanel p3 = new JPanel();

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

		p3.add(buttonNewField);

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
		p3.add(buttonRemove);
		getContentPane().add(p3, BorderLayout.WEST);

		JPanel p2 = new JPanel();
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
		labelMinMaxSi.setText("Minimum");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanelEST.add(labelMinMaxSi, new GridBagConstraints(9, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
		// --- label SI Max
		labelMinMaxSi = new JLabel();
		labelMinMaxSi.setText("Maximum");
		labelMinMaxSi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanelEST.add(labelMinMaxSi, new GridBagConstraints(10, 13, 1, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		for (int i = 0; i < Run.getNumComp(); i = i + 1) {

			fieldSIMin = new JTextField();
			if (numExp == 0) {
				fieldSIMin.setEnabled(false);
			} else {
				fieldSIMin.setEnabled(true);
			}
			fieldSIMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanelEST.add(fieldSIMin, new GridBagConstraints(9, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			fieldSIMax = new JTextField();
			if (numExp == 0) {
				fieldSIMax.setEnabled(false);
			} else {
				fieldSIMax.setEnabled(true);
			}
			fieldSIMax.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanelEST.add(fieldSIMax, new GridBagConstraints(10, 14 + i,
					1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			labelAbrev = new JLabel();
			labelAbrev.setText("Abkuerzug");
			labelAbrev.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPanelEST.add(labelAbrev, new GridBagConstraints(12 + i, 13,
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
