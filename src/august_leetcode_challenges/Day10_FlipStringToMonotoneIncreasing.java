/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP LeetCode 926
 *
 */
public class Day10_FlipStringToMonotoneIncreasing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "00011000";
		Day10_FlipStringToMonotoneIncreasing obj = new Day10_FlipStringToMonotoneIncreasing();
		int ans = obj.minFlipsMonoIncr(s);
		System.out.println(ans);
	}

	public int minFlipsMonoIncr(String s) {
		if (s.length() == 0)
			return 0;
		int i = 0;
		while (i < s.length() && s.charAt(i) == '0')
			i++;
		int oneCount = 0, zeroToOnes = 0;
		while (i < s.length()) {
			if (s.charAt(i) == '0') {
				zeroToOnes++;
			} else {
				oneCount++;
			}
			zeroToOnes = Math.min(oneCount, zeroToOnes);
			i++;
		}
		return zeroToOnes;
	}
}
