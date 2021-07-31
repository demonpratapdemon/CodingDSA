/**
 * 
 */
package heaps;

/**
 * @author PRATAP
 *
 */
public class Merge2MaxHeaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a[] = { 10, 5, 6, 2 };
		long b[] = { 12, 7, 9 };
		int n = a.length, m = b.length;
		long merged[] = new long[n + m];
		maxProfit(merged, a, b, n, m);
		for (long i : merged)
			System.out.print(i + " ");
	}

	public static void maxProfit(long merged[], long a[], long b[], long n, long m) {
//		long x = n - 1;
//		long y = m - 1;
//		long s, t;
//		for (int i = 0; i < n + m; i++) {
//			if (x >= 0)
//				s = a[0];
//			else
//				s = Long.MIN_VALUE;
//			if (y >= 0)
//				t = b[0];
//			else
//				t = Long.MIN_VALUE;
//			if (s > t && x >= 0) {
//				merged[i] = s;
//				swap(a, 0, x);
//				x--;
//				maxHeapify(a, 0, x);
//			} else if (t >= s && y >= 0) {
//				merged[i] = t;
//				swap(b, 0, y);
//				y--;
//				maxHeapify(a, 0, y);
//			}
//		}
		int i = 0;
		for (; i < n; i++) {
			merged[i] = a[i];
		}
		for (int j = 0; j < m; j++) {
			merged[i++] = b[j];
		}
		buildMaxHeap(merged, n+m);
	}

	private static void buildMaxHeap(long[] arr, long l) {
		// TODO Auto-generated method stub
		for (int i = 1; i < l; i++) {
			bottomUpHeapify(arr, i);
		}
	}

	private static void bottomUpHeapify(long[] arr, int i) {
		// TODO Auto-generated method stub
		int p = (i - 1) / 2;
		while (p >= 0) {
			if (arr[i] > arr[p]) {
				swap(arr, i, p);
				i = p;
				p = (p - 1) / 2;
			} else {
				break;
			}
		}
	}

	private static void maxHeapify(long[] arr, int i, long x) {
		// TODO Auto-generated method stub
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int max = i;
		if (r <= x) {
			if (arr[l] > arr[i]) {
				max = l;
			}
			if (arr[r] > arr[max]) {
				max = r;
			}
			swap(arr, i, max);
			maxHeapify(arr, max, x);
		} else if (l <= x) {
			if (arr[l] > arr[i]) {
				swap(arr, l, i);
			}
		}
	}

	private static void swap(long[] arr, int i, long x) {
		// TODO Auto-generated method stub
		long temp = arr[i];
		arr[i] = arr[(int) x];
		arr[(int) x] = temp;
	}

}
