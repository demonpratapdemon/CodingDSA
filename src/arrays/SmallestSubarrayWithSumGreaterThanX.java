/**
 * 
 */
package arrays;

/**
 * @author PRATAP
 *
 */
public class SmallestSubarrayWithSumGreaterThanX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a[] = { 0, 1, 4, 45, 6, 0, 19 };
		long ans = sb(a, a.length, 51);
		System.out.println(ans);
	}

	public static long sb(long a[], long n, long x) {
		// Your code goes here
		int i = 0, j = 0, min = Integer.MAX_VALUE;
		int sum = 0;
		while (i <= j && j < n) {
			while (sum <= x && j < n) {
				sum += a[j];
				j++;
			}
			while (sum > x && i < j) {
				min = Math.min(min, j - i);
				sum -= a[i];
				i++;
			}
		}
		return min;
	}

}
