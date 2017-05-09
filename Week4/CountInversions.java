import java.util.*;
import java.io.*;
public class CountInversions
{

    
    /************************ SOLUTION STARTS HERE ***********************/

    private static int aux[];   //auxiliary array for merging
    
    private static long merge(int arr[],int lo,int mid,int hi)
    {
	int i = lo;
	int j = mid + 1;
	long inv = 0;
	System.arraycopy(arr, lo, aux, lo, hi - lo + 1);
	for(int curr = lo;curr<=hi;curr++)
	{
	    if(i>mid)
		arr[curr] = aux[j++];
	    else if(j>hi)
		arr[curr] = aux[i++];
	    else
	    {
		if(aux[i] > aux[j])
		{
		    inv += (long)(mid - i + 1);
		    arr[curr] = aux[j++];
		}
		else
		{
		    arr[curr] = aux[i++];
		}
	    }
	}
	return inv;
    }
    
    private static long countInversions(int arr[],int lo,int hi)
    {
	if(lo < hi)
	{
	    int mid = (lo + hi)/2;
	    long leftInv  = countInversions(arr, lo, mid);
	    long rightInv = countInversions(arr, mid+1, hi);
	    long totalInv = leftInv + rightInv + merge(arr, lo, mid, hi);
	    return totalInv;
	}
	else
	    return 0;
    }
    
    
    private static void solve(FastScanner s1, PrintWriter out){

	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	aux = new int[len];
	long inv = countInversions(arr, 0, len - 1);
	out.print(inv);
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