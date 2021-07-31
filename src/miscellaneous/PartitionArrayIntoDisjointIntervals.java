/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 915
 *
 */
public class PartitionArrayIntoDisjointIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 0, 6, 12 };
		PartitionArrayIntoDisjointIntervals obj = new PartitionArrayIntoDisjointIntervals();
		int ans = obj.partitionDisjoint(nums);
		System.out.println(ans);
	}

	public int partitionDisjoint(int[] nums) {
		int n = nums.length;
		int[] leftMax = new int[n];
		int[] rightMin = new int[n];
		leftMax[0] = nums[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
		}
		rightMin[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
		}
		int i = 0;
		for (; i < n; i++) {
			if (leftMax[i] <= rightMin[i + 1])
				break;
		}
		return i + 1;
	}
}
