package GUI.Two;

/**
 * @author Yury Kalinin Main Window
 * 
 * 20141116
 *
 */
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
	private JLabel labelNameofValue;
	private JTextField textFieldMin;
	private JTextField textFieldMax;
	private JComboBox comboBoxSi;

	private int numExp;

	public Window(Vector nameOfValue) {

		super(XMLDate.dateLabels("title"));
		setSize(1194, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		numExp = Run.getNumExp();
		init(nameOfValue);
		setVisible(true);
	}

	public void init(Vector nameOfValue) {
		int numberOfComp = nameOfValue.size();
		JComboBox form = new JComboBox();

		JPanel contentPanel = new JPanel();
		contentPanel.setSize(600, 400);

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
		contentPanel.add(labelName, new GridBagConstraints(0, 11, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Min ----
		labelMin = new JLabel();
		labelMin.setText("Min");
		labelMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelMin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPanel.add(labelMin, new GridBagConstraints(1, 11, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label Max ----
		labelMax = new JLabel();
		labelMax.setText("Max");
		labelMax.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelMax.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelMax, new GridBagConstraints(2, 11, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

		// ---- label SI ----
		labelSI = new JLabel();
		labelSI.setText("SI");
		labelSI.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSI.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelSI, new GridBagConstraints(3, 11, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 5, 0), 0, 0));

		int index = 0;
		for (int i = 0; i < numberOfComp; i = i + 1) {

			// ---- labelNameofValue----
			labelNameofValue = new JLabel();
			labelNameofValue.setText(nameOfValue.get(i).toString());
			labelNameofValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
			labelNameofValue.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(labelNameofValue, new GridBagConstraints(0,
					12 + i, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			// ---- textFieldMin ----
			textFieldMin = new JTextField();
			if (numExp == 0) {
				textFieldMin.setEnabled(false);
			} else {
				textFieldMin.setEnabled(true);
			}
			textFieldMin.setMinimumSize(new Dimension(80, 20));
			contentPanel.add(textFieldMin, new GridBagConstraints(1, 12 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			// ---- textFieldMax ----
			textFieldMax = new JTextField();
			if (numExp == 0) {
				textFieldMax.setEnabled(false);
			} else {
				textFieldMax.setEnabled(true);
			}
			textFieldMax.setMinimumSize(new Dimension(80, 20));
			contentPanel.add(textFieldMax, new GridBagConstraints(2, 12 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

			if (numExp == 0) {
				comboBoxSi = new JComboBox();

				comboBoxSi.setEnabled(false);
			} else {
				// System.out.println(nameOfValue.get(i).toString());
				comboBoxSi = new JComboBox(XMLDate.informationBoxSI("de",
						nameOfValue.get(i).toString()));
				comboBoxSi.setEnabled(true);
			}
			contentPanel.add(comboBoxSi, new GridBagConstraints(3, 12 + i, 1,
					1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

			// ---- end of contentpanel ------
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
					WindowOne windowOne = new WindowOne();

					windowOne.setWindow(1194, 550);

					setVisible(false);
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
					Window window = new Window(Run.nameOfValue);

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
					Window window = new Window(Run.nameOfValue);

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
