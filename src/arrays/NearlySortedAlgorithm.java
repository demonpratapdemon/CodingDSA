/**
 * 
 */
package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class NearlySortedAlgorithm {

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
			String[] buff = br.readLine().split("\\s+");
			int n = Integer.parseInt(buff[0]);
			int k = Integer.parseInt(buff[1]);
			int[] arr = new int[n];
			String[] input = br.readLine().split("\\s+");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			ksort(arr, n, k);
			for (int i = 0; i < n; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}

	private static void ksort(int[] arr, int n, int k) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		if (k + 1 > n) {
			for (int i : arr)
				pq.add(i);
		} else {
			for (int i = 0; i < k + 1; i++)
				pq.add(arr[i]);
		}

		int idx = 0;
		for (int i = k + 1; i < n; i++) {
			arr[idx++] = pq.poll();
			pq.add(arr[i]);
		}

		while (!pq.isEmpty()) {
			arr[idx++] = pq.poll();
		}
	}

}
