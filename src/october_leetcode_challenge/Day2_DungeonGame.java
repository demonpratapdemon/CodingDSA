/**
 * 
 */
package october_leetcode_challenge;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 174
 *
 */
public class Day2_DungeonGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int[][] dungeon = { { -2, 3, 5 } };
		Day2_DungeonGame obj = new Day2_DungeonGame();
		int ans = obj.calculateMinimumHP(dungeon);
		System.out.println(ans);
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length, n = dungeon[0].length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		dp[m][n] = 1;
		dp[m - 1][n] = 1;
		dp[m][n - 1] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int power = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];
				dp[i][j] = (power <= 0) ? 1 : power;
			}
		}
		return dp[0][0];
	}
}
