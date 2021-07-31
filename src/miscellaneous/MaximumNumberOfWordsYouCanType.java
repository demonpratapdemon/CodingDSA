/**
 * 
 */
package miscellaneous;

import java.util.HashSet;

/**
 * @author PRATAP LeetCode 1935
 *
 */
public class MaximumNumberOfWordsYouCanType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "leet code", brokenLetters = "e";
		MaximumNumberOfWordsYouCanType obj = new MaximumNumberOfWordsYouCanType();
		int ans = obj.canBeTypedWords(text, brokenLetters);
		System.out.println(ans);
	}

	public int canBeTypedWords(String text, String brokenLetters) {
		int count = 0;
		HashSet<Character> set = new HashSet<Character>();
		String[] buff = text.split("\\s+");
		for (char ch : brokenLetters.toCharArray())
			set.add(ch);
		boolean flag = false;
		for (int i = 0; i < buff.length; i++) {
			flag = false;
			for (char ch : buff[i].toCharArray()) {
				if (set.contains(ch)) {
					flag = true;
					break;
				}
			}
			if (!flag)
				count++;
		}
		return count;
	}

}
