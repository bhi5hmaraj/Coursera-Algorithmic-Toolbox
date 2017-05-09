import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static void swap(int a[],int i,int j)
    {
	int temp = a[i];
	a[i] = a[j];
	a[j] = temp;
    }
    private static int[] partition3(int[] a, int l, int r) {
	int piv = a[l];
	int lt = l;
	int gt = r;
	for(int i=l;i<=gt;)
	{
	    if(a[i] < piv)
	    {
		swap(a,i,lt);
		lt++;
		i++;
	    }
	    else if(a[i] > piv)
	    {
		swap(a,i,gt);
		gt--;       			
	    }
	    else
	    {
		i++;
	    }
	}
	int[] m = {lt, gt};
	return m;
    }


    private static void randomizedQuickSort(int[] a, int l, int r) {
	if (l >= r) {
	    return;
	}
	int k = random.nextInt(r - l + 1) + l;
	swap(a,k,l);
	int m[] = partition3(a, l, r);
	randomizedQuickSort(a, l, m[0] - 1);
	randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
	FastScanner scanner = new FastScanner(System.in);        
	PrintWriter out = 
		new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false); 
	int n = scanner.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++) {
	    a[i] = scanner.nextInt();
	}
	randomizedQuickSort(a, 0, n - 1);
	for (int i = 0; i < n; i++) {
	    out.print(a[i] + " ");
	}
	out.close();
	scanner.close();
    }

    static class FastScanner {
	BufferedReader br;
	StringTokenizer st;

	FastScanner(InputStream stream) {
	    try {
		br = new BufferedReader(new InputStreamReader(stream));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}

	String next() {
	    while (st == null || !st.hasMoreTokens()) {
		try {
		    st = new StringTokenizer(br.readLine());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	    return st.nextToken();
	}

	int nextInt() {
	    return Integer.parseInt(next());
	}
	void close(){try{br.close();}catch(IOException e){e.printStackTrace();}}
    }
}

