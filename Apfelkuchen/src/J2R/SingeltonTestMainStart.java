package J2R;

public class SingeltonTestMainStart {

	public static void main(String[] args) {
		J2R callerInstance = new J2R("RScript/RSkript.R");
		 new ControllerMainExample(callerInstance.getInstance());
		

	}

}
