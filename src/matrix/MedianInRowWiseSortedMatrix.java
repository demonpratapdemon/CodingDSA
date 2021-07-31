/**
 * 
 */
package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class MedianInRowWiseSortedMatrix {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the nos space separated");
		String[] numbers = br.readLine().split("\\s+");
		String[] row_col = br.readLine().split("\\s+");
		int[] nos = new int[numbers.length];
		int l = 0;
		for (String s : numbers)
			nos[l++] = Integer.parseInt(s);
		Arrays.sort(nos);
		System.out.println("Actual Median without Algo= " + nos[(nos.length + 1) / 2]);
		int row = Integer.parseInt(row_col[0]);
		int col = Integer.parseInt(row_col[1]);
		int[][] matrix = new int[row][col];
		int k = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.parseInt(numbers[k++]);
			}
		}

		int median = median(matrix, matrix.length, matrix[0].length);
		System.out.println("Median = " + median);
	}

	public static int median(int matrix[][], int r, int c) {
		// code here
		int min = matrix[0][0];
		int max = matrix[0][c - 1];
		for (int i = 1; i < r; i++) {
			min = Math.min(min, matrix[i][0]);
			max = Math.max(max, matrix[i][c - 1]);
		}
		int med = (1 + r * c) / 2;
		while (min <= max) {
			int mid = (min + max) / 2;
			int noOfSmallerElements = 0;
			int pos = -1;
			for (int i = 0; i < r; i++) {
				pos = Arrays.binarySearch(matrix[i], mid);
				if (pos >= 0) {
					if (pos < c - 1 && matrix[i][pos + 1] == mid) {
						while (matrix[i][pos + 1] == mid)
							pos++;
					}
					noOfSmallerElements += pos + 1;
				} else {
					noOfSmallerElements += Math.abs(pos) - 1;
				}
			}
			System.out.println("Mid =" + mid + " smaller_elements = " + noOfSmallerElements);
			if (noOfSmallerElements == med && pos >= 0) {
				return mid;
			} else if (noOfSmallerElements < med) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return min;
	}

}
