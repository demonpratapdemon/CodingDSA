/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP LeetCode 303
 *
 */
public class Day16_RangeSumQueryImmutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class NumArray {

	int tree[];
	int newArr[];

	public NumArray(int[] nums) {
		this.newArr = nums;
		tree = new int[4 * nums.length];
		build(1, 0, nums.length - 1);
	}

	private void build(int node, int start, int end) {
		// TODO Auto-generated method stub
		if (start == end) {
			tree[node] = this.newArr[start];
			return;
		}
		int mid = (start + end) / 2;
		int left = 2 * node;
		int right = 2 * node + 1;
		build(left, start, mid);
		build(right, mid + 1, end);
		tree[node] = tree[left] + tree[right];
	}

	public int sumRange(int l, int r) {
		int start = 0, end = this.newArr.length - 1;
		int ans = find(1, start, end, l, r);
		return ans;
	}

	private int find(int node, int start, int end, int l, int r) {
		// TODO Auto-generated method stub
		if (start > r || end < l)
			return Integer.MIN_VALUE;
		if (start == end)
			return tree[node];
		else if (start >= l && end <= r) {
			return tree[node];
		} else {
			int mid = (start + end) / 2;
			int left = find(2 * node, start, mid, l, r);
			int right = find(2 * node + 1, mid + 1, end, l, r);
			int sum = (left == Integer.MIN_VALUE) ? 0 : left;
			sum += (right == Integer.MIN_VALUE) ? 0 : right;
			return sum;
		}
	}
}
