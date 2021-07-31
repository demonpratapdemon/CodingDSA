/**
 * 
 */
package trie_prefix_tree;

/**
 * @author PRATAP LeetCode 720
 *
 */
public class LongestWordInDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		LongestWordInDictionary obj = new LongestWordInDictionary();
		String ans = obj.longestWord(words);
		System.out.println(ans);
	}

	public static String ans = "";

	public String longestWord(String[] words) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			insert(root, words[i]);
		}
		ans = "";
		dfs(root);
		return ans;
	}

	private void dfs(TrieNode root) {
		// TODO Auto-generated method stub
		if (root.isWord && root.word.length() > ans.length()) {
			ans = root.word;
		}

		for (int i = 0; i < 26; i++) {
			if (root.childs[i] != null && root.childs[i].isWord) {
				dfs(root.childs[i]);
			}
		}
	}

	public static void insert(TrieNode curr, String word) {
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (curr.childs[pos] == null) {
				TrieNode newNode = new TrieNode();
				curr.childs[pos] = newNode;
			}
			curr = curr.childs[pos];
		}
		curr.isWord = true;
		curr.word = word;
	}
}

class TrieNode {
	TrieNode[] childs;
	boolean isWord;
	String word;

	public TrieNode() {
		super();
		this.childs = new TrieNode[26];
		this.isWord = false;
	}

}
