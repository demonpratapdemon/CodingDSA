/**
 * 
 */
package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PRATAP
 *
 */
public class SubarrayWith0Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findsum(new int[] { 4, 2, -3, 1, 6 }, 5));
	}

	public static boolean findsum(int arr[], int n) {
		// Your code here
		Set<Integer> hs = new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (arr[i] == 0 || sum == 0 || hs.contains(sum)) {
				return true;
			}
			hs.add(sum);
		}
		return false;
	}

}
