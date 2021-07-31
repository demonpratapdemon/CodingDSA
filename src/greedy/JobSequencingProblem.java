/**
 * 
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;

import entities.Job;

/**
 * @author PRATAP
 *
 */
public class JobSequencingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job[] arr = new Job[4];
		arr[0] = new Job(1, 4, 20);
		arr[1] = new Job(2, 1, 10);
		arr[2] = new Job(3, 1, 40);
		arr[3] = new Job(4, 1, 30);
		int[] res = JobScheduling(arr, arr.length);
		System.out.println(res[0] + " " + res[1]);
	}

	static int[] JobScheduling(Job arr[], int n) {
		// Your code here
		Arrays.sort(arr, new Comparator<Job>() {

			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				return -Integer.compare(o1.profit, o2.profit);
			}
		});
		int maxDeadline = -1;
		for (int i = 0; i < n; i++)
			maxDeadline = Math.max(maxDeadline, arr[i].deadline);
		Integer[] timeline = new Integer[maxDeadline];
		int counter = 0;
		int profit = 0;
		for (int i = 0; i < n; i++) {
			Job curr = arr[i];
			for (int j = curr.deadline - 1; j >= 0; j--) {
				if (timeline[j] == null) {
					timeline[j] = curr.id;
					counter++;
					profit += curr.profit;
					break;
				}
			}
		}
		return new int[] { counter, profit };
	}
}
