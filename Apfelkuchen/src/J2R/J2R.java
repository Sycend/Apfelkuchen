package J2R;

import rcaller.RCaller;
import rcaller.RCode;
import rcaller.ROutputParser;

public class J2R {
	private RCaller caller;
	private RCode code;
	private String rExePfad;
	private String skriptPath;

	public J2R(String skript) {
		initRCaller("C://Program Files/R/R-3.1.1/bin/x64");// ersetzten wenn
															// bekannt wo das
															// her kommen wird
		initRskript(skript);
		initRCode();
	};

	private void initRCaller(String PathPrefix) {
		caller = new RCaller();
		rExePfad = PathPrefix.concat("/R.exe");
		caller.setRExecutable(rExePfad);
	}

	private void initRskript(String skript) {
		skriptPath = skript;
	}

	private void initRCode() {
		code = null;
		code = new RCode();
		code.clear();
		code.R_source(skriptPath);
	}

	public void setCode(RCode Code) {
		// code.clear();
		// code.R_source(skriptPath); //wenn mehrere Skripte benutzt werden
		// ebenfalls anpassen// bei einem Startpunkt festlegen
		// starten und dann weglassen // nach Run ist es vorhanden

		caller.setRCode(code);

	}

	public void runRCaller(String s) {
		caller.runAndReturnResultOnline(s);
		
	}

	public ROutputParser getParser()
	{
		return caller.getParser();
	}
	
	public void runAndReturnResultOnline(String s)
	{
		caller.runAndReturnResultOnline(s);
	}
	
	public void stopRCaller() {

		caller.stopStreamConsumers();
		caller.StopRCallerOnline();
		caller.deleteTempFiles();
	}

	public RCode getRCode() {
		return this.code;
	}

	public RCaller getRCaller() {
		return this.caller;
	}
}
