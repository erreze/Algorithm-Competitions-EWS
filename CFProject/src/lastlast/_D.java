package lastlast;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _D {
	public void solve() {
		int r = ni();
		int []ar=new int[r];
		int arr=0;
		int zero=0;
		int nonzero=0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < r; i++) {
			ar[i]=ni();
			set.add(ar[i]);
			arr+=ar[i];
			if(ar[i]==0)
				zero++;
			else
				nonzero++;
		}
		if(arr==0){
			out.println("BitAryo");
			return;
		}
		sort(ar);
		if(r==2){
			if(nonzero==2){
				if(set.size()==2){
					if(!win(ar[0],ar[1])){
						out.println("BitAryo");
						return;
					}
				}
			}	
		}
		if(r==3){
			if(zero==1){
				if(set.size()==3){
					if(!win(ar[1],ar[2])){
						out.println("BitAryo");
						return;
					}
				}	
			}
			if(zero==0){ 
				if(!win(ar[0],ar[1])
					|| !win(ar[1],ar[2])
					|| !win(ar[0],ar[2])){
				}else{        
					out.println("BitAryo");
					return;
				}
			} 
		}
		out.println("BitLGM");
	}
	boolean win(int a, int b){
		if(a==1){
			return (b>2);
		}
		if(b-a>=2){
			if((a%2!=0 || b%2!=0))
				return true;
			return false;
		}

		return true;
	}

	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	
	public static void main(String[] args) throws Exception {new _D().run();}

	InputStream in=System.in;
	PrintWriter out=new PrintWriter(System.out);
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private byte[] inbuf = new byte[1024];
	private int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {return !(c >= 33 && c <= 126);}
	private int skip() {int b;while ((b = readByte()) != -1 && isSpaceChar(b));return b;}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != // ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	
	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl(){
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	void pr(Object... ob) {if (!oj)System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));}
}
