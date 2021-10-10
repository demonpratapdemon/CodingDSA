/**
 * 
 */
package october_leetcode_challenge;

/**
 * @author PRATAP LeetCode 201
 *
 */
public class Day10_BitwiseANDOfNumbersRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int left = 1, right = 2147483647;
		Day10_BitwiseANDOfNumbersRange obj = new Day10_BitwiseANDOfNumbersRange();
		int ans = obj.rangeBitwiseAnd(left, right);
		System.out.println(ans);
	}

	public int rangeBitwiseAnd(int left, int right) {
		int count = 0;
		while (left != right) {
			left >>= 1;
			right >>= 1;
			count++;
			if (left == 0)
				break;
		}
		if (left == 0)
			return 0;
		return left << count;
	}

}
