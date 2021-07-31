/**
 * 
 */
package bitmanipulation;

/**
 * @author PRATAP
 *
 */
public class NonRepeatingNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 2, 1, 4 };
		int[] ans = singleNumber(nums);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] singleNumber(int[] nums) {
		// Code here
		int n = nums.length;
		int allXOR = nums[0];
		int[] ans = new int[2];
		for (int i = 1; i < n; i++)
			allXOR ^= nums[i];
		int setBitMask = allXOR & -allXOR;
		int num1 = 0, num2 = 0;
		for (int num : nums) {
			if ((num & setBitMask) > 0) {
				num1 = num ^ num1;
			} else {
				num2 = num ^ num2;
			}
		}
		if(num1 > num2) {
			ans[0] = num2;
			ans[1] = num1;
		} else {
			ans[0] = num1;
			ans[1] = num2;
		}
		return ans;
	}
}
