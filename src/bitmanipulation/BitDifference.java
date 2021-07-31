/**
 * 
 */
package bitmanipulation;

/**
 * @author PRATAP
 *
 */
public class BitDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		int ans = countBitsFlip(a, b);
		System.out.println(ans);
	}

	public static int countBitsFlip(int a, int b) {
		// Your code here
		int xor = a ^ b;
		return setBits(xor);
	}

	static int setBits(int N) {
		// code here
		int x = 1;
		int count = 0;
		while (x <= N) {
			if ((N & x) > 0) {
				count++;
			}
			x *= 2;
		}
		return count;
	}

}
