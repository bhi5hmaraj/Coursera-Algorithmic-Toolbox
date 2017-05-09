import java.util.*;
import java.io.*;

class PairwiseDistinctSummands
{

	/************************ SOLUTION STARTS HERE ************************/

	private static boolean isPerfectSquare(long N)
	{
		long root = (long) (Math.sqrt(N));
		return root * root == N;
	}

	private static ArrayList<Integer> generateEdgeCase(int MAX_SIZE)
	{
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 1; i <= MAX_SIZE; i++)
			if (isPerfectSquare(9L + (8L * (long) i)))
				a.add(i);

		return a;
	}

	private static void solve(FastScanner s1, PrintWriter out)
	{

		long K = s1.nextLong();
		double root = (Math.sqrt(9.0 + (8.0 * K)) - 3.0) / 2.0;
		boolean isPerfectRoot = isPerfectSquare(9L + (8L * K));
		int MAX = (int) (Math.ceil(root));
		// out.println("MAX "+MAX);
		long sum = 0;
		// ArrayList<Long> arl = new ArrayList<>();
		int storage[] = new int[45000]; // Upper bound
		int ct = 0;
		for (int i = 1; i <= MAX; i++)
		{
			sum += (long) i;
			if (isPerfectRoot)
			{
				if (K - sum > MAX)/* arl.add((long)i); */ storage[ct++] = i;
				else
					sum -= i;
			}
			else
			{
				if (K - sum >= MAX)/* arl.add((long)i); */ storage[ct++] = i;
				else
					sum -= i;
			}
		}
		/* arl.add(K - sum); */
		storage[ct++] = (int) (K - sum);
		// out.println(arl.size());
		out.println(ct);
		// for(long a:arl)out.print(a + " ");
		for (int i = 0; i < ct; i++)
			out.print(storage[i] + " ");

	}

	/************************ SOLUTION ENDS HERE ************************/

	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String[] args) throws IOException
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false);
		solve(in, out);
		in.close();
		out.close();
	}

	static class FastScanner
	{
		public BufferedReader reader;
		public StringTokenizer st;

		public FastScanner(InputStream stream)
		{
			reader = new BufferedReader(new InputStreamReader(stream));
			st = null;
		}

		public String next()
		{
			while (st == null || !st.hasMoreTokens())
			{
				try
				{
					String line = reader.readLine();
					if (line == null)
						return null;
					st = new StringTokenizer(line);
				}
				catch (Exception e)
				{
					throw (new RuntimeException());
				}
			}
			return st.nextToken();
		}

		public String nextLine()
		{
			String str = null;
			try
			{
				str = reader.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}

		public int nextInt()
		{
			return Integer.parseInt(next());
		}

		public long nextLong()
		{
			return Long.parseLong(next());
		}

		public double nextDouble()
		{
			return Double.parseDouble(next());
		}

		public char nextChar()
		{
			return next().charAt(0);
		}

		int[] nextIntArray(int n)
		{
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
			{
				arr[i] = nextInt();
			}
			return arr;
		}

		long[] nextLongArray(int n)
		{
			long[] arr = new long[n];
			for (int i = 0; i < n; i++)
			{
				arr[i] = nextLong();
			}
			return arr;
		}

		int[] nextIntArrayOneBased(int n)
		{
			int[] arr = new int[n + 1];
			for (int i = 1; i <= n; i++)
			{
				arr[i] = nextInt();
			}
			return arr;
		}

		long[] nextLongArrayOneBased(int n)
		{
			long[] arr = new long[n + 1];
			for (int i = 1; i <= n; i++)
			{
				arr[i] = nextLong();
			}
			return arr;
		}

		public void close()
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/************************ TEMPLATE ENDS HERE ************************/
}
