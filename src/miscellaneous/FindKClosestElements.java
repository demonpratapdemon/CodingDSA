/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author PRATAP LeetCode 658
 *
 */
public class FindKClosestElements {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s+");
		int[] arr = new int[input.length];
		for (int i = 0; i < input.length; i++)
			arr[i] = Integer.parseInt(input[i]);
		String[] buff = br.readLine().split("\\s+");
		int k = Integer.parseInt(buff[0]);
		int x = Integer.parseInt(buff[1]);
		List<Integer> ans = findClosestElements(arr, k, x);
		System.out.println(ans);
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		int n = arr.length;
		int pos = Arrays.binarySearch(arr, x);
		List<Integer> res = new ArrayList<Integer>();
		if (pos == 0 || Math.abs(pos) - 1 == 0) {
			for (int i = 0; i < k; i++) {
				res.add(arr[i]);
			}
		} else if (pos == n - 1 || Math.abs(pos) - 1 == n) {
			for (int i = n - k; i < n; i++) {
				res.add(arr[i]);
			}
		} else {
			int i = -1, j = -1;
			if (pos < 0) {
				pos = Math.abs(pos) - 1;
				if (pos < n) {
					i = pos - 1;
					j = pos;
				}
			} else {
				i = pos - 1;
				j = pos + 1;
				k--;
				res.add(arr[pos]);
			}
			while (i >= 0 && j <= n - 1 && k > 0) {
				if (Math.abs(arr[i] - x) < Math.abs(arr[j] - x)) {
					res.add(arr[i]);
					i--;
					k--;
				} else if (Math.abs(arr[j] - x) < Math.abs(arr[i] - x)) {
					res.add(arr[j]);
					j++;
					k--;
				} else if (Math.abs(arr[i] - x) == Math.abs(arr[j] - x)) {
					if (arr[i] < arr[j]) {
						res.add(arr[i]);
						k--;
						i--;
					} else {
						res.add(arr[j]);
						k--;
						j++;
					}
				}
				if (k == 0)
					break;
			}
			if (j >= n) {
				while (k-- > 0) {
					res.add(arr[i--]);
				}
			}
			if (i < 0) {
				while (k-- > 0) {
					res.add(arr[j++]);
				}
			}
			Collections.sort(res);
		}
		return res;
	}
}
