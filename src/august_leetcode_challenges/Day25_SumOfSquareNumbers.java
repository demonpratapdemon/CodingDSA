/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP LeetCode 633
 *
 */
public class Day25_SumOfSquareNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = 1000000;
		Day25_SumOfSquareNumbers obj = new Day25_SumOfSquareNumbers();
		boolean ans = obj.judgeSquareSum(c);
		System.out.println(ans);
	}
	public boolean judgeSquareSum(int c) {
        Double i = Double.parseDouble(String.valueOf(0));
        Double k = Math.sqrt(c);
        Double j = Double.parseDouble(String.valueOf(k.intValue()));
        while (i <= j) {
            Double sum = Math.pow(i, 2) + Math.pow(j, 2);
            if (sum.intValue() == c)
                return true;
            if (sum.intValue() > c)
                j--;
            else 
                i++;
        }
        return false;
    }
}
