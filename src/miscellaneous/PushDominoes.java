/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 838
 *
 */
public class PushDominoes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  dominoes = ".L.R...LR..L..";
		PushDominoes obj = new PushDominoes();
		String ans = obj.pushDominoes(dominoes);
		System.out.println(ans);
	}

	public String pushDominoes(String dominoes) {
		int n = dominoes.length();
		int[] forces = new int[n];
		int force = 0;
		for (int i = 0; i < n; i++) {
			if (dominoes.charAt(i) == 'R') {
				force = n;
			} else if (dominoes.charAt(i) == 'L') {
				force = 0;
			} else {
				force = Math.max(force - 1, 0);
			}
			forces[i] = force;
		}
		force = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (dominoes.charAt(i) == 'L') {
				force = n;
			} else if (dominoes.charAt(i) == 'R') {
				force = 0;
			} else {
				force = Math.max(force - 1, 0);
			}
			forces[i] -= force;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : forces) {
			if (i > 0)
				sb.append("R");
			else if (i < 0)
				sb.append("L");
			else
				sb.append(".");
		}
		return sb.toString();
	}
}
