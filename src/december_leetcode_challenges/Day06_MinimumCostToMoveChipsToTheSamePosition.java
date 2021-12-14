/**
 * 
 */
package december_leetcode_challenges;

/**
 * @author PRATAP LeetCode 1217
 *
 */
public class Day06_MinimumCostToMoveChipsToTheSamePosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] position = {2,2,2,3,3};
		Day06_MinimumCostToMoveChipsToTheSamePosition obj = new Day06_MinimumCostToMoveChipsToTheSamePosition();
		int ans = obj.minCostToMoveChips(position);
		System.out.println(ans);
	}

	public int minCostToMoveChips(int[] position) {
		int even = 0, odd = 0;
		int n = position.length;
		for (int i = 0; i < n; i++) {
			if (position[i] % 2 == 0)
				even++;
			else
				odd++;
		}
		if (odd > even)
			return even;
		else
			return odd;
	}
}
