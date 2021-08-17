/**
 * 
 */
package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author PRATAP Coding Ninjas - Generalized Abbreviation
 *
 */
public class GeneralizedAbbreviation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "", 0, 0);
		scn.close();
	}

	public static void solution(String str, String asf, int count, int pos) {
		// write your code here
		List<String> res = new ArrayList<String>();
		solve(str, "", 0, 0, res);
		Collections.sort(res);
		System.out.println(res);
	}

	private static void solve(String str, String asf, int count, int pos, List<String> res) {
		// TODO Auto-generated method stub
		if (pos == str.length()) {
			if (asf.trim().length() == str.length()) {
				res.add(asf.trim());
			} else if (asf.trim().length() > 0) {
				res.add(asf.trim() + (count > 0 ? String.valueOf(count) : ""));
			} else {
				res.add(String.valueOf(count));
			}
			return;
		}
		solve(str, asf, count + 1, pos + 1, res);
		String newAsf = asf + (count > 0 ? count : "") + str.charAt(pos);
		solve(str, newAsf, 0, pos + 1, res);
	}
}
