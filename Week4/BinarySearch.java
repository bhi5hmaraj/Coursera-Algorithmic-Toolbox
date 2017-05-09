import java.util.*;
import java.io.*;
class BinarySearch
{

    
    
    /************************ SOLUTION STARTS HERE ***********************/

    private static int bsearch(int arr[],int key)
    {
	int lo = 0,hi = arr.length - 1,mid;
	while(lo <= hi)
	{
	    mid = (lo + hi) / 2;
	    if(arr[mid] == key)
		return mid;
	    else if(arr[mid] < key)
		lo = mid + 1;
	    else
		hi = mid -1;
	}
	return -1;
    }
    
    private static void solve1(FastScanner s1, PrintWriter out){

	int n = s1.nextInt();
	int arr1[] = s1.nextIntArray(n);
	int m = s1.nextInt();
	int arr2[] = s1.nextIntArray(m);
	for(int a:arr2)
	{
	    /*
	    int index = Arrays.binarySearch(arr1, a);
	    out.print(((index >= 0)?index:-1) + " ");
	    */
	    out.print(bsearch(arr1,a) + " ");
	}
    }

    private static void solve2(FastScanner s1, PrintWriter out){
	
	HashMap<Integer,Integer> mp = new HashMap<>();
	int n = s1.nextInt();
	for(int i=0;i<n;i++)
	    mp.put(s1.nextInt(), i);
	int m = s1.nextInt();
	int arr2[] = s1.nextIntArray(m);
	for(int a:arr2)
	{
	    Integer index = mp.get(a);
	    out.print(((index != null)?index:-1) + " ");
	}
    }
    
    /************************ SOLUTION ENDS HERE ************************/
    
    
    
    
    
    /************************ TEMPLATE STARTS HERE *********************/

    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false); 
	solve1(in, out);
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