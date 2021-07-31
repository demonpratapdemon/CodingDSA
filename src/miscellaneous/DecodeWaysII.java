/**
 * 
 */
package miscellaneous;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 639
 *
 */
public class DecodeWaysII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "*********";
		int ans = numDecodings(s);
		System.out.println(ans);
	}

	public static int numDecodings(String s) {
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 1; i <= 26; i++) {
			map.put(i, (char) (i + 65 - 1));
		}
		int n = s.length();
		long[] dp = new long[n + 1];
		long mod = (long) (1e9 + 7);
		dp[0] = 1; // base case
		dp[1] = decode1Char(s.charAt(0));
		for (int i = 2; i <= n; i++) {
			char prev = s.charAt(i - 2);
			char curr = s.charAt(i - 1);
			dp[i] = dp[i - 1] * decode1Char(curr);
			dp[i] += dp[i - 2] * decode2Chars(prev, curr);
			dp[i] %= mod;
		}
		return (int) dp[n];
	}

	public static int decode1Char(char ch) {
		if (ch == '*') {
			return 9;
		} else if (ch == '0') {
			return 0;
		}
		return 1;
	}

	public static int decode2Chars(char first, char sec) {
		switch (first) {
		case '*': {
			if (sec == '*')
				return 15;
			else if (sec >= '0' && sec <= '6') {
				return 2;
			} else {
				return 1;
			}
		}
		case '1': {
			if (sec == '*')
				return 9;
			else
				return 1;
		}
		case '2': {
			if (sec == '*') {
				return 6;
			} else if (sec >= '0' && sec <= '6')
				return 1;
			else
				return 0;
		}
		default:
			return 0;
		}
	}

}
