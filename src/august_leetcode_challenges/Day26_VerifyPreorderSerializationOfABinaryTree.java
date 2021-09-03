/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP LeetCode 331
 *
 */
public class Day26_VerifyPreorderSerializationOfABinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String preorder = "9,#,#,1";
		Day26_VerifyPreorderSerializationOfABinaryTree obj = new Day26_VerifyPreorderSerializationOfABinaryTree();
		boolean ans = obj.isValidSerialization(preorder);
		System.out.println(ans);
	}

	public int vacancy = 0;
	public int i = 0;

	public boolean isValidSerialization(String preorder) {
		if (preorder.length() == 0)
			return true;
		vacancy = 1;
		i = 0;
		String[] pre = preorder.split(",");
		checkVacancy(pre);
		return vacancy == 0 ? i >= pre.length : false;
	}

	private void checkVacancy(String[] pre) {
		// TODO Auto-generated method stub
		if (i >= pre.length)
			return;
		if (pre[i].equalsIgnoreCase("#")) {
			vacancy--;
			i++;
		} else {
			vacancy--;
			vacancy += 2;
			i++;
			checkVacancy(pre);
			checkVacancy(pre);
		}
	}
}
