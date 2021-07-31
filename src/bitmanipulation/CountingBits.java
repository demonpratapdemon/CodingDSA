/**
 * 
 */
package bitmanipulation;

/**
 * @author PRATAP
 *
 */
public class CountingBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		CountingBits obj = new CountingBits();
		int[] ans = obj.countBits(n);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int count = 0;
			int k = i;
			while (k > 0) {
				int rsb = k & -k;
				if (rsb > 0)
					count++;
				k -= rsb;
			}
			res[i] = count;
		}
		return res;
	}
}
