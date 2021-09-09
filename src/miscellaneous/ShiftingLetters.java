/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 848
 *
 */
public class ShiftingLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"qoqpvw"
//		[95,7,67,21,33,23]
//		String s = "qoqpvw";
//		int shifts[] = { 95, 7, 67, 21, 33, 23 };
		String s = "ba";
		int shifts[] = { 1, 2 };
		ShiftingLetters obj = new ShiftingLetters();
		String ans = obj.shiftingLetters(s, shifts);
		System.out.println(ans);
	}

	public String shiftingLetters(String s, int[] shifts) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
        int n = shifts.length;
        int shift = 0;
		for (int j = n - 1; j >= 0; j--) {
			shift = (shift + shifts[j]) % 26;
			char ch = (char) ((s.charAt(j) - 'a' + shift) % 26 + 'a');
			sb.replace(j, j + 1, String.valueOf(ch));
		}
		return sb.toString();
	}
}
