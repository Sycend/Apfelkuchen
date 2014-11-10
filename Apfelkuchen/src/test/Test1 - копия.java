package test;

import java.io.File;

import rcaller.RCaller;
import rcaller.RCode;

public class Test1 {
	
	public static void main(String[] args) {
		new Test1();
	}
	
	/*
	 * Test for simple plots
	 */
	public Test1() {
		try {
			RCaller caller = new RCaller();
			caller.setRscriptExecutable("C://Program Files/R/R-3.1.1/bin/x64/Rscript.exe");
			
			RCode code = new RCode();
			code.clear();
			
			double[] numbers = new double[] { 1, 4, 3, 5, 6, 10 };
			
			code.addDoubleArray("x", numbers);
			File file = code.startPlot();
			System.out.println("Plot will be saved to : " + file);
			code.addRCode("plot.ts(x)");
			code.endPlot();
			
			caller.setRCode(code);
			caller.runOnly();
			code.showPlot(file);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}