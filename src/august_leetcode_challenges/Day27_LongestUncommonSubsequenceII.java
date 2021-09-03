/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP LeetCode 522
 *
 */
public class Day27_LongestUncommonSubsequenceII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "aba", "cdc", "eae" };
		Day27_LongestUncommonSubsequenceII obj = new Day27_LongestUncommonSubsequenceII();
		int ans = obj.findLUSlength(strs);
		System.out.println(ans);
	}

	public int findLUSlength(String[] strs) {
		int max = -1;
		int n = strs.length;
		for (int i = 0; i < n; i++) {
			int currLen = strs[i].length();
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (i != j && isSubSequence(strs[i], strs[j])) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				max = Math.max(max, currLen);
			}
		}
		return max;
	}

	private boolean isSubSequence(String str1, String str2) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) == str2.charAt(j))
				i++;
			j++;
		}
		return i == str1.length();
	}
}
