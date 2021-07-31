/**
 * 
 */
package math;

/**
 * @author PRATAP
 *
 */
public class FactorialTrailingZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
		int ans = obj.trailingZeroes(n);
		System.out.println(ans);
	}

	public int trailingZeroes(int n) {
		int count = 0;
		int x = 5;
		while (x <= n) {
			count += (n / x);
			x = x * 5;
		}
		return count;
	}
}
