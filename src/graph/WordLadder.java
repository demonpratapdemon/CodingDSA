/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author PRATAP LeetCode 127
 *
 */
public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit", endWord = "cog";
		List<String> wordList = new ArrayList<>();
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		for (String word : words)
			wordList.add(word);
		int ans = ladderLength(beginWord, endWord, wordList);
		System.out.println(ans);
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		TreeSet<String> set = new TreeSet<String>();
		boolean isPresent = false;
		for (String word : wordList) {
			if (word.equalsIgnoreCase(endWord))
				isPresent = true;
			set.add(word);
		}
		if (!isPresent)
			return 0;
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		int depth = 0;
		while (!q.isEmpty()) {
			depth++;
			int size = q.size();
			while (size-- > 0) {
				String curr = q.poll();
				for (int i = 0; i < curr.length(); i++) {
					StringBuilder sb = new StringBuilder(curr);
					for (int j = 0; j < 26; j++) {
						sb.setCharAt(i, (char) (j + 'a'));
						if (sb.toString().equalsIgnoreCase(curr))
							continue;
						if (sb.toString().equalsIgnoreCase(endWord))
							return depth + 1;
						if (set.contains(sb.toString())) {
							set.remove(sb.toString());
							q.add(sb.toString());
						}
					}
				}
			}
		}
		return 0;
	}
}
