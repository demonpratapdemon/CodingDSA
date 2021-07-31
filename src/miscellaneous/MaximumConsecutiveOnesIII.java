/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1004
 *
 */
public class MaximumConsecutiveOnesIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, k = 2;
//		int nums[] = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, k = 3;
//		int nums[] = { 0, 0, 0, 1 }, k = 0;
//		int nums[] = { 0, 0, 0, 1 }, k = 4;
		int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, k = 0;
		int ans = longestOnes(nums, k);
		System.out.println("Max = " + ans);
	}

	public static int longestOnes(int[] nums, int k) {
		int n = nums.length;
		int max = 0;
		int i = -1, j = -1;
		int curr = k;
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			while (i < n && curr >= 0) {
				f1 = true;
				i++;
				if (i < n && nums[i] == 0) {
					curr--;
				}
			}

			while (j < i && curr < 0) {
				f2 = true;
				j++;
				max = Math.max(max, i - j);
				if (j < n && nums[j] == 0)
					curr++;
			}
			if (!f1 && !f2)
				break;
		}
		if ((nums[i - 1] == 1 && curr >= 0) || j == -1) {
			max = Math.max(max, i - j - 1);
		}
		return max;
	}
}
