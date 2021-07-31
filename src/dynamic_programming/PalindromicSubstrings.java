package dynamic_programming;

/**
 * @author PRATAP LeetCode 647 + LeetCode 5
 *
 */
public class PalindromicSubstrings {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babad";
		System.out.println(countSubstrings(s));
	}

	public static int countSubstrings(String s) {
		int n = s.length();
		int count = 0;
		boolean[][] dp = new boolean[n][n];
		String largest = "";
		for (int gap = 0; gap < n; gap++) {
			int i = 0;
			int j = i + gap;
			while (j < n) {
				if (gap == 0) {
					dp[i][j] = true;
					count++;
					largest = s.substring(i, j + 1);
				} else if (s.charAt(i) == s.charAt(j) && gap == 1) {
					dp[i][j] = true;
					count++;
					largest = s.substring(i, j + 1);
				} else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					count++;
					largest = s.substring(i, j + 1);
				}
				i++;
				j++;
			}
		}
		System.out.println(largest);
		return count;
	}
}
