import java.util.*;
import java.io.*;
class FractionalKnapsack
{

	/************************ SOLUTION STARTS HERE ************************/

	static class Pair implements Comparable<Pair>
	{
		int weight,value;
		double vPerW;
		Pair(int value,int weight)
		{
			this.value = value;
			this.weight = weight;
			this.vPerW = ((double)value)/((double)weight);
		}
		@Override
		public int compareTo(Pair o) {
			return (new Double(o.vPerW)).compareTo(new Double(this.vPerW));
		}
	}
	private static void solve(FastScanner s1, PrintWriter out){

		int len = s1.nextInt();
		int weightOfBag = s1.nextInt();
		Pair arr[] = new Pair[len];
		for(int i=0;i<len;i++)
			arr[i] = new Pair(s1.nextInt(), s1.nextInt());
		
		Arrays.sort(arr);
		
		double maxPossible = 0.0;
		
		for(Pair p :arr)
		{
			if(weightOfBag == 0)
				break;
			
			if(weightOfBag > p.weight)
				maxPossible += (double)p.value;
			else
				maxPossible += (p.vPerW * (double)weightOfBag);
			
			weightOfBag -= Math.min(weightOfBag,p.weight);
		}
		out.printf("%.6f\n", maxPossible);
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
