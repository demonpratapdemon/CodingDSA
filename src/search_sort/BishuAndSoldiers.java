/**
 * 
 */
package search_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author PRATAP HackerEarth
 *
 */
public class BishuAndSoldiers {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] powers = new int[n];
		String[] inputPowers = br.readLine().split("\\s+");
		int p = 0;
		for (String power : inputPowers)
			powers[p++] = Integer.parseInt(power);
		int rounds = Integer.parseInt(br.readLine());
		Arrays.sort(powers);
		int[] prefix = new int[n];
		prefix[0] = powers[0];
		for (int i = 1; i < n; i++)
			prefix[i] = prefix[i - 1] + powers[i];
		for (int i = 0; i < rounds; i++) {
			int bishuPower = Integer.parseInt(br.readLine());
			int idx = bishuKills(powers, bishuPower);
			System.out.println((idx + 1) + " " + prefix[idx]);
		}
	}

	private static int bishuKills(int[] powers, int bishuPower) {
		// TODO Auto-generated method stub
		int lo = 0;
		int hi = powers.length - 1;
		int ans = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (powers[mid] <= bishuPower) {
				ans = mid;
				lo = mid + 1;
			} else
				hi = mid - 1;
		}
		return ans;
	}

}
