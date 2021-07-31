/**
 * 
 */
package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP LeetCode 8
 *
 */
public class AtoI {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String s = br.readLine();
			int ans = myAtoi(s);
			System.out.println(ans);
		}
	}

	public static int myAtoi(String s) {
		s = s.trim();
		long res = 0;
		int sign = s.charAt(0) == '-' ? -1 : 1;
		int i = 0;
		if (s.charAt(i) == '-' || s.charAt(i) == '+')
			i++;
		for (; i < s.length(); i++) {
			if ((s.charAt(i) - '0') > 9 || (s.charAt(i) - '0') < 0)
				break;
			res = (res * 10) + (s.charAt(i) - '0');
			if (res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) {
				return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
		}
		return (int) (res * sign);
	}
}
