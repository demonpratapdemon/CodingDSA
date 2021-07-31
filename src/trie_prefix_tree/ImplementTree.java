/**
 * 
 */
package trie_prefix_tree;

/**
 * @author PRATAP LeetCode 208
 *
 */
public class ImplementTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Trie {

	private class Node {
		Node[] childs;
		boolean isEnd;
	}

	/** Initialize your data structure here. */
	private final Node root;

	public Trie() {
		root = new Node();
		root.childs = new Node[26];
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node curr = root;
		int pos = -1;
		for (int i = 0; i < word.length(); i++) {
			pos = word.charAt(i) - 'a';
			if (curr.childs[pos] == null) {
				Node newNode = new Node();
				newNode.childs = new Node[26];
				curr.childs[pos] = newNode;
			}
			curr = curr.childs[pos];
		}
		curr.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			int pos = word.charAt(i) - 'a';
			if (curr.childs[pos] == null)
				return false;
			curr = curr.childs[pos];
		}
		return curr.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			int pos = prefix.charAt(i) - 'a';
			if (curr.childs[pos] == null)
				return false;
			curr = curr.childs[pos];
		}
		return true;
	}
}