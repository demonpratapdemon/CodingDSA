/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP
 *
 */
public class Day9_AddStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "0", num2 = "0";
		Day9_AddStrings obj = new Day9_AddStrings();
		String ans = obj.addStrings(num1, num2);
		System.out.println(ans);
	}

	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {
			int sum = Integer.parseInt(String.valueOf(num1.charAt(i)))
					+ Integer.parseInt(String.valueOf(num2.charAt(j))) + carry;
			if (sum >= 10) {
				sb.append(sum % 10);
				carry = sum / 10;
			} else {
				carry = 0;
				sb.append(sum);
			}
			i--;
			j--;
		}
		while (i >= 0) {
			int sum = Integer.parseInt(String.valueOf(num1.charAt(i))) + carry;
			if (sum >= 10) {
				sb.append(sum % 10);
				carry = sum / 10;
			} else {
				carry = 0;
				sb.append(sum);
			}
			i--;
		}
		while (j >= 0) {
			int sum = Integer.parseInt(String.valueOf(num2.charAt(j))) + carry;
			if (sum >= 10) {
				sb.append(sum % 10);
				carry = sum / 10;
			} else {
				carry = 0;
				sb.append(sum);
			}
			j--;
		}
		if (carry > 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
