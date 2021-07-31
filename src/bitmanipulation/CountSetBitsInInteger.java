/**
 * 
 */
package bitmanipulation;

/**
 * @author PRATAP
 *
 */
public class CountSetBitsInInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 6;
		int ans = setBits(N);
		System.out.println(ans);
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
