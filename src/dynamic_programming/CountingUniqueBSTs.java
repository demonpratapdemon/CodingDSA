/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 96 f(n) = sum(f(i-1)* f(n-i)), for all i belonging to
 *         1 to N Catalan Number Problem
 *
 */
public class CountingUniqueBSTs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(numTrees(n));
	}

	public static int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += dp[j] * dp[i - j - 1];
			}
			dp[i] = sum;
		}
		return dp[n];
	}

}
