public class SortPerformanceAnalysor
{
	public static double time(String alg, Comparable[] a)
	{
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) Insertion.sort(a);
		if (alg.equals("Selection")) Selection.sort(a);
		if (alg.equals("Shell"))	 Shell.sort(a);
		if (alg.equals("Merge")) 	 Merge.sort(a);
		if (alg.equals("Merge")) 	 MergeBU.sort(a);
		if (alg.equals("Quick")) 	 Quick.sort(a);
		if (alg.equals("Heap")) 	 Heap.sort(a);
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg, int N, int T)
	{
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++)
				a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args)
	{
		String alg1 = args[0];
		int N = Integer.parseInt(args[1]);
		int T = Integer.parseInt(args[2]);
		double t1 = timeRandomInput(alg1, N, T);
		StdOut.printf("For running %d random Doubles %d times:\n", N, T);
		StdOut.printf("%s runs %.2fs\n", alg1, t1);
	}
}