package GUI;
/**
 * @author Yury Kalinin
 * creating of window, setting of positions of components, 
 * listener for buttons
 *
 */
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

public class Window extends JFrame {

	protected static int windowSize1;
	protected static int windowSize2;
	
	private JMenu mnuHelp;
	private JMenuItem mnuItemAbout;
	private JMenuBar mb;
	private JLabel counterNumber;
	private JLabel experimentLabel;
	private JLabel resultsLabel;
	private JLabel temperatureLabel;
	private JLabel timeLabel;
	private JLabel heightLabel;
	private JLabel diameterLabel;
	private JTextField temperatureField;
	private JTextField timeField;
	private JTextField diameterField;
	private JTextField heightField;
	private JButton buttonOk;
	private JButton buttonNext;
	private JTextField resultsField;
	private JSlider slider;
	private JComboBox diameterBox;
	private JComboBox heightBox;
	private JComboBox temperatureBox;
	private JComboBox timeBox;
	private JFrame frame;
	private JPanel panel;
	private JButton newExperiment;
	private int counter = 1;

	public void setWindow(int windowSize1, int windowSize2) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		frame = new JFrame(XMLDate.dateLabels("title"));
		frame.setLocation(30, 30);
		panel = new JPanel();
		panel.setLayout(null);

		JMenuBar mb = new JMenuBar();
		JMenu mnuHelp = new JMenu(XMLDate.dateLabels("mnuHelp")); // Help Menu
																	// entry
		JMenuItem mnuItemAbout = new JMenuItem(
				XMLDate.dateLabels("mnuItemAbout")); // About Entry
		frame.setJMenuBar(mb);
		mnuHelp.add(mnuItemAbout); // Create About line
		mb.add(mnuHelp);
		mnuHelp.add(mnuItemAbout); // Create About line
		mb.add(mnuHelp);

		Vector BoxDate = XMLDate.informationBox("temperature");
		temperatureBox = new JComboBox(BoxDate);
		temperatureBox.setSize(100, 20);
		temperatureBox.setLocation(300, 120);
		temperatureBox.setEditable(false);
		panel.add(temperatureBox);

		temperatureLabel = new JLabel();
		temperatureLabel.setLocation(126, 120);
		temperatureLabel.setSize(100, 20);
		temperatureLabel.setText(XMLDate.dateLabels("temperature"));
		panel.add(temperatureLabel);

		temperatureField = new JTextField("", 50);
		temperatureField.setLocation(243, 120);
		temperatureField.setSize(50, 20);
		temperatureField.setText("");
		panel.add(temperatureField);

		timeLabel = new JLabel();
		timeLabel.setLocation(126, 160);
		timeLabel.setSize(50, 20);
		timeLabel.setText(XMLDate.dateLabels("time"));
		panel.add(timeLabel);

		timeField = new JTextField("", 50);
		timeField.setLocation(243, 160);
		timeField.setSize(50, 20);
		timeField.setText("");
		panel.add(timeField);

		BoxDate = XMLDate.informationBox("time");
		timeBox = new JComboBox(BoxDate);
		timeBox.setLocation(300, 160);
		timeBox.setSize(100, 20);
		timeBox.setEditable(false);
		panel.add(timeBox);

		buttonOk = new JButton(XMLDate.dateLabels("buttonOk"));
		buttonOk.setFocusPainted(false);
		buttonOk.setToolTipText(XMLDate.dateLabels("buttonOKTipText"));
		buttonOk.setLocation(220, 400);
		buttonOk.setSize(110, 20);
		buttonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOk) {
					counter++;
					frame.setVisible(false);

					setWindow(1194, 550);

				}
			}
		});
		panel.add(buttonOk);

		buttonNext = new JButton(XMLDate.dateLabels("buttonNext"));
		buttonNext.setFocusPainted(false);
		buttonNext.setToolTipText(XMLDate.dateLabels("buttonNextTipText"));
		buttonNext.setLocation(120, 400);
		buttonNext.setSize(90, 20);
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNext) {

				}
			}
		});
		panel.add(buttonNext);

		diameterLabel = new JLabel();
		diameterLabel.setLocation(126, 200);
		diameterLabel.setSize(80, 20);
		diameterLabel.setText(XMLDate.dateLabels("diameter"));
		panel.add(diameterLabel);

		diameterField = new JTextField();
		diameterField.setLocation(243, 200);
		diameterField.setSize(50, 20);
		diameterField.setText("");
		panel.add(diameterField);
		// Box for diameter
		BoxDate = XMLDate.informationBox("diameter");
		diameterBox = new JComboBox(BoxDate);
		diameterBox.setLocation(300, 200);
		diameterBox.setSize(100, 20);
		diameterBox.setEditable(false);
		panel.add(diameterBox);

		heightLabel = new JLabel();
		heightLabel.setLocation(126, 240);
		heightLabel.setSize(80, 20);
		heightLabel.setText(XMLDate.dateLabels("height"));
		panel.add(heightLabel);

		heightField = new JTextField();
		heightField.setLocation(243, 240);
		heightField.setSize(50, 20);
		heightField.setText("");
		panel.add(heightField);

		// Box for diameter
		BoxDate = XMLDate.informationBox("height");
		heightBox = new JComboBox(BoxDate);
		heightBox.setLocation(300, 240);
		heightBox.setSize(100, 20);
		heightBox.setEditable(false);
		panel.add(heightBox);

		resultsLabel = new JLabel();
		resultsLabel.setLocation(126, 280);
		resultsLabel.setSize(90, 30);
		resultsLabel.setText(XMLDate.dateLabels("results"));
		panel.add(resultsLabel);

		// creating of evolutions slider
		slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setLocation(240, 270);
		slider.setSize(50, 60);
		slider.setLabelTable(slider.createStandardLabels(10));
		int resultsValue = slider.getValue();
		// creat Listener for JSlider.
		SliderListener slListener = new SliderListener();
		slider.addChangeListener(slListener);
		panel.add(slider);
		String resultsValueStr = String.valueOf(slListener.getSliderValue());

		// creatig results evolutions field. we get value from slider

		resultsField = new JTextField("", 50);
		resultsField.setLocation(320, 280);
		resultsField.setSize(50, 20);
		resultsField.setText(resultsValueStr); // FIX this
		panel.add(resultsField);

		experimentLabel = new JLabel();
		experimentLabel.setFont(new Font("Arial", 18, 18));
		experimentLabel.setLocation(500, 30);
		experimentLabel.setSize(200, 20);
		experimentLabel.setText(XMLDate.dateLabels("experiment"));
		panel.add(experimentLabel);

		// counter for number of experiments
		counterNumber = new JLabel();
		counterNumber.setFont(new Font("Arial", 18, 18));
		counterNumber.setLocation(700, 30);
		counterNumber.setSize(50, 20);
		counterNumber.setText(String.valueOf(counter));
		panel.add(counterNumber);

		frame.add(panel);
		frame.setSize(windowSize1, windowSize2);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

}
