/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class FindPeakElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 0 };
		int idx = findPeakElement(nums);
		System.out.println(idx);
	}

	public static int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		int l = 0;
		int h = nums.length - 1;
		int m = -1;
		while (l <= h) {
			m = l + (h - l) / 2;
			if ((m > 0 && nums[m] > nums[m - 1]) || (m == 0)) {
				l = m + 1;
			} else {
				h = m - 1;
			}

		}
		return l - 1;
	}

}
