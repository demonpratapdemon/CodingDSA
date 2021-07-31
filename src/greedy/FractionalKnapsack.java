/**
 * 
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PRATAP
 *
 */
public class FractionalKnapsack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int W = 50;
		int wt[] = { 10, 20, 30 };
		int val[] = { 60, 100, 120 };
		double ans = knapSack(W, wt, val, val.length);
		System.out.println(ans);
	}

	static double knapSack(int W, int wt[], int val[], int n) {
		// your code here
		double ans = solve(W, wt, val, n, 0);
		return ans;
	}

	private static double solve(int W, int[] wt, int[] val, int n, int maxProfit) {
		// TODO Auto-generated method stub
		KSPair[] valuePerWt = new KSPair[n];
		for (int i = 0; i < n; i++) {
			valuePerWt[i] = new KSPair(wt[i], val[i], ((double) val[i] / wt[i]));
		}
		Arrays.sort(valuePerWt, new Comparator<KSPair>() {

			@Override
			public int compare(KSPair o1, KSPair o2) {
				// TODO Auto-generated method stub
				return -Double.compare(o1.valPWt, o2.valPWt);
			}
		});
		double profit = 0;
		int i = 0;
		for (; i < n; i++) {
			KSPair curr = valuePerWt[i];
			if (W - curr.wt >= 0) {
				profit += curr.val;
				W -= curr.wt;
			} else
				break;
		}
		if (i < n)
			profit += (valuePerWt[i].valPWt) * W;
		return profit;
	}

}

class KSPair {
	public int wt;
	public int val;
	public double valPWt;

	public KSPair(int wt, int val, double valPWt) {
		super();
		this.wt = wt;
		this.val = val;
		this.valPWt = valPWt;
	}

}
