/**
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 17
 *
 */
public class LetterCombinationsOfAPhoneKeypad {

	static String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "";
		List<String> output = letterCombinations(digits);
		System.out.println(output);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> output = new ArrayList<String>();
		if (digits.length() <= 0)
			return output;
		generateLetterCombinations(digits, output, 0, digits.length(), "", 0);
		return output;
	}

	private static void generateLetterCombinations(String digits, List<String> output, int curr, int n, String combo,
			int i) {
		// TODO Auto-generated method stub
		if (curr == n) {
			output.add(combo);
			return;
		}
		String val = keypad[Integer.parseInt(String.valueOf(digits.charAt(i)))];
		for (int k = 0; k < val.length(); k++) {
			generateLetterCombinations(digits, output, curr + 1, n, combo + String.valueOf(val.charAt(k)), i + 1);
		}

	}

}
