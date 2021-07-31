/**
 * 
 */
package greedy;

import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class MinimumPlatforms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int minPlats = findPlatform(arr, dep, arr.length);
		System.out.println(minPlats);
	}

	static int findPlatform(int arr[], int dep[], int n) {
		// add your code here
		Arrays.sort(arr);
		Arrays.sort(dep);
		int plats = 1, maxPlats = 1;
		int i = 1, j = 0;
		while (i < n) {
			if (arr[i] <= dep[j]) {
				plats++;
				i++;
			} else if (arr[i] > dep[j]) {
				plats--;
				j++;
			}
			maxPlats = Math.max(maxPlats, plats);
		}
		return maxPlats;
	}

}

class PlatPair {
	public int arv;
	public int dept;

	public PlatPair(int arv, int dept) {
		super();
		this.arv = arv;
		this.dept = dept;
	}

}