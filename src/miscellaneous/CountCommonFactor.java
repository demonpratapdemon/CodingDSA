/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class CountCommonFactor {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int count = countCommonFactors(a, b);
		System.out.println(count);
	}

	private static int countCommonFactors(int a, int b) {
		// TODO Auto-generated method stub
		int gcd = findGCD(a, b);
		int res = 0;
		for (int i = 1; i <= Math.sqrt(gcd); i++) {
			if (gcd % i == 0) {
				if (gcd / i == i) {
					res++;
				} else
					res += 2;
			}
		}
		return res;
	}

	private static int findGCD(int a, int b) {
		// TODO Auto-generated method stub
		if (a == 0)
			return b;
		return findGCD(b % a, a);
	}

}
