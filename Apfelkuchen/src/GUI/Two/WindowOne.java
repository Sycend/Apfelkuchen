package GUI.Two;

/**
 * @author Yury Kalinin Window for the selection of
 * the SI name  
 * 20141116
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class WindowOne extends JFrame {

	protected static int windowSize1;
	protected static int windowSize2;

	private JMenu mnuHelp;
	private JMenuItem mnuItemAbout;
	private JMenuBar mb;
	private JComboBox nameBox;
	private JLabel nameLabe;
	private JButton buttonOK;
	private JFrame frame;
	private JPanel panel;
	private String nameOfValue = null;
	private static boolean state = false;

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

		Vector boxDateTemp = new Vector(XMLDate.informationBox("de"));
		boolean state = false;
		nameBox = new JComboBox(boxDateTemp);
		nameBox.setSize(100, 20);
		nameBox.setLocation(300, 90);
		nameBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameBox.setEditable(false);
		nameBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				nameOfValue = (String) cb.getSelectedItem();

			}
		});

		panel.add(nameBox);

		nameLabe = new JLabel();
		nameLabe.setLocation(126, 90);
		nameLabe.setSize(100, 20);
		nameLabe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabe.setText(XMLDate.dateLabels("nameLabel"));
		panel.add(nameLabe);

		buttonOK = new JButton(XMLDate.dateLabels("buttonOk"));
		buttonOK.setFocusPainted(false);
		buttonOK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonOK.setToolTipText(XMLDate.dateLabels("buttonNextTipText"));
		buttonOK.setLocation(120, 180);
		buttonOK.setSize(90, 20);

		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOK) {
					if (nameOfValue == null) {
						JOptionPane.showMessageDialog(frame,
								XMLDate.dateLabels("errorSelection"));
					} else {
						Run.nameOfValue.add(nameOfValue);

						Window windowTwo = new Window(Run.nameOfValue);

						frame.setVisible(false);
					}
				}

			}
		});

		panel.add(buttonOK);

		frame.add(panel);
		frame.setSize(windowSize1, windowSize2);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}
}
