import java.util.*;
import java.io.*;
public class LCS3
{

    
    /************************ SOLUTION STARTS HERE ***********************/

    private static int[] lcs(int a[],int b[])
    {
	int n = a.length;
	int m = b.length;
	int dp[][] = new int [n+1][m+1];
	int x=-1,y=-1;
	int max = 0;
	for(int i=1;i<=n;i++)
	{
	    for(int j=1;j<=m;j++)
	    {
		dp[i][j] = (a[i-1] == b[j-1])?dp[i-1][j-1] + 1:0;
		if(dp[i][j] > max)
		{
		    max = dp[i][j];
		    x = i; y =j;
		}
	    }
	}
	if(x == -1 && y == -1)
	    return null;
	else
	{
	    int lcs[] = new int[max];
	    int ptr = max;
	    System.out.println(max);
	    while(dp[x][y] != 0)
	    {
		lcs[--ptr] = a[x-1];
		x--; y--;
	    }
	    return lcs;
	}
    }
    
    private static void solve(FastScanner s1, PrintWriter out){

	int a[] = s1.nextIntArray(s1.nextInt());
	int b[] = s1.nextIntArray(s1.nextInt());
	//int c[] = s1.nextIntArray(s1.nextInt());
	System.out.println(Arrays.toString(lcs(a, b)));
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