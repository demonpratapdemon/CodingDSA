/**
 * 
 */
package strings;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 166
 *
 */
public class FractionToRecurringDecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numerator = 7;
		int denominator = -12;
		FractionToRecurringDecimal obj = new FractionToRecurringDecimal();
		String ans = obj.fractionToDecimal(numerator, denominator);
		System.out.println(ans);
	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		long n = numerator, d = denominator;
		if (numerator == 0) {
			return "0";
		}
		if (n < 0 || d < 0) {
			n = Math.abs(n);
			d = Math.abs(d);
			sb.append("-");
		}
		if (numerator < 0 && denominator < 0) {
			sb = new StringBuilder();
		}
		long q = n / d;
		long r = n % d;
		sb.append(q);
		if (r == 0) {
			return sb.toString();
		} else {
			sb.append(".");
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			while (r != 0) {
				if (map.containsKey(r)) {
					int len = map.get(r);
					sb.insert(len, "(");
					sb.append(")");
					break;
				} else {
					map.put(r, sb.length());
					r *= 10;
					q = r / d;
					r = r % d;
					sb.append(q);
				}
			}
		}
		return sb.toString();
	}
}
