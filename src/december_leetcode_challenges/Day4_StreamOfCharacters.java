/**
 * 
 */
package december_leetcode_challenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author PRATAP LeetCode 1032
 *
 */
public class Day4_StreamOfCharacters {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StreamChecker obj = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] queries = br.readLine().replace("[", "").replace("]", "").split(",");
		StringBuilder sb = new StringBuilder();
		String[] inputs = br.readLine().split(",");
		for (int i = 0; i < inputs.length; i++) {
			String word = inputs[i].replace("\"", "").trim();
			inputs[i] = word;
		}
		for (int i = 0; i < queries.length; i++) {
			if (i == 0)
				obj = new StreamChecker(inputs);
			else {
				String input = br.readLine().trim().replace("\"", "");
				if (input.length() > 1) {
					throw new Exception("Invalid Input");
				} else {
					sb.append(obj.query(input.charAt(0))).append(",");
				}
			}
		}
		System.out.println(sb.substring(0, sb.length() - 1).toString());
	}

}

class StreamChecker {

	final Trie root;
	StringBuilder sb;

	public StreamChecker(String[] words) {
		root = new Trie();
		sb = new StringBuilder();
		for (String word : words) {
			Trie temp = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				int pos = word.charAt(i) - 'a';
				if (temp.child[pos] == null) {
					temp.child[pos] = new Trie();
				}
				temp = temp.child[pos];
			}
			temp.isWord = true;
		}
	}

	public boolean query(char letter) {
		sb.append(letter);
		Trie temp = root;
		for (int i = sb.length() - 1; i >= 0; i--) {
			char ch = sb.charAt(i);
			int pos = ch - 'a';
			temp = temp.child[pos];
			if (temp == null)
				return false;
			if (temp.isWord)
				return true;
		}
		return false;
	}
}

class Trie {
	Trie[] child;
	boolean isWord;

	public Trie() {
		child = new Trie[26];
		isWord = false;
	}
}