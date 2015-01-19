package GUI.Two;

import java.io.File;

/**
 * Main used to Start Window1 + ReadCSV
 * @author Yuri Kalinin, Dominik Hofmann
 * @version 2.1.3
 */
public class Run {
	protected static WindowRelevantFactors WRF;
	protected static WindowDimensionlessFactors WDF;
	
	public static void main(String args[]) {
		if (!new File(Util.getInstance().RELEVANTFACTORS_FILENAME).exists()) {
			System.out.println("new WindowRelevantFactors()");
			WRF = new WindowRelevantFactors();
		} else {
			System.out.println("restoreRelevantFactors()");
			WRF = new WindowRelevantFactors();
			Util.getInstance().restorePersistentRelevantFactors(WRF);
		}
		
		new Thread(() -> {
			CSV.readCSV(Util.getInstance().CSV_FILENAME);
			CSV.readCSV(Util.getInstance().USER_CSV_FILENAME);
		}).start();
	}//end Main
}