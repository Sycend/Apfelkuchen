package GUI.Two;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WindowOne {
	public void initWindowOne() {
		JTextField name = new JTextField();
		JTextField abrev = new JTextField();
		Object[] message = { "Name", name, "Abkuerzung", abrev };

		JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE,
				JOptionPane.OK_CANCEL_OPTION);
		pane.createDialog(null, "Titel").setVisible(true);
		Run.AddNameValue(name.getText());
		System.out.println(name.getText());

	}
}