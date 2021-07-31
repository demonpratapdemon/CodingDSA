/**
 * 
 */
package strings;

/**
 * @author PRATAP
 *
 */
public class MinSwapsForBracketBalancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "[]]][[";
		int minSwaps = minimumNumberOfSwaps(S);
		System.out.println(minSwaps);
	}

	public static int minimumNumberOfSwaps(String S) {
		// code here
		int open = 0, close = 0, fault = 0;
		int swaps = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == ']') {
				close++;
				fault = close - open;
			} else {
				open++;
				if (fault > 0) {
					swaps += fault;
					fault--;
				}
			}
		}
		return swaps;
	}
}
