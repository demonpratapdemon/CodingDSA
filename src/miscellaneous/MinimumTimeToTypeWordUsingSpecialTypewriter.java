/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1974
 *
 */
public class MinimumTimeToTypeWordUsingSpecialTypewriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "zjpc";
		MinimumTimeToTypeWordUsingSpecialTypewriter obj = new MinimumTimeToTypeWordUsingSpecialTypewriter();
		int ans = obj.minTimeToType(word);
		System.out.println(ans);
	}

	public int minTimeToType(String word) {
		int time = 0;
		int n = word.length();
		for (int i = 0; i < n; i++) {
			char ch = word.charAt(i);
			if (i == 0) {
				int diff1 = (int) 'a' - (int) ch;
				if (diff1 < 0) {
					diff1 = 26 - Math.abs(diff1);
				}
				int diff2 = (int) ch - (int) 'a';
				if (diff2 < 0) {
					diff2 = 26 - Math.abs(diff2);
				}
				time += Math.min(diff1, diff2) + 1;
			} else {
				int diff1 = (int) word.charAt(i - 1) - (int) ch;
				if (diff1 < 0) {
					diff1 = 26 - Math.abs(diff1);
				}
				int diff2 = (int) ch - (int) word.charAt(i - 1);
				if (diff2 < 0) {
					diff2 = 26 - Math.abs(diff2);
				}
				time += Math.min(diff1, diff2) + 1;
			}
		}
		return time;
	}
}
