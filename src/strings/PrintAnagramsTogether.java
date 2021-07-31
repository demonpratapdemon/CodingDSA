/**
 * 
 */
package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP LeetCode 49
 *
 */
public class PrintAnagramsTogether {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "act", "god", "cat", "dog", "tac", "fat" };
		List<List<String>> ans = Anagrams(words);
		for (List<String> l : ans)
			System.out.println(l);
	}

	public static List<List<String>> Anagrams(String[] words) {
		// Your Code here
//		int n = words.length;
//		boolean[] visited = new boolean[n];
//		List<List<String>> res = new ArrayList<List<String>>();
//		for (int i = 0; i < n; i++) {
//			if (!visited[i]) {
//				HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//				List<String> newList = new ArrayList<String>();
//				newList.add(words[i]);
//				for (Character ch : words[i].toCharArray()) {
//					map.put(ch, map.getOrDefault(ch, 0) + 1);
//				}
//				for (int j = i + 1; j < n; j++) {
//					if (!visited[j]) {
//						HashMap<Character, Integer> checkMap = new HashMap<Character, Integer>();
//						for (Character ch : words[j].toCharArray()) {
//							checkMap.put(ch, checkMap.getOrDefault(ch, 0) + 1);
//						}
//						if (map.equals(checkMap)) {
//							newList.add(words[j]);
//							visited[j] = true;
//						}
//					}
//				}
//				res.add(newList);
//			}
//		}
//		return res;
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> list = new ArrayList<List<String>>();
		for (String word : words) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String str = String.valueOf(chars);
			if (!map.containsKey(str)) {
				map.put(str, new ArrayList<String>());
				map.get(str).add(word);
			} else {
				map.get(str).add(word);
			}
		}
		list.addAll(map.values());
		return list;
	}
}
