/**
 * 
 */
package bitmanipulation;

/**
 * @author PRATAP
 *
 */
public class DuplicateNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 2, 2, 4 };
		int ans = findDuplicate(nums);
		System.out.println(ans);
	}

	public static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		fast = nums[0];
		while (slow != fast) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}

}
