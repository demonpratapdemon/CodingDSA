/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author PRATAP LeetCode 12
 *
 */
public class IntegerToRoman {

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
			int num = Integer.parseInt(br.readLine());
			String roman = intToRoman(num);
			System.out.println(roman);
		}
	}

	@SuppressWarnings("serial")
	public static HashMap<Integer, String> map = new HashMap<Integer, String>() {
		{
			put(1, "I");
			put(5, "V");
			put(10, "X");
			put(50, "L");
			put(100, "C");
			put(500, "D");
			put(1000, "M");
			put(4, "IV");
			put(9, "IX");
			put(40, "XL");
			put(90, "XC");
			put(400, "CD");
			put(900, "CM");
		}
	};

	public static int[] hund = { 100, 400, 500, 900 };
	public static int[] twos = { 10, 40, 50, 90 };
	public static int[] ones = { 1, 4, 5, 9 };

	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int base = 10;
		while (num > 0) {
			int n = String.valueOf(num).length();
			if (num >= 1000) {
				int no = (int) Math.pow(base, n - 1);
				String val = map.get(no);
				sb.append(val);
				num -= no;
			} else if (num >= 100) {
				while (num >= 100) {
					for (int i = hund.length - 1; i >= 0 && num >= 100; i--) {
						if (num - hund[i] >= 0) {
							sb.append(map.get(hund[i]));
							num -= hund[i];
							break;
						}
					}
				}
			} else if (num >= 10) {
				while (num >= 10) {
					for (int i = twos.length - 1; i >= 0 && num >= 10; i--) {
						if (num - twos[i] >= 0) {
							sb.append(map.get(twos[i]));
							num -= twos[i];
							break;
						}
					}
				}
			} else {
				while (num > 0) {
					for (int i = ones.length - 1; i >= 0 && num > 0; i--) {
						if (num - ones[i] >= 0) {
							sb.append(map.get(ones[i]));
							num -= ones[i];
							break;
						}
					}
				}
			}
		}
		return sb.toString();
	}
}
