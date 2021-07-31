/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class SmallestSubarrayWithSumGreaterThanX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 6, 3, 4, 5, 4, 3, 7, 9 }, n = a.length, X = 16;
//		int a[] = { 1, 4, 45, 6, 0, 19 }, n = a.length, X = 51;
		int ans = sb(a, n, X);
		System.out.println(ans);
	}

	public static int sb(int a[], int n, int x) {
		// Your code goes here
		int i = 0, j = 0;
		int ans = Integer.MAX_VALUE;
		int curr = 0;
		while (true) {
			boolean f1 = false, f2 = false;
			while (i < n && curr <= x) {
				curr += a[i];
				i++;
				f1 = true;
			}
			while (j < i && curr > x) {
				ans = Math.min(ans, i - j);
				curr -= a[j];
				j++;
				f2 = true;
			}
			if (!f1 && !f2)
				break;
		}
		return ans;
	}
}
