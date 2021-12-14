/**
 * 
 */
package november_leetcode_challenges;

/**
 * @author PRATAP LeetCode 540
 *
 */
public class Day20_SingleElementInASortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		Day20_SingleElementInASortedArray obj = new Day20_SingleElementInASortedArray();
		int ans = obj.singleNonDuplicate(nums);
		System.out.println(ans);
	}

	public int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int low = 0, high = nums.length - 1;
		if (nums[low] != nums[low + 1])
			return nums[low];
		if (nums[high] != nums[high - 1])
			return nums[high];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid % 2 == 0) {
				if (nums[mid + 1] == nums[mid]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				if (nums[mid] == nums[mid - 1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return nums[low];
	}

}
