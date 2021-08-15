/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1968
 *
 */
public class ArrayWithElementsNotEqualToAverageOfNeighbors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3, 4, 5 };
		ArrayWithElementsNotEqualToAverageOfNeighbors obj = new ArrayWithElementsNotEqualToAverageOfNeighbors();
		obj.rearrangeArray(nums);
		for (int x : nums)
			System.out.print(x + " ");
	}

	public int[] rearrangeArray(int[] nums) {
		int n = nums.length;
		for (int i = 1; i < n - 1; i++) {
			double d = (nums[i - 1] + nums[i + 1]) / 2.0;
			if (d == nums[i] && i + 2 < n) {
				int temp = nums[i + 1];
				nums[i + 1] = nums[i + 2];
				nums[i + 2] = temp;
			} else if (d == nums[i]) {
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
		}
		return nums;
	}

}
