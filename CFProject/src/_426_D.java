import java.io.*;
public class _426_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 5 2 "+
		"1 1 1 1 1 "+
		"1 1 1 1 1 "+
		"1 1 0 1 1 "+
		"1 1 1 1 1 "+
		"1 1 1 1 1 ";
		runTest(input,
		"1 ");

//		Case 1
		input=
		"3 4 1 "+
		"1 0 0 0 "+
		"0 1 1 1 "+
		"1 1 1 0 ";
		runTest(input,
		"-1 ");

//		Case 2
		input=
		"3 4 1 "+
		"1 0 0 1 "+
		"0 1 1 0 "+
		"1 0 0 1 ";
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
	_426_D_Sereja_and_Table_ r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _426_D_Sereja_and_Table_();
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
		new _426_D().init();
	}
	
}

