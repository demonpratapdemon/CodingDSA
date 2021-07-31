/**
 * 
 */
package problem_of_the_day;

/**
 * @author PRATAP Kernighan's Algorithm
 *
 */
public class BitDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] A = { 1, 3, 5 };
		int N = A.length;
		int count = countBits(N, A);
		System.out.println(count);
	}

	public static int countBits(int N, long A[]) {
		// code here
		long res = 0;
		long mod = (long) (1e9 + 7);
		for (int i = 0; i < 32; i++) {
			long on = 0;
			long off = 0;
			for (int j = 0; j < A.length; j++) {
				long rsb = A[j] & (1 << i);
				if (rsb > 0)
					on++;
				else
					off++;
//				A[j] -= rsb;
			}
			res += ((on * off * 2) % mod);
		}
		return (int) (res % mod);
	}
}
