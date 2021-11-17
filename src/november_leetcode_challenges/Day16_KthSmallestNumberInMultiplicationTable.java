/**
 * 
 */
package november_leetcode_challenges;

/**
 * @author PRATAP LeetCode 668
 *
 */
public class Day16_KthSmallestNumberInMultiplicationTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 9895, n = 28405, k = 100787757;
		Day16_KthSmallestNumberInMultiplicationTable obj = new Day16_KthSmallestNumberInMultiplicationTable();
		int ans = obj.findKthNumber(m, n, k);
		System.out.println(ans);
	}

	public int findKthNumber(int m, int n, int k) {
		int low = 1, high = m * n;
		while (low < high) {
			int mid = low + (high - low) / 2;
			int count = count(mid, m, n);
			if (count >= k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public int count(int mid, int m, int n) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			int temp = Math.min(mid / i, n);
			count += temp;
		}
		return count;
	}
}
