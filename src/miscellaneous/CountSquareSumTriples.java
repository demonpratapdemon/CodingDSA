/**
 * 
 */
package miscellaneous;

import java.util.TreeSet;

/**
 * @author PRATAP
 *
 */
public class CountSquareSumTriples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		CountSquareSumTriples obj = new CountSquareSumTriples();
		int ans = obj.countTriples(n);
		System.out.println(ans);
	}

	public int countTriples(int n) {
		int count = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 1; i <= n; i++)
			set.add(i * i);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (set.contains(i * i + j * j))
					count++;
			}
		}
		return count;
	}
}
