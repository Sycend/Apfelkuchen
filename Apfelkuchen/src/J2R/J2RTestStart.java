package J2R;

public class J2RTestStart {
	public static void main(String[] args) {
	J2R testJ2R=new J2R();
	testJ2R.setCodeToSuggestVmatrix(new String[]{"Test1","Test2","Test3","Test4","Test5"},
	new double[][]{{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{1,2,3,4,5,6,7},{1,2,3,4,5,6,7}} ,true);
	testJ2R.startRCallerWithSuggestVmatrix();
	double results[][]=testJ2R.getVMatrix();
	String[] n=testJ2R.getRownames();
	String[] cn=testJ2R.getColnames();
	int mydim[]=testJ2R.getMydim();
	testJ2R.stopRCaller();
	
	for (int i = 0; i < mydim[1]; i++) {
	if (i < n.length)
		System.out.print(n[i] + " ");
	for (int j = 0; j < mydim[0]; j++) {
		System.out.print(results[i][j]);// Spalte /Zeilen
		System.out.print(" ");
	}
	System.out.println("das ist ein test Push");
	System.out.println(cn[i]);
	System.out.print('\n');
	}
	}
	//TestTestTest
}