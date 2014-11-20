package GUI.Two;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Dominik Hofmann, Mark Leibmann
 * @version 1.0.0
 */
public class ReadCSV {
	
	public static void readCSV(){
		ArrayList<String> content = new ArrayList<String>();
		ReadFromFile rff = new ReadFromFile();
		try {
			content = rff.readFile("spezifikation.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 1; i < content.size(); i++){ // starts at 1 so that first row is ignored
			//System.out.println(""+content.get(i));
	        System.out.println("-------------------------- Neue Zeile:"); 
	        final StringTokenizer st = new StringTokenizer(content.get(i), ";"); 
	        while (st.hasMoreTokens()) {  
	            System.out.println("Naechste Spalte:" + st.nextToken()); 
	        } 
		}
	}
	
}
