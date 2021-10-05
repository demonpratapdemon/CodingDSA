/**
 * 
 */
package math;

/**
 * @author PRATAP LeetCode 29
 *
 */
public class Divide2Integers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dividend = -7;
		int divisor = 3;
		Divide2Integers obj = new Divide2Integers();
		int ans = obj.divide(dividend, divisor);
		System.out.println(ans);
	}

	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		int res = 0;
		int a = Math.abs(dividend);
		int b = Math.abs(divisor);
		while (a - b >= 0) {
			int x = 0;
			while (a - (b << 1 << x) >= 0)
				x++;
			res += 1 << x;
			a -= b << x;
		}
		if (dividend < 0 && divisor < 0)
			return res;
		else if (dividend < 0 || divisor < 0)
			return -res;
		else
			return res;
	}
}
