package GUI.Two;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * @author Dominik Hofmann
 * @version 1.2.4
 */

public class ReadFromFile {

	/**
	 * @param Inputfiles
	 * @return an Arraylist containing every line that has been read from
	 *         Inputfiles
	 * @throws Exception 
	 */

	public ArrayList<String> readFile(ArrayList<String> Inputfiles) throws Exception {
		ArrayList<String> tmp = new ArrayList<String>();
		for (int i = 0; i < Inputfiles.size(); i++) {
			File file = new File(Inputfiles.get(i));
			if (file.exists()) {
				System.out.println("File: " + file.getAbsolutePath() + " Exists.");
			} else {
				System.out.println("Could not find: " + file.getAbsolutePath());
			}
			Scanner scanner = null;
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				System.out.println("File not found! file: " + file);
			}
			while (scanner.hasNext()) {
				tmp.add(scanner.nextLine());
			}
			scanner.close();
		}
		return tmp;
	}

	/**
	 * @param Inputfile
	 * @return an Arraylist containing every line that has been read from the
	 *         file located in Inputfile
	 * @throws Exception 
	 */
	
	public ArrayList<String> readLargeFile(String Inputfile) throws Exception {
		ArrayList<String> tmp = new ArrayList<String>();
		File file = new File(Inputfile);
		if (file.exists()) {
			System.out.println("File: " + file.getAbsolutePath() + " Exists.");
			FileInputStream f1 = new FileInputStream(file);
		    BufferedReader br = new BufferedReader(new InputStreamReader(f1));
		    String strLine;
		    while ((strLine = br.readLine()) != null) {
		    	tmp.add(strLine);
		    }
			br.close();
		} else {
			System.out.println("Could not find: " + file.getAbsolutePath());
		}		
		return tmp;
	}
	
	public ArrayList<String> readFile(String Inputfile) throws Exception {
		ArrayList<String> tmp = new ArrayList<String>();
		File file = new File(Inputfile);
		if (file.exists()) {
			System.out.println("File: " + file.getAbsolutePath() + " Exists.");
		} else {
			System.out.println("Could not find: " + file.getAbsolutePath());
		}
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found! file: " + file);
		}
		while (scanner.hasNext()) {
			tmp.add(scanner.nextLine());
		}
		scanner.close();
		return tmp;
	}
	
	
	

	/**
	 * @param Inputfile
	 * @return an Arraylist containing an ArrayList that has been read from Inputfile
	 */
	public ArrayList readObject(String Inputfile){
		ArrayList tmp = new ArrayList();
		try{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(Inputfile));			
			tmp = (ArrayList) input.readObject();
			input.close();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return tmp;		
	}
	
}