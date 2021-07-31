/**
 * 
 */
package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class StringPermutations {

	static List<String> output = new ArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "ljr";
		List<String> out = find_permutation(S);
		System.out.println(out);
	}

	public static List<String> find_permutation(String S) {
		// Code here
		if (output.size() > 0)
			output.clear();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : S.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		generatePermutations(1, S.length(), map, "");
		Collections.sort(output);
		return output;
	}

	private static void generatePermutations(int cs, int ts, HashMap<Character, Integer> map, String asf) {
		// TODO Auto-generated method stub
		if (cs > ts) {
			output.add(asf);
			return;
		}
		for (char ch : map.keySet()) {
			if (map.get(ch) > 0) {
				map.put(ch, map.get(ch) - 1);
				generatePermutations(cs + 1, ts, map, asf + ch);
				map.put(ch, map.get(ch) + 1);
			}
		}
	}

}
