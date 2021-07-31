/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class LargestPrimeFactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 21;
		System.out.println(Math.sqrt(12));
		long ans = largestPrimeFactor(N);
		System.out.println(ans);
	}

	public static long largestPrimeFactor(int N) {
		long maxP = 1;
		while (N % 2 == 0) {
			maxP = 2;
			N /= 2;
		}
		for (int i = 3; i <= Math.sqrt(N); i += 2) {
			while (N % i == 0) {
				maxP = i;
				N /= i;
			}
		}
		if (N > 2)
			maxP = N;
		return maxP;
	}
}
