import java.util.*;
import java.io.*;
class CoveringSegmentsbyPoints
{

    /************************ SOLUTION STARTS HERE ************************/

    static class Segment implements Comparable<Segment>
    {
	int left , right;
	Segment(int l,int r)
	{
	    left = l;
	    right = r;
	}
	@Override
	public int compareTo(Segment o) {
	    return this.right - o.right;
	}
	@Override
	public String toString() {
	    return "["+this.left+", "+this.right+"]";
	}
    }

    private static void solve(FastScanner s1, PrintWriter out){

	int len = s1.nextInt();
	Segment arr[] = new Segment[len];
	for(int i=0;i<len;i++)
	    arr[i] = new Segment(s1.nextInt(), s1.nextInt());

	Arrays.sort(arr);
	//System.out.println(Arrays.toString(arr));
	ArrayList<Integer> arl = new ArrayList<>();

	for(int i=0;i<len;i++)
	{
	    if(arr[i] != null)
	    {
		for(int j=0;j<len;j++)
		{
		    if(j != i && arr[j] != null)
		    {
			if(arr[i].right >= arr[j].left && arr[i].right <= arr[j].right)
			    arr[j] = null;
		    }
		}
		arl.add(arr[i].right);
	    }
	}
	out.println(arl.size());
	for(int a:arl)out.print(a + " ");
	out.println();
    }

    /************************ SOLUTION ENDS HERE ************************/



    /************************ TEMPLATE STARTS HERE ************************/

    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false); 
	solve(in, out);
	in.close();
	out.close();
    }    

    static class FastScanner{
	public BufferedReader reader;
	public StringTokenizer st;
	public FastScanner(InputStream stream){
	    reader = new BufferedReader(new InputStreamReader(stream));
	    st = null;
	}
	public String next(){
	    while(st == null || !st.hasMoreTokens()){
		try{
		    String line = reader.readLine();
		    if(line == null) return null;
		    st = new StringTokenizer(line);
		}catch (Exception e){
		    throw (new RuntimeException());
		}
	    }
	    return st.nextToken();
	}
	public String nextLine(){
	    String str = null;
	    try {
		str = reader.readLine();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    return str;
	}
	public int nextInt(){
	    return Integer.parseInt(next());
	}
	public long nextLong(){
	    return Long.parseLong(next());
	}
	public double nextDouble(){
	    return Double.parseDouble(next());
	}
	public char nextChar(){
	    return next().charAt(0);
	}
	int[] nextIntArray(int n) {
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
		arr[i] = nextInt();
	    }
	    return arr;
	}
	long[] nextLongArray(int n) {
	    long[] arr = new long[n];
	    for (int i = 0; i < n; i++) {
		arr[i] = nextLong();
	    }
	    return arr;
	}
	int[] nextIntArrayOneBased(int n) {
	    int[] arr = new int[n+1];
	    for (int i = 1; i <= n; i++) {
		arr[i] = nextInt();
	    }
	    return arr;
	}

	long[] nextLongArrayOneBased(int n) {
	    long[] arr = new long[n+1];
	    for (int i = 1; i <= n; i++) {
		arr[i] = nextLong();
	    }
	    return arr;
	}
	public void close(){	
	    try{ reader.close(); } catch(IOException e){e.printStackTrace();}
	}
    }

    /************************ TEMPLATE ENDS HERE ************************/
}
