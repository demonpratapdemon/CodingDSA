/**
 * 
 */
package search_sort;

/**
 * @author PRATAP LeetCode 153
 *
 */
public class FindMinimumInRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 4, 5, 1, 2 };
		int pivot = findMin(nums);
		System.out.println(pivot);
	}

	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] < nums[high]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return nums[low];
	}
}
