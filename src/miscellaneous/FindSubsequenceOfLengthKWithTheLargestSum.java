/**
 * 
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 2099
 *
 */
public class FindSubsequenceOfLengthKWithTheLargestSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { -1, -2, 3, 4 }, k = 3;
		FindSubsequenceOfLengthKWithTheLargestSum obj = new FindSubsequenceOfLengthKWithTheLargestSum();
		int[] ans = obj.maxSubsequence(nums, k);
		for (int i = 0; i < k; i++)
			System.out.print(ans[i] + " ");
	}

	public int[] maxSubsequence(int[] nums, int k) {
		int[] ans = new int[k];
		PriorityQueue<Box> pq = new PriorityQueue<Box>();
		for (int i = 0; i < nums.length; i++) {
			pq.add(new Box(nums[i], i));
		}
		List<Box> list = new ArrayList<Box>();
		while (k-- > 0 && !pq.isEmpty()) {
			Box curr = pq.poll();
			list.add(curr);
		}
		Collections.sort(list, new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.idx, o2.idx);
			}
		});
		int i = 0;
		for (Box b : list) {
			ans[i++] = b.val;
		}
		return ans;
	}
}

class Box implements Comparable<Box> {
	public int val;
	public int idx;

	public Box(int val, int idx) {
		super();
		this.val = val;
		this.idx = idx;
	}

	@Override
	public int compareTo(Box o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.val, this.val);
	}

}
