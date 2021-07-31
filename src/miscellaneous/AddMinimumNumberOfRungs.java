/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1936
 *
 */
public class AddMinimumNumberOfRungs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int rungs[] = { 1, 3, 5, 10 }, dist = 2;
//		int rungs[] = { 3, 6, 8, 10 }, dist = 3;
		int rungs[] = { 3 }, dist = 1;
		AddMinimumNumberOfRungs obj = new AddMinimumNumberOfRungs();
		int ans = obj.addRungs(rungs, dist);
		System.out.println(ans);
	}

	public int addRungs(int[] rungs, int dist) {
		int added = 0;
		int curr = 0;
		for (int i = 0; i < rungs.length; i++) {
			if ((rungs[i] - curr) % dist == 0) {
				added += (rungs[i] - curr) / dist - 1;
			} else {
				added += (rungs[i] - curr) / dist;
			}
			curr = rungs[i];
		}
		return added;
	}
}
