/**
 * 
 */
package dynamic_programming;

/**
 * @author PRATAP LeetCode 714
 *
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = { 1, 3, 2, 8, 4, 9 }, fee = 2;
		int profit = maxProfit(prices, fee);
		System.out.println(profit);
	}

	public static int maxProfit(int[] prices, int fee) {
		int obsp = 0, ossp = 0;
		obsp = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			int nbsp = 0, nssp = 0;
			if (ossp - prices[i] > obsp) {
				nbsp = ossp - prices[i];
			} else {
				nbsp = obsp;
			}
			if (prices[i] + obsp - fee > ossp) {
				nssp = prices[i] + obsp - fee;
			} else {
				nssp = ossp;
			}
			obsp = nbsp;
			ossp = nssp;
		}
		return ossp;
	}
}
