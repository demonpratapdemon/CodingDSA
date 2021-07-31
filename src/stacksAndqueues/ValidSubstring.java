/**
 * 
 */
package stacksAndqueues;

import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class ValidSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "((())(";
		int maxLength = findMaxLen(S);
		System.out.println(maxLength);
	}

	static int findMaxLen(String S) {
        // code here
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < S.length(); i++) {
            String val = String.valueOf(S.charAt(i));
            if(val.equals(")") && !stack.isEmpty()) {
                stack.pop();
                if(!stack.isEmpty())
                    count =  i - stack.peek();
                if(stack.isEmpty())
                    stack.push(i);
            } else {
                stack.push(i);
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
