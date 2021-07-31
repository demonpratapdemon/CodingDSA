/**
 * 
 */
package arrays;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author PRATAP
 *
 */
public class ArraySubset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 0, -1, 0, -2, 2 };
	}

	public String isSubset(long a1[], long a2[], long n, long m) {
		Set<Long> set = new TreeSet<Long>();
		for (int i = 0; i < a1.length; i++)
			set.add(a1[i]);
		for (int i = 0; i < a2.length; i++) {
			if (!set.contains(a2[i]))
				return "No";
		}
		return "Yes";
	}

}
