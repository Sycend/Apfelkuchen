package test;

//import static org.junit.Assert.*;
import GUI.UnitTable;

/**
 * @author Dominik Hofmann, Mark L
 * @version 1.0.0
 */
public class Testing {
	public static int Test0(int n) {
		UnitTable unitT = new UnitTable();
		unitT.setEnergy_J_high(n);
		//energy_J_high = n;
		//return 0;
		return unitT.getEnergy_J_high() * unitT.getEnergy_J_gradient();
	}
	
	public static void testEnergy_J() {
		//assertEquals(0, Test0(3));
	}
}
