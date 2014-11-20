package GUI.Two;

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

public class WindowOptim extends JFrame {

	private JMenu mnuHelp;
	private JMenuItem mnuItemAbout;
	private JMenuBar mb;

	private JButton buttonNewStart;
	private JFrame frame;
	private JPanel panel;

	public void setWindow() {
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

		buttonNewStart = new JButton(XMLDate.dateLabels("buttonNewStart"));
		buttonNewStart.setFocusPainted(false);
		buttonNewStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonNewStart.setToolTipText(XMLDate.dateLabels("buttonNextTipText"));
		buttonNewStart.setLocation(500, 400);
		buttonNewStart.setSize(150, 20);
		buttonNewStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonNewStart) {
					Run.changeNumExp(0);

					frame.setVisible(false);
					Window window = new Window();

				}
			}
		});
		panel.add(buttonNewStart);

		frame.add(panel);
		frame.setSize(1194, 550);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

}
