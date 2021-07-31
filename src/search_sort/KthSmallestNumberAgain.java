/**
 * 
 */
package search_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PRATAP HackerEarth
 *
 */
public class KthSmallestNumberAgain {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] cases = br.readLine().split("\\s+");
			int N = Integer.parseInt(cases[0]);
			int Q = Integer.parseInt(cases[1]);
			SmallestPair[] arr = new SmallestPair[N];
			for (int i = 0; i < N; i++) {
				String[] buff = br.readLine().split("\\s+");
				Long start = Long.parseLong(buff[0]);
				Long end = Long.parseLong(buff[1]);
				arr[i] = new SmallestPair(start, end);
			}
			Arrays.sort(arr, new SPComparator());
			SmallestPair[] newSMPair = merge(arr);
			while (Q-- > 0) {
				Long k = Long.parseLong(br.readLine());
				Long ans = findKthSmallest(newSMPair, k);
				System.out.println(ans);
			}
		}
	}

	private static Long findKthSmallest(SmallestPair[] arr, Long k) {
		// TODO Auto-generated method stub
		Long smallest = Long.parseLong(String.valueOf(-1));
		for (int i = 0; i < arr.length; i++) {
			Long diff = arr[i].end - arr[i].start + 1;
			if (diff >= k) {
				smallest = arr[i].start + k - 1;
				break;
			} else {
				k -= diff;
			}
		}
		return smallest;
	}

	private static SmallestPair[] merge(SmallestPair[] arr) {
		// TODO Auto-generated method stub
		if (arr.length == 1)
			return arr;
		ArrayList<SmallestPair> list = new ArrayList<SmallestPair>();
		list.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			SmallestPair prev = list.get(list.size() - 1);
			if (prev.end >= arr[i].start) {
				list.remove(list.size() - 1);
				Long newStart = Math.min(prev.start, arr[i].start);
				Long newEnd = Math.max(prev.end, arr[i].end);
				list.add(new SmallestPair(newStart, newEnd));
			} else {
				list.add(arr[i]);
			}
		}
		SmallestPair[] newArr = new SmallestPair[list.size()];
		int p = 0;
		for (SmallestPair sp : list) {
			newArr[p++] = sp;
		}
		return newArr;
	}

}

class SPComparator implements Comparator<SmallestPair> {

	@Override
	public int compare(SmallestPair o1, SmallestPair o2) {
		return Long.compare(o1.start, o2.start);
	}
}

class SmallestPair {
	public Long start;
	public Long end;

	public SmallestPair(Long start, Long end) {
		this.start = start;
		this.end = end;
	}
}