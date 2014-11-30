package GUI.Two;

public class StringCheck {

	public boolean abbreviationCheck(String input) {
		if (input.isEmpty()) {
			return false;
		}
		if (input.length() > 8) {
			return false;
		}
		char[] chars = input.toCharArray();
		for (char charInput : chars) {
			if (!Character.isLetter(charInput)) {
				return false;
			}
		}

		return true;
	}
}
