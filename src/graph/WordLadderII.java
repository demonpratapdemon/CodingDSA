/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author PRATAP LeetCode 126
 *
 */
public class WordLadderII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = new ArrayList<>();
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
//		String beginWord = "red", endWord = "tax";
//		List<String> wordList = new ArrayList<>();
//		String[] words = { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };
		for (String word : words)
			wordList.add(word);
		List<List<String>> ans = findLadders(beginWord, endWord, wordList);
		System.out.println(ans);
	}

	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		TreeSet<String> set = new TreeSet<String>();
		boolean isPresent = false;
		List<List<String>> res = new ArrayList<List<String>>();
		for (String word : wordList) {
			if (word.equalsIgnoreCase(endWord))
				isPresent = true;
			set.add(word);
		}
		if (!isPresent)
			return res;
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		visited.put(beginWord, 0);
		HashMap<String, List<String>> adj = new HashMap<String, List<String>>();
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String curr = q.poll();
				for (int i = 0; i < curr.length(); i++) {
					StringBuilder sb = new StringBuilder(curr);
					for (int j = 0; j < 26; j++) {
						sb.setCharAt(i, (char) (j + 'a'));
						if (sb.toString().equalsIgnoreCase(curr) || (visited.get(sb.toString()) == visited.get(curr))
								|| (visited.containsKey(sb.toString())
										&& visited.get(sb.toString()) == visited.get(curr) - 1))
							continue;
						if (set.contains(sb.toString()) && (visited.get(sb.toString()) != visited.get(curr))) {
							q.add(sb.toString());
							if (!visited.containsKey(sb.toString()))
								visited.put(sb.toString(), visited.get(curr) + 1);
							List<String> list = adj.getOrDefault(curr, null);
							if (list == null)
								list = new ArrayList<String>();
							if (list.size() == 0)
								list.add(sb.toString());
							else if (!list.contains(sb.toString()))
								list.add(sb.toString());
							adj.put(curr, list);
						}
					}
				}
			}
		}
		dfs(adj, res, beginWord, beginWord, endWord);
		return res;
	}

	private static void dfs(HashMap<String, List<String>> adj, List<List<String>> res, String path, String currWord,
			String endWord) {
		// TODO Auto-generated method stub
		if (currWord.equalsIgnoreCase(endWord)) {
			String[] buff = path.split("\\s+");
			List<String> list = new ArrayList<String>();
			for (String str : buff)
				list.add(str);
			res.add(list);
			return;
		}
		if (adj.getOrDefault(currWord, null) == null)
			return;
		for (String word : adj.get(currWord)) {
			dfs(adj, res, path + " " + word, word, endWord);
		}
	}

}
