import java.util.*;
import java.io.*;
public class ThreeWayQuickSort
{

    
    /************************ SOLUTION STARTS HERE ***********************/

    static  void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    
    private static <Key> void frequency(Map<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else	    	
    		mp.put(k, query + 1);	    	
    }
    
    private static void solve1(FastScanner s1, PrintWriter out){
	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	Arrays.sort(arr);
	for(int x:arr)out.print(x + " ");
    }
    
    private static void solve2(FastScanner s1, PrintWriter out){
	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	shuffleArray(arr);
	Arrays.sort(arr);
	for(int x:arr)out.print(x + " ");
    }
    
    private static void solve3(FastScanner s1, PrintWriter out){
	int len = s1.nextInt();
	TreeMap<Integer,Integer> freq = new TreeMap<>();
	while(len-->0)frequency(freq, s1.nextInt());
	for (Map.Entry<Integer,Integer> e : freq.entrySet()) 
	{
	    for(int j=e.getValue();j>0;j--)
		out.print(e.getKey() + " ");
	}
    }
    
    private static void solve4(FastScanner s1, PrintWriter out){
	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	
    }
    
    /************************ SOLUTION ENDS HERE ************************/
    
    
    
    
    
    /************************ TEMPLATE STARTS HERE *********************/

    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false); 
	solve2(in, out);
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