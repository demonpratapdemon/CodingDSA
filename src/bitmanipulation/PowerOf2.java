/**
 * 
 */
package bitmanipulation;

/**
 * @author PRATAP
 *
 */
public class PowerOf2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerofTwo(127));
	}

	public static boolean isPowerofTwo(long n) {
		// Your code here
		int count = 0;
		if (n == 0)
			return false;
		while (n > 0) {
			count += n & 1;
			if (count > 1)
				return false;
			n >>= 1;
		}
		return true;
	}

}
