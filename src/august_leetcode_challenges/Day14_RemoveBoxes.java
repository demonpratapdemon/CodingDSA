/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP
 *
 */
public class Day14_RemoveBoxes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] boxes = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
		Day14_RemoveBoxes obj = new Day14_RemoveBoxes();
		int ans = obj.removeBoxes(boxes);
		System.out.println(ans);
	}

	public int removeBoxes(int[] boxes) {
		if (boxes == null || boxes.length == 0)
			return 0;
		int n = boxes.length;
		int[][][] dp = new int[n][n][n];
		int ans = dfs(boxes, 0, n - 1, dp, 0);
		return ans;
	}

	private int dfs(int[] boxes, int left, int right, int[][][] dp, int streak) {
		// TODO Auto-generated method stub
		if (left > right)
			return 0;
		else if (left == right)
			return (streak + 1) * (streak + 1);
		else if (dp[left][right][streak] != 0)
			return dp[left][right][streak];
		else {
			int max = (streak + 1) * (streak + 1) + dfs(boxes, left + 1, right, dp, 0);
			for (int i = left + 1; i <= right; i++) {
				if (boxes[left] == boxes[i]) {
					max = Math.max(max, dfs(boxes, left + 1, i - 1, dp, 0) + dfs(boxes, i, right, dp, streak + 1));
				}
			}
			return dp[left][right][streak] = max;
		}

	}
}
