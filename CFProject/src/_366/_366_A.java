package _366;
import java.io.*;
public class _366_A {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"10 "+
		"5 6 5 6 "+
		"6 6 7 7 "+
		"5 8 6 6 "+
		"9 9 9 9 ";
		runTest(input,
		"1 5 5 ");

//		Case 1
		input=
		"10 "+
		"6 6 6 6 "+
		"7 7 7 7 "+
		"4 4 4 4 "+
		"8 8 8 8 ";
		runTest(input,
		"3 4 6 ");

//		Case 2
		input=
		"5 "+
		"3 3 3 3 "+
		"3 3 3 3 "+
		"3 3 3 3 "+
		"3 3 3 3 ";
		runTest(input,
		"-1 ");


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
	_366_A_Dima_and_Guards r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _366_A_Dima_and_Guards();
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
		new _366_A().init();
	}
	
}

