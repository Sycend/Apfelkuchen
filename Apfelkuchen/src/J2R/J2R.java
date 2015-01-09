package J2R;

import rcaller.RCaller;
import rcaller.RCode;
import rcaller.ROutputParser;

/**
 * Class for operating the RCaller.
 * 
 * @author Christoph Wütschner, Clemens Kretzer, Florian Then
 *
 */
public class J2R {
	private RCaller caller;
	private RCode code;
	private String rExePfad;
	private String skriptPath;

	/**
	 * Creates a new object of J2R.
	 * 
	 * -> Inits RCaller with initRCaller() -> Inits RScript with Rskript(skript)
	 * -> Inits RCode with initRCode()
	 * 
	 * @param skript
	 *            The path of the script with your R code.
	 */
	public J2R(String skript) {
		initRCaller("C://Program Files/R/R-3.1.1/bin/x64");// ersetzten wenn
															// bekannt wo das
															// her kommen wird
		initRskript(skript);
		initRCode();
	};

	/**
	 * This method initializes the RCaller. A new RCaller object is created.
	 * After that the pathprefix is appended with the location of the R.exe.
	 * The caller executable is set to this path.
	 * 
	 * @param PathPrefix
	 *            this is the path of the bin folder in the R program folder
	 */
	private void initRCaller(String PathPrefix) {
		caller = new RCaller();
		rExePfad = PathPrefix.concat("/R.exe");
		caller.setRExecutable(rExePfad);
	}

	/**
	 * Sets the skriptPath parameter with the skript string
	 * 
	 * @param skript
	 *            The path of the R script you want to use
	 *
	 */
	private void initRskript(String skript) {
		skriptPath = skript;
	}

	/**
	 * This method initializes the RCode. The source of the code is set to the
	 * Path of the script you want to use. This path is provided with the
	 * Construktor
	 */
	private void initRCode() {
		code = null;
		code = new RCode();
		code.clear();
		code.R_source(skriptPath);
	}

	/**
	 * This method sets the code of the caller instance to the parameter Code
	 * 
	 * @param Code
	 *            the Code with the R commands
	 */
	public void setCode(RCode Code) {
		// code.clear();
		// code.R_source(skriptPath); //wenn mehrere Skripte benutzt werden
		// ebenfalls anpassen// bei einem Startpunkt festlegen
		// starten und dann weglassen // nach Run ist es vorhanden

		caller.setRCode(code);

	}

	/**
	 * The caller runs the R command which is send over in the Parameter s
	 * 
	 * @param s
	 *            The R command to be executed
	 */
	public void runAndReturnResultOnline(String s) {
		caller.runAndReturnResultOnline(s);

	}

	/**
	 * This method returns the parser of the RCaller from this class (currently
	 * running)
	 * 
	 * @return caller.getParser() the type is ROutputParser
	 */
	public ROutputParser getParser() {
		return caller.getParser();
	}


	/**
	 * !!!CAUTION!!!
	 * The running RCaller instance is STOPPED. 
	 * ALL TEMPFILES will be DELETED.
	 */
	public void stopRCaller() {

		caller.stopStreamConsumers();
		caller.StopRCallerOnline();
		caller.deleteTempFiles();
	}

	/**
	 * Returns the RCode of the instance of this class. This code is used in the
	 * RCaller instance.
	 * 
	 * @return this.code
	 */
	public RCode getRCode() {
		return this.code;
	}

}
//Test
