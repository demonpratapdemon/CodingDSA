/**
 * 
 */
package miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP Graph BFS + Sieve of Eratosthenes (Adobe)
 *
 */
public class ShortestPrimePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 1009;
		int num2 = 1051;
		int shortestPath = shortestPath(num1, num2);
		System.out.println(shortestPath);
	}

	static boolean[] primes = new boolean[10000];

	private static void createPrimeArray() {
		// TODO Auto-generated method stub
		int n = 10000;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (!primes[i]) {
				for (int j = (i * i); j < n; j += i) {
					primes[j] = true;
				}
			}
		}
	}

	public static int shortestPath(int Num1, int Num2) {
		// Complete this function using prime array
		createPrimeArray();
		Queue<PrimePair> q = new LinkedList<PrimePair>();
		q.add(new PrimePair(Num1, 0));
		int steps = Integer.MAX_VALUE;
		boolean[] visited = new boolean[10000];
		visited[Num1] = true;
		while (!q.isEmpty()) {
			PrimePair curr = q.poll();
			if (curr.num == Num2) {
				steps = Math.min(steps, curr.steps);
			}
			for (int i = 0; i < 4; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(curr.num);
				for (int j = 0; j < 10; j++) {
					if ((i == 0 && j == 0) || sb.charAt(i) == String.valueOf(j).charAt(0)) {
						continue;
					}
					String str = String.valueOf(j);
					sb.setCharAt(i, str.charAt(0));
					if (!primes[Integer.parseInt(sb.toString())] && !visited[Integer.parseInt(sb.toString())]) {
						visited[Integer.parseInt(sb.toString())] = true;
						q.add(new PrimePair(Integer.parseInt(sb.toString()), curr.steps + 1));
					}
				}
			}
		}
		if (steps == Integer.MAX_VALUE)
			return -1;
		return steps;
	}

}

class PrimePair {
	public int num;
	public int steps;

	public PrimePair(int num, int steps) {
		this.num = num;
		this.steps = steps;
	}
}
