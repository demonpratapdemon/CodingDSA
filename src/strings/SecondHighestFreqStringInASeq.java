/**
 * 
 */
package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PRATAP
 *
 */
public class SecondHighestFreqStringInASeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = { "geek", "for", "geek", "for", "geek", "aaa" };
		String ans = secFrequent(arr, arr.length);
		System.out.println(ans);
	}

	public static String secFrequent(String arr[], int N) {
		// your code here
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int h = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			h = Math.max(h, map.get(arr[i]));
		}
		int prev = -1;
		String res = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int curr = map.get(entry.getKey());
			if (curr < h && curr > prev) {
				prev = curr;
				res = entry.getKey();
			}
		}
		return res;

	}
}
