/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCde 1748
 *
 */
public class SumOfUniqueNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 2 };
		int ans = sumOfUnique(nums);
		System.out.println(ans);
	}

	public static int sumOfUnique(int[] nums) {
		int[] uniq = new int[101];
		for (int i : nums)
			uniq[i] += 1;
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			if (uniq[i] == 1) {
				sum += i;
			}
		}
		return sum;
	}

}
