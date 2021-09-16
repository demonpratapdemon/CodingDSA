/**
 * 
 */
package september_leetcode_challenge;

/**
 * @author PRATAP LeetCode 978
 *
 */
public class Day15_LongestTurbulentSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
		Day15_LongestTurbulentSubarray obj = new Day15_LongestTurbulentSubarray();
		int ans = obj.maxTurbulenceSize(arr);
		System.out.println(ans);
	}

	public int maxTurbulenceSize(int[] arr) {
		int n = arr.length;
		if (n == 1)
			return 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1])
				continue;
			int j = i + 1;
			while (j < n - 1 && (checkValley(arr, j) || checkMountain(arr, j))) {
				j++;
			}
			max = Math.max(max, j - i + 1);
		}
		return max == Integer.MIN_VALUE ? 1 : max;
	}

	private boolean checkMountain(int[] arr, int j) {
		// TODO Auto-generated method stub
		int prev = arr[j - 1];
		if (j == arr.length - 1)
			return true;
		int next = arr[j + 1];
		if (prev < arr[j] && arr[j] > next)
			return true;
		return false;
	}

	private boolean checkValley(int[] arr, int j) {
		// TODO Auto-generated method stub
		int prev = arr[j - 1];
		if (j == arr.length - 1)
			return true;
		int next = arr[j + 1];
		if (prev > arr[j] && arr[j] < next)
			return true;
		return false;
	}
}
