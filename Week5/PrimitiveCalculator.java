import java.util.*;
import java.io.*;
class PrimitiveCalculator
{


    /************************ SOLUTION STARTS HERE ***********************/



    private static void solve(FastScanner s1, PrintWriter out){

	int n = s1.nextInt();
	int n_ = n;
	int dp[] = new int[n + 1];	
	for(int i=2;i<=n;i++)
	{
	    dp[i] = dp[i-1] + 1;
	    if(i % 3 == 0)
		dp[i] = Math.min(dp[i],dp[i / 3] + 1);
	    if(i % 2 == 0)
		dp[i] = Math.min(dp[i],dp[i / 2] + 1);
	}
	ArrayDeque<Integer> stk = new ArrayDeque<>();
	stk.push(n);
	while(n != 1)
	{
	    if(dp[n] == dp[n-1] + 1)
		n -= 1;
	    else if(n%2==0 && dp[n] == dp[n/2] + 1)
		n /= 2;
	    else if(n%3==0 && dp[n] == dp[n/3] + 1)
		n /= 3;

	    stk.push(n);
	}
	out.println(dp[n_]);
	for(int x:stk)out.print(x + " ");
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