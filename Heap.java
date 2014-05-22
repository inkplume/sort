public class Heap
{
	public static void sort(Comparable[] pq)
	{
		int N = pq.length;
		for (int k = N/2; k >= 1; k--)
			sink(pq, k, N);
		while (N > 1) {
			exch(pq, 1, N--);
			sink(pq, 1, N);
		}
	}
	private static void sink(Comparable[] pq, int k, int N)
	{
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && less(pq, j, j+1)) j++;
			if (!less(pq, k, j)) break;
			exch(pq, k, j);
			k = j;
		}
	}
	private static boolean less(Comparable[] a, int i, int j)
	{ return a[i-1].compareTo(a[j-1]) < 0; }
	private static boolean less(Comparable v, Comparable w)
	{ return v.compareTo(w) < 0; }
	private static void exch(Comparable[] a, int i, int j)
	{Comparable t = a[i-1]; a[i-1] = a[j-1]; a[j-1] = t; }
	private static void show(Comparable[] a)
	{
		int N = a.length;
		for (int i = 0; i < N; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	private static boolean isSorted(Comparable[] a)
	{
		int N = a.length;
		for (int i = 1; i < N; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}
	public static void main(String[] args)
	{
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}