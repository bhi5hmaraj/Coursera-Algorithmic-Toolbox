import java.util.*;
import java.io.*;
class MaximumValueOfExpr
{

    
    /************************ SOLUTION STARTS HERE ***********************/

    private static long eval(long a,char ch,long b)
    {
	switch(ch)
	{
	case '+':
	    return a + b;
	case '-':
	    return a - b;
	case '*':
	    return a * b;
	default:
	    return -1;
	}
    }
    
    private static void solve(FastScanner s1, PrintWriter out){

	char expr[] = s1.nextLine().toCharArray();
	int len = expr.length/2 + 1;
	long dp[][][] = new long[len][len][2];
	for(int i=0;i<len;i++)
	    dp[i][i][0] = dp[i][i][1] = Character.getNumericValue(expr[2*i]);
	
	for(int s=1;s<len;s++)
	{
	    for(int i=0;i<len-s;i++)
	    {
		int j = i + s;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for(int k = i;k<j;k++)
		{
		    char op = expr[(2 * k) + 1];
		    min = Math.min(min,
			    Math.min(
		            Math.min(eval(dp[i][k][0], op, dp[k + 1][j][0]), eval(dp[i][k][0], op, dp[k + 1][j][1])),
			    Math.min(eval(dp[i][k][1], op, dp[k + 1][j][0]), eval(dp[i][k][1], op, dp[k + 1][j][1]))));
		    max = Math.max(max,
			    Math.max(
			    Math.max(eval(dp[i][k][0], op, dp[k + 1][j][0]),eval(dp[i][k][0], op, dp[k + 1][j][1])),
			    Math.max(eval(dp[i][k][1], op, dp[k + 1][j][0]), eval(dp[i][k][1], op, dp[k + 1][j][1]))));
		}
		dp[i][j][0] = min;
		dp[i][j][1] = max;
	    }
	}
	out.print(dp[0][len-1][1]);
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