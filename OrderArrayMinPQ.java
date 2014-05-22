public class OrderArrayMinPQ<Key extends Comparable<Key>>
{
	private Key[] a;// PQ entity
	private int N; 	// size
	/* Constructors */
	public OrderArrayMinPQ(){}
	public OrderArrayMinPQ(int cap)
	{ a = (Key[]) new Comparable[cap]; }	//capacity of array
	public OrderArrayMinPQ(Key[] a)
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
	public void insert(Key v)
	{
		a[N++] = v;
		for (int i = N-1; i > 0 && less(a[i-1], a[i]); i--)
			exch(a, i, i-1);
		}
	public Key min()	{ return a[N-1]; }
	public Key delMin() { return a[--N]; }
	
}