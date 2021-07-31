/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP
 *
 */
public class PaintingTheFence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2, k = 4;
		long ways = countWays(n, k);
		System.out.println(ways);
	}

	public static long countWays(int n, int k) {
		// code here.
		if (n == 0)
			return 0;
		if (n == 1)
			return k;
		long[] same = new long[n + 1];
		long[] diff = new long[n + 1];
		int mod = 1000000007;
		same[2] = k % mod;
		diff[2] = (k * (k - 1)) % mod;
		for (int i = 3; i <= n; i++) {
			same[i] = diff[i - 1] % mod;
			diff[i] = (same[i - 1] + diff[i - 1] * (k - 1)) % mod;
		}
		return (same[n] + diff[n]) % mod;
	}
}
