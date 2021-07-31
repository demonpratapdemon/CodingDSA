/**
 * 
 */
package greedy;

/**
 * @author PRATAP LeetCode 134
 *
 */
public class GasStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };
//		int[] gas = { 2, 3, 4, }, cost = { 3, 4, 3 };
		int[] gas = { 5, 8, 2, 8 }, cost = { 6, 5, 6, 6 };
//		int[] gas = { 4, 6, 7, 4 }, cost = { 6, 5, 3, 5 };
		int index = canCompleteCircuit(gas, cost);
		System.out.println(index);
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int deficit = 0, start = 0, cal = 0;
		for (int i = 0; i < gas.length; i++) {
			cal += gas[i] - cost[i];
			if (cal < 0) {
				start = i + 1;
				deficit += cal;
				cal = 0;
			}
		}
		return (cal + deficit) >= 0 ? start : -1;
	}
}