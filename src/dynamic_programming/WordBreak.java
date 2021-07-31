/**
 * 
 */
package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go",
				"mango" };
		String s = "ilikesamsung";
		List<String> wordDict = new ArrayList<String>();
		for (String str : words)
			wordDict.add(str);
		boolean ans = wordBreak(s, wordDict);
		System.out.println(ans);
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				String word2Check = s.substring(j, i + 1);
				System.out.println(word2Check);
				if (wordDict.contains(word2Check)) {
					if (j > 0) {
						dp[i] += dp[j - 1];
					} else {
						dp[i] += 1;
					}
				}
			}
		}
		return dp[n - 1] > 0;
	}

}
