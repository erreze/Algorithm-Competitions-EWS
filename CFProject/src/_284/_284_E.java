package _284;
import java.io.*;
public class _284_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"4 2 17 "+
		"3 1 2 5 "+
		"4 2 "+
		"3 4 ";
		runTest(input,
		"3 ");

//		Case 1
		input=
		"3 2 6 "+
		"3 1 1 "+
		"1 2 "+
		"2 3 ";
		runTest(input,
		"0 ");

//		Case 2
		input=
		"3 2 10 "+
		"1 2 3 "+
		"1 2 "+
		"2 1 ";
		runTest(input,
		"0 ");


	}
	
	public void compare(String rcAnswer, String realAnswer){
		realAnswer=realAnswer.trim();
		rcAnswer=rcAnswer.trim();
		if(realAnswer.equals(rcAnswer)){
			System.out.println("[Passed] Case "+nroCases);
		}else{
			failed=true;
			System.out.println("rChi "+rcAnswer);
			System.out.println("Expected "+realAnswer);
			System.out.println("[Failed] Case "+nroCases);
//			System.exit(0);
		}
		nroCases++;
	}
	
	public void runTest(String input, String output) throws Exception{
		r.in= new ByteArrayInputStream(input.getBytes());
		r.run();
		if(testOutput){
			compare(baos.toString(), output);
		}else{
			System.out.println(baos.toString());
		}
		baos.reset();
//		r.in.
	}
	_284_E_Coin_Troubles r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _284_E_Coin_Troubles();
		r.out = new PrintWriter(baos);
		runTestCases();
		if(testOutput && !failed){
			System.out.println("All test cases [Passed]");
		}
	}
	private String input;
	private int nroCases=1;
	private boolean failed=false;
	public static void main(String[] args) throws Exception {
		new _284_E().init();
	}
	
}

