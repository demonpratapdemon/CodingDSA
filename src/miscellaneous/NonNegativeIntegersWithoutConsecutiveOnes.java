/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 600
 *
 */
public class NonNegativeIntegersWithoutConsecutiveOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		int ans = findIntegers(n);
		System.out.println(ans);
	}

	public static int findIntegers(int n) {
		int[] f = new int[32];
		f[0] = 1;
		f[1] = 2;
		for (int i = 2; i < 32; i++)
			f[i] = f[i - 1] + f[i - 2];
		int i = 30, prev = 0, sum = 0;
		while (i >= 0) {
			if ((n & (1 << i)) != 0) {
				sum += f[i];
				if (prev == 1) {
					return sum;
				}
				prev = 1;
			} else {
				prev = 0;
			}
			i--;
		}
		return sum + 1;
	}
}
