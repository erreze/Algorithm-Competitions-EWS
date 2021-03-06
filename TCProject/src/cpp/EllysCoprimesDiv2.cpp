#include <algorithm>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <queue>
#include <set>
#include <map>
#include <cstdio>
#include <cstdlib>
#include <cctype>
#include <cmath>
using namespace std;
#define all(v) (v).begin(),(v).end()
#define rall(v) (v).rbegin(),(v).rend()
#define debug(a) cerr << #a << ": " << a << endl;
#define debugv(b) cerr << #b << ":\n"; for(int countvec = 0; countvec < b.size(); countvec++) {cerr << b[countvec] << "    ";} cerr << endl;
#define debuga(b) cerr << #b << ":\n"; for(int countvec = 0; countvec < sizeof(b)/sizeof(int); countvec++) {cerr << b[countvec] << "    ";} cerr << endl;
#define debugm(c) cerr << #c << ":\n"; for(int countmat = 0; countmat < c.size(); countmat++) {for(int countbb = 0; countbb < c[countmat].size(); countbb++) { cerr << c[countmat][countbb] << "    "; } cerr << endl; }
#define fill(a , value) memset(a , value , sizeof(a))
#define FOREACH(i,c) for (typeof((c).end()) i = (c).begin(); i != (c).end(); ++i)
string tos(int a) {ostringstream os(""); os << a; return os.str();}


// BEGIN CUT HERE
vector<string> split( const string& s, const string& delim =" " ) {
    vector<string> res;
    string t;
    for ( int i = 0 ; i != s.size() ; i++ ) {
        if ( delim.find( s[i] ) != string::npos ) {
            if ( !t.empty() ) {
                res.push_back( t );
                t = "";
            }
        } else {
            t += s[i];
        }
    }
    if ( !t.empty() ) {
        res.push_back(t);
    }
    return res;
}

vector<int> splitInt( const string& s, const string& delim =" " ) {
    vector<string> tok = split( s, delim );
    vector<int> res;
    for ( int i = 0 ; i != tok.size(); i++ )
        res.push_back( atoi( tok[i].c_str() ) );
    return res;
}
// END CUT HERE

// BEGIN CUT HERE
#define ARRSIZE(x) (sizeof(x)/sizeof(x[0]))

template<typename T> void print( T a ) {
    cerr << a;
}
static void print( long long a ) {
    cerr << a << "L";
}
static void print( string a ) {
    cerr << '"' << a << '"';
}
template<typename T> void print( vector<T> a ) {
    cerr << "{";
    for ( int i = 0 ; i != a.size() ; i++ ) {
        if ( i != 0 ) cerr << ", ";
        print( a[i] );
    }
    cerr << "}" << endl;
}
template<typename T> void eq( int n, T have, T need ) {
    if ( have == need ) {
        cerr << "Case " << n << " passed." << endl;
    } else {
        cerr << "Case " << n << " failed: expected ";
        print( need );
        cerr << " received ";
        print( have );
        cerr << "." << endl;
    }
}
template<typename T> void eq( int n, vector<T> have, vector<T> need ) {
    if( have.size() != need.size() ) {
        cerr << "Case " << n << " failed: returned " << have.size() << " elements; expected " << need.size() << " elements.";
        print( have );
        print( need );
        return;
    }
    for( int i= 0; i < have.size(); i++ ) {
        if( have[i] != need[i] ) {
            cerr << "Case " << n << " failed. Expected and returned array differ in position " << i << ".";
            print( have );
            print( need );
            return;
        }
    }
    cerr << "Case " << n << " passed." << endl;
}
static void eq( int n, string have, string need ) {
    if ( have == need ) {
        cerr << "Case " << n << " passed." << endl;
    } else {
        cerr << "Case " << n << " failed: expected ";
        print( need );
        cerr << " received ";
        print( have );
        cerr << "." << endl;
    }
}

// END CUT HERE

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    int get(int a, int b){
        for (int i = a+1; i <b; ++i)
        {
            if(gcd(i,a)==1 && gcd(i,b)==1){
                return 1;
            }
        }
        return 2;
    }
class EllysCoprimesDiv2 {
public:
    int getCount(vector <int> numbers) {
        int res=0;
        sort(all(numbers));
        for (int i = 1; i < numbers.size(); ++i)
        {
            int a = numbers[i-1];
            int b = numbers[i];
            if(gcd(a,b)!=1){
                res+=get(a,b);
            }
        }
        return res;
    }
};

// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        int numbersARRAY[] = {2200, 42, 2184, 17};
        vector <int> numbers( numbersARRAY, numbersARRAY+ARRSIZE(numbersARRAY) );
        EllysCoprimesDiv2 theObject;
        eq(0, theObject.getCount(numbers),3);
    }
    {
        int numbersARRAY[] = {13, 1, 6, 20, 33};
        vector <int> numbers( numbersARRAY, numbersARRAY+ARRSIZE(numbersARRAY) );
        EllysCoprimesDiv2 theObject;
        eq(1, theObject.getCount(numbers),0);
    }
    {
        int numbersARRAY[] = {7, 42};
        vector <int> numbers( numbersARRAY, numbersARRAY+ARRSIZE(numbersARRAY) );
        EllysCoprimesDiv2 theObject;
        eq(2, theObject.getCount(numbers),1);
    }
    {
        int numbersARRAY[] = {55780, 44918, 55653, 4762, 41536, 40083, 79260, 7374, 24124, 91858, 7856,
            12999, 64025, 12706, 19770, 71495, 32817, 79309, 53779, 8421, 97984, 34586,
            893, 64549, 77792, 12143, 52732, 94416, 54207, 51811, 80845, 67079, 14829,
            25350, 22976, 23932, 62273, 58871, 82358, 13283, 33667, 64263, 1337, 42666};
        vector <int> numbers( numbersARRAY, numbersARRAY+ARRSIZE(numbersARRAY) );
        EllysCoprimesDiv2 theObject;
        eq(3, theObject.getCount(numbers),15);
    }
        {
        int numbersARRAY[] = {55780, 44918, 55653, 4762, 41536, 40083, 79260, 7374, 24124, 91858, 7856,
            12999, 64025, 12706, 19770, 71495, 32817, 79309, 53779, 8421, 97984, 34586,
            893, 64549, 77792, 12143, 52732, 94416, 54207, 51811, 80845, 67079, 14829,
            25350, 22976, 23932, 62273, 58871, 82358, 13283, 33667, 64263, 1337, 100000};
        vector <int> numbers( numbersARRAY, numbersARRAY+ARRSIZE(numbersARRAY) );
        EllysCoprimesDiv2 theObject;
        eq(3, theObject.getCount(numbers),15);
    }
}
// END CUT HERE
