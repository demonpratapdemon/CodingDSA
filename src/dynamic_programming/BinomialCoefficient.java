/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP PAscal's Triangle
 *
 */
public class BinomialCoefficient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 778;
		int r = 116;
		int ans = nCr(n, r);
		System.out.println(ans);
	}

	static int nCr(int n, int r) {
		// code here
		if (r > n)
			return 0;
		if (n - r > r)
			r = n - r;
		int mod = 1000000007;
		int[] dp = new int[r + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = r; j > 0; j--) {
				dp[j] = (dp[j] + dp[j - 1]) % mod;
			}
		}
		return dp[r];
	}
}
