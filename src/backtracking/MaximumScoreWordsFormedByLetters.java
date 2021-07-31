/**
 * 
 */
package backtracking;

/**
 * @author PRATAP LeetCode 1255
 *
 */
public class MaximumScoreWordsFormedByLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "dog", "cat", "dad", "good" };
		char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
		int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int maxScore = maxScoreWords(words, letters, score);
		System.out.println(maxScore);
	}

	public static int maxScoreWords(String[] words, char[] letters, int[] score) {
		int[] freq = new int[26];
		for (int i = 0; i < letters.length; i++) {
			freq[letters[i] - 'a']++;
		}
		int ans = solve(words, freq, score, 0);
		return ans;
	}

	private static int solve(String[] words, int[] freq, int[] score, int idx) {
		// TODO Auto-generated method stub
		if (idx == words.length)
			return 0;
		int sno = solve(words, freq, score, idx + 1);
		int sscore = 0;
		String word = words[idx];
		boolean flag = true;
		for (int i = 0; i < word.length(); i++) {
			if (freq[word.charAt(i) - 'a'] == 0) {
				flag = false;
			}
			freq[word.charAt(i) - 'a']--;
			sscore += score[word.charAt(i) - 'a'];
		}
		int syes = 0;
		if (flag)
			syes = sscore + solve(words, freq, score, idx + 1);
		for (int i = 0; i < word.length(); i++) {
			freq[word.charAt(i) - 'a']++;
		}
		return Math.max(sno, syes);
	}

}
