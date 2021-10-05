/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 26
 *
 */
public class RemoveDuplicatesFromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
		int ans = obj.removeDuplicates(nums);
		System.out.println(ans);
	}

	public int removeDuplicates(int[] nums) {
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n;) {
			nums[count++] = nums[i];
			int search = binarySearch(nums, nums[i], i + 1);
			if (search != -1) {
				i = search + 1;
			} else {
				i++;
			}
		}
		return count;
	}

	public int binarySearch(int[] nums, int target, int start) {
		if (start >= nums.length)
			return -1;
		int end = nums.length - 1;
		int pos = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				pos = mid;
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return pos;
	}
}
