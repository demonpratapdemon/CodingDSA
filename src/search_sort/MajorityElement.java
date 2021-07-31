/**
 * 
 */
package search_sort;

/**
 * @author PRATAP Moore Voting algorithm
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 3 };
		int ans = majorityElement(nums);
		System.out.println(ans);
	}

	public static int majorityElement(int[] nums) {
		int major = nums[0];
		int counter = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != major) {
				counter--;
				if (counter == 0) {
					major = nums[i];
					counter++;
				}
			} else {
				counter++;
			}
		}
		counter = 0;
		for (int i : nums) {
			if (i == major) {
				counter++;
			}
		}
		if (counter > Math.floor(nums.length / 2))
			return major;
		return -1;
	}

}
