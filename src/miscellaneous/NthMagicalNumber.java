/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 878
 *
 */
public class NthMagicalNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, a = 2, b = 3;
		NthMagicalNumber obj = new NthMagicalNumber();
		int ans = obj.nthMagicalNumber(n, a, b);
		System.out.println(ans);
	}

	public int nthMagicalNumber(int n, int a, int b) {
		int gcd = findGCD(a, b);
		int lcm = (a * b) / gcd;
		long low = Math.min(a, b);
		long high = n * low;
		while (low < high) {
			long mid = low + (high - low) / 2;
			long factors = mid / a + mid / b - mid / lcm;
			if (factors < n) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		long mod = (long) 1e9 + 7;
		return (int) (low % mod);
	}

	private int findGCD(int a, int b) {
		// TODO Auto-generated method stub
		if (a == 0)
			return b;
		return findGCD(b % a, a);
	}

}
