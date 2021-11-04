/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 309
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2, 3, 0, 2 };
		int profit = maxProfit(prices);
		System.out.println(profit);
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int obsp = 0, ossp = 0, ocsp = 0;
		obsp = -prices[0];
		for (int i = 1; i < n; i++) {
			int nbsp = 0, nssp = 0, ncsp = 0;
			if (ocsp - prices[i] > obsp) {
				nbsp = ocsp - prices[i];
			} else {
				nbsp = obsp;
			}
			if (prices[i] + obsp > ossp) {
				nssp = prices[i] + obsp;
			} else {
				nssp = ossp;
			}
			ncsp = Math.max(ocsp, ossp);
			obsp = nbsp;
			ossp = nssp;
			ocsp = ncsp;
		}
		return ossp;
	}
}
