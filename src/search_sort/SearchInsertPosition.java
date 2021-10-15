/**
 * 
 */
package search_sort;

/**
 * @author PRATAP LeetCode 35
 *
 */
public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 3, 5, 6 }, target = 5;
		int pos = searchInsert(nums, target);
		System.out.println(pos);
	}

	public static int searchInsert(int[] nums, int target) {
		int l = 0, h = nums.length - 1;
		int res = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target) {
				if (mid == 0) {
					return 0;
				}
				if (nums[mid - 1] < target)
					return mid;
				else
					h = mid - 1;
			} else {
				if (mid == nums.length - 1)
					return nums.length;
				if (nums[mid + 1] > target)
					return mid + 1;
				else
					l = mid + 1;
			}
		}
		return res;
	}
}
