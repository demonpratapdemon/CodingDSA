/**
 * 
 */
package problem_of_the_day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class LuckyAlivePersonInCircle {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = find(N);
		System.out.println(ans);
	}

	public static int find(int N) {
		// code here
		int ans = findSurv(N, 1);
		return ans;
	}

	private static int findSurv(int N, int k) {
		// TODO Auto-generated method stub
		if (N == 1) {
			return 1;
		}
		int x = findSurv(N - 1, k);
		int y = (x + k) % N + 1;
		return y;
	}
}
