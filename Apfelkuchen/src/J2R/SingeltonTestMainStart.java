package J2R;

public class SingeltonTestMainStart {

	public static void main(String[] args) {
		J2R callerInstance =  J2R.getInstance();
		 new ControllerMainExample(callerInstance);
		

	}

}
