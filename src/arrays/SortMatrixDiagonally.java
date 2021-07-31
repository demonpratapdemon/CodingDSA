/**
 * 
 */
package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author PRATAP LeetCode 1329
 *
 */
public class SortMatrixDiagonally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 3, 9 }, { 2, 4 }, { 1, 2 }, { 9, 8 }, { 7, 3 } };
		System.out.println("Before");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("******************************************");
		int[][] ans = diagonalSort(mat);
		System.out.println("After");
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] diagonalSort(int[][] mat) {
		List<Integer> list = new ArrayList<Integer>();
		int m = mat.length, n = mat[0].length;
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			flag = false;
			int k = i;
			int j = 0;
			list.clear();
			while (k < m && j < n) {
				if (list.size() <= 0) {
					list.add(mat[k][j]);
				} else {
					if (list.get(list.size() - 1) > mat[k][j]) {
						flag = true;
					}
					list.add(mat[k][j]);
				}
				k++;
				j++;
			}
			if (flag) {
				Collections.sort(list);
				k = i;
				j = 0;
				while (k < m && j < n) {
					mat[k][j] = list.get(j);
					k++;
					j++;
				}
			}
		}
		for (int j = 1; j < n; j++) {
			int i = 0;
			int k = j;
			if (list.size() > 0)
				list.clear();
			flag = false;
			while (i < m && k < n) {
				if (list.size() == 0) {
					list.add(mat[i][k]);
				} else {
					if (list.get(list.size() - 1) > mat[i][k]) {
						flag = true;
					}
					list.add(mat[i][k]);
				}
				i++;
				k++;
			}
			if (flag) {
				Collections.sort(list);
				i = 0;
				k = j;
				while (i < m && k < n) {
					mat[i][k] = list.get(i);
					i++;
					k++;
				}
			}
		}
		return mat;
	}
}
