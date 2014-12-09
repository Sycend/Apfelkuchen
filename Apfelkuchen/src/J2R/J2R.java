package J2R;
import rcaller.RCaller;
import rcaller.RCode;

public class J2R {
	private RCaller caller;
	private RCode code;
//	private String rSkriptExePfad;
	private String rExePfad;
	private String skriptPath;
//	private String RskriptSuggestVmatrix;

	
	public J2R(String skript)
	{
		initRCaller("C://Program Files/R/R-3.1.1/bin/x64");//ersetzten wenn bekannt wo das her kommen wird
		initRskript(skript);
		initRCode();		
	};
	private void initRCaller(String PathPrefix)
	{
		caller=new RCaller();
//		rSkriptExePfad=PathPrefix.concat("/Rscript.exe");	//Falls überhaupt noch gebraucht
//		caller.setRscriptExecutable(rSkriptExePfad);        //Falls überhaupt noch gebraucht
		rExePfad=PathPrefix.concat("/R.exe");		
		caller.setRExecutable(rExePfad);
	}
	private void initRskript(String skript)
	{
		//RskriptSuggestVmatrix="C://Users/Florian/Documents/RSkript.R"; //Anpassen wenn bekannt ist wo Skript(e) untergebracht werden
		//RskriptSuggestVmatrix="C://Users/Clemens/Documents/RSkript.R"; //Anpassen wenn bekannt ist wo Skript(e) untergebracht werden
		//RskriptSuggestVmatrix="D://Skript.R"; //Anpassen wenn bekannt ist wo Skript(e) untergebracht werden
		skriptPath = skript;
	}
	private void initRCode()
	{
		code = null;
		code = new RCode();
		code.clear();
		code.R_source(skriptPath);
	}
	public void setCode(RCode Code)
	{
		//code.clear();
		//code.R_source(skriptPath);		//wenn mehrere Skripte benutzt werden ebenfalls anpassen// bei einem Startpunkt festlegen
													// starten und dann weglassen // nach Run ist es vorhanden
		
		caller.setRCode(code);	
		
	}


	public void stopRCaller()
	{
		
		caller.stopStreamConsumers();
		caller.StopRCallerOnline();
		caller.deleteTempFiles();
	}
	public RCode getRCode()
	{
		return this.code;
	}
	public RCaller getRCaller()
	{
		return this.caller;
	}
}
