/**
 * 
 */
package arrays;

/**
 * @author PRATAP LeetCode 238
 *
 */
public class ProductOfArrayExceptSelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 1, 0, -3, 3 };
		int[] ans = productExceptSelf1(nums);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] productExceptSelf(int[] nums) {
		int pdt = 1, pdtWith = 1;
		int countZ = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				pdtWith *= 0;
				countZ++;
			} else {
				pdt *= nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0 && countZ <= 0) {
				nums[i] = pdt / nums[i];
			} else if (nums[i] == 0 && countZ == 1) {
				nums[i] = pdt;
			} else {
				nums[i] = pdtWith;
			}
		}
		return nums;
	}

	public static int[] productExceptSelf1(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		ans[0] = nums[0];
		for (int i = 1; i < n; i++) {
			ans[i] = ans[i - 1] * nums[i];
		}
		int pdt = nums[n - 1];
		ans[n - 1] = ans[n - 2];
		for (int i = n - 2; i > 0; i--) {
			ans[i] = ans[i - 1] * pdt;
			pdt *= nums[i];
		}
		ans[0] = pdt;
		return ans;
	}
}
