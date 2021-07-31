/**
 * 
 */
package math;

/**
 * @author PRATAP
 *
 */
public class UglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		System.out.println(isUgly(n));
	}

	public static boolean isUgly(int n) {
		while (n != 0 && (n % 2 == 0 || n % 3 == 0 || n % 5 == 0)) {
			if (n % 2 == 0)
				n /= 2;
			if (n % 3 == 0)
				n /= 3;
			if (n % 5 == 0)
				n /= 5;
		}
		if (n == 1)
			return true;
		return false;
	}
}
