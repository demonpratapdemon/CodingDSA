/**
 * 
 */
package october_leetcode_challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 212
 *
 */
public class Day9_WordSearchII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String words[] = { "oath", "pea", "eat", "rain" };
		Day9_WordSearchII obj = new Day9_WordSearchII();
		List<String> ans = obj.findWords(board, words);
		System.out.println(ans);
	}

	static int[][] adj = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<String> findWords(char[][] board, String[] words) {
		int m = board.length, n = board[0].length;
		List<String> res = new ArrayList<String>();
		TrieNode root = new TrieNode();
		for (String s : words) {
			insert(s, root);
		}
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, i, j, root, res, visited, m, n);
			}
		}
		return res;
	}

	private void insert(String s, TrieNode root) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.length(); i++) {
			int pos = s.charAt(i) - 'a';
			if (root.childs[pos] == null) {
				root.childs[pos] = new TrieNode();
				root.count++;
			}
			root = root.childs[pos];
		}
		root.isWord = true;
		root.word = s;
	}

	private void dfs(char[][] board, int i, int j, TrieNode root, List<String> res, boolean[][] visited, int m, int n) {
		// TODO Auto-generated method stub
		if (root.childs[board[i][j] - 'a'] == null) {
			return;
		}
		TrieNode child = root.childs[board[i][j] - 'a'];
		if (child != null && child.isWord) {
			res.add(child.word);
			child.isWord = false;
		}
		visited[i][j] = true;
		for (int k = 0; k < adj.length; k++) {
			int currI = i + adj[k][0];
			int currJ = j + adj[k][1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && !visited[currI][currJ] && child.count != 0) {
				dfs(board, currI, currJ, child, res, visited, m, n);
			}
		}
		visited[i][j] = false;
		if (child.count == 0) {
			root.count--;
		}
	}
}

class TrieNode {
	TrieNode[] childs;
	boolean isWord;
	String word;
	int count;

	public TrieNode() {
		super();
		this.childs = new TrieNode[26];
		this.isWord = false;
		this.count = 0;
	}

}