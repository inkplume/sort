public class DisorderArrayMaxPQ<Key extends Comparable<Key>>
{
	private Key[] a;// PQ entity
	private int N; 	// size
	/* Constructors */
	public DisorderArrayMaxPQ(){}
	public DisorderArrayMaxPQ(int cap)
	{ a = (Key[]) new Comparable[cap]; }	//capacity of array
	public DisorderArrayMaxPQ(Key[] a)
	{
		int cap = a.length;
		//a = new Key[cap]; ERROR:generic array creation is disallowed in Java!
		this.a = (Key[]) new Comparable[cap];
		for (int i = 0; i < cap; i++)
			this.a[i] = a[i];
	}

	/* Instance Method */
	private boolean less(Key v, Key w)			{ return v.compareTo(w) < 0;}
	private void exch(Key[] a, int i, int j) { Key t = a[i]; a[i] = a[j]; a[j] = t; }

	public boolean isEmpty()  { return N ==0; }
	public int size()		  { return N; }	
	public void insert(Key v) { a[N++] = v;}
	public Key max()
	{
		int max = N-1;
		for (int i = max; i >= 0; i--)
			if (less(a[max], a[i])) max = i;
		return a[max];
	}
	public Key delMax()
	{
		int max = N-1;
		for (int i = max; i >= 0; i--)
			if (less(a[max], a[i])) max = i;
		exch(a, max, N-1);
		return a[--N];
	}
	
}