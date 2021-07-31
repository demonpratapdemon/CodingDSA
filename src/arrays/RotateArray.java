/**
 * 
 */
package arrays;

/**
 * @author PRATAP LeetCode 189
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { -1, -100, 3, 99 }, k = 2;
		RotateArray obj = new RotateArray();
		obj.rotate1(nums, k);
		for (int i : nums)
			System.out.print(i + " ");
	}

	public void rotate1(int[] nums, int k) {
		int n = nums.length;
		int rot = k % n;
		if (rot > 0) {
			while (rot-- > 0) {
				int prev = nums[0];
				int temp = prev;
				for (int i = 1; i < n; i++) {
					temp = nums[i];
					nums[i] = prev;
					prev = temp;
				}
				nums[0] = temp;
			}
		}
	}

	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}
