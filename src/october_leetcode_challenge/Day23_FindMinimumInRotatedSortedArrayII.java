/**
 * 
 */
package october_leetcode_challenge;

/**
 * @author PRATAP LeetCode 154
 *
 */
public class Day23_FindMinimumInRotatedSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 3 };
		Day23_FindMinimumInRotatedSortedArrayII obj = new Day23_FindMinimumInRotatedSortedArrayII();
		int ans = obj.findMin(nums);
		System.out.println(ans);
	}

	public int findMin(int[] nums) {
		if (nums[0] < nums[nums.length - 1])
			return nums[0];
		int l = 0, h = nums.length - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (nums[m] > nums[h]) {
				l = m + 1;
			} else if (nums[m] < nums[h]) {
				h = m;
			} else {
				h--;
			}
		}
		return nums[l];
	}
}
