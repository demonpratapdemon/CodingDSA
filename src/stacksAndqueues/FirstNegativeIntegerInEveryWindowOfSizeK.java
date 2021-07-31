/**
 * 
 */
package stacksAndqueues;

import java.util.ArrayDeque;

/**
 * @author PRATAP
 *
 */
public class FirstNegativeIntegerInEveryWindowOfSizeK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 8, K = 3;
		long A[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		long[] ans = printFirstNegativeInteger(A, N, K);
		for (long i : ans)
			System.out.print(i + " ");
	}

	public static long[] printFirstNegativeInteger(long A[], int N, int K) {
		ArrayDeque<NegativePair> dq = new ArrayDeque<NegativePair>(K);
		for (int i = 0; i < K; i++) {
			if (A[i] < 0) {
				dq.offerLast(new NegativePair(A[i], i));
			}
		}
		long[] res = new long[N - K + 1];
		for (int i = 0; i <= N - K; i++) {
			if (dq.size() > 0) {
				if (dq.peekFirst().pos == i) {
					res[i] = dq.pollFirst().val;
				} else {
					res[i] = dq.peekFirst().val;
				}
			} else {
				res[i] = 0;
			}
			if (i + K < N && A[i + K] < 0) {
				dq.offerLast(new NegativePair(A[i + K], i + K));
			}
		}
		return res;
	}
}

class NegativePair {
	public long val;
	public int pos;

	public NegativePair(long val, int pos) {
		this.val = val;
		this.pos = pos;
	}
}
