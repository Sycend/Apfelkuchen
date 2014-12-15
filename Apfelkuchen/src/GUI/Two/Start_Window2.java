package GUI.Two;

public class Start_Window2 {
	public static void main(String[] args) {
		DLF test=new DLF(
				new double[][]{{1.0,2.0},{-1.0,-2.0},{1.0,2.0},{-1.0,0.0},{0.0,-2.0}},//,{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0},{0.0,0.0}},
				new String[]{"Höhe","Breite","Dichte","Temperatur","Verhältnis"},//,"Test 1","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3","Test 2","Test 3"},
				new String[]{"Alpha","Beta"},
				new String[][]{{"-5","0"},{"5","10"}},
				new String[][]{{"0","0"},{"0","0"},{"0","0"},{"0","0"},{"0","0"},{"0","0"},{"0","0"}}
				);
	}
}