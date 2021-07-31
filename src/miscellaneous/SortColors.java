/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 75
 *
 */
public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 0 };
		sortColors(nums);
	}

	public static void sortColors(int[] nums) {
		int[] arr = new int[3];
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]] += 1;
		}
		int p = 0;
		for (int i = 0; i < 3; i++) {
			if (arr[i] != 0) {
				nums[p++] = i;
				arr[i]--;
				i--;
			}
		}
		for (int i : nums)
			System.out.print(i + " ");
	}

}
