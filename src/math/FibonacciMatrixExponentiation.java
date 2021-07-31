package math;

/**
 * @author PRATAP
 *
 */
public class FibonacciMatrixExponentiation {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1000;
		int ans = fib(n);
		System.out.println(ans);
	}

	static long mod = (long) (1e9 + 7);

	public static int fib(int n) {
		if (n == 0 || n == 1)
			return n;
		int k = n;
		int count = 0;
		while (k > 0) {
			count++;
			k /= 2;
		}

		long[][][] exp = new long[count][2][2];
		exp[0] = new long[][] { { 1, 1 }, { 1, 0 } };
		for (int i = 1; i < count; i++) {
			exp[i] = square(exp[i - 1]);
		}
		long[][] result = null;
		n--;
		for (int i = 31; i >= 0; i--) {
			if ((n & (1 << i)) != 0) {
				if (result == null)
					result = exp[i];
				else
					result = mult(result, exp[i]);
			}
		}
		return (int) (result[0][0] % mod);
	}

	private static long[][] square(long[][] mat) {
		// TODO Auto-generated method stub
		return mult(mat, mat);
	}

	private static long[][] mult(long[][] mat1, long[][] mat2) {
		// TODO Auto-generated method stub
		long res[][] = new long[mat1.length][mat2[0].length];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				for (int k = 0; k < mat1.length; k++) {
					res[i][j] += (mat1[i][k] * mat2[k][j]) % mod;
				}
			}
		}
		return res;
	}
}
