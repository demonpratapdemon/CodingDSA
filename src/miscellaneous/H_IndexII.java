/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 275
 *
 */
public class H_IndexII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 0, 1, 2, 3, 7, 8 };
		int ans = hIndex(citations);
		System.out.println(ans);
	}

	public static int hIndex(int[] citations) {
		int n = citations.length;
		int low = 0, high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int v = citations[mid];
			if (v == n - mid) {
				return v;
			} else if (v > n - mid) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return n - low;
	}
}
