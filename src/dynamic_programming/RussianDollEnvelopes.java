/**
 * 
 */
package dynamic_programming;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class RussianDollEnvelopes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		int ans = maxEnvelopes(envelopes);
		System.out.println(ans);
	}

	public static int maxEnvelopes(int[][] envelopes) {
		int n = envelopes.length;
		Envelop[] envs = new Envelop[n];
		for (int i = 0; i < n; i++) {
			envs[i] = new Envelop(envelopes[i][0], envelopes[i][1]);
		}
		Arrays.sort(envs);
		int[] dp = new int[n];
		int omax = 0;
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (envs[i].w > envs[j].w && envs[i].h > envs[j].h) {
					if (dp[j] > max)
						max = dp[j];
				}
			}
			dp[i] = max + 1;
			omax = Math.max(omax, dp[i]);
		}
		return omax;
	}
}

class Envelop implements Comparable<Envelop> {
	public int w;
	public int h;

	public Envelop(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public int compareTo(Envelop o) {
		// TODO Auto-generated method stub
		if (this.w != o.w)
			return this.w - o.w;
		return this.h - o.h;
	}

}
