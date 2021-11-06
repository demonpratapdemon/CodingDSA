/**
 * 
 */
package november_leetcode_challenges;

/**
 * @author PRATAP LeetCode 260
 *
 */
public class Day6_SingleNumberIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		Day6_SingleNumberIII obj = new Day6_SingleNumberIII();
		int[] res = obj.singleNumber(nums);
		System.out.println(res[0] + " " + res[1]);
	}

	public int[] singleNumber(int[] nums) {
		int xor = nums[0];
		int[] res = new int[2];
		for (int i = 1; i < nums.length; i++) {
			xor ^= nums[i];
		}
		int d = xor & (-xor);
		int g1 = 0, g2 = 0;
		for (int num : nums) {
			if ((num & d) == 0) {
				if (g1 == 0)
					g1 = num;
				else
					g1 ^= num;
			} else {
				if (g2 == 0)
					g2 = num;
				else
					g2 ^= num;
			}
		}
		res[0] = g1;
		res[1] = g2;
		return res;
	}

}
