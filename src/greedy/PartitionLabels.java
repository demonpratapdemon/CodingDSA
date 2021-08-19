/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP LeetCode 763
 *
 */
public class PartitionLabels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcbacadefegdehijhklij";
		PartitionLabels obj = new PartitionLabels();
		List<Integer> ans = obj.partitionLabels(s);
		System.out.println(ans);
	}

	public List<Integer> partitionLabels(String s) {
		List<Integer> ans = new ArrayList<Integer>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		int prev = -1;
		for (int i = 0; i < s.length(); i++) {
			int max = map.get(s.charAt(i));
			while (i < s.length() && i != max) {
				i++;
				if (map.get(s.charAt(i)) > max) {
					max = map.get(s.charAt(i));
				}
			}
			ans.add(i - prev);
			prev = i;
		}
		return ans;
	}
}
