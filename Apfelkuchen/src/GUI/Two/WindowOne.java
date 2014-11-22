package GUI.Two;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WindowOne {
	public void initWindowOne() {
		JTextField name = new JTextField();
		JTextField abrev = new JTextField();
		Object[] message = { "Name", name};

		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION);

		pane.createDialog("Titel").setVisible(true);	
		if (pane.getValue().equals(JOptionPane.OK_OPTION)) {
			Run.changeNumComp();
			Run.AddNameValue(name.getText());
			System.out.println(name.getText());
		}
	}
}