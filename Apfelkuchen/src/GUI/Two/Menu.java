package GUI.Two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import J2R.*;

/**
 * MainMenu
 * @author Sycend, Yuri Kalinin, Dominik Hofmann
 * @version 2.1.5
 */
public class Menu implements ActionListener {
	private JFrame mainMenuWindow = new JFrame("Main Menu");
	protected static WindowRelevantFactors WRF;
	public static WindowDimensionlessFactors WDF; //musste für die verwendung mit J2R geändert werden
	protected static J2R callerInstance = J2R.getInstance();
	
	public static void main(String args[]) {
		new Menu();
	}
	
	Menu() {
		mainMenuWindow.setSize(740, 440);
		mainMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiNew = new JMenuItem("New");
		//JMenuItem jmiLoadTestCaseCSV = new JMenuItem("Load");
		//JMenuItem jmiClose = new JMenuItem("Close");
		//JMenuItem jmiSave = new JMenuItem("Save");
		JMenuItem jmiExit = new JMenuItem("Exit");
		JLabel label1 = new JLabel("Welcome, thanks for using our product.");
		mainMenuWindow.add(label1);
		jmFile.add(jmiNew);
		//jmFile.add(jmiLoad);
		//jmFile.add(jmiClose);
		//jmFile.add(jmiSave);
		//jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		
		JMenu jmOptions = new JMenu("Options");
		JMenu a = new JMenu("A");
		JMenuItem b = new JMenuItem("B");
		JMenuItem c = new JMenuItem("C");
		JMenuItem d = new JMenuItem("D");
		a.add(b);
		a.add(c);
		a.add(d);
		jmOptions.add(a);
		
		JMenu e = new JMenu("E");
		e.add(new JMenuItem("F"));
		e.add(new JMenuItem("G"));
		jmOptions.add(e);
		
		jmb.add(jmOptions);
		
		JMenu jmHelp = new JMenu("Help");
		JMenuItem jmiAbout = new JMenuItem("About");
		jmHelp.add(jmiAbout);
		jmb.add(jmHelp);

		jmiNew.addActionListener(this);
		//jmiLoad.addActionListener(this);
		//jmiClose.addActionListener(this);
		//jmiSave.addActionListener(this);
		jmiExit.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		jmiAbout.addActionListener(this);
		
		mainMenuWindow.setJMenuBar(jmb);
		mainMenuWindow.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		System.out.println(command + " Selected");
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
			
			new Thread(() -> {
				Util.getInstance().readCSV(Util.getInstance().CSV_FILENAME);
				Util.getInstance().readCSV(Util.getInstance().USER_CSV_FILENAME);
			}).start();
		} else if (command.equals("Help")) {
			
		} else if (command.equals("Exit")){
			System.exit(0);
		}
		else {
			
		}
	}
}