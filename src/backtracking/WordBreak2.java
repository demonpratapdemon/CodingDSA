/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP LeetCode 140
 *
 */
public class WordBreak2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		int n = 5;
		List<String> dict = new ArrayList<String>();
		String[] arr = { "cat", "cats", "and", "sand", "dog" };
		for (String str : arr)
			dict.add(str);
		List<String> ans = wordBreak(n, dict, s);
		System.out.println(ans);
	}

	static List<String> wordBreak(int n, List<String> dict, String s) {
		// code here
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		return solve(s, dict, map);
	}

	private static List<String> solve(String s, List<String> dict, HashMap<String, List<String>> map) {
		// TODO Auto-generated method stub
		if (map.containsKey(s))
			return map.get(s);
		List<String> res = new ArrayList<String>();
		for (String word : dict) {
			if (s.length() >= word.length()) {
				String word2Check = s.substring(0, word.length());
				if (word2Check.equalsIgnoreCase(word)) {
					if (word2Check.length() == s.length()) {
						res.add(word2Check);
						break;
					} else {
						List<String> temp = solve(s.substring(word.length()), dict, map);
						for (String str : temp) {
							res.add(word2Check + " " + str);
						}
					}
				}
			}
		}
		map.put(s, res);
		return res;
	}

}
