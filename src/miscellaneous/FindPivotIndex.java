/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 724
 *
 */
public class FindPivotIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 7, 3, 6, 5, 6 };
		FindPivotIndex obj = new FindPivotIndex();
		int ans = obj.pivotIndex(nums);
		System.out.println(ans);
	}

	public int pivotIndex(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		int ps = 0;
		for (int i = 0; i < nums.length; i++) {
			int rs = sum - ps - nums[i];
			if (ps == rs)
				return i;
			ps += nums[i];
		}
		return -1;
	}
}
