/**
 * 
 */
package september_leetcode_challenge;

/**
 * @author PRATAP LeetCode 1629
 *
 */
public class Day6_SlowestKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] releaseTimes = { 9, 29, 49, 50 };
		String keysPressed = "cbcd";
		Day6_SlowestKey obj = new Day6_SlowestKey();
		char ans = obj.slowestKey(releaseTimes, keysPressed);
		System.out.println(ans);
	}

	public char slowestKey(int[] releaseTimes, String keysPressed) {
		int max = releaseTimes[0], idx = 0;
		for (int i = 1; i < keysPressed.length(); i++) {
			if (releaseTimes[i] - releaseTimes[i - 1] >= max) {
				if (releaseTimes[i] - releaseTimes[i - 1] == max) {
					if (keysPressed.charAt(idx) < keysPressed.charAt(i)) {
						idx = i;
					}
				} else
					idx = i;
				max = releaseTimes[i] - releaseTimes[i - 1];
			}
		}
		return keysPressed.charAt(idx);
	}
}
