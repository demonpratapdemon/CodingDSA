/**
 * 
 */
package strings;

/**
 * @author PRATAP
 *
 */
public class CountNoOfGivenStringIn2DCharacterArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] a = { { 'D', 'D', 'D', 'G', 'D', 'D' }, { 'B', 'B', 'D', 'E', 'B', 'S' },
				{ 'B', 'S', 'K', 'E', 'B', 'K' }, { 'D', 'D', 'D', 'D', 'D', 'E' }, { 'D', 'D', 'D', 'D', 'D', 'E' },
				{ 'D', 'D', 'D', 'D', 'D', 'G' } };
		String str = "GEEKS";
		int counter = countOccurances(a, str);
		System.out.println(counter);
	}

	private static int[][] neighbs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static int count = 0;

	private static int countOccurances(char[][] a, String str) {
		// TODO Auto-generated method stub
		count = 0;
		if (str.length() <= 0)
			return 0;
		boolean[][] visited = new boolean[a.length][a[0].length];
		int m = a.length;
		int n = a[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == str.charAt(0) && !visited[i][j]) {
					visited[i][j] = true;
					dfs(a, str, i, j, visited, 0, n, m);
				}
			}
		}
		return count;
	}

	private static void dfs(char[][] a, String str, int i, int j, boolean[][] visited, int currId, int n, int m) {
		// TODO Auto-generated method stub
		if (currId == str.length() - 1) {
			count++;
			return;
		}
		for (int[] neighb : neighbs) {
			int currI = i + neighb[0];
			int currJ = j + neighb[1];
			if (currI >= 0 && currI < m && currJ >= 0 && currJ < n && currId + 1 < str.length()
					&& a[currI][currJ] == str.charAt(currId + 1)) {
				visited[currI][currJ] = true;
				dfs(a, str, currI, currJ, visited, currId + 1, n, m);
			}
		}
	}

}
