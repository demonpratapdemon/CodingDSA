/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 27
 *
 */
public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 3, 2, 2, 3 }, val = 3;
		int k = removeElement(nums, val);
		System.out.println(k);
	}

	public static int removeElement(int[] nums, int val) {
		int i = 0, j = nums.length - 1;
		if (j < 0)
			return 0;
		while (j >= 0 && nums[j] == val)
			j--;
		int count = 0;
		while (i <= j) {
			if (nums[i] == val) {
				nums[i] = nums[j];
				nums[j] = val;
				while (nums[j] == val)
					j--;
			}
			count++;
			i++;
		}
		return count;
	}
}
