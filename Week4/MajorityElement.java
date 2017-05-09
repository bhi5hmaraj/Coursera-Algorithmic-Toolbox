import java.util.*;
import java.io.*;
class MajorityElement
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
    private static void solve1(FastScanner s1, PrintWriter out)/*Time : 0.8s*/{

	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	Arrays.sort(arr);
	int cnt = 1;
	for(int i=0;i<len-1;i++)
	{
	    if(arr[i] == arr[i+1])
		cnt++;
	    else
	    {
		if(cnt > len/2)
		{
		    out.print(1);
		    return;
		}
		else
		    cnt = 1;
	    }
	}
	
	out.print((cnt > len/2)?1:0);
    }

    private static void solve2(FastScanner s1, PrintWriter out)/*Time : 0.76s */{

	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	shuffleArray(arr);
	Arrays.sort(arr);
	int cnt = 1;
	for(int i=0;i<len-1;i++)
	{
	    if(arr[i] == arr[i+1])
		cnt++;
	    else
	    {
		if(cnt > len/2)
		{
		    out.print(1);
		    return;
		}
		else
		    cnt = 1;
	    }
	}
	
	out.print((cnt > len/2)?1:0);
    }
    private static void solve3(FastScanner s1, PrintWriter out)/*Time : 0.75s*/{

	int len = s1.nextInt();
	int temp = len;
	HashMap<Integer,Integer> freq = new HashMap<>();
	while(temp-->0)frequency(freq, s1.nextInt());
	for (Map.Entry<Integer,Integer> e : freq.entrySet()) 
	{
	    if(e.getValue().intValue() > (len / 2))
	    {
		out.print(1);
		return;
	    }
	}
	out.print(0);
    }
    private static void solve4(FastScanner s1, PrintWriter out)/*Time : 0.51s */{

	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	int curr = arr[0];
	int ct = 1;
	for(int i=1;i<len;i++)
	{
	    if(arr[i] == curr)
		ct++;
	    else
	    {
		ct--;
		if(ct == 0)
		{
		    curr = arr[i];
		    ct = 1;
		}
	    }
	}
	ct = 0;
	for(int x:arr)
	    if(x == curr)
		ct++;
	
	out.print((ct > len/2)?1:0);
    }
    /************************ SOLUTION ENDS HERE ************************/





    /************************ TEMPLATE STARTS HERE *********************/

    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false); 
	solve4(in, out);
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