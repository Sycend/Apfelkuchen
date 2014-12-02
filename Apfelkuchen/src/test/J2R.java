package test;

import rcaller.RCaller;
import rcaller.RCode;

public class J2R {
	private RCaller caller;
	private RCode code;
//	private String rSkriptExePfad;
	private String rExePfad;
	private String RskriptSuggestVmatrix;
	private String[] colNames;
	private double[][] vMatrix;
	private String[] rowNames;
	private int[] mydim;
	static private String vMatrixResultName ="vMatrix";
	static private String rowNamesResultName ="rowNames";
	static private String colNamesResultName ="colNames";
	private boolean suggestVmatrixResults;
	private boolean resultsAvailable;
	
	public J2R()
	{
		initRCaller("C://Program Files/R/R-3.1.1/bin/x64");//ersetzten wenn bekannt wo das her kommen wird
		initRskript();
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
	private void initRskript()
	{
		//RskriptSuggestVmatrix="C://Users/Florian/Documents/RSkript.R"; //Anpassen wenn bekannt ist wo Skript(e) untergebracht werden
		RskriptSuggestVmatrix="C://Users/Clemens/Documents/RSkript.R"; //Anpassen wenn bekannt ist wo Skript(e) untergebracht werden
		//RskriptSuggestVmatrix="D://Skript.R"; //Anpassen wenn bekannt ist wo Skript(e) untergebracht werden
	}
	private void initRCode()
	{
		code=new RCode();
		code.clear();
	}
	public void setCodeToSuggestVmatrix(String[] abkuerzungen,double[][] dMatrix, boolean debug)
	{
		code.clear();
		code.R_source(RskriptSuggestVmatrix);		//wenn mehrere Skripte benutzt werden ebenfalls anpassen// bei einem Startpunkt festlegen
													// starten und dann weglassen // nach Run ist es vorhanden
		code.addDoubleMatrix("D", dMatrix);
		code.addStringArray("u_abbr", abkuerzungen);
		
		if(debug)
			code.addRCode(vMatrixResultName.concat("<-suggestVmatrix(u_abbr,D,TRUE)"));
		else
			code.addRCode(vMatrixResultName.concat("<-suggestVmatrix(u_abbr,D,FALSE)"));

		suggestVmatrixResults=true;
	}
	public void startRCallerWithSuggestVmatrix()
	{
		if(suggestVmatrixResults)
		{
			caller.setRCode(code);
			code.addRCode(vMatrixResultName.concat("<-t(vMatrix)"));
			caller.runAndReturnResultOnline(vMatrixResultName);
			mydim = caller.getParser().getDimensions(vMatrixResultName);
			vMatrix=caller.getParser().getAsDoubleMatrix(vMatrixResultName, mydim[1], mydim[0]);
			code.clear();
			code.addRCode(rowNamesResultName.concat("<-rownames(vMatrix)"));
			caller.runAndReturnResultOnline(rowNamesResultName);
			rowNames=caller.getParser().getAsStringArray(rowNamesResultName);
			code.clear();
			code.addRCode(colNamesResultName.concat("<-colnames(vMatrix)"));
			caller.runAndReturnResultOnline(colNamesResultName);
			colNames=caller.getParser().getAsStringArray(colNamesResultName);
			code.clear();	
			resultsAvailable=true;
		}else
		{
			System.out.println("Don`t forget setCodeToSuggestVmatrix");
		}		
		
	}
	public double[][] getVMatrix()
	{
		if(resultsAvailable)
		{
			return vMatrix;
		}else{
			return new double[0][0];
		}
	}
	public String[] getRownames()
	{
		if(resultsAvailable)
		{
			return rowNames;
		}else{
			return new String[]{};
		}
	}
	public String[] getColnames()
	{
		if(resultsAvailable)
		{
			return colNames;
		}else{
			return new String[]{};
		}
	}
	public int[] getMydim()
	{
		if(resultsAvailable)
		{
			return mydim;
		}else{
			return new int[]{};
		}
	}
	public void stopRCaller()
	{
		suggestVmatrixResults=false;
		resultsAvailable=false;
		caller.stopStreamConsumers();
		caller.StopRCallerOnline();
		caller.deleteTempFiles();
	}
}
