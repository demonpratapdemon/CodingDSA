/**
 * 
 */
package bitmanipulation;

/**
 * @author PRATAP
 *
 */
public class CountTotalBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 17;
		int ans = countSetBits(n);
		System.out.println(ans);
	}

	public static int countSetBits(int n) {
		// Your code here
		if (n == 0)
			return 0;
		int x = 0;
		while (Math.pow(2, x) <= n) {
			x++;
		}
		x--;
		int bitsSetBefore2x = (1 << (x - 1)) * x; // (1 << x ==> 2 ^ x)
		int firstBitsAfter2x = n - (1 << x) + 1;
		int setBits = (bitsSetBefore2x + firstBitsAfter2x + countSetBits(n - (1 << x)));
		return setBits;
	}

}
