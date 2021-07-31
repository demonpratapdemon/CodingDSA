/**
 * 
 */
package arrays;

/**
 * @author PRATAP LeetCode 1497
 *
 */
public class CheckIfArrayPairsAreDivisibleByK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { -1, 1, -2, 2, -3, 3, -4, 4 }, k = 3;
		int arr[] = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 }, k = 5;
		CheckIfArrayPairsAreDivisibleByK obj = new CheckIfArrayPairsAreDivisibleByK();
		boolean ans = obj.canArrange(arr, k);
		System.out.println(ans);
	}

	public boolean canArrange(int[] arr, int k) {
		int[] freq = new int[k];
		for (int i = 0; i < arr.length; i++) {
			freq[(((arr[i]) % k) + k) % k]++;
		}
		for (int i = 0; i < k; i++) {
			if (i == 0 && freq[i] % 2 > 0)
				return false;
			else if (i > 0) {
				int x = freq[i];
				int s = freq[k - i];
				if (x != s)
					return false;
			}
		}
		return true;
	}
}
