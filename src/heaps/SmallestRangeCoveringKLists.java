/**
 * 
 */
package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 632
 *
 */
public class SmallestRangeCoveringKLists {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		while (n-- > 0) {
			String[] input = br.readLine().split("\\s+");
			nums.add(new ArrayList<Integer>());
			int i = nums.size() - 1;
			for (String str : input) {
				nums.get(i).add(Integer.parseInt(str));
			}
		}
		int[] ans = smallestRange(nums);
		for (int i : ans)
			System.out.print(i + " ");
	}

	public static int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<ListCover> minHeap = new PriorityQueue<ListCover>(new ListComp());
		int k = nums.size();
		ListCover min = null, max = null;
		for (int i = 0; i < k; i++) {
			ListCover newEle = new ListCover(nums.get(i).get(0), i, 0);
			minHeap.add(newEle);
			if (max == null)
				max = newEle;
			else
				max = max.val > newEle.val ? max : newEle;
		}
		min = minHeap.peek();
		int range = max.val - min.val;
		int[] ans = new int[2];
		int prevRange = 0;
		ans[0] = minHeap.peek().val;
		ans[1] = max.val;
		while (!minHeap.isEmpty()) {
			min = minHeap.peek();
			minHeap.remove();
			if (min.col + 1 >= nums.get(min.row).size()) {
				break;
			}
			ListCover newEle = new ListCover(nums.get(min.row).get(min.col + 1), min.row, min.col + 1);
			minHeap.add(newEle);
			max = max.val > newEle.val ? max : newEle;
			prevRange = range;
			range = Math.min(range, max.val - minHeap.peek().val);
			if (prevRange != range) {
				ans[0] = minHeap.peek().val;
				ans[1] = max.val;
			}
		}
		return ans;
	}

}

class ListComp implements Comparator<ListCover> {

	@Override
	public int compare(ListCover o1, ListCover o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.val, o2.val);
	}

}

class ListCover {
	public int val;
	public int row;
	public int col;

	public ListCover(int val, int row, int col) {
		super();
		this.val = val;
		this.row = row;
		this.col = col;
	}

}
