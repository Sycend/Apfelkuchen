package GUI.Two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import J2R.*;

/**
 * MainMenu
 * @author Sycend, Yuri Kalinin, Dominik Hofmann, Christoph Wütschner
 * @version 2.2.0
 */
public class Menu implements ActionListener {
	private JFrame mainMenuWindow = new JFrame("Main Menu");
	protected static WindowRelevantFactors WRF;
	public static WindowDimensionlessFactors WDF; //public because J2R needs to access it
	protected static J2R callerInstance = J2R.getInstance();
	
	public static void main(String args[]) {
		new Menu();
		new Thread(() -> {
			Util.getInstance().readCSV(Util.getInstance().CSV_FILENAME);
			Util.getInstance().readUserCSV(Util.getInstance().USER_CSV_FILENAME);
		}).start();
	}
	
	Menu() {
		mainMenuWindow.setSize(740, 440);
		mainMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiNew = new JMenuItem("New");
		JMenuItem jmiExit = new JMenuItem("Exit");
		JLabel label1 = new JLabel("Welcome, thanks for using our product.");
		mainMenuWindow.add(label1);
		jmFile.add(jmiNew);
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		
		JMenu jmOptions = new JMenu("Options");
		JMenuItem settingPathTestCase = new JMenuItem("Set Path for TestCase.csv");
		JMenuItem settingPathRelevantFactorstmp = new JMenuItem("Set Path for RelevantFactors.tmp file");
		JMenuItem settingPathDimensionlessFactorstmp = new JMenuItem("Set Path for DimensionlessFactors.tmp file");
		//add option to autoload tmp file
		jmOptions.add(settingPathTestCase);
		jmOptions.add(settingPathRelevantFactorstmp);
		jmOptions.add(settingPathDimensionlessFactorstmp);
		
		jmb.add(jmOptions);
		
		JMenu jmHelp = new JMenu("Help");
		JMenuItem jmiAbout = new JMenuItem("About");
		jmHelp.add(jmiAbout);
		jmb.add(jmHelp);
		
		jmiNew.addActionListener(this);
		jmiExit.addActionListener(this);
		settingPathTestCase.addActionListener(this);
		settingPathRelevantFactorstmp.addActionListener(this);
		settingPathDimensionlessFactorstmp.addActionListener(this);
		jmiAbout.addActionListener(this);
		
		mainMenuWindow.setJMenuBar(jmb);
		mainMenuWindow.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command.equals("New")) {
			//mainMenuWindow.setVisible(false);
			//Run.main(null);
			/*if (!new File(Util.getInstance().RELEVANTFACTORS_FILENAME).exists()) {
				System.out.println("new WindowRelevantFactors()");
				WRF = new WindowRelevantFactors();
			} else {
				System.out.println("restoreRelevantFactors()");
				WRF = new WindowRelevantFactors();
				Util.getInstance().restorePersistentRelevantFactors(WRF);
				//CSV.readCSVTest(Util.getInstance().TESTCASE_CSV_FILENAME, WRF);
			}*/
			
			WRF = new WindowRelevantFactors();
		} else if (command.equals("Set Path for TestCase.csv")) {
			try {			
				String path = JOptionPane.showInputDialog(null, "Geben Sie den Pfad zu einer TestCase.csv ein", Util.getInstance().TESTCASE_CSV_FILE.getAbsolutePath());
				Util.getInstance().TESTCASE_CSV_FILENAME = path;
				JOptionPane.showMessageDialog(null, "Erfolgreich den Pfad auf: "+path+" geändert", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("Set Path for RelevantFactors.tmp file")) {
			try {			
				String path = JOptionPane.showInputDialog(null, "Geben Sie den Pfad zu einer RelevantFactors.tmp ein", Util.getInstance().RELEVANTFACTORS_FILE.getAbsolutePath());
				Util.getInstance().RELEVANTFACTORS_FILENAME = path;
				JOptionPane.showMessageDialog(null, "Erfolgreich den Pfad auf: "+path+" geändert", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("Set Path for DimensionlessFactors.tmp file")) {
			try {			
				String path = JOptionPane.showInputDialog(null, "Geben Sie den Pfad zu einer DimensionlessFactors.tmp ein", Util.getInstance().DIMENSIONLESSFACTORS_FILE.getAbsolutePath());
				Util.getInstance().DIMENSIONLESSFACTORS_FILENAME = path;
				JOptionPane.showMessageDialog(null, "Erfolgreich den Pfad auf: "+path+" geändert", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("About")) {
			System.out.println("344aab9758bbd18b93739e7893fb3a");
		} else if (command.equals("Exit")) {
			System.exit(0);
		}
	}
}