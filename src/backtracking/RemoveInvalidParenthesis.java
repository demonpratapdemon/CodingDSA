/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author PRATAP LeetCode 301
 *
 */
public class RemoveInvalidParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "((()((s((((()";
		List<String> ans = removeInvalidParentheses(s);
		System.out.println(ans);
	}

	static List<String> ans = new ArrayList<String>();

	public static List<String> removeInvalidParentheses(String s) {
		if (ans.size() > 0) {
			ans.clear();
		}
		int minr = getMinRemovals(s);
		if (minr == s.length()) {
			ans.add("");
			return ans;
		}
		HashSet<String> set = new HashSet<>();
		solve(s, minr, set);
		return ans;
	}

	private static void solve(String s, int minr, HashSet<String> set) {
		// TODO Auto-generated method stub
		if (minr == 0) {
			int valid = getMinRemovals(s);
			if (valid == 0) {
				if (!set.contains(s)) {
					set.add(s);
					ans.add(s);
				}
			}
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i + 1);
			if (!set.contains(left + right)) {
				solve(left + right, minr - 1, set);
				set.add(left + right);
			}
		}
	}

	private static int getMinRemovals(String s) {
		// TODO Auto-generated method stub
		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				left++;
			} else if (ch == ')') {
				if (left == 0)
					right++;
				else if (left > 0)
					left--;
			}
		}
		return left + right;
	}
}
