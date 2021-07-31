/**
 * 
 */
package strings;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 13
 *
 */
public class RomanNumberToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "MCMXCIV";
		int ans = romanToDecimal(str);
		System.out.println(ans);
	}

	@SuppressWarnings("serial")
	public static HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};

	public static int romanToDecimal(String str) {
		// code here
		int result = 0;
		int i = 0, j = 1;
		while (j < str.length()) {
			if (str.charAt(i) == 'I' && (str.charAt(j) == 'V' || str.charAt(j) == 'X')) {
				int curr = str.charAt(j) == 'V' ? 4 : 9;
				result += curr;
				i += 2;
				j = i + 1;
			} else if (str.charAt(i) == 'X' && (str.charAt(j) == 'L' || str.charAt(j) == 'C')) {
				int curr = str.charAt(j) == 'L' ? 40 : 90;
				result += curr;
				i += 2;
				j = i + 1;
			} else if (str.charAt(i) == 'C' && (str.charAt(j) == 'D' || str.charAt(j) == 'M')) {
				int curr = str.charAt(j) == 'D' ? 400 : 900;
				result += curr;
				i += 2;
				j = i + 1;
			} else {
				result += map.get(str.charAt(i));
				i++;
				j++;
			}
		}
		if (i < str.length())
			result += map.get(str.charAt(i));
		return result;
	}
}
