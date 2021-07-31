/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode Weekly 248
 *
 */
public class CountGoodNos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countGoodNumbers(50));
	}

	public static int mod = (int) (1e9 + 7);

	public static int countGoodNumbers(long n) {
		long odds = n / 2;
		long evens = n - odds;
		return (int) ((pow(5, evens) * pow(4, odds)) % mod);
	}

	private static long pow(int x, long y) {
		// TODO Auto-generated method stub
		if (y == 0)
			return 1;
		long ans = pow(x, y / 2);
		ans *= ans;
		if (y % 2 > 0)
			ans *= x;
		return ans % mod;
	}
}
