/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1573
 *
 */
public class NumberOfWaysToSplitAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "10101";
		int ways = numWays(s);
		System.out.println(ways);
	}

	public static int numWays(String s) {
		long ones = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '1')
				ones++;
		}
		if (ones % 3 > 0)
			return 0;
		long mod = (long) (1e9 + 7);
		long ways = 0;
		int n = s.length();
		if (ones == 0) {
			long x = (((n - 1) % mod) * ((n - 2) % mod) / 2);
			return (int) (x % mod);
		} else {
			long oneThird = ones / 3;
			ones = 0;
			long ways1 = 0, ways2 = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '1')
					ones++;
				if (ones == oneThird) {
					ways1++;
					ways1 %= mod;
				}
				if (ones == 2 * oneThird) {
					ways2++;
					ways2 %= mod;
				}
			}
			ways = (ways1 * ways2) % mod;
		}
		return (int) (ways % mod);
	}
}
