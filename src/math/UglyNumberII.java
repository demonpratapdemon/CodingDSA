/**
 * 
 */
package math;

import java.util.TreeSet;

/**
 * @author PRATAP
 *
 */
public class UglyNumberII {
	static String s = "%s position Ugly number is %s";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		String str  = String.format(s, String.valueOf(n), String.valueOf(nthUglyNumber(n)));
		System.out.println(str);
	}

	public static int nthUglyNumber(int n) {
		TreeSet<Long> fix = new TreeSet<Long>();
		TreeSet<Long> possible = new TreeSet<Long>();
		possible.add(Long.parseLong(String.valueOf(1)));
		while (fix.size() != n) {
			Long x = possible.pollFirst();
			fix.add(x);
			possible.add(x * 2);
			possible.add(x * 3);
			possible.add(x * 5);
		}
		return fix.last().intValue();
	}

}
