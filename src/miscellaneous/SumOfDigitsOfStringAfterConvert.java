/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP LeetCode 1945
 *
 */
public class SumOfDigitsOfStringAfterConvert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		int k = 2;
		SumOfDigitsOfStringAfterConvert obj = new SumOfDigitsOfStringAfterConvert();
		int ans = obj.getLucky(s, k);
		System.out.println(ans);
	}

	public int getLucky(String s, int k) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			sb.append((int) (ch - 'a' + 1));
		}
		int sum = 0;
		while (k-- > 0) {
			sum = 0;
			for (int i = 0; i < sb.length(); i++) {
				sum += Integer.parseInt(String.valueOf(sb.charAt(i)));
			}
			sb = new StringBuilder();
			sb.append(sum);
		}
		return sum;
	}
}
