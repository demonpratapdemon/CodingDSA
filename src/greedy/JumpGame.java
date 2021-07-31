/**
 * 
 */
package greedy;

/**
 * @author PRATAP
 *
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 0, 4 };
		boolean ans = canJump(nums);
		System.out.println(ans);
	}

	public static boolean canJump(int[] nums) {
		int n = nums.length - 1;
		int reachable = 0;
		for (int i = 0; i <= n; i++) {
			if (i > reachable)
				return false;
			reachable = Math.max(reachable, i + nums[i]);
			if (reachable >= n)
				return true;
		}
		return true;
	}
}
