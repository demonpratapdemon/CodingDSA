/**
 * 
 */
package miscellaneous;

import java.util.Arrays;

/**
 * @author PRATAP LeetCode 135
 *
 */
public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[1,3,2,4]
//		[0,1,2,5,3,2,7]
//		[1,0,0]
		int[] ratings = { 1, 2, 87, 87, 87, 2, 1 };
		int ans = candy(ratings);
		System.out.println(ans);
	}

	public static int candy(int[] ratings) {
		int n = ratings.length;
		int[] l2r = new int[n];
		int[] r2l = new int[n];
		Arrays.fill(l2r, 1);
		Arrays.fill(r2l, 1);
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				l2r[i] = l2r[i - 1] + 1;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				r2l[i] = r2l[i + 1] + 1;
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.max(l2r[i], r2l[i]);
		}
		return sum;
	}
}
