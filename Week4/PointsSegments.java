import java.util.*;
import java.io.*;
public class PointsSegments
{


    /************************ SOLUTION STARTS HERE ***********************/



    private static void solve(FastScanner s1, PrintWriter out) {

	int S = s1.nextInt();
	int P = s1.nextInt();
	int seg[][] = new int[S][2];
	for (int i = 0; i < S; i++) {
	    seg[i][0] = s1.nextInt();
	    seg[i][1] = s1.nextInt();
	}
	int points[] = s1.nextIntArray(P);
	int temp_points[] = new int[P];
	System.arraycopy(points, 0, temp_points, 0, P);
	Arrays.sort(points);
	TreeMap<Integer, Integer> map = new TreeMap<>();
	for (int i = 0; i < P; i++)
	    map.put(points[i], i);
	int dp[] = new int[P + 1]; // We increment the left end point and
	// decrement the right+1 end point
	for (int i = 0; i < S; i++) {
	    Map.Entry<Integer, Integer> e1 = map.ceilingEntry((seg[i][0]));
	    Map.Entry<Integer, Integer> e2 = map.floorEntry(seg[i][1]);
	    if (e1 != null && e2 != null) {
		int lo = e1.getValue();
		int hi = e2.getValue();
		if (lo <= hi) {
		    dp[lo]++;
		    dp[hi + 1]--;
		}
	    }
	}
	for (int i = 1; i < P; i++)
	    dp[i] += dp[i - 1];
	for (int point : temp_points)
	    out.print(dp[map.get(point)] + " ");
    }


    /************************ SOLUTION ENDS HERE ************************/





    /************************ TEMPLATE STARTS HERE *********************/

    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false); 
	solve(in, out);
	in.close();
	out.close();
    }    

    static class FastScanner{
	BufferedReader reader;
	StringTokenizer st;
	FastScanner(InputStream stream){reader=new BufferedReader(new InputStreamReader(stream));st=null;}	
	String next()
	{while(st == null || !st.hasMoreTokens()){try{String line = reader.readLine();if(line == null){return null;}		    
	st = new StringTokenizer(line);}catch (Exception e){throw new RuntimeException();}}return st.nextToken();}
	String nextLine()  {String s=null;try{s=reader.readLine();}catch(IOException e){e.printStackTrace();}return s;}	    	  	
	int    nextInt()   {return Integer.parseInt(next());}
	long   nextLong()  {return Long.parseLong(next());}		
	double nextDouble(){return Double.parseDouble(next());}
	char   nextChar()  {return next().charAt(0);}
	int[]  nextIntArray(int n)         {int[] arr= new int[n];   int i=0;while(i<n){arr[i++]=nextInt();}  return arr;}
	long[] nextLongArray(int n)        {long[]arr= new long[n];  int i=0;while(i<n){arr[i++]=nextLong();} return arr;}	
	int[]  nextIntArrayOneBased(int n) {int[] arr= new int[n+1]; int i=1;while(i<=n){arr[i++]=nextInt();} return arr;}	    	
	long[] nextLongArrayOneBased(int n){long[]arr= new long[n+1];int i=1;while(i<=n){arr[i++]=nextLong();}return arr;}	    	
	void   close(){try{reader.close();}catch(IOException e){e.printStackTrace();}}				
    }

    /************************ TEMPLATE ENDS HERE ************************/
}