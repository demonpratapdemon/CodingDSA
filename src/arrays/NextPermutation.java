/**
 * 
 */
package arrays;

/**
 * @author PRATAP LeetCode 31
 *
 */
public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 4, 3, 2, 1 };
		nextPermutation(nums);
	}

	public static void nextPermutation(int[] nums) {

		int n = nums.length;
		int idx1 = -1, idx2 = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				idx1 = i;
				break;
			}
		}
		if (idx1 != -1) {
			for (int i = n - 1; i > idx1; i--) {
				if (nums[i] > nums[idx1]) {
					idx2 = i;
					break;
				}
			}

			int temp = nums[idx1];
			nums[idx1] = nums[idx2];
			nums[idx2] = temp;
		}
		for (int i = idx1 + 1, j = n - 1; i <= j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		for (int i : nums)
			System.out.print(i + " ");
	}

}
