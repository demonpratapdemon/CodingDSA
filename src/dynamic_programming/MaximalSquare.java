/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 221
 *
 */
public class MaximalSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		MaximalSquare obj = new MaximalSquare();
		int ans = obj.maximalSquare(matrix);
		System.out.println(ans);
	}

	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int max = 0;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1) {
					if (matrix[i][j] == '1')
						dp[i][j] = 1;
				} else if (j == n - 1) {
					if (matrix[i][j] == '1')
						dp[i][j] = 1;
				} else {
					if (matrix[i][j] != '0') {
						int min = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
						dp[i][j] = min + 1;
					}
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max == 1 ? max : max * max;
	}
}
