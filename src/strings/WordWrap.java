/**
 * 
 */
package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 68
 *
 */
public class WordWrap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
//		String[] words = { "Tushar", "Roy", "likes", "to", "code" };
		int maxWidth = 16;
		List<String> ans = fullJustify(words, maxWidth);
		System.out.println(ans);
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<String>();
		int i = 0, n = words.length;
		while (i < n) {
			int j = i + 1;
			int lineLength = words[i].length();
			while (j < n && (lineLength + words[j].length() + (j - i - 1) < maxWidth)) {
				lineLength += words[j].length();
				j++;
			}
			int diff = maxWidth - lineLength;
			int wc = j - i;
			// Left Justified condition
			if (wc == 1 || j >= n) {
				list.add(leftJustify(words, i, j, diff, wc, maxWidth));
			} else {
				// Middle Justify
				list.add(middleJustify(words, i, j, diff));
			}
			i = j;
		}
		return list;
	}

	private static String middleJustify(String[] words, int i, int j, int diff) {
		// TODO Auto-generated method stub
		int spacesNeeded = j - i - 1;
		int spaces = diff / spacesNeeded;
		int extraSpace = diff % spacesNeeded;
		StringBuilder sb = new StringBuilder(words[i]);
		for (int k = i + 1; k < j; k++) {
			int spacesToApply = spaces + (extraSpace > 0 ? 1 : 0);
			extraSpace--;
			sb.append(repeat(spacesToApply));
			sb.append(words[k]);
		}
		return sb.toString();
	}

	private static String leftJustify(String[] words, int i, int j, int diff, int wc, int maxWidth) {
		// TODO Auto-generated method stub
		int spacesOnRight = diff - (j - i - 1);
		StringBuilder sb = new StringBuilder(words[i]);
		for (int k = i + 1; k < j - 1; k++) {
			sb.append(" ").append(words[k]);
		}
		sb.append(repeat(spacesOnRight));
		return sb.toString();
	}

	private static String repeat(int spacesOnRight) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < spacesOnRight; i++)
			sb.append(" ");
		return sb.toString();
	}
}
