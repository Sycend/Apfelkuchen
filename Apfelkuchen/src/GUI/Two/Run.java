package GUI.Two;

import java.util.Vector;

/**
 * @author Yury Kalinin Start of window 
 * 20141116
 *
 */
public class Run {
	public static Vector nameOfValue;
	public static boolean state;

	private static int numExp;

	public static void main(String args[]) {

		numExp = 0;
		nameOfValue = new Vector();
		WindowOne window = new WindowOne();

		window.setWindow(597, 275);

	}

	public static void remove() {
		nameOfValue.remove(nameOfValue.indexOf(nameOfValue.lastElement()));

	}

	public static int getNumExp() {
		return numExp;
	}

	public static void changeNumExp() {
		numExp++;
	}

	public static void changeNumExp(int value) {
		numExp = value;
	}

	public static void changeNameOfValue() {
		nameOfValue = new Vector();
	}

}
