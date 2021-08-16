/**
 * 
 */
package segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class MaxInAnInterval {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(read.readLine());
		}

		SegmentTree obj = new SegmentTree(arr);

		int q = Integer.parseInt(read.readLine());

		StringBuilder out = new StringBuilder();
		while (q-- > 0) {
			String[] inp = read.readLine().split(" ");

			int l = Integer.parseInt(inp[0]);
			int r = Integer.parseInt(inp[1]);

			int ans = obj.query(l, r);
			out.append(ans);
			out.append("\n");
		}

		System.out.println(out);
	}

	public static class SegmentTree {

		int tree[];
		int newArr[];

		SegmentTree(int arr[]) {
			this.newArr = arr;
			tree = new int[4 * arr.length];
			build(1, 0, arr.length - 1);
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
			tree[node] = Math.max(tree[left], tree[right]);
		}

		int query(int l, int r) {
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
				return Math.max(left, right);
			}
		}

	}

}
