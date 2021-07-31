/**
 * 
 */
package greedy;

/**
 * @author PRATAP
 *
 */
public class SmallestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int S = 20, D = 3;
		String ans = smallestNumber(S, D);
		System.out.println(ans);
	}

	public static String smallestNumber(int S, int D) {
		// code here
		StringBuilder sb = new StringBuilder();
		while (D-- > 0) {
			for (int i = 9; i >= 0; i--) {
				if (S - i == 0 && D > 0) {
					continue;
				} else if (S - i >= 0) {
					sb.insert(0, i);
					S -= i;
					break;
				}
			}
		}
		return sb.toString();
	}
}
