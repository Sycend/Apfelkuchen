package GUI.Two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
 * @version 2.2.4
 */
public class Menu implements ActionListener {
	private JFrame mainMenuWindow = new JFrame("Main Menu");
	protected static WindowRelevantFactors WRF;
	public static WindowDimensionlessFactors WDF; //public because J2R needs to access it
	protected static J2R callerInstance = J2R.getInstance();
	protected boolean window1Open = false;
	
	public static void main(String args[]) {
		new Menu();
		new Thread(() -> {
			Util.getInstance().readCSV(Util.getInstance().CSV_FILENAME);
			Util.getInstance().readUserCSV(Util.getInstance().USER_CSV_FILENAME);
		}).start();
	}
	
	Menu() {
		mainMenuWindow.setSize(740, 440);
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiNew = new JMenuItem("New");
		JMenuItem jmiExit = new JMenuItem("Exit");
		JLabel label1 = new JLabel("Welcome, thanks for using our product.");
		mainMenuWindow.add(label1);
		jmFile.add(jmiNew);
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		
		mainMenuWindow.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Close");
				callerInstance.stopRCaller();
				System.exit(0);				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		
		JMenu jmOptions = new JMenu("Options");
		JMenuItem settingPathTestCase = new JMenuItem("Set Path for TestCase.csv");
		JMenuItem settingPathRelevantFactorstmp = new JMenuItem("Set Path for RelevantFactors.apk file");
		JMenuItem settingPathDimensionlessFactorstmp = new JMenuItem("Set Path for DimensionlessFactors.apk file");
		JMenuItem settingAutoloadTMPFiles = new JMenuItem("(De)Activate APK File Autoloading for Window1");
		jmOptions.add(settingPathTestCase);
		jmOptions.add(settingPathRelevantFactorstmp);
		jmOptions.add(settingPathDimensionlessFactorstmp);
		jmOptions.add(settingAutoloadTMPFiles);
		
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
		settingAutoloadTMPFiles.addActionListener(this);
		jmiAbout.addActionListener(this);
		
		mainMenuWindow.setJMenuBar(jmb);
		mainMenuWindow.setVisible(true);
	}
	public void onExit() {
		  System.err.println("Exit");
		  System.exit(0);
		}
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command.equals("New")) {
			if (window1Open == false) {
				window1Open = true;
				//mainMenuWindow.setVisible(false);
				if (Util.getInstance().isAutoloadingWindow1 != false) {
					if (!new File(Util.getInstance().RELEVANTFACTORS_FILENAME).exists()) {
						System.out.println("new WindowRelevantFactors()");
						WRF = new WindowRelevantFactors();
					} else {
						System.out.println("restoreRelevantFactors()");
						WRF = new WindowRelevantFactors();
						Util.getInstance().restorePersistentRelevantFactors(WRF);
					}
				} else {
					WRF = new WindowRelevantFactors();
				}
			}
		} else if (command.equals("Set Path for TestCase.csv")) {
			try {
				String path = JOptionPane.showInputDialog(null, "Geben Sie den Pfad zu einer TestCase.csv ein", Util.getInstance().TESTCASE_CSV_FILE.getAbsolutePath());
				if (path != null) {
					Util.getInstance().TESTCASE_CSV_FILENAME = path;
					JOptionPane.showMessageDialog(null, "Erfolgreich den Pfad auf: " + path + " geändert", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("Set Path for RelevantFactors.apk file")) {
			try {
				String path = JOptionPane.showInputDialog(null, "Geben Sie den Pfad zu einer RelevantFactors.apk ein", Util.getInstance().RELEVANTFACTORS_FILE.getAbsolutePath());
				if (path != null) {
					Util.getInstance().RELEVANTFACTORS_FILENAME = path;
					JOptionPane.showMessageDialog(null, "Erfolgreich den Pfad auf: " + path + " geändert", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("Set Path for DimensionlessFactors.apk file")) {
			try {
				String path = JOptionPane.showInputDialog(null, "Geben Sie den Pfad zu einer DimensionlessFactors.apk ein", Util.getInstance().DIMENSIONLESSFACTORS_FILE.getAbsolutePath());
				if (path != null) {
					Util.getInstance().DIMENSIONLESSFACTORS_FILENAME = path;
					JOptionPane.showMessageDialog(null, "Erfolgreich den Pfad auf: " + path + " geändert", "Info", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("(De)Activate APK File Autoloading for Window1")) {
			if (Util.getInstance().isAutoloadingWindow1 == true) {
				Util.getInstance().isAutoloadingWindow1 = false;
			} else if (Util.getInstance().isAutoloadingWindow1 == false) {
				Util.getInstance().isAutoloadingWindow1 = true;
			}
			JOptionPane.showMessageDialog(null, "isAutoloadingWindow1: " + Util.getInstance().isAutoloadingWindow1, "Info", JOptionPane.WARNING_MESSAGE);
		} else if (command.equals("About")) {
			System.out.println("344aab9758bbd18b93739e7893fb3a");
		} else if (command.equals("Exit")) {
			System.exit(0);
		}
	}
}