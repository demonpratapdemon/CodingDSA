/**
 * 
 */
package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author PRATAP
 *
 */
public class FirstNonRepeatingCharacterInStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "zz"; // abcabc
		String ans = firstNonRepeating(A);
		System.out.println(ans);
	}

	public static String firstNonRepeating(String A) {
		// code here
		Queue<Character> q = new LinkedList<Character>();
		int[] freq = new int[26];
		StringBuffer res = new StringBuffer();
		int n = A.length();
		for (int i = 0; i < n; i++) {
			int index = A.charAt(i) - 'a';
			freq[index] += 1;
			q.add(A.charAt(i));
			Character front = q.peek();
			if (freq[front - 'a'] == 1) {
				res.append(front);
			} else {
				q.poll();
				if (q.size() != 0 && freq[q.peek() - 'a'] == 1)
					res.append(q.peek());
				else if (q.isEmpty()) {
					res.append("#");
				} else {
					q.poll();
					i--;
				}
			}
		}
		return res.toString();
	}

}