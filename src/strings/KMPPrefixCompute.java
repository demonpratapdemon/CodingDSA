/**
 * 
 */
package strings;

/**
 * @author PRATAP
 *
 */
public class KMPPrefixCompute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abab";
		System.out.println(lps(s));
	}

	public static int lps(String s) {
		// code here
		int n = s.length();
		int[] arr = new int[n];
		int max = 0;
		int j = 0;
		for (int i = 1; i < n;) {
			if (s.charAt(i) == s.charAt(j)) {
				arr[i] = j + 1;
				j++;
				max = Math.max(max, arr[i]);
				i++;
			} else {
				if (j != 0) {
					j = arr[j - 1];
				} else {
					arr[i] = 0;
					i++;
				}
			}
		}
		return arr[n - 1];
	}

}
