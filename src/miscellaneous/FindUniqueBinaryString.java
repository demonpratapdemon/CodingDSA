/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1980
 *
 */
public class FindUniqueBinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nums = { "00", "01" };
		FindUniqueBinaryString obj = new FindUniqueBinaryString();
		String ans = obj.findDifferentBinaryString(nums);
		System.out.println(ans);
	}

	public String findDifferentBinaryString(String[] nums) {
		StringBuilder sb = new StringBuilder();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			char ch = nums[i].charAt(i);
			if (ch == '0') {
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}

}
