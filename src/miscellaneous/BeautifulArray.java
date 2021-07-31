/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;

/**
 * @author PRATAP LeetCode 932
 *
 */
public class BeautifulArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		BeautifulArray obj = new BeautifulArray();
		int[] ans = obj.beautifulArray(n);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public int[] beautifulArray(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 2; i <= n; i++) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			for (int j = 0; j < list.size(); j++) {
				if (2 * list.get(j) - 1 <= i) {
					l.add(2 * list.get(j) - 1);
				}
			}
			for (int j = 0; j < list.size(); j++) {
				if (2 * list.get(j) <= i) {
					l.add(2 * list.get(j));
				}
			}
			list = l;
		}
		int[] ans = new int[n];
		for (int i = 0; i < n; i++)
			ans[i] = list.get(i);
		return ans;
	}
}
