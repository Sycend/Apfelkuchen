/**
 * 
 * 
 */
package GUI.Two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class Menu implements ActionListener {
	
	public static void main(String args[]) {
		new Menu();
	}
	
	Menu() {
		JFrame mainMenuWindow = new JFrame("Main Menu");
		mainMenuWindow.setSize(620, 200);
		mainMenuWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiNew = new JMenuItem("New");
		JMenuItem jmiOpen = new JMenuItem("Open");
		JMenuItem jmiClose = new JMenuItem("Close");
		JMenuItem jmiSave = new JMenuItem("Save");
		JMenuItem jmiExit = new JMenuItem("Exit");
		JLabel label1 = new JLabel("Welcome, thanks for using our product.");
		mainMenuWindow.add(label1);
		jmFile.add(jmiNew);
		jmFile.add(jmiOpen);
		jmFile.add(jmiClose);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
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
		jmiOpen.addActionListener(this);
		jmiClose.addActionListener(this);
		jmiSave.addActionListener(this);
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
	 if( command.equals( "New" ))  {
		 //mainMenuWindow.setVisible(false);
		 Run.main(null);
      }
      else if( command.equals( "Help" ) )  {
        
      }
      else  {
         
      }  
	}
}

