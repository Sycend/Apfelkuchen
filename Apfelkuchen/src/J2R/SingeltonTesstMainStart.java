package J2R;

public class SingeltonTesstMainStart {

	public static void main(String[] args) {
		J2R callerInstance = new J2R("RScript/RSkript.R");
		
		new SuggestVMatrixSingelton(callerInstance.getInstance());
		
		new MinMaxSingelton(callerInstance.getInstance());

	}

}
