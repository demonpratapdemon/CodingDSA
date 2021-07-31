/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 875
 *
 */
public class KokoEatingBananas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int piles[] = { 30, 11, 23, 4, 20 }, h = 5;
		KokoEatingBananas obj = new KokoEatingBananas();
		int ans = obj.minEatingSpeed(piles, h);
		System.out.println(ans);
	}

	public int minEatingSpeed(int[] piles, int h) {
		int n = piles.length;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = piles[i];
		Arrays.sort(arr);
		int lo = 0, hi = arr[n - 1];
		int res = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (check(piles, mid, h)) {
				res = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return res;
	}

	private boolean check(int[] piles, int mid, int h) {
		// TODO Auto-generated method stub
		double hrs = 0;
		for (int i = 0; i < piles.length; i++) {
			hrs += Math.ceil((double) piles[i] / (double) mid);
			if (hrs > h)
				return false;
		}
		return true;
	}

}
