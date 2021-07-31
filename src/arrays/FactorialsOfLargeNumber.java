/**
 * 
 */
package arrays;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class FactorialsOfLargeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = factorial(40);
		System.out.println(ans);
	}

	public static ArrayList<Integer> factorial(int N) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);
		if (N == 0)
			return res;
		int carry = 0;
		int k = 2;
		while (k <= N) {
			int n = res.size();
			carry = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (res.get(i) * k + carry > 9) {
					int mul = (res.get(i) * k) + carry;
					res.set(i, mul % 10);
					carry = mul / 10;
				} else {
					int x = res.get(i) * k + carry;
					res.set(i, x);
					carry = 0;
				}
			}
			if (carry > 0) {
				while (carry > 0) {
					res.add(0, carry % 10);
					carry /= 10;
				}

			}
			k++;
		}
		System.out.println(res.size());
		return res;
	}

}
