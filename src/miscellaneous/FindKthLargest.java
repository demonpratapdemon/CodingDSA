/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 215(Quick Select)
 *
 */
public class FindKthLargest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		FindKthLargest ob = new FindKthLargest();
		int ans = ob.findKthLargest(nums, k);
		System.out.println(ans);
	}

	public int findKthLargest(int[] nums, int k) {
		k = nums.length - k;
		int ans = findKth(nums, k, 0, nums.length - 1);
		return ans;
	}

	public int findKth(int[] nums, int k, int lo, int hi) {
		int pivot = nums[hi];
		int pi = partition(nums, lo, hi, pivot);
		if (pi > k)
			return findKth(nums, k, lo, pi - 1);
		else if (pi < k)
			return findKth(nums, k, pi + 1, hi);
		else
			return pivot;
	}

	public int partition(int[] nums, int lo, int hi, int pivot) {
		int j = lo, i = lo;
		while (i < hi) {
			if (nums[i] <= pivot) {
				swap(nums, i, j);
				j++;
			}
			i++;
		}
		swap(nums, i, j);
		return j;
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
