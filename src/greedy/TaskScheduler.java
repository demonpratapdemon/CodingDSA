/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author PRATAP LeetCode 621
 *
 */
public class TaskScheduler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
//		int n = 0;
		char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int n = 2;
		TaskScheduler obj = new TaskScheduler();
		int ans = obj.leastInterval(tasks, n);
		System.out.println(ans);
	}

	public int leastInterval(char[] tasks, int n) {
		PriorityQueue<Task> pq = new PriorityQueue<>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ch : tasks)
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		Iterator<Character> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			char key = itr.next();
			pq.add(new Task(key, map.get(key)));
		}
		int res = 0;
		while (!pq.isEmpty()) {
			int time = 0;
			ArrayList<Task> list = new ArrayList<Task>();
			for (int i = 0; i <= n; i++) {
				if (!pq.isEmpty()) {
					Task temp = pq.poll();
					temp.count--;
					list.add(temp);
					time++;
				} else {
					break;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).count > 0) {
					pq.add(list.get(i));
				}
			}
			res += pq.isEmpty() ? time : n + 1;
		}
		return res;
	}
}

class Task implements Comparable<Task> {
	public char task;
	public int count;

	@Override
	public String toString() {
		return "Task [task=" + task + ", count=" + count + "]";
	}

	public Task(char task, int count) {
		super();
		this.task = task;
		this.count = count;
	}

	@Override
	public int compareTo(Task o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.count, this.count);
	}

}
