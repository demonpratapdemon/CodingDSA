/**
 * 
 */
package search_sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PRATAP
 *
 */
public class SortBySetCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = { 9, 8, 6, 1, 11, 7, 3, 3, 10 };
		sortBySetBitCount(arr, arr.length);
	}

	static void sortBySetBitCount(Integer arr[], int n) {
		// Your code goes here
		BitPair[] temp = new BitPair[n];
		for (int i = 0; i < n; i++) {
			temp[i] = new BitPair(arr[i], setBitsCount(arr[i]));
		}
		Arrays.sort(temp, new ComparatorBit());
		for (int i = 0; i < n; i++) {
			System.out.print(temp[i].no + " ");
		}
	}

	static int setBitsCount(int x) {
		int count = 0;
		while (x > 0) {
			if ((x & 1) > 0) {
				count++;
			}
			x = x >> 1;
		}
		return count;
	}
}

class ComparatorBit implements Comparator<BitPair> {

	@Override
	public int compare(BitPair o1, BitPair o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o2.count, o1.count);
	}

}

class BitPair {
	public int no;
	public int count;

	public BitPair(int no, int count) {
		super();
		this.no = no;
		this.count = count;
	}

}
