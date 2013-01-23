
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class LandAndSea {
    public int[] howManyIslands(String[] seaMap) {
        N=seaMap.length+2;
        M=seaMap[0].length()+2;
        sea = new char[N][M];
        char[]fillers=new char[M];
        fill(fillers,'.');
        sea[0]=fillers;
        sea[sea.length-1]=fillers;
        for (int i = 0; i < seaMap.length; i++) {
        	sea[i+1]=("."+seaMap[i]+".").toCharArray();
		}
        vals = new int [N][M];
        memo= new boolean[N][M];
        map=new Object[N][M];
        
        water root=new water(0);
        ff(0,0,'.',0, root);
        int c=1;
        for (int i = 0; i < vals.length; i++) {
			for (int j = 0; j < vals[i].length; j++) {
				if(!memo[i][j] && sea[i][j]=='x'){
					water father=(water)map[i][j-1];
					island isl= new island(c);
					ff(i,j,sea[i][j],c++,isl);
					father.children.add(isl);
				}else if(!memo[i][j] && sea[i][j]=='.'){
					island father=(island)map[i][j-1];
					water wat= new water(c);
					ff(i,j,sea[i][j],c++,wat);
					father.children.add(wat);
				}
			}
		}
        
//        print(root);
        r = new int[2502];
        go(root);
//        print(vals);
//        print(r);
        if(max==0 && r[0]==0)
        	return new int[0];
        int res[]= new int[max+1];
        for (int i = 0; i < res.length; i++) {
			res[i]=r[i];
		}
        return res;
    }
    int r[];
    int max=0;
    int go(Object node){
//    	print(node);
    	if(node==null)
    		return 0;
    	if(node instanceof water){
    		water w = (water)node;
    		int rr = 0;
    		for (int i = 0; i < w.children.size(); i++) {
    			rr = max(rr,1+go(w.children.get(i)));
			}
    		return rr;
    	}else{
    		island isl = (island)node;
    		int rr=0;
    		for (water wat : isl.children) {
				rr=max(rr,go(wat));
			}
    		r[rr]++;
    		max=max(rr,max);
    		return rr;
    	}
//    	return 0;
    }
    
    class water{
    	int name;
    	ArrayList<island> children = new ArrayList<island>();
    	public water(int name) {
			this.name=name;
		}
    	@Override
    	public String toString() {
    		return name+" "+children;
    	}
    }
    class island{
    	int name;
    	ArrayList<water> children = new ArrayList<water>();
    	public island(int name) {
			this.name=name;
		}
    	@Override
    	public String toString() {
    		return name+""+children;
    	}
    }
    Object map[][];
    int N,M;
    char[][]sea;
    int[][] vals;
//    int di4[] = { 0, 0, 1, -1 };
//	int dj4[] = { -1, 1, 0, 0 };
	int di8[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
	int dj8[] = { -1, 1, 0, 0, 1, -1, -1, 1 };
	boolean [][]memo;
	void ff(int x, int y, char c, int val, Object ob){
		map[x][y]=ob;
		memo[x][y]=true;
		vals[x][y]=val;
		for (int i = 0; i < (c=='x'?8:4); i++) {
			int X=x+di8[i];
			int Y=y+dj8[i];
			if(X>=0 && X<sea.length && Y>=0 && Y<sea[X].length && !memo[X][Y] && sea[X][Y]==c){
//				memo[X][Y]=true;
				vals [X][Y]= val;
				
				ff(X,Y,c,val,ob);
			}
		}
	}
    

// BEGIN CUT HERE

//	private static void print(Object... rs) {
//		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
//	}
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}

    public static void main(String[] args) {
        try {
            eq(0,(new LandAndSea()).howManyIslands(new String[] {"x"}),new int[] {1 });
            eq(1,(new LandAndSea()).howManyIslands(new String[] {
               "xxxxx",
               "x...x",
               "x.x.x",
               "x...x",
               "xxxxx"
               }),new int[] {1, 1 });
            eq(2,(new LandAndSea()).howManyIslands(new String[] {
               "xxxxx",
               "x...x",
               "x.x.x",
               "x...x",
               "xxxxx",
               "xxxxx",
               "x...x",
               "x.x.x",
               "x...x",
               "xxxxx"
               }),new int[] {2, 1 });
            eq(3,(new LandAndSea()).howManyIslands(new String[] {
               "..",
               ".."
               }),new int[] { });
            eq(4,(new LandAndSea()).howManyIslands(new String[] {
               "............",
               ".......xxxx.",
               "..xxx.x...x.",
               "..x..x..x.x.",
               "..x.x.x...x.",
               "..xx...xxx.."
               }),new int[] {1, 1 });
            eq(2,(new LandAndSea()).howManyIslands(new String[] {
                    "xxxxxxxxx",
                    "x.......x",
                    "x.xxxxx.x",
                    "x.x...x.x",
                    "x.x.x.x.x",
                    "x.x...x.x",
                    "x.x.x.x.x",
                    "x.x...x.x",
                    "x.xxxxx.x",
                    "x.......x",
                    "xxxxxxxxx"
                    }),new int[] {2,1,1});
            eq(2,(new LandAndSea()).howManyIslands(new String[] {
            		"xxxxxxxx", 
            		"x..x...x", 
            		"x.xxx..x", 
            		"x..x...x", 
            		"x......x", 
            		"xxxxxxxx"}),new int[] {1});
            
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
   private static void eq(int n, int a, int b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " " + a + " " + expected + " " + b + ".");
        }
    }

    private static void eq(int n, double a, double b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, char a, char b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, long a, long b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "L' " + expected + " '" + b + "L'.");
        }
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b)) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " \"" + a + "\" " + expected + " \"" + b + "\".");
        }
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            print(received + "<" + a.length + "> ", a);
            print(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received + " ", a);
                print(expected + " ", b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            print(received + "<" + a.length + "> ", a);
            print(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received, a);
                print(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, double[] a, double[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            print(received + "<" + a.length + "> ", a);
            print(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received, a);
                print(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            print(received + "<" + a.length + "> ", (Object[]) a);
            print(expected + "<" + b.length + "> ", (Object[]) b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received, (Object[]) a);
                print(expected, (Object[]) b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }


    
    static String expected = "  expe";
    static String received = "  rc";
// END CUT HERE
}

// BEGIN CUT HERE

// END CUT HERE
