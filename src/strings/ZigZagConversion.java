/**
 * 
 */
package strings;

import java.util.ArrayList;

/**
 * @author PRATAP LeetCode 6
 *
 */
public class ZigZagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		int numRows = 4;
		ZigZagConversion obj = new ZigZagConversion();
		String ans = obj.convert(s, numRows);
		System.out.println(ans);
	}

	public String convert(String s, int numRows) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < numRows; i++)
			list.add(new ArrayList<String>());
		int dir = 0;
		int k = 0;
		while (k < s.length()) {
			if (dir == 0) {
				for (int i = 0; i < numRows && k < s.length(); i++) {
					list.get(i).add(String.valueOf(s.charAt(k++)));
				}
			} else if (dir == 1) {
				int j = numRows - 1;
				while (--j > 0 && k < s.length()) {
					list.get(j).add(String.valueOf(s.charAt(k++)));
				}
			}
			dir = (dir + 1) % 2;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (String st : list.get(i))
				sb.append(st);
		}
		return sb.toString();
	}
}
