/**
 * 
 */
package arrays;

/**
 * @author PRATAP
 *
 */
public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int ans = trappingWater(arr, arr.length);
		System.out.println(ans);
	}

	public static int trappingWater(int arr[], int n) {
		// Your code here
		int maxWater = 0;
		int left = 0, right = n - 1;
		int leftMax = 0, rightMax = 0;
		while (left <= right) {
			if (arr[left] <= arr[right]) {
				if (arr[left] >= leftMax) {
					leftMax = arr[left];
				} else {
					maxWater += leftMax - arr[left];
				}
				left++;
			} else {
				if (arr[right] >= rightMax) {
					rightMax = arr[right];
				} else {
					maxWater += rightMax - arr[right];
				}
				right--;
			}
		}
		return maxWater;
	}

}
