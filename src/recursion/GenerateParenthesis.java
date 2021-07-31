/**
 * 
 */
package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 22
 *
 */
public class GenerateParenthesis {

	static List<String> output = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		List<String> out = generateParenthesis(n);
		for (String s : out) {
			System.out.println(s);
		}
	}

	public static List<String> generateParenthesis(int n) {
		generateOutput("", n, 0, 0, 0);
		return output;
	}

	public static void generateOutput(String out, int n, int open, int close, int i) {
		// Base Condition
		if (i == 2 * n) {
			output.add(out);
			return;
		}

		// Condition for open
		if (open < n) {
			generateOutput(out + "(", n, open + 1, close, i + 1);
		}

		// Condition for close
		if (close < open) {
			generateOutput(out + ")", n, open, close + 1, i + 1);
		}

	}
}
