/**
 * 
 */
package trie_prefix_tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author PRATAP
 *
 */
public class MostFrequentWordInAnArrayOfStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = { "hello", "world" };
		String ans = mostFrequentWord(arr, arr.length);
		System.out.println(ans);
	}

	public static String ans = "";
	public static int count = 0;
	public static int first = 0;

	public static String mostFrequentWord(String arr[], int n) {
		FreqTrie root = new FreqTrie();
		for (int i = 0; i < n; i++) {
			insert(arr[i], root, i);
		}
		ans = "";
		count = 0;
		first = 0;
		preorder(root);
		return ans;
	}

	private static void preorder(FreqTrie root) {
		// TODO Auto-generated method stub
		if (root.word != null && (root.count > count || (root.count == count && root.first > first))) {
			ans = root.word;
			count = root.count;
			first = root.first;
		}

		Set<Character> set = root.map.keySet();
		Iterator<Character> itr = set.iterator();
		while (itr.hasNext()) {
			preorder(root.map.get(itr.next()));
		}
	}

	private static void insert(String word, FreqTrie root, int pos) {
		// TODO Auto-generated method stub
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!root.map.containsKey(ch)) {
				root.map.put(ch, new FreqTrie());
			}
			root = root.map.get(ch);
		}
		root.count++;
		root.word = word;
		if (root.first == -1)
			root.first = pos;
	}
}

class FreqTrie {
	public HashMap<Character, FreqTrie> map;
	public int count;
	public String word;
	public int first;

	public FreqTrie() {
		super();
		this.map = new HashMap<Character, FreqTrie>();
		this.count = 0;
		this.first = -1;
	}

}
