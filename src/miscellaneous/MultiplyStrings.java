/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 43
 *
 */
public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "9133", num2 = "0";
		MultiplyStrings obj = new MultiplyStrings();
		String res = obj.multiply(num1, num2);
		System.out.println(res);
	}

	public String multiply(String num1, String num2) {
		int n = num1.length(), m = num2.length();
		StringBuilder sb = new StringBuilder();
		StringBuilder carry = new StringBuilder();
		StringBuilder r = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			int d = Integer.parseInt(String.valueOf(num1.charAt(i)));
			int c = 0;
			for (int j = m - 1; j >= 0; j--) {
				int dnext = Integer.parseInt(String.valueOf(num2.charAt(j)));
				int num = d * dnext + c;
				if (num > 9) {
					r.insert(0, num % 10);
					c = num / 10;
				} else {
					r.insert(0, num);
					c = 0;
				}
			}
			if (c > 0) {
				r.insert(0, c);
				c = 0;
			}
			String result = add(r, carry);
			int k = result.length();
			sb.insert(0, result.substring(k - 1));
			carry.setLength(0);
			if (k > 1) {
				carry.append(result.substring(0, k - 1));
			}
			r.setLength(0);
		}
		if (carry.length() > 0) {
			sb.insert(0, carry);
		}
		int k = 0;
		while (k < sb.length() && sb.charAt(k) == '0') {
			k++;
		}
		if (k == sb.length())
			return "0";
		return sb.toString().substring(k);
	}

	public String add(StringBuilder num1, StringBuilder num2) {
		int c = 0;
		int i = num1.length() - 1, j = num2.length() - 1;
		StringBuilder res = new StringBuilder();
		while (i >= 0 && j >= 0) {
			int d1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
			int d2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
			if (d1 + d2 + c > 9) {
				res.insert(0, (d1 + d2 + c) % 10);
				c = (d1 + d2 + c) / 10;
			} else {
				res.insert(0, d1 + d2 + c);
				c = 0;
			}
			i--;
			j--;
		}
		while (i >= 0) {
			int d1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
			if (d1 + c > 9) {
				res.insert(0, (d1 + c) % 10);
				c = (d1 + c) / 10;
			} else {
				res.insert(0, d1 + c);
				c = 0;
			}
			i--;
		}
		while (j >= 0) {
			int d2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
			if (d2 + c > 9) {
				res.insert(0, (d2 + c) % 10);
				c = (d2 + c) / 10;
			} else {
				res.insert(0, d2 + c);
				c = 0;
			}
			j--;
		}
		if (c > 0)
			res.insert(0, c);
		return res.toString();
	}
}
