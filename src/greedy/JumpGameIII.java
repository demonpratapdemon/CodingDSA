/**
 * 
 */
package greedy;

/**
 * @author PRATAP
 *
 */
public class JumpGameIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
		int start = 0;
		boolean ans = canReach(arr, start);
		System.out.println(ans);
	}

	public static boolean canReach(int[] arr, int start) {
		if (arr[start] == 0)
			return true;
		boolean[] visited = new boolean[arr.length];
		boolean ans = solve(arr, start, visited);
		return ans;
	}

	private static boolean solve(int[] arr, int pos, boolean[] visited) {
		// TODO Auto-generated method stub
		if (pos < 0 || pos > arr.length - 1)
			return false;
		if (arr[pos] == 0)
			return true;
		visited[pos] = true;
		boolean add = false, del = false;
		if (pos + arr[pos] < arr.length && !visited[pos + arr[pos]])
			add = solve(arr, pos + arr[pos], visited);
		if (pos - arr[pos] >= 0 && !visited[pos - arr[pos]])
			del = solve(arr, pos - arr[pos], visited);

		return add | del;
	}

}
