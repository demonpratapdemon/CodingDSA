/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1975
 *
 */
public class MaximumMatrixSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 }, { -1, -2, -3 }, { 1, 2, 3 } };
//		int[][] matrix = { { -1, 0, -1 }, { -2, 1, 3 }, { 3, 2, 2 } };
		MaximumMatrixSum obj = new MaximumMatrixSum();
		long ans = obj.maxMatrixSum(matrix);
		System.out.println(ans);
	}

	public long maxMatrixSum(int[][] matrix) {
		long sum = 0;
		int negatives = 0;
		int m = matrix.length, n = matrix[0].length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sum += Math.abs(matrix[i][j]);
				if (matrix[i][j] < 0)
					negatives++;
				min = Math.min(min, Math.abs(matrix[i][j]));
			}
		}
		System.out.println(min);
		if (negatives % 2 != 0)
			sum -= 2 * min;
		return sum;
	}
}

class ValPos implements Comparable<ValPos> {
	public int val;
	public int i;
	public int j;

	public ValPos(int val, int i, int j) {
		super();
		this.val = val;
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString() {
		return "ValPos [val=" + val + ", i=" + i + ", j=" + j + "]";
	}

	@Override
	public int compareTo(ValPos o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.val, o.val);
	}

}
