
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class C {

	public void solve() {
		
	}
	
	C(){
//		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		try {
//			in = new Scanner(new File("C_in.txt"));
			in = new Scanner(new File("find_the_mintxt.txt"));
			out = new PrintWriter(new File("C_out.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new C().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return parseInt(in.nextLine());
	}
	static long readLong(){
		return Long.parseLong(in.nextLine());
	}
	static int[] readIntArray(){
		String l[] = in.nextLine().split(" ");
		int[] r=new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i]=parseInt(l[i]);
		}
		return r;
	}
	
	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

