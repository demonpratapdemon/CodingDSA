/**
 * 
 */
package backtracking;

/**
 * @author PRATAP
 *
 */
public class Sudoku {

	static boolean flag = false;
	static int finalGrid[][];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 8, 7, 6, 5, 4, 3, 2, 1 }, { 2, 0, 0, 0, 0, 0, 0, 0, 0 }, { 3, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0 }, { 5, 0, 0, 0, 0, 0, 0, 0, 0 }, { 6, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 7, 0, 0, 0, 0, 0, 0, 0, 0 }, { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 9, 0, 0, 0, 0, 0, 0, 0, 0 } };
		SolveSudoku(grid);
		if (flag) {
			printGrid(grid);
		}
	}

	static boolean SolveSudoku(int grid[][]) {
		// add your code here
		finalGrid = new int[grid.length][grid[0].length];
		solveGrid(grid, 0, 0);
		if (flag) {
			for (int k = 0; k < grid.length; k++) {
				for (int l = 0; l < grid[0].length; l++) {
					grid[k][l] = finalGrid[k][l];
				}
			}
		}
		return flag;
	}

	private static void solveGrid(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		if (i == grid.length) {
			if (!flag) {
				for (int k = 0; k < grid.length; k++) {
					for (int l = 0; l < grid[0].length; l++) {
						finalGrid[k][l] = grid[k][l];
					}
				}
			}
			flag = true;
			return;
		}
		int ni = 0;
		int nj = 0;
		if (j == grid[0].length - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}
		if (grid[i][j] != 0) {
			solveGrid(grid, ni, nj);
		} else {
			for (int po = 1; po < 10; po++) {
				if (isValid(grid, i, j, po)) {
					grid[i][j] = po;
					solveGrid(grid, ni, nj);
					grid[i][j] = 0;
				}
			}
		}
	}

	private static boolean isValid(int[][] grid, int i, int j, int po) {
		// TODO Auto-generated method stub
		// row check
		for (int k = 0; k < grid.length; k++) {
			if (grid[i][k] == po)
				return false;
		}
		// col check
		for (int k = 0; k < grid.length; k++) {
			if (grid[k][j] == po)
				return false;
		}
		// sub matrix check
		int corneri = 3 * (i / 3);
		int cornerj = 3 * (j / 3);
		for (int k = corneri; k < corneri + 3; k++) {
			for (int l = cornerj; l < cornerj + 3; l++) {
				if (grid[k][l] == po)
					return false;
			}
		}
		return true;
	}

	// Function to print grids of the Sudoku.
	static void printGrid(int grid[][]) {
		// add your code here
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
