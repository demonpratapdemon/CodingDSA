/**
 * 
 */
package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author PRATAP SPOJ BRDGHRD - Building Bridges(HARD)
 *
 */
public class NonOverlappingBridges {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				int n = Integer.parseInt(br.readLine());
				String[] e1 = br.readLine().split("\\s+");
				String[] e2 = br.readLine().split("\\s+");
				Bridge[] brdgs = new Bridge[n];
				for (int i = 0; i < n; i++) {
					int nr = Integer.parseInt(e1[i]);
					int s = Integer.parseInt(e2[i]);
					brdgs[i] = new Bridge(nr, s);
				}
				int ans = findNonOverlappingBridges(brdgs);
				System.out.println(ans);
			}
		} catch (Exception e) {
			return;
		}

		return;
	}

	private static int findNonOverlappingBridges(Bridge[] brdgs) {
		// TODO Auto-generated method stub
		Arrays.sort(brdgs);
		int omax = 0;
		int n = brdgs.length;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (brdgs[j].s <= brdgs[i].s) {
					if (dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			omax = Math.max(omax, dp[i]);
		}
		return omax;
	}

}

class Bridge implements Comparable<Bridge> {
	public int n;
	public int s;

	public Bridge(int n, int s) {
		super();
		this.n = n;
		this.s = s;
	}

	@Override
	public int compareTo(Bridge o) {
		// TODO Auto-generated method stub
		if (this.n != o.n) {
			return this.n - o.n;
		} else {
			return this.s - o.s;
		}
	}

}
