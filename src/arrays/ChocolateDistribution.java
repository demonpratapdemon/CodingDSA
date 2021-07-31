/**
 * 
 */
package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author PRATAP
 *
 */
public class ChocolateDistribution {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			String[] input = br.readLine().split(" ");
			ArrayList<Long> arr = new ArrayList<Long>();
			for (String s : input)
				arr.add(Long.parseLong(s));
			long noOfStudents = Long.parseLong(br.readLine());
			long minimumDiff = findMinDiff(arr, Long.parseLong(String.valueOf(arr.size())), noOfStudents);
			System.out.println(minimumDiff);
		}
	}

	public static long findMinDiff(ArrayList<Long> a, long n, long m) {
		// your code here
		Collections.sort(a);
		long minDiff = Integer.MAX_VALUE;
		long i = 0, j = i + m - 1;
		while (i <= j && j < n) {
			minDiff = Math.min(minDiff, a.get((int) j) - a.get((int) i));
			i++;
			j++;
		}
		return minDiff;
	}

}
