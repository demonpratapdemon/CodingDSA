/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 677
 *
 */
public class MapSumPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MapSum {

	TrieNode root;

	/** Initialize your data structure here. */
	public MapSum() {
		root = new TrieNode();
	}

	public void insert(String key, int val) {
		TrieNode curr = root;
		for (int i = 0; i < key.length(); i++) {
			int pos = key.charAt(i) - 'a';
			if (curr.childs[pos] == null) {
				curr.childs[pos] = new TrieNode();
			}
			curr = curr.childs[pos];
		}
		curr.isEnd = true;
		curr.val = val;
	}

	public int sum(String prefix) {
		int sum = 0;
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			int pos = prefix.charAt(i) - 'a';
			if (curr.childs[pos] == null)
				return sum;
			curr = curr.childs[pos];
		}
		if (curr.isEnd)
			sum += curr.val;
		for (int i = 0; i < 26; i++) {
			if (curr.childs[i] != null) {
				int s = dfs(curr.childs[i]);
				sum += s;
			}
		}
		return sum;
	}

	private int dfs(TrieNode node) {
		// TODO Auto-generated method stub
		int sum = 0;
		if (node.isEnd) {
			sum += node.val;
		}
		for (int i = 0; i < 26; i++) {
			if (node.childs[i] != null) {
				int x = dfs(node.childs[i]);
				sum += x;
			}
		}
		return sum;
	}
}

class TrieNode {
	TrieNode[] childs;
	int val;
	boolean isEnd;

	public TrieNode() {
		super();
		this.childs = new TrieNode[26];
		this.isEnd = false;
	}

}
