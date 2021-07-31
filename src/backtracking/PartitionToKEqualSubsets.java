/**
 * 
 */
package backtracking;

import java.util.ArrayList;

/**
 * @author PRATAP LeetCode 698
 *
 */
public class PartitionToKEqualSubsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 354, 1983, 167, 2655, 73, 927, 470, 485, 1035, 405, 1358, 1944, 3404, 4078, 2500, 577 };
		int k = 5;
		boolean ans = kpartition(nums, k);
		System.out.println(ans);
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		// if k == 1
		if (k == 1)
			return false;
		// if k > nums.length
		int n = nums.length;
		if (k > n)
			return false;
		int sum = 0;
		for (int i : nums)
			sum += i;
		if (sum % k != 0)
			return false;
		int subsetSum[] = new int[k];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < k; i++)
			list.add(new ArrayList<Integer>());
//		stn = 0 => subset till now
		boolean[] visited = new boolean[n];
		boolean flag = solve(nums, k, 0, subsetSum, list, 0, sum / k, 0, visited);
		return flag;
	}

//	Recursive Approach
	private static boolean solve(int[] nums, int k, int currId, int[] subsetSum, ArrayList<ArrayList<Integer>> list,
			int stn, int reqdSum, int pos, boolean[] visited) {
		// TODO Auto-generated method stub
		if (pos < subsetSum.length && subsetSum[pos] > reqdSum)
			return false;
		if (currId == nums.length) {
			if (k == stn) {
				boolean flag = true;
				for (int i = 1; i < k; i++) {
					if (subsetSum[i] != subsetSum[i - 1]) {
						flag = false;
						break;
					}
				}
				if (flag)
					return true;
			}
			return false;
		}
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).size() > 0 && !visited[currId]) {
				list.get(i).add(nums[currId]);
				subsetSum[i] += nums[currId];
				visited[currId] = true;
				flag = solve(nums, k, currId + 1, subsetSum, list, stn, reqdSum, i, visited);
				if (flag) {
					break;
				}
				visited[currId] = false;
				subsetSum[i] -= nums[currId];
				list.get(i).remove(list.get(i).size() - 1);
			} else if (!visited[currId]) {
				list.get(i).add(nums[currId]);
				subsetSum[i] += nums[currId];
				visited[currId] = true;
				flag = solve(nums, k, currId + 1, subsetSum, list, stn + 1, reqdSum, i, visited);
				if (flag) {
					break;
				}
				visited[currId] = false;
				subsetSum[i] -= nums[currId];
				list.get(i).remove(list.get(i).size() - 1);
			}
		}
		return flag;
	}

	public static boolean kpartition(int[] nums, int k) {
		if (k == 1)
			return false;
		// if k > nums.length
		int n = nums.length;
		if (k > n)
			return false;
		int sum = 0;
		for (int i : nums)
			sum += i;
		if (sum % k != 0)
			return false;
		boolean[] visited = new boolean[n];
		return subsets(nums, 0, k, 0, sum / k, visited);
	}

	private static boolean subsets(int[] nums, int i, int k, int currSum, int sum, boolean[] visited) {
		// TODO Auto-generated method stub
		if (k == 0)
			return true;
		if (currSum > sum)
			return false;
		if (currSum == sum) {
			return subsets(nums, 0, k - 1, 0, sum, visited);
		}

		for (int j = i; j < nums.length; j++) {
			if (!visited[j]) {
				visited[j] = true;
				if (subsets(nums, j + 1, k, currSum + nums[j], sum, visited))
					return true;
				visited[j] = false;
			}
		}
		return false;
	}

}
